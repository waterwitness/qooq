package com.hiar.sdk.renderer;

import ahg;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.Matrix;
import com.hiar.sdk.HSARToolkit;
import com.hiar.sdk.utils.Drawable2d;
import com.hiar.sdk.utils.GlUtil;
import com.tencent.mobileqq.ar.TraceUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class CameraRenderer
  implements SurfaceTexture.OnFrameAvailableListener, GLSurfaceView.Renderer
{
  private static int f;
  private static int g;
  private int jdField_a_of_type_Int;
  private SurfaceTexture jdField_a_of_type_AndroidGraphicsSurfaceTexture;
  private GLSurfaceView jdField_a_of_type_AndroidOpenglGLSurfaceView;
  private Drawable2d jdField_a_of_type_ComHiarSdkUtilsDrawable2d;
  private float[] jdField_a_of_type_ArrayOfFloat;
  private int b;
  private int c;
  private int d;
  private int e;
  private int h;
  private int i;
  private int j;
  private int k;
  
  public CameraRenderer(GLSurfaceView paramGLSurfaceView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ArrayOfFloat = new float[16];
    this.jdField_a_of_type_ComHiarSdkUtilsDrawable2d = new Drawable2d();
    this.jdField_a_of_type_AndroidOpenglGLSurfaceView = paramGLSurfaceView;
  }
  
  protected void a()
  {
    this.e = GLES20.glGetUniformLocation(this.j, "uTexture");
    this.jdField_a_of_type_Int = GLES20.glGetAttribLocation(this.j, "aPosition");
    this.b = GLES20.glGetUniformLocation(this.j, "uMVPMatrix");
    this.c = GLES20.glGetUniformLocation(this.j, "uTexMatrix");
    this.d = GLES20.glGetAttribLocation(this.j, "aTextureCoord");
  }
  
  protected void a(int paramInt)
  {
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(36197, paramInt);
    GLES20.glUniform1i(this.e, 0);
    GLES20.glTexParameterf(36197, 10242, 33071.0F);
    GLES20.glTexParameterf(36197, 10243, 33071.0F);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.i = paramInt1;
    this.h = paramInt2;
    float f1 = f / g;
    float f2 = paramInt2 / paramInt1;
    if (f1 < f2)
    {
      f2 = g * f2 / f;
      f1 = 1.0F;
    }
    for (;;)
    {
      Matrix.setIdentityM(this.jdField_a_of_type_ArrayOfFloat, 0);
      Matrix.scaleM(this.jdField_a_of_type_ArrayOfFloat, 0, f2, f1, 1.0F);
      return;
      if (f1 > f2)
      {
        f1 = f / (f2 * g);
        f2 = 1.0F;
      }
      else
      {
        f1 = 1.0F;
        f2 = 1.0F;
      }
    }
  }
  
  public void a(int paramInt, SurfaceTexture paramSurfaceTexture)
  {
    HSARToolkit.a().a = 0L;
    HSARToolkit.a().c = 0L;
    HSARToolkit.a().b = 0L;
    if (this.jdField_a_of_type_AndroidGraphicsSurfaceTexture != null)
    {
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.setOnFrameAvailableListener(null);
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.release();
      this.k = 0;
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = null;
    }
    this.k = paramInt;
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = paramSurfaceTexture;
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.setOnFrameAvailableListener(this);
  }
  
  protected void a(float[] paramArrayOfFloat1, FloatBuffer paramFloatBuffer1, int paramInt1, int paramInt2, float[] paramArrayOfFloat2, FloatBuffer paramFloatBuffer2, int paramInt3)
  {
    GLES20.glUniformMatrix4fv(this.b, 1, false, paramArrayOfFloat1, 0);
    GLES20.glUniformMatrix4fv(this.c, 1, false, paramArrayOfFloat2, 0);
    GLES20.glEnableVertexAttribArray(this.jdField_a_of_type_Int);
    GLES20.glVertexAttribPointer(this.jdField_a_of_type_Int, paramInt1, 5126, false, paramInt2, paramFloatBuffer1);
    GLES20.glEnableVertexAttribArray(this.d);
    GLES20.glVertexAttribPointer(this.d, 2, 5126, false, paramInt3, paramFloatBuffer2);
  }
  
  protected void b()
  {
    GLES20.glUseProgram(this.j);
  }
  
  protected void b(int paramInt1, int paramInt2)
  {
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    GLES20.glClear(16384);
    GLES20.glDrawArrays(5, paramInt1, paramInt2);
  }
  
  protected void c()
  {
    GLES20.glDisableVertexAttribArray(this.jdField_a_of_type_Int);
    GLES20.glDisableVertexAttribArray(this.d);
  }
  
  protected void d()
  {
    GLES20.glBindTexture(36197, 0);
  }
  
  protected void e()
  {
    GLES20.glUseProgram(0);
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_AndroidGraphicsSurfaceTexture != null)
    {
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.setOnFrameAvailableListener(null);
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.release();
      this.k = 0;
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = null;
    }
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    if ((this.jdField_a_of_type_AndroidGraphicsSurfaceTexture == null) || (HSARToolkit.a().a == 0L)) {
      return;
    }
    long l1 = System.currentTimeMillis();
    while (HSARToolkit.a().c > HSARToolkit.a().b)
    {
      paramGL10 = HSARToolkit.a();
      paramGL10.b += 1L;
      try
      {
        this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.updateTexImage();
      }
      catch (Exception paramGL10) {}
    }
    b();
    a(this.k);
    paramGL10 = new float[16];
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.getTransformMatrix(paramGL10);
    a(this.jdField_a_of_type_ArrayOfFloat, this.jdField_a_of_type_ComHiarSdkUtilsDrawable2d.a(), this.jdField_a_of_type_ComHiarSdkUtilsDrawable2d.d(), this.jdField_a_of_type_ComHiarSdkUtilsDrawable2d.b(), paramGL10, this.jdField_a_of_type_ComHiarSdkUtilsDrawable2d.b(), this.jdField_a_of_type_ComHiarSdkUtilsDrawable2d.c());
    b(0, this.jdField_a_of_type_ComHiarSdkUtilsDrawable2d.a());
    c();
    d();
    e();
    long l2 = System.currentTimeMillis();
    TraceUtil.b("CameraRenderer.onRender cost = " + (l2 - l1));
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    paramSurfaceTexture = HSARToolkit.a();
    paramSurfaceTexture.a += 1L;
    this.jdField_a_of_type_AndroidOpenglGLSurfaceView.queueEvent(new ahg(this));
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    g = paramInt2;
    f = paramInt1;
    GLES20.glViewport(0, 0, paramInt1, paramInt2);
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    this.j = GlUtil.a("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\n\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\n\nvarying vec2 vTextureCoord;\n\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\n\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES uTexture;\n\nvoid main() {\n    gl_FragColor = texture2D(uTexture, vTextureCoord);\n}");
    a();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\hiar\sdk\renderer\CameraRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */