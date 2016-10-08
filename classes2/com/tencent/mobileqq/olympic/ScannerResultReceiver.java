package com.tencent.mobileqq.olympic;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.olympic.utils.OlympicUtil;

public class ScannerResultReceiver
  extends ResultReceiver
{
  private ScannerActivity a;
  
  public ScannerResultReceiver(Handler paramHandler)
  {
    super(paramHandler);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(ScannerActivity paramScannerActivity)
  {
    this.a = paramScannerActivity;
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    OlympicUtil.b("ScannerResultReceiver", new Object[] { "mResultReceiver.onReceiveResult, resultCode=", Integer.valueOf(paramInt) });
    if ((paramInt == 0) && (this.a != null) && (this.a.n)) {
      this.a.a(true);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\olympic\ScannerResultReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */