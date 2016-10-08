package com.tencent.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Interpolator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public abstract class VerticalAbsSpinner
  extends AbsSpinner
{
  View jdField_a_of_type_AndroidViewView;
  Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator;
  
  public VerticalAbsSpinner(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = null;
  }
  
  public VerticalAbsSpinner(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VerticalAbsSpinner(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = null;
  }
  
  public View a()
  {
    if ((this.aG > 0) && (this.aF >= 0))
    {
      int i;
      View localView2;
      View localView1;
      if (Math.abs(this.aF - this.au) > getChildCount())
      {
        i = this.aF + this.aG - this.au;
        localView2 = getChildAt(i);
        localView1 = localView2;
        if (localView2 != null)
        {
          localView2.setTag(String.valueOf(i));
          localView1 = localView2;
        }
      }
      do
      {
        return localView1;
        i = this.aF - this.au;
        localView2 = getChildAt(i);
        localView1 = localView2;
      } while (localView2 == null);
      localView2.setTag(String.valueOf(i));
      return localView2;
    }
    return null;
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new ViewGroup.LayoutParams(-1, -2);
  }
  
  void s()
  {
    super.s();
  }
  
  public void setSelection(int paramInt)
  {
    super.setSelection(paramInt);
    A();
  }
  
  public void setSelection(int paramInt, boolean paramBoolean)
  {
    super.setSelection(paramInt, paramBoolean);
    A();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\widget\VerticalAbsSpinner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */