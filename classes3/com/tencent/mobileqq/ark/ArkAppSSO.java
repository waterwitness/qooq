package com.tencent.mobileqq.ark;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ArkAppSSO
{
  QQAppInterface a;
  
  public ArkAppSSO(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramQQAppInterface;
  }
  
  public boolean a(String paramString1, String paramString2, int paramInt1, int paramInt2, BusinessObserver paramBusinessObserver)
  {
    return ((ArkAppHandler)this.a.a(95)).a(paramString1, paramString2, paramInt1, paramInt2, paramBusinessObserver);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\ark\ArkAppSSO.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */