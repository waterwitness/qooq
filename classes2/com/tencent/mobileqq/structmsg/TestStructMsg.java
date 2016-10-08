package com.tencent.mobileqq.structmsg;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

public class TestStructMsg
{
  private static final String a = TestStructMsg.class.getSimpleName();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static AbsStructMsg a(String paramString)
  {
    paramString = new ByteArrayInputStream(paramString.getBytes());
    StructMsgParserHandler localStructMsgParserHandler = new StructMsgParserHandler();
    SAXParserFactory localSAXParserFactory = SAXParserFactory.newInstance();
    try
    {
      localSAXParserFactory.newSAXParser().parse(paramString, localStructMsgParserHandler);
      paramString.close();
      paramString = localStructMsgParserHandler.a();
      return paramString;
    }
    catch (ParserConfigurationException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e(a, 2, "getStructMsgFromXmlBuffByStream", paramString);
      }
      return null;
    }
    catch (SAXException paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e(a, 2, "getStructMsgFromXmlBuffByStream", paramString);
        }
      }
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e(a, 2, "getStructMsgFromXmlBuffByStream", paramString);
        }
      }
    }
  }
  
  public static String a(String paramString)
  {
    try
    {
      paramString = new FileInputStream(paramString);
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      byte[] arrayOfByte = new byte['Ѐ'];
      for (;;)
      {
        int i = paramString.read(arrayOfByte, 0, 1024);
        if (i == -1) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      paramString = new String(localByteArrayOutputStream.toByteArray(), "utf-8");
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
      return "";
    }
    return paramString;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\structmsg\TestStructMsg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */