import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.GLTextureView.EGLContextFactory;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

public class pqq
  implements GLTextureView.EGLContextFactory
{
  private static final int jdField_a_of_type_Int = 12440;
  
  private pqq(ApolloTextureView paramApolloTextureView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public EGLContext a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloTextureView", 2, "[createContext], id:" + Thread.currentThread().getId());
    }
    return paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
  }
  
  public void a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloTextureView", 2, "[destroyContext], id:" + Thread.currentThread().getId());
    }
    if (ApolloTextureView.a(this.a) != null) {
      ApolloTextureView.a(this.a).a();
    }
    paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\pqq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */