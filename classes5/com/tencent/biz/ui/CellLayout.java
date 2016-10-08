package com.tencent.biz.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import jfg;

public class CellLayout
  extends ViewGroup
  implements Animation.AnimationListener
{
  public static final int a = 1;
  public static final int b = 2;
  public static int c = 0;
  public static int d = 0;
  public static int e = 0;
  public static int f = 0;
  public static int g = 0;
  public static int h = 0;
  public static int i = 0;
  public static int j = 0;
  public static int k = 0;
  public static int l = 0;
  public static final int m = 2;
  public static final int n = 3;
  public static final int o = 1;
  public static final int p = 2;
  public static final int q = 3;
  public Animation a;
  CellLayout.OnLayoutListener jdField_a_of_type_ComTencentBizUiCellLayout$OnLayoutListener;
  PopupMenuPA.AnimationCallbacks jdField_a_of_type_ComTencentBizUiPopupMenuPA$AnimationCallbacks;
  jfg jdField_a_of_type_Jfg;
  boolean jdField_a_of_type_Boolean = true;
  Animation jdField_b_of_type_AndroidViewAnimationAnimation;
  boolean jdField_b_of_type_Boolean = false;
  public int r = 3;
  public int s = 3;
  public int t = 1;
  
  public CellLayout(Context paramContext)
  {
    this(paramContext, null);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public CellLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CellLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.t == 1)
    {
      c = (int)(paramInt1 * 150.0F / 750.0F);
      d = c + MenuViewFactory.a(getContext(), 30.0F);
      e = (int)(paramInt1 * 70.0F / 750.0F);
      return;
    }
    h = (paramInt1 - (this.r - 1) * k - j * 2) / this.r;
    i = Math.min(MenuViewFactory.a(getContext(), 60.0F), (paramInt2 - (this.s - 1) * l - g * 2) / this.s);
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramView.layout(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4);
  }
  
  private int b()
  {
    if (this.t == 1) {
      return c;
    }
    return h;
  }
  
  private int c()
  {
    if (this.t == 1) {
      return d;
    }
    return i;
  }
  
  private void c()
  {
    e = MenuViewFactory.a(getContext(), 25.0F);
    f = MenuViewFactory.a(getContext(), 25.0F);
    g = MenuViewFactory.a(getContext(), 10.0F);
    Context localContext = getContext();
    if (this.r == 2)
    {
      f1 = 30.0F;
      j = MenuViewFactory.a(localContext, f1);
      localContext = getContext();
      if (this.r != 2) {
        break label103;
      }
    }
    label103:
    for (float f1 = 25.0F;; f1 = 10.0F)
    {
      k = MenuViewFactory.a(localContext, f1);
      l = MenuViewFactory.a(getContext(), 22.0F);
      return;
      f1 = 15.0F;
      break;
    }
  }
  
  private int d()
  {
    if (this.t == 1) {
      return e;
    }
    return k;
  }
  
  private int e()
  {
    if (this.t == 1) {
      return f;
    }
    return l;
  }
  
  public int a()
  {
    return c() * this.s + (this.s - 1) * e() + g * 2;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Jfg == null)
    {
      this.jdField_a_of_type_Jfg = new jfg(this, this.jdField_a_of_type_AndroidViewAnimationAnimation);
      setLayoutAnimation(this.jdField_a_of_type_Jfg);
    }
    this.jdField_a_of_type_Jfg.setAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
    startLayoutAnimation();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Jfg == null)
    {
      this.jdField_a_of_type_Jfg = new jfg(this, this.jdField_b_of_type_AndroidViewAnimationAnimation);
      setLayoutAnimation(this.jdField_a_of_type_Jfg);
    }
    this.jdField_a_of_type_Jfg.setAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
    startLayoutAnimation();
    invalidate();
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    PopupMenuPA.AnimationCallbacks localAnimationCallbacks;
    if (this.jdField_a_of_type_ComTencentBizUiPopupMenuPA$AnimationCallbacks != null)
    {
      localAnimationCallbacks = this.jdField_a_of_type_ComTencentBizUiPopupMenuPA$AnimationCallbacks;
      if (paramAnimation != this.jdField_a_of_type_AndroidViewAnimationAnimation) {
        break label30;
      }
    }
    label30:
    for (int i1 = 0;; i1 = 1)
    {
      localAnimationCallbacks.b(i1);
      return;
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    PopupMenuPA.AnimationCallbacks localAnimationCallbacks;
    if (this.jdField_a_of_type_ComTencentBizUiPopupMenuPA$AnimationCallbacks != null)
    {
      localAnimationCallbacks = this.jdField_a_of_type_ComTencentBizUiPopupMenuPA$AnimationCallbacks;
      if (paramAnimation != this.jdField_a_of_type_AndroidViewAnimationAnimation) {
        break label30;
      }
    }
    label30:
    for (int i1 = 0;; i1 = 1)
    {
      localAnimationCallbacks.a(i1);
      return;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = getChildCount();
    int i2 = b();
    int i3 = c();
    int i4 = d();
    int i5 = e();
    int i6 = (paramInt3 - paramInt1 - this.r * i2 - (this.r - 1) * i4) / 2;
    paramInt4 = (paramInt4 - paramInt2 - this.s * i3 - (this.s - 1) * i5) / 2;
    paramInt1 = 0;
    if (paramInt1 < i1)
    {
      View localView = getChildAt(paramInt1);
      int i7 = paramInt1 / this.r;
      int i8 = paramInt1 % this.r;
      if (i8 > 0)
      {
        paramInt2 = i8 * i4;
        label124:
        if (i7 <= 0) {
          break label196;
        }
      }
      label196:
      for (paramInt3 = i7 * i5;; paramInt3 = 0)
      {
        a(localView, i8 * i2 + i6 + paramInt2, paramInt4 + i7 * i3 + paramInt3, i2, i3);
        if (this.jdField_a_of_type_ComTencentBizUiCellLayout$OnLayoutListener != null) {
          this.jdField_a_of_type_ComTencentBizUiCellLayout$OnLayoutListener.a(this);
        }
        paramInt1 += 1;
        break;
        paramInt2 = 0;
        break label124;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i2 = 2;
    int i1 = 3;
    int i3 = getChildCount();
    if (this.t == 1)
    {
      if ((this.jdField_a_of_type_Boolean) && (i3 <= 6)) {
        if (i3 >= 5)
        {
          this.r = i1;
          if (i3 < 4) {
            break label103;
          }
          i1 = i2;
        }
      }
      label53:
      for (this.s = i1;; this.s = 3)
      {
        i2 = View.MeasureSpec.getMode(paramInt1);
        i1 = View.MeasureSpec.getSize(paramInt1);
        paramInt1 = View.MeasureSpec.getMode(paramInt2);
        paramInt2 = View.MeasureSpec.getSize(paramInt2);
        if ((i2 != 0) && (paramInt1 != 0)) {
          break label177;
        }
        throw new RuntimeException("CellLayout cannot have UNSPECIFIED dimensions");
        i1 = 2;
        break;
        label103:
        i1 = 1;
        break label53;
        this.r = 3;
      }
    }
    if (i3 > 8)
    {
      label128:
      this.r = i1;
      if (i3 % this.r == 0) {
        break label166;
      }
    }
    label166:
    for (i1 = i3 / this.r + 1;; i1 = i3 / this.r)
    {
      this.s = i1;
      break;
      i1 = 2;
      break label128;
    }
    label177:
    c();
    a(i1, paramInt2);
    paramInt2 = View.MeasureSpec.makeMeasureSpec(b(), 1073741824);
    i2 = View.MeasureSpec.makeMeasureSpec(c(), 1073741824);
    paramInt1 = 0;
    while (paramInt1 < i3)
    {
      getChildAt(paramInt1).measure(paramInt2, i2);
      paramInt1 += 1;
    }
    setMeasuredDimension(i1, c() * this.s + (this.s - 1) * e() + g * 2);
  }
  
  public void setAnimationCallbacks(PopupMenuPA.AnimationCallbacks paramAnimationCallbacks)
  {
    this.jdField_a_of_type_ComTencentBizUiPopupMenuPA$AnimationCallbacks = paramAnimationCallbacks;
  }
  
  public void setCenterInLayout(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(getContext(), 2130968652);
    this.jdField_b_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(getContext(), 2130968653);
    setLayoutAnimationListener(this);
  }
  
  public void setOnLayoutListener(CellLayout.OnLayoutListener paramOnLayoutListener)
  {
    this.jdField_a_of_type_ComTencentBizUiCellLayout$OnLayoutListener = paramOnLayoutListener;
  }
  
  public void setType(int paramInt)
  {
    this.t = paramInt;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\ui\CellLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */