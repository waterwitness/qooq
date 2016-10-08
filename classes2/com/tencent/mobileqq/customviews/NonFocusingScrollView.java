package com.tencent.mobileqq.customviews;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class NonFocusingScrollView
  extends ScrollView
{
  public NonFocusingScrollView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public NonFocusingScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public NonFocusingScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    scrollTo(0, 0);
  }
  
  public void setOverScrollMode(int paramInt)
  {
    super.setOverScrollMode(2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\customviews\NonFocusingScrollView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */