package com.tencent.av.opengl.texture;

import android.opengl.GLES20;
import com.tencent.av.opengl.glrenderer.GLCanvas;
import com.tencent.av.opengl.glrenderer.GLES20Canvas;
import com.tencent.av.opengl.program.TextureProgram;
import com.tencent.av.opengl.program.TextureProgramFactory;
import com.tencent.av.opengl.shader.ShaderParameter;
import com.tencent.av.opengl.utils.Utils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

public abstract class BasicTexture
{
  protected static final int a = -1;
  private static final String jdField_a_of_type_JavaLangString = "BasicTexture";
  private static ThreadLocal jdField_a_of_type_JavaLangThreadLocal = new ThreadLocal();
  private static WeakHashMap jdField_a_of_type_JavaUtilWeakHashMap;
  protected static final int b = 0;
  protected static final int c = 1;
  protected static final int d = -1;
  public static final int e = 0;
  public static final int f = 1;
  public static final int g = 2;
  private static final int q = 4096;
  protected GLCanvas a;
  protected int[] a;
  protected int h;
  protected int i = -1;
  protected int j = -1;
  protected int k;
  protected int l;
  protected int m;
  protected int n;
  int o = 0;
  int p = 0;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaUtilWeakHashMap = new WeakHashMap();
  }
  
  protected BasicTexture()
  {
    this(null, 0);
  }
  
  protected BasicTexture(GLCanvas arg1, int paramInt)
  {
    a(???);
    this.h = paramInt;
    synchronized (jdField_a_of_type_JavaUtilWeakHashMap)
    {
      jdField_a_of_type_JavaUtilWeakHashMap.put(this, null);
      return;
    }
  }
  
  public static void c()
  {
    synchronized (jdField_a_of_type_JavaUtilWeakHashMap)
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilWeakHashMap.keySet().iterator();
      if (localIterator.hasNext()) {
        ((BasicTexture)localIterator.next()).b();
      }
    }
  }
  
  public static void d()
  {
    synchronized (jdField_a_of_type_JavaUtilWeakHashMap)
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilWeakHashMap.keySet().iterator();
      if (localIterator.hasNext())
      {
        BasicTexture localBasicTexture = (BasicTexture)localIterator.next();
        localBasicTexture.h = 0;
        localBasicTexture.a(null);
      }
    }
  }
  
  public static boolean d()
  {
    return jdField_a_of_type_JavaLangThreadLocal.get() != null;
  }
  
  private void e()
  {
    GLCanvas localGLCanvas = this.jdField_a_of_type_ComTencentAvOpenglGlrendererGLCanvas;
    if ((localGLCanvas != null) && (this.jdField_a_of_type_ArrayOfInt != null))
    {
      localGLCanvas.a(this);
      this.jdField_a_of_type_ArrayOfInt = null;
    }
    this.h = 0;
    a(null);
  }
  
  public int a()
  {
    return this.m;
  }
  
  public TextureProgram a(GLCanvas paramGLCanvas)
  {
    return paramGLCanvas.a().a(this);
  }
  
  public void a()
  {
    e();
  }
  
  public void a(int paramInt)
  {
    this.m = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.i = paramInt1;
    this.j = paramInt2;
  }
  
  protected void a(GLCanvas paramGLCanvas)
  {
    this.jdField_a_of_type_ComTencentAvOpenglGlrendererGLCanvas = paramGLCanvas;
  }
  
  public void a(GLCanvas paramGLCanvas, int paramInt1, int paramInt2)
  {
    paramGLCanvas.a(this, paramInt1, paramInt2, f(), g());
  }
  
  public void a(GLCanvas paramGLCanvas, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramGLCanvas.a(this, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public abstract boolean a(GLCanvas paramGLCanvas);
  
  public int[] a()
  {
    return this.jdField_a_of_type_ArrayOfInt;
  }
  
  public ShaderParameter[] a(GLCanvas paramGLCanvas)
  {
    int i1 = 0;
    TextureProgram localTextureProgram = a(paramGLCanvas);
    GLES20.glUseProgram(localTextureProgram.a());
    Utils.a();
    if ((!b()) || (paramGLCanvas.a() < 0.95F)) {}
    for (boolean bool = true;; bool = false)
    {
      GLES20Canvas.a(bool);
      a(paramGLCanvas);
      int[] arrayOfInt = a();
      while (i1 < arrayOfInt.length)
      {
        GLES20.glActiveTexture(33984 + i1);
        Utils.a();
        GLES20.glBindTexture(j(), arrayOfInt[i1]);
        Utils.a();
        GLES20.glUniform1i(localTextureProgram.a()[(i1 + 4)].a, i1);
        Utils.a();
        i1 += 1;
      }
    }
    GLES20.glUniform1f(localTextureProgram.a()[2].a, paramGLCanvas.a());
    Utils.a();
    return localTextureProgram.a();
  }
  
  public int b()
  {
    return this.n;
  }
  
  public void b()
  {
    e();
  }
  
  public void b(int paramInt)
  {
    this.n = paramInt;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    this.k = paramInt1;
    this.l = paramInt2;
    if (((this.k > 4096) || (this.l > 4096)) && (QLog.isColorLevel())) {
      QLog.w("BasicTexture", 2, String.format("texture is too large: %d x %d", new Object[] { Integer.valueOf(this.k), Integer.valueOf(this.l) }), new Exception());
    }
    if (this.i == -1)
    {
      this.i = paramInt1;
      this.j = paramInt2;
    }
  }
  
  public abstract boolean b();
  
  public int c()
  {
    return 0;
  }
  
  public void c(int paramInt)
  {
    this.o = paramInt;
  }
  
  public boolean c()
  {
    return this.h == 1;
  }
  
  public int d()
  {
    return this.o;
  }
  
  public void d(int paramInt)
  {
    this.p = paramInt;
  }
  
  public int e()
  {
    return this.p;
  }
  
  public int f()
  {
    return this.i;
  }
  
  protected void finalize()
  {
    jdField_a_of_type_JavaLangThreadLocal.set(BasicTexture.class);
    a();
    jdField_a_of_type_JavaLangThreadLocal.set(null);
  }
  
  public int g()
  {
    return this.j;
  }
  
  public int h()
  {
    return this.k;
  }
  
  public int i()
  {
    return this.l;
  }
  
  public abstract int j();
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\opengl\texture\BasicTexture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */