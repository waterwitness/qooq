import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.camera.CameraObserver;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.EffectSettingUi;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class gpb
  extends CameraObserver
{
  public gpb(AVActivity paramAVActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVActivity", 2, "onBeforeOpenCamera");
    }
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(2131299023, false);
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
    {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.f(paramBoolean);
      if ((this.a.jdField_a_of_type_ComTencentAvVideoController != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().i) && (!this.a.jdField_a_of_type_ComTencentAvVideoController.b())) {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(2131299023, this.a.jdField_a_of_type_ComTencentAvVideoController.a().g);
      }
      if ((this.a.jdField_a_of_type_ComTencentAvVideoController != null) && (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().Z) && ((!this.a.jdField_a_of_type_ComTencentAvVideoController.a().W) || (this.a.jdField_a_of_type_ComTencentAvVideoController.a().aa)) && ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().f != 1) || (this.a.jdField_a_of_type_ComTencentAvVideoController.c()))) {}
    }
    else
    {
      return;
    }
    this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(2131299023, true);
  }
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVActivity", 2, "onAfterOpenCamera success: " + paramBoolean + ", preSessionType: " + paramInt);
    }
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
    {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(2131299023, true);
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.c(this.a.p);
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramBoolean, paramInt);
    }
    String str;
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
    {
      if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().D != 2)
      {
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(this.a.p, false);
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.d(this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.a());
      }
    }
    else
    {
      if ((this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().D != 2)) {
        this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(this.a.p);
      }
      if ((paramBoolean) && (this.a.jdField_a_of_type_ComTencentAvUiEffectSettingUi != null)) {
        this.a.jdField_a_of_type_ComTencentAvUiEffectSettingUi.c();
      }
      if (!paramBoolean) {
        if ((this.a.jdField_a_of_type_ComTencentAvVideoController != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a() != null))
        {
          str = "";
          if (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().j()) {
            break label356;
          }
          str = "0X8004894";
        }
      }
    }
    for (;;)
    {
      ReportController.b(null, "CliOper", "", "", str, str, 0, 0, "", "", "", "");
      if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
        this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(38), Integer.valueOf(2) });
      }
      return;
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(this.a.p);
      break;
      label356:
      if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().h == 1) {
        str = "0X8004888";
      } else if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().h == 2) {
        str = "0X800488E";
      }
    }
  }
  
  protected void b()
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(2131299023, false);
    }
    if (this.a.jdField_a_of_type_ComTencentAvUiEffectSettingUi != null) {
      this.a.jdField_a_of_type_ComTencentAvUiEffectSettingUi.d();
    }
  }
  
  protected void b(boolean paramBoolean)
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(2131299087, true);
    }
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.e(this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.a());
    }
  }
  
  protected void c()
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(2131299087, false);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gpb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */