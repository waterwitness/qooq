package com.tencent.open.util;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class Logger
{
  private static int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString;
  private final boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int = 3;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private String c;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    int i = 0;
    for (;;)
    {
      if (i < arrayOfStackTraceElement.length)
      {
        if (Logger.class.getName().equals(arrayOfStackTraceElement[i].getClassName())) {
          jdField_a_of_type_Int = i;
        }
      }
      else {
        return;
      }
      i += 1;
    }
  }
  
  private StringBuilder a(int paramInt)
  {
    return new StringBuilder();
  }
  
  private void a(String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3)
  {
    switch (paramInt1)
    {
    }
    for (;;)
    {
      StringBuilder localStringBuilder;
      try
      {
        localStringBuilder = a(paramInt3);
        if (paramString2 != null) {
          localStringBuilder.append(paramString2);
        }
        paramString2 = paramString1;
        if (paramString1 == null) {
          paramString2 = this.jdField_a_of_type_JavaLangString;
        }
        switch (paramInt2)
        {
        default: 
          return;
        }
      }
      finally {}
      if (!QLog.isDevelopLevel())
      {
        continue;
        if (!QLog.isColorLevel())
        {
          continue;
          QLog.e(paramString2, paramInt1, localStringBuilder.toString());
          continue;
          QLog.w(paramString2, paramInt1, localStringBuilder.toString());
          continue;
          QLog.i(paramString2, paramInt1, localStringBuilder.toString());
          continue;
          QLog.d(paramString2, paramInt1, localStringBuilder.toString());
        }
      }
    }
  }
  
  public Logger a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public Logger a(String paramString1, int paramInt, String paramString2)
  {
    a(paramString1, paramInt, 6, paramString2, this.jdField_b_of_type_Int);
    return this;
  }
  
  public void a()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (!this.jdField_b_of_type_Boolean) {}
      return;
    }
  }
  
  public final void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public Logger b(String paramString1, int paramInt, String paramString2)
  {
    a(paramString1, paramInt, 5, paramString2, this.jdField_b_of_type_Int);
    return this;
  }
  
  public void b()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_b_of_type_Boolean) {}
      return;
    }
  }
  
  public Logger c(String paramString1, int paramInt, String paramString2)
  {
    a(paramString1, paramInt, 4, paramString2, this.jdField_b_of_type_Int);
    return this;
  }
  
  public Logger d(String paramString1, int paramInt, String paramString2)
  {
    a(paramString1, paramInt, 3, paramString2, this.jdField_b_of_type_Int);
    return this;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\util\Logger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */