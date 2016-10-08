import android.opengl.GLSurfaceView.EGLContextFactory;
import android.util.Log;
import com.tencent.mobileqq.ar.ARGLSurfaceView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

public class qot
  implements GLSurfaceView.EGLContextFactory
{
  private int jdField_a_of_type_Int;
  
  public qot(ARGLSurfaceView paramARGLSurfaceView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 12440;
  }
  
  public EGLContext createContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
  {
    int i = this.jdField_a_of_type_Int;
    return paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, EGL10.EGL_NO_CONTEXT, new int[] { i, 2, 12344 });
  }
  
  public void destroyContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
  {
    if (!paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext)) {
      Log.e("DefaultContextFactory", "display:" + paramEGLDisplay + " context: " + paramEGLContext + " tid=" + Thread.currentThread().getId());
    }
    this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView.a();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\qot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */