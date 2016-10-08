package com.tencent.mobileqq.msf.core.a;

import com.tencent.qphone.base.util.QLog;
import java.io.InputStream;
import java.util.Map;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class c
{
  public static void a(InputStream paramInputStream, Map paramMap, String paramString)
  {
    try
    {
      SAXParserFactory.newInstance().newSAXParser().parse(paramInputStream, new f(paramString, paramMap));
      paramInputStream.close();
      return;
    }
    catch (Exception paramInputStream)
    {
      QLog.d("MSF.C.ConfigManager", 1, " " + paramInputStream, paramInputStream);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\msf\core\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */