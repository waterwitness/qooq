package com.tencent.mobileqq.businessCard.helpers;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import qwy;

public final class ViewHelper
{
  private ViewHelper()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static float a(View paramView)
  {
    if (AnimatorProxy.a) {
      return AnimatorProxy.a(paramView).a();
    }
    return qwy.c(paramView);
  }
  
  public static Matrix a(View paramView)
  {
    if (AnimatorProxy.a) {
      return AnimatorProxy.a(paramView).a();
    }
    return qwy.a(paramView);
  }
  
  public static void a(RectF paramRectF, View paramView)
  {
    if (AnimatorProxy.a) {
      AnimatorProxy.a(paramView).a(paramRectF, paramView);
    }
  }
  
  public static void a(View paramView, float paramFloat)
  {
    if (AnimatorProxy.a)
    {
      AnimatorProxy.a(paramView).a(paramFloat);
      return;
    }
    qwy.c(paramView, paramFloat);
  }
  
  public static void a(View paramView, int paramInt)
  {
    if (AnimatorProxy.a)
    {
      AnimatorProxy.a(paramView).a(paramInt);
      return;
    }
    qwy.a(paramView, paramInt);
  }
  
  public static float b(View paramView)
  {
    if (AnimatorProxy.a) {
      return AnimatorProxy.a(paramView).e();
    }
    return qwy.d(paramView);
  }
  
  public static void b(View paramView, float paramFloat)
  {
    if (AnimatorProxy.a)
    {
      AnimatorProxy.a(paramView).e(paramFloat);
      return;
    }
    qwy.d(paramView, paramFloat);
  }
  
  public static void b(View paramView, int paramInt)
  {
    if (AnimatorProxy.a)
    {
      AnimatorProxy.a(paramView).b(paramInt);
      return;
    }
    qwy.b(paramView, paramInt);
  }
  
  public static float c(View paramView)
  {
    if (AnimatorProxy.a) {
      return AnimatorProxy.a(paramView).f();
    }
    return qwy.e(paramView);
  }
  
  public static void c(View paramView, float paramFloat)
  {
    if (AnimatorProxy.a)
    {
      AnimatorProxy.a(paramView).f(paramFloat);
      return;
    }
    qwy.e(paramView, paramFloat);
  }
  
  public static float d(View paramView)
  {
    if (AnimatorProxy.a) {
      return AnimatorProxy.a(paramView).b();
    }
    return qwy.a(paramView);
  }
  
  public static void d(View paramView, float paramFloat)
  {
    if (AnimatorProxy.a)
    {
      AnimatorProxy.a(paramView).b(paramFloat);
      return;
    }
    qwy.a(paramView, paramFloat);
  }
  
  public static float e(View paramView)
  {
    if (AnimatorProxy.a) {
      return AnimatorProxy.a(paramView).c();
    }
    return qwy.b(paramView);
  }
  
  public static void e(View paramView, float paramFloat)
  {
    if (AnimatorProxy.a)
    {
      AnimatorProxy.a(paramView).c(paramFloat);
      return;
    }
    qwy.b(paramView, paramFloat);
  }
  
  public static float f(View paramView)
  {
    if (AnimatorProxy.a) {
      return AnimatorProxy.a(paramView).a();
    }
    return qwy.f(paramView);
  }
  
  public static void f(View paramView, float paramFloat)
  {
    if (AnimatorProxy.a)
    {
      AnimatorProxy.a(paramView).g(paramFloat);
      return;
    }
    qwy.f(paramView, paramFloat);
  }
  
  public static float g(View paramView)
  {
    if (AnimatorProxy.a) {
      return AnimatorProxy.a(paramView).b();
    }
    return qwy.g(paramView);
  }
  
  public static void g(View paramView, float paramFloat)
  {
    if (AnimatorProxy.a)
    {
      AnimatorProxy.a(paramView).h(paramFloat);
      return;
    }
    qwy.g(paramView, paramFloat);
  }
  
  public static float h(View paramView)
  {
    if (AnimatorProxy.a) {
      return AnimatorProxy.a(paramView).g();
    }
    return qwy.h(paramView);
  }
  
  public static void h(View paramView, float paramFloat)
  {
    if (AnimatorProxy.a)
    {
      AnimatorProxy.a(paramView).i(paramFloat);
      return;
    }
    qwy.h(paramView, paramFloat);
  }
  
  public static float i(View paramView)
  {
    if (AnimatorProxy.a) {
      return AnimatorProxy.a(paramView).h();
    }
    return qwy.i(paramView);
  }
  
  public static float j(View paramView)
  {
    if (AnimatorProxy.a) {
      return AnimatorProxy.a(paramView).i();
    }
    return qwy.j(paramView);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\businessCard\helpers\ViewHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */