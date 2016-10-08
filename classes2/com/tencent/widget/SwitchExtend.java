package com.tencent.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class SwitchExtend
  extends Switch
{
  private SwitchExtend.OnSwitchListener a;
  
  public SwitchExtend(Context paramContext)
  {
    this(paramContext, null);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public SwitchExtend(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 2130772207);
  }
  
  public SwitchExtend(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean performClick()
  {
    if ((this.a == null) || (this.a.a(this))) {
      return super.performClick();
    }
    return false;
  }
  
  public void setOnSwitchListener(SwitchExtend.OnSwitchListener paramOnSwitchListener)
  {
    this.a = paramOnSwitchListener;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\widget\SwitchExtend.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */