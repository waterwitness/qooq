package com.tencent.mobileqq.apollo;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView.Renderer;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import pqr;
import pqt;
import pqu;
import pqv;
import pqx;
import pqy;
import pra;

public class GLTextureView
  extends TextureView
  implements TextureView.SurfaceTextureListener
{
  public static final int a = 0;
  private static final String jdField_a_of_type_JavaLangString = "GLTextureView";
  private static final pqy jdField_a_of_type_Pqy = new pqy(null);
  private static final boolean jdField_a_of_type_Boolean = false;
  public static final int b = 1;
  private static final boolean b = false;
  public static final int c = 1;
  private static final boolean c = false;
  public static final int d = 2;
  private static final boolean d = false;
  private static int jdField_e_of_type_Int;
  private static final boolean jdField_e_of_type_Boolean = false;
  private static final boolean jdField_f_of_type_Boolean = false;
  private static final boolean jdField_g_of_type_Boolean = false;
  private GLSurfaceView.Renderer jdField_a_of_type_AndroidOpenglGLSurfaceView$Renderer;
  private GLTextureView.EGLConfigChooser jdField_a_of_type_ComTencentMobileqqApolloGLTextureView$EGLConfigChooser;
  private GLTextureView.EGLContextFactory jdField_a_of_type_ComTencentMobileqqApolloGLTextureView$EGLContextFactory;
  private GLTextureView.EGLWindowSurfaceFactory jdField_a_of_type_ComTencentMobileqqApolloGLTextureView$EGLWindowSurfaceFactory;
  private GLTextureView.GLWrapper jdField_a_of_type_ComTencentMobileqqApolloGLTextureView$GLWrapper;
  private final WeakReference jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this);
  private pqx jdField_a_of_type_Pqx;
  private int jdField_f_of_type_Int;
  private int jdField_g_of_type_Int;
  private boolean h;
  private boolean i;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public GLTextureView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public GLTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public static Integer a(Context paramContext, String paramString, int paramInt)
  {
    try
    {
      paramContext = paramContext.getClassLoader().loadClass("android.os.SystemProperties");
      paramContext = (Integer)paramContext.getMethod("getInt", new Class[] { String.class, Integer.TYPE }).invoke(paramContext, new Object[] { new String(paramString), new Integer(paramInt) });
      return paramContext;
    }
    catch (IllegalArgumentException paramContext)
    {
      throw paramContext;
    }
    catch (Exception paramContext) {}
    return Integer.valueOf(paramInt);
  }
  
  private void a()
  {
    e = a(getContext(), "ro.opengles.version", 0).intValue();
    setSurfaceTextureListener(this);
    addOnLayoutChangeListener(new pqr(this));
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Pqx != null) {
      throw new IllegalStateException("setRenderer has already been called for this instance.");
    }
  }
  
  public int a()
  {
    return this.f;
  }
  
  public void a(SurfaceTexture paramSurfaceTexture)
  {
    this.jdField_a_of_type_Pqx.b();
  }
  
  public void a(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Pqx.a(paramInt2, paramInt3);
  }
  
  public void a(Runnable paramRunnable)
  {
    this.jdField_a_of_type_Pqx.a(paramRunnable);
  }
  
  public boolean a()
  {
    return this.i;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Pqx.a();
  }
  
  public void b()
  {
    this.jdField_a_of_type_Pqx.a();
  }
  
  public void b(SurfaceTexture paramSurfaceTexture)
  {
    this.jdField_a_of_type_Pqx.c();
  }
  
  public void d()
  {
    this.jdField_a_of_type_Pqx.d();
  }
  
  public void e()
  {
    this.jdField_a_of_type_Pqx.e();
  }
  
  protected void finalize()
  {
    try
    {
      if (this.jdField_a_of_type_Pqx != null) {
        this.jdField_a_of_type_Pqx.f();
      }
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if ((this.h) && (this.jdField_a_of_type_AndroidOpenglGLSurfaceView$Renderer != null)) {
      if (this.jdField_a_of_type_Pqx == null) {
        break label74;
      }
    }
    label74:
    for (int j = this.jdField_a_of_type_Pqx.a();; j = 1)
    {
      this.jdField_a_of_type_Pqx = new pqx(this.jdField_a_of_type_JavaLangRefWeakReference);
      if (j != 1) {
        this.jdField_a_of_type_Pqx.a(j);
      }
      this.jdField_a_of_type_Pqx.start();
      this.h = false;
      return;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    if (this.jdField_a_of_type_Pqx != null) {
      this.jdField_a_of_type_Pqx.f();
    }
    this.h = true;
    super.onDetachedFromWindow();
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    Log.d("GLTextureView", "onSurfaceTextureAvailable");
    a(paramSurfaceTexture);
    a(paramSurfaceTexture, 0, paramInt1, paramInt2);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    Log.d("GLTextureView", "onSurfaceTextureDestroyed");
    b(paramSurfaceTexture);
    return true;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    Log.d("GLTextureView", "onSurfaceTextureSizeChanged");
    a(paramSurfaceTexture, 0, paramInt1, paramInt2);
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public void setDebugFlags(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void setEGLConfigChooser(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    setEGLConfigChooser(new pqt(this, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6));
  }
  
  public void setEGLConfigChooser(GLTextureView.EGLConfigChooser paramEGLConfigChooser)
  {
    c();
    this.jdField_a_of_type_ComTencentMobileqqApolloGLTextureView$EGLConfigChooser = paramEGLConfigChooser;
  }
  
  public void setEGLConfigChooser(boolean paramBoolean)
  {
    setEGLConfigChooser(new pra(this, paramBoolean));
  }
  
  public void setEGLContextClientVersion(int paramInt)
  {
    c();
    this.g = paramInt;
  }
  
  public void setEGLContextFactory(GLTextureView.EGLContextFactory paramEGLContextFactory)
  {
    c();
    this.jdField_a_of_type_ComTencentMobileqqApolloGLTextureView$EGLContextFactory = paramEGLContextFactory;
  }
  
  public void setEGLWindowSurfaceFactory(GLTextureView.EGLWindowSurfaceFactory paramEGLWindowSurfaceFactory)
  {
    c();
    this.jdField_a_of_type_ComTencentMobileqqApolloGLTextureView$EGLWindowSurfaceFactory = paramEGLWindowSurfaceFactory;
  }
  
  public void setGLWrapper(GLTextureView.GLWrapper paramGLWrapper)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloGLTextureView$GLWrapper = paramGLWrapper;
  }
  
  public void setPreserveEGLContextOnPause(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public void setRenderMode(int paramInt)
  {
    this.jdField_a_of_type_Pqx.a(paramInt);
  }
  
  public void setRenderer(GLSurfaceView.Renderer paramRenderer)
  {
    c();
    if (this.jdField_a_of_type_ComTencentMobileqqApolloGLTextureView$EGLConfigChooser == null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloGLTextureView$EGLConfigChooser = new pra(this, true);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloGLTextureView$EGLContextFactory == null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloGLTextureView$EGLContextFactory = new pqu(this, null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloGLTextureView$EGLWindowSurfaceFactory == null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloGLTextureView$EGLWindowSurfaceFactory = new pqv(null);
    }
    this.jdField_a_of_type_AndroidOpenglGLSurfaceView$Renderer = paramRenderer;
    this.jdField_a_of_type_Pqx = new pqx(this.jdField_a_of_type_JavaLangRefWeakReference);
    this.jdField_a_of_type_Pqx.start();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\apollo\GLTextureView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */