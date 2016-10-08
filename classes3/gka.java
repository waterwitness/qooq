import com.tencent.av.opengl.effects.AbstractEffects;
import com.tencent.av.opengl.effects.EffectsRenderController;
import com.tencent.av.opengl.ui.GLRootView;
import com.tencent.av.opengl.ui.GLRootView.OnEvent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class gka
  implements GLRootView.OnEvent
{
  public gka(GLRootView paramGLRootView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(EffectsRenderController.a, 2, "updatePreviewSize onResume() initial()");
    }
    this.a.a.a();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gka.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */