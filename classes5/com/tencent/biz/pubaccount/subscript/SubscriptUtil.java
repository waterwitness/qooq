package com.tencent.biz.pubaccount.subscript;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class SubscriptUtil
{
  private static final String a = "SubscriptUtil";
  
  public SubscriptUtil()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static String a(String paramString)
  {
    String str1;
    if ((paramString != null) && (paramString.length() < 5)) {
      str1 = (String)SubscriptConstants.a.get(paramString);
    }
    for (;;)
    {
      String str3 = str1;
      if (str1 == null) {
        str3 = "";
      }
      if (QLog.isColorLevel()) {
        QLog.d("SubscriptUtil", 2, "getUin subscribeID[" + paramString + "]'s uin: " + str3);
      }
      return str3;
      try
      {
        int i = Integer.parseInt(paramString);
        str1 = String.valueOf(i);
      }
      catch (Exception localException)
      {
        String str2 = (String)SubscriptConstants.a.get(paramString);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\subscript\SubscriptUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */