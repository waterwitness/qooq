package com.tencent.mobileqq.utils;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SecSvcHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.app.MobileQQ;

public class PhoneUnityInfoUtil
{
  public PhoneUnityInfoUtil()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    Object localObject = (QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localObject != null)
    {
      localObject = (SecSvcHandler)((QQAppInterface)localObject).a(34);
      if (localObject != null) {
        ((SecSvcHandler)localObject).a(paramInt1, paramInt2, paramString1, paramString2);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\utils\PhoneUnityInfoUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */