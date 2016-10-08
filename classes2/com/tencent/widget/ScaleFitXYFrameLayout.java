package com.tencent.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ScaleFitXYFrameLayout
  extends FrameLayout
{
  private float jdField_a_of_type_Float;
  private Context jdField_a_of_type_AndroidContentContext;
  private float b;
  
  public ScaleFitXYFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Float = 1.0F;
    this.b = 1.0F;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    paramContext = this.jdField_a_of_type_AndroidContentContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ai);
    this.jdField_a_of_type_Float = paramContext.getFloat(0, 1.0F);
    this.b = paramContext.getFloat(1, 1.0F);
    paramContext.recycle();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt1);
    int j = View.MeasureSpec.getSize(paramInt1);
    paramInt1 = View.MeasureSpec.getMode(paramInt2);
    View.MeasureSpec.getSize(paramInt2);
    if (this.jdField_a_of_type_Float == 1.0F) {
      if (i != 0)
      {
        k = (int)(j * this.b);
        setMeasuredDimension(j, k);
        paramInt2 = View.MeasureSpec.makeMeasureSpec(j, i);
        paramInt1 = View.MeasureSpec.makeMeasureSpec(k, paramInt1);
        measureChildren(paramInt2, paramInt1);
      }
    }
    while (this.b != 1.0F) {
      for (;;)
      {
        int k;
        return;
        setMeasuredDimension(0, 0);
        paramInt2 = View.MeasureSpec.makeMeasureSpec(0, i);
        paramInt1 = View.MeasureSpec.makeMeasureSpec(0, paramInt1);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\widget\ScaleFitXYFrameLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */