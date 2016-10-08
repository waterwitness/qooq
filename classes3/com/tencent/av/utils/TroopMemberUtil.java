package com.tencent.av.utils;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class TroopMemberUtil
{
  public TroopMemberUtil()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static int a(AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    if ((paramAppInterface instanceof QQAppInterface)) {
      return a((QQAppInterface)paramAppInterface, paramString1, paramString2);
    }
    return b(paramAppInterface, paramString1, paramString2);
  }
  
  private static int a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(51);
      if (paramQQAppInterface != null)
      {
        if (paramQQAppInterface.a(paramString2, paramString1) == null) {
          return 3;
        }
        paramQQAppInterface = paramQQAppInterface.a(paramString2);
        if ((paramQQAppInterface != null) && (paramQQAppInterface.isTroopOwner(paramString1))) {
          return 0;
        }
        if ((paramQQAppInterface != null) && (paramQQAppInterface.isTroopAdmin(paramString1))) {
          return 1;
        }
        if (paramQQAppInterface != null) {
          return 2;
        }
        return -1;
      }
      return -1;
    }
    return -1;
  }
  
  private static int b(AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    if ((paramAppInterface instanceof TroopMemberUtil.ITroopMemberGetter)) {
      return ((TroopMemberUtil.ITroopMemberGetter)paramAppInterface).a(paramString1, paramString2);
    }
    return -1;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\utils\TroopMemberUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */