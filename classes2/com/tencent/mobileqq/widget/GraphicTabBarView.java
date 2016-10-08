package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import wmd;

public class GraphicTabBarView
  extends LinearLayout
{
  private static final int b = (int)(BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density * 60.0F + 0.5F);
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new wmd(this);
  private LinearLayout.LayoutParams jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams;
  private GraphicTabBarView.OnTabChangeListener jdField_a_of_type_ComTencentMobileqqWidgetGraphicTabBarView$OnTabChangeListener;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public GraphicTabBarView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public GraphicTabBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams = new LinearLayout.LayoutParams(0, -2);
    this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams.weight = 1.0F;
    this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams.gravity = 17;
  }
  
  public RedDotTextView a(int paramInt)
  {
    if ((paramInt > -1) && (paramInt < getChildCount()))
    {
      View localView = getChildAt(paramInt);
      if ((localView instanceof RedDotTextView)) {
        return (RedDotTextView)localView;
      }
    }
    return null;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    RedDotTextView localRedDotTextView = a(paramInt1);
    if (localRedDotTextView != null)
    {
      Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(paramInt2);
      localDrawable.setBounds(0, 0, localDrawable.getMinimumWidth(), localDrawable.getMinimumHeight());
      localRedDotTextView.setCompoundDrawables(null, localDrawable, null, null);
      localRedDotTextView.setTextColor(paramInt3);
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt1 > getChildCount())) {
      throw new IllegalArgumentException("position is not legal, please check!");
    }
    RedDotTextView localRedDotTextView = new RedDotTextView(this.jdField_a_of_type_AndroidContentContext);
    localRedDotTextView.setText(paramString);
    localRedDotTextView.setTextSize(2, 12.0F);
    Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(paramInt2);
    localDrawable.setBounds(0, 0, localDrawable.getMinimumWidth(), localDrawable.getMinimumHeight());
    localRedDotTextView.setCompoundDrawables(null, localDrawable, null, null);
    if (paramInt1 == 0) {
      localRedDotTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131427602));
    }
    localRedDotTextView.setFocusable(true);
    localRedDotTextView.setContentDescription(paramString);
    localRedDotTextView.setTag(Integer.valueOf(paramInt1));
    localRedDotTextView.setGravity(17);
    localRedDotTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    addView(localRedDotTextView, paramInt1, this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(b, 1073741824));
    setMeasuredDimension(getMeasuredWidth(), b);
  }
  
  public void setOnTabChangeListener(GraphicTabBarView.OnTabChangeListener paramOnTabChangeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetGraphicTabBarView$OnTabChangeListener = paramOnTabChangeListener;
  }
  
  public void setTabSelected(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    int j = getChildCount();
    paramInt = i;
    if (i >= j) {
      paramInt = j - 1;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetGraphicTabBarView$OnTabChangeListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetGraphicTabBarView$OnTabChangeListener.a(this.jdField_a_of_type_Int, paramInt);
    }
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\widget\GraphicTabBarView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */