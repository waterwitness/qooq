package com.tencent.mobileqq.earlydownload.handler;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.QQShortVideoDataX86;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;

public class QQShortVideoHandlerX86
  extends EarlyHandler
{
  public static final String a = "QQShortVideoHandlerX86";
  public static final String b = "qq.android.native.short.video.x86";
  public int a;
  private Handler a;
  public boolean a;
  public int b;
  QQAppInterface b;
  
  public QQShortVideoHandlerX86(QQAppInterface paramQQAppInterface)
  {
    super("qq.android.native.short.video.x86", paramQQAppInterface);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (QLog.isColorLevel()) {
      QLog.d("QQShortVideoHandlerX86", 2, "create QQShortVideoHandlerX86");
    }
  }
  
  public QQShortVideoHandlerX86(String paramString, QQAppInterface paramQQAppInterface)
  {
    super(paramString, paramQQAppInterface);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public Class a()
  {
    return QQShortVideoDataX86.class;
  }
  
  public String a()
  {
    return "QQShortVideoHandlerX86";
  }
  
  public void a(XmlData paramXmlData)
  {
    QLog.e("QQShortVideoHandlerX86", 1, "short_X86So goDownloadFail");
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
        QLog.d("QQShortVideoHandlerX86", 2, "download success: " + paramString);
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
      QLog.i("QQShortVideoHandlerX86", 2, "curOffset " + paramLong1 + ", totalLen " + paramLong2);
    }
    this.jdField_b_of_type_Int = ((int)(100L * paramLong1 / paramLong2));
    VideoEnvironment.a(this.jdField_b_of_type_Int);
  }
  
  public void b(XmlData paramXmlData)
  {
    if (paramXmlData == null) {}
    QQShortVideoDataX86 localQQShortVideoDataX86;
    boolean bool;
    do
    {
      return;
      localQQShortVideoDataX86 = (QQShortVideoDataX86)paramXmlData;
      bool = VideoEnvironment.c();
      if (bool) {
        super.b(paramXmlData);
      }
    } while (!QLog.isColorLevel());
    QLog.d("QQShortVideoHandlerX86", 2, "doOnServerResp: mIsX86Platform=" + bool + " md5=" + localQQShortVideoDataX86.MD5 + " abi=" + Build.CPU_ABI + " abi2=" + Build.CPU_ABI2);
  }
  
  public boolean b()
  {
    return true;
  }
  
  public boolean d_()
  {
    boolean bool = VideoEnvironment.d(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.d("QQShortVideoHandlerX86", 2, "isUserNeedDownload called  flag=" + bool);
    }
    return bool;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\earlydownload\handler\QQShortVideoHandlerX86.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */