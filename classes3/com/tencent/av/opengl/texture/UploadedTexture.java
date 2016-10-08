package com.tencent.av.opengl.texture;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.tencent.av.opengl.glrenderer.GLCanvas;
import com.tencent.av.opengl.glrenderer.GLId;
import com.tencent.av.opengl.shader.ShaderParameter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public abstract class UploadedTexture
  extends BasicTexture
{
  private static final String jdField_a_of_type_JavaLangString = "UploadedTexture";
  private static int q = 0;
  private static final int r = 100;
  boolean jdField_a_of_type_Boolean;
  protected Bitmap b;
  private boolean b;
  private boolean c;
  private boolean d;
  private boolean e;
  
  protected UploadedTexture()
  {
    super(null, 0);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_b_of_type_Boolean = true;
    this.d = true;
    this.jdField_a_of_type_Boolean = false;
  }
  
  private Bitmap b()
  {
    if (this.jdField_b_of_type_AndroidGraphicsBitmap == null)
    {
      this.jdField_b_of_type_AndroidGraphicsBitmap = a();
      if (this.jdField_b_of_type_AndroidGraphicsBitmap != null)
      {
        int i = this.jdField_b_of_type_AndroidGraphicsBitmap.getWidth();
        int j = this.jdField_b_of_type_AndroidGraphicsBitmap.getHeight();
        if (this.i == -1) {
          b(i, j);
        }
      }
    }
    return this.jdField_b_of_type_AndroidGraphicsBitmap;
  }
  
  private void c(GLCanvas paramGLCanvas)
  {
    Bitmap localBitmap = b();
    if (localBitmap != null) {
      try
      {
        int i = localBitmap.getWidth();
        int j = localBitmap.getHeight();
        int k = h();
        int m = i();
        if (this.jdField_a_of_type_ArrayOfInt == null) {
          this.jdField_a_of_type_ArrayOfInt = new int[1];
        }
        this.jdField_a_of_type_ArrayOfInt[0] = paramGLCanvas.a().a();
        paramGLCanvas.a(this);
        if ((i == k) && (j == m)) {
          paramGLCanvas.a(this, localBitmap);
        }
        for (;;)
        {
          e();
          a(paramGLCanvas);
          this.h = 1;
          this.jdField_b_of_type_Boolean = true;
          return;
          i = GLUtils.getInternalFormat(localBitmap);
          j = GLUtils.getType(localBitmap);
          paramGLCanvas.a(this, i, j);
          paramGLCanvas.a(this, 0, 0, localBitmap, i, j);
        }
        this.h = -1;
      }
      finally
      {
        e();
      }
    }
    throw new RuntimeException("Texture load fail, no bitmap");
  }
  
  private void e()
  {
    if (this.jdField_b_of_type_AndroidGraphicsBitmap != null)
    {
      a(this.jdField_b_of_type_AndroidGraphicsBitmap);
      this.jdField_b_of_type_AndroidGraphicsBitmap = null;
    }
  }
  
  public static void g()
  {
    q = 0;
  }
  
  public static boolean g()
  {
    return q > 100;
  }
  
  protected abstract Bitmap a();
  
  public void a()
  {
    super.a();
    if (this.jdField_b_of_type_AndroidGraphicsBitmap != null) {
      e();
    }
  }
  
  protected abstract void a(Bitmap paramBitmap);
  
  public boolean a(GLCanvas paramGLCanvas)
  {
    b(paramGLCanvas);
    return f();
  }
  
  public ShaderParameter[] a(GLCanvas paramGLCanvas)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      GLES20.glEnable(3042);
      GLES20.glBlendFunc(770, 771);
    }
    return super.a(paramGLCanvas);
  }
  
  public void b(GLCanvas paramGLCanvas)
  {
    if (!c()) {
      if (this.e)
      {
        i = q + 1;
        q = i;
        if (i <= 100) {}
      }
    }
    while (this.jdField_b_of_type_Boolean)
    {
      int i;
      return;
      c(paramGLCanvas);
      return;
    }
    Bitmap localBitmap = b();
    paramGLCanvas.a(this, 0, 0, localBitmap, GLUtils.getInternalFormat(localBitmap), GLUtils.getType(localBitmap));
    e();
    this.jdField_b_of_type_Boolean = true;
  }
  
  protected void b(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public boolean b()
  {
    return this.d;
  }
  
  protected void c(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public void d(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void e(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean e()
  {
    return this.c;
  }
  
  public int f()
  {
    if (this.i == -1) {
      b();
    }
    return this.i;
  }
  
  protected void f()
  {
    if (this.jdField_b_of_type_AndroidGraphicsBitmap != null) {
      e();
    }
    this.jdField_b_of_type_Boolean = false;
    this.i = -1;
    this.j = -1;
  }
  
  public boolean f()
  {
    return (c()) && (this.jdField_b_of_type_Boolean);
  }
  
  public int g()
  {
    if (this.i == -1) {
      b();
    }
    return this.j;
  }
  
  public int j()
  {
    return 3553;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\opengl\texture\UploadedTexture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */