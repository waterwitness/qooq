package com.tencent.mobileqq.businessCard.helpers;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public final class AnimatorProxy
  extends Animation
{
  static final WeakHashMap jdField_a_of_type_JavaUtilWeakHashMap;
  public static final boolean a;
  float jdField_a_of_type_Float = 1.0F;
  final Camera jdField_a_of_type_AndroidGraphicsCamera = new Camera();
  final Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  final RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  final WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  float jdField_b_of_type_Float;
  final RectF jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  boolean jdField_b_of_type_Boolean;
  float c;
  float d;
  float e;
  float f;
  float g = 1.0F;
  float h = 1.0F;
  float i;
  float j;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    if (Integer.valueOf(Build.VERSION.SDK_INT).intValue() < 11) {}
    for (bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      jdField_a_of_type_JavaUtilWeakHashMap = new WeakHashMap();
      return;
    }
  }
  
  private AnimatorProxy(View paramView)
  {
    setDuration(0L);
    setFillAfter(true);
    paramView.setAnimation(this);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
  }
  
  public static AnimatorProxy a(View paramView)
  {
    AnimatorProxy localAnimatorProxy2 = (AnimatorProxy)jdField_a_of_type_JavaUtilWeakHashMap.get(paramView);
    AnimatorProxy localAnimatorProxy1;
    if (localAnimatorProxy2 != null)
    {
      localAnimatorProxy1 = localAnimatorProxy2;
      if (localAnimatorProxy2 == paramView.getAnimation()) {}
    }
    else
    {
      localAnimatorProxy1 = new AnimatorProxy(paramView);
      jdField_a_of_type_JavaUtilWeakHashMap.put(paramView, localAnimatorProxy1);
    }
    return localAnimatorProxy1;
  }
  
  private void a()
  {
    View localView = (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localView != null) {
      a(this.jdField_a_of_type_AndroidGraphicsRectF, localView);
    }
  }
  
  private void a(Matrix paramMatrix, View paramView)
  {
    float f3 = paramView.getWidth();
    float f4 = paramView.getHeight();
    boolean bool = this.jdField_b_of_type_Boolean;
    float f1;
    if (bool)
    {
      f1 = this.jdField_b_of_type_Float;
      if (!bool) {
        break label226;
      }
    }
    label226:
    for (float f2 = this.c;; f2 = f4 / 2.0F)
    {
      float f5 = this.d;
      float f6 = this.e;
      float f7 = this.f;
      if ((f5 != 0.0F) || (f6 != 0.0F) || (f7 != 0.0F))
      {
        paramView = this.jdField_a_of_type_AndroidGraphicsCamera;
        paramView.save();
        paramView.rotateX(f5);
        paramView.rotateY(f6);
        paramView.rotateZ(-f7);
        paramView.getMatrix(paramMatrix);
        paramView.restore();
        paramMatrix.preTranslate(-f1, -f2);
        paramMatrix.postTranslate(f1, f2);
      }
      f5 = this.g;
      f6 = this.h;
      if ((f5 != 1.0F) || (f6 != 1.0F))
      {
        paramMatrix.postScale(f5, f6);
        paramMatrix.postTranslate(-(f1 / f3) * (f5 * f3 - f3), -(f2 / f4) * (f6 * f4 - f4));
      }
      paramMatrix.postTranslate(this.i, this.j);
      return;
      f1 = f3 / 2.0F;
      break;
    }
  }
  
  private void b()
  {
    View localView = (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localView == null) || (localView.getParent() == null)) {
      return;
    }
    RectF localRectF = this.jdField_b_of_type_AndroidGraphicsRectF;
    a(localRectF, localView);
    localRectF.union(this.jdField_a_of_type_AndroidGraphicsRectF);
    ((View)localView.getParent()).invalidate((int)Math.floor(localRectF.left), (int)Math.floor(localRectF.top), (int)Math.ceil(localRectF.right), (int)Math.ceil(localRectF.bottom));
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public int a()
  {
    View localView = (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localView == null) {
      return 0;
    }
    return localView.getScrollX();
  }
  
  public Matrix a()
  {
    if ((View)this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) {
      a();
    }
    return this.jdField_a_of_type_AndroidGraphicsMatrix;
  }
  
  public void a(float paramFloat)
  {
    if (this.jdField_a_of_type_Float != paramFloat)
    {
      this.jdField_a_of_type_Float = paramFloat;
      View localView = (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localView != null) {
        localView.invalidate();
      }
    }
  }
  
  public void a(int paramInt)
  {
    View localView = (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localView != null) {
      localView.scrollTo(paramInt, localView.getScrollY());
    }
  }
  
  public void a(RectF paramRectF, View paramView)
  {
    paramRectF.set(0.0F, 0.0F, paramView.getWidth(), paramView.getHeight());
    Matrix localMatrix = this.jdField_a_of_type_AndroidGraphicsMatrix;
    localMatrix.reset();
    a(localMatrix, paramView);
    this.jdField_a_of_type_AndroidGraphicsMatrix.mapRect(paramRectF);
    paramRectF.offset(paramView.getLeft(), paramView.getTop());
    float f1;
    if (paramRectF.right < paramRectF.left)
    {
      f1 = paramRectF.right;
      paramRectF.right = paramRectF.left;
      paramRectF.left = f1;
    }
    if (paramRectF.bottom < paramRectF.top)
    {
      f1 = paramRectF.top;
      paramRectF.top = paramRectF.bottom;
      paramRectF.bottom = f1;
    }
  }
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    View localView = (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localView != null)
    {
      paramTransformation.setAlpha(this.jdField_a_of_type_Float);
      a(paramTransformation.getMatrix(), localView);
    }
  }
  
  public float b()
  {
    return this.jdField_b_of_type_Float;
  }
  
  public int b()
  {
    View localView = (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localView == null) {
      return 0;
    }
    return localView.getScrollY();
  }
  
  public void b(float paramFloat)
  {
    if ((!this.jdField_b_of_type_Boolean) || (this.jdField_b_of_type_Float != paramFloat))
    {
      a();
      this.jdField_b_of_type_Boolean = true;
      this.jdField_b_of_type_Float = paramFloat;
      b();
    }
  }
  
  public void b(int paramInt)
  {
    View localView = (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localView != null) {
      localView.scrollTo(localView.getScrollX(), paramInt);
    }
  }
  
  public float c()
  {
    return this.c;
  }
  
  public void c(float paramFloat)
  {
    if ((!this.jdField_b_of_type_Boolean) || (this.c != paramFloat))
    {
      a();
      this.jdField_b_of_type_Boolean = true;
      this.c = paramFloat;
      b();
    }
  }
  
  public float d()
  {
    return this.f;
  }
  
  public void d(float paramFloat)
  {
    if (this.f != paramFloat)
    {
      a();
      this.f = paramFloat;
      b();
    }
  }
  
  public float e()
  {
    return this.g;
  }
  
  public void e(float paramFloat)
  {
    if (this.g != paramFloat)
    {
      a();
      this.g = paramFloat;
      b();
    }
  }
  
  public float f()
  {
    return this.h;
  }
  
  public void f(float paramFloat)
  {
    if (this.h != paramFloat)
    {
      a();
      this.h = paramFloat;
      b();
    }
  }
  
  public float g()
  {
    return this.i;
  }
  
  public void g(float paramFloat)
  {
    if (this.i != paramFloat)
    {
      a();
      this.i = paramFloat;
      b();
    }
  }
  
  public float h()
  {
    return this.j;
  }
  
  public void h(float paramFloat)
  {
    if (this.j != paramFloat)
    {
      a();
      this.j = paramFloat;
      b();
    }
  }
  
  public float i()
  {
    View localView = (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localView == null) {
      return 0.0F;
    }
    return localView.getLeft() + this.i;
  }
  
  public void i(float paramFloat)
  {
    View localView = (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localView != null) {
      g(paramFloat - localView.getLeft());
    }
  }
  
  public float j()
  {
    View localView = (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localView == null) {
      return 0.0F;
    }
    return localView.getTop() + this.j;
  }
  
  public void j(float paramFloat)
  {
    View localView = (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localView != null) {
      h(paramFloat - localView.getTop());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\businessCard\helpers\AnimatorProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */