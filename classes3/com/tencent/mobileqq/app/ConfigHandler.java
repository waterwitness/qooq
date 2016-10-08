package com.tencent.mobileqq.app;

import MAAccessClient.AccessRsp;
import MAAccessClient.CheckSinglePkgSigRsp;
import MAAccessClient.GetSinglePkgSigRsp;
import MAAccessClient.NoCheckMarket;
import MAAccessClient.Tips;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.qq.taf.jce.JceInputStream;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.UpgradeActivity;
import com.tencent.mobileqq.activity.aio.anim.AioAnimationConfigHelper;
import com.tencent.mobileqq.activity.weather.WeatherManager;
import com.tencent.mobileqq.app.upgrade.UpgradeController;
import com.tencent.mobileqq.app.upgrade.UpgradeController.OnHandleUpgradeFinishListener;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper.NewApkInfo;
import com.tencent.mobileqq.config.operation.QQOperateManager;
import com.tencent.mobileqq.config.operation.QQOperationRequestTaskInfo;
import com.tencent.mobileqq.config.operation.QQOperationViopTipTask;
import com.tencent.mobileqq.config.operation.QQOperationVoipTipsTaskExcuteRecord;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.OperateVoipTipsInfo;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AppShareIDUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.JumpFilterHelper;
import com.tencent.mobileqq.vaswebviewplugin.ThemeUiPlugin;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.securitysdk.utils.ApkExternalInfoTool;
import com.tencent.securitysdk.utils.Verify;
import com.tencent.util.Pair;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import protocol.KQQConfig.GetResourceReqInfo;
import protocol.KQQConfig.GetResourceResp;
import protocol.KQQConfig.GetResourceRespInfo;
import protocol.KQQConfig.SDKUpgradeRes;
import protocol.KQQConfig.UpgradeInfo;
import pvv;
import pvw;
import pvx;
import pvy;
import pvz;
import pwa;
import pwb;
import pwc;
import pwd;
import pwe;
import tencent.im.mobiletips.MobileTips.MobileTipsPkg;
import tencent.im.mobiletips.MobileTips.ReqBody;
import tencent.im.mobiletips.MobileTips.RspBody;
import tencent.im.mobiletips.MobileTips.TaskInfo;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.im.s2c.msgtype0x210.SubMsgType0x43.UpdateTips;

public class ConfigHandler
  extends BusinessHandler
  implements UpgradeController.OnHandleUpgradeFinishListener
{
  public static final int a = 1;
  private static final String jdField_a_of_type_JavaLangString = "eggs_config.zip";
  public static final int b = 2;
  public static final String b = "k_eggs_file_version";
  public static final int c = 3;
  private static final String c = "eggs";
  public static final int d = 4;
  private static final String d = "VoiceNotify";
  public static final int e = 5;
  private static final String e = "k_voice_notify2_file_version";
  public static final int f = 6;
  public static final int g = 7;
  public static final int h = 8;
  public static final int i = 9;
  public static final int j = 10;
  public static final int k = 11;
  public static int l;
  private HashSet jdField_a_of_type_JavaUtilHashSet;
  private volatile boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public ConfigHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
  }
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    int m = paramQQAppInterface.getPreferences().getInt("UPGRADE_TIPS_SHOW_COUNT", 0);
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "ConfigHandler.getUpgradeTipsShowCount:" + m);
    }
    return m;
  }
  
  public static UpgradeDetailWrapper.NewApkInfo a(UpgradeInfo paramUpgradeInfo)
  {
    if ((paramUpgradeInfo != null) && (paramUpgradeInfo.strProgressName != null))
    {
      paramUpgradeInfo = paramUpgradeInfo.strProgressName;
      if (paramUpgradeInfo != null)
      {
        String[] arrayOfString = paramUpgradeInfo.split("\\|");
        try
        {
          paramUpgradeInfo = new UpgradeDetailWrapper.NewApkInfo();
          return null;
        }
        catch (Exception paramUpgradeInfo)
        {
          try
          {
            paramUpgradeInfo.jdField_a_of_type_JavaLangString = arrayOfString[2];
            paramUpgradeInfo.b = arrayOfString[1];
            paramUpgradeInfo.jdField_a_of_type_Long = Long.parseLong(arrayOfString[0]);
            paramUpgradeInfo.jdField_a_of_type_Int = Integer.parseInt(arrayOfString[3]);
            return paramUpgradeInfo;
          }
          catch (Exception localException)
          {
            return paramUpgradeInfo;
          }
          paramUpgradeInfo = paramUpgradeInfo;
          return null;
        }
      }
    }
  }
  
  private static String a()
  {
    Date localDate = new Date();
    int m = localDate.getYear();
    int n = localDate.getMonth();
    int i1 = localDate.getDay();
    return m + ":" + n + ":" + i1;
  }
  
  public static String a(Context paramContext)
  {
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1);
    if ((paramContext != null) && (paramContext.size() > 0) && (((ActivityManager.RunningTaskInfo)paramContext.get(0)).topActivity != null)) {
      return ((ActivityManager.RunningTaskInfo)paramContext.get(0)).topActivity.getClassName();
    }
    return null;
  }
  
  public static String a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.getPreferences();
    String str1 = paramQQAppInterface.getString("UPGRADE_BANNER_URL", null);
    if (str1 == null) {
      return null;
    }
    String str2 = paramQQAppInterface.getString("UPGRADE_BANNER_URL_MARK", null);
    paramQQAppInterface = str1;
    if (str2 != null)
    {
      paramQQAppInterface = str2.split(":");
      long l1 = Long.parseLong(paramQQAppInterface[0]);
      long l2 = Long.parseLong(paramQQAppInterface[1]);
      long l3 = System.currentTimeMillis();
      if ((l2 >= l1) && (l3 > l1))
      {
        paramQQAppInterface = str1;
        if (l3 <= l2) {}
      }
      else
      {
        paramQQAppInterface = null;
      }
    }
    return paramQQAppInterface;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "ConfigHandler.getUpgradeTipsUrl:" + paramInt);
    }
    Object localObject = paramQQAppInterface.getPreferences();
    paramQQAppInterface = ((SharedPreferences)localObject).getString("UPGRADE_TIPS_URL", null);
    if (paramQQAppInterface == null) {}
    do
    {
      long l1;
      long l2;
      long l3;
      do
      {
        return null;
        localObject = ((SharedPreferences)localObject).getString("UPGRADE_TIPS_URL_MARK", null);
        if (QLog.isColorLevel()) {
          QLog.d("UpgradeController", 2, "ConfigHandler.getUpgradeTipsUrl:" + (String)localObject);
        }
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        localObject = ((String)localObject).split(":");
        l1 = Long.parseLong(localObject[0]);
        l2 = Long.parseLong(localObject[1]);
        l3 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("UpgradeController", 2, "ConfigHandler.getUpgradeTipsUrl:" + l3);
        }
      } while ((l2 < l1) || (l3 <= l1));
      if (l3 > l2) {
        return paramQQAppInterface;
      }
    } while (paramInt > 0);
    return paramQQAppInterface;
  }
  
  private void a(Intent paramIntent)
  {
    paramIntent.putExtra("logout_intent", true);
    ThemeUiPlugin.destroy(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    ChatBackgroundManager.a();
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.logout(true);
    if (BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null) {
      BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.evictAll();
    }
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    Object localObject = localBaseActivity;
    if (localBaseActivity == null)
    {
      localObject = BaseApplication.getContext();
      paramIntent.addFlags(268435456);
    }
    paramIntent.setClass((Context)localObject, LoginActivity.class);
    ((Context)localObject).startActivity(paramIntent);
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.getPreferences().edit();
    paramQQAppInterface.putString("UPGRADE_TIPS_DAILY_STR", a());
    paramQQAppInterface.commit();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    paramQQAppInterface = paramQQAppInterface.getPreferences().edit();
    paramQQAppInterface.putInt("NEW_ICON_TIMESTAMP", paramInt);
    paramQQAppInterface.commit();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    Object localObject = paramQQAppInterface.getPreferences();
    String str = ((SharedPreferences)localObject).getString("UPGRADE_TIPS_URL", null);
    if ((str != null) && (paramInt >= 0))
    {
      if (str.equals(paramString)) {
        return;
      }
      b(paramQQAppInterface, 0);
    }
    if (TextUtils.isEmpty(paramString))
    {
      paramQQAppInterface = ((SharedPreferences)localObject).edit();
      paramQQAppInterface.putString("UPGRADE_TIPS_URL_MARK", null);
      paramQQAppInterface.putString("UPGRADE_TIPS_URL", paramString);
      paramQQAppInterface.commit();
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = paramInt * 24 * 60 * 60 * 1000;
    paramQQAppInterface = l1 + ":" + (l2 + l1);
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putString("UPGRADE_TIPS_URL_MARK", paramQQAppInterface);
    ((SharedPreferences.Editor)localObject).putString("UPGRADE_TIPS_URL", paramString);
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface = paramQQAppInterface.getPreferences().edit();
    paramQQAppInterface.putBoolean("AUTO_DOWNLOADED_IN_WIFI", paramBoolean);
    paramQQAppInterface.commit();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "ConfigHandler.onReceiverPCUpgradeMessage");
    }
    SubMsgType0x43.UpdateTips localUpdateTips = new SubMsgType0x43.UpdateTips();
    try
    {
      paramQQAppInterface.a(0);
      paramQQAppInterface = localUpdateTips.bytes_desc.get().toString();
      if (QLog.isColorLevel()) {
        QLog.d("UpgradeController", 2, "ConfigHandler.onReceiverPCUpgradeMessage: " + paramQQAppInterface);
      }
      localUpdateTips.mergeFrom(paramArrayOfByte);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramQQAppInterface) {}
  }
  
  private void a(UpgradeDetailWrapper paramUpgradeDetailWrapper)
  {
    SharedPreferences localSharedPreferences = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    if (paramUpgradeDetailWrapper == null) {}
    label41:
    Object localObject;
    label56:
    label265:
    label279:
    do
    {
      do
      {
        UpgradeInfo localUpgradeInfo;
        do
        {
          do
          {
            int m;
            do
            {
              do
              {
                return;
                localUpgradeInfo = paramUpgradeDetailWrapper.a;
              } while (localUpgradeInfo == null);
              if ((localUpgradeInfo.iUpgradeType <= 0) || (localUpgradeInfo.bNewSwitch != 1)) {
                break;
              }
              m = 1;
              QQAppInterface localQQAppInterface = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface;
              if (m == 0) {
                break label265;
              }
              localObject = "1";
              ReportController.b(localQQAppInterface, "CliOper", "", "", "0X8004DA5", "0X8004DA5", 0, 0, (String)localObject, "", UpgradeController.a(), "");
              localObject = localSharedPreferences.edit();
              if (localSharedPreferences.getInt("upgrade_timeStamp", 0) < localUpgradeInfo.iNewTimeStamp) {
                ((SharedPreferences.Editor)localObject).putInt("upgrade_timeStamp", localUpgradeInfo.iNewTimeStamp);
              }
              ((SharedPreferences.Editor)localObject).commit();
              a(true, paramUpgradeDetailWrapper);
            } while (localUpgradeInfo.iActionType != 0);
            if (localUpgradeInfo.iUpgradeType == 1) {}
            for (;;)
            {
              if (localUpgradeInfo.iUpgradeType != 2) {
                break label279;
              }
              localObject = a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
              if ((localObject == null) || (((String)localObject).equals("com.tencent.mobileqq.activity.UserguideActivity"))) {
                break;
              }
              localObject = new Intent();
              ((Intent)localObject).putExtra("reason_for_upgrade", true);
              ((Intent)localObject).putExtra("StrTitle", "版本升级");
              ((Intent)localObject).putExtra("StrUpgradeDesc", "你当前使用的QQ版本过低，需要立即升级");
              ((Intent)localObject).putExtra("StrUrl", localUpgradeInfo.strNewSoftwareURL);
              ((Intent)localObject).putExtra(paramUpgradeDetailWrapper.getClass().getSimpleName(), paramUpgradeDetailWrapper);
              a((Intent)localObject);
              return;
              m = 0;
              break label41;
              localObject = "0";
              break label56;
              d();
            }
          } while (localUpgradeInfo.iUpgradeType != 1);
          if (UpgradeController.a().a() != 4) {
            break;
          }
          paramUpgradeDetailWrapper = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(Conversation.class);
        } while (paramUpgradeDetailWrapper == null);
        paramUpgradeDetailWrapper.obtainMessage(1134018).sendToTarget();
        return;
        if (a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, false))
        {
          UpgradeController.a().a();
          return;
        }
        if ((localUpgradeInfo.iTipsType != 0) && (localUpgradeInfo.iTipsType != 2)) {
          break;
        }
        paramUpgradeDetailWrapper = new Intent(BaseApplication.getContext(), UpgradeActivity.class);
        paramUpgradeDetailWrapper.putExtra("StrTitle", localUpgradeInfo.strTitle);
        paramUpgradeDetailWrapper.putExtra("StrUpgradeDesc", localUpgradeInfo.strUpgradeDesc);
        paramUpgradeDetailWrapper.putExtra("StrUrl", localUpgradeInfo.strUrl);
        paramUpgradeDetailWrapper.putExtra("iUpgradeType", localUpgradeInfo.iUpgradeType);
        paramUpgradeDetailWrapper.putExtra("iTipsType", localUpgradeInfo.iTipsType);
        paramUpgradeDetailWrapper.putExtra("strConfirmBtnText", localUpgradeInfo.strButtonDesc);
        paramUpgradeDetailWrapper.putExtra("activity_type", 4096);
        paramUpgradeDetailWrapper.putExtra("mode", 0);
        localObject = a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
        if ((localObject != null) && (((String)localObject).equals("com.tencent.mobileqq.activity.UserguideActivity")))
        {
          this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a = paramUpgradeDetailWrapper;
          return;
        }
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a = null;
      } while (BaseActivity.sTopActivity == null);
      BaseActivity.sTopActivity.startActivity(paramUpgradeDetailWrapper);
      return;
      localObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(Conversation.class);
    } while (localObject == null);
    ((MqqHandler)localObject).obtainMessage(1134020, paramUpgradeDetailWrapper).sendToTarget();
  }
  
  private void a(EntityManager paramEntityManager, GetResourceRespInfo paramGetResourceRespInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("share_appid", 2, "get share appid resp info");
    }
    if (paramGetResourceRespInfo.iResult != 0) {
      a(5, false, null);
    }
    AppShareID localAppShareID;
    do
    {
      return;
      localAppShareID = AppShareIDUtil.a(paramGetResourceRespInfo);
    } while (localAppShareID == null);
    if (QLog.isColorLevel()) {
      QLog.d("share_appid", 2, "parser share appid from resp info, result:  " + localAppShareID);
    }
    paramGetResourceRespInfo = (AppShareID)paramEntityManager.a(AppShareID.class, "strPkgName=?", new String[] { paramGetResourceRespInfo.strPkgName });
    if (paramGetResourceRespInfo == null)
    {
      paramEntityManager.a(localAppShareID);
      if (QLog.isColorLevel()) {
        QLog.d("share_appid", 2, "Persist DB appid = " + localAppShareID.strPkgName);
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a.a(localAppShareID.strPkgName, localAppShareID);
      a(localAppShareID.strResURL_big, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getFileStreamPath(localAppShareID.strPkgName));
      a(5, true, localAppShareID);
      return;
      if (localAppShareID.uiNewVer != paramGetResourceRespInfo.uiNewVer)
      {
        paramEntityManager.b(paramGetResourceRespInfo);
        paramEntityManager.a(localAppShareID);
        if (QLog.isColorLevel()) {
          QLog.d("share_appid", 2, "Update DB appid = " + localAppShareID.strPkgName);
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("share_appid", 2, "Not need update DB appid = " + localAppShareID.strPkgName);
      }
    }
  }
  
  private void a(Object paramObject)
  {
    if (paramObject == null)
    {
      a(false, null);
      return;
    }
    Object localObject = ((SDKUpgradeRes)paramObject).vUpgradeInfo;
    paramObject = UpgradeController.a().a();
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      localObject = (UpgradeInfo)((ArrayList)localObject).get(0);
      if (((UpgradeInfo)localObject).iUpgradeType == 0)
      {
        ((UpgradeDetailWrapper)paramObject).a = new UpgradeInfo();
        a(true, (UpgradeDetailWrapper)paramObject);
        return;
      }
      UpgradeController.a().a((UpgradeInfo)localObject, this);
      return;
    }
    ((UpgradeDetailWrapper)paramObject).a = new UpgradeInfo();
    a(false, (UpgradeDetailWrapper)paramObject);
  }
  
  private void a(String paramString)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilHashSet.add(paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private void a(GetResourceRespInfo paramGetResourceRespInfo)
  {
    if (paramGetResourceRespInfo == null) {}
    long l2;
    do
    {
      return;
      long l1 = JumpFilterHelper.a().a();
      l2 = paramGetResourceRespInfo.uiNewVer;
      if (QLog.isColorLevel()) {
        QLog.d("JumpWhiteList", 2, "handleJumpWhiteList currentVersion: " + l1 + ", serverVersion: " + l2 + ",iResult: " + paramGetResourceRespInfo.iResult + ", bigUrl: " + paramGetResourceRespInfo.strResURL_big);
      }
      if (l2 == l1) {
        break;
      }
      paramGetResourceRespInfo = paramGetResourceRespInfo.strResURL_big;
    } while (TextUtils.isEmpty(paramGetResourceRespInfo));
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(new pvv(this, paramGetResourceRespInfo, l2));
    return;
    ThreadManager.a().post(new pvx(this));
  }
  
  private void a(boolean paramBoolean, UpgradeDetailWrapper paramUpgradeDetailWrapper)
  {
    a(4, paramBoolean, paramUpgradeDetailWrapper);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getPreferences().getBoolean("AUTO_DOWNLOADED_IN_WIFI", false);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    return paramInt == paramQQAppInterface.getPreferences().getInt("NEW_ICON_TIMESTAMP", -1);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    return paramQQAppInterface.getPreferences().getBoolean("UPGRADE_AUTO_DOWNLOAD_IN_WIFI", paramBoolean);
  }
  
  private boolean a(String paramString, long paramLong)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (paramString == null) {
      bool2 = bool1;
    }
    do
    {
      return bool2;
      DeviceProfileManager localDeviceProfileManager = DeviceProfileManager.a();
      bool1 = bool2;
      if ("eggs_android_CI_4.7.1".equals(paramString))
      {
        bool1 = bool2;
        if (!localDeviceProfileManager.a(DeviceProfileManager.DpcNames.aio_eggs.name(), paramLong))
        {
          FileUtils.d(new File(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getFilesDir(), "eggs_config.zip").getAbsolutePath());
          FileUtils.d(AioAnimationConfigHelper.p);
          bool1 = false;
          AioAnimationConfigHelper.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication());
          this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putLong("k_eggs_file_version", 0L).commit();
        }
      }
      bool2 = bool1;
    } while (!QLog.isColorLevel());
    QLog.d("ConfigHandler", 2, "str=" + paramString + ", isFeatureSupport=" + bool1);
    return bool1;
  }
  
  public static void b(QQAppInterface paramQQAppInterface, int paramInt)
  {
    paramQQAppInterface = paramQQAppInterface.getPreferences().edit();
    paramQQAppInterface.putInt("UPGRADE_TIPS_SHOW_COUNT", paramInt);
    paramQQAppInterface.commit();
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    paramQQAppInterface = paramQQAppInterface.getPreferences();
    String str = paramQQAppInterface.getString("UPGRADE_BANNER_URL", null);
    if ((str != null) && (paramInt > 0) && (str.equals(paramString))) {
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      paramQQAppInterface = paramQQAppInterface.edit();
      paramQQAppInterface.putString("UPGRADE_BANNER_URL_MARK", null);
      paramQQAppInterface.putString("UPGRADE_BANNER_URL", paramString);
      paramQQAppInterface.commit();
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = paramInt * 24 * 60 * 60 * 1000;
    str = l1 + ":" + (l2 + l1);
    paramQQAppInterface = paramQQAppInterface.edit();
    paramQQAppInterface.putString("UPGRADE_BANNER_URL_MARK", str);
    paramQQAppInterface.putString("UPGRADE_BANNER_URL", paramString);
    paramQQAppInterface.commit();
  }
  
  public static void b(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface = paramQQAppInterface.getPreferences().edit();
    paramQQAppInterface.putBoolean("UPGRADE_AUTO_DOWNLOAD_IN_WIFI", paramBoolean);
    paramQQAppInterface.commit();
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool9 = false;
    boolean bool10 = false;
    boolean bool11 = false;
    boolean bool8 = false;
    boolean bool1;
    boolean bool2;
    boolean bool7;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.d("ConfigHandler", 2, "handleGetPCActiveConfig success=" + bool1);
      }
      bool2 = bool1;
      bool7 = bool9;
      if (bool1)
      {
        bool3 = bool1;
        bool4 = bool10;
        bool5 = bool1;
        bool6 = bool11;
      }
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        if (paramFromServiceMsg == null) {
          continue;
        }
        bool3 = bool1;
        bool4 = bool10;
        bool5 = bool1;
        bool6 = bool11;
        if (paramFromServiceMsg.uint32_result.get() != 0) {
          continue;
        }
        bool1 = true;
        bool3 = bool1;
        bool4 = bool10;
        bool5 = bool1;
        bool6 = bool11;
        if (QLog.isColorLevel())
        {
          bool3 = bool1;
          bool4 = bool10;
          bool5 = bool1;
          bool6 = bool11;
          QLog.d("ConfigHandler", 2, "handleGetPCActiveConfig result=" + bool1);
        }
        bool2 = bool1;
        bool7 = bool9;
        if (bool1)
        {
          bool2 = bool1;
          bool7 = bool9;
          bool3 = bool1;
          bool4 = bool10;
          bool5 = bool1;
          bool6 = bool11;
          if (paramFromServiceMsg.bytes_bodybuffer.has())
          {
            bool2 = bool1;
            bool7 = bool9;
            bool3 = bool1;
            bool4 = bool10;
            bool5 = bool1;
            bool6 = bool11;
            if (paramFromServiceMsg.bytes_bodybuffer.get() != null)
            {
              bool3 = bool1;
              bool4 = bool10;
              bool5 = bool1;
              bool6 = bool11;
              paramFromServiceMsg = ByteBuffer.wrap(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
              bool3 = bool1;
              bool4 = bool10;
              bool5 = bool1;
              bool6 = bool11;
              int m = paramFromServiceMsg.getShort();
              bool3 = bool1;
              bool4 = bool10;
              bool5 = bool1;
              bool6 = bool11;
              int n = paramFromServiceMsg.getShort();
              bool2 = bool1;
              bool7 = bool9;
              if (m == 16)
              {
                bool3 = bool1;
                bool4 = bool10;
                bool5 = bool1;
                bool6 = bool11;
                paramObject = new byte[n];
                bool3 = bool1;
                bool4 = bool10;
                bool5 = bool1;
                bool6 = bool11;
                paramFromServiceMsg.get((byte[])paramObject);
                bool2 = bool8;
                if ((paramObject[16] & 0x1) > 0) {
                  bool2 = true;
                }
                bool3 = bool1;
                bool4 = bool2;
                bool5 = bool1;
                bool6 = bool2;
                SettingCloneUtil.writeValue(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), paramToServiceMsg.getUin(), null, "pcactive_config", bool2);
                bool3 = bool1;
                bool4 = bool2;
                bool5 = bool1;
                bool6 = bool2;
                this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.openMsfPCActive(paramToServiceMsg.getUin(), "config", bool2);
                bool3 = bool1;
                bool4 = bool2;
                bool5 = bool1;
                bool6 = bool2;
                QLog.d("ConfigHandler", 1, "PCActive opened: " + bool2 + " by config");
                bool3 = bool1;
                bool4 = bool2;
                bool5 = bool1;
                bool6 = bool2;
                paramFromServiceMsg = new Intent("com.tencent.mobileqq.activity.NotifyPushSettingActivity.ConfigPCActive");
                bool3 = bool1;
                bool4 = bool2;
                bool5 = bool1;
                bool6 = bool2;
                paramFromServiceMsg.putExtra("configPCActive", bool2);
                bool3 = bool1;
                bool4 = bool2;
                bool5 = bool1;
                bool6 = bool2;
                paramFromServiceMsg.putExtra("uin", paramToServiceMsg.getUin());
                bool3 = bool1;
                bool4 = bool2;
                bool5 = bool1;
                bool6 = bool2;
                this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().sendBroadcast(paramFromServiceMsg);
                bool7 = bool2;
                bool2 = bool1;
              }
            }
          }
        }
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        bool5 = bool3;
        bool6 = bool4;
        if (!QLog.isColorLevel()) {
          continue;
        }
        bool5 = bool3;
        bool6 = bool4;
        QLog.d("ConfigHandler", 2, "handleGetPCActiveConfig ex", paramToServiceMsg);
        return;
      }
      finally
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ConfigHandler", 2, "handleGetPCActiveConfig result=" + bool5 + ";allow=" + bool6);
      }
      bool1 = false;
      break;
      bool1 = false;
    }
  }
  
  private void b(String paramString)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilHashSet.remove(paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private void b(GetResourceRespInfo paramGetResourceRespInfo)
  {
    if (paramGetResourceRespInfo == null) {}
    WeatherManager localWeatherManager;
    long l1;
    do
    {
      long l2;
      do
      {
        return;
        localWeatherManager = (WeatherManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(113);
        l1 = paramGetResourceRespInfo.uiNewVer;
        l2 = localWeatherManager.a();
        if (QLog.isColorLevel()) {
          QLog.d("weatherManager", 2, "handleWeatherResources currentVersion: " + l2 + ", serverVersion: " + l1 + ",iResult: " + paramGetResourceRespInfo.iResult + ", bigUrl: " + paramGetResourceRespInfo.strResURL_big);
        }
      } while (l1 == l2);
      paramGetResourceRespInfo = paramGetResourceRespInfo.strResURL_big;
    } while (TextUtils.isEmpty(paramGetResourceRespInfo));
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(new pvy(this, paramGetResourceRespInfo, localWeatherManager, l1));
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.getPreferences();
    boolean bool2 = false;
    paramQQAppInterface = paramQQAppInterface.getString("UPGRADE_TIPS_DAILY_STR", null);
    boolean bool1 = bool2;
    if (paramQQAppInterface != null)
    {
      bool1 = bool2;
      if (a().equals(paramQQAppInterface)) {
        bool1 = true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "ConfigHandler.isDailyShowTips:" + bool1 + "--> " + paramQQAppInterface);
    }
    return bool1;
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1 = false;
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool4;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool4 = true;
      if (bool4) {
        break label215;
      }
      paramToServiceMsg = null;
      paramFromServiceMsg = null;
      paramObject = null;
    }
    boolean bool2;
    label45:
    Object localObject4;
    label215:
    AccessRsp localAccessRsp;
    int m;
    for (;;)
    {
      if (!bool4)
      {
        bool2 = true;
        if (QLog.isDevelopLevel()) {
          QLog.d("UpgradeController", 4, "handleCheckAuthCode:" + bool4 + ", valid:" + bool2);
        }
        this.jdField_b_of_type_Boolean = bool2;
        if (!bool2)
        {
          BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getResources();
          localObject4 = new Intent();
          ((Intent)localObject4).putExtra("reason_for_checkAuth", true);
          ((Intent)localObject4).putExtra("StrTitle", (String)localObject3);
          ((Intent)localObject4).putExtra("StrUpgradeDesc", (String)localObject2);
          ((Intent)localObject4).putExtra("StrButton", (String)localObject1);
          ((Intent)localObject4).putExtra("StrClientUrl", paramFromServiceMsg);
          ((Intent)localObject4).putExtra("StrH5Url", paramToServiceMsg);
          ((Intent)localObject4).putExtra("StrCode", (String)paramObject);
          a((Intent)localObject4);
        }
        a(11, bool4, Boolean.valueOf(bool2));
        return;
        bool4 = false;
        break;
        localAccessRsp = (AccessRsp)paramObject;
        m = localAccessRsp.ret;
        if (m == 1)
        {
          bool1 = true;
          paramToServiceMsg = null;
          paramFromServiceMsg = null;
          paramObject = null;
        }
        else if (m != 0)
        {
          bool1 = true;
          paramToServiceMsg = null;
          paramFromServiceMsg = null;
          paramObject = null;
        }
        else
        {
          if ((localAccessRsp.body == null) || (localAccessRsp.body.length <= 0)) {
            break label757;
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg = new JceInputStream(localAccessRsp.body);
        paramToServiceMsg = new CheckSinglePkgSigRsp();
      }
      catch (Exception paramToServiceMsg)
      {
        try
        {
          paramToServiceMsg.readFrom(paramFromServiceMsg);
          if ((paramToServiceMsg != null) && (paramToServiceMsg.ret != 1) && (paramToServiceMsg.ret != -1) && (paramToServiceMsg.ret != 100)) {
            break label353;
          }
          bool1 = true;
          paramToServiceMsg = null;
          paramFromServiceMsg = null;
          paramObject = null;
        }
        catch (Exception paramFromServiceMsg)
        {
          for (;;)
          {
            continue;
            paramToServiceMsg = null;
            paramFromServiceMsg = null;
            paramObject = null;
            continue;
            boolean bool3 = false;
          }
        }
        paramToServiceMsg = paramToServiceMsg;
        paramToServiceMsg = null;
      }
      continue;
      label353:
      if (paramToServiceMsg.ret == 0)
      {
        if (paramToServiceMsg.vtMarket != null)
        {
          paramFromServiceMsg = paramToServiceMsg.vtMarket.iterator();
          for (bool1 = false;; bool1 = bool3)
          {
            bool3 = bool1;
            if (paramFromServiceMsg.hasNext())
            {
              paramObject = (NoCheckMarket)paramFromServiceMsg.next();
              bool3 = bool1;
              if (TextUtils.isEmpty(((NoCheckMarket)paramObject).pkgName)) {
                continue;
              }
              bool2 = bool1;
              if (!bool1) {
                bool2 = Verify.a(BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, ((NoCheckMarket)paramObject).pkgName, ((NoCheckMarket)paramObject).versionCode, ((NoCheckMarket)paramObject).signatureMd5);
              }
              if (QLog.isDevelopLevel()) {
                QLog.d("UpgradeController", 4, "handleCheckAuthCode NoCheckMarket:" + ((NoCheckMarket)paramObject).pkgName + ", " + ((NoCheckMarket)paramObject).versionCode);
              }
              bool3 = bool2;
              if (!bool2) {
                continue;
              }
              bool3 = bool2;
              if (QLog.isDevelopLevel())
              {
                QLog.d("UpgradeController", 4, "handleCheckAuthCode NoCheckMarket:" + bool2);
                bool3 = bool2;
              }
            }
            String str = paramToServiceMsg.pkgSig;
            localObject4 = paramToServiceMsg.tmastUrl;
            paramFromServiceMsg = paramToServiceMsg.pageUrl;
            m = paramToServiceMsg.sigVersionCode;
            localObject2 = paramFromServiceMsg + "#versioncode=" + m;
            if (QLog.isDevelopLevel()) {
              QLog.d("UpgradeController", 4, "handleCheckAuthCode TargetCode:" + str + ", " + m);
            }
            if (localAccessRsp.tips == null) {
              break label742;
            }
            paramObject = localAccessRsp.tips.title;
            paramFromServiceMsg = localAccessRsp.tips.content;
            paramToServiceMsg = localAccessRsp.tips.button;
            localObject1 = paramToServiceMsg;
            bool1 = bool3;
            paramToServiceMsg = (ToServiceMsg)localObject2;
            localObject2 = paramFromServiceMsg;
            localObject3 = paramObject;
            paramFromServiceMsg = (FromServiceMsg)localObject4;
            paramObject = str;
            break;
          }
        }
      }
      else
      {
        bool1 = true;
        paramToServiceMsg = null;
        paramFromServiceMsg = null;
        paramObject = null;
        break;
        bool2 = bool1;
        if (!bool1) {
          break label45;
        }
        Verify.a(BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl);
        bool2 = bool1;
        break label45;
      }
      label742:
      label757:
      paramToServiceMsg = null;
    }
  }
  
  private void c(GetResourceRespInfo paramGetResourceRespInfo)
  {
    com.tencent.mobileqq.filemanager.data.FMConstants.jdField_a_of_type_Boolean = true;
    if (paramGetResourceRespInfo.iResult == -2) {}
    while (paramGetResourceRespInfo.iResult == 0)
    {
      String str = paramGetResourceRespInfo.strResURL_big;
      if ((str != null) && (str.length() > 0)) {
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(new pvz(this, str, paramGetResourceRespInfo));
      }
      return;
    }
  }
  
  private void d()
  {
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("mobileQQ", 0).edit().putInt("upgrade_tip_count", 0).putLong("upgrade_tip_time", 0L).commit();
    b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, 0);
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = null;
    boolean bool2 = false;
    String str = paramToServiceMsg.extraData.getString("rid");
    int m;
    boolean bool1;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      m = 1;
      if (m != 0) {
        break label134;
      }
      bool1 = bool2;
      paramToServiceMsg = (ToServiceMsg)localObject;
    }
    label134:
    label176:
    do
    {
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("UpgradeController", 4, "handleGetAuthCode:" + bool1 + ", " + str + ", code:" + paramToServiceMsg);
        }
        a(10, bool1, new Pair(paramToServiceMsg, str));
        UpgradeController.a().a(bool1, str, paramToServiceMsg);
        return;
        m = 0;
        break;
        paramFromServiceMsg = (AccessRsp)paramObject;
        m = paramFromServiceMsg.ret;
        if (m != 1) {
          break label176;
        }
        if (QLog.isDevelopLevel()) {
          QLog.d("UpgradeController", 4, "handleGetAuthCode not supported");
        }
        paramToServiceMsg = "";
        bool1 = true;
      }
      paramToServiceMsg = (ToServiceMsg)localObject;
      bool1 = bool2;
    } while (m != 0);
    if ((paramFromServiceMsg.body != null) && (paramFromServiceMsg.body.length > 0)) {}
    for (;;)
    {
      try
      {
        paramToServiceMsg = new JceInputStream(paramFromServiceMsg.body);
        paramFromServiceMsg = new GetSinglePkgSigRsp();
      }
      catch (Exception paramToServiceMsg)
      {
        try
        {
          paramFromServiceMsg.readFrom(paramToServiceMsg);
          paramToServiceMsg = (ToServiceMsg)localObject;
          bool1 = bool2;
          if (paramFromServiceMsg == null) {
            break;
          }
          paramToServiceMsg = (ToServiceMsg)localObject;
          bool1 = bool2;
          if (paramFromServiceMsg.ret != 0) {
            break;
          }
          paramToServiceMsg = paramFromServiceMsg.pkgSig;
          bool1 = true;
          break;
          paramToServiceMsg = paramToServiceMsg;
          paramFromServiceMsg = null;
          continue;
        }
        catch (Exception paramToServiceMsg)
        {
          continue;
        }
      }
      paramFromServiceMsg = null;
    }
  }
  
  private void d(GetResourceRespInfo paramGetResourceRespInfo)
  {
    if (paramGetResourceRespInfo.iResult != 0) {
      a(1, false, paramGetResourceRespInfo);
    }
    String str;
    do
    {
      return;
      str = paramGetResourceRespInfo.strResURL_big;
    } while ((str == null) || (str.length() <= 0));
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(new pwa(this, str, paramGetResourceRespInfo));
  }
  
  private void e(GetResourceRespInfo paramGetResourceRespInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.xml", 2, "ConfigHandler.handleUpdateStatusActions, result is " + paramGetResourceRespInfo.iResult + ", server version:" + paramGetResourceRespInfo.uiNewVer);
    }
    if (paramGetResourceRespInfo.iResult == -2) {
      a(7, true, Integer.valueOf(100));
    }
    StatusManager localStatusManager;
    do
    {
      return;
      if (paramGetResourceRespInfo.iResult != 0)
      {
        a(7, false, Integer.valueOf(-1));
        return;
      }
      localStatusManager = (StatusManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14);
    } while (localStatusManager == null);
    if (!localStatusManager.a(paramGetResourceRespInfo.uiNewVer))
    {
      a(7, true, Integer.valueOf(100));
      return;
    }
    String str = paramGetResourceRespInfo.strResURL_big;
    if (TextUtils.isEmpty(str))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.richstatus.xml", 2, "url is empty");
      }
      a(7, false, Integer.valueOf(-1));
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(new pwb(this, str, localStatusManager, paramGetResourceRespInfo));
  }
  
  private void f(GetResourceRespInfo paramGetResourceRespInfo)
  {
    if (paramGetResourceRespInfo == null) {}
    long l2;
    String str;
    do
    {
      return;
      long l1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getLong("k_eggs_file_version", 0L);
      l2 = paramGetResourceRespInfo.uiNewVer;
      if (QLog.isColorLevel()) {
        QLog.d("eggs", 2, "handleUpdateEggsActions currentVersion: " + l1 + ", serverVersion: " + l2 + ",iResult: " + paramGetResourceRespInfo.iResult + ", bigUrl: " + paramGetResourceRespInfo.strResURL_big);
      }
      if (l2 == l1) {
        break;
      }
      str = paramGetResourceRespInfo.strResURL_big;
    } while (TextUtils.isEmpty(str));
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(new pwc(this, paramGetResourceRespInfo, str, l2));
    return;
    ThreadManager.a().post(new pwd(this, paramGetResourceRespInfo));
  }
  
  protected Class a()
  {
    return ConfigObserver.class;
  }
  
  public GetResourceReqInfo a()
  {
    long l1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getLong("k_eggs_file_version", 0L);
    if (QLog.isColorLevel()) {
      QLog.d("eggs", 2, "getEggsInfo curVersion: " + l1);
    }
    GetResourceReqInfo localGetResourceReqInfo = new GetResourceReqInfo();
    localGetResourceReqInfo.uiResID = 0L;
    localGetResourceReqInfo.strPkgName = "eggs_android_CI_4.7.1";
    localGetResourceReqInfo.uiCurVer = l1;
    localGetResourceReqInfo.sResType = 2;
    localGetResourceReqInfo.sLanType = 0;
    localGetResourceReqInfo.sReqType = 1;
    return localGetResourceReqInfo;
  }
  
  public GetResourceReqInfo a(String paramString, long paramLong)
  {
    GetResourceReqInfo localGetResourceReqInfo = new GetResourceReqInfo();
    localGetResourceReqInfo.uiResID = 0L;
    localGetResourceReqInfo.strPkgName = paramString;
    localGetResourceReqInfo.uiCurVer = paramLong;
    localGetResourceReqInfo.sResType = 3;
    localGetResourceReqInfo.sLanType = 0;
    localGetResourceReqInfo.sReqType = 1;
    return localGetResourceReqInfo;
  }
  
  public void a()
  {
    MqqHandler localMqqHandler = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(Conversation.class);
    if (localMqqHandler != null)
    {
      localMqqHandler.sendEmptyMessage(11340004);
      localMqqHandler.sendEmptyMessage(1134019);
    }
    a(true, null);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {}
    while (!this.jdField_b_of_type_Boolean) {
      return;
    }
    UpgradeController.a().a(false);
    a(false, null);
    this.jdField_a_of_type_Boolean = true;
    ToServiceMsg localToServiceMsg = a("ConfigService.ClientReq");
    localToServiceMsg.extraData.putInt("iActionType", paramInt);
    localToServiceMsg.setAppId(AppSetting.jdField_a_of_type_Int);
    DisplayMetrics localDisplayMetrics = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDisplayMetrics();
    paramInt = localDisplayMetrics.widthPixels;
    int m = localDisplayMetrics.heightPixels;
    localToServiceMsg.extraData.putInt("iWidth", paramInt);
    localToServiceMsg.extraData.putInt("iHeight", m);
    a(localToServiceMsg);
  }
  
  public void a(int paramInt, UpgradeDetailWrapper paramUpgradeDetailWrapper, UpgradeController paramUpgradeController)
  {
    paramUpgradeController = paramUpgradeDetailWrapper.a;
    if ((paramInt == 0) && (paramUpgradeController != null))
    {
      BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getPackageName();
      a(paramUpgradeController);
      a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramUpgradeController.strNewTipsDescURL, paramUpgradeController.iTipsWaitDay);
      b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramUpgradeController.strBannerPicUrl, paramUpgradeController.iDisplayDay);
      a(paramUpgradeDetailWrapper);
      return;
    }
    a(true, paramUpgradeDetailWrapper);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1 = false;
    if ("ConfigService.GetResourceReq".equals(paramFromServiceMsg.getServiceCmd()))
    {
      if (paramObject == null) {
        if (paramToServiceMsg.extraData.getBoolean("reqRegionConfig")) {
          ((ConditionSearchManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(58)).a(null);
        }
      }
      do
      {
        return;
        paramToServiceMsg = ((GetResourceResp)paramObject).vecResRespInfo;
      } while ((paramToServiceMsg == null) || (paramToServiceMsg.size() <= 0));
      int m = 0;
      label72:
      if (m < paramToServiceMsg.size())
      {
        paramFromServiceMsg = (GetResourceRespInfo)paramToServiceMsg.get(m);
        if (QLog.isColorLevel()) {
          QLog.d("ThemeDownloadTrace", 2, "resType is:" + paramFromServiceMsg.sResType + ",result is:" + paramFromServiceMsg.iResult + ",pkgName is:" + paramFromServiceMsg.strPkgName);
        }
        if (paramFromServiceMsg.sResType != 3) {
          break label196;
        }
        if (!"FileOnlinePreviewConfigV2".equals(paramFromServiceMsg.strPkgName)) {
          break label188;
        }
        c(paramFromServiceMsg);
      }
      for (;;)
      {
        m += 1;
        break label72;
        break;
        label188:
        d(paramFromServiceMsg);
        continue;
        label196:
        if (paramFromServiceMsg.sResType == 0)
        {
          if ("com.tencent.weather_bg".equals(paramFromServiceMsg.strPkgName)) {
            b(paramFromServiceMsg);
          }
        }
        else if (paramFromServiceMsg.sResType == 2)
        {
          if ("rich_status_android".equals(paramFromServiceMsg.strPkgName))
          {
            e(paramFromServiceMsg);
          }
          else if ("eggs_android_CI_4.7.1".equals(paramFromServiceMsg.strPkgName))
          {
            f(paramFromServiceMsg);
          }
          else if ("QQAddFriend.AdministrateRegion".equals(paramFromServiceMsg.strPkgName))
          {
            paramObject = (ConditionSearchManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(58);
            if (paramObject != null) {
              ((ConditionSearchManager)paramObject).a(paramFromServiceMsg);
            }
          }
          else if ("com.tencent.jumpCI".equals(paramFromServiceMsg.strPkgName))
          {
            a(paramFromServiceMsg);
          }
        }
        else if (paramFromServiceMsg.sResType == 4)
        {
          paramObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
          a((EntityManager)paramObject, paramFromServiceMsg);
          ((EntityManager)paramObject).a();
        }
        else if (paramFromServiceMsg.sResType == 512)
        {
          paramObject = (EarlyDownloadManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(76);
          if (paramObject != null) {
            ((EarlyDownloadManager)paramObject).a(paramFromServiceMsg);
          }
        }
      }
    }
    if ("ConfigService.ClientReq".equals(paramFromServiceMsg.getServiceCmd()))
    {
      a(paramObject);
      return;
    }
    boolean bool2;
    if ("MobileTipsSvc.TipsReport".equals(paramFromServiceMsg.getServiceCmd()))
    {
      bool2 = paramFromServiceMsg.isSuccess();
      if (!bool2) {
        break label627;
      }
      paramToServiceMsg = new MobileTips.MobileTipsPkg();
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (paramToServiceMsg.rsp.result.get() == 0) {
          bool1 = true;
        }
        if (QLog.isDevelopLevel()) {
          QLog.d("QQOperateVoIP", 4, "get voip_tips req ack rsp confighandler isSuccess " + bool1);
        }
        if (bool1) {
          break;
        }
        return;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        paramFromServiceMsg.printStackTrace();
        continue;
      }
      if ("OidbSvc.0x82f_0".equals(paramFromServiceMsg.getServiceCmd()))
      {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("MAAControl.CheckSinglePkgSig".equals(paramFromServiceMsg.getServiceCmd()))
      {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("MAAControl.GetSinglePkgSig".equals(paramFromServiceMsg.getServiceCmd()))
      {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.richstatus.xml", 2, "cmdfilter error=" + paramFromServiceMsg.getServiceCmd());
      return;
      label627:
      bool1 = bool2;
    }
  }
  
  public void a(String paramString, int paramInt, ArrayList paramArrayList)
  {
    if (QLog.isDevelopLevel())
    {
      QLog.d("QQOperateVoIP", 4, "receive task, uin =" + paramString + " uinType=" + paramInt);
      localObject1 = paramArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (QQOperationViopTipTask)((Iterator)localObject1).next();
        QLog.d("QQOperateVoIP", 4, "receive task, taskid=" + ((QQOperationViopTipTask)localObject2).taskid);
      }
    }
    Object localObject1 = new OperateVoipTipsInfo();
    ((OperateVoipTipsInfo)localObject1).uin = paramString;
    ((OperateVoipTipsInfo)localObject1).uinType = paramInt;
    ((OperateVoipTipsInfo)localObject1).taskList = paramArrayList;
    Object localObject2 = QQOperateManager.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      QQOperationViopTipTask localQQOperationViopTipTask = ((QQOperateManager)localObject2).a(((QQOperationViopTipTask)paramArrayList.next()).taskid);
      if (localQQOperationViopTipTask == null)
      {
        ConfigServlet.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
        return;
      }
      QQOperationVoipTipsTaskExcuteRecord localQQOperationVoipTipsTaskExcuteRecord = new QQOperationVoipTipsTaskExcuteRecord();
      localQQOperationVoipTipsTaskExcuteRecord.taskid = localQQOperationViopTipTask.taskid;
      localQQOperationVoipTipsTaskExcuteRecord.tipType = localQQOperationViopTipTask.tipType;
      localQQOperationVoipTipsTaskExcuteRecord.uin = paramString;
      localQQOperationVoipTipsTaskExcuteRecord.uinType = paramInt;
      localQQOperationVoipTipsTaskExcuteRecord.count = 1;
      localQQOperationVoipTipsTaskExcuteRecord.time = System.currentTimeMillis();
      ((QQOperateManager)localObject2).a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, localQQOperationVoipTipsTaskExcuteRecord);
    }
    a(8, true, localObject1);
  }
  
  public void a(String paramString, int paramInt, ArrayList paramArrayList, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    for (;;)
    {
      try
      {
        Long.parseLong(paramString);
        MobileTips.MobileTipsPkg localMobileTipsPkg = new MobileTips.MobileTipsPkg();
        if (paramInt == 3000)
        {
          m = 2;
          localMobileTipsPkg.req.peer_type.set(m);
          localMobileTipsPkg.req.peer_uin.set(Long.parseLong(paramString));
          if (paramArrayList != null)
          {
            ArrayList localArrayList = new ArrayList();
            paramArrayList = paramArrayList.iterator();
            if (paramArrayList.hasNext())
            {
              QQOperationRequestTaskInfo localQQOperationRequestTaskInfo = (QQOperationRequestTaskInfo)paramArrayList.next();
              MobileTips.TaskInfo localTaskInfo = new MobileTips.TaskInfo();
              localTaskInfo.task_id.set(localQQOperationRequestTaskInfo.jdField_a_of_type_Int);
              localTaskInfo.msgcnt.set(localQQOperationRequestTaskInfo.b);
              localTaskInfo.keywords.set(localQQOperationRequestTaskInfo.jdField_a_of_type_JavaUtilArrayList);
              localTaskInfo.setHasFlag(true);
              localArrayList.add(localTaskInfo);
              continue;
            }
            localMobileTipsPkg.req.task_list.set(localArrayList);
          }
          localMobileTipsPkg.req.setHasFlag(true);
          localMobileTipsPkg.rsp.setHasFlag(true);
          localMobileTipsPkg.setHasFlag(true);
          paramArrayList = new ToServiceMsg("mobileqq.service", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), "MobileTipsSvc.TipsReport");
          paramArrayList.extraData.putBoolean("isRetry", paramBoolean);
          paramArrayList.extraData.putString("chatuin", paramString);
          paramArrayList.extraData.putInt("chattype", paramInt);
          paramArrayList.putWupBuffer(localMobileTipsPkg.toByteArray());
          b(paramArrayList);
          return;
        }
      }
      catch (NumberFormatException paramString)
      {
        return;
      }
      int m = 1;
    }
  }
  
  public void a(String paramString, File paramFile)
  {
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(new pwe(this, paramString, paramFile));
  }
  
  public void a(String paramString1, String paramString2)
  {
    try
    {
      boolean bool = this.jdField_a_of_type_JavaUtilHashSet.contains(paramString1);
      if ((paramString1 == null) || (paramString1.length() == 0) || (bool)) {
        return;
      }
    }
    finally {}
    a(paramString1);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(new pvw(this, paramString2, paramString1));
  }
  
  public void a(ArrayList paramArrayList, GetResourceReqInfo... paramVarArgs)
  {
    int m = 0;
    ArrayList localArrayList = new ArrayList(4);
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramArrayList = paramArrayList.iterator();
      for (bool1 = false;; bool1 = bool2)
      {
        bool2 = bool1;
        if (!paramArrayList.hasNext()) {
          break;
        }
        GetResourceReqInfo localGetResourceReqInfo = (GetResourceReqInfo)paramArrayList.next();
        bool2 = bool1;
        if (localGetResourceReqInfo != null)
        {
          if (localGetResourceReqInfo.strPkgName.equals("QQAddFriend.AdministrateRegion")) {
            bool1 = true;
          }
          localArrayList.add(localGetResourceReqInfo);
          bool2 = bool1;
        }
      }
    }
    boolean bool2 = false;
    int n = paramVarArgs.length;
    for (boolean bool1 = bool2; m < n; bool1 = bool2)
    {
      paramArrayList = paramVarArgs[m];
      bool2 = bool1;
      if (paramArrayList != null)
      {
        if (paramArrayList.strPkgName.equals("QQAddFriend.AdministrateRegion")) {
          bool1 = true;
        }
        localArrayList.add(paramArrayList);
        bool2 = bool1;
      }
      m += 1;
    }
    if (localArrayList.size() <= 0) {
      return;
    }
    paramArrayList = a("ConfigService.GetResourceReq");
    paramArrayList.extraData.putSerializable("getResourceReqInfos", localArrayList);
    paramArrayList.extraData.putBoolean("reqRegionConfig", bool1);
    a(paramArrayList);
  }
  
  public boolean a()
  {
    boolean bool = Verify.b(BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl);
    if (QLog.isDevelopLevel()) {
      QLog.d("UpgradeController", 4, "checkAuthIfNeccessary preCheck:" + bool);
    }
    this.jdField_b_of_type_Boolean = bool;
    if (bool) {
      return false;
    }
    Object localObject1 = null;
    try
    {
      localObject2 = ApkExternalInfoTool.a(new File(BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getPackageResourcePath()));
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      Object localObject2;
      for (;;) {}
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("UpgradeController", 4, "checkAuthIfNeccessary forCode:" + (String)localObject1);
    }
    localObject2 = a("MAAControl.CheckSinglePkgSig");
    ((ToServiceMsg)localObject2).extraData.putString("ac", (String)localObject1);
    a((ToServiceMsg)localObject2);
    return true;
  }
  
  public boolean a(String paramString1, int paramInt, String paramString2)
  {
    ToServiceMsg localToServiceMsg = a("MAAControl.GetSinglePkgSig");
    localToServiceMsg.extraData.putString("pn", paramString1);
    localToServiceMsg.extraData.putInt("vc", paramInt);
    localToServiceMsg.extraData.putString("rid", paramString2);
    a(localToServiceMsg);
    if (QLog.isDevelopLevel()) {
      QLog.d("UpgradeController", 4, "getAuthCode:" + paramString2 + ", forPkg:" + paramString1);
    }
    return true;
  }
  
  public GetResourceReqInfo b()
  {
    long l1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getLong("k_voice_notify2_file_version", 0L);
    if (QLog.isColorLevel()) {
      QLog.d("VoiceNotify", 2, "updateVoiceNotifyConfig => curVersion: " + l1);
    }
    GetResourceReqInfo localGetResourceReqInfo = new GetResourceReqInfo();
    localGetResourceReqInfo.uiResID = 0L;
    localGetResourceReqInfo.strPkgName = "QQVoiceNotifyConfig2_android_CI";
    localGetResourceReqInfo.uiCurVer = l1;
    localGetResourceReqInfo.sResType = 2;
    localGetResourceReqInfo.sLanType = 0;
    localGetResourceReqInfo.sReqType = 1;
    return localGetResourceReqInfo;
  }
  
  public void b() {}
  
  public GetResourceReqInfo c()
  {
    long l1 = BaseApplicationImpl.a().getSharedPreferences("qq_safe_jump_whitelist", 0).getLong("key_jump_whitelist_version", 0L);
    GetResourceReqInfo localGetResourceReqInfo = new GetResourceReqInfo();
    localGetResourceReqInfo.uiResID = 0L;
    localGetResourceReqInfo.strPkgName = "com.tencent.jumpCI";
    localGetResourceReqInfo.uiCurVer = l1;
    localGetResourceReqInfo.sResType = 2;
    localGetResourceReqInfo.sLanType = 0;
    localGetResourceReqInfo.sReqType = 1;
    return localGetResourceReqInfo;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConfigHandler", 2, "getPCActiveConfig");
    }
    try
    {
      oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
      localOIDBSSOPkg.uint32_command.set(2095);
      localOIDBSSOPkg.uint32_service_type.set(0);
      Object localObject = ByteBuffer.allocate(6);
      ((ByteBuffer)localObject).putInt(Utils.a(Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()))).putShort((short)16);
      localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
      localObject = a("OidbSvc.0x82f_0");
      ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
      ((ToServiceMsg)localObject).setTimeout(30000L);
      b((ToServiceMsg)localObject);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ConfigHandler", 2, "getPCActiveConfig ex", localException);
    }
  }
  
  public GetResourceReqInfo d()
  {
    int m = ((WindowManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSystemService("window")).getDefaultDisplay().getWidth();
    if (QLog.isColorLevel()) {
      QLog.d("weatherManager", 2, "getWeatherResources width: " + m);
    }
    if (m <= 480) {
      return null;
    }
    GetResourceReqInfo localGetResourceReqInfo = new GetResourceReqInfo();
    long l1 = ((WeatherManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(113)).a();
    localGetResourceReqInfo.uiResID = 0L;
    localGetResourceReqInfo.uiCurVer = l1;
    localGetResourceReqInfo.strPkgName = "com.tencent.weather_bg";
    localGetResourceReqInfo.sResType = 0;
    localGetResourceReqInfo.sLanType = 0;
    localGetResourceReqInfo.sReqType = 1;
    return localGetResourceReqInfo;
  }
  
  public GetResourceReqInfo e()
  {
    Object localObject = (StatusManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14);
    if (localObject == null) {
      return null;
    }
    long l1 = ((StatusManager)localObject).a();
    localObject = new GetResourceReqInfo();
    ((GetResourceReqInfo)localObject).uiResID = 0L;
    ((GetResourceReqInfo)localObject).strPkgName = "rich_status_android";
    ((GetResourceReqInfo)localObject).uiCurVer = l1;
    ((GetResourceReqInfo)localObject).sResType = 2;
    ((GetResourceReqInfo)localObject).sLanType = 0;
    ((GetResourceReqInfo)localObject).sReqType = 1;
    return (GetResourceReqInfo)localObject;
  }
  
  public GetResourceReqInfo f()
  {
    ConditionSearchManager localConditionSearchManager = (ConditionSearchManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(58);
    if (localConditionSearchManager == null) {
      return null;
    }
    GetResourceReqInfo localGetResourceReqInfo = new GetResourceReqInfo();
    localGetResourceReqInfo.uiResID = 0L;
    localGetResourceReqInfo.strPkgName = "QQAddFriend.AdministrateRegion";
    localGetResourceReqInfo.uiCurVer = localConditionSearchManager.a(true);
    localGetResourceReqInfo.sResType = 2;
    localGetResourceReqInfo.sLanType = 0;
    localGetResourceReqInfo.sReqType = 1;
    return localGetResourceReqInfo;
  }
  
  public GetResourceReqInfo g()
  {
    Object localObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("QlinkResistTerrorist", 0);
    long l1 = ((SharedPreferences)localObject).getLong("SettingQlinkResistTerroristLastTime", 0L);
    l1 = MessageCache.a() - l1;
    if (QLog.isColorLevel()) {
      QLog.i("FMConfig<FileAssistant>", 2, "verifyResistTerrorist,qlinkdur[" + l1 + "]");
    }
    String str = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (!((SharedPreferences)localObject).getString("SettingQlinkResistTerroristLastAccount", "0").equalsIgnoreCase(str))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FMConfig<FileAssistant>", 2, "verifyResistTerrorist,change account!");
      }
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    }
    for (;;)
    {
      localObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("OfflineFileConfigV2", 0);
      l1 = ((SharedPreferences)localObject).getLong("FMConfigUpdateLastTime", 0L);
      long l2 = MessageCache.a();
      if (QLog.isDevelopLevel()) {
        l1 = 0L;
      }
      l1 = l2 - l1;
      if (QLog.isColorLevel()) {
        QLog.i("FMConfig<FileAssistant>", 2, "updateConfig,durtime[" + l1 + "]");
      }
      if (l1 <= 86400L) {
        break;
      }
      l1 = ((SharedPreferences)localObject).getLong("FileOnlinePreviewVersionKey", 0L);
      if (QLog.isDevelopLevel()) {
        l1 = 0L;
      }
      localObject = new GetResourceReqInfo();
      ((GetResourceReqInfo)localObject).uiResID = 0L;
      ((GetResourceReqInfo)localObject).strPkgName = "FileOnlinePreviewConfigV2";
      ((GetResourceReqInfo)localObject).uiCurVer = l1;
      ((GetResourceReqInfo)localObject).sResType = 3;
      ((GetResourceReqInfo)localObject).sLanType = 0;
      ((GetResourceReqInfo)localObject).sReqType = 1;
      if (QLog.isColorLevel()) {
        QLog.i("FMConfig<FileAssistant>", 2, "updateConfig,durtime over one day!currentVersion[" + l1 + "]");
      }
      return (GetResourceReqInfo)localObject;
      if (l1 > 86400L)
      {
        if (QLog.isColorLevel()) {
          QLog.i("FMConfig<FileAssistant>", 2, "verifyResistTerrorist,durtime over one day!");
        }
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      }
    }
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\ConfigHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */