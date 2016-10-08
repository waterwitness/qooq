package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ADViewIndividuation
  extends ADView
{
  private int a;
  
  public ADViewIndividuation(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.f = 8;
    this.g = 18;
    this.d = 2130841641;
    this.e = this.d;
  }
  
  public ADViewIndividuation(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.f = 4;
    this.g = 8;
    this.d = 2130841641;
    this.e = this.d;
  }
  
  public void a(View paramView, int paramInt)
  {
    super.a(paramView, paramInt);
    setNavVisible(this.jdField_a_of_type_Int, false);
  }
  
  protected void a(LinearLayout paramLinearLayout)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(8, 100000);
    localLayoutParams.addRule(7, 100000);
    localLayoutParams.setMargins(0, 0, 0, (int)(6.0F * this.jdField_a_of_type_Float));
    paramLinearLayout.setGravity(16);
    paramLinearLayout.setPadding((int)(4.0F * this.jdField_a_of_type_Float), 0, (int)(2.0F * this.jdField_a_of_type_Float), 0);
    paramLinearLayout.setLayoutParams(localLayoutParams);
  }
  
  public void setNavVisible(int paramInt, boolean paramBoolean)
  {
    if (paramInt == 0) {}
    do
    {
      return;
      Object localObject = (ViewGroup)this.b.getChildAt(0);
      if (localObject != null)
      {
        localObject = (LinearLayout)((ViewGroup)localObject).getChildAt(1);
        if (localObject != null)
        {
          if (paramInt > 0) {}
          for (paramInt = 0;; paramInt = 8)
          {
            ((LinearLayout)localObject).setVisibility(paramInt);
            if (!paramBoolean) {
              break;
            }
            this.jdField_a_of_type_Int = 0;
            return;
          }
        }
      }
    } while (!paramBoolean);
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\widget\ADViewIndividuation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */