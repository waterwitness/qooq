package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.LebaHelper;
import com.tencent.mobileqq.app.PluginConfigProxy;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.config.AboutConfig;
import com.tencent.mobileqq.config.ResourcePluginListener;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import cooperation.plugin.IPluginManager;
import java.util.HashMap;
import protocol.KQQConfig.GetResourceReqInfo;
import qjh;

public class GetConfig
  extends AsyncStep
{
  private ResourcePluginListener a;
  
  public GetConfig()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected int a()
  {
    Object localObject = new PluginConfigProxy();
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.a().a((PluginConfigProxy)localObject);
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.a().a((PluginConfigProxy)localObject);
    ((PluginConfigProxy)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b);
    ((IPluginManager)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.getManager(26)).a();
    ((EarlyDownloadManager)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.getManager(76)).b();
    localObject = (ConfigHandler)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.a(4);
    ((ConfigHandler)localObject).a(null, new GetResourceReqInfo[] { ((ConfigHandler)localObject).e(), ((ConfigHandler)localObject).g(), ((ConfigHandler)localObject).b(), ((ConfigHandler)localObject).f(), ((ConfigHandler)localObject).c() });
    if (NetworkUtil.b(BaseApplication.getContext()) == 1)
    {
      TVK_SDKMgr.initSdk(BaseApplication.getContext(), "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
      if (!TVK_SDKMgr.isInstalled(BaseApplication.getContext()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQInitHandler", 2, "init TVK_SDKMgr SDK");
        }
        localObject = new HashMap();
        ((HashMap)localObject).put(BaseConstants.RDM_NoChangeFailCode, "");
        StatisticCollector.a(BaseApplication.getContext()).a(null, "actSDKPredownload", true, 0L, 0L, (HashMap)localObject, "");
      }
    }
    return 2;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener = new qjh(this, null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.a(this.jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.b(this.jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener);
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener = null;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\automator\step\GetConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */