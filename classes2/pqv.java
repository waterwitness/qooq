import android.util.Log;
import com.tencent.mobileqq.apollo.GLTextureView.EGLWindowSurfaceFactory;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class pqv
  implements GLTextureView.EGLWindowSurfaceFactory
{
  private pqv()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public EGLSurface a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, Object paramObject)
  {
    try
    {
      paramEGL10 = paramEGL10.eglCreateWindowSurface(paramEGLDisplay, paramEGLConfig, paramObject, null);
      return paramEGL10;
    }
    catch (IllegalArgumentException paramEGL10)
    {
      Log.e("GLTextureView", "eglCreateWindowSurface", paramEGL10);
    }
    return null;
  }
  
  public void a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLSurface paramEGLSurface)
  {
    paramEGL10.eglDestroySurface(paramEGLDisplay, paramEGLSurface);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\pqv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */