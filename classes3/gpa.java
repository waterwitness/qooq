import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.smallscreen.SmallScreenVideoController;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gpa
  implements Runnable
{
  gpa(SmallScreenVideoController paramSmallScreenVideoController)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController != null))
    {
      if (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().f) {
        break label121;
      }
      this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.c();
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(0, 0, true);
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(this.a.jdField_a_of_type_ComTencentAvVideoController.a().f, false);
      if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().f) {
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.d(this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.a());
      }
      return;
      label121:
      this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(true);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gpa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */