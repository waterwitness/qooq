package com.tencent.mobileqq.shortvideo.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager.DpcAccountNames;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.video.decode.ShortVideoSoLoad;
import java.io.File;
import mqq.app.MobileQQ;
import uss;

public class ShortVideoGuideUtil
{
  public static String a;
  static boolean a = false;
  public static final String b = "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==";
  public static final String c = "faceu_reddot_click_sp";
  public static final String d = "faceu_reddot_click_sp";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = "ShortVideoGuideUtil";
  }
  
  private static void a()
  {
    ThreadManager.a(new uss(), 2, null, false);
  }
  
  private static boolean a(Context paramContext)
  {
    boolean bool = true;
    if (paramContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "isSDKloaded context= null");
      }
      return false;
    }
    if (!jdField_a_of_type_Boolean)
    {
      TVK_SDKMgr.initSdk(paramContext, "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
      jdField_a_of_type_Boolean = true;
    }
    if (TVK_SDKMgr.isInstalled(paramContext)) {}
    for (;;)
    {
      return bool;
      bool = false;
      a();
    }
  }
  
  public static boolean a(AppInterface paramAppInterface)
  {
    if (!e(paramAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "isGuideReaded isPubicSo= false");
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "isGuideReaded isPubicSo= true");
    }
    return true;
  }
  
  public static boolean a(AppInterface paramAppInterface, Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent(paramActivity, NewFlowCameraActivity.class);
    localIntent.putExtra("callback", paramString);
    localIntent.putExtra("flow_key_from_guide", true);
    paramString = new SessionInfo();
    paramString.a = 0;
    localIntent.putExtra("PhotoConst.SEND_SESSION_INFO", paramString);
    localIntent.putExtra("sv_config", DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.NewShortVideoConfig.name(), null));
    localIntent.putExtra("sv_whitelist", DeviceProfileManager.a().a(DeviceProfileManager.AccountDpcManager.DpcAccountNames.picpredownload_whitelist.name()));
    localIntent.putExtra("flow_camera_use_filter_function", true);
    localIntent.putExtra("flow_camera_video_mode", true);
    boolean bool = d(paramAppInterface);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "startNextActivity isNeedRed=" + bool);
    }
    if (bool) {
      localIntent.putExtra("flow_camera_show_redDot", true);
    }
    localIntent.setClass(paramActivity, NewFlowCameraActivity.class);
    paramActivity.startActivityForResult(localIntent, 11000);
    return true;
  }
  
  public static boolean b(AppInterface paramAppInterface)
  {
    if (!PtvFilterSoLoad.SVFilterSoLoadStatus.b(paramAppInterface.getApplication().getApplicationContext())) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "ispublicResReady isFilterSoExist fasle");
      }
    }
    String str;
    do
    {
      do
      {
        return false;
        if (VideoEnvironment.d()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "ispublicResReady getAVCodecVersionOK fasle");
      return false;
      paramAppInterface = ShortVideoSoLoad.getShortVideoSoPath(BaseApplicationImpl.getContext());
      str = ShortVideoSoLoad.getLibActualName("AVCodec");
      if (new File(paramAppInterface + str).exists()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "ispublicResReady isVideoSo fasle file is not exist " + paramAppInterface + str);
    return false;
    return true;
  }
  
  public static boolean c(AppInterface paramAppInterface)
  {
    boolean bool3 = true;
    if (paramAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "isRedDotShow app= null");
      }
      return false;
    }
    if (f(paramAppInterface)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (PtvTemplateManager.a(paramAppInterface).d()) {}
      for (boolean bool2 = true;; bool2 = false)
      {
        if ((bool1) && (bool2)) {}
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "isRedDotShow isPubicSo=" + bool1 + "    isguideVideo" + bool2);
          }
          return bool3;
          bool3 = false;
        }
      }
    }
  }
  
  public static boolean d(AppInterface paramAppInterface)
  {
    boolean bool1 = true;
    boolean bool2 = BaseApplicationImpl.a().getSharedPreferences("faceu_reddot_click_sp", 4).getBoolean("faceu_reddot_click_sp", false);
    if (QLog.isColorLevel()) {
      QLog.d("faceGuide", 2, "isNeedRedFromGuide hasClicked =" + bool2);
    }
    if (!bool2) {
      if (!PtvTemplateManager.a(paramAppInterface).d()) {
        break label123;
      }
    }
    label123:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("faceGuide", 2, "isNeedRedFromGuide isloaded false");
        }
        return false;
        bool1 = false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("faceGuide", 2, "isNeedRedFromGuide isNeed =" + bool1);
      }
      return bool1;
    }
  }
  
  public static boolean e(AppInterface paramAppInterface)
  {
    boolean bool2 = PtvFilterSoLoad.b();
    boolean bool1;
    if (!bool2)
    {
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "ispublicResReady iissupportFilterSo is false");
        bool1 = bool2;
      }
    }
    do
    {
      return bool1;
      if (VideoEnvironment.b(paramAppInterface)) {
        break;
      }
      bool1 = false;
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "ispublicResReady isVersion fasle");
    return false;
    return true;
  }
  
  public static boolean f(AppInterface paramAppInterface)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    boolean bool3 = PtvFilterSoLoad.b();
    if (!bool3)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "ispublicResReady iissupportFilterSo is false");
      }
      bool2 = bool3;
    }
    String str1;
    String str2;
    do
    {
      do
      {
        do
        {
          do
          {
            return bool2;
            if (VideoEnvironment.b(paramAppInterface)) {
              break;
            }
            bool2 = bool1;
          } while (!QLog.isColorLevel());
          QLog.d(jdField_a_of_type_JavaLangString, 2, "ispublicResReady isVersion fasle");
          return false;
          if (PtvFilterSoLoad.SVFilterSoLoadStatus.b(paramAppInterface.getApplication().getApplicationContext())) {
            break;
          }
          bool2 = bool1;
        } while (!QLog.isColorLevel());
        QLog.d(jdField_a_of_type_JavaLangString, 2, "ispublicResReady isFilterSoExist fasle");
        return false;
        if (VideoEnvironment.d()) {
          break;
        }
        bool2 = bool1;
      } while (!QLog.isColorLevel());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "ispublicResReady getAVCodecVersionOK fasle");
      return false;
      str1 = ShortVideoSoLoad.getShortVideoSoPath(BaseApplicationImpl.getContext());
      str2 = ShortVideoSoLoad.getLibActualName("AVCodec");
      if (new File(str1 + str2).exists()) {
        break;
      }
      bool2 = bool1;
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "ispublicResReady isVideoSo fasle file is not exist " + str1 + str2);
    return false;
    if (a(BaseApplicationImpl.a().getApplicationContext())) {}
    for (int i = 1;; i = 0)
    {
      if (PtvTemplateManager.a(paramAppInterface).e()) {}
      for (bool3 = true;; bool3 = false)
      {
        bool1 = bool2;
        if (bool3)
        {
          bool1 = bool2;
          if (i != 0) {
            bool1 = true;
          }
        }
        bool2 = bool1;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "ispublicResReady isVideoSo=" + true + "    isFilterSo" + true + "   isTemplateConfig=" + bool3);
        return bool1;
      }
    }
  }
  
  public static boolean g(AppInterface paramAppInterface)
  {
    boolean bool = true;
    if (paramAppInterface.a() == null) {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "isAccLoginSucdess false.");
      }
    }
    do
    {
      do
      {
        return false;
        if (a(paramAppInterface)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i(jdField_a_of_type_JavaLangString, 2, "isGuideReaded false.");
      return false;
      if (PtvFilterSoLoad.a(BaseApplicationImpl.getContext()) == 1) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "ispublicResReady iissupportFilterSo is false");
    return false;
    if (ShortVideoUtils.a()) {}
    for (;;)
    {
      return bool;
      ShortVideoUtils.a(paramAppInterface);
      if (!ShortVideoUtils.a()) {
        bool = false;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\util\ShortVideoGuideUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */