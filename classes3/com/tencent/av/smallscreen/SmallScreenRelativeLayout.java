package com.tencent.av.smallscreen;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import gop;

public class SmallScreenRelativeLayout
  extends RelativeLayout
  implements Animator.AnimatorListener
{
  static final String jdField_a_of_type_JavaLangString = "SmallScreenRelativeLayout";
  final int jdField_a_of_type_Int;
  Display jdField_a_of_type_AndroidViewDisplay;
  Animator jdField_a_of_type_ComTencentAvSmallscreenAnimator;
  SmallScreenRelativeLayout.FloatListener jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$FloatListener;
  gop jdField_a_of_type_Gop = null;
  boolean jdField_a_of_type_Boolean = false;
  final int jdField_b_of_type_Int;
  Animator jdField_b_of_type_ComTencentAvSmallscreenAnimator;
  boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int;
  boolean jdField_c_of_type_Boolean = false;
  int jdField_d_of_type_Int;
  boolean jdField_d_of_type_Boolean = true;
  final int e;
  final int f;
  int g;
  final int h;
  int i = -1;
  int j = -1;
  int k = -1;
  int l = -1;
  int m = -1;
  int n = -1;
  int o = 6;
  int p = 0;
  int q = 0;
  int r = 0;
  int s = 7;
  
  public SmallScreenRelativeLayout(Context paramContext)
  {
    this(paramContext, null);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public SmallScreenRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SmallScreenRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenRelativeLayout", 2, "WL_DEBUG SmallScreenRelativeLayout");
    }
    this.jdField_b_of_type_Int = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.e = getResources().getDimensionPixelSize(2131494075);
    this.f = getResources().getDimensionPixelSize(2131494076);
    this.jdField_a_of_type_Int = getResources().getDimensionPixelSize(2131494049);
    this.g = getResources().getDimensionPixelSize(2131492908);
    this.h = getResources().getDimensionPixelSize(2131494081);
    this.jdField_a_of_type_ComTencentAvSmallscreenAnimator = Animator.a(0.0F, 1.0F);
    this.jdField_a_of_type_ComTencentAvSmallscreenAnimator.a(200L);
    this.jdField_a_of_type_ComTencentAvSmallscreenAnimator.a(this);
    this.jdField_b_of_type_ComTencentAvSmallscreenAnimator = Animator.a(0.0F, 1.0F);
    this.jdField_b_of_type_ComTencentAvSmallscreenAnimator.a(400L);
    this.jdField_b_of_type_ComTencentAvSmallscreenAnimator.a(this);
    this.jdField_a_of_type_AndroidViewDisplay = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    this.p = this.jdField_a_of_type_AndroidViewDisplay.getRotation();
    this.jdField_a_of_type_Gop = new gop(this, getContext(), 2);
  }
  
  public int a()
  {
    int i2;
    if ((this.q != 0) && (this.r != 0))
    {
      if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$FloatListener == null) {
        break label60;
      }
      i2 = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$FloatListener.a(this);
    }
    for (int i1 = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$FloatListener.b(this);; i1 = getTop())
    {
      this.s = a(i2, i1, i2, i1);
      return this.s;
      label60:
      i2 = getLeft();
    }
  }
  
  int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = Integer.MAX_VALUE;
    int i1 = 0;
    paramInt1 = 1;
    if (paramInt1 < 11)
    {
      Point localPoint = a(paramInt1);
      int i2 = localPoint.x;
      int i3 = localPoint.x;
      int i4 = localPoint.y;
      i2 = (paramInt4 - localPoint.y) * (paramInt4 - i4) + (paramInt3 - i2) * (paramInt3 - i3);
      if (i2 >= paramInt2) {
        break label90;
      }
      i1 = paramInt1;
      paramInt2 = i2;
    }
    label90:
    for (;;)
    {
      paramInt1 += 1;
      break;
      return i1;
    }
  }
  
  Point a(int paramInt)
  {
    Rect localRect = a();
    Point localPoint = new Point();
    switch (paramInt)
    {
    default: 
      return localPoint;
    case 0: 
      localPoint.x = localRect.centerX();
      localPoint.y = localRect.centerY();
      return localPoint;
    case 1: 
      localPoint.x = localRect.left;
      localPoint.y = localRect.top;
      return localPoint;
    case 2: 
      localPoint.x = localRect.left;
      localPoint.y = (localRect.top + this.g);
      return localPoint;
    case 3: 
      localPoint.x = localRect.left;
      localPoint.y = localRect.centerY();
      return localPoint;
    case 4: 
      localPoint.x = localRect.left;
      localPoint.y = (localRect.bottom - this.h);
      return localPoint;
    case 5: 
      localPoint.x = localRect.left;
      localPoint.y = localRect.bottom;
      return localPoint;
    case 6: 
      localPoint.x = localRect.right;
      localPoint.y = localRect.top;
      return localPoint;
    case 7: 
      localPoint.x = localRect.right;
      localPoint.y = (localRect.top + this.g);
      return localPoint;
    case 8: 
      localPoint.x = localRect.right;
      localPoint.y = localRect.centerY();
      return localPoint;
    case 9: 
      localPoint.x = localRect.right;
      localPoint.y = (localRect.bottom - this.h);
      return localPoint;
    }
    localPoint.x = localRect.right;
    localPoint.y = localRect.bottom;
    return localPoint;
  }
  
  Rect a()
  {
    int i1;
    label25:
    int i2;
    label35:
    Rect localRect;
    int i4;
    if (this.jdField_a_of_type_AndroidViewDisplay.getRotation() % 2 == 0)
    {
      i3 = 1;
      if (i3 == 0) {
        break label125;
      }
      i1 = this.e;
      if (i3 == 0) {
        break label133;
      }
      i2 = this.f;
      localRect = new Rect();
      localRect.left = i1;
      localRect.top = i2;
      if ((i3 == 0) && (this.jdField_a_of_type_Boolean)) {
        break label141;
      }
      i4 = this.jdField_c_of_type_Int;
    }
    for (int i3 = this.jdField_d_of_type_Int;; i3 = this.jdField_c_of_type_Int)
    {
      if ((this.q == 0) || (this.r == 0)) {
        break label156;
      }
      localRect.right = (this.q - i4 - i1);
      localRect.bottom = (this.r - i3 - i2);
      return localRect;
      i3 = 0;
      break;
      label125:
      i1 = this.f;
      break label25;
      label133:
      i2 = this.e;
      break label35;
      label141:
      i4 = this.jdField_d_of_type_Int;
    }
    label156:
    localRect.right = (this.jdField_a_of_type_AndroidViewDisplay.getWidth() - i4 - i1);
    localRect.bottom = (this.jdField_a_of_type_AndroidViewDisplay.getHeight() - i3 - i2);
    return localRect;
  }
  
  public void a()
  {
    int i3 = this.jdField_a_of_type_AndroidViewDisplay.getRotation();
    Rect localRect = new Rect();
    try
    {
      getWindowVisibleDisplayFrame(localRect);
      boolean bool = SmallScreenUtils.a();
      int i4 = localRect.width();
      int i2 = localRect.height();
      i1 = i2;
      if (bool) {
        i1 = i2 - this.jdField_a_of_type_Int;
      }
      if ((this.p != i3) || (i4 != this.q) || (i1 != this.r))
      {
        if (QLog.isColorLevel())
        {
          QLog.d("SmallScreenRelativeLayout", 2, "WL_DEBUG onOrientationChangedInner mIsInit = " + this.jdField_d_of_type_Boolean);
          QLog.d("SmallScreenRelativeLayout", 2, "WL_DEBUG onOrientationChangedInner mRotation = " + this.p);
          QLog.d("SmallScreenRelativeLayout", 2, "WL_DEBUG onOrientationChangedInner mScreenWidth = " + this.q);
          QLog.d("SmallScreenRelativeLayout", 2, "WL_DEBUG onOrientationChangedInner mScreenHeight = " + this.r);
          QLog.d("SmallScreenRelativeLayout", 2, "WL_DEBUG onOrientationChangedInner rotation = " + i3);
          QLog.d("SmallScreenRelativeLayout", 2, "WL_DEBUG onOrientationChangedInner width = " + i4);
          QLog.d("SmallScreenRelativeLayout", 2, "WL_DEBUG onOrientationChangedInner height = " + i1);
        }
        if ((this.jdField_d_of_type_Boolean) && (i3 != 0)) {
          this.jdField_d_of_type_Boolean = false;
        }
        this.jdField_a_of_type_ComTencentAvSmallscreenAnimator.d();
        this.p = i3;
        this.q = i4;
        this.r = i1;
        setCurPosition(this.s);
        if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$FloatListener == null) {
          break label415;
        }
        i1 = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$FloatListener.a(this);
        this.m = i1;
        this.i = i1;
        i1 = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$FloatListener.b(this);
        this.n = i1;
        this.j = i1;
        if (!this.jdField_d_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentAvSmallscreenAnimator.b();
        }
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i1;
        if (QLog.isColorLevel())
        {
          QLog.e("SmallScreenRelativeLayout", 2, "Can not getWindowVisibleDisplayFrame");
          continue;
          label415:
          i1 = getLeft();
          this.m = i1;
          this.i = i1;
          i1 = getTop();
          this.n = i1;
          this.j = i1;
        }
      }
    }
  }
  
  void a(int paramInt1, int paramInt2)
  {
    paramInt1 = this.i + paramInt1 - this.k;
    int i3 = this.j + paramInt2 - this.l;
    int i1;
    int i2;
    int i4;
    if ((this.p % 2 == 0) || (!this.jdField_a_of_type_Boolean))
    {
      i1 = this.jdField_c_of_type_Int;
      paramInt2 = this.jdField_d_of_type_Int;
      i2 = this.q - i1;
      i4 = this.r - paramInt2;
      if (paramInt1 >= 0) {
        break label166;
      }
      paramInt1 = 0;
    }
    label166:
    for (;;)
    {
      if (paramInt1 > i2) {}
      for (;;)
      {
        if (i3 < 0) {}
        for (paramInt1 = 0;; paramInt1 = i3)
        {
          if (paramInt1 > i4) {
            paramInt1 = i4;
          }
          for (;;)
          {
            if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$FloatListener != null)
            {
              this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$FloatListener.a(this, i2, paramInt1, i1 + i2, paramInt1 + paramInt2);
              return;
              i1 = this.jdField_d_of_type_Int;
              paramInt2 = this.jdField_c_of_type_Int;
              break;
            }
            layout(i2, paramInt1, i2 + i1, paramInt2 + paramInt1);
            return;
          }
        }
        i2 = paramInt1;
      }
    }
  }
  
  public void a(Animator paramAnimator)
  {
    float f1 = Float.valueOf(paramAnimator.a()).floatValue();
    if (paramAnimator == this.jdField_a_of_type_ComTencentAvSmallscreenAnimator)
    {
      paramAnimator = a(this.o);
      i3 = (int)(this.m + (paramAnimator.x - this.m) * f1);
      f2 = this.n;
      i4 = (int)(f1 * (paramAnimator.y - this.n) + f2);
      if ((this.p % 2 == 0) || (!this.jdField_a_of_type_Boolean))
      {
        i1 = this.jdField_c_of_type_Int;
        i2 = this.jdField_d_of_type_Int;
        if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$FloatListener == null) {
          break label147;
        }
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$FloatListener.a(this, i3, i4, i1 + i3, i4 + i2);
      }
    }
    label147:
    while ((paramAnimator != this.jdField_b_of_type_ComTencentAvSmallscreenAnimator) || (this.jdField_b_of_type_Boolean))
    {
      int i3;
      int i4;
      int i1;
      int i2;
      for (;;)
      {
        float f2;
        return;
        i1 = this.jdField_d_of_type_Int;
        i2 = this.jdField_c_of_type_Int;
      }
      layout(i3, i4, i3 + i1, i2 + i4);
      return;
    }
  }
  
  void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SmallScreenRelativeLayout", 2, "WL_DEBUG startShowHideAnimation mIsShow = " + this.jdField_b_of_type_Boolean);
      QLog.d("SmallScreenRelativeLayout", 2, "WL_DEBUG startShowHideAnimation isShow = " + paramBoolean);
    }
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (paramBoolean) {}
    for (int i1 = 0;; i1 = 8)
    {
      setVisibility(i1);
      if ((!paramBoolean) && (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$FloatListener != null)) {
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$FloatListener.a(this);
      }
      return;
    }
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenRelativeLayout", 2, "WL_DEBUG onCreate");
    }
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_Gop.enable();
  }
  
  public void b(Animator paramAnimator)
  {
    if (paramAnimator == this.jdField_a_of_type_ComTencentAvSmallscreenAnimator) {
      this.o = a(this.i, this.j, this.m, this.n);
    }
    do
    {
      do
      {
        return;
      } while ((paramAnimator != this.jdField_b_of_type_ComTencentAvSmallscreenAnimator) || (!this.jdField_b_of_type_Boolean));
      setVisibility(0);
    } while (!QLog.isColorLevel());
    QLog.d("SmallScreenRelativeLayout", 2, "WL_DEBUG onAnimationStart setVisibility(VISIBLE)");
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenRelativeLayout", 2, "WL_DEBUG onDestroy");
    }
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$FloatListener = null;
    this.jdField_a_of_type_Gop.disable();
  }
  
  public void c(Animator paramAnimator)
  {
    Point localPoint;
    int i1;
    int i2;
    if (paramAnimator == this.jdField_a_of_type_ComTencentAvSmallscreenAnimator)
    {
      localPoint = a(this.o);
      switch (this.o)
      {
      default: 
        paramAnimator = null;
        if ((this.p % 2 == 0) || (!this.jdField_a_of_type_Boolean))
        {
          i1 = this.jdField_c_of_type_Int;
          i2 = this.jdField_d_of_type_Int;
          label93:
          if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$FloatListener == null) {
            break label220;
          }
          this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$FloatListener.a(this, localPoint.x, localPoint.y, i1 + localPoint.x, localPoint.y + i2);
          label131:
          this.jdField_d_of_type_Boolean = false;
          this.s = this.o;
          if (paramAnimator != null) {
            ReportController.b(null, "CliOper", "", "", paramAnimator, paramAnimator, 0, 0, "", "", "", "");
          }
        }
        break;
      }
    }
    label220:
    do
    {
      do
      {
        return;
        paramAnimator = "0X80057E1";
        break;
        paramAnimator = "0X80057E3";
        break;
        paramAnimator = "0X80057E2";
        break;
        paramAnimator = "0X80057E4";
        break;
        i1 = this.jdField_d_of_type_Int;
        i2 = this.jdField_c_of_type_Int;
        break label93;
        layout(localPoint.x, localPoint.y, localPoint.x + i1, i2 + localPoint.y);
        break label131;
      } while ((paramAnimator != this.jdField_b_of_type_ComTencentAvSmallscreenAnimator) || (this.jdField_b_of_type_Boolean));
      setVisibility(8);
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenRelativeLayout", 2, "WL_DEBUG onAnimationEnd setVisibility(GONE)");
      }
    } while (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$FloatListener == null);
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$FloatListener.a(this);
  }
  
  public void d()
  {
    a(true);
  }
  
  public void d(Animator paramAnimator) {}
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    int i1 = (int)paramMotionEvent.getRawX();
    int i2 = (int)paramMotionEvent.getRawY();
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 0: 
    case 2: 
      do
      {
        return true;
        this.jdField_a_of_type_ComTencentAvSmallscreenAnimator.d();
        this.k = i1;
        this.l = i2;
        if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$FloatListener != null) {
          this.i = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$FloatListener.a(this);
        }
        for (this.j = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$FloatListener.b(this);; this.j = getTop())
        {
          this.jdField_c_of_type_Boolean = false;
          return true;
          this.i = getLeft();
        }
        if (this.jdField_c_of_type_Boolean)
        {
          a(i1, i2);
          return true;
        }
      } while ((Math.abs(i1 - this.k) <= this.jdField_b_of_type_Int) && (Math.abs(i2 - this.l) <= this.jdField_b_of_type_Int));
      this.jdField_c_of_type_Boolean = true;
      return true;
    case 1: 
      if (this.jdField_c_of_type_Boolean)
      {
        a(i1, i2);
        label195:
        if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$FloatListener == null) {
          break label266;
        }
        this.m = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$FloatListener.a(this);
      }
      for (this.n = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$FloatListener.b(this); !bool; this.n = getTop())
      {
        this.jdField_a_of_type_ComTencentAvSmallscreenAnimator.b();
        return true;
        if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$FloatListener == null) {
          break label195;
        }
        bool = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$FloatListener.a(this);
        break label195;
        label266:
        this.m = getLeft();
      }
    }
    if (this.jdField_c_of_type_Boolean) {
      a(i1, i2);
    }
    if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$FloatListener != null) {
      this.m = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$FloatListener.a(this);
    }
    for (this.n = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$FloatListener.b(this);; this.n = getTop())
    {
      this.jdField_a_of_type_ComTencentAvSmallscreenAnimator.b();
      return true;
      this.m = getLeft();
    }
  }
  
  public void e()
  {
    a(false);
  }
  
  public void e(Animator paramAnimator) {}
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    a();
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.q == 0) || (this.r == 0))
    {
      Rect localRect = new Rect();
      getWindowVisibleDisplayFrame(localRect);
      this.q = localRect.width();
      this.r = localRect.height();
      setCurPosition(this.s);
    }
  }
  
  public void setCurPosition(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SmallScreenRelativeLayout", 2, "WL_DEBUG setCurPosition position = " + paramInt);
      QLog.d("SmallScreenRelativeLayout", 2, "WL_DEBUG setCurPosition mScreenWidth = " + this.q);
      QLog.d("SmallScreenRelativeLayout", 2, "WL_DEBUG setCurPosition mScreenHeight = " + this.r);
    }
    this.s = paramInt;
    Point localPoint;
    if ((this.q != 0) && (this.r != 0))
    {
      localPoint = a(paramInt);
      if ((this.p % 2 != 0) && (this.jdField_a_of_type_Boolean)) {
        break label179;
      }
      paramInt = this.jdField_c_of_type_Int;
    }
    for (int i1 = this.jdField_d_of_type_Int; this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$FloatListener != null; i1 = this.jdField_c_of_type_Int)
    {
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$FloatListener.a(this, localPoint.x, localPoint.y, paramInt + localPoint.x, localPoint.y + i1);
      return;
      label179:
      paramInt = this.jdField_d_of_type_Int;
    }
    layout(localPoint.x, localPoint.y, localPoint.x + paramInt, i1 + localPoint.y);
  }
  
  public void setFloatListener(SmallScreenRelativeLayout.FloatListener paramFloatListener)
  {
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$FloatListener = paramFloatListener;
  }
  
  public void setIsRotateSize(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setSize(int paramInt1, int paramInt2)
  {
    this.jdField_c_of_type_Int = paramInt1;
    this.jdField_d_of_type_Int = paramInt2;
  }
  
  public void setTitleHeight(int paramInt)
  {
    this.g = paramInt;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\smallscreen\SmallScreenRelativeLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */