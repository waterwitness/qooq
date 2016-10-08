package com.tencent.mobileqq.earlydownload.handler;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.QavSoDataBase;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.startup.step.UpdateAvSo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

public abstract class QavSoDownloadHandlerBase
  extends EarlyHandler
{
  public static final String b = "QavSoDownloadHandlerBase";
  
  public QavSoDownloadHandlerBase(String paramString, QQAppInterface paramQQAppInterface)
  {
    super(paramString, paramQQAppInterface);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public String a()
  {
    return "qavDownloadSoDuration";
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavSoDownloadHandlerBase", 2, "download success: " + paramString);
    }
    try
    {
      FileUtils.a(paramString, UpdateAvSo.a(), false);
      super.a(paramString);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void b(XmlData paramXmlData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavSoDownloadHandlerBase", 2, "func doOnServerResp begins, respData" + paramXmlData);
    }
    if ((paramXmlData == null) || (!(paramXmlData instanceof QavSoDataBase)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QavSoDownloadHandlerBase", 2, "func doOnServerResp ends. respData is not QavSoDataBase");
      }
      super.b(paramXmlData);
      return;
    }
    QavSoDataBase localQavSoDataBase = (QavSoDataBase)paramXmlData;
    paramXmlData.MD5 = localQavSoDataBase.m_631;
    paramXmlData.strResURL_big = localQavSoDataBase.v_631;
    paramXmlData.strResURL_small = localQavSoDataBase.v_631;
    if (QLog.isColorLevel()) {
      QLog.d("QavSoDownloadHandlerBase", 2, "url:" + paramXmlData.strResURL_big + ", md5:" + paramXmlData.MD5);
    }
    super.b(paramXmlData);
  }
  
  public boolean b()
  {
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\earlydownload\handler\QavSoDownloadHandlerBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */