package com.tencent.mobileqq.persistence;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.reflect.Method;

public class OGEntityDaoManager
{
  public static OGEntityDaoManager a = new OGEntityDaoManager();
  public static final String a = "com.tencent.mobileqq.persistence.EntityDaoRegister";
  public static Method a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static OGEntityDaoManager a()
  {
    return a;
  }
  
  public static void a(String[] paramArrayOfString)
  {
    new OGEntityDaoManager().a(OGEntityDaoManager.class);
  }
  
  public OGAbstractDao a(Class paramClass)
  {
    return EntityDaoRegister.a(paramClass);
  }
  
  public String a(Class paramClass, String paramString)
  {
    paramClass = a(paramClass);
    if (paramClass != null) {
      return paramClass.a(paramString);
    }
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\persistence\OGEntityDaoManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */