import com.tencent.av.opengl.ui.animation.GLAnimation.AnimationListenerGL;
import com.tencent.av.ui.GLVideoView;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hac
  implements GLAnimation.AnimationListenerGL
{
  public hac(VideoLayerUI paramVideoLayerUI, GLVideoView paramGLVideoView, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentAvUiGLVideoView.i(true);
    this.jdField_a_of_type_ComTencentAvUiGLVideoView.b(this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b(this.jdField_a_of_type_ComTencentAvUiGLVideoView, this.jdField_a_of_type_Boolean);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\hac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */