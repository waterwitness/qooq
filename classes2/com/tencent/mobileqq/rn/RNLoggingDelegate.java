package com.tencent.mobileqq.rn;

import com.facebook.common.logging.LoggingDelegate;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyUtils;

public class RNLoggingDelegate
  implements LoggingDelegate
{
  static final String jdField_a_of_type_JavaLangString;
  static final boolean jdField_a_of_type_Boolean = false;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    a = RNLoggingDelegate.class.getSimpleName();
  }
  
  public void d(String paramString1, String paramString2) {}
  
  public void d(String paramString1, String paramString2, Throwable paramThrowable) {}
  
  public void e(String paramString1, String paramString2)
  {
    if (NearbyUtils.b()) {
      NearbyUtils.a(paramString1, new Object[] { paramString2 });
    }
  }
  
  public void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (NearbyUtils.b())
    {
      if (paramThrowable != null) {
        paramThrowable.printStackTrace();
      }
      NearbyUtils.a(paramString1, new Object[] { paramString2, paramThrowable });
    }
  }
  
  public int getMinimumLoggingLevel()
  {
    if (NearbyUtils.b()) {
      return 6;
    }
    return 7;
  }
  
  public void i(String paramString1, String paramString2) {}
  
  public void i(String paramString1, String paramString2, Throwable paramThrowable) {}
  
  public boolean isLoggable(int paramInt)
  {
    boolean bool = false;
    if (paramInt >= 6) {
      bool = NearbyUtils.b();
    }
    return bool;
  }
  
  public void log(int paramInt, String paramString1, String paramString2) {}
  
  public void setMinimumLoggingLevel(int paramInt) {}
  
  public void v(String paramString1, String paramString2) {}
  
  public void v(String paramString1, String paramString2, Throwable paramThrowable) {}
  
  public void w(String paramString1, String paramString2) {}
  
  public void w(String paramString1, String paramString2, Throwable paramThrowable) {}
  
  public void wtf(String paramString1, String paramString2)
  {
    if (NearbyUtils.b()) {
      NearbyUtils.a(paramString1, new Object[] { paramString2 });
    }
  }
  
  public void wtf(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (NearbyUtils.b())
    {
      if (paramThrowable != null) {
        paramThrowable.printStackTrace();
      }
      NearbyUtils.a(paramString1, new Object[] { paramString2, paramThrowable });
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\rn\RNLoggingDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */