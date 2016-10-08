package com.tencent.mobileqq.activity.recent;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.Scroller;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import owr;

public class DrawerFrame
  extends FrameLayout
  implements Handler.Callback
{
  public static final int a = 0;
  public static final String a = "DrawerFrame";
  public static final boolean a;
  public static final int b = 1;
  public static final int c = 0;
  public static final int d = 1;
  public static final int e = 2;
  public static int f = 0;
  public static final int g = 1;
  public static final int h = 2;
  public static final int i = 3;
  public static final int j = 4;
  private static final int k = 300;
  private static final int l = 1;
  private static final int m = 2;
  private static final int n = 3;
  private static final int o = 4;
  private static final int p = 5;
  private static final int q = 0;
  private static final int r = 1;
  private static final int s = 2;
  private int A;
  private int B;
  private int C;
  private int D;
  private int E;
  private int F;
  private int G;
  private int H;
  private int I;
  private int J = 0;
  private int K = -1;
  private int L;
  private final float jdField_a_of_type_Float = 0.8F;
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private Scroller jdField_a_of_type_AndroidWidgetScroller;
  private DrawerFrame.IDrawerCallbacks jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder;
  private final float jdField_b_of_type_Float = 0.7F;
  private View jdField_b_of_type_AndroidViewView;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  public boolean b;
  private final float jdField_c_of_type_Float = 0.4F;
  private ViewGroup jdField_c_of_type_AndroidViewViewGroup;
  private boolean jdField_c_of_type_Boolean = true;
  private ViewGroup jdField_d_of_type_AndroidViewViewGroup;
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  private boolean f;
  private int t;
  private int u;
  private int v;
  private int w;
  private int x;
  private int y;
  private int z;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_Boolean = QLog.isDevelopLevel();
    jdField_f_of_type_Int = 0;
  }
  
  public DrawerFrame(Context paramContext, ViewGroup paramViewGroup1, ViewGroup paramViewGroup2, View paramView, ViewGroup paramViewGroup3)
  {
    super(paramContext);
    this.jdField_b_of_type_Boolean = true;
    if (paramContext == null) {
      throw new NullPointerException("context is null");
    }
    Resources localResources = paramContext.getResources();
    DisplayMetrics localDisplayMetrics = localResources.getDisplayMetrics();
    this.G = 0;
    this.A = ((int)(localDisplayMetrics.density * 100.0F + 0.5D));
    this.C = localResources.getDimensionPixelSize(2131493298);
    this.v = localResources.getDimensionPixelSize(2131493360);
    this.B = 0;
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(paramContext, new DrawerFrame.SmoothInterpolator());
    if ((paramContext instanceof Activity)) {}
    for (this.K = DeviceInfoUtil.a((Activity)paramContext);; this.K = paramContext.getResources().getConfiguration().orientation)
    {
      if (jdField_a_of_type_Boolean) {
        a("DrawerFrame", null);
      }
      a(paramViewGroup1, paramViewGroup2, paramView, paramViewGroup3);
      b(this.J, 1);
      return;
    }
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    this.G = 2;
    if (!this.jdField_d_of_type_Boolean)
    {
      b(paramInt, paramBoolean);
      return;
    }
    a(paramBoolean);
  }
  
  private void a(String paramString, Object paramObject)
  {
    if (QLog.isDevelopLevel())
    {
      if (this.jdField_a_of_type_JavaLangStringBuilder != null) {
        break label142;
      }
      this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder(120);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaLangStringBuilder.append(paramString).append(", mConfigurationFlag = ").append(this.L).append(", mCurOrientation = ").append(this.K).append(", mDecorOffsetX = ").append(this.t).append(", mLeftDrawerWidth = ").append(this.u).append(", mConfigurationFlag = ").append(this.L).append(", mWidth = ").append(this.H).append(", mHeight =").append(this.I).append(", param = ").append(paramObject);
      QLog.i("DrawerFrame", 4, this.jdField_a_of_type_JavaLangStringBuilder.toString());
      return;
      label142:
      this.jdField_a_of_type_JavaLangStringBuilder.setLength(0);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (!d()) {
      return;
    }
    Scroller localScroller;
    int i2;
    int i3;
    if (this.e)
    {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(1);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(2);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(4);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(3);
      this.e = true;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks.a(this.J);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks.a(this.J, false);
      }
      localScroller = this.jdField_a_of_type_AndroidWidgetScroller;
      i2 = this.t;
      i3 = -this.t;
      if (!paramBoolean) {
        break label148;
      }
    }
    label148:
    for (int i1 = 300;; i1 = 0)
    {
      localScroller.startScroll(i2, 0, i3, 0, i1);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(2);
      return;
      if (this.jdField_d_of_type_Boolean) {
        break;
      }
      return;
    }
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    int i2 = 0;
    int i1;
    if (paramInt2 == 1)
    {
      i1 = 8;
      if ((this.jdField_d_of_type_AndroidViewViewGroup != null) && (this.jdField_d_of_type_AndroidViewViewGroup.getVisibility() != i1)) {
        this.jdField_d_of_type_AndroidViewViewGroup.setVisibility(i1);
      }
      if ((paramInt2 != 1) && (paramInt1 != 1)) {
        break label153;
      }
      i1 = 8;
      label50:
      if ((this.jdField_c_of_type_AndroidViewViewGroup != null) && (this.jdField_c_of_type_AndroidViewViewGroup.getVisibility() != i1)) {
        this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(i1);
      }
      if ((paramInt2 != 1) && (paramInt1 != 0)) {
        break label158;
      }
      paramInt1 = 8;
      label88:
      if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() != paramInt1)) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(paramInt1);
      }
      if (paramInt2 != 0) {
        break label163;
      }
    }
    label153:
    label158:
    label163:
    for (paramInt1 = i2;; paramInt1 = 8)
    {
      if ((this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidViewView.getVisibility() != paramInt1)) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(paramInt1);
      }
      return;
      i1 = 0;
      break;
      i1 = 0;
      break label50;
      paramInt1 = 0;
      break label88;
    }
  }
  
  private void b(int paramInt, boolean paramBoolean)
  {
    int i1 = 300;
    if (!d()) {
      return;
    }
    this.J = paramInt;
    if (this.e)
    {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(1);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(2);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(4);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(3);
      label57:
      if (this.J != 0) {
        break label156;
      }
      this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(0);
    }
    for (;;)
    {
      this.e = true;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks.a(this.J);
      }
      switch (paramInt)
      {
      default: 
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks.a(paramInt, true);
        }
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(1);
        return;
        if (!this.jdField_d_of_type_Boolean) {
          break label57;
        }
        return;
        label156:
        if (this.J == 1) {
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        }
        break;
      }
    }
    Scroller localScroller = this.jdField_a_of_type_AndroidWidgetScroller;
    int i2 = this.t;
    int i3 = this.u;
    int i4 = this.t;
    if (paramBoolean) {}
    for (;;)
    {
      localScroller.startScroll(i2, 0, i3 - i4, 0, i1);
      break;
      i1 = 1;
    }
    localScroller = this.jdField_a_of_type_AndroidWidgetScroller;
    i2 = this.t;
    i3 = -this.v;
    i4 = this.t;
    if (paramBoolean) {}
    for (;;)
    {
      localScroller.startScroll(i2, 0, i3 - i4, 0, i1);
      break;
      i1 = 1;
    }
  }
  
  private boolean d()
  {
    return (this.jdField_c_of_type_Boolean) && (this.jdField_c_of_type_AndroidViewViewGroup != null) && (this.jdField_a_of_type_AndroidViewViewGroup != null);
  }
  
  private boolean e()
  {
    if ((this.K == 1) && (this.H > this.I)) {}
    while ((this.K == 0) && (this.H < this.I)) {
      return false;
    }
    return true;
  }
  
  public int a()
  {
    return this.A;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public DrawerFrame.IDrawerCallbacks a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks;
  }
  
  public void a()
  {
    a(0, true);
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    b(paramInt1, 2);
    float f1;
    float f2;
    if (Build.VERSION.SDK_INT >= 11)
    {
      if (paramInt1 != 0) {
        break label86;
      }
      f1 = paramInt2 / this.u;
      if (paramInt1 != 0) {
        break label99;
      }
      f2 = this.A * (f1 - 1.0F);
      label42:
      if (paramInt1 != 0) {
        break label114;
      }
    }
    label86:
    label99:
    label114:
    for (Object localObject = this.jdField_c_of_type_AndroidViewViewGroup;; localObject = this.jdField_a_of_type_AndroidViewView)
    {
      if (localObject != null) {
        ((View)localObject).setTranslationX(f2);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks.a(this.J, f1);
      }
      return;
      f1 = -paramInt2 / this.v;
      break;
      f2 = -this.A * (f1 - 1.0F);
      break label42;
    }
  }
  
  public void a(ViewGroup paramViewGroup1, ViewGroup paramViewGroup2, View paramView, ViewGroup paramViewGroup3)
  {
    if (paramViewGroup3 != this.jdField_d_of_type_AndroidViewViewGroup)
    {
      if (this.jdField_d_of_type_AndroidViewViewGroup != null) {
        removeView(this.jdField_d_of_type_AndroidViewViewGroup);
      }
      this.jdField_d_of_type_AndroidViewViewGroup = paramViewGroup3;
      if (this.jdField_d_of_type_AndroidViewViewGroup != null)
      {
        paramViewGroup3 = new FrameLayout.LayoutParams(-1, -1);
        addView(this.jdField_d_of_type_AndroidViewViewGroup, paramViewGroup3);
      }
    }
    if (paramViewGroup2 != this.jdField_c_of_type_AndroidViewViewGroup)
    {
      if (this.jdField_c_of_type_AndroidViewViewGroup != null) {
        removeView(this.jdField_c_of_type_AndroidViewViewGroup);
      }
      this.jdField_c_of_type_AndroidViewViewGroup = paramViewGroup2;
      if (this.jdField_c_of_type_AndroidViewViewGroup != null)
      {
        paramViewGroup2 = new FrameLayout.LayoutParams(-1, -1, 19);
        addView(this.jdField_c_of_type_AndroidViewViewGroup, paramViewGroup2);
      }
    }
    if (paramView != this.jdField_a_of_type_AndroidViewView)
    {
      if (this.jdField_a_of_type_AndroidViewView != null) {
        removeView(this.jdField_a_of_type_AndroidViewView);
      }
      this.jdField_a_of_type_AndroidViewView = paramView;
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        paramViewGroup2 = new FrameLayout.LayoutParams(-2, -1, 21);
        addView(this.jdField_a_of_type_AndroidViewView, paramViewGroup2);
      }
    }
    if (paramViewGroup1 != this.jdField_a_of_type_AndroidViewViewGroup)
    {
      if (this.jdField_a_of_type_AndroidViewViewGroup != null)
      {
        removeView(this.jdField_a_of_type_AndroidViewViewGroup);
        if (this.jdField_b_of_type_AndroidViewViewGroup != null)
        {
          this.jdField_b_of_type_AndroidViewViewGroup.removeView(this);
          this.jdField_b_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_AndroidViewViewGroup);
          this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(null);
          this.jdField_b_of_type_AndroidViewViewGroup = null;
        }
      }
      this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup1;
      AccessibilityUtil.b(this.jdField_a_of_type_AndroidViewViewGroup, true);
      if (this.jdField_a_of_type_AndroidViewViewGroup != null)
      {
        paramViewGroup1 = this.jdField_a_of_type_AndroidViewViewGroup.getParent();
        if (!(paramViewGroup1 instanceof ViewGroup)) {
          break label446;
        }
        this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)paramViewGroup1);
        this.jdField_b_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_AndroidViewViewGroup);
      }
    }
    for (;;)
    {
      paramViewGroup1 = new FrameLayout.LayoutParams(-1, -1);
      addView(this.jdField_a_of_type_AndroidViewViewGroup, paramViewGroup1);
      if (this.jdField_b_of_type_AndroidViewViewGroup != null)
      {
        this.jdField_b_of_type_AndroidViewViewGroup.addView(this);
        this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(new owr(this));
      }
      if ((this.jdField_c_of_type_AndroidViewViewGroup != null) && (this.jdField_b_of_type_AndroidViewView == null))
      {
        this.jdField_b_of_type_AndroidViewView = new View(getContext());
        this.jdField_b_of_type_AndroidViewView.setFocusable(true);
        this.jdField_b_of_type_AndroidViewView.setFocusableInTouchMode(true);
        this.jdField_b_of_type_AndroidViewView.setClickable(true);
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        this.jdField_b_of_type_AndroidViewView.setBackgroundResource(17170445);
        this.jdField_b_of_type_AndroidViewView.setContentDescription("返回 按钮");
        paramViewGroup1 = new FrameLayout.LayoutParams(this.u, this.D, 21);
        addView(this.jdField_b_of_type_AndroidViewView, paramViewGroup1);
      }
      return;
      label446:
      this.jdField_b_of_type_AndroidViewViewGroup = null;
    }
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public int b()
  {
    return this.C;
  }
  
  public void b()
  {
    a(1, true);
  }
  
  public boolean b()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public void c()
  {
    b(0, true);
  }
  
  public boolean c()
  {
    return this.e;
  }
  
  public void d()
  {
    b(1, true);
  }
  
  public void e()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("DrawerFrame", 4, "resetDrawer()");
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(1);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(2);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(4);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(3);
    this.e = false;
    this.J = 0;
    this.t = 0;
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.offsetLeftAndRight(0 - this.jdField_a_of_type_AndroidViewViewGroup.getLeft());
    }
    a(this.J, this.t);
    postInvalidate();
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_d_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(4);
    }
    b(this.J, 1);
    jdField_f_of_type_Int = 0;
  }
  
  public void f()
  {
    a(true);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i1 = 0;
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          return true;
          boolean bool = this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset();
          i1 = this.jdField_a_of_type_AndroidWidgetScroller.getCurrX();
          int i2 = this.t;
          this.t = this.jdField_a_of_type_AndroidWidgetScroller.getCurrX();
          if (this.jdField_a_of_type_AndroidViewViewGroup != null)
          {
            this.jdField_a_of_type_AndroidViewViewGroup.offsetLeftAndRight(i1 - i2);
            a(this.J, this.t);
          }
          postInvalidate();
          if (!bool)
          {
            this.e = false;
            this.jdField_d_of_type_Boolean = true;
            this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(3);
            return true;
          }
          this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(1);
          return true;
          bool = this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset();
          i1 = this.jdField_a_of_type_AndroidWidgetScroller.getCurrX();
          i2 = this.t;
          this.t = this.jdField_a_of_type_AndroidWidgetScroller.getCurrX();
          if (this.jdField_a_of_type_AndroidViewViewGroup != null)
          {
            this.jdField_a_of_type_AndroidViewViewGroup.offsetLeftAndRight(i1 - i2);
            a(this.J, this.t);
          }
          postInvalidate();
          if (!bool)
          {
            this.e = false;
            this.jdField_d_of_type_Boolean = false;
            if (this.jdField_c_of_type_AndroidViewViewGroup != null) {
              this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(8);
            }
            if (this.jdField_a_of_type_AndroidViewView != null) {
              this.jdField_a_of_type_AndroidViewView.setVisibility(8);
            }
            this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(4);
            return true;
          }
          this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(2);
          return true;
        } while (this.e);
        AccessibilityUtil.b(this.jdField_a_of_type_AndroidViewViewGroup, true);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks.b(this.J, this.G);
        }
        this.G = 0;
        this.J = 0;
        b(this.J, 1);
        return true;
      } while (this.e);
      AccessibilityUtil.b(this.jdField_a_of_type_AndroidViewViewGroup, false);
      b(this.J, 0);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks.a(this.J, this.G);
      }
      this.G = 0;
      return true;
    } while (!b());
    if (this.J == 0)
    {
      i1 = this.u - this.t;
      this.t = this.u;
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_AndroidViewViewGroup != null) && (i1 != 0))
      {
        this.jdField_a_of_type_AndroidViewViewGroup.offsetLeftAndRight(i1);
        a(this.J, this.t);
        postInvalidate();
      }
      if (!jdField_a_of_type_Boolean) {
        break;
      }
      a("MSG_CONFIGURATION_CHANGED", Integer.valueOf(i1));
      return true;
      if (this.J == 1)
      {
        i1 = -this.v - this.t;
        this.t = (-this.v);
      }
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (paramConfiguration.orientation != this.K)
    {
      this.K = paramConfiguration.orientation;
      if ((b()) && (this.L == 0)) {
        this.L = 1;
      }
      if (jdField_a_of_type_Boolean) {
        a("onConfigurationChanged", Boolean.valueOf(b()));
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2;
    if (!d()) {
      bool2 = bool1;
    }
    int i1;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return bool2;
              bool2 = bool1;
            } while (!this.jdField_b_of_type_Boolean);
            i1 = ViewConfiguration.get(getContext()).getScaledTouchSlop();
            i2 = (int)(paramMotionEvent.getX() + 0.5F);
            i3 = (int)(paramMotionEvent.getY() + 0.5F);
            switch (paramMotionEvent.getAction())
            {
            default: 
              return false;
            case 0: 
              this.x = i2;
              this.w = i2;
              this.z = i3;
              this.y = i3;
              if ((!this.jdField_d_of_type_Boolean) || (this.w > this.B)) {
                this.jdField_f_of_type_Boolean = true;
              }
              bool2 = bool1;
            }
          } while (!this.e);
          if ((this.J == 0) && (this.w > this.t)) {
            break;
          }
          bool2 = bool1;
        } while (this.J != 1);
        bool2 = bool1;
      } while (this.w >= this.H + this.t);
      this.jdField_f_of_type_Boolean = true;
      return true;
      bool2 = bool1;
    } while (!this.jdField_f_of_type_Boolean);
    if ((!this.jdField_d_of_type_Boolean) && ((i2 < this.x) || (i2 < this.w)))
    {
      this.jdField_f_of_type_Boolean = false;
      return false;
    }
    this.x = i2;
    this.z = i3;
    int i2 = Math.abs(this.x - this.w);
    int i3 = Math.abs(this.z - this.y);
    if (this.jdField_d_of_type_Boolean)
    {
      bool1 = bool3;
      if (i2 > i1) {
        bool1 = true;
      }
    }
    for (;;)
    {
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      bool2 = bool1;
      if (!this.e) {
        break;
      }
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(1);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(2);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(4);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(3);
      return bool1;
      bool1 = bool3;
      if (i2 > i1)
      {
        bool1 = bool3;
        if ((i3 + 0.0F) / i2 < 0.6F) {
          bool1 = true;
        }
      }
    }
    this.jdField_f_of_type_Boolean = false;
    if (((this.jdField_d_of_type_Boolean) && (this.J == 0) && (this.w > this.u)) || ((this.J == 1) && (this.w < this.H - this.v)))
    {
      this.G = 3;
      if ((this.y >= this.E) && (this.y <= this.F)) {
        this.G = 4;
      }
      f();
      this.x = -1;
      this.w = -1;
      this.z = -1;
      this.y = -1;
      return true;
    }
    this.x = -1;
    this.w = -1;
    this.z = -1;
    this.y = -1;
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.jdField_d_of_type_AndroidViewViewGroup != null) && (this.jdField_d_of_type_AndroidViewViewGroup.getVisibility() != 8)) {
      this.jdField_d_of_type_AndroidViewViewGroup.layout(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    if ((this.jdField_c_of_type_AndroidViewViewGroup != null) && (this.jdField_c_of_type_AndroidViewViewGroup.getVisibility() != 8)) {
      this.jdField_c_of_type_AndroidViewViewGroup.layout(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() != 8)) {
      this.jdField_a_of_type_AndroidViewView.layout(paramInt3 - this.v, this.E, paramInt3, this.F);
    }
    if ((this.jdField_a_of_type_AndroidViewViewGroup != null) && (this.jdField_a_of_type_AndroidViewViewGroup.getVisibility() != 8)) {
      this.jdField_a_of_type_AndroidViewViewGroup.layout(this.jdField_a_of_type_AndroidViewViewGroup.getLeft(), this.jdField_a_of_type_AndroidViewViewGroup.getTop(), this.jdField_a_of_type_AndroidViewViewGroup.getLeft() + paramInt3, paramInt4);
    }
    if ((this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidViewView.getVisibility() != 8))
    {
      if (this.J != 0) {
        break label270;
      }
      this.jdField_b_of_type_AndroidViewView.layout(this.u, this.E, this.u + this.C, this.F);
    }
    label270:
    do
    {
      while (e())
      {
        if (this.L == 2)
        {
          this.L = 0;
          if (!this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.hasMessages(5)) {
            this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(5);
          }
          if (jdField_a_of_type_Boolean) {
            a("onLayout", "valid orientation");
          }
        }
        return;
        if (this.J == 1) {
          this.jdField_b_of_type_AndroidViewView.layout(0, this.E, paramInt3 - this.v, this.F);
        }
      }
    } while (!jdField_a_of_type_Boolean);
    a("onLayout", "not valid orientation");
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.H = getMeasuredWidth();
    this.I = getMeasuredHeight();
    this.u = (this.H - this.C);
    if (Build.VERSION.SDK_INT >= 11)
    {
      this.D = ((int)(this.I * 0.8F + 0.5D));
      this.E = ((int)(this.I * 0.19999999F / 2.0F));
      this.F = (this.E + this.D);
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidViewView.getLayoutParams().height = this.D;
      }
      if (!e()) {
        break label177;
      }
      if (this.L == 1)
      {
        this.L = 2;
        if (jdField_a_of_type_Boolean) {
          a("onMeasure", "valid orientation");
        }
      }
    }
    label177:
    while (!jdField_a_of_type_Boolean)
    {
      return;
      this.D = this.I;
      this.E = 0;
      this.F = (this.E + this.D);
      break;
    }
    a("onMeasure", "not valid orientation");
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!d()) {}
    while (!this.jdField_b_of_type_Boolean) {
      return false;
    }
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(getContext());
    int i1 = (int)(paramMotionEvent.getX() + 0.5F);
    int i2 = (int)(paramMotionEvent.getY() + 0.5F);
    int i3 = i1 - this.x;
    int i4 = this.z;
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    }
    this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
    this.x = i1;
    this.z = i2;
    switch (paramMotionEvent.getAction())
    {
    default: 
      return false;
    case 0: 
      if (this.e)
      {
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(1);
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(2);
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(4);
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(3);
      }
    case 2: 
      boolean bool = this.e;
      this.e = true;
      if ((!bool) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks != null)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks.a(this.J);
      }
      this.G = 1;
      if ((this.J == 0) && (this.t + i3 > this.u)) {
        if (this.t != this.u)
        {
          this.jdField_d_of_type_Boolean = true;
          this.jdField_a_of_type_AndroidViewViewGroup.offsetLeftAndRight(this.u - this.t);
          this.t = this.u;
          a(this.J, this.t);
          invalidate();
        }
      }
      for (;;)
      {
        return true;
        if ((this.J == 0) && (this.t + i3 < 0))
        {
          if (this.t != 0)
          {
            this.jdField_d_of_type_Boolean = false;
            this.jdField_a_of_type_AndroidViewViewGroup.offsetLeftAndRight(0 - this.jdField_a_of_type_AndroidViewViewGroup.getLeft());
            this.t = 0;
            a(this.J, this.t);
            invalidate();
          }
        }
        else if ((this.J == 1) && (this.t + i3 < -this.v))
        {
          if (this.t != -this.v)
          {
            this.jdField_d_of_type_Boolean = true;
            this.jdField_a_of_type_AndroidViewViewGroup.offsetLeftAndRight(-this.v - this.t);
            this.t = (-this.v);
            a(this.J, this.t);
            invalidate();
          }
        }
        else if ((this.J == 1) && (this.t + i3 > 0))
        {
          if (this.t != 0)
          {
            this.jdField_d_of_type_Boolean = false;
            this.jdField_a_of_type_AndroidViewViewGroup.offsetLeftAndRight(0 - this.jdField_a_of_type_AndroidViewViewGroup.getLeft());
            this.t = 0;
            a(this.J, this.t);
            invalidate();
          }
        }
        else
        {
          this.jdField_a_of_type_AndroidViewViewGroup.offsetLeftAndRight(i3);
          this.t += i3;
          a(this.J, this.t);
          invalidate();
        }
      }
    }
    this.jdField_f_of_type_Boolean = false;
    this.e = false;
    this.jdField_a_of_type_AndroidViewVelocityTracker.computeCurrentVelocity(1000);
    if (Math.abs(this.jdField_a_of_type_AndroidViewVelocityTracker.getXVelocity()) > localViewConfiguration.getScaledMinimumFlingVelocity()) {
      if (this.J == 0) {
        if (this.jdField_a_of_type_AndroidViewVelocityTracker.getXVelocity() > 0.0F)
        {
          this.jdField_d_of_type_Boolean = false;
          c();
        }
      }
    }
    for (;;)
    {
      return true;
      this.jdField_d_of_type_Boolean = true;
      f();
      continue;
      if (this.jdField_a_of_type_AndroidViewVelocityTracker.getXVelocity() < 0.0F)
      {
        this.jdField_d_of_type_Boolean = false;
        d();
      }
      else
      {
        this.jdField_d_of_type_Boolean = true;
        f();
        continue;
        if (this.J == 0)
        {
          if (this.t > this.H / 2.0D)
          {
            this.jdField_d_of_type_Boolean = false;
            c();
          }
          else
          {
            this.jdField_d_of_type_Boolean = true;
            f();
          }
        }
        else if (this.t < -(this.v / 3.0D * 2.0D))
        {
          this.jdField_d_of_type_Boolean = false;
          d();
        }
        else
        {
          this.jdField_d_of_type_Boolean = true;
          f();
        }
      }
    }
  }
  
  public void setDrawerCallbacks(DrawerFrame.IDrawerCallbacks paramIDrawerCallbacks)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks = paramIDrawerCallbacks;
  }
  
  public void setDrawerEnabled(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\recent\DrawerFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */