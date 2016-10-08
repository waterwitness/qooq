package com.tencent.mobileqq.earlydownload.handler;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.QQShortVideoConstFilterData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.qphone.base.util.QLog;

public class QQShortVideoConstFilterHandler
  extends EarlyHandler
{
  public static final String a = "QQShortVideoConstFilterHandler";
  public static final String b = "qq.android.native.short.video.filter.const.v1";
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler;
  public boolean a;
  QQAppInterface b;
  
  public QQShortVideoConstFilterHandler(QQAppInterface paramQQAppInterface)
  {
    super("qq.android.native.short.video.filter.const.v1", paramQQAppInterface);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = null;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_Boolean = true;
    this.b = paramQQAppInterface;
    if (QLog.isColorLevel()) {
      QLog.d("QQShortVideoConstFilterHandler", 2, "create QQShortVideoHandler");
    }
  }
  
  public Class a()
  {
    return QQShortVideoConstFilterData.class;
  }
  
  public String a()
  {
    return "QQShortVideoConstFilterHandler";
  }
  
  public void a(XmlData paramXmlData)
  {
    QLog.e("QQShortVideoConstFilterHandler", 1, "const goDownloadFail");
    super.a(paramXmlData);
  }
  
  public void a(XmlData paramXmlData, boolean paramBoolean, int paramInt, String paramString)
  {
    if (!paramBoolean) {
      PtvFilterSoLoad.a(false, this.b, null);
    }
    super.a(paramXmlData, paramBoolean, paramInt, paramString);
  }
  
  public void a(String paramString)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQShortVideoConstFilterHandler", 2, "download success: " + paramString);
      }
      PtvFilterSoLoad.a(true, this.b, paramString);
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
  
  public void b(long paramLong1, long paramLong2)
  {
    super.b(paramLong1, paramLong2);
    if (QLog.isColorLevel()) {
      QLog.i("QQShortVideoConstFilterHandler", 2, "curOffset " + paramLong1 + ", totalLen " + paramLong2);
    }
    this.jdField_a_of_type_Int = ((int)(100L * paramLong1 / paramLong2));
    PtvFilterSoLoad.a(this.jdField_a_of_type_Int);
  }
  
  public void b(XmlData paramXmlData)
  {
    if (paramXmlData == null) {}
    QQShortVideoConstFilterData localQQShortVideoConstFilterData;
    boolean bool;
    do
    {
      return;
      str = Build.CPU_ABI;
      localQQShortVideoConstFilterData = (QQShortVideoConstFilterData)paramXmlData;
      bool = PtvFilterSoLoad.b();
    } while ((str == null) || ("".equals(str)) || (!"armeabi-v7a".equalsIgnoreCase(str)) || (!bool));
    String str = paramXmlData.strResURL_big;
    paramXmlData.strResURL_big = paramXmlData.strResURL_small;
    paramXmlData.strResURL_small = str;
    if (QLog.isColorLevel()) {
      QLog.d("QQShortVideoConstFilterHandler", 2, "doOnServerResp[armeabi-v7a]");
    }
    if (QLog.isColorLevel())
    {
      QLog.d("QQShortVideoConstFilterHandler", 2, "   arm_md5=" + paramXmlData.MD5);
      QLog.d("QQShortVideoConstFilterHandler", 2, "armv7a_md5=" + localQQShortVideoConstFilterData.v7a_MD5);
    }
    str = paramXmlData.MD5;
    paramXmlData.MD5 = localQQShortVideoConstFilterData.v7a_MD5;
    localQQShortVideoConstFilterData.v7a_MD5 = str;
    if (QLog.isColorLevel()) {
      QLog.d("QQShortVideoConstFilterHandler", 2, "doOnServerResp");
    }
    super.b(paramXmlData);
  }
  
  public boolean b()
  {
    return true;
  }
  
  public void c(XmlData paramXmlData)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQShortVideoConstFilterHandler", 2, "const onDownloadBegin");
    }
    super.c(paramXmlData);
  }
  
  public boolean d_()
  {
    boolean bool = PtvFilterSoLoad.b();
    if (QLog.isColorLevel()) {
      QLog.d("QQShortVideoConstFilterHandler", 2, "isUserNeedDownload called  flag=" + bool);
    }
    return bool;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\earlydownload\handler\QQShortVideoConstFilterHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */