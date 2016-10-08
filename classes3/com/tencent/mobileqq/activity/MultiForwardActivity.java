package com.tencent.mobileqq.activity;

import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class MultiForwardActivity
  extends ChatActivity
{
  public MultiForwardActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    return super.doOnCreate(paramBundle);
  }
  
  protected void doOnWindowFocusChanged(boolean paramBoolean) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\MultiForwardActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */