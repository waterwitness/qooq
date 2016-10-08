package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Scroller;
import android.widget.TextView;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.AbsSpinner;

public class HorizontalItemIndicator
  extends ViewGroup
{
  private static final int jdField_a_of_type_Int = 6;
  private static final int b = 8;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private Scroller jdField_a_of_type_AndroidWidgetScroller = new Scroller(getContext());
  private HorizontalItemIndicator.OnItemChanged jdField_a_of_type_ComTencentMobileqqWidgetHorizontalItemIndicator$OnItemChanged;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  
  public HorizontalItemIndicator(Context paramContext)
  {
    this(paramContext, null);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public HorizontalItemIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public HorizontalItemIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, R.styleable.K, paramInt, 0);
    try
    {
      this.c = paramContext.getColor(1, -1711276033);
      this.d = paramContext.getDimensionPixelSize(0, 28);
      this.f = paramContext.getColor(2, -1);
      paramContext.recycle();
      this.e = this.d;
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
      setWillNotDraw(false);
      return;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  private TextView a()
  {
    TextView localTextView = new TextView(getContext());
    localTextView.setTextColor(this.c);
    localTextView.setTextSize(0, this.d);
    localTextView.setSingleLine();
    ViewGroup.MarginLayoutParams localMarginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
    localMarginLayoutParams.leftMargin = 10;
    localMarginLayoutParams.rightMargin = 10;
    localMarginLayoutParams.topMargin = 10;
    localMarginLayoutParams.bottomMargin = 20;
    localTextView.setLayoutParams(localMarginLayoutParams);
    return localTextView;
  }
  
  private TextView a(int paramInt)
  {
    return (TextView)getChildAt(paramInt);
  }
  
  public int a()
  {
    return this.g;
  }
  
  public HorizontalItemIndicator.OnItemChanged a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWidgetHorizontalItemIndicator$OnItemChanged;
  }
  
  public void a()
  {
    int i = this.g + 1;
    if (i >= getChildCount()) {
      return;
    }
    a(i);
  }
  
  public void a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= getChildCount())) {}
    while ((!this.jdField_a_of_type_AndroidWidgetScroller.isFinished()) || (paramInt == this.g)) {
      return;
    }
    int i = getChildAt(this.g).getMeasuredWidth() / 2 + getChildAt(this.g).getLeft();
    int j = getChildAt(paramInt).getMeasuredWidth() / 2;
    int k = getChildAt(paramInt).getLeft();
    this.h = this.g;
    this.g = paramInt;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetHorizontalItemIndicator$OnItemChanged != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetHorizontalItemIndicator$OnItemChanged.a(paramInt);
    }
    this.jdField_a_of_type_AndroidWidgetScroller.startScroll(i, 0, j + k - i, 0);
    requestLayout();
  }
  
  public void a(int paramInt, String paramString)
  {
    TextView localTextView = a();
    localTextView.setText(paramString);
    addView(localTextView, paramInt);
  }
  
  public void a(String paramString)
  {
    TextView localTextView = a();
    localTextView.setText(paramString);
    addView(localTextView);
  }
  
  public void a(String... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      a(paramVarArgs[i]);
      i += 1;
    }
  }
  
  public void b()
  {
    int i = this.g - 1;
    if (i < 0) {
      return;
    }
    a(i);
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    int i;
    if (this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset())
    {
      i = this.jdField_a_of_type_AndroidWidgetScroller.getCurrX();
      Log.i("tmp", "currMid is " + i);
      postInvalidate();
    }
    for (;;)
    {
      int j = getMeasuredWidth() / 2;
      paramCanvas.save();
      paramCanvas.translate(j - i, 0.0F);
      super.dispatchDraw(paramCanvas);
      paramCanvas.restore();
      paramCanvas.drawCircle(j, getChildAt(0).getBottom() + 8 + 6, 6.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
      return;
      i = getChildAt(this.g).getMeasuredWidth() / 2 + getChildAt(this.g).getLeft();
      if (this.h != this.g)
      {
        localTextView = a(this.h);
        localTextView.setTextSize(0, this.d);
        localTextView.setTextColor(this.c);
      }
      TextView localTextView = a(this.g);
      localTextView.setTextSize(0, this.e);
      localTextView.setTextColor(this.f);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt3 = getChildCount();
    paramInt2 = getPaddingLeft();
    paramInt1 = 0;
    while (paramInt1 < paramInt3)
    {
      View localView = getChildAt(paramInt1);
      paramInt4 = localView.getMeasuredWidth();
      int i = localView.getMeasuredHeight();
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localView.getLayoutParams();
      paramInt2 += localMarginLayoutParams.leftMargin;
      int j = getPaddingTop() + localMarginLayoutParams.topMargin;
      localView.layout(paramInt2, j, paramInt2 + paramInt4, i + j);
      paramInt2 = paramInt2 + paramInt4 + localMarginLayoutParams.rightMargin;
      paramInt1 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int n = getChildCount();
    measureChildren(paramInt1, paramInt2);
    int k = 0;
    int j = 0;
    int i = 0;
    int m;
    int i1;
    if (k < n)
    {
      View localView = getChildAt(k);
      if (localView.getVisibility() == 8) {
        break label264;
      }
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localView.getLayoutParams();
      m = localMarginLayoutParams.leftMargin;
      i1 = localMarginLayoutParams.rightMargin;
      int i2 = localView.getMeasuredWidth();
      int i3 = localMarginLayoutParams.topMargin;
      i = Math.max(i, localMarginLayoutParams.bottomMargin + i3 + localView.getMeasuredHeight());
      m = j + (m + i1 + i2);
      j = i;
      i = m;
    }
    for (;;)
    {
      m = k + 1;
      k = j;
      j = i;
      i = k;
      k = m;
      break;
      n = getPaddingLeft();
      i1 = getPaddingRight();
      k = getPaddingTop();
      m = getPaddingBottom();
      j = Math.max(n + i1 + j, getSuggestedMinimumWidth());
      k = Math.max(k + m + i, getSuggestedMinimumHeight());
      if (Build.VERSION.SDK_INT >= 11)
      {
        paramInt1 = resolveSizeAndState(j, paramInt1, 0);
        i = resolveSizeAndState(k, paramInt2, 0);
        paramInt2 = paramInt1;
        paramInt1 = i;
      }
      for (;;)
      {
        setMeasuredDimension(paramInt2, paramInt1);
        return;
        i = AbsSpinner.a(j, paramInt1, 0);
        paramInt1 = AbsSpinner.a(k, paramInt2, 0);
        paramInt2 = i;
      }
      label264:
      m = i;
      i = j;
      j = m;
    }
  }
  
  public void setCurrItem(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= getChildCount())) {}
    while ((!this.jdField_a_of_type_AndroidWidgetScroller.isFinished()) || (paramInt == this.g)) {
      return;
    }
    this.h = this.g;
    this.g = paramInt;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetHorizontalItemIndicator$OnItemChanged != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetHorizontalItemIndicator$OnItemChanged.a(paramInt);
    }
    requestLayout();
  }
  
  public void setNextItem()
  {
    int i = this.g + 1;
    if (i >= getChildCount()) {
      return;
    }
    setCurrItem(i);
  }
  
  public void setOnItemChanged(HorizontalItemIndicator.OnItemChanged paramOnItemChanged)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetHorizontalItemIndicator$OnItemChanged = paramOnItemChanged;
  }
  
  public void setPrevItem()
  {
    int i = this.g - 1;
    if (i < 0) {
      return;
    }
    setCurrItem(i);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\widget\HorizontalItemIndicator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */