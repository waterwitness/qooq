package com.tencent.common.app;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.intervideo.now.runtime.NowRunTime;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.olympic.OlympicToolAppInterface;
import com.tencent.mobileqq.startup.step.InitSkin;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.VipComicHelper;
import cooperation.qqindividuality.QQIndividualityRuntimeHelper;
import cooperation.qqpim.QQPimPluginRuntimeHelper;
import cooperation.qqreader.QReaderHelper;
import cooperation.qwallet.plugin.QWalletHelper;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class ToolAppRuntime
  extends ToolRuntimeBase
{
  public static final String a = ToolAppRuntime.class.getSimpleName();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public String getModuleId()
  {
    return "tool";
  }
  
  public AppRuntime onGetSubRuntime(String paramString)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.i(a, 2, "ToolAppRuntime.onGetSubRuntime() moduleId " + paramString);
    }
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.a();
    if ("module_nearby".equals(paramString)) {
      paramString = new NearbyAppInterface(localBaseApplicationImpl, MobileQQ.processName);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i(a, 2, "moduleId needInitSkin =" + bool);
      }
      if ((!InitSkin.c) && (bool)) {
        InitSkin.a();
      }
      return paramString;
      if ("comic_plugin.apk".equals(paramString))
      {
        paramString = VipComicHelper.a(localBaseApplicationImpl, MobileQQ.processName);
        bool = false;
      }
      else if ("qqreaderplugin.apk".equals(paramString))
      {
        paramString = QReaderHelper.a(localBaseApplicationImpl, MobileQQ.processName);
        bool = false;
      }
      else if ("qqpim_plugin.apk".equals(paramString))
      {
        paramString = QQPimPluginRuntimeHelper.a(localBaseApplicationImpl, MobileQQ.processName);
      }
      else if ("module_olympic".equals(paramString))
      {
        paramString = new OlympicToolAppInterface(localBaseApplicationImpl, MobileQQ.processName);
        bool = false;
      }
      else if ("qwallet_plugin.apk".equals(paramString))
      {
        paramString = QWalletHelper.a(localBaseApplicationImpl, MobileQQ.processName);
      }
      else if ("qqindividuality_plugin.apk".equals(paramString))
      {
        paramString = QQIndividualityRuntimeHelper.a(localBaseApplicationImpl, MobileQQ.processName);
        bool = false;
      }
      else if ("Now".equals(paramString))
      {
        paramString = new NowRunTime(localBaseApplicationImpl, MobileQQ.processName);
        bool = false;
      }
      else
      {
        bool = false;
        paramString = null;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\common\app\ToolAppRuntime.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */