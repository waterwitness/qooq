import com.tencent.mobileqq.apollo.GLTextureView;
import com.tencent.mobileqq.apollo.GLTextureView.EGLConfigChooser;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

public abstract class pqs
  implements GLTextureView.EGLConfigChooser
{
  protected int[] a;
  
  public pqs(GLTextureView paramGLTextureView, int[] paramArrayOfInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ArrayOfInt = a(paramArrayOfInt);
  }
  
  private int[] a(int[] paramArrayOfInt)
  {
    if ((GLTextureView.a(this.jdField_a_of_type_ComTencentMobileqqApolloGLTextureView) != 2) && (GLTextureView.a(this.jdField_a_of_type_ComTencentMobileqqApolloGLTextureView) != 3)) {
      return paramArrayOfInt;
    }
    int i = paramArrayOfInt.length;
    int[] arrayOfInt = new int[i + 2];
    System.arraycopy(paramArrayOfInt, 0, arrayOfInt, 0, i - 1);
    arrayOfInt[(i - 1)] = 12352;
    if (GLTextureView.a(this.jdField_a_of_type_ComTencentMobileqqApolloGLTextureView) == 2) {
      arrayOfInt[i] = 4;
    }
    for (;;)
    {
      arrayOfInt[(i + 1)] = 12344;
      return arrayOfInt;
      arrayOfInt[i] = 64;
    }
  }
  
  public EGLConfig a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay)
  {
    int[] arrayOfInt = new int[1];
    if (!paramEGL10.eglChooseConfig(paramEGLDisplay, this.jdField_a_of_type_ArrayOfInt, null, 0, arrayOfInt)) {
      throw new IllegalArgumentException("eglChooseConfig failed");
    }
    int i = arrayOfInt[0];
    if (i <= 0) {
      throw new IllegalArgumentException("No configs match configSpec");
    }
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[i];
    if (!paramEGL10.eglChooseConfig(paramEGLDisplay, this.jdField_a_of_type_ArrayOfInt, arrayOfEGLConfig, i, arrayOfInt)) {
      throw new IllegalArgumentException("eglChooseConfig#2 failed");
    }
    paramEGL10 = a(paramEGL10, paramEGLDisplay, arrayOfEGLConfig);
    if (paramEGL10 == null) {
      throw new IllegalArgumentException("No config chosen");
    }
    return paramEGL10;
  }
  
  abstract EGLConfig a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig[] paramArrayOfEGLConfig);
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\pqs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */