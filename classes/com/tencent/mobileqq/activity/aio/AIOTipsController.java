package com.tencent.mobileqq.activity.aio;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class AIOTipsController
{
  private ViewGroup a;
  
  public AIOTipsController(ViewGroup paramViewGroup)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramViewGroup;
  }
  
  public void a()
  {
    this.a.setVisibility(8);
  }
  
  public void a(View paramView)
  {
    if (paramView != null)
    {
      if (this.a.indexOfChild(paramView) == -1) {
        this.a.addView(paramView, new ViewGroup.LayoutParams(-1, -2));
      }
      int i = 0;
      while (i < this.a.getChildCount())
      {
        this.a.getChildAt(i).setVisibility(8);
        i += 1;
      }
      paramView.setVisibility(0);
      this.a.setVisibility(0);
    }
  }
  
  public void b()
  {
    this.a.removeAllViews();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\AIOTipsController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */