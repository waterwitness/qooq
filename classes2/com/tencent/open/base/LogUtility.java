package com.tencent.open.base;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class LogUtility
{
  protected static final int a = 0;
  public static final String a = "opensdk";
  protected static boolean a = false;
  protected static final int b = 1;
  protected static String b;
  protected static final int c = 2;
  protected static final int d = 3;
  protected static final int e = 4;
  protected static final int f = 0;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    a = true;
    b = "";
    b += ".*[S|s][I|i][D|d].*";
    b += "|.*==.*";
    b += "|.*[U|u][I|i][N|n].*";
    b += "|.*%3d%3d.*";
    b += "|.*[V|v][K|k][E|e][Y|y]";
  }
  
  protected static void a(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (a) {
      if (paramInt == 1)
      {
        if (paramThrowable != null) {
          break label187;
        }
        if (QLog.isColorLevel()) {
          QLog.i(paramString1, 2, "" + "::" + paramString2);
        }
      }
    }
    label98:
    label186:
    label187:
    label226:
    label265:
    label304:
    do
    {
      break label186;
      if ((paramInt == 2) || (paramInt == 0))
      {
        if (paramThrowable != null) {
          break label226;
        }
        if (QLog.isColorLevel()) {
          QLog.d(paramString1, 2, "" + "::" + paramString2);
        }
      }
      if (paramInt == 3)
      {
        if (paramThrowable != null) {
          break label265;
        }
        if (QLog.isColorLevel()) {
          QLog.w(paramString1, 2, "" + "::" + paramString2);
        }
      }
      for (;;)
      {
        if (paramInt == 4)
        {
          if (paramThrowable != null) {
            break label304;
          }
          if (QLog.isColorLevel()) {
            QLog.e(paramString1, 2, "" + "::" + paramString2);
          }
        }
        return;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i(paramString1, 2, "" + "::" + paramString2, paramThrowable);
        break;
        if (!QLog.isColorLevel()) {
          break label98;
        }
        QLog.d(paramString1, 2, "" + "::" + paramString2, paramThrowable);
        break label98;
        if (QLog.isColorLevel()) {
          QLog.w(paramString1, 2, "" + "::" + paramString2, paramThrowable);
        }
      }
    } while (!QLog.isColorLevel());
    QLog.e(paramString1, 2, "" + "::" + paramString2, paramThrowable);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    a(0, paramString1, paramString2, null);
  }
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    a(2, paramString1, paramString2, paramThrowable);
  }
  
  public static boolean a()
  {
    return a;
  }
  
  public static void b(String paramString1, String paramString2)
  {
    a(1, paramString1, paramString2, null);
  }
  
  public static void b(String paramString1, String paramString2, Throwable paramThrowable)
  {
    a(3, paramString1, paramString2, paramThrowable);
  }
  
  public static void c(String paramString1, String paramString2)
  {
    a(2, paramString1, paramString2, null);
  }
  
  public static void c(String paramString1, String paramString2, Throwable paramThrowable)
  {
    a(4, paramString1, paramString2, paramThrowable);
  }
  
  public static void d(String paramString1, String paramString2)
  {
    a(3, paramString1, paramString2, null);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    a(4, paramString1, paramString2, null);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\base\LogUtility.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */