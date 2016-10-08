package com.tencent.mobileqq.persistence;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class ORMConfig
{
  public static final String a = "FastORM";
  public static final boolean a = true;
  public static final boolean b = false;
  public static final boolean c = true;
  public static final boolean d = true;
  public static final boolean e = false;
  
  public ORMConfig()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("FastORM", 4, paramString);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\persistence\ORMConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */