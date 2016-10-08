package com.tencent.mobileqq.earlydownload.handler;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.PrecoverData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class PrecoverHandler
  extends EarlyHandler
{
  public static final String a = "PrecoverHandler";
  public static final String b = "qq.android.early.precover";
  
  public PrecoverHandler(QQAppInterface paramQQAppInterface)
  {
    super("qq.android.early.precover", paramQQAppInterface);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public Class a()
  {
    return PrecoverData.class;
  }
  
  public String a()
  {
    return "actEarlyPrecover";
  }
  
  public void b(XmlData paramXmlData)
  {
    super.b(paramXmlData);
    if ((QLog.isColorLevel()) && (paramXmlData != null) && ((paramXmlData instanceof PrecoverData))) {
      QLog.d("PrecoverHandler", 2, new Object[] { "doOnServerResp, xmlData=", paramXmlData });
    }
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean d()
  {
    File localFile = new File(c());
    return (localFile != null) && (localFile.exists());
  }
  
  public boolean k()
  {
    File localFile = new File(d());
    return (localFile != null) && (localFile.exists());
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\earlydownload\handler\PrecoverHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */