package com.tencent.mobileqq.structmsg.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class HeightLimitedLinearLayout
  extends LinearLayout
{
  protected int a;
  
  public HeightLimitedLinearLayout(Context paramContext)
  {
    super(paramContext);
    this.a = -1;
  }
  
  public HeightLimitedLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = -1;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt2 = getMeasuredHeight();
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    if ((this.a > 0) && (paramInt2 > this.a))
    {
      setMeasuredDimension(paramInt1, this.a);
      return;
    }
    setMeasuredDimension(paramInt1, paramInt2);
  }
  
  public void setMaxHeight(int paramInt)
  {
    this.a = paramInt;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\structmsg\widget\HeightLimitedLinearLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */