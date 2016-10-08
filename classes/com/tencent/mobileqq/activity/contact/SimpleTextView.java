package com.tencent.mobileqq.activity.contact;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DisplayUtils;

public class SimpleTextView
  extends View
{
  private int jdField_a_of_type_Int;
  private ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  private Paint.FontMetrics jdField_a_of_type_AndroidGraphicsPaint$FontMetrics;
  private final TextPaint jdField_a_of_type_AndroidTextTextPaint;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private int b;
  
  public SimpleTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SimpleTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangCharSequence = "";
    this.b = -1;
    Object localObject = getResources();
    this.jdField_a_of_type_AndroidTextTextPaint = new TextPaint(1);
    this.jdField_a_of_type_AndroidTextTextPaint.density = ((Resources)localObject).getDisplayMetrics().density;
    if (paramAttributeSet != null)
    {
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.an);
      paramInt = paramAttributeSet.getDimensionPixelSize(0, (int)DisplayUtils.a(paramContext, 12.0F));
      paramContext = paramAttributeSet.getColorStateList(1);
      localObject = paramAttributeSet.getString(2);
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(paramInt);
      this.jdField_a_of_type_AndroidGraphicsPaint$FontMetrics = this.jdField_a_of_type_AndroidTextTextPaint.getFontMetrics();
      this.jdField_a_of_type_AndroidContentResColorStateList = paramContext;
      this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentResColorStateList.getDefaultColor();
      this.jdField_a_of_type_AndroidTextTextPaint.setColor(this.jdField_a_of_type_Int);
      setText((CharSequence)localObject);
      paramAttributeSet.recycle();
    }
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    int j = View.MeasureSpec.getMode(paramInt1);
    int i = View.MeasureSpec.getSize(paramInt1);
    if (j == 1073741824) {
      paramInt1 = i;
    }
    do
    {
      return paramInt1;
      paramInt1 = paramInt2;
    } while (j != Integer.MIN_VALUE);
    return Math.min(i, paramInt2);
  }
  
  private void a()
  {
    int[] arrayOfInt = getDrawableState();
    int i = this.jdField_a_of_type_AndroidContentResColorStateList.getColorForState(arrayOfInt, 0);
    if (i != this.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_Int = i;
      this.jdField_a_of_type_AndroidTextTextPaint.setColor(this.jdField_a_of_type_Int);
      invalidate();
    }
  }
  
  public Paint a()
  {
    return this.jdField_a_of_type_AndroidTextTextPaint;
  }
  
  public CharSequence a()
  {
    return this.jdField_a_of_type_JavaLangCharSequence;
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if ((this.jdField_a_of_type_AndroidContentResColorStateList != null) && (this.jdField_a_of_type_AndroidContentResColorStateList.isStateful())) {
      a();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i = getMeasuredHeight();
    float f2 = this.jdField_a_of_type_AndroidGraphicsPaint$FontMetrics.bottom;
    float f3 = this.jdField_a_of_type_AndroidGraphicsPaint$FontMetrics.top;
    float f1 = i;
    f2 = (i - (f2 - f3)) / 2.0F;
    f3 = this.jdField_a_of_type_AndroidGraphicsPaint$FontMetrics.bottom;
    paramCanvas.drawText(this.jdField_a_of_type_JavaLangCharSequence, 0, this.jdField_a_of_type_JavaLangCharSequence.length(), getPaddingLeft(), f1 - f2 - f3, this.jdField_a_of_type_AndroidTextTextPaint);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.b != -1) {}
    for (int i = this.b;; i = (int)this.jdField_a_of_type_AndroidTextTextPaint.measureText(this.jdField_a_of_type_JavaLangCharSequence, 0, this.jdField_a_of_type_JavaLangCharSequence.length()))
    {
      setMeasuredDimension(a(paramInt1, i), a(paramInt2, Math.max((int)(this.jdField_a_of_type_AndroidGraphicsPaint$FontMetrics.top - this.jdField_a_of_type_AndroidGraphicsPaint$FontMetrics.bottom), getSuggestedMinimumWidth())));
      return;
    }
  }
  
  public void setFixedWidth(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    Object localObject = paramCharSequence;
    if (paramCharSequence == null) {
      localObject = "";
    }
    if (localObject != this.jdField_a_of_type_JavaLangCharSequence)
    {
      this.jdField_a_of_type_JavaLangCharSequence = ((CharSequence)localObject);
      requestLayout();
    }
  }
  
  public void setTextColor(int paramInt)
  {
    this.jdField_a_of_type_AndroidContentResColorStateList = ColorStateList.valueOf(paramInt);
    a();
    invalidate();
  }
  
  public void setTextSize(float paramFloat)
  {
    Object localObject = getContext();
    if (localObject == null) {}
    for (localObject = Resources.getSystem();; localObject = ((Context)localObject).getResources())
    {
      paramFloat = TypedValue.applyDimension(1, paramFloat, ((Resources)localObject).getDisplayMetrics());
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(paramFloat);
      this.jdField_a_of_type_AndroidGraphicsPaint$FontMetrics = this.jdField_a_of_type_AndroidTextTextPaint.getFontMetrics();
      requestLayout();
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\contact\SimpleTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */