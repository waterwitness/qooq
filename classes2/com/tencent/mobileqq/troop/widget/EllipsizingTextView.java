package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import vsq;

public class EllipsizingTextView
  extends TextView
{
  private int jdField_a_of_type_Int;
  private vsq jdField_a_of_type_Vsq;
  private int b;
  
  public EllipsizingTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 1;
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.s);
      int i = 0;
      int j = paramContext.getIndexCount();
      if (i < j)
      {
        int k = paramContext.getIndex(i);
        switch (k)
        {
        }
        for (;;)
        {
          i += 1;
          break;
          this.b = paramContext.getDimensionPixelOffset(k, this.b);
          continue;
          this.jdField_a_of_type_Int = paramContext.getInt(k, this.jdField_a_of_type_Int);
        }
      }
      paramContext.recycle();
    }
  }
  
  private vsq a()
  {
    if (this.jdField_a_of_type_Vsq == null) {
      this.jdField_a_of_type_Vsq = new vsq(this);
    }
    return this.jdField_a_of_type_Vsq;
  }
  
  public int getLineCount()
  {
    return a().a();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    String str = getText().toString();
    Object localObject = getPaint();
    ((TextPaint)localObject).setColor(getCurrentTextColor());
    ((TextPaint)localObject).drawableState = getDrawableState();
    localObject = a();
    ((vsq)localObject).a(str, this, this.jdField_a_of_type_Int, this.b);
    if (getEllipsize() == TextUtils.TruncateAt.END)
    {
      ((vsq)localObject).a(paramCanvas, TextUtils.TruncateAt.END);
      return;
    }
    if (getEllipsize() == TextUtils.TruncateAt.MIDDLE)
    {
      ((vsq)localObject).a(paramCanvas, TextUtils.TruncateAt.MIDDLE);
      return;
    }
    super.onDraw(paramCanvas);
  }
  
  public void setEndStrWidth(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void setMaxLines(int paramInt)
  {
    super.setMaxLines(paramInt);
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\widget\EllipsizingTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */