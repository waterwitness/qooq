package com.tencent.mobileqq.profile.upload.task;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.profile.upload.config.VipUploadConfigImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.upload.uinterface.IUploadService;
import com.tencent.upload.uinterface.IUploadService.UploadServiceCreator;
import cooperation.qzone.UploadEnv;
import mqq.manager.Manager;
import tvt;

public class VipImageUploadManager
  implements Manager
{
  public VipImageUploadManager(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private void a(QQAppInterface paramQQAppInterface, VipUploadConfigImpl paramVipUploadConfigImpl)
  {
    if (paramVipUploadConfigImpl != null)
    {
      IUploadService.UploadServiceCreator.getInstance().init(paramQQAppInterface.a().getApplicationContext(), paramVipUploadConfigImpl, null, null, new UploadEnv());
      return;
    }
    IUploadService.UploadServiceCreator.getInstance().init(paramQQAppInterface.a().getApplicationContext(), new tvt(this, Long.parseLong(paramQQAppInterface.a())), null, null, new UploadEnv());
  }
  
  public void a(QQAppInterface paramQQAppInterface, VipBaseUploadTask paramVipBaseUploadTask, VipUploadConfigImpl paramVipUploadConfigImpl)
  {
    if (!IUploadService.UploadServiceCreator.getInstance().isInitialized()) {
      a(paramQQAppInterface, paramVipUploadConfigImpl);
    }
    paramVipBaseUploadTask.a();
  }
  
  public void onDestroy() {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\profile\upload\task\VipImageUploadManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */