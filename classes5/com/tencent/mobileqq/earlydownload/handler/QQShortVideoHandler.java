package com.tencent.mobileqq.earlydownload.handler;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.QQShortVideoData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;

public class QQShortVideoHandler
  extends EarlyHandler
{
  public static final String a = "QQShortVideoHandler";
  public static final String b = "qq.android.native.short.video";
  public int a;
  private Handler a;
  public boolean a;
  public int b;
  QQAppInterface b;
  
  public QQShortVideoHandler(QQAppInterface paramQQAppInterface)
  {
    super("qq.android.native.short.video", paramQQAppInterface);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (QLog.isColorLevel()) {
      QLog.d("QQShortVideoHandler", 2, "create QQShortVideoHandler");
    }
  }
  
  public QQShortVideoHandler(String paramString, QQAppInterface paramQQAppInterface)
  {
    super(paramString, paramQQAppInterface);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public Class a()
  {
    return QQShortVideoData.class;
  }
  
  public String a()
  {
    return "QQShortVideoHandler";
  }
  
  public void a(XmlData paramXmlData)
  {
    QLog.e("QQShortVideoHandler", 1, "shortSo goDownloadFail");
    super.a(paramXmlData);
  }
  
  public void a(XmlData paramXmlData, boolean paramBoolean, int paramInt, String paramString)
  {
    if (!paramBoolean) {
      VideoEnvironment.a(false, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    super.a(paramXmlData, paramBoolean, paramInt, paramString);
  }
  
  public void a(String paramString)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQShortVideoHandler", 2, "download success: " + paramString);
      }
      VideoEnvironment.a(paramString);
      VideoEnvironment.a(true, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
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
      QLog.i("QQShortVideoHandler", 2, "curOffset " + paramLong1 + ", totalLen " + paramLong2);
    }
    this.jdField_b_of_type_Int = ((int)(100L * paramLong1 / paramLong2));
    VideoEnvironment.a(this.jdField_b_of_type_Int);
  }
  
  public void b(XmlData paramXmlData)
  {
    if (paramXmlData == null) {}
    String str;
    QQShortVideoData localQQShortVideoData;
    do
    {
      return;
      str = Build.CPU_ABI;
      localQQShortVideoData = (QQShortVideoData)paramXmlData;
      bool = VideoEnvironment.c();
      if (QLog.isColorLevel()) {
        QLog.d("QQShortVideoHandler", 2, "doOnServerResp:mIsX86Platform=" + bool + " abi=" + str);
      }
    } while (bool);
    boolean bool = VcSystemInfo.a("neon");
    if ((str != null) && (!"".equals(str)) && ("armeabi-v7a".equalsIgnoreCase(str)) && (bool))
    {
      str = paramXmlData.strResURL_big;
      paramXmlData.strResURL_big = paramXmlData.strResURL_small;
      paramXmlData.strResURL_small = str;
      if (QLog.isColorLevel()) {
        QLog.d("QQShortVideoHandler", 2, "doOnServerResp[armeabi-v7a]");
      }
      if (QLog.isColorLevel())
      {
        QLog.d("QQShortVideoHandler", 2, "   arm_md5=" + paramXmlData.MD5);
        QLog.d("QQShortVideoHandler", 2, "armv7a_md5=" + localQQShortVideoData.v7a_MD5);
      }
      str = paramXmlData.MD5;
      paramXmlData.MD5 = localQQShortVideoData.v7a_MD5;
      localQQShortVideoData.v7a_MD5 = str;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQShortVideoHandler", 2, "doOnServerResp");
    }
    super.b(paramXmlData);
  }
  
  public boolean b()
  {
    return true;
  }
  
  public boolean d_()
  {
    boolean bool = VideoEnvironment.d(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.d("QQShortVideoHandler", 2, "isUserNeedDownload called  flag=" + bool);
    }
    return bool;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\earlydownload\handler\QQShortVideoHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */