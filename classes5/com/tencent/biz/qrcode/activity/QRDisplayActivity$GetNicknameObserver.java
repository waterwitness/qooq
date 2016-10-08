package com.tencent.biz.qrcode.activity;

import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;
import mqq.observer.BusinessObserver;

public class QRDisplayActivity$GetNicknameObserver
  implements BusinessObserver
{
  public QRDisplayActivity$GetNicknameObserver(QRDisplayActivity paramQRDisplayActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, List paramList1, List paramList2) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    if (paramBoolean)
    {
      a(paramBoolean, paramBundle.getStringArrayList("nickname_list"), paramBundle.getStringArrayList("uin_list"));
      return;
    }
    this.b.g();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\qrcode\activity\QRDisplayActivity$GetNicknameObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */