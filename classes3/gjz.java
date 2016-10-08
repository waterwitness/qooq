import com.tencent.av.opengl.effects.AbstractEffects;
import com.tencent.av.opengl.effects.EffectsRenderController;
import com.tencent.av.opengl.ui.GLRootView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class gjz
  implements Runnable
{
  public gjz(GLRootView paramGLRootView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(EffectsRenderController.a, 2, "updatePreviewSize onPause() unfreeze()");
    }
    this.a.a.c();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gjz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */