import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hitrate.PreloadProcHitPluginSession;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneHelper;

public final class ykr
  implements Runnable
{
  public ykr(QQAppInterface paramQQAppInterface, PreloadProcHitPluginSession paramPreloadProcHitPluginSession)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i = QzoneConfig.a().a("QZoneSetting", "PreloadQzoneProcessEnable", 1);
    if (QLog.isColorLevel()) {
      QLog.d(QZoneHelper.a, 2, "preloadInFriendProfileCard enable:" + i);
    }
    if (i == 1)
    {
      long l = DeviceInfoUtil.c() / 1048576L;
      i = QzoneConfig.a().a("QZoneSetting", "PreloadQzoneProcessRamThreshold", 1024);
      if (QLog.isColorLevel()) {
        QLog.d(QZoneHelper.a, 2, "preloadInFriendProfileCard totalMemSize:" + l + ",threshold:" + i);
      }
      if (l >= i) {
        QZoneHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "FriendProfileCardActivity", this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitPluginSession);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ykr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */