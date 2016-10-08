package com.tencent.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class MaxHeightRelativelayout
  extends RelativeLayout
{
  private int a;
  
  public MaxHeightRelativelayout(Context paramContext)
  {
    super(paramContext);
    this.a = Integer.MAX_VALUE;
  }
  
  public MaxHeightRelativelayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = Integer.MAX_VALUE;
  }
  
  public MaxHeightRelativelayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = Integer.MAX_VALUE;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = View.MeasureSpec.getMode(paramInt2);
    int i = paramInt2;
    if (View.MeasureSpec.getSize(paramInt2) > this.a)
    {
      i = paramInt2;
      if (j != 0) {
        i = View.MeasureSpec.makeMeasureSpec(this.a, j);
      }
    }
    super.onMeasure(paramInt1, i);
  }
  
  public void setMaxHeight(int paramInt)
  {
    this.a = paramInt;
    if (this.a < getMeasuredHeight()) {
      requestLayout();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\widget\MaxHeightRelativelayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */