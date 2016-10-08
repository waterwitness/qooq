package com.tencent.mobileqq.unifiedebug;

import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import vxa;

public class UnifiedTraceRouter
{
  public static final String a = "UnifiedTraceRouter";
  public static final String b = "PING";
  public static final String c = "From";
  public static final String d = "from";
  public static final String e = "(";
  public static final String f = ")";
  public static final String g = "time=";
  public static final String h = "exceed";
  public static final String i = "100%";
  public float a;
  public final int a;
  public Handler a;
  public QQAppInterface a;
  public List a;
  public int b;
  public String j;
  public String k;
  
  public UnifiedTraceRouter(QQAppInterface paramQQAppInterface, Handler paramHandler)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 32;
    this.b = 1;
    this.k = "";
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public String a(String paramString)
  {
    Object localObject = String.format("/system/bin/ping -i 0.2 -c 1 -s 0 -t %d -W 4 %s", new Object[] { Integer.valueOf(this.b), paramString });
    long l = System.currentTimeMillis();
    Process localProcess = Runtime.getRuntime().exec((String)localObject);
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(localProcess.getInputStream()));
    localObject = "";
    for (;;)
    {
      String str2 = localBufferedReader.readLine();
      if (str2 == null) {
        break;
      }
      String str1 = (String)localObject + str2 + "\n";
      if (!str2.contains("From"))
      {
        localObject = str1;
        if (!str2.contains("from")) {}
      }
      else
      {
        this.jdField_a_of_type_Float = ((float)(System.currentTimeMillis() - l));
        localObject = str1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("UnifiedTraceRouter", 2, "ping url = " + paramString + " result = " + (String)localObject);
    }
    try
    {
      localProcess.destroy();
      if (((String)localObject).equals("")) {
        throw new IllegalArgumentException("ping result is empty");
      }
      if (this.b == 1)
      {
        this.j = c((String)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("UnifiedTraceRouter", 2, "final ip: " + this.j);
        }
      }
      return (String)localObject;
    }
    catch (Exception paramString)
    {
      for (;;) {}
    }
  }
  
  public void a(long paramLong, String paramString, Map paramMap)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new vxa(this, paramString, paramLong, paramMap));
  }
  
  public String b(String paramString)
  {
    Object localObject2 = null;
    int m;
    int n;
    Object localObject1;
    if (paramString.contains("From"))
    {
      paramString = paramString.substring(paramString.indexOf("From") + 5);
      if (paramString.contains("("))
      {
        m = paramString.indexOf("(");
        n = paramString.indexOf(")");
        localObject1 = paramString;
        if (m >= 0)
        {
          localObject1 = paramString;
          if (n >= 0) {
            localObject1 = paramString.substring(m + 1, n);
          }
        }
      }
    }
    do
    {
      do
      {
        return (String)localObject1;
        paramString = paramString.substring(0, paramString.indexOf("\n"));
        if (paramString.contains(":")) {}
        for (m = paramString.indexOf(":");; m = paramString.indexOf(" "))
        {
          localObject1 = paramString;
          if (m <= 0) {
            break;
          }
          return paramString.substring(0, m);
        }
        m = paramString.indexOf("(");
        n = paramString.indexOf(")");
        localObject1 = localObject2;
      } while (m < 0);
      localObject1 = localObject2;
    } while (n < 0);
    return paramString.substring(m + 1, n);
  }
  
  public String c(String paramString)
  {
    String str = "";
    if (paramString.contains("PING")) {
      str = paramString.substring(paramString.indexOf("(") + 1, paramString.indexOf(")"));
    }
    return str;
  }
  
  public String d(String paramString)
  {
    String str = "";
    if (paramString.contains("time="))
    {
      paramString = paramString.substring(paramString.indexOf("time=") + 5);
      str = paramString.substring(0, paramString.indexOf(" "));
    }
    return str;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\unifiedebug\UnifiedTraceRouter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */