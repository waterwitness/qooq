package com.facebook.react.modules.network;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.ValueCallback;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.GuardedResultAsyncTask;
import com.facebook.react.bridge.ReactContext;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.CookieHandler;
import java.net.URI;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

public class ForwardingCookieHandler
  extends CookieHandler
{
  private static final String COOKIE_HEADER = "Cookie";
  private static final boolean USES_LEGACY_STORE;
  private static final String VERSION_ONE_HEADER = "Set-cookie2";
  private static final String VERSION_ZERO_HEADER = "Set-cookie";
  private final ReactContext mContext;
  @Nullable
  private CookieManager mCookieManager;
  private final CookieSaver mCookieSaver;
  
  static
  {
    if (Build.VERSION.SDK_INT < 21) {}
    for (boolean bool = true;; bool = false)
    {
      USES_LEGACY_STORE = bool;
      return;
    }
  }
  
  public ForwardingCookieHandler(ReactContext paramReactContext)
  {
    this.mContext = paramReactContext;
    this.mCookieSaver = new CookieSaver();
  }
  
  @TargetApi(21)
  private void addCookieAsync(String paramString1, String paramString2)
  {
    getCookieManager().setCookie(paramString1, paramString2);
  }
  
  private void addCookies(final String paramString, final List<String> paramList)
  {
    if (USES_LEGACY_STORE)
    {
      runInBackground(new Runnable()
      {
        public void run()
        {
          Iterator localIterator = paramList.iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            ForwardingCookieHandler.this.getCookieManager().setCookie(paramString, str);
          }
          ForwardingCookieHandler.this.mCookieSaver.onCookiesModified();
        }
      });
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      addCookieAsync(paramString, (String)paramList.next());
    }
    this.mCookieSaver.onCookiesModified();
  }
  
  private void clearCookiesAsync(final Callback paramCallback)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      paramCallback = new ValueCallback()
      {
        public void onReceiveValue(Boolean paramAnonymousBoolean)
        {
          ForwardingCookieHandler.this.mCookieSaver.onCookiesModified();
          paramCallback.invoke(new Object[] { paramAnonymousBoolean });
        }
      };
    }
    try
    {
      CookieManager localCookieManager = getCookieManager();
      localCookieManager.getClass().getMethod("removeAllCookies", new Class[] { ValueCallback.class }).invoke(localCookieManager, new Object[] { paramCallback });
      return;
    }
    catch (Exception paramCallback) {}
    getCookieManager().removeAllCookie();
    return;
  }
  
  private CookieManager getCookieManager()
  {
    if (this.mCookieManager == null)
    {
      possiblyWorkaroundSyncManager(this.mContext);
      this.mCookieManager = CookieManager.getInstance();
      if (USES_LEGACY_STORE) {
        this.mCookieManager.removeExpiredCookie();
      }
    }
    return this.mCookieManager;
  }
  
  private static boolean isCookieHeader(String paramString)
  {
    return (paramString.equalsIgnoreCase("Set-cookie")) || (paramString.equalsIgnoreCase("Set-cookie2"));
  }
  
  private static void possiblyWorkaroundSyncManager(Context paramContext)
  {
    if (USES_LEGACY_STORE) {
      CookieSyncManager.createInstance(paramContext).sync();
    }
  }
  
  private void runInBackground(final Runnable paramRunnable)
  {
    new GuardedAsyncTask(this.mContext)
    {
      protected void doInBackgroundGuarded(Void... paramAnonymousVarArgs)
      {
        paramRunnable.run();
      }
    }.execute(new Void[0]);
  }
  
  public void clearCookies(final Callback paramCallback)
  {
    if (USES_LEGACY_STORE)
    {
      new GuardedResultAsyncTask(this.mContext)
      {
        protected Boolean doInBackgroundGuarded()
        {
          ForwardingCookieHandler.this.getCookieManager().removeAllCookie();
          ForwardingCookieHandler.this.mCookieSaver.onCookiesModified();
          return Boolean.valueOf(true);
        }
        
        protected void onPostExecuteGuarded(Boolean paramAnonymousBoolean)
        {
          paramCallback.invoke(new Object[] { paramAnonymousBoolean });
        }
      }.execute(new Void[0]);
      return;
    }
    clearCookiesAsync(paramCallback);
  }
  
  public void destroy()
  {
    if (USES_LEGACY_STORE)
    {
      getCookieManager().removeExpiredCookie();
      this.mCookieSaver.persistCookies();
    }
  }
  
  public Map<String, List<String>> get(URI paramURI, Map<String, List<String>> paramMap)
    throws IOException
  {
    try
    {
      paramURI = getCookieManager().getCookie(paramURI.toString());
      if (TextUtils.isEmpty(paramURI)) {
        return Collections.emptyMap();
      }
      paramURI = Collections.singletonMap("Cookie", Collections.singletonList(paramURI));
      return paramURI;
    }
    catch (Exception paramURI)
    {
      if (FLog.isLoggable(3)) {
        FLog.d("ForwardingCookieHandler", "get cookie error");
      }
      paramURI.printStackTrace();
    }
    return Collections.emptyMap();
  }
  
  public void put(URI paramURI, Map<String, List<String>> paramMap)
    throws IOException
  {
    paramURI = paramURI.toString();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      String str = (String)localEntry.getKey();
      if ((str != null) && (isCookieHeader(str))) {
        addCookies(paramURI, (List)localEntry.getValue());
      }
    }
  }
  
  private class CookieSaver
  {
    private static final int MSG_PERSIST_COOKIES = 1;
    private static final int TIMEOUT = 30000;
    private final Handler mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback()
    {
      public boolean handleMessage(Message paramAnonymousMessage)
      {
        if (paramAnonymousMessage.what == 1)
        {
          ForwardingCookieHandler.CookieSaver.this.persistCookies();
          return true;
        }
        return false;
      }
    });
    
    public CookieSaver() {}
    
    @TargetApi(21)
    private void flush()
    {
      try
      {
        CookieManager localCookieManager = ForwardingCookieHandler.this.getCookieManager();
        localCookieManager.getClass().getMethod("flush", new Class[0]).invoke(localCookieManager, new Object[0]);
        return;
      }
      catch (Exception localException) {}
    }
    
    public void onCookiesModified()
    {
      if (ForwardingCookieHandler.USES_LEGACY_STORE) {
        this.mHandler.sendEmptyMessageDelayed(1, 30000L);
      }
    }
    
    public void persistCookies()
    {
      this.mHandler.removeMessages(1);
      ForwardingCookieHandler.this.runInBackground(new Runnable()
      {
        public void run()
        {
          if (ForwardingCookieHandler.USES_LEGACY_STORE)
          {
            CookieSyncManager.getInstance().sync();
            return;
          }
          ForwardingCookieHandler.CookieSaver.this.flush();
        }
      });
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\modules\network\ForwardingCookieHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */