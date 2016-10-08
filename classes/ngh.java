import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.utils.TraeHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.audiopanel.PressToChangeVoicePanel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.earlydownload.handler.EarlyHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.startup.step.UpdateAvSo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public final class ngh
  implements Runnable
{
  public ngh(boolean paramBoolean, QQAppInterface paramQQAppInterface, String paramString)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      if (PressToChangeVoicePanel.b == null) {
        PressToChangeVoicePanel.b = TraeHelper.a(BaseApplicationImpl.a);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "checkVcSo async:" + PressToChangeVoicePanel.b);
      }
    }
    if ((PressToChangeVoicePanel.b != null) || (VcSystemInfo.f() <= 2)) {}
    for (;;)
    {
      try
      {
        EarlyHandler localEarlyHandler = ((EarlyDownloadManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(76)).a("qq.android.qav.so");
        if (localEarlyHandler == null) {
          continue;
        }
        localEarlyHandler.a(false);
      }
      catch (Exception localException)
      {
        QLog.e("AIOAudioPanel", 1, "voiceChang checkVcSo Exception:" + localException.getMessage());
        continue;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, 0, 0, "", "", "", "");
      return;
      QLog.e("AIOAudioPanel", 1, "voiceChang checkVcSo null == earlyHandler:");
      continue;
      UpdateAvSo.b(BaseApplicationImpl.a, "traeimp-armeabi-v7a", true);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ngh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */