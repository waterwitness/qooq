package com.tencent.mobileqq.activity;

import android.os.Bundle;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qfileJumpIpadActivity
  extends qfileJumpActivity
{
  public qfileJumpIpadActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.a = AppConstants.ak;
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\qfileJumpIpadActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */