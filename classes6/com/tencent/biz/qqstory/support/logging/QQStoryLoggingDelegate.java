package com.tencent.biz.qqstory.support.logging;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.io.PrintWriter;
import java.io.StringWriter;

public class QQStoryLoggingDelegate
  implements LoggingDelegate
{
  public static final QQStoryLoggingDelegate a;
  public int a;
  public String a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ComTencentBizQqstorySupportLoggingQQStoryLoggingDelegate = new QQStoryLoggingDelegate();
  }
  
  private QQStoryLoggingDelegate()
  {
    this.jdField_a_of_type_Int = 3;
  }
  
  public static QQStoryLoggingDelegate a()
  {
    return jdField_a_of_type_ComTencentBizQqstorySupportLoggingQQStoryLoggingDelegate;
  }
  
  private String a(String paramString)
  {
    String str = paramString;
    if (this.jdField_a_of_type_JavaLangString != null) {
      str = this.jdField_a_of_type_JavaLangString + "_" + paramString;
    }
    return str;
  }
  
  private static String a(String paramString, Throwable paramThrowable)
  {
    return paramString + '\n' + a(paramThrowable);
  }
  
  private static String a(Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      return "";
    }
    StringWriter localStringWriter = new StringWriter();
    paramThrowable.printStackTrace(new PrintWriter(localStringWriter));
    return localStringWriter.toString();
  }
  
  private void a(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 2: 
      QLog.d(a(paramString1), 2, a(paramString2, paramThrowable));
      return;
    case 3: 
      QLog.d(a(paramString1), 2, a(paramString2, paramThrowable));
      return;
    case 4: 
      QLog.i(a(paramString1), 2, a(paramString2, paramThrowable));
      return;
    case 5: 
      QLog.e(a(paramString1), 1, a(paramString2, paramThrowable));
      return;
    }
    QLog.e(a(paramString1), 1, a(paramString2, paramThrowable));
  }
  
  private void b(int paramInt, String paramString1, String paramString2)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 2: 
      QLog.d(a(paramString1), 2, paramString2);
      return;
    case 3: 
      QLog.d(a(paramString1), 2, paramString2);
      return;
    case 4: 
      QLog.i(a(paramString1), 2, paramString2);
      return;
    case 5: 
      QLog.e(a(paramString1), 1, paramString2);
      return;
    }
    QLog.e(a(paramString1), 1, paramString2);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    b(paramInt, paramString1, paramString2);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(String paramString1, String paramString2)
  {
    b(2, paramString1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    a(2, paramString1, paramString2, paramThrowable);
  }
  
  public boolean a(int paramInt)
  {
    if (5 <= paramInt) {}
    do
    {
      return true;
      if (!QLog.isColorLevel()) {
        return false;
      }
    } while (this.jdField_a_of_type_Int <= paramInt);
    return false;
  }
  
  public void b(String paramString1, String paramString2)
  {
    b(3, paramString1, paramString2);
  }
  
  public void b(String paramString1, String paramString2, Throwable paramThrowable)
  {
    a(3, paramString1, paramString2, paramThrowable);
  }
  
  public void c(String paramString1, String paramString2)
  {
    b(4, paramString1, paramString2);
  }
  
  public void c(String paramString1, String paramString2, Throwable paramThrowable)
  {
    a(4, paramString1, paramString2, paramThrowable);
  }
  
  public void d(String paramString1, String paramString2)
  {
    b(5, paramString1, paramString2);
  }
  
  public void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    a(5, paramString1, paramString2, paramThrowable);
  }
  
  public void e(String paramString1, String paramString2)
  {
    b(6, paramString1, paramString2);
  }
  
  public void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    a(6, paramString1, paramString2, paramThrowable);
  }
  
  public void f(String paramString1, String paramString2)
  {
    b(6, paramString1, paramString2);
  }
  
  public void f(String paramString1, String paramString2, Throwable paramThrowable)
  {
    a(6, paramString1, paramString2, paramThrowable);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\support\logging\QQStoryLoggingDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */