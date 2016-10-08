import android.content.Context;
import android.view.Display;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.smallscreen.SmallScreenVideoControlUI;
import com.tencent.av.smallscreen.SmallScreenVideoController;
import com.tencent.av.ui.AbstractOrientationEventListener;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class goz
  extends AbstractOrientationEventListener
{
  public goz(SmallScreenVideoController paramSmallScreenVideoController, Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    int i = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController.jdField_a_of_type_AndroidViewDisplay.getRotation();
    if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.b((i * 90 + paramInt) % 360);
    }
    if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramInt, paramBoolean);
    }
    if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController.jdField_a_of_type_ComTencentAvCameraCameraUtils != null) {
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(paramInt);
    }
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController.l = paramInt;
  }
  
  public void a(boolean paramBoolean)
  {
    CameraUtils.a(this.jdField_a_of_type_AndroidContentContext).b(paramBoolean);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\goz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */