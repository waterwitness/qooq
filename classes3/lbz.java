import android.opengl.GLSurfaceView.Renderer;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class lbz
  implements GLSurfaceView.Renderer
{
  public lbz(Conversation paramConversation)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDrawFrame(GL10 paramGL10) {}
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2) {}
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    Conversation.a(this.a, paramGL10.glGetString(7937));
    if (Conversation.a(this.a) != null) {
      ThreadManager.a(new lca(this), 5, null, true);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_GPU", 2, "onSurfaceCreated|GL_RENDERER= " + Conversation.a(this.a));
    }
    this.a.b(new lcb(this));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lbz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */