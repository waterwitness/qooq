package com.tencent.mobileqq.richmedia;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class LOG
{
  public LOG()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static int a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(paramString1, 2, "##" + paramString2);
    }
    return 0;
  }
  
  public static int b(String paramString1, String paramString2)
  {
    QLog.e(paramString1, 2, "##" + paramString2);
    return 0;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\richmedia\LOG.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */