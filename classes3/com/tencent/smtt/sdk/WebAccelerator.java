package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.export.external.DexLoader;
import java.util.Map;

public class WebAccelerator
{
  public static final int INIT_TYPE_TBS = 1;
  public static final int INIT_TYPE_X5CORE = 2;
  
  public static void createCacheWebView(Context paramContext, boolean paramBoolean)
  {
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    if (paramBoolean) {
      localX5CoreEngine.init(paramContext);
    }
    if (localX5CoreEngine.isX5Core()) {
      localX5CoreEngine.wizard().dexLoader().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createCacheWebView", new Class[] { Context.class }, new Object[] { paramContext });
    }
  }
  
  public static void initTbsEnvironment(Context paramContext, int paramInt)
  {
    if (paramContext != null)
    {
      if (paramInt != 1) {
        break label20;
      }
      SDKEngine.getInstance(true).init(paramContext, false, false);
    }
    label20:
    while (paramInt != 2) {
      return;
    }
    X5CoreEngine.getInstance().init(paramContext);
  }
  
  public static void preConnect(Context paramContext, String paramString, int paramInt, boolean paramBoolean)
  {
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    if (paramBoolean) {
      localX5CoreEngine.init(paramContext);
    }
    if (localX5CoreEngine.isX5Core()) {
      localX5CoreEngine.wizard().dexLoader().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "preConnect", new Class[] { Context.class, String.class, Integer.TYPE }, new Object[] { paramContext, paramString, Integer.valueOf(paramInt) });
    }
  }
  
  public static void prefetchResource(Context paramContext, String paramString, Map<String, String> paramMap, boolean paramBoolean)
  {
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    if (paramBoolean) {
      localX5CoreEngine.init(paramContext);
    }
    if (localX5CoreEngine.isX5Core()) {
      localX5CoreEngine.wizard().dexLoader().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "prefetchResource", new Class[] { Context.class, String.class, Map.class }, new Object[] { paramContext, paramString, paramMap });
    }
  }
  
  public static void setWebViewPoolSize(Context paramContext, int paramInt, boolean paramBoolean)
  {
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    if (paramBoolean) {
      localX5CoreEngine.init(paramContext);
    }
    if (localX5CoreEngine.isX5Core()) {
      localX5CoreEngine.wizard().dexLoader().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "setWebViewPoolSize", new Class[] { Context.class, Integer.TYPE }, new Object[] { paramContext, Integer.valueOf(paramInt) });
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\smtt\sdk\WebAccelerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */