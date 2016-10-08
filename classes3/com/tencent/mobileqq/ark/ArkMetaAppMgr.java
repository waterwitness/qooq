package com.tencent.mobileqq.ark;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ArkMetaAppMgr
{
  QQAppInterface a;
  
  ArkMetaAppMgr(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramQQAppInterface;
  }
  
  public void a(ArkAppInfo.Context paramContext, ArkAppInfo.Meta paramMeta) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\ark\ArkMetaAppMgr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */