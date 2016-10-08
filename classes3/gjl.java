import com.tencent.av.camera.CameraObserver;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.opengl.effects.EffectsRenderController;
import com.tencent.av.opengl.effects.FilterProcessRender;
import com.tencent.av.opengl.ui.GLRootView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gjl
  extends CameraObserver
{
  public gjl(EffectsRenderController paramEffectsRenderController)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean)
  {
    if (this.a.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender != null) {
      this.a.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender.d();
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    if ((!paramBoolean) || (!GraphicRenderMgr.soloadedPTV)) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentAvOpenglUiGLRootView.setOnEvent(new gjm(this));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gjl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */