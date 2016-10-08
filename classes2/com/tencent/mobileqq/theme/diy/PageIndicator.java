package com.tencent.mobileqq.theme.diy;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class PageIndicator
  extends LinearLayout
{
  protected float density;
  ScrollLayout scrollViewGroup;
  
  public PageIndicator(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.density = super.getResources().getDisplayMetrics().density;
  }
  
  public PageIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.density = super.getResources().getDisplayMetrics().density;
  }
  
  public void bindScrollViewGroup(ScrollLayout paramScrollLayout)
  {
    if (paramScrollLayout == null) {
      return;
    }
    this.scrollViewGroup = paramScrollLayout;
    int j = paramScrollLayout.getChildCount();
    int i = 0;
    while (i < j)
    {
      ImageView localImageView = new ImageView(super.getContext());
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams((int)(this.density * 8.0F), (int)(this.density * 8.0F));
      localLayoutParams.setMargins((int)(4.0F * this.density), 0, (int)(5.0F * this.density), 0);
      localImageView.setLayoutParams(localLayoutParams);
      super.addView(localImageView);
      localImageView.setBackgroundResource(2130841881);
      if (i == j - 1) {
        generatePageControl(paramScrollLayout.getCurScreen());
      }
      i += 1;
    }
    generatePageControl(paramScrollLayout.getCurScreen());
  }
  
  public void generatePageControl(int paramInt)
  {
    int j = super.getChildCount();
    int i = 0;
    View localView;
    while (i < j)
    {
      localView = super.getChildAt(i);
      if (localView != null) {
        localView.setBackgroundResource(2130841881);
      }
      i += 1;
    }
    if (paramInt == -1) {
      i = 0;
    }
    for (;;)
    {
      if ((i > -1) && (i < j))
      {
        localView = super.getChildAt(i);
        if (localView != null) {
          localView.setBackgroundResource(2130841882);
        }
      }
      return;
      i = paramInt;
      if (paramInt == j) {
        i = j - 1;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\theme\diy\PageIndicator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */