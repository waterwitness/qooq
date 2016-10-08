package com.tencent.bitapp;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.structmsg.StructMsgUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

public class BitAppMsgUtils
{
  public BitAppMsgUtils()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static BitAppMsgNode a(byte[] paramArrayOfByte, int paramInt)
  {
    paramArrayOfByte = a(paramArrayOfByte, paramInt);
    BitAppMsgParserHandler localBitAppMsgParserHandler;
    SAXParserFactory localSAXParserFactory;
    if (paramArrayOfByte != null)
    {
      paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
      localBitAppMsgParserHandler = new BitAppMsgParserHandler();
      localSAXParserFactory = SAXParserFactory.newInstance();
    }
    try
    {
      localSAXParserFactory.newSAXParser().parse(paramArrayOfByte, localBitAppMsgParserHandler);
      paramArrayOfByte.close();
      paramArrayOfByte = localBitAppMsgParserHandler.a();
      if ((paramArrayOfByte != null) && (QLog.isColorLevel())) {
        QLog.d("BitAppMsg", 2, "getBitAppMsgFromXmlBuff decode node success");
      }
      return paramArrayOfByte;
    }
    catch (ParserConfigurationException paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.e("BitAppMsg", 2, "getBitAppMsgFromXmlBuff", paramArrayOfByte);
      }
      return null;
    }
    catch (SAXException paramArrayOfByte)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("BitAppMsg", 2, "getBitAppMsgFromXmlBuff", paramArrayOfByte);
        }
      }
    }
    catch (IOException paramArrayOfByte)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("BitAppMsg", 2, "getBitAppMsgFromXmlBuff", paramArrayOfByte);
        }
      }
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("BitAppMsg", 2, "getBitAppMsgFromXmlBuff", paramArrayOfByte);
        }
      }
    }
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BitAppMsg", 2, "getBitAppMsgFromXmlBuff xmlbuff is null or lenght < 2");
      }
      return null;
    }
    paramArrayOfByte = StructMsgUtils.a(paramArrayOfByte, paramInt);
    try
    {
      new String(paramArrayOfByte, "utf-8");
      return paramArrayOfByte;
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\bitapp\BitAppMsgUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */