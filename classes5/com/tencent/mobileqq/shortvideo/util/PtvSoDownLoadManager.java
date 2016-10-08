package com.tencent.mobileqq.shortvideo.util;

import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.earlydownload.handler.QQShortVideoHandler;
import com.tencent.mobileqq.earlydownload.handler.QQShortVideoHandlerX86;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.VideoEnvironment.ShortVideoDownload;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.video.decode.ShortVideoSoLoad;
import usq;
import usr;

public class PtvSoDownLoadManager
{
  private static final String jdField_a_of_type_JavaLangString = "PtvSoDownLoadManager";
  private static volatile boolean jdField_a_of_type_Boolean;
  private static volatile boolean b;
  private static volatile boolean c;
  private static volatile boolean d;
  
  public PtvSoDownLoadManager()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(AppInterface paramAppInterface, boolean paramBoolean, VideoEnvironment.ShortVideoDownload paramShortVideoDownload)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    paramShortVideoDownload = new usr(paramShortVideoDownload, paramBoolean, null);
    if (ShortVideoUtils.a()) {
      paramShortVideoDownload.b(101);
    }
    do
    {
      do
      {
        return;
        if (!jdField_a_of_type_Boolean)
        {
          ShortVideoUtils.a(paramAppInterface);
          if (ShortVideoUtils.a())
          {
            paramShortVideoDownload.b(101);
            return;
          }
          if (ShortVideoSoLoad.VIDEO_SO_LOAD_STATUS == -5) {
            jdField_a_of_type_Boolean = true;
          }
        }
        if ((b) && (jdField_a_of_type_Boolean))
        {
          paramShortVideoDownload.b(-3);
          return;
        }
        if (!NetworkUtil.h(null))
        {
          paramShortVideoDownload.b(-4);
          return;
        }
        VideoEnvironment.a(paramShortVideoDownload);
        paramAppInterface = (EarlyDownloadManager)paramAppInterface.getManager(76);
        if (!VideoEnvironment.c()) {
          break;
        }
        paramAppInterface = (QQShortVideoHandlerX86)paramAppInterface.a("qq.android.native.short.video.x86");
      } while ((paramAppInterface == null) || ((!paramAppInterface.jdField_a_of_type_Boolean) && (paramAppInterface.jdField_a_of_type_Int >= 3)));
      if (!paramBoolean) {
        bool1 = true;
      }
      paramAppInterface.jdField_a_of_type_Boolean = bool1;
      paramAppInterface.jdField_a_of_type_Int += 1;
      paramAppInterface.a(true);
      return;
      paramAppInterface = (QQShortVideoHandler)paramAppInterface.a("qq.android.native.short.video");
    } while ((paramAppInterface == null) || ((!paramAppInterface.jdField_a_of_type_Boolean) && (paramAppInterface.jdField_a_of_type_Int >= 3)));
    bool1 = bool2;
    if (!paramBoolean) {
      bool1 = true;
    }
    paramAppInterface.jdField_a_of_type_Boolean = bool1;
    paramAppInterface.jdField_a_of_type_Int += 1;
    paramAppInterface.a(true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, PtvFilterSoLoad.FilterVideoSoCallback paramFilterVideoSoCallback, boolean paramBoolean)
  {
    usq localusq = new usq(paramFilterVideoSoCallback, null);
    switch (PtvFilterSoLoad.a(BaseApplicationImpl.getContext()))
    {
    }
    do
    {
      do
      {
        do
        {
          return;
          paramFilterVideoSoCallback.a(-2);
        } while (!QLog.isColorLevel());
        QLog.d("PtvSoDownLoadManager", 2, "filterSo not supported device");
        return;
        paramFilterVideoSoCallback.a(101);
      } while (!QLog.isColorLevel());
      QLog.d("PtvSoDownLoadManager", 2, "filterSo already exist");
      return;
      if (!NetworkUtil.h(null))
      {
        localusq.a(-4);
        return;
      }
      PtvFilterSoLoad.a(localusq);
      PtvFilterSoLoad.a(paramQQAppInterface, paramBoolean);
    } while (!QLog.isColorLevel());
    QLog.d("PtvSoDownLoadManager", 2, "start download filterSo");
  }
  
  public static void a(VideoEnvironment.ShortVideoDownload paramShortVideoDownload)
  {
    VideoEnvironment.b(new usr(paramShortVideoDownload, false, null));
  }
  
  public static void a(PtvFilterSoLoad.FilterVideoSoCallback paramFilterVideoSoCallback)
  {
    PtvFilterSoLoad.b(new usq(paramFilterVideoSoCallback, null));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\util\PtvSoDownLoadManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */