import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.camera.CameraObserver;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.smallscreen.SmallScreenVideoController;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class gov
  extends CameraObserver
{
  public gov(SmallScreenVideoController paramSmallScreenVideoController)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "onBeforeOpenCamera");
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    if ((this.a.jdField_a_of_type_ComTencentAvVideoController != null) && ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().l == 1011) || (this.a.jdField_a_of_type_ComTencentAvVideoController.f)))
    {
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(false, false);
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.n();
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "onAfterOpenCamera success: " + paramBoolean + ", preSessionType: " + paramInt);
    }
    if (paramBoolean)
    {
      if ((this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (SmallScreenUtils.e(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a())) && ((paramInt == 1) || (paramInt == 3)) && (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null))
      {
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(true, false);
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.d(this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.a());
      }
      return;
    }
    String str;
    if ((this.a.jdField_a_of_type_ComTencentAvVideoController != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a() != null))
    {
      str = "";
      if (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().j()) {
        break label231;
      }
      str = "0X8004894";
    }
    for (;;)
    {
      ReportController.b(null, "CliOper", "", "", str, str, 0, 0, "", "", "", "");
      if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
        break;
      }
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(38), Integer.valueOf(2) });
      return;
      label231:
      if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().h == 1) {
        str = "0X8004888";
      } else if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().h == 2) {
        str = "0X800488E";
      }
    }
  }
  
  protected void b() {}
  
  protected void b(boolean paramBoolean) {}
  
  protected void c() {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gov.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */