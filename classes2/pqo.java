import android.opengl.GLSurfaceView.EGLContextFactory;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

public class pqo
  implements GLSurfaceView.EGLContextFactory
{
  private static final int jdField_a_of_type_Int = 12440;
  
  private pqo(ApolloSurfaceView paramApolloSurfaceView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public EGLContext createContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloSurfaceView", 2, "[createContext], id:" + Thread.currentThread().getId());
    }
    return paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
  }
  
  public void destroyContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloSurfaceView", 2, "[destroyContext], id:" + Thread.currentThread().getId());
    }
    if (this.a.a != null) {
      this.a.a.a();
    }
    paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\pqo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */