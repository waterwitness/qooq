package com.tencent.mobileqq.activity.phone;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class PhoneFrame
  extends PhoneInnerFrame
{
  private BaseActivityView.IPhoneContext a;
  
  public PhoneFrame(Context paramContext)
  {
    super(paramContext);
  }
  
  public PhoneFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PhoneFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected BaseActivityView.IPhoneContext a()
  {
    return this.a;
  }
  
  public void f()
  {
    a().finish();
  }
  
  public void setPhoneContext(BaseActivityView.IPhoneContext paramIPhoneContext)
  {
    this.a = paramIPhoneContext;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\mobileqq\activity\phone\PhoneFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */