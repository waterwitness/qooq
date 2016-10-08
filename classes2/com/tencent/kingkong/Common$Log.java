package com.tencent.kingkong;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class Common$Log
{
  public Common$Log()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(String paramString1, String paramString2)
  {
    QLog.d(paramString1, 1, paramString2);
  }
  
  public static void b(String paramString1, String paramString2) {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\kingkong\Common$Log.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */