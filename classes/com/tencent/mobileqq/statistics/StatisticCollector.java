package com.tencent.mobileqq.statistics;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Debug.MemoryInfo;
import android.os.Process;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.feedback.anr.ANRReport;
import com.tencent.feedback.eup.CrashReport;
import com.tencent.feedback.eup.CrashStrategyBean;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.memory.MemoryReporter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.msf.sdk.RdmReq;
import com.tencent.mobileqq.servlet.ReportServlet;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import cooperation.qzone.LocalMultiProcConfig;
import java.io.File;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import uui;
import uuj;
import uuk;
import uun;
import uuo;
import uup;
import uuq;

public class StatisticCollector
{
  public static final String A = "dim.actSendGrpTmpMsg";
  public static final String B = "actC2CPicUploadV1";
  public static final String C = "actC2CPicUploadV2";
  public static final String D = "actC2CPicDownloadV1";
  public static final String E = "actC2CPicSmallDownV1";
  public static final String F = "actSwitchChnl";
  public static final String G = "actC2CStreamPttUpload";
  public static final String H = "actC2CStreamPttDownload";
  public static final String I = "actC2CPttDownload";
  public static final String J = "actC2CPttUpload";
  public static final String K = "actGroupPicUploadV1";
  public static final String L = "actGroupPicUploadV2";
  public static final String M = "actGroupPicDownloadV1";
  public static final String N = "actGroupPicSmallDownV1";
  public static final String O = "actGrpPttUp";
  public static final String P = "actGrpPttDown";
  public static final String Q = "actAllC2CPttUp";
  public static final String R = "actPttShowDownloading";
  public static final String S = "actPttUserWaiting";
  public static final String T = "actPttDownloadStream2Offline";
  public static final String U = "actPttLongPressFate2";
  public static final String V = "actPttSoUpdate";
  public static final String W = "actPttProcessFrameCost";
  public static final String X = "actPttNoRangeFailed";
  public static final String Y = "actPttPlayBluetooth";
  public static final String Z = "actDiscussPicUpload";
  public static final int a = 5;
  private static final long jdField_a_of_type_Long = 3000L;
  private static Context jdField_a_of_type_AndroidContentContext;
  private static StatisticCollector jdField_a_of_type_ComTencentMobileqqStatisticsStatisticCollector;
  public static final String a = "StatisticCollector";
  private static SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("MM.dd HH:mm:ss.SSS");
  public static final String aA = "actSDKPredownload";
  public static final String aB = "actSDKDownloadHijacked";
  public static final String aC = "actPredictionData";
  public static final String aD = "actForwardVideoBroken";
  public static final String aE = "actVideoMessageTime";
  public static final String aF = "qzonePreloadFinished";
  public static final String aG = "actMessageEvent";
  public static final String aH = "multiMsgNickTimeOut";
  public static final String aI = "multiMsgNickTimeoutR";
  public static final String aJ = "multiMsgSend";
  public static final String aK = "multiMsgReceive";
  public static final String aL = "actShortVideoUpload";
  public static final String aM = "actShortVideoUploadBDH";
  public static final String aN = "actShortVideoDownloadVideo";
  public static final String aO = "actShortVideoDownloadThumb";
  public static final String aP = "actShortVideoDiscussgroupUpload";
  public static final String aQ = "actShortVideoDiscussgroupUploadBDH";
  public static final String aR = "actShortVideoDiscussgroupDownloadVideo";
  public static final String aS = "actShortVideoDiscussgroupDownloadThumb";
  public static final String aT = "actShortVideoRedirect";
  public static final String aU = "actShortVideoForward";
  public static final String aV = "actShortVideoForwardBDH";
  public static final String aW = "actSqliteDatabaseCorrupt";
  public static final String aX = "evSpError";
  public static final String aY = "actLongMessageDownload";
  public static final String aZ = "actLongMessageTimeSSO";
  public static final String aa = "actDiscussPicUploadV2";
  public static final String ab = "actDiscussPicDown";
  public static final String ac = "actDiscussPicSmallDown";
  public static final String ad = "actDisscusPttUp";
  public static final String ae = "actDisscusPttDown";
  public static final String af = "actMultiMsgUpload";
  public static final String ag = "actMultiMsgDownload";
  public static final String ah = "actSendDiscussProcess";
  public static final String ai = "actIntroPttUpload";
  public static final String aj = "actIntroPttDownload";
  public static final String ak = "dim.actSendWpaMsg";
  public static final String al = "actQzoneUnread";
  public static final String am = "actPluginUnread";
  public static final String an = "actNearbyPeoplePicUpload";
  public static final String ao = "actFriendAvatarUpload";
  public static final String ap = "actNearbyPeoplePicDownload";
  public static final String aq = "actFreshNewsPicUpload";
  public static final String ar = "actNearbyPicBrowser";
  public static final String as = "actSnapChatPicUpload";
  public static final String at = "actBusinessCardPicUpload";
  public static final String au = "actProfileCoverPicUpload";
  public static final String av = "actBaseDynamicAvatarUpload";
  public static final String aw = "actNearbyDynamicAvatarUpload";
  public static final String ax = "actDnsReq";
  public static final String ay = "actDnsBadIp";
  public static final String az = "actStreamingVideoPlay";
  public static final int b = 100;
  private static final long jdField_b_of_type_Long = 86400000L;
  public static final String b = "actLoginT";
  private static SimpleDateFormat jdField_b_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yyyyMMddHH");
  public static boolean b = false;
  public static final String bA = "actDefaultObserverCost";
  public static final String bB = "addFriendSource";
  public static final String bC = "qqlsReprotTag";
  public static final String bD = "qqlsSettingReprotTag";
  public static final String bE = "ptvGuideReportTag";
  public static final String bF = "ptvTeachGuideReportTag";
  public static final String bH = "CrashInfoSummary.txt";
  public static final String bI = "actNvwaConfig";
  public static final String bJ = "actNvwaDownload";
  public static final String bK = "actNvwaCheck";
  public static final String bL = "actNvwaLoad";
  public static final String bM = "actNvwaInstall";
  private static final String bN = "next_reportTime";
  private static final String bO = "End_Info";
  private static final String bP = "AndroidQQUseApp";
  private static final String bQ = "AndroidQQRunTime";
  private static final String bR = "mqq_dailyUse";
  private static final String bS = "/data/data/com.tencent.mobileqq/files/";
  public static final String ba = "actLongMessageTimeDownload";
  public static final String bb = "callqzonefrompushv2";
  public static final String bc = "actQZSourceDataReport";
  public static final String bd = "actQZPushDataReport";
  public static final String be = "actQZUnreadDataReport";
  public static final String bf = "qzonepushstate";
  public static final String bg = "callqzonefromfriendfeed";
  public static final String bh = "actQzonePluginPatch";
  public static final String bi = "prxyRegisterB";
  public static final String bj = "prxyRegisterT";
  public static final String bk = "prxyRegisterM";
  public static final String bl = "prxyRegFailCode";
  public static final String bm = "prxyRegDiffGroupNum";
  public static final String bn = "prxyRegNeedPullGroup";
  public static final String bo = "prxyLookupCoderNull";
  public static final String bp = "ltextAutoPullResult";
  public static final String bq = "ltextManualPullResult";
  public static final String br = "ltextNewReceiveResult";
  public static final String bs = "ltextNewSendResult";
  public static final String bt = "ltextOldReceiveResult";
  public static final String bu = "ltextOldSendResult";
  public static final String bv = "MixedMsgForward";
  public static final String bw = "MixedMsgReceived";
  public static final String bx = "MixedMsgClientAutoPull";
  public static final String by = "MixedMsgClientManualPull";
  public static final String bz = "actQqComicPicUpload";
  public static final int c = 101;
  private static final long jdField_c_of_type_Long = 15360L;
  public static final String c = "actMemory";
  private static boolean jdField_c_of_type_Boolean = false;
  public static final int d = 102;
  public static final String d = "actSyncMsgFirst";
  private static final boolean d = true;
  public static final int e = 200;
  public static final String e = "actSyncMsgSecond";
  public static final int f = 201;
  public static final String f = "actQQInit";
  private static boolean f = false;
  public static final int g = 202;
  public static final String g = "actSendC2CProcess";
  public static final int h = 300;
  public static final String h = "actSendC2CPictureProcess";
  public static final int i = 301;
  public static final String i = "actSendGroupProcess";
  public static final int j = 302;
  public static final String j = "actSendGroupPictureProcess";
  public static final int k = 400;
  public static final String k = "dim.actSendGroupPttMsg";
  public static final int l = 401;
  public static final String l = "facePicUploadProcess";
  public static final int m = 500;
  public static final String m = "sendMsgTooLargeErrorTag";
  public static final int n = 501;
  public static final String n = "revokeMsgErrorTag";
  public static final int o = 502;
  public static final String o = "msg_cache_strategy_tag";
  public static final int p = 503;
  public static final String p = "msgNotificationStatsTag";
  public static final int q = 504;
  public static final String q = "tMSearchUpdateReq";
  private static final int r = 10;
  public static final String r = "tMSearchBuiltIndexCost";
  private static final int s = 28800000;
  public static final String s = "illegalGraytipId";
  public static final String t = "netchangeNotifyWaitQueue";
  public static final String u = "PAJSSDKPicUploadProcess";
  public static final String v = "C2BUploadFile";
  public static final String w = "msgSendCostPerPhase";
  public static final String x = "version_patchlib_load";
  public static final String y = "actPicUploadV2.Card.Picture";
  public static final String z = "actPicDownloadV2.Card.Picture";
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder("DPC info:\n");
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap(4);
  private LinkedList jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private Stack jdField_a_of_type_JavaUtilStack = new Stack();
  uup jdField_a_of_type_Uup = new uup();
  public boolean a;
  private uuq[] jdField_a_of_type_ArrayOfUuq = { new uuq("com.tencent.mtt", "qqBrowser"), new uuq("com.tencent.android.qqdownloader", "qqMarket"), new uuq("com.tencent.qqgame", "qqGame"), new uuq("com.tencent.qqmusic", "qqMusic"), new uuq("com.tencent.news", "qqNews"), new uuq("com.qq.reader", "qqReader"), new uuq("com.tencent.qqlive", "qqVideo"), new uuq("com.tencent.wblog", "qqMicroblog"), new uuq("com.tencent.qqphonebook", "qqPhonebook") };
  private StringBuilder jdField_b_of_type_JavaLangStringBuilder = new StringBuilder("Thread info:\n");
  public String bG = "999";
  private String bT;
  private boolean e;
  private int t;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private StatisticCollector(Context paramContext, long paramLong)
  {
    this.jdField_a_of_type_Boolean = false;
    jdField_a_of_type_AndroidContentContext = paramContext;
    UserAction.setUserID("10000");
    UserAction.initUserAction(jdField_a_of_type_AndroidContentContext, false, paramLong);
    UserAction.setChannelID("10000049");
  }
  
  public static int a()
  {
    return LocalMultiProcConfig.a("version_patchlib_load", 0);
  }
  
  public static StatisticCollector a(Context paramContext)
  {
    return a(paramContext, 3000L);
  }
  
  public static StatisticCollector a(Context paramContext, long paramLong)
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    if (localBaseApplication != null) {
      paramContext = localBaseApplication;
    }
    if (jdField_a_of_type_ComTencentMobileqqStatisticsStatisticCollector == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqStatisticsStatisticCollector == null) {
        jdField_a_of_type_ComTencentMobileqqStatisticsStatisticCollector = new StatisticCollector(paramContext, paramLong);
      }
      return jdField_a_of_type_ComTencentMobileqqStatisticsStatisticCollector;
    }
    finally {}
  }
  
  private String a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    int i1 = 0;
    if (i1 < this.jdField_a_of_type_ArrayOfUuq.length)
    {
      String str = this.jdField_a_of_type_ArrayOfUuq[i1].a;
      if (!paramString.toLowerCase().contains(str)) {}
    }
    for (paramString = this.jdField_a_of_type_ArrayOfUuq[i1].b;; paramString = null)
    {
      return paramString;
      i1 += 1;
      break;
    }
  }
  
  private static Map a()
  {
    HashMap localHashMap = new HashMap(16);
    localHashMap.put("param_MODEL", DeviceInfoUtil.d());
    localHashMap.put("param_manu", DeviceInfoUtil.k());
    localHashMap.put("param_OS", DeviceInfoUtil.e());
    localHashMap.put("param_Resolution", MsfSdkUtils.getResolutionString(jdField_a_of_type_AndroidContentContext));
    localHashMap.put("param_IMEI", DeviceInfoUtil.a());
    localHashMap.put("param_IMSI", DeviceInfoUtil.b());
    localHashMap.put("param_NetworkType", "" + NetworkUtil.b(jdField_a_of_type_AndroidContentContext));
    localHashMap.put("param_ProductVersion", "" + AppSetting.jdField_a_of_type_Int);
    localHashMap.put("param_CPU", DeviceInfoUtil.g());
    localHashMap.put("param_totalmemory", MsfSdkUtils.getTotalMemory());
    localHashMap.put("param_availmemory", String.valueOf(DeviceInfoUtil.d() / 1024L) + "kB");
    long[] arrayOfLong = DeviceInfoUtil.a();
    localHashMap.put("param_totalrom", String.valueOf(arrayOfLong[0]) + "MB");
    localHashMap.put("param_availrom", String.valueOf(arrayOfLong[1]) + "MB");
    arrayOfLong = DeviceInfoUtil.b();
    localHashMap.put("param_totalsd", String.valueOf(arrayOfLong[0]) + "MB");
    localHashMap.put("param_availsd", String.valueOf(arrayOfLong[1]) + "MB");
    localHashMap.put("param_Camera", "" + DeviceInfoUtil.c());
    return localHashMap;
  }
  
  public static void a(int paramInt)
  {
    LocalMultiProcConfig.a("version_patchlib_load", paramInt);
    if (paramInt > 0) {
      QLog.i("PatchLibLoader", 1, "setQzonePatchTag" + paramInt);
    }
  }
  
  private void a(Context paramContext, String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramContext == null)) {}
    for (;;)
    {
      return;
      Object localObject = ((ActivityManager)paramContext.getSystemService("activity")).getRunningServices(200);
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          ActivityManager.RunningServiceInfo localRunningServiceInfo = (ActivityManager.RunningServiceInfo)((Iterator)localObject).next();
          if (paramString.equals(localRunningServiceInfo.process))
          {
            Intent localIntent = new Intent();
            localIntent.setComponent(localRunningServiceInfo.service);
            QLog.d("StatisticCollector", 1, "Stop service: " + localRunningServiceInfo.service + ", clientCount: " + localRunningServiceInfo.clientCount + ", clientPackage: " + localRunningServiceInfo.clientPackage + ", crashCount: " + localRunningServiceInfo.crashCount);
            paramContext.stopService(localIntent);
          }
        }
      }
    }
  }
  
  public static void a(Map paramMap, int paramInt)
  {
    paramMap.put("param_FailCode", String.valueOf(paramInt));
  }
  
  private boolean a(String paramString)
  {
    if ("actC2CPicUploadV1".equals(paramString)) {}
    while (("actC2CPicUploadV2".equals(paramString)) || ("actGroupPicUploadV2".equals(paramString)) || ("actDiscussPicUploadV2".equals(paramString)) || ("actC2CPicDownloadV1".equals(paramString)) || ("actC2CPicSmallDownV1".equals(paramString)) || ("actGroupPicUploadV1".equals(paramString)) || ("actGroupPicDownloadV1".equals(paramString)) || ("actGroupPicSmallDownV1".equals(paramString)) || ("actDiscussPicUpload".equals(paramString)) || ("actDiscussPicDown".equals(paramString)) || ("actDiscussPicSmallDown".equals(paramString)) || ("actGrpPttUp".equals(paramString)) || ("actGrpPttDown".equals(paramString)) || ("actDisscusPttUp".equals(paramString)) || ("actDisscusPttDown".equals(paramString)) || ("actC2CStreamPttUpload".equals(paramString)) || ("actC2CStreamPttDownload".equals(paramString)) || ("actC2CPttDownload".equals(paramString)) || ("actC2CPttUpload".equals(paramString)) || ("actFileDown".equals(paramString)) || ("actFileUp".equals(paramString)) || ("actFileOf2Of".equals(paramString)) || ("actFileOf2Wy".equals(paramString)) || ("actFileWy2Of".equals(paramString)) || ("actFileWyUp".equals(paramString)) || ("actFileWyDown".equals(paramString)) || ("actFileUpDetail".equals(paramString)) || ("actFileDownDetail".equals(paramString)) || ("actFAFileDown".equals(paramString)) || ("actFAFileUp".equals(paramString)) || ("actShortVideoUpload".equals(paramString)) || ("actShortVideoUploadBDH".equals(paramString)) || ("actShortVideoDiscussgroupUploadBDH".equals(paramString)) || ("actShortVideoForwardBDH".equals(paramString)) || ("actShortVideoDownloadVideo".equals(paramString)) || ("actShortVideoDownloadThumb".equals(paramString)) || ("actShortVideoDiscussgroupUpload".equals(paramString)) || ("actShortVideoDiscussgroupDownloadVideo".equals(paramString)) || ("actShortVideoDiscussgroupDownloadThumb".equals(paramString)) || ("PicStatisticsManagerUploadPic".equals(paramString))) {
      return true;
    }
    return false;
  }
  
  private static String b()
  {
    StringBuilder localStringBuilder = new StringBuilder("RAM Info:all=");
    Object localObject = new DecimalFormat();
    ((DecimalFormat)localObject).applyPattern("0.0");
    try
    {
      long l1 = DeviceInfoUtil.c() / 1024L / 1024L;
      long l2 = DeviceInfoUtil.d() / 1024L / 1024L;
      Debug.MemoryInfo[] arrayOfMemoryInfo = ((ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity")).getProcessMemoryInfo(new int[] { Process.myPid() });
      float f2 = -1.0F;
      float f1 = f2;
      if (arrayOfMemoryInfo != null)
      {
        f1 = f2;
        if (arrayOfMemoryInfo.length > 0) {
          f1 = arrayOfMemoryInfo[0].getTotalPss() / 1024.0F;
        }
      }
      f2 = (float)Runtime.getRuntime().freeMemory() / 1024.0F / 1024.0F;
      float f3 = (float)Runtime.getRuntime().totalMemory() / 1024.0F / 1024.0F;
      float f4 = (float)Runtime.getRuntime().maxMemory() / 1024.0F / 1024.0F;
      localStringBuilder.append(l1).append("M,avaiable:").append(l2).append("M used:").append(((DecimalFormat)localObject).format(f1)).append("M freeMemory:").append(f2).append("M,appTotalMemory:").append(f3).append("M,maxMemory:").append(f4).append("M, ImgCache:").append(BaseApplicationImpl.a.size() / 1024 / 1024).append("M,SkinCache:").append(SkinEngine.dumpDrawableCacheMemSize() / 1024L / 1024L).append("M,LeakMonitor=").append(MemoryReporter.a().jdField_a_of_type_Boolean);
      localObject = (ArrayList)MemoryReporter.jdField_a_of_type_JavaUtilArrayList.clone();
      if (((ArrayList)localObject).size() > 0)
      {
        localStringBuilder.append(",Leaked=[");
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          localStringBuilder.append((String)((Iterator)localObject).next());
          localStringBuilder.append(",");
        }
      }
      return localStringBuilder.toString();
    }
    catch (Throwable localThrowable) {}
    for (;;)
    {
      localStringBuilder.append("]");
    }
  }
  
  private void b(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.remove(paramString1);
    paramString2 = paramString2 + " time:" + System.currentTimeMillis() + "\n";
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, paramString2);
  }
  
  public void a()
  {
    String str = DeviceProfileManager.b().a(DeviceProfileManager.DpcNames.crash_control.name(), null);
    if (!TextUtils.isEmpty(str)) {}
    try
    {
      Object localObject = new JSONObject(str);
      this.jdField_a_of_type_Uup.jdField_a_of_type_Boolean = ((JSONObject)localObject).getBoolean("control_switch");
      this.jdField_a_of_type_Uup.jdField_a_of_type_Int = ((JSONObject)localObject).getInt("control_level");
      this.jdField_a_of_type_Uup.b = ((JSONObject)localObject).getInt("control_window");
      this.jdField_a_of_type_Uup.c = ((JSONObject)localObject).getInt("control_freq");
      localObject = this.jdField_a_of_type_JavaLangStringBuilder.append("initCrashControl");
      ((StringBuilder)localObject).append(",controlJson=").append(str);
      ((StringBuilder)localObject).append(",switch=").append(this.jdField_a_of_type_Uup.jdField_a_of_type_Boolean);
      ((StringBuilder)localObject).append(",level=").append(this.jdField_a_of_type_Uup.jdField_a_of_type_Int);
      ((StringBuilder)localObject).append(",window=").append(this.jdField_a_of_type_Uup.b);
      ((StringBuilder)localObject).append(",Freq=").append(this.jdField_a_of_type_Uup.c);
      this.jdField_a_of_type_JavaLangStringBuilder.append("\n");
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        this.jdField_a_of_type_Uup.a();
        QLog.d("StatisticCollector", 1, "initCrashControl parse json throws an exception, so reset.");
      }
    }
  }
  
  public void a(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = paramContext.toString();
      this.jdField_a_of_type_JavaUtilStack.push(paramContext);
      b("onCreate", paramContext);
    }
  }
  
  public void a(String paramString)
  {
    this.bG = paramString;
    try
    {
      UserAction.setUserID(paramString);
      CrashReport.setUserId(jdField_a_of_type_AndroidContentContext, paramString);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.length() == 0) || (paramString2 == null) || (paramString2.length() == 0)) {}
    for (;;)
    {
      return;
      paramString1 = new uuo(System.currentTimeMillis(), paramString1, paramString2);
      this.jdField_a_of_type_JavaUtilLinkedList.add(paramString1);
      int i1 = this.t;
      for (this.t = (paramString1.jdField_a_of_type_Int + i1); (this.t > 15360L) && (this.jdField_a_of_type_JavaUtilLinkedList.size() > 1); this.t -= paramString1.jdField_a_of_type_Int) {
        paramString1 = (uuo)this.jdField_a_of_type_JavaUtilLinkedList.removeLast();
      }
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    for (;;)
    {
      String str1;
      HashMap localHashMap;
      Object localObject1;
      Object localObject2;
      try
      {
        str1 = String.valueOf(paramInt);
        localHashMap = new HashMap();
        localHashMap.put("resultCode", str1);
        localHashMap.put("patchId", paramString3);
        if (!TextUtils.isEmpty(paramString1)) {
          break label505;
        }
        localObject1 = BaseApplicationImpl.a().a();
        if (localObject1 == null) {
          break label499;
        }
        localObject1 = ((AppRuntime)localObject1).getAccount();
        paramString1 = (String)localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject2 = BaseApplicationImpl.a().getFirstSimpleAccount();
          paramString1 = (String)localObject1;
          if (localObject2 != null) {
            paramString1 = ((SimpleAccount)localObject2).getUin();
          }
        }
        QLog.d("StatisticCollector", 1, "reportDexPatch curUin=" + paramString1 + ", event=" + paramString2 + ", result=" + paramInt + ", patchId=" + paramString3);
        if (paramInt % 100 != 0) {
          break label509;
        }
        bool = true;
        if (("actNvwaConfig".equals(paramString2)) || ("actNvwaDownload".equals(paramString2)))
        {
          a(paramString1, paramString2, bool, 0L, 0L, localHashMap, null);
          QLog.d("StatisticCollector", 1, "reportDexPatch collectPerformance " + paramString2);
          return;
        }
        localObject2 = jdField_a_of_type_AndroidContentContext.getSharedPreferences("sp_dex_patch", 4);
        paramString3 = paramString2 + paramString3;
        localObject1 = ((SharedPreferences)localObject2).getString(paramString3, "");
        localObject2 = ((SharedPreferences)localObject2).edit();
        if ("actNvwaCheck".equals(paramString2))
        {
          if (((String)localObject1).equals(str1)) {
            break label508;
          }
          a(paramString1, paramString2, bool, 0L, 0L, localHashMap, null);
          ((SharedPreferences.Editor)localObject2).putString(paramString3, str1).commit();
          QLog.d("StatisticCollector", 1, "reportDexPatch collectPerformance actNvwaCheck");
          return;
        }
      }
      catch (Throwable paramString1)
      {
        QLog.d("StatisticCollector", 1, "reportDexPatch throwable=" + paramString1.toString());
        paramString1.printStackTrace();
        return;
      }
      if ("actNvwaInstall".equals(paramString2))
      {
        String str2 = jdField_b_of_type_JavaTextSimpleDateFormat.format(new Date(System.currentTimeMillis()));
        str1 = str1 + str2.substring(0, 8) + Integer.parseInt(str2.substring(8)) / 8;
        if ((TextUtils.isEmpty((CharSequence)localObject1)) || (!((String)localObject1).equals(str1)))
        {
          a(paramString1, paramString2, bool, 0L, 0L, localHashMap, null);
          ((SharedPreferences.Editor)localObject2).putString(paramString3, str1).commit();
          QLog.d("StatisticCollector", 1, "reportDexPatch collectPerformance actNvwaInstall");
          return;
          label499:
          localObject1 = paramString1;
          continue;
          label505:
          continue;
        }
      }
      label508:
      return;
      label509:
      boolean bool = false;
    }
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2, HashMap paramHashMap, String paramString3)
  {
    a(paramString1, paramString2, paramBoolean, paramLong1, paramLong2, paramHashMap, paramString3, false);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean1, long paramLong1, long paramLong2, HashMap paramHashMap, String paramString3, boolean paramBoolean2)
  {
    if (paramString1 == null) {
      paramString1 = "10000";
    }
    for (;;)
    {
      paramString3 = paramString1;
      if (paramString1 != null)
      {
        paramString3 = paramString1;
        if (paramString1.length() < 1) {
          paramString3 = "10000";
        }
      }
      UserAction.setUserID(paramString3);
      if (paramHashMap == null)
      {
        paramString1 = new HashMap();
        if (paramString1 != null) {
          paramString1.put("param_ProductVersion", "" + AppSetting.jdField_a_of_type_Int);
        }
        if (QLog.isColorLevel()) {
          QLog.d("StatisticCollector", 2, "event report: " + paramString2 + " " + paramBoolean1 + " time:" + paramLong1 + " size:" + paramLong2);
        }
        if ((paramBoolean1) && ((!paramString1.containsKey("param_FailCode")) || ("".equals(paramString1.get("param_FailCode"))))) {
          paramString1.put("param_FailCode", String.valueOf(0));
        }
        paramHashMap = new RdmReq();
        paramHashMap.eventName = paramString2;
        paramHashMap.elapse = paramLong1;
        paramHashMap.size = paramLong2;
        paramHashMap.isSucceed = paramBoolean1;
        paramHashMap.isRealTime = paramBoolean2;
        if (a(paramString2))
        {
          paramHashMap.isMerge = false;
          paramHashMap.isRealTime = true;
        }
        paramHashMap.params = paramString1;
      }
      try
      {
        paramString1 = MsfMsgUtil.getRdmReportMsg(MsfServiceSdk.get().getMsfServiceName(), paramHashMap);
        paramString1.setAppId(AppSetting.jdField_a_of_type_Int);
        paramString1.setTimeout(30000L);
        ThreadManager.a(new uun(this, paramString1), 5, null, true);
        return;
      }
      catch (Exception paramString1)
      {
        return;
      }
      paramString3 = paramHashMap.keySet().iterator();
      for (;;)
      {
        paramString1 = paramHashMap;
        if (!paramString3.hasNext()) {
          break;
        }
        paramString1 = (String)paramString3.next();
        if ((String)paramHashMap.get(paramString1) == null) {
          paramHashMap.put(paramString1, "");
        }
      }
    }
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    if (f) {}
    long l1;
    long l2;
    do
    {
      do
      {
        return;
      } while ((paramAppRuntime == null) || (!paramAppRuntime.isLogin()));
      localObject = jdField_a_of_type_AndroidContentContext.getSharedPreferences("mobileQQ", 0);
      l1 = ((SharedPreferences)localObject).getLong("next_reportTime_" + paramAppRuntime.getAccount(), 0L);
      l2 = (NetConnInfoCenter.getServerTimeMillis() + 28800000L) / 86400000L;
    } while (l2 < l1);
    f = true;
    ((SharedPreferences)localObject).edit().putLong("next_reportTime_" + paramAppRuntime.getAccount(), 1L + l2).commit();
    Object localObject = new NewIntent(paramAppRuntime.getApplication(), ReportServlet.class);
    ((NewIntent)localObject).putExtra("sendType", 2);
    ((NewIntent)localObject).putExtra("tag", "mqq_dailyUse");
    ((NewIntent)localObject).putExtra("content", "");
    paramAppRuntime.startServlet((NewIntent)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "Report Daily Use,Next Report Day:" + l2 + 1);
    }
    f = false;
  }
  
  public void a(AppRuntime paramAppRuntime, String paramString)
  {
    if ((paramAppRuntime == null) || (paramString == null)) {}
    do
    {
      return;
      paramString = a(paramString);
    } while (paramString == null);
    paramString = paramString + '|';
    paramString = paramString + "1|";
    NewIntent localNewIntent = new NewIntent(paramAppRuntime.getApplication(), ReportServlet.class);
    localNewIntent.putExtra("sendType", 2);
    localNewIntent.putExtra("tag", "AndroidQQUseApp");
    localNewIntent.putExtra("content", paramString);
    paramAppRuntime.startServlet(localNewIntent);
  }
  
  public void a(AppRuntime paramAppRuntime, String paramString, int paramInt)
  {
    if ((paramAppRuntime == null) || (paramString == null)) {
      return;
    }
    a(paramAppRuntime, paramString, paramInt, "", "", "");
  }
  
  public void a(AppRuntime paramAppRuntime, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    if ((paramAppRuntime == null) || (paramString1 == null)) {}
    do
    {
      return;
      paramString1 = paramString1 + "|" + paramString2 + "|" + paramString3 + "|" + paramInt + "|" + paramString4;
      paramString2 = new NewIntent(paramAppRuntime.getApplication(), ReportServlet.class);
      paramString2.putExtra("sendType", 2);
      paramString2.putExtra("tag", "appPlug");
      paramString2.putExtra("content", paramString1);
      paramAppRuntime.startServlet(paramString2);
    } while (!QLog.isColorLevel());
    QLog.d("reportToAds", 2, paramString1);
  }
  
  public void a(AppRuntime paramAppRuntime, String paramString1, String paramString2)
  {
    if ((paramAppRuntime == null) || (paramString1 == null)) {
      return;
    }
    a(paramAppRuntime, paramString1, 1, "", "", paramString2);
  }
  
  @Deprecated
  public void a(AppRuntime paramAppRuntime, String paramString1, String paramString2, int paramInt)
  {
    if ((paramAppRuntime == null) || (paramString1 == null) || (paramString2 == null)) {
      return;
    }
    paramString1 = paramString2 + "|" + paramInt;
    paramString2 = new NewIntent(paramAppRuntime.getApplication(), ReportServlet.class);
    paramString2.putExtra("sendType", 2);
    paramString2.putExtra("tag", "mqq_tab");
    paramString2.putExtra("content", paramString1);
    paramAppRuntime.startServlet(paramString2);
  }
  
  @Deprecated
  public void a(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3)
  {
    if ((paramAppRuntime == null) || (paramString1 == null) || (paramString2 == null)) {
      return;
    }
    paramString1 = paramString2 + "|" + paramString3;
    paramString2 = new NewIntent(paramAppRuntime.getApplication(), ReportServlet.class);
    paramString2.putExtra("sendType", 2);
    paramString2.putExtra("tag", "mqq_tab");
    paramString2.putExtra("content", paramString1);
    paramAppRuntime.startServlet(paramString2);
  }
  
  @Deprecated
  public void a(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    if ((paramAppRuntime == null) || (paramString1 == null) || (paramString2 == null) || (paramString3 == null)) {
      return;
    }
    String str = paramString4;
    if (paramString4 == null) {
      str = "0";
    }
    paramString4 = paramString5;
    if (paramString5 == null) {
      paramString4 = "";
    }
    paramString5 = paramString6;
    if (paramString6 == null) {
      paramString5 = "";
    }
    paramString6 = paramString7;
    if (paramString7 == null) {
      paramString6 = "";
    }
    paramString7 = paramString8;
    if (paramString8 == null) {
      paramString7 = "";
    }
    paramString8 = new StringBuilder(128);
    paramString8.append(paramAppRuntime.getAccount()).append('|').append(paramString1).append('|').append(paramString2).append('|').append(paramString3).append('|').append(paramInt1).append('|').append(paramInt2).append('|').append(str).append('|').append(paramString4).append('|').append(paramString5).append('|').append(paramString6).append('|').append(paramString7).append('|');
    paramString1 = new NewIntent(paramAppRuntime.getApplication(), ReportServlet.class);
    paramString1.putExtra("sendType", 2);
    paramString1.putExtra("tag", "CliOper");
    paramString1.putExtra("content", paramString8.toString());
    paramAppRuntime.startServlet(paramString1);
  }
  
  @Deprecated
  public void a(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramAppRuntime == null) || (paramString1 == null) || (paramString3 == null) || (paramString4 == null)) {}
    StringBuilder localStringBuilder;
    do
    {
      return;
      localStringBuilder = new StringBuilder(128);
      localStringBuilder.append(paramString1).append('|').append(paramString2).append('|').append(paramString3).append('|').append(paramString4).append('|').append(paramInt1).append('|').append(paramInt2).append('|').append(paramInt3);
      localStringBuilder.append('|').append('|').append('|').append('|').append('|');
      paramString1 = new NewIntent(paramAppRuntime.getApplication(), ReportServlet.class);
      paramString1.putExtra("sendType", 2);
      paramString1.putExtra("tag", "CliOper");
      paramString1.putExtra("content", localStringBuilder.toString());
      paramAppRuntime.startServlet(paramString1);
    } while (!QLog.isColorLevel());
    QLog.d("StatisticCollector", 2, "tag=CliOper,content=" + localStringBuilder.toString());
  }
  
  @Deprecated
  public void a(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramAppRuntime == null) || (paramString1 == null) || (paramString3 == null) || (paramString4 == null)) {}
    StringBuilder localStringBuilder;
    do
    {
      return;
      localStringBuilder = new StringBuilder(128);
      localStringBuilder.append(paramString1).append('|').append(paramString2).append('|').append(paramString3).append('|').append(paramString4).append('|').append(paramInt1).append('|').append(paramInt2).append('|').append(paramInt3).append('|').append(paramInt4).append('|').append('|').append('|').append('|');
      paramString1 = new NewIntent(paramAppRuntime.getApplication(), ReportServlet.class);
      paramString1.putExtra("sendType", 2);
      paramString1.putExtra("tag", "CliOper");
      paramString1.putExtra("content", localStringBuilder.toString());
      paramAppRuntime.startServlet(paramString1);
    } while (!QLog.isColorLevel());
    QLog.d("StatisticCollector", 2, "tag=CliOper,content=" + localStringBuilder.toString());
  }
  
  @Deprecated
  public void a(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    if ((paramAppRuntime == null) || (paramString1 == null) || (paramString3 == null) || (paramString4 == null)) {
      return;
    }
    String str = paramString5;
    if (paramString5 == null) {
      str = "";
    }
    paramString5 = paramString6;
    if (paramString6 == null) {
      paramString5 = "";
    }
    paramString6 = paramString7;
    if (paramString7 == null) {
      paramString6 = "";
    }
    paramString7 = paramString8;
    if (paramString8 == null) {
      paramString7 = "";
    }
    paramString8 = new StringBuilder(128);
    paramString8.append(paramString1).append('|').append(paramString2).append('|').append(paramString3).append('|').append(paramString4).append('|').append(paramInt1).append('|').append(paramInt2).append('|').append(paramInt3).append('|').append(str).append('|').append(paramString5).append('|').append(paramString6).append('|').append(paramString7).append('|');
    paramString1 = new NewIntent(paramAppRuntime.getApplication(), ReportServlet.class);
    paramString1.putExtra("sendType", 2);
    paramString1.putExtra("tag", "CliOper");
    paramString1.putExtra("content", paramString8.toString());
    paramAppRuntime.startServlet(paramString1);
  }
  
  @Deprecated
  public void a(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramAppRuntime == null) || (paramString1 == null) || (paramString4 == null) || (paramString5 == null)) {}
    StringBuilder localStringBuilder;
    do
    {
      return;
      localStringBuilder = new StringBuilder(128);
      localStringBuilder.append(paramString3).append('|').append(paramString1).append('|').append("").append('|').append(paramString4).append('|').append(paramString5).append('|').append(paramInt1).append('|').append(paramInt2).append('|').append(paramInt3);
      localStringBuilder.append('|').append(paramString2).append('|').append('|').append('|').append('|');
      paramString1 = new NewIntent(paramAppRuntime.getApplication(), ReportServlet.class);
      paramString1.putExtra("sendType", 2);
      paramString1.putExtra("tag", "P_CliOper");
      paramString1.putExtra("content", localStringBuilder.toString());
      paramAppRuntime.startServlet(paramString1);
    } while (!QLog.isColorLevel());
    QLog.d("StatisticCollector", 2, "tag=P_CliOper,content=" + localStringBuilder.toString());
  }
  
  @Deprecated
  public void a(AppRuntime paramAppRuntime, String paramString, Map paramMap)
  {
    if ((paramAppRuntime == null) || (paramString == null) || (paramMap == null)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder(128);
    Object localObject = paramMap.keySet();
    paramString = new ArrayList(paramMap.size());
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      localStringBuilder.append(str).append("|").append(paramMap.get(str)).append("|");
      paramString.add(localStringBuilder.toString());
      localStringBuilder.delete(0, localStringBuilder.length());
    }
    paramMap = new NewIntent(paramAppRuntime.getApplication(), ReportServlet.class);
    paramMap.putExtra("sendType", 6);
    paramMap.putExtra("tag", "custom_set");
    paramMap.putExtra("content", paramString);
    paramAppRuntime.startServlet(paramMap);
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_Uup.jdField_a_of_type_Boolean) {
      QLog.d("StatisticCollector", 1, "updateLocalCrashData crash control is off..");
    }
    Object localObject;
    do
    {
      return;
      localObject = BaseApplicationImpl.a().startComponentInfo;
      if ((this.jdField_a_of_type_Uup.jdField_a_of_type_Int == 2) && ((TextUtils.isEmpty((CharSequence)localObject)) || (!((String)localObject).contains("QQBroadcastReceiver"))))
      {
        QLog.d("StatisticCollector", 1, "updateLocalCrashData controllevel is 2 but not QQBroadcastReceiver start QQ.");
        return;
      }
      localObject = jdField_a_of_type_AndroidContentContext.getSharedPreferences("crashcontrol", 0);
    } while (localObject == null);
    long l1 = ((SharedPreferences)localObject).getLong("starttime", 0L);
    int i1 = ((SharedPreferences)localObject).getInt("crashcount", 0);
    long l2 = System.currentTimeMillis();
    this.jdField_a_of_type_JavaLangStringBuilder.append("updateLocalCrashData startTime=").append(jdField_a_of_type_JavaTextSimpleDateFormat.format(new Date(l1))).append(",currenttime=").append(jdField_a_of_type_JavaTextSimpleDateFormat.format(new Date(l2))).append(",crashCount=").append(i1).append(",mCurUin=").append(this.bG).append("\n");
    if ((l1 <= 0L) || (l2 <= l1) || (i1 < 0) || (l2 - l1 > this.jdField_a_of_type_Uup.b * 1000))
    {
      i1 = 1;
      l1 = l2;
    }
    for (;;)
    {
      if (i1 > this.jdField_a_of_type_Uup.c) {
        this.jdField_a_of_type_Boolean = true;
      }
      this.jdField_a_of_type_JavaLangStringBuilder.append("updateLocalCrashData shouldStopMsf=").append(this.jdField_a_of_type_Boolean).append("\n");
      ((SharedPreferences)localObject).edit().putLong("starttime", l1).putInt("crashcount", i1).putBoolean("shouldStopMsf", this.jdField_a_of_type_Boolean).commit();
      return;
      i1 += 1;
    }
  }
  
  public void b(Context paramContext)
  {
    if (paramContext != null) {
      b("onResume", paramContext.toString());
    }
  }
  
  public void b(String paramString)
  {
    boolean bool1 = true;
    if (!this.jdField_a_of_type_Uup.jdField_a_of_type_Boolean) {
      QLog.d("StatisticCollector", 1, "updatePreloadCrashData crash control is off..");
    }
    SharedPreferences localSharedPreferences;
    do
    {
      return;
      localSharedPreferences = jdField_a_of_type_AndroidContentContext.getSharedPreferences("CrashControl_" + paramString, 4);
    } while (localSharedPreferences == null);
    long l1 = localSharedPreferences.getLong("starttime", 0L);
    int i1 = localSharedPreferences.getInt("crashcount", 0);
    boolean bool2 = localSharedPreferences.getBoolean("allowpreload", true);
    long l2 = System.currentTimeMillis();
    this.jdField_a_of_type_JavaLangStringBuilder.append("updatePreloadCrashData process=").append(paramString).append(",startTime=").append(jdField_a_of_type_JavaTextSimpleDateFormat.format(new Date(l1))).append(",currenttime=").append(jdField_a_of_type_JavaTextSimpleDateFormat.format(new Date(l2))).append(",crashCount=").append(i1).append(",allowPreload=").append(bool2).append(",mCurUin=").append(this.bG).append("\n");
    if ((l1 <= 0L) || (l2 <= l1) || (i1 < 0) || (l2 - l1 > this.jdField_a_of_type_Uup.b * 1000))
    {
      i1 = 1;
      l1 = l2;
    }
    for (;;)
    {
      if (i1 > this.jdField_a_of_type_Uup.c) {
        bool1 = false;
      }
      this.jdField_a_of_type_JavaLangStringBuilder.append("updatePreloadCrashData update allowPreload=").append(bool1).append("\n");
      localSharedPreferences.edit().putLong("starttime", l1).putInt("crashcount", i1).putBoolean("allowpreload", bool1).putInt("controlwindow", this.jdField_a_of_type_Uup.b).commit();
      return;
      i1 += 1;
    }
  }
  
  @Deprecated
  public void b(AppRuntime paramAppRuntime, String paramString)
  {
    NewIntent localNewIntent = new NewIntent(paramAppRuntime.getApplication(), ReportServlet.class);
    localNewIntent.putExtra("sendType", 2);
    localNewIntent.putExtra("tag", "MsgOper");
    localNewIntent.putExtra("content", paramString);
    paramAppRuntime.startServlet(localNewIntent);
    if (QLog.isColorLevel()) {
      QLog.d("StatisticCollector", 2, "tag=MsgOper,content=" + paramString);
    }
  }
  
  public void b(AppRuntime paramAppRuntime, String paramString1, String paramString2, int paramInt)
  {
    a(paramAppRuntime, paramString2, paramInt);
  }
  
  @Deprecated
  public void b(AppRuntime paramAppRuntime, String paramString, Map paramMap)
  {
    if ((paramAppRuntime == null) || (paramString == null) || (paramMap == null)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder(128);
    Object localObject = paramMap.keySet();
    paramString = new ArrayList(paramMap.size());
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      localStringBuilder.append(str).append("|").append(paramMap.get(str)).append("|");
      paramString.add(localStringBuilder.toString());
      localStringBuilder.delete(0, localStringBuilder.length());
    }
    paramMap = new NewIntent(paramAppRuntime.getApplication(), ReportServlet.class);
    paramMap.putExtra("sendType", 6);
    paramMap.putExtra("tag", "on_off");
    paramMap.putExtra("content", paramString);
    paramAppRuntime.startServlet(paramMap);
  }
  
  public void c(Context paramContext)
  {
    if (paramContext != null) {
      b("onPause", paramContext.toString());
    }
  }
  
  public void c(String paramString)
  {
    this.bG = paramString;
    CrashReport.setLogAble(false, false);
    Object localObject1 = new CrashStrategyBean();
    ((CrashStrategyBean)localObject1).setMaxStackFrame(6);
    QLog.d("StatisticCollector", 1, "initCrashReport ... process:" + BaseApplicationImpl.processName + " pid=" + Process.myPid());
    if (BaseApplicationImpl.processName.endsWith(":qzone"))
    {
      int i1 = a();
      if (i1 > 0)
      {
        Object localObject2 = BaseApplicationImpl.a().a();
        if (localObject2 != null)
        {
          localObject2 = ((AppRuntime)localObject2).getApplication();
          if (localObject2 != null)
          {
            localObject2 = ((Context)localObject2).getPackageManager().getPackageInfo(((Context)localObject2).getPackageName(), 0);
            if ((localObject2 != null) && (((PackageInfo)localObject2).versionName != null))
            {
              localObject2 = ((PackageInfo)localObject2).versionName + "." + (i1 + ((PackageInfo)localObject2).versionCode);
              CrashReport.setProductVersion(BaseApplicationImpl.a(), (String)localObject2);
            }
          }
        }
      }
    }
    CrashReport.initCrashReport(jdField_a_of_type_AndroidContentContext, new uui(this), null, true, (CrashStrategyBean)localObject1, 30000L);
    localObject1 = jdField_a_of_type_AndroidContentContext.getDir("tombs", 0).getAbsolutePath();
    try
    {
      QLog.d("StatisticCollector", 1, "initNativeCrashReport ... process:" + BaseApplicationImpl.processName + " pid=" + Process.myPid());
      CrashReport.initNativeCrashReport(jdField_a_of_type_AndroidContentContext, (String)localObject1, false);
      ANRReport.stopANRMonitor();
      CrashReport.setUserId(jdField_a_of_type_AndroidContentContext, paramString);
      this.jdField_b_of_type_JavaLangStringBuilder.append("Current process name=").append(BaseApplicationImpl.processName).append("\n");
      if (BaseApplicationImpl.processName.equals("com.tencent.mobileqq")) {
        ThreadManager.b().postDelayed(new uuj(this, paramString), 3000L);
      }
      ThreadManager.a().post(new uuk(this));
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("StatisticCollector", 2, "", localUnsatisfiedLinkError);
        }
      }
    }
  }
  
  @Deprecated
  public void c(AppRuntime paramAppRuntime, String paramString)
  {
    NewIntent localNewIntent = new NewIntent(paramAppRuntime.getApplication(), ReportServlet.class);
    localNewIntent.putExtra("sendType", 2);
    localNewIntent.putExtra("tag", "P_CliOper");
    localNewIntent.putExtra("content", paramString);
    paramAppRuntime.startServlet(localNewIntent);
    if (QLog.isColorLevel()) {
      QLog.d("StatisticCollector", 2, "tag=P_CliOper,content=" + paramString);
    }
  }
  
  public void d(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = paramContext.toString();
      this.jdField_a_of_type_JavaUtilStack.remove(paramContext);
      b("onDestroy", paramContext);
    }
  }
  
  public void d(String paramString)
  {
    Map localMap = a();
    if ((paramString == null) || (localMap == null)) {
      return;
    }
    Iterator localIterator = localMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((String)localMap.get(str) == null) {
        localMap.put(str, "");
      }
    }
    UserAction.setUserID(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("StatisticCollector", 2, "report End_Info:" + localMap.toString());
    }
    paramString = new RdmReq();
    paramString.eventName = "End_Info";
    paramString.elapse = -1L;
    paramString.size = 0L;
    paramString.isSucceed = true;
    paramString.isRealTime = true;
    paramString.isMerge = false;
    paramString.params = localMap;
    try
    {
      paramString = MsfMsgUtil.getRdmReportMsg(MsfServiceSdk.get().getMsfServiceName(), paramString);
      paramString.setAppId(AppSetting.jdField_a_of_type_Int);
      paramString.setTimeout(30000L);
      MsfServiceSdk.get().sendMsg(paramString);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void d(AppRuntime paramAppRuntime, String paramString)
  {
    if ((paramAppRuntime == null) || (paramString == null)) {
      return;
    }
    a(paramAppRuntime, paramString, 1, "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\statistics\StatisticCollector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */