package com.tencent.av.opengl.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.tencent.av.opengl.glrenderer.GLCanvas;
import com.tencent.av.opengl.texture.BasicTexture;
import com.tencent.av.opengl.texture.BitmapTexture;
import com.tencent.av.opengl.texture.ResourceTexture;
import com.tencent.av.opengl.ui.animation.GLAnimation;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class GLView
{
  private static final String jdField_a_of_type_JavaLangString = "GLView";
  public static final int v = 0;
  public static final int w = 1;
  protected static final int x = 1;
  protected static final int y = 2;
  protected static final int z = 4;
  protected int A;
  protected int B;
  protected int C;
  protected int D;
  protected int E;
  protected int F;
  protected int G;
  protected int H;
  protected int I;
  protected int J;
  protected int K;
  protected int L;
  protected final Rect a;
  private SparseArray jdField_a_of_type_AndroidUtilSparseArray;
  protected Animation a;
  protected Transformation a;
  protected GLView.OnZOrderChangedListener a;
  protected GLView a;
  protected Object a;
  protected WeakReference a;
  protected final Rect b;
  protected GLRootView b;
  protected GLView.OnTouchListener b;
  protected float c;
  protected BasicTexture c;
  protected List c;
  protected float d;
  protected BasicTexture d;
  protected float e;
  protected float f;
  protected float g;
  protected float h;
  protected float i;
  protected float j;
  protected float k;
  protected float l;
  protected float m;
  protected float n;
  
  public GLView(Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect(0, 0, 0, 0);
    this.jdField_b_of_type_AndroidGraphicsRect = new Rect(0, 0, 0, 0);
    this.D = -1;
    this.E = -1;
    this.K = -16777216;
    this.i = 1.0F;
    this.j = 1.0F;
    this.k = 1.0F;
    this.jdField_c_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
  }
  
  public void A()
  {
    if (this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView != null) {
      this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView.e();
    }
  }
  
  public Rect a()
  {
    return this.jdField_b_of_type_AndroidGraphicsRect;
  }
  
  public GLRootView a()
  {
    return this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView;
  }
  
  public Object a()
  {
    return this.jdField_a_of_type_JavaLangObject;
  }
  
  public Object a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray != null) {
      return this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    }
    return null;
  }
  
  public List a()
  {
    return this.jdField_c_of_type_JavaUtilList;
  }
  
  public void a()
  {
    this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView = null;
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_b_of_type_AndroidGraphicsRect.set(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void a(int paramInt, Object paramObject)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {
      this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    }
    this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramObject);
  }
  
  public void a(long paramLong)
  {
    label104:
    for (;;)
    {
      synchronized (this.jdField_c_of_type_JavaUtilList)
      {
        if (this.jdField_c_of_type_JavaUtilList.size() > 0)
        {
          x();
          int i1 = 0;
          int i2 = this.jdField_c_of_type_JavaUtilList.size();
          if (i1 < i2) {
            try
            {
              boolean bool = ((GLAnimation)this.jdField_c_of_type_JavaUtilList.get(i1)).a(paramLong);
              if (!bool) {
                break label104;
              }
              i1 -= 1;
              i1 += 1;
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
              break label104;
            }
          }
        }
        return;
      }
    }
  }
  
  public void a(Animation paramAnimation)
  {
    if (a() == null) {
      throw new IllegalStateException();
    }
    this.jdField_a_of_type_AndroidViewAnimationAnimation = paramAnimation;
    if (this.jdField_a_of_type_AndroidViewAnimationAnimation != null) {
      this.jdField_a_of_type_AndroidViewAnimationAnimation.start();
    }
    x();
  }
  
  protected void a(GLCanvas paramGLCanvas)
  {
    if (this.jdField_c_of_type_ComTencentAvOpenglTextureBasicTexture != null)
    {
      i1 = g();
      i2 = h();
      this.jdField_c_of_type_ComTencentAvOpenglTextureBasicTexture.a(paramGLCanvas, 0, 0, i1, i2);
      return;
    }
    int i1 = g();
    int i2 = h();
    paramGLCanvas.a(0.0F, 0.0F, i1, i2, this.K);
  }
  
  public void a(BasicTexture paramBasicTexture)
  {
    this.d = paramBasicTexture;
  }
  
  public void a(GLRootView paramGLRootView)
  {
    b(paramGLRootView);
  }
  
  public void a(GLView.OnTouchListener paramOnTouchListener)
  {
    this.jdField_b_of_type_ComTencentAvOpenglUiGLView$OnTouchListener = paramOnTouchListener;
  }
  
  protected void a(GLView.OnZOrderChangedListener paramOnZOrderChangedListener)
  {
    this.jdField_a_of_type_ComTencentAvOpenglUiGLView$OnZOrderChangedListener = paramOnZOrderChangedListener;
  }
  
  public void a(GLAnimation paramGLAnimation)
  {
    List localList = this.jdField_c_of_type_JavaUtilList;
    if (paramGLAnimation != null) {}
    try
    {
      paramGLAnimation.a(this);
      paramGLAnimation.a();
      this.jdField_c_of_type_JavaUtilList.add(paramGLAnimation);
      x();
      return;
    }
    finally {}
  }
  
  public void a(Object paramObject)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
  }
  
  public void a(Runnable paramRunnable)
  {
    GLRootView localGLRootView = a();
    if (localGLRootView != null) {
      localGLRootView.post(paramRunnable);
    }
  }
  
  public void a(Runnable paramRunnable, long paramLong)
  {
    GLRootView localGLRootView = a();
    if (localGLRootView != null) {
      localGLRootView.postDelayed(paramRunnable, paramLong);
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt3 - paramInt1 != this.jdField_a_of_type_AndroidGraphicsRect.right - this.jdField_a_of_type_AndroidGraphicsRect.left) || (paramInt4 - paramInt2 != this.jdField_a_of_type_AndroidGraphicsRect.bottom - this.jdField_a_of_type_AndroidGraphicsRect.top)) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_AndroidGraphicsRect.set(paramInt1, paramInt2, paramInt3, paramInt4);
      return bool;
    }
  }
  
  protected boolean a(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean a(GLView paramGLView, Rect paramRect)
  {
    GLView localGLView = paramGLView;
    int i1 = 0;
    int i2 = 0;
    while (localGLView != this)
    {
      if (localGLView == null) {
        return false;
      }
      Rect localRect = localGLView.jdField_a_of_type_AndroidGraphicsRect;
      i2 += localRect.left;
      i1 += localRect.top;
      localGLView = localGLView.jdField_a_of_type_ComTencentAvOpenglUiGLView;
    }
    paramRect.set(i2, i1, paramGLView.g() + i2, paramGLView.h() + i1);
    return true;
  }
  
  public Rect b()
  {
    return this.jdField_a_of_type_AndroidGraphicsRect;
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool = a(paramInt1, paramInt2, paramInt3, paramInt4);
    this.A &= 0xFFFFFFFB;
    a(bool, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void b(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return;
    }
    if (this.jdField_c_of_type_ComTencentAvOpenglTextureBasicTexture != null)
    {
      this.jdField_c_of_type_ComTencentAvOpenglTextureBasicTexture.a();
      this.jdField_c_of_type_ComTencentAvOpenglTextureBasicTexture = null;
    }
    this.jdField_c_of_type_ComTencentAvOpenglTextureBasicTexture = new BitmapTexture(paramBitmap);
    this.J = 0;
  }
  
  public void b(GLCanvas paramGLCanvas)
  {
    if (this.d == null) {
      return;
    }
    int i1 = g();
    int i2 = h();
    Rect localRect = a();
    int i3 = localRect.left;
    int i4 = localRect.right;
    int i5 = localRect.top;
    int i6 = localRect.bottom;
    int i7 = localRect.left;
    int i8 = localRect.top;
    paramGLCanvas.a(2);
    this.d.a(paramGLCanvas, i7, i8, i1 - i3 - i4, i2 - i5 - i6);
    paramGLCanvas.c();
  }
  
  protected void b(GLRootView paramGLRootView)
  {
    this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView = paramGLRootView;
  }
  
  protected boolean b(MotionEvent paramMotionEvent)
  {
    if ((f() == 0) && (this.jdField_b_of_type_ComTencentAvOpenglUiGLView$OnTouchListener != null) && (this.jdField_b_of_type_ComTencentAvOpenglUiGLView$OnTouchListener.a(this, paramMotionEvent))) {
      return true;
    }
    return a(paramMotionEvent);
  }
  
  protected void c() {}
  
  protected void c(GLCanvas paramGLCanvas)
  {
    a(System.currentTimeMillis());
    int i1 = this.jdField_a_of_type_AndroidGraphicsRect.left;
    int i2 = this.jdField_a_of_type_AndroidGraphicsRect.top;
    paramGLCanvas.b();
    GLAnimation localGLAnimation = null;
    if (this.jdField_c_of_type_JavaUtilList.size() > 0) {
      localGLAnimation = (GLAnimation)this.jdField_c_of_type_JavaUtilList.get(0);
    }
    if ((localGLAnimation != null) && (localGLAnimation.b()))
    {
      paramGLCanvas.a(localGLAnimation.a(), localGLAnimation.b(), localGLAnimation.c());
      float f1 = this.i;
      f1 = this.j;
      f1 = this.k;
      if ((localGLAnimation != null) && (localGLAnimation.d()))
      {
        f1 = localGLAnimation.e();
        float f2 = localGLAnimation.f();
        a(i1, i2, (int)(f1 + i1), (int)(f2 + i2));
      }
      paramGLCanvas.a(g() / 2, h() / 2, 0.0F);
      if ((localGLAnimation == null) || (!localGLAnimation.e())) {
        break label268;
      }
      paramGLCanvas.b(localGLAnimation.g(), 1.0F, 0.0F, 0.0F);
      paramGLCanvas.b(localGLAnimation.h(), 0.0F, 1.0F, 0.0F);
      paramGLCanvas.b(localGLAnimation.i(), 0.0F, 0.0F, 1.0F);
    }
    for (;;)
    {
      a(paramGLCanvas);
      b(paramGLCanvas);
      paramGLCanvas.c();
      return;
      paramGLCanvas.a(i1, i2, this.e);
      break;
      label268:
      if (this.f != 0.0F) {
        paramGLCanvas.b(this.f, 1.0F, 0.0F, 0.0F);
      }
      if (this.g != 0.0F) {
        paramGLCanvas.b(this.g, 0.0F, 1.0F, 0.0F);
      }
      if (this.h != 0.0F) {
        paramGLCanvas.b(this.h, 0.0F, 0.0F, 1.0F);
      }
    }
  }
  
  public void e(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == this.D) && (paramInt2 == this.E) && ((this.A & 0x4) == 0)) {}
    do
    {
      return;
      this.D = paramInt1;
      this.E = paramInt2;
      this.A &= 0xFFFFFFFD;
      f(paramInt1, paramInt2);
    } while ((this.A & 0x2) != 0);
    throw new IllegalStateException(getClass().getName() + " should call setMeasuredSize() in onMeasure()");
  }
  
  public int f()
  {
    if ((this.A & 0x1) == 0) {
      return 0;
    }
    return 1;
  }
  
  protected void f(int paramInt1, int paramInt2) {}
  
  public void finalize()
  {
    super.finalize();
    if (this.d != null)
    {
      this.d.a();
      this.d = null;
    }
    if (this.jdField_c_of_type_ComTencentAvOpenglTextureBasicTexture != null)
    {
      this.jdField_c_of_type_ComTencentAvOpenglTextureBasicTexture.a();
      this.jdField_c_of_type_ComTencentAvOpenglTextureBasicTexture = null;
      this.J = 0;
    }
  }
  
  public int g()
  {
    return this.jdField_a_of_type_AndroidGraphicsRect.right - this.jdField_a_of_type_AndroidGraphicsRect.left;
  }
  
  public void g(int paramInt)
  {
    if (paramInt == f()) {
      return;
    }
    if (paramInt == 0) {}
    for (this.A &= 0xFFFFFFFE;; this.A |= 0x1)
    {
      k(paramInt);
      x();
      return;
    }
  }
  
  protected void g(int paramInt1, int paramInt2)
  {
    this.A |= 0x2;
    this.B = paramInt1;
    this.C = paramInt2;
  }
  
  public int h()
  {
    return this.jdField_a_of_type_AndroidGraphicsRect.bottom - this.jdField_a_of_type_AndroidGraphicsRect.top;
  }
  
  public void h(int paramInt)
  {
    if (this.L != paramInt)
    {
      int i1 = this.L;
      this.L = paramInt;
      if (this.jdField_a_of_type_ComTencentAvOpenglUiGLView$OnZOrderChangedListener != null) {
        this.jdField_a_of_type_ComTencentAvOpenglUiGLView$OnZOrderChangedListener.a(this, paramInt, i1);
      }
    }
  }
  
  public int i()
  {
    return this.L;
  }
  
  public void i(int paramInt)
  {
    this.K = paramInt;
  }
  
  public int j()
  {
    return this.K;
  }
  
  public void j(int paramInt)
  {
    ResourceTexture localResourceTexture = null;
    if ((paramInt != 0) && (paramInt == this.J)) {
      return;
    }
    Object localObject = a();
    if (localObject == null) {
      throw new RuntimeException("Cannot set resource background before attach to GLRootView!");
    }
    if (this.jdField_c_of_type_ComTencentAvOpenglTextureBasicTexture != null)
    {
      this.jdField_c_of_type_ComTencentAvOpenglTextureBasicTexture.a();
      this.jdField_c_of_type_ComTencentAvOpenglTextureBasicTexture = null;
    }
    localObject = ((GLRootView)localObject).getContext();
    if (paramInt == 0) {}
    for (;;)
    {
      this.jdField_c_of_type_ComTencentAvOpenglTextureBasicTexture = localResourceTexture;
      this.J = paramInt;
      return;
      localResourceTexture = new ResourceTexture((Context)localObject, paramInt);
    }
  }
  
  public int k()
  {
    return this.B;
  }
  
  protected void k(int paramInt) {}
  
  public int l()
  {
    return this.C;
  }
  
  public void w()
  {
    a();
  }
  
  public void x()
  {
    GLRootView localGLRootView = a();
    if (localGLRootView != null) {
      localGLRootView.requestRender();
    }
  }
  
  public void y()
  {
    this.A |= 0x4;
    this.E = -1;
    this.D = -1;
    if (this.jdField_a_of_type_ComTencentAvOpenglUiGLView != null) {
      this.jdField_a_of_type_ComTencentAvOpenglUiGLView.y();
    }
    GLRootView localGLRootView;
    do
    {
      return;
      localGLRootView = a();
    } while (localGLRootView == null);
    localGLRootView.c();
  }
  
  public void z()
  {
    if (this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView != null) {
      this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView.d();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\opengl\ui\GLView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */