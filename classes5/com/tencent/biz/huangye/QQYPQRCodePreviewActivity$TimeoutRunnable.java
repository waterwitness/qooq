package com.tencent.biz.huangye;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class QQYPQRCodePreviewActivity$TimeoutRunnable
  implements Runnable
{
  protected QQYPQRCodePreviewActivity$TimeoutRunnable(QQYPQRCodePreviewActivity paramQQYPQRCodePreviewActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.a.a != null) && (this.a.a.isShowing())) {}
    try
    {
      this.a.a.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\huangye\QQYPQRCodePreviewActivity$TimeoutRunnable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */