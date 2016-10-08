package com.tencent.mobileqq.nearby.flat.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class UIElementView
  extends View
  implements UIElementHost
{
  AbstractUIElement.OnClickListener jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasAbstractUIElement$OnClickListener;
  UIElement jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasUIElement;
  
  public UIElementView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public UIElementView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public UIElement a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasUIElement;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasUIElement.a(paramMotionEvent);
  }
  
  public void drawableStateChanged()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasUIElement != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasUIElement.f();
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasUIElement != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasUIElement.a(this);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasUIElement != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasUIElement.a(null);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = paramCanvas.getSaveCount();
    paramCanvas.save();
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasUIElement != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasUIElement.a(paramCanvas);
    }
    paramCanvas.restoreToCount(i);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasUIElement != null)
    {
      int i = getPaddingLeft();
      int j = getPaddingTop();
      int k = getPaddingRight();
      int m = getPaddingBottom();
      this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasUIElement.a(i, j, paramInt3 - paramInt1 - k, paramInt4 - paramInt2 - m);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = 0;
    int j;
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasUIElement != null)
    {
      int k = getPaddingLeft();
      i = getPaddingTop();
      int m = getPaddingRight();
      j = getPaddingBottom();
      int n = View.MeasureSpec.getSize(paramInt1);
      int i1 = View.MeasureSpec.getMode(paramInt1);
      paramInt1 = View.MeasureSpec.getSize(paramInt2);
      paramInt2 = View.MeasureSpec.getMode(paramInt2);
      n = View.MeasureSpec.makeMeasureSpec(n - k - m, i1);
      paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt1 - i - j, paramInt2);
      this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasUIElement.a(n, paramInt1);
      paramInt2 = m + (k + this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasUIElement.b());
    }
    for (paramInt1 = this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasUIElement.c() + i + j;; paramInt1 = i)
    {
      setMeasuredDimension(Math.max(paramInt2, getSuggestedMinimumWidth()), Math.max(paramInt1, getSuggestedMinimumHeight()));
      return;
      paramInt2 = 0;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasUIElement.b(paramMotionEvent);
  }
  
  public void setOnElementClickListener(AbstractUIElement.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasAbstractUIElement$OnClickListener = paramOnClickListener;
  }
  
  public void setUIElement(UIElement paramUIElement)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasUIElement == paramUIElement) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasUIElement != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasUIElement.a(null);
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasUIElement = paramUIElement;
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasUIElement != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasUIElement.a(this);
    }
    requestLayout();
    invalidate();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\flat\canvas\UIElementView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */