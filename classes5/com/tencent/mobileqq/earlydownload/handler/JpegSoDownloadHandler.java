package com.tencent.mobileqq.earlydownload.handler;

import android.os.Build;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.JpegSoData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pic.JpegCompressor;
import com.tencent.mobileqq.pic.JpegSoLoad;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

public class JpegSoDownloadHandler
  extends EarlyHandler
{
  public static final String a = "QJpegSoDownloadHandler";
  public static final String b = "qq.android.pic.jpeg.so";
  long jdField_a_of_type_Long;
  boolean jdField_a_of_type_Boolean;
  QQAppInterface b;
  
  public JpegSoDownloadHandler(QQAppInterface paramQQAppInterface)
  {
    super("qq.android.pic.jpeg.so", paramQQAppInterface);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = null;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Boolean = true;
    this.b = paramQQAppInterface;
  }
  
  public JpegSoDownloadHandler(String paramString, QQAppInterface paramQQAppInterface)
  {
    super(paramString, paramQQAppInterface);
    this.b = null;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Boolean = true;
    this.b = paramQQAppInterface;
  }
  
  public Class a()
  {
    return JpegSoData.class;
  }
  
  public String a()
  {
    return "qjpegDownloadSoDuration";
  }
  
  public void a(String paramString)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("QJpegSoDownloadHandler", 2, "download success: " + paramString);
      }
      FileUtils.a(paramString, JpegSoLoad.getJpegSolibPath(BaseApplicationImpl.getContext()), false);
      JpegCompressor.jpegcompressLoadSo();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    super.a(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    if (a().loadState == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QJpegSoDownloadHandler", 2, "is in downloading");
      }
      return;
    }
    super.a(paramBoolean);
  }
  
  public void b(XmlData paramXmlData)
  {
    if (paramXmlData == null) {
      return;
    }
    String str = Build.CPU_ABI;
    JpegSoData localJpegSoData = (JpegSoData)paramXmlData;
    if ((str != null) && (!"".equals(str)) && ("armeabi-v7a".equalsIgnoreCase(str)))
    {
      str = paramXmlData.strResURL_big;
      paramXmlData.strResURL_big = paramXmlData.strResURL_small;
      paramXmlData.strResURL_small = str;
      if (QLog.isColorLevel()) {
        QLog.d("QJpegSoDownloadHandler", 2, "doOnServerResp[armeabi-v7a]");
      }
      if (QLog.isColorLevel())
      {
        QLog.d("QJpegSoDownloadHandler", 2, "   arm_md5=" + paramXmlData.MD5);
        QLog.d("QJpegSoDownloadHandler", 2, "armv7a_md5=" + localJpegSoData.v7a_MD5);
      }
      str = paramXmlData.MD5;
      paramXmlData.MD5 = localJpegSoData.v7a_MD5;
      localJpegSoData.v7a_MD5 = str;
    }
    super.b(paramXmlData);
  }
  
  public boolean b()
  {
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\earlydownload\handler\JpegSoDownloadHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */