package com.tencent.mobileqq.ark;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.NetEngineFactory;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import qqv;

public class ArkAppDataReport
{
  private static final String a = "ArkApp.DataReport";
  private static final String b = "0X8006137";
  private static final String c = "GetAppPathByName";
  private static final String d = "UpdateLocalApp";
  
  public ArkAppDataReport()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    if (paramInt != 0) {}
    for (boolean bool = true;; bool = false)
    {
      a(paramQQAppInterface, "UpdateLocalApp." + paramString + "." + Boolean.toString(bool), 0);
      a(paramQQAppInterface, "QQ/UpdateApp", bool, paramInt, 0, paramString);
      return;
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8006137", paramString, 0, paramInt, "", "", "", "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    if (paramInt1 == 0) {}
    for (boolean bool = true;; bool = false)
    {
      a(paramQQAppInterface, "GetAppPathByName." + Boolean.toString(bool), (int)paramLong);
      a(paramQQAppInterface, "QQ/GetAppByName", bool, paramInt1, (int)paramLong, paramString);
      return;
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, String paramString1, boolean paramBoolean, int paramInt1, int paramInt2, String paramString2)
  {
    if (paramQQAppInterface == null) {}
    for (;;)
    {
      return;
      if ((paramString1 != null) && (paramString1.length() != 0))
      {
        String str1 = paramQQAppInterface.f();
        Object localObject = new HashMap();
        ((HashMap)localObject).put("domain", "ark.qq.com");
        ((HashMap)localObject).put("cgi", paramString1);
        if (paramBoolean) {}
        for (paramString1 = "1";; paramString1 = "2")
        {
          ((HashMap)localObject).put("type", paramString1);
          ((HashMap)localObject).put("code", Integer.toString(paramInt1));
          ((HashMap)localObject).put("time", Integer.toString(paramInt2));
          ((HashMap)localObject).put("uin", str1);
          if (paramString2 != null) {
            ((HashMap)localObject).put("data", paramString2);
          }
          paramString1 = new StringBuilder();
          paramString2 = ((HashMap)localObject).keySet().iterator();
          while (paramString2.hasNext())
          {
            str1 = (String)paramString2.next();
            String str2 = (String)((HashMap)localObject).get(str1);
            if (paramString1.length() > 0) {
              paramString1.append('&');
            }
            try
            {
              paramString1.append(String.format("%s=%s", new Object[] { URLEncoder.encode(str1, "UTF-8"), URLEncoder.encode(str2, "UTF-8") }));
            }
            catch (Exception localException)
            {
              ArkAppCenter.c("ArkApp.DataReport", "report_realtime_monitor, URLEncoder fail, msg=" + localException.getMessage());
            }
          }
        }
        paramString2 = "http://c.isdspeed.qq.com/code.cgi?" + paramString1.toString();
        localObject = new ByteArrayOutputStream();
        paramString1 = new HttpNetReq();
        paramString1.jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
        paramString1.c = 0;
        paramString1.jdField_a_of_type_JavaLangString = paramString2;
        paramString1.m = 1;
        paramString1.d = 30L;
        paramString1.jdField_a_of_type_JavaIoOutputStream = ((OutputStream)localObject);
        paramString1.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = new qqv();
        paramString2 = (NetEngineFactory)paramQQAppInterface.getManager(20);
        if (paramString2 != null) {}
        for (paramQQAppInterface = paramString2.a(paramQQAppInterface, 0); paramQQAppInterface != null; paramQQAppInterface = null)
        {
          paramQQAppInterface.a(paramString1);
          return;
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\ark\ArkAppDataReport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */