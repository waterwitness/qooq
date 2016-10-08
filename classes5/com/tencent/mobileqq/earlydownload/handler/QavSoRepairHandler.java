package com.tencent.mobileqq.earlydownload.handler;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.EarlyDataFactory;
import com.tencent.mobileqq.earlydownload.xmldata.QavSoRepairData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class QavSoRepairHandler
  extends QavSoDownloadHandlerBase
{
  public static final String a = "QavSoRepairHandler";
  public static final String f = "qq.android.qav.sorepair.all";
  public static final String g = "5.7";
  
  public QavSoRepairHandler(QQAppInterface paramQQAppInterface)
  {
    super("qq.android.qav.sorepair.all", paramQQAppInterface);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public Class a()
  {
    return QavSoRepairData.class;
  }
  
  public void a(boolean paramBoolean)
  {
    QavSoRepairData localQavSoRepairData = (QavSoRepairData)a();
    if ((localQavSoRepairData != null) && (!localQavSoRepairData.autoDownload))
    {
      localQavSoRepairData.autoDownload = true;
      EarlyDataFactory.a(localQavSoRepairData, new String[] { "autoDownload" });
    }
    super.a(paramBoolean);
  }
  
  public void b(XmlData paramXmlData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavSoRepairHandler", 2, "func doOnServerResp begins, respData" + paramXmlData);
    }
    if ((paramXmlData == null) || (!(paramXmlData instanceof QavSoRepairData)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QavSoRepairHandler", 2, "func doOnServerResp ends. respData is not QavSoRepairData");
      }
      super.b(paramXmlData);
      return;
    }
    QavSoRepairData localQavSoRepairData = (QavSoRepairData)paramXmlData;
    if ("5.7".equals("5.7"))
    {
      paramXmlData.MD5 = localQavSoRepairData.m_57;
      paramXmlData.strResURL_big = localQavSoRepairData.v_57;
      paramXmlData.strResURL_small = localQavSoRepairData.v_57;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QavSoRepairHandler", 2, "url:" + paramXmlData.strResURL_big + ", md5:" + paramXmlData.MD5);
    }
    super.b(paramXmlData);
  }
  
  public boolean d_()
  {
    return ((QavSoRepairData)a()).autoDownload;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\earlydownload\handler\QavSoRepairHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */