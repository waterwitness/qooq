package com.tencent.mobileqq.activity.specialcare;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class SpecialCareTipsController
{
  private ViewGroup a;
  
  public SpecialCareTipsController(ViewGroup paramViewGroup)
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
        this.a.addView(paramView);
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
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\specialcare\SpecialCareTipsController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */