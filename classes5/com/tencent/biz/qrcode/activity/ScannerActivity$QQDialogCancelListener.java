package com.tencent.biz.qrcode.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public abstract class ScannerActivity$QQDialogCancelListener
  implements DialogInterface.OnCancelListener, DialogInterface.OnClickListener
{
  public ScannerActivity$QQDialogCancelListener()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public abstract void a();
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    a();
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    a();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\qrcode\activity\ScannerActivity$QQDialogCancelListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */