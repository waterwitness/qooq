package com.tencent.biz.common.util;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import hhi;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CommUtils
{
  private static final String a = CommUtils.class.getName();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static String a(String paramString)
  {
    localStringBuffer = new StringBuffer();
    try
    {
      paramString = new BufferedReader(new InputStreamReader(((HttpURLConnection)new URL(paramString).openConnection()).getInputStream()));
      for (;;)
      {
        String str = paramString.readLine();
        if (str == null) {
          break;
        }
        localStringBuffer.append(str);
      }
      return localStringBuffer.toString();
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "http error");
      }
    }
  }
  
  public static void a(String paramString, CommUtils.IHttpGetString paramIHttpGetString)
  {
    new hhi(paramIHttpGetString, paramString).execute(new Void[0]);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\common\util\CommUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */