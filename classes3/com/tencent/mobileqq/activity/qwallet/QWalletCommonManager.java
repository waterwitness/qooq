package com.tencent.mobileqq.activity.qwallet;

import Wallet.GetPasswordReq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QWalletAuthHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qwallet.plugin.PatternLockUtils;

public class QWalletCommonManager
{
  public QWalletCommonManager()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (PatternLockUtils.d(paramQQAppInterface.a(), paramQQAppInterface.f()))
    {
      GetPasswordReq localGetPasswordReq = new GetPasswordReq();
      localGetPasswordReq.MQOS = "Android";
      ((QWalletAuthHandler)paramQQAppInterface.a(42)).a(localGetPasswordReq);
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\qwallet\QWalletCommonManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */