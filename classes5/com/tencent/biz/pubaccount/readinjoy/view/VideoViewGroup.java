package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class VideoViewGroup
  extends FrameLayout
{
  private float a = 1.0F;
  private float b = 1.0F;
  private float c;
  private float d;
  
  public VideoViewGroup(Context paramContext)
  {
    this(paramContext, null);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public VideoViewGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VideoViewGroup(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramAttributeSet);
  }
  
  private void a(AttributeSet paramAttributeSet)
  {
    paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.aB);
    this.a = paramAttributeSet.getFloat(0, 1.0F);
    this.b = paramAttributeSet.getFloat(1, 1.0F);
    paramAttributeSet.recycle();
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getSize(paramInt1);
    int k = View.MeasureSpec.getSize(paramInt2);
    View.MeasureSpec.getMode(paramInt1);
    int j = View.MeasureSpec.getMode(paramInt2);
    if ((this.a == 1.0F) && (this.b != 1.0F))
    {
      k = (int)(i * this.b);
      if (j == 0) {
        paramInt2 = View.MeasureSpec.makeMeasureSpec(k, 1073741824);
      }
      super.onMeasure(paramInt1, paramInt2);
      setMeasuredDimension(i, k);
      return;
    }
    if ((this.a != 1.0F) && (this.b == 1.0F))
    {
      i = (int)(k * this.a);
      super.onMeasure(paramInt1, paramInt2);
      setMeasuredDimension(i, k);
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\readinjoy\view\VideoViewGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */