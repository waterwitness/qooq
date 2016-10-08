package com.tencent.mobileqq.webprocess;

import android.content.Context;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.log.VipWebViewReportLog;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import wgs;
import wgt;

public class PreloadService$PreloadImpl
{
  public PreloadService$PreloadImpl()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private void a()
  {
    long l1 = System.currentTimeMillis();
    AuthorizeConfig localAuthorizeConfig = AuthorizeConfig.a(false);
    localAuthorizeConfig.a("http://www.qq.com/", "foo.bar");
    localAuthorizeConfig.a("skey");
    localAuthorizeConfig.a("pskey");
    localAuthorizeConfig.a("pt4_token");
    localAuthorizeConfig.a("a1");
    localAuthorizeConfig.a("a2");
    localAuthorizeConfig.b("http://www.qq.com/");
    localAuthorizeConfig.a();
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.i("QQBrowser", 2, "Pre_Load_async_load_config, cost=" + (l2 - l1));
    }
  }
  
  private void a(Context paramContext, AppRuntime paramAppRuntime)
  {
    QLog.d("WebCoreDump", 2, "preload http record config!");
    if (!VipWebViewReportLog.a()) {
      VipWebViewReportLog.a(paramContext, paramAppRuntime);
    }
  }
  
  protected List a()
  {
    return null;
  }
  
  public void a(Context paramContext, long paramLong)
  {
    ThreadManager.a(new wgt(this, paramContext, paramLong), 5, null, true);
  }
  
  public void a(AppInterface paramAppInterface, Context paramContext, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreloadService", 2, "asyncPreload app = " + paramAppInterface);
    }
    if (paramAppInterface == null) {
      return;
    }
    ThreadManager.a(new wgs(this, paramAppInterface, paramLong, paramContext), null, true);
  }
  
  public void a(AppRuntime paramAppRuntime, long paramLong)
  {
    if (paramAppRuntime == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PreloadService", 2, "doPreload, app is null!");
      }
      return;
    }
    String str = paramAppRuntime.getApplication().getProcessName();
    if (QLog.isColorLevel()) {
      QLog.d("PreloadService", 2, "do preload,app:" + str + ",preload opt:" + paramLong);
    }
    long l1;
    if ((1L & paramLong) == 1L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PreloadService", 2, "preload webview engine");
      }
      l1 = System.currentTimeMillis();
      if (!PreloadService.a(paramAppRuntime)) {
        break label326;
      }
      PreloadService.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine = WebAccelerateHelper.getInstance().createWebViewPluginEngine((AppInterface)paramAppRuntime, null, null, a());
    }
    for (;;)
    {
      synchronized (PreloadService.jdField_a_of_type_JavaLangObject)
      {
        PreloadService.jdField_a_of_type_JavaLangObject.notifyAll();
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.i("QQBrowser", 2, "Pre_Load_async_create_webview_engine, cost=" + (l2 - l1));
        }
        if (((0x2 & paramLong) != 2L) || (!WebAccelerateHelper.getInstance().isPreGetKey())) {
          break label377;
        }
        if (QLog.isColorLevel()) {
          QLog.d("PreloadService", 2, "-->app:" + str + " preload key info!");
        }
        l1 = System.currentTimeMillis();
        WebAccelerateHelper.getInstance().preGetKeyInPreloadService(paramAppRuntime);
        l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.i("QQBrowser", 2, "Pre_Load_async_get_cookie_info, cost=" + (l2 - l1));
        }
        if ((0x10 & paramLong) != 16L) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("PreloadService", 2, "preload PRELOAD_INDIVIDUATION_URLS");
        }
        IndividuationUrlHelper.a(paramAppRuntime);
        return;
      }
      label326:
      if (PreloadService.b(paramAppRuntime))
      {
        PreloadService.b = WebAccelerateHelper.getInstance().createWebViewPluginEngine((AppInterface)paramAppRuntime, null, null, a());
      }
      else
      {
        com.tencent.mobileqq.webview.swift.WebViewPluginEngine.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine = WebAccelerateHelper.getInstance().createWebViewPluginEngine((AppInterface)paramAppRuntime, null, null, a());
        continue;
        label377:
        if (QLog.isColorLevel()) {
          QLog.d("PreloadService", 2, "no need preload key");
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\webprocess\PreloadService$PreloadImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */