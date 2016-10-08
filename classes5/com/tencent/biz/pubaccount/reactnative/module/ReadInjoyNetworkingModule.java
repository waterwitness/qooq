package com.tencent.biz.pubaccount.reactnative.module;

import android.os.Build.VERSION;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import hwe;
import mqq.manager.TicketManager;

public class ReadInjoyNetworkingModule
  extends ReactBaseModule
{
  public static final String BUNDLE = "BUNDLE";
  public static final String CONTEXT = "CONTEXT";
  public static final String COOKIE = "Cookie";
  private static final int DEFAULTRREQUESTCODE = 1;
  public static final String DOMAIN_KANDIAN_QQ_COM = "kandian.qq.com";
  private static final int FAILCODE = 1;
  public static final String HOST = "Host";
  public static final String ORIGIN = "Origin";
  public static final String REFERER = "Referer";
  private static final int SUCCCODE = 0;
  private static final String TAG = "ReadInjoyNetworkingModule";
  private static final String UA = "QQ/6.5.5 ReactNativeAndroid/0.17 Android/" + Build.VERSION.RELEASE;
  private QQAppInterface mApp = (QQAppInterface)BaseApplicationImpl.a().a();
  private boolean mShuttingDown;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ReadInjoyNetworkingModule(ReactApplicationContext paramReactApplicationContext)
  {
    super(paramReactApplicationContext);
  }
  
  private void doSendRequestWithExtraHeaderAsync(String paramString, Callback paramCallback)
  {
    ThreadManager.a(new hwe(this, paramCallback, paramString), 5, null, true);
  }
  
  private String getCSRFToken()
  {
    Object localObject = (TicketManager)this.mApp.getManager(2);
    if (localObject == null) {
      return "";
    }
    localObject = ((TicketManager)localObject).getSkey(this.mApp.a());
    long l = 5381L;
    int i = 0;
    while (i < ((String)localObject).length())
    {
      l += (l << 5 & 0x7FFFFFFF) + ((String)localObject).charAt(i);
      i += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.w("ReadInjoyNetworkingModule", 2, "getCSRFToken " + (l & 0x7FFFFFFF));
    }
    return String.valueOf(l & 0x7FFFFFFF);
  }
  
  public String getName()
  {
    return "NetworkingModule";
  }
  
  @ReactMethod
  public void httpFetchAsync(String paramString1, String paramString2, Callback paramCallback)
  {
    if (paramString2.indexOf("?") != -1) {}
    for (paramString2 = paramString2 + "&g_tk=" + getCSRFToken();; paramString2 = paramString2 + "?g_tk=" + getCSRFToken())
    {
      if ("get".equals(paramString1)) {
        doSendRequestWithExtraHeaderAsync(paramString2, paramCallback);
      }
      return;
    }
  }
  
  public void onCatalystInstanceDestroy()
  {
    this.mShuttingDown = true;
    if (this.mApp != null) {
      this.mApp = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\reactnative\module\ReadInjoyNetworkingModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */