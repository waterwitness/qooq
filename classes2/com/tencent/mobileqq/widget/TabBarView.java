package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.accessibility.AccessibilityManager;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.qphone.base.util.BaseApplication;
import woq;
import wor;

public class TabBarView
  extends LinearLayout
{
  private static final int jdField_a_of_type_Int;
  public static final String a;
  private static final int b;
  private static final int c = 15;
  private static final int o = 10;
  private static final int p = 0;
  private static final int q = 1;
  private static final int r = 2;
  private float jdField_a_of_type_Float;
  public long a;
  public final Paint a;
  private Handler jdField_a_of_type_AndroidOsHandler = new woq(this);
  private LinearLayout.LayoutParams jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams;
  public TabBarView.OnTabChangeListener a;
  private boolean jdField_a_of_type_Boolean;
  private int d = jdField_a_of_type_Int;
  private int e = b;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l = c;
  private int m = -1;
  private int n = -1;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = TabBarView.class.getSimpleName();
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    jdField_a_of_type_Int = (int)(46.0F * localBaseApplication.getResources().getDisplayMetrics().density + 0.5F);
    b = (int)(localBaseApplication.getResources().getDisplayMetrics().density * 3.0F + 0.5F);
  }
  
  public TabBarView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TabBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Long = 0L;
    this.f = paramContext.getResources().getColor(2131428268);
    this.g = paramContext.getResources().getColor(2131428302);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.f);
    this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams = new LinearLayout.LayoutParams(0, -1);
    this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams.weight = 1.0F;
    this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams.gravity = 17;
    setBackgroundDrawable(getResources().getDrawable(2130843316));
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView$OnTabChangeListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView$OnTabChangeListener.a(paramInt1, paramInt2);
    }
  }
  
  private void b(int paramInt)
  {
    Object localObject = (AccessibilityManager)getContext().getSystemService("accessibility");
    if ((localObject != null) && (((AccessibilityManager)localObject).isEnabled()))
    {
      int i2 = getChildCount();
      int i1 = 0;
      if (i1 < i2)
      {
        localObject = a(i1);
        if (localObject != null)
        {
          if (i1 != paramInt) {
            break label105;
          }
          ((RedDotTextView)localObject).setContentDescription(getContext().getString(2131362094) + ((RedDotTextView)localObject).getText() + getContext().getString(2131362093));
        }
        for (;;)
        {
          i1 += 1;
          break;
          label105:
          ((RedDotTextView)localObject).setContentDescription(((RedDotTextView)localObject).getText() + getContext().getString(2131362093));
        }
      }
    }
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    View localView = getChildAt(paramInt1);
    if (localView != null)
    {
      if (!(localView instanceof TextView)) {
        break label57;
      }
      ((TextView)localView).setTextColor(this.g);
    }
    label57:
    do
    {
      for (;;)
      {
        localView = getChildAt(paramInt2);
        if (localView != null)
        {
          if (!(localView instanceof TextView)) {
            break;
          }
          ((TextView)localView).setTextColor(this.f);
        }
        return;
        if (((localView instanceof RedTouch)) && ((((RedTouch)localView).a() instanceof TextView))) {
          ((TextView)((RedTouch)localView).a()).setTextColor(this.g);
        }
      }
    } while ((!(localView instanceof RedTouch)) || (!(((RedTouch)localView).a() instanceof TextView)));
    ((TextView)((RedTouch)localView).a()).setTextColor(this.f);
  }
  
  public int a()
  {
    return this.n;
  }
  
  public RedDotTextView a(int paramInt)
  {
    View localView = getChildAt(paramInt);
    if ((localView instanceof RedDotTextView)) {
      return (RedDotTextView)localView;
    }
    return null;
  }
  
  public RedDotTextView a(int paramInt, String paramString)
  {
    if ((paramInt < 0) || (paramInt > getChildCount())) {
      throw new IllegalArgumentException("position is not legal, please check!");
    }
    RedDotTextView localRedDotTextView = new RedDotTextView(getContext());
    localRedDotTextView.setText(paramString);
    localRedDotTextView.setTextSize(2, this.l);
    localRedDotTextView.setTextColor(this.g);
    localRedDotTextView.setPadding(this.h, this.j, this.i, this.k);
    localRedDotTextView.setSingleLine();
    localRedDotTextView.setFocusable(true);
    localRedDotTextView.setContentDescription(paramString);
    localRedDotTextView.setGravity(17);
    localRedDotTextView.setOnClickListener(new wor(this, paramInt));
    addView(localRedDotTextView, paramInt, this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams);
    return localRedDotTextView;
  }
  
  public RedDotTextView a(String paramString)
  {
    return a(getChildCount(), paramString);
  }
  
  public void a()
  {
    this.n = -1;
  }
  
  public void a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= getChildCount())) {
      throw new IllegalArgumentException("index is not legal, please check!");
    }
    removeViewAt(paramInt);
  }
  
  public void a(int paramInt, String paramString)
  {
    if ((paramInt >= getChildCount()) || (paramInt < 0)) {}
    View localView;
    do
    {
      return;
      localView = getChildAt(paramInt);
    } while ((localView == null) || (!(localView instanceof TextView)));
    ((TextView)localView).setText(paramString);
  }
  
  public int b()
  {
    return this.d;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    View localView1 = getChildAt(this.n);
    if (localView1 != null)
    {
      int i3 = localView1.getLeft();
      int i4 = localView1.getRight();
      int i2 = i4;
      int i1 = i3;
      if (this.jdField_a_of_type_Float > 0.0F)
      {
        View localView2 = getChildAt(this.m);
        i2 = i4;
        i1 = i3;
        if (localView2 != null)
        {
          i1 = (int)(localView1.getLeft() + this.jdField_a_of_type_Float * (localView2.getLeft() - localView1.getLeft()));
          float f1 = localView1.getRight();
          float f2 = this.jdField_a_of_type_Float;
          i2 = (int)(f1 + (localView2.getRight() - localView1.getRight()) * f2);
        }
      }
      paramCanvas.drawRect(i1, getHeight() - this.e, i2, getHeight(), this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.d, 1073741824));
    setMeasuredDimension(getMeasuredWidth(), this.d);
  }
  
  public void setEnableRepeatedClick(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setOnTabChangeListener(TabBarView.OnTabChangeListener paramOnTabChangeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView$OnTabChangeListener = paramOnTabChangeListener;
  }
  
  public void setSelectColor(int paramInt)
  {
    this.f = paramInt;
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.f);
  }
  
  public void setSelectedTab(int paramInt, boolean paramBoolean)
  {
    int i1 = paramInt;
    if (paramInt < 0) {
      i1 = 0;
    }
    int i2 = getChildCount();
    paramInt = i1;
    if (i1 >= i2) {
      paramInt = i2 - 1;
    }
    if (this.n != paramInt)
    {
      if (this.n == -1) {
        paramBoolean = false;
      }
      if (paramBoolean)
      {
        this.jdField_a_of_type_Float = 0.0F;
        this.m = paramInt;
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
      }
    }
    while (!this.jdField_a_of_type_Boolean)
    {
      return;
      b(paramInt);
      a(this.n, paramInt);
      this.m = paramInt;
      this.jdField_a_of_type_Float = 1.0F;
      b(this.n, paramInt);
      invalidate();
      this.n = paramInt;
      return;
    }
    a(this.n, this.n);
  }
  
  public void setTabHeight(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setTabLayoutParams(LinearLayout.LayoutParams paramLayoutParams)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams = paramLayoutParams;
  }
  
  public void setTabTextSize(int paramInt)
  {
    this.l = paramInt;
  }
  
  public void setTextPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.h = paramInt1;
    this.j = paramInt2;
    this.i = paramInt3;
    this.k = paramInt4;
  }
  
  public void setUnderLineHeight(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setUnselectColor(int paramInt)
  {
    this.g = paramInt;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\widget\TabBarView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */