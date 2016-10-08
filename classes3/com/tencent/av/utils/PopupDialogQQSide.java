package com.tencent.av.utils;

import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class PopupDialogQQSide
  extends PopupDialog
{
  public PopupDialogQQSide()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.a = false;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\utils\PopupDialogQQSide.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */