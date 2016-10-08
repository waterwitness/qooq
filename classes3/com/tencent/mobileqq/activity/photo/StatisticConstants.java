package com.tencent.mobileqq.activity.photo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Environment;
import android.preference.PreferenceManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager.DpcAccountNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyCardManager;
import com.tencent.mobileqq.richmedia.dc.PhotoUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;

public class StatisticConstants
{
  public static final String A = "PhotoConst.total_save_count";
  public static final String B = "PhotoConst.camerapreviewactivity_enter_times";
  public static final String C = "PhotoConst.camerapreviewactivity_send_times";
  public static final String D = "PhotoConst.camerapreviewactivity_send_rate";
  public static final String E = "PhotoConst.camerapreviewactivity_enter_times_fast";
  public static final String F = "PhotoConst.camerapreviewactivity_send_times_fast";
  public static final String G = "PhotoConst.camerapreviewactivity_send_rate_fast";
  public static final String H = "PhotoConst.photopreviewactivity_send";
  public static final String I = "PhotoConst.photopreviewactivity_send_pic_count";
  public static final String J = "PhotoConst.photopreviewactivity_send_pic_total_count";
  public static final String K = "PhotoConst.photopreviewactivity_send_pic_rate";
  public static final String L = "PhotoConst.photopreviewactivity_send_pic_quality";
  public static final String M = "param_type";
  public static final String N = "param_totalSelNum";
  public static final String O = "param_selNum";
  public static final String P = "param_netType";
  public static final String Q = "param_urlType";
  public static final String R = "param_cancelSelNum";
  public static final String S = "param_consumTime";
  public static final String T = "param_aio_duration";
  public static final String U = "param_second_trans";
  public static final String V = "param_phone_type";
  public static final String W = "param_showing_progress";
  public static final String X = "param_pic_filesize";
  public static final String Y = "param_optimizePercent";
  public static final String Z = "param_averageTime";
  private static final int a = 1001;
  public static final long a = 86400000L;
  public static final String a = "StatisticConstants";
  public static final String aA = "param_screnshot_qq_cnt";
  public static final String aB = "param_screnshot_other_cnt";
  public static final String aC = "param_qq_collection_cnt";
  public static final String aD = "param_qq_image_cnt";
  public static final String aE = "param_qq_filerecv_cnt";
  public static final String aF = "param_qq_zebra_cnt";
  public static final String aG = "param_qq_favorite_cnt";
  public static final String aH = "param_sourceDetailUrl";
  public static final String aI = "param_uinType";
  public static final String aJ = "param_forwardSourceUinType";
  public static final String aK = "param_picSizeType";
  public static final String aL = "param_isForward";
  public static final String aM = "param_age";
  public static final String aN = "param_gender";
  public static final String aO = "param_userType";
  public static final String aP = "param_picSuffixType";
  public static final String aQ = "param_picMD5";
  public static final String aR = "param_isRAWPic";
  public static final String aS = "param_fileName";
  public static final String aT = "param_picReportHour";
  public static final String aU = "param_picInterval";
  public static final String aV = "param_picBatchCount";
  public static final String aW = "param_initTime";
  public static final String aX = "param_compressInitTime";
  public static final String aY = "actPSselectSendPic";
  public static final String aZ = "actPScompressPic";
  public static final String aa = "param_residentTime";
  public static final String ab = "param_selCount";
  public static final String ac = "param_sendCount";
  public static final String ad = "param_saveCount";
  public static final String ae = "param_sendPercent";
  public static final String af = "param_cameraCount";
  public static final String ag = "param_browseCount";
  public static final String ah = "param_WasteSize";
  public static final String ai = "param_cancelType";
  public static final String aj = "param_systemAlbumSendCount";
  public static final String ak = "param_otherSendCount";
  public static final String al = "param_appSendCount";
  public static final String am = "param_weixinSendCount";
  public static final String an = "param_sougouSendCount";
  public static final String ao = "param_qqpinyinSendCount";
  public static final String ap = "param_screnshotQQSendCount";
  public static final String aq = "param_screnshotOtherSendCount";
  public static final String ar = "param_qq_collection_SendCount";
  public static final String as = "param_qq_image_SendCount";
  public static final String at = "param_qq_filerecv_SendCount";
  public static final String au = "param_qq_zebra_SendCount";
  public static final String av = "param_qq_favorite_SendCount";
  public static final String aw = "param_systemAlbumCount";
  public static final String ax = "param_otherCount";
  public static final String ay = "param_appCount";
  public static final String az = "param_weixinCnt";
  private static final int b = 1002;
  public static final String b = "PhotoConst.last_send_select_rate_time";
  public static final String ba = "actPSdonecompressPic";
  public static final String bb = "actPSdoneaioduration";
  public static final String bc = "actPScancelSend";
  public static final String bd = "actPSdaySelSend";
  public static final String be = "actPSdayCameraSend";
  public static final String bf = "actPSdayQuickSend";
  public static final String bg = "actPSdayWastedSize";
  public static final String bh = "actPSWaste";
  public static final String bi = "actPSCompressTimeOut";
  public static final String bj = "actPSprogressTime";
  public static final String bk = "actDaySendPicSourceType";
  public static final String bl = "actPhotoSourceDetailUrl";
  public static final String bm = "actAlbumPicSourceType";
  public static final String bn = "actAIOPhotoSave";
  public static final String bo = "actDayTotalSave";
  public static final String bp = "actVideoCompressTime";
  public static final String bq = "param_compressTime";
  public static final String br = "param_compressSuccess";
  public static final String bs = "param_file_source_size";
  public static final String bt = "param_file_target_sze";
  private static final int c = 1003;
  public static final String c = "PhotoConst.last_send_select_rate_time_preview";
  private static final int d = 1004;
  public static final String d = "PhotoConst.last_send_camera_preview_rate";
  private static final int e = 1005;
  public static final String e = "PhotoConst.last_send_camera_preview_rate_fast";
  private static final int f = 1006;
  public static final String f = "PhotoConst.last_send_pic_source_type";
  private static final int g = 1007;
  public static final String g = "PhotoConst.last_album_source_type";
  private static final int h = 1008;
  public static final String h = "PhotoConst.last_total_save_count";
  private static final int i = 1009;
  public static final String i = "PhotoConst.photolistactivity_send";
  private static final int j = 1010;
  public static final String j = "PhotoConst.photolistactivity_pic_quality";
  private static final int k = 1011;
  public static final String k = "PhotoConst.photolistactivity_pic_count";
  private static final int l = 1012;
  public static final String l = "PhotoConst.photolistactivity_pic_total_count";
  private static final int m = 1013;
  public static final String m = "PhotoConst.photolistactivity_pic_rate";
  private static final int n = 1001;
  public static final String n = "PhotoConst.photolistactivity_systemalbum_send_count";
  private static final int o = 1002;
  public static final String o = "PhotoConst.photolistactivity_other_send_count";
  public static final String p = "PhotoConst.photolistactivity_app_send_count";
  public static final String q = "PhotoConst.photolistactivity_weixin_send_count";
  public static final String r = "PhotoConst.photolistactivity_sougou_send_count";
  public static final String s = "PhotoConst.photolistactivity_qqpinyin_send_count";
  public static final String t = "PhotoConst.photolistactivity_screnshot_qq_send_count";
  public static final String u = "PhotoConst.photolistactivity_screnshot_other_send_count";
  public static final String v = "PhotoConst.photolistactivity_qq_collection_send_count";
  public static final String w = "PhotoConst.photolistactivity_qq_image_send_count";
  public static final String x = "PhotoConst.photolistactivity_qq_filerecv_send_count";
  public static final String y = "PhotoConst.photolistactivity_qq_zebra_send_count";
  public static final String z = "PhotoConst.photolistactivity_qq_favorite_send_count";
  
  public StatisticConstants()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static int a()
  {
    int i2 = 1;
    int i1;
    if ((DeviceInfoUtil.c() >>> 20 < 600L) || (DeviceInfoUtil.b() == 1)) {
      i1 = 0;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StatisticConstants", 2, "getDeviceType,DeviceInfoUtil.getSystemTotalMemory() =" + (DeviceInfoUtil.c() >>> 20) + ",DeviceInfoUtil.getCpuNumber() = " + DeviceInfoUtil.b() + ",phoneType = " + i1);
      }
      return i1;
      i1 = i2;
      if (DeviceInfoUtil.c() >>> 20 >= 1536.0D)
      {
        i1 = i2;
        if (DeviceInfoUtil.b() >= 4) {
          i1 = 2;
        }
      }
    }
  }
  
  public static void a()
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
    int i1 = localSharedPreferences.getInt("PhotoConst.camerapreviewactivity_enter_times", 0);
    localSharedPreferences.edit().putInt("PhotoConst.camerapreviewactivity_enter_times", i1 + 1).commit();
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StatisticConstants", 2, "sendPhotoPreviewSelectRateStatistic (" + paramInt1 + " ," + paramInt2 + ")");
    }
    SharedPreferences localSharedPreferences;
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
      long l1 = localSharedPreferences.getLong("PhotoConst.last_send_select_rate_time_preview", 0L);
      long l2 = System.currentTimeMillis();
      paramInt1 = localSharedPreferences.getInt("PhotoConst.photopreviewactivity_send_pic_count", 0) + paramInt1;
      paramInt2 = localSharedPreferences.getInt("PhotoConst.photopreviewactivity_send_pic_total_count", 0) + paramInt2;
      if (l2 - l1 > 86400000L)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("PhotoConst.photopreviewactivity_send_pic_count", paramInt1 + "");
        localHashMap.put("PhotoConst.photopreviewactivity_send_pic_rate", paramInt1 / paramInt2 + "");
        StatisticCollector.a(BaseApplication.getContext()).a(null, "PhotoConst.photopreviewactivity_send", false, 0L, 0L, localHashMap, "", false);
        localSharedPreferences.edit().putLong("PhotoConst.last_send_select_rate_time_preview", l2).putInt("PhotoConst.photopreviewactivity_send_pic_count", 0).putInt("PhotoConst.photopreviewactivity_send_pic_total_count", 0).commit();
      }
    }
    else
    {
      return;
    }
    localSharedPreferences.edit().putInt("PhotoConst.photopreviewactivity_send_pic_count", paramInt1).putInt("PhotoConst.photopreviewactivity_send_pic_total_count", paramInt2).commit();
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("StatisticConstants", 4, "userAlbumSourceTypeStatistic (" + paramInt1 + "," + paramInt2 + "," + paramInt3 + "," + paramInt4 + "," + paramInt5 + "," + paramInt6 + "," + paramInt7 + "," + paramInt8 + "," + paramInt9 + "," + paramInt10 + "," + paramInt11 + ")");
    }
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
    long l1 = localSharedPreferences.getLong("PhotoConst.last_album_source_type", 0L);
    long l2 = System.currentTimeMillis();
    if (l2 - l1 > 86400000L)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_systemAlbumCount", paramInt1 + "");
      localHashMap.put("param_screnshot_qq_cnt", paramInt2 + "");
      localHashMap.put("param_screnshot_other_cnt", paramInt3 + "");
      localHashMap.put("param_appCount", paramInt4 + "");
      localHashMap.put("param_otherCount", paramInt5 + "");
      localHashMap.put("param_qq_collection_cnt", paramInt6 + "");
      localHashMap.put("param_qq_filerecv_cnt", paramInt8 + "");
      localHashMap.put("param_qq_image_cnt", paramInt7 + "");
      localHashMap.put("param_qq_zebra_cnt", paramInt9 + "");
      localHashMap.put("param_qq_favorite_cnt", paramInt10 + "");
      localHashMap.put("param_weixinCnt", paramInt11 + "");
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actAlbumPicSourceType", false, 0L, 0L, localHashMap, "", false);
      localSharedPreferences.edit().putLong("PhotoConst.last_album_source_type", l2).commit();
    }
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, int paramInt13, int paramInt14, int paramInt15, int paramInt16)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("StatisticConstants", 4, "sendPhotoListSourceTypeStatistic (" + paramInt1 + "," + paramInt2 + "," + paramInt3 + "," + paramInt4 + "," + paramInt5 + "," + paramInt6 + "," + paramInt7 + "," + paramInt8 + "," + paramInt9 + "," + paramInt10 + "," + paramInt11 + "," + paramInt12 + "," + paramInt13 + ")" + ",age = " + paramInt14 + ",gender = " + paramInt15 + ",userType = " + paramInt16);
    }
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
    long l1 = localSharedPreferences.getLong("PhotoConst.last_send_pic_source_type", 0L);
    long l2 = System.currentTimeMillis();
    paramInt1 = localSharedPreferences.getInt("PhotoConst.photolistactivity_systemalbum_send_count", 0) + paramInt1;
    paramInt2 = localSharedPreferences.getInt("PhotoConst.photolistactivity_screnshot_qq_send_count", 0) + paramInt2;
    paramInt3 = localSharedPreferences.getInt("PhotoConst.photolistactivity_screnshot_other_send_count", 0) + paramInt3;
    paramInt5 = localSharedPreferences.getInt("PhotoConst.photolistactivity_other_send_count", 0) + paramInt5;
    paramInt4 = localSharedPreferences.getInt("PhotoConst.photolistactivity_app_send_count", 0) + paramInt4;
    paramInt6 = localSharedPreferences.getInt("PhotoConst.photolistactivity_qq_collection_send_count", 0) + paramInt6;
    paramInt7 = localSharedPreferences.getInt("PhotoConst.photolistactivity_qq_image_send_count", 0) + paramInt7;
    paramInt8 = localSharedPreferences.getInt("PhotoConst.photolistactivity_qq_filerecv_send_count", 0) + paramInt8;
    paramInt9 = localSharedPreferences.getInt("PhotoConst.photolistactivity_qq_zebra_send_count", 0) + paramInt9;
    paramInt10 = localSharedPreferences.getInt("PhotoConst.photolistactivity_qq_favorite_send_count", 0) + paramInt10;
    paramInt11 = localSharedPreferences.getInt("PhotoConst.photolistactivity_weixin_send_count", 0) + paramInt11;
    paramInt12 = localSharedPreferences.getInt("PhotoConst.photolistactivity_sougou_send_count", 0) + paramInt12;
    paramInt13 = localSharedPreferences.getInt("PhotoConst.photolistactivity_qqpinyin_send_count", 0) + paramInt13;
    if (l2 - l1 > 86400000L)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_systemAlbumSendCount", paramInt1 + "");
      localHashMap.put("param_screnshotQQSendCount", paramInt2 + "");
      localHashMap.put("param_screnshotOtherSendCount", paramInt3 + "");
      localHashMap.put("param_otherSendCount", paramInt5 + "");
      localHashMap.put("param_appSendCount", paramInt4 + "");
      localHashMap.put("param_qq_collection_SendCount", paramInt6 + "");
      localHashMap.put("param_qq_image_SendCount", paramInt7 + "");
      localHashMap.put("param_qq_filerecv_SendCount", paramInt8 + "");
      localHashMap.put("param_qq_zebra_SendCount", paramInt9 + "");
      localHashMap.put("param_qq_favorite_SendCount", paramInt10 + "");
      localHashMap.put("param_weixinSendCount", paramInt11 + "");
      localHashMap.put("param_sougouSendCount", paramInt12 + "");
      localHashMap.put("param_qqpinyinSendCount", paramInt13 + "");
      localHashMap.put("param_age", paramInt14 + "");
      localHashMap.put("param_gender", paramInt15 + "");
      localHashMap.put("param_userType", paramInt16 + "");
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actDaySendPicSourceType", false, 0L, 0L, localHashMap, "", false);
      localSharedPreferences.edit().putLong("PhotoConst.last_send_pic_source_type", l2).putInt("PhotoConst.photolistactivity_systemalbum_send_count", 0).putInt("PhotoConst.photolistactivity_screnshot_qq_send_count", 0).putInt("PhotoConst.photolistactivity_screnshot_other_send_count", 0).putInt("PhotoConst.photolistactivity_other_send_count", 0).putInt("PhotoConst.photolistactivity_app_send_count", 0).putInt("PhotoConst.photolistactivity_qq_collection_send_count", 0).putInt("PhotoConst.photolistactivity_qq_image_send_count", 0).putInt("PhotoConst.photolistactivity_qq_filerecv_send_count", 0).putInt("PhotoConst.photolistactivity_qq_zebra_send_count", 0).putInt("PhotoConst.photolistactivity_qq_favorite_send_count", 0).putInt("PhotoConst.photolistactivity_weixin_send_count", 0).putInt("PhotoConst.photolistactivity_sougou_send_count", 0).putInt("PhotoConst.photolistactivity_qqpinyin_send_count", 0).commit();
      return;
    }
    localSharedPreferences.edit().putInt("PhotoConst.photolistactivity_systemalbum_send_count", paramInt1).putInt("PhotoConst.photolistactivity_screnshot_qq_send_count", paramInt2).putInt("PhotoConst.photolistactivity_screnshot_other_send_count", paramInt3).putInt("PhotoConst.photolistactivity_other_send_count", paramInt5).putInt("PhotoConst.photolistactivity_app_send_count", paramInt4).putInt("PhotoConst.photolistactivity_qq_collection_send_count", paramInt6).putInt("PhotoConst.photolistactivity_qq_image_send_count", paramInt7).putInt("PhotoConst.photolistactivity_qq_filerecv_send_count", paramInt8).putInt("PhotoConst.photolistactivity_qq_zebra_send_count", paramInt9).putInt("PhotoConst.photolistactivity_qq_favorite_send_count", paramInt10).putInt("PhotoConst.photolistactivity_weixin_send_count", paramInt11).putInt("PhotoConst.photolistactivity_sougou_send_count", paramInt12).putInt("PhotoConst.photolistactivity_qqpinyin_send_count", paramInt13).commit();
  }
  
  public static void a(long paramLong)
  {
    if (paramLong <= 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StatisticConstants", 2, "reportActPSdayWastedSize,size <= 0,return! size = " + paramLong);
      }
      return;
    }
    HashMap localHashMap = new HashMap();
    if (DeviceProfileManager.a().a(DeviceProfileManager.AccountDpcManager.DpcAccountNames.picpredownload_whitelist.name())) {}
    for (int i1 = 1002;; i1 = 1001)
    {
      int i2 = NetworkUtil.a(BaseApplication.getContext());
      int i3 = a();
      localHashMap.put("param_netType", i2 + "");
      localHashMap.put("param_phone_type", i3 + "");
      localHashMap.put("param_userType", i1 + "");
      localHashMap.put("param_WasteSize", paramLong + "");
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actPSdayWastedSize", false, 0L, 0L, localHashMap, "", false);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("StatisticConstants", 2, "reportActPSdayWastedSize,WastedSize =" + paramLong);
      return;
    }
  }
  
  public static void a(long paramLong, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    if (DeviceProfileManager.a().a(DeviceProfileManager.AccountDpcManager.DpcAccountNames.picpredownload_whitelist.name())) {}
    for (int i1 = 1002;; i1 = 1001)
    {
      int i2 = NetworkUtil.a(BaseApplication.getContext());
      int i3 = a();
      localHashMap.put("param_netType", i2 + "");
      localHashMap.put("param_phone_type", i3 + "");
      localHashMap.put("param_userType", i1 + "");
      localHashMap.put("param_WasteSize", paramLong + "");
      localHashMap.put("param_cancelType", paramInt + "");
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actPSWaste", false, 0L, 0L, localHashMap, "", false);
      if (QLog.isColorLevel()) {
        QLog.d("StatisticConstants", 2, "reportActPSWaste,size = " + paramLong + ",cancelType = " + paramInt);
      }
      return;
    }
  }
  
  public static void a(long paramLong, int paramInt, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    if ((paramLong == 0L) || (paramInt == 0) || (paramLong > 86400000L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("StatisticConstants", 2, "reportActPSdonecompressPic,invalid arg,return!");
      }
      return;
    }
    long l1 = paramLong / paramInt;
    int i2 = a();
    if (DeviceProfileManager.a().a(DeviceProfileManager.AccountDpcManager.DpcAccountNames.picpredownload_whitelist.name())) {}
    for (int i1 = 1002;; i1 = 1001)
    {
      localHashMap.put("param_userType", i1 + "");
      localHashMap.put("param_phone_type", i2 + "");
      localHashMap.put("param_consumTime", paramLong + "");
      localHashMap.put("param_selNum", paramInt + "");
      localHashMap.put("param_showing_progress", paramBoolean + "");
      localHashMap.put("param_averageTime", l1 + "");
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actPSdonecompressPic", false, 0L, 0L, localHashMap, "", false);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("StatisticConstants", 2, "reportActPSdonecompressPic,param_consumTime =" + paramLong + ",param_selNum = " + paramInt + ",param_averageTime = " + l1 + ",isShowing = " + paramBoolean);
      return;
    }
  }
  
  public static void a(long paramLong1, long paramLong2, boolean paramBoolean, double paramDouble)
  {
    HashMap localHashMap = new HashMap();
    if ((paramLong1 > 86400000L) || (paramDouble < 0.0D) || (paramDouble > 1.0D))
    {
      if (QLog.isColorLevel()) {
        QLog.d("StatisticConstants", 2, "reportActPSdoneAioDuration,invalid arg,return!");
      }
      return;
    }
    int i2 = NetworkUtil.a(BaseApplication.getContext());
    int i3 = a();
    if (DeviceProfileManager.a().a(DeviceProfileManager.AccountDpcManager.DpcAccountNames.picpredownload_whitelist.name())) {}
    for (int i1 = 1002;; i1 = 1001)
    {
      localHashMap.put("param_userType", i1 + "");
      localHashMap.put("param_netType", i2 + "");
      localHashMap.put("param_aio_duration", paramLong1 + "");
      localHashMap.put("param_second_trans", paramBoolean + "");
      localHashMap.put("param_phone_type", i3 + "");
      localHashMap.put("param_pic_filesize", paramLong2 + "");
      localHashMap.put("param_optimizePercent", paramDouble + "");
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actPSdoneaioduration", false, 0L, 0L, localHashMap, "", false);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("StatisticConstants", 2, "reportActPSdoneAioDuration,aioduration =" + paramLong1 + ",filesize = " + paramLong2 + ",isSecondTrans = " + paramBoolean + ",phoneType = " + i3 + ",percent = " + paramDouble);
      return;
    }
  }
  
  public static void a(Intent paramIntent)
  {
    HashMap localHashMap = new HashMap();
    long l1 = paramIntent.getLongExtra("param_compressInitTime", 0L);
    if (l1 == 0L) {
      if (QLog.isColorLevel()) {
        QLog.d("StatisticConstants", 2, "reportActPScompressPic,initTime == 0,return!");
      }
    }
    long l2;
    int i1;
    do
    {
      do
      {
        return;
        l2 = System.currentTimeMillis() - l1;
      } while (l2 > 86400000L);
      i1 = paramIntent.getIntExtra("param_selNum", 0);
      if (i1 != 0) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("StatisticConstants", 2, "reportActPScompressPic,param_selNum == 0,return!");
    return;
    if (i1 > 0) {}
    for (l1 = l2 / i1;; l1 = 0L)
    {
      localHashMap.put("param_consumTime", l2 + "");
      localHashMap.put("param_selNum", i1 + "");
      localHashMap.put("param_averageTime", l1 + "");
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actPScompressPic", false, 0L, 0L, localHashMap, "", false);
      paramIntent.removeExtra("param_compressInitTime");
      paramIntent.removeExtra("param_selNum");
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("StatisticConstants", 2, "reportActPScompressPic,param_consumTime =" + l2 + ",param_selNum = " + i1 + ",param_averageTime = " + l1);
      return;
    }
  }
  
  public static void a(Intent paramIntent, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("StatisticConstants", 4, "sendPhotoListSelectRateStatistic (" + paramInt + ")");
    }
    int i1 = paramIntent.getIntExtra("param_totalSelNum", 0);
    if ((paramInt > 0) && (i1 > 0))
    {
      paramIntent = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
      long l1 = paramIntent.getLong("PhotoConst.last_send_select_rate_time", 0L);
      long l2 = System.currentTimeMillis();
      paramInt = paramIntent.getInt("PhotoConst.photolistactivity_pic_count", 0) + paramInt;
      i1 += paramIntent.getInt("PhotoConst.photolistactivity_pic_total_count", 0);
      if (l2 - l1 > 86400000L)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("param_sendCount", paramInt + "");
        localHashMap.put("param_selCount", i1 + "");
        localHashMap.put("param_sendPercent", paramInt / i1 + "");
        StatisticCollector.a(BaseApplication.getContext()).a(null, "actPSdaySelSend", false, 0L, 0L, localHashMap, "", false);
        paramIntent.edit().putLong("PhotoConst.last_send_select_rate_time", l2).putInt("PhotoConst.photolistactivity_pic_count", 0).putInt("PhotoConst.photolistactivity_pic_total_count", 0).commit();
      }
    }
    else
    {
      return;
    }
    paramIntent.edit().putInt("PhotoConst.photolistactivity_pic_count", paramInt).putInt("PhotoConst.photolistactivity_pic_total_count", i1).commit();
  }
  
  public static void a(Intent paramIntent, int paramInt1, int paramInt2)
  {
    long l1 = paramIntent.getLongExtra("param_initTime", 0L);
    if (l1 == 0L) {
      if (QLog.isColorLevel()) {
        QLog.d("StatisticConstants", 2, "reportActPSselectSendPic,initTime == 0,return!");
      }
    }
    long l2;
    do
    {
      return;
      l2 = System.currentTimeMillis() - l1;
    } while (l2 > 86400000L);
    if (paramInt1 > 0) {}
    for (l1 = l2 / paramInt1;; l1 = 0L)
    {
      int i1 = paramIntent.getIntExtra("param_cancelSelNum", 0);
      HashMap localHashMap = new HashMap();
      int i2 = NetworkUtil.a(BaseApplication.getContext());
      localHashMap.put("param_netType", i2 + "");
      localHashMap.put("param_type", paramInt2 + "");
      localHashMap.put("param_cancelSelNum", i1 + "");
      localHashMap.put("param_consumTime", l2 + "");
      localHashMap.put("param_selNum", paramInt1 + "");
      localHashMap.put("param_averageTime", l1 + "");
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actPSselectSendPic", false, 0L, 0L, localHashMap, "", false);
      paramIntent.removeExtra("param_initTime");
      paramIntent.removeExtra("param_cancelSelNum");
      paramIntent.removeExtra("param_totalSelNum");
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("StatisticConstants", 2, "reportActPSselectSendPic,param_type =" + paramInt2 + ",param_cancelSelNum = " + i1 + ",param_consumTime = " + l2 + ",param_selNum = " + paramInt1 + ",param_averageTime = " + l1);
      return;
    }
  }
  
  public static void a(Intent paramIntent, String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("StatisticConstants", 4, "incrementStatisticParam(" + paramString);
    }
    if (paramIntent != null) {
      paramIntent.putExtra(paramString, paramIntent.getIntExtra(paramString, 0) + 1);
    }
  }
  
  /* Error */
  public static void a(String paramString, int paramInt, QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_2
    //   6: bipush 105
    //   8: invokevirtual 645	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   11: checkcast 647	com/tencent/mobileqq/nearby/NearbyCardManager
    //   14: astore_2
    //   15: aload_2
    //   16: ifnull +960 -> 976
    //   19: aload_2
    //   20: invokevirtual 648	com/tencent/mobileqq/nearby/NearbyCardManager:a	()I
    //   23: istore 6
    //   25: aload_2
    //   26: invokevirtual 649	com/tencent/mobileqq/nearby/NearbyCardManager:b	()I
    //   29: istore 5
    //   31: new 651	android/graphics/BitmapFactory$Options
    //   34: dup
    //   35: invokespecial 652	android/graphics/BitmapFactory$Options:<init>	()V
    //   38: astore_2
    //   39: aload_2
    //   40: iconst_1
    //   41: putfield 655	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   44: aload_0
    //   45: aload_2
    //   46: invokestatic 661	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   49: pop
    //   50: aload_2
    //   51: getfield 664	android/graphics/BitmapFactory$Options:outWidth	I
    //   54: istore 9
    //   56: aload_2
    //   57: getfield 667	android/graphics/BitmapFactory$Options:outHeight	I
    //   60: istore 10
    //   62: iload 9
    //   64: i2l
    //   65: iload 10
    //   67: i2l
    //   68: invokestatic 672	com/tencent/mobileqq/richmedia/dc/PhotoUtils:a	(JJ)I
    //   71: istore 11
    //   73: iload_1
    //   74: istore 7
    //   76: iload_1
    //   77: ifeq +24 -> 101
    //   80: iload_1
    //   81: istore 7
    //   83: iload_1
    //   84: iconst_1
    //   85: if_icmpeq +16 -> 101
    //   88: iload_1
    //   89: istore 7
    //   91: iload_1
    //   92: sipush 3000
    //   95: if_icmpeq +6 -> 101
    //   98: iconst_5
    //   99: istore 7
    //   101: aconst_null
    //   102: astore 4
    //   104: new 674	java/io/FileInputStream
    //   107: dup
    //   108: aload_0
    //   109: invokespecial 676	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   112: astore_3
    //   113: aload_3
    //   114: new 678	java/io/File
    //   117: dup
    //   118: aload_0
    //   119: invokespecial 679	java/io/File:<init>	(Ljava/lang/String;)V
    //   122: invokevirtual 682	java/io/File:length	()J
    //   125: invokestatic 688	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   128: astore_2
    //   129: aload_2
    //   130: invokestatic 694	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   133: astore_2
    //   134: aload_2
    //   135: astore 4
    //   137: aload 4
    //   139: astore_2
    //   140: aload_3
    //   141: ifnull +10 -> 151
    //   144: aload_3
    //   145: invokevirtual 697	java/io/FileInputStream:close	()V
    //   148: aload 4
    //   150: astore_2
    //   151: aload_0
    //   152: invokestatic 702	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   155: astore_3
    //   156: aload_3
    //   157: invokevirtual 707	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   160: ldc_w 709
    //   163: invokevirtual 713	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   166: ifeq +763 -> 929
    //   169: iconst_0
    //   170: istore_1
    //   171: invokestatic 719	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   174: bipush 11
    //   176: invokevirtual 723	java/util/Calendar:get	(I)I
    //   179: istore 12
    //   181: invokestatic 542	com/tencent/mobileqq/app/DeviceProfileManager:a	()Lcom/tencent/mobileqq/app/DeviceProfileManager;
    //   184: getstatic 548	com/tencent/mobileqq/app/DeviceProfileManager$AccountDpcManager$DpcAccountNames:picpredownload_whitelist	Lcom/tencent/mobileqq/app/DeviceProfileManager$AccountDpcManager$DpcAccountNames;
    //   187: invokevirtual 551	com/tencent/mobileqq/app/DeviceProfileManager$AccountDpcManager$DpcAccountNames:name	()Ljava/lang/String;
    //   190: invokevirtual 554	com/tencent/mobileqq/app/DeviceProfileManager:a	(Ljava/lang/String;)Z
    //   193: ifeq +741 -> 934
    //   196: sipush 1002
    //   199: istore 8
    //   201: invokestatic 521	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   204: ifeq +160 -> 364
    //   207: ldc 89
    //   209: iconst_4
    //   210: new 420	java/lang/StringBuilder
    //   213: dup
    //   214: invokespecial 421	java/lang/StringBuilder:<init>	()V
    //   217: ldc_w 725
    //   220: invokevirtual 427	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: aload_0
    //   224: invokevirtual 427	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: ldc_w 727
    //   230: invokevirtual 427	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: iload 7
    //   235: invokevirtual 435	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   238: ldc_w 729
    //   241: invokevirtual 427	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: iload 11
    //   246: invokevirtual 435	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   249: ldc_w 530
    //   252: invokevirtual 427	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: iload 6
    //   257: invokevirtual 435	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   260: ldc_w 532
    //   263: invokevirtual 427	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: iload 5
    //   268: invokevirtual 435	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   271: ldc_w 731
    //   274: invokevirtual 427	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: iload 12
    //   279: invokevirtual 435	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   282: ldc_w 733
    //   285: invokevirtual 427	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: aload_2
    //   289: invokevirtual 427	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: ldc_w 735
    //   295: invokevirtual 427	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: iload_1
    //   299: invokevirtual 435	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   302: ldc_w 737
    //   305: invokevirtual 427	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: aload_3
    //   309: invokevirtual 427	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: ldc_w 739
    //   315: invokevirtual 427	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: aload_0
    //   319: invokestatic 742	com/tencent/qphone/base/util/MD5:toMD5	(Ljava/lang/String;)Ljava/lang/String;
    //   322: invokevirtual 427	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: ldc_w 744
    //   328: invokevirtual 427	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: iload 9
    //   333: invokevirtual 435	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   336: ldc_w 746
    //   339: invokevirtual 427	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: iload 10
    //   344: invokevirtual 435	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   347: ldc_w 534
    //   350: invokevirtual 427	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: iload 8
    //   355: invokevirtual 435	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   358: invokevirtual 441	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   361: invokestatic 444	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   364: new 495	java/util/HashMap
    //   367: dup
    //   368: invokespecial 496	java/util/HashMap:<init>	()V
    //   371: astore_0
    //   372: aload_0
    //   373: ldc 116
    //   375: new 420	java/lang/StringBuilder
    //   378: dup
    //   379: invokespecial 421	java/lang/StringBuilder:<init>	()V
    //   382: iload 7
    //   384: invokevirtual 435	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   387: ldc_w 498
    //   390: invokevirtual 427	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: invokevirtual 441	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   396: invokevirtual 502	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   399: pop
    //   400: aload_0
    //   401: ldc 122
    //   403: new 420	java/lang/StringBuilder
    //   406: dup
    //   407: invokespecial 421	java/lang/StringBuilder:<init>	()V
    //   410: iload 11
    //   412: invokevirtual 435	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   415: ldc_w 498
    //   418: invokevirtual 427	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: invokevirtual 441	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   424: invokevirtual 502	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   427: pop
    //   428: aload_0
    //   429: ldc -128
    //   431: new 420	java/lang/StringBuilder
    //   434: dup
    //   435: invokespecial 421	java/lang/StringBuilder:<init>	()V
    //   438: iload 6
    //   440: invokevirtual 435	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   443: ldc_w 498
    //   446: invokevirtual 427	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   449: invokevirtual 441	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   452: invokevirtual 502	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   455: pop
    //   456: aload_0
    //   457: ldc -125
    //   459: new 420	java/lang/StringBuilder
    //   462: dup
    //   463: invokespecial 421	java/lang/StringBuilder:<init>	()V
    //   466: iload 5
    //   468: invokevirtual 435	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   471: ldc_w 498
    //   474: invokevirtual 427	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   477: invokevirtual 441	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   480: invokevirtual 502	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   483: pop
    //   484: aload_0
    //   485: ldc -122
    //   487: new 420	java/lang/StringBuilder
    //   490: dup
    //   491: invokespecial 421	java/lang/StringBuilder:<init>	()V
    //   494: iload 8
    //   496: invokevirtual 435	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   499: ldc_w 498
    //   502: invokevirtual 427	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: invokevirtual 441	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   508: invokevirtual 502	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   511: pop
    //   512: aload_0
    //   513: ldc -116
    //   515: aload_2
    //   516: invokevirtual 502	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   519: pop
    //   520: aload_0
    //   521: ldc -119
    //   523: new 420	java/lang/StringBuilder
    //   526: dup
    //   527: invokespecial 421	java/lang/StringBuilder:<init>	()V
    //   530: iload_1
    //   531: invokevirtual 435	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   534: ldc_w 498
    //   537: invokevirtual 427	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: invokevirtual 441	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   543: invokevirtual 502	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   546: pop
    //   547: aload_0
    //   548: ldc -107
    //   550: new 420	java/lang/StringBuilder
    //   553: dup
    //   554: invokespecial 421	java/lang/StringBuilder:<init>	()V
    //   557: iload 12
    //   559: invokevirtual 435	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   562: ldc_w 498
    //   565: invokevirtual 427	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   568: invokevirtual 441	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   571: invokevirtual 502	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   574: pop
    //   575: invokestatic 452	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   578: invokestatic 510	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   581: aconst_null
    //   582: ldc_w 291
    //   585: iconst_0
    //   586: lconst_0
    //   587: lconst_0
    //   588: aload_0
    //   589: ldc_w 498
    //   592: iconst_0
    //   593: invokevirtual 513	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   596: invokestatic 452	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   599: invokestatic 458	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   602: astore_0
    //   603: aload_0
    //   604: ldc_w 333
    //   607: lconst_0
    //   608: invokeinterface 488 4 0
    //   613: lstore 13
    //   615: invokestatic 493	java/lang/System:currentTimeMillis	()J
    //   618: lstore 15
    //   620: aload_0
    //   621: ldc 8
    //   623: iconst_0
    //   624: invokeinterface 464 3 0
    //   629: iconst_1
    //   630: iadd
    //   631: istore_1
    //   632: lload 15
    //   634: lload 13
    //   636: lsub
    //   637: ldc2_w 86
    //   640: lcmp
    //   641: ifle +301 -> 942
    //   644: new 495	java/util/HashMap
    //   647: dup
    //   648: invokespecial 496	java/util/HashMap:<init>	()V
    //   651: astore_2
    //   652: aload_2
    //   653: ldc -128
    //   655: new 420	java/lang/StringBuilder
    //   658: dup
    //   659: invokespecial 421	java/lang/StringBuilder:<init>	()V
    //   662: iload 6
    //   664: invokevirtual 435	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   667: ldc_w 498
    //   670: invokevirtual 427	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   673: invokevirtual 441	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   676: invokevirtual 502	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   679: pop
    //   680: aload_2
    //   681: ldc -125
    //   683: new 420	java/lang/StringBuilder
    //   686: dup
    //   687: invokespecial 421	java/lang/StringBuilder:<init>	()V
    //   690: iload 5
    //   692: invokevirtual 435	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   695: ldc_w 498
    //   698: invokevirtual 427	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   701: invokevirtual 441	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   704: invokevirtual 502	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   707: pop
    //   708: aload_2
    //   709: ldc -122
    //   711: new 420	java/lang/StringBuilder
    //   714: dup
    //   715: invokespecial 421	java/lang/StringBuilder:<init>	()V
    //   718: iload 8
    //   720: invokevirtual 435	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   723: ldc_w 498
    //   726: invokevirtual 427	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   729: invokevirtual 441	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   732: invokevirtual 502	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   735: pop
    //   736: aload_2
    //   737: ldc -77
    //   739: new 420	java/lang/StringBuilder
    //   742: dup
    //   743: invokespecial 421	java/lang/StringBuilder:<init>	()V
    //   746: iload_1
    //   747: invokevirtual 435	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   750: ldc_w 498
    //   753: invokevirtual 427	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   756: invokevirtual 441	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   759: invokevirtual 502	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   762: pop
    //   763: invokestatic 452	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   766: invokestatic 510	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   769: aconst_null
    //   770: ldc_w 294
    //   773: iconst_0
    //   774: lconst_0
    //   775: lconst_0
    //   776: aload_2
    //   777: ldc_w 498
    //   780: iconst_0
    //   781: invokevirtual 513	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   784: aload_0
    //   785: invokeinterface 468 1 0
    //   790: ldc_w 333
    //   793: lload 15
    //   795: invokeinterface 517 4 0
    //   800: ldc 8
    //   802: iconst_0
    //   803: invokeinterface 474 3 0
    //   808: invokeinterface 477 1 0
    //   813: pop
    //   814: return
    //   815: astore_2
    //   816: new 678	java/io/File
    //   819: dup
    //   820: aload_0
    //   821: invokespecial 679	java/io/File:<init>	(Ljava/lang/String;)V
    //   824: astore_2
    //   825: aload_2
    //   826: invokevirtual 749	java/io/File:exists	()Z
    //   829: istore 17
    //   831: iload 17
    //   833: ifeq +138 -> 971
    //   836: aload_2
    //   837: invokestatic 754	com/tencent/qqprotect/singleupdate/MD5FileUtil:a	(Ljava/io/File;)Ljava/lang/String;
    //   840: astore_2
    //   841: aload_2
    //   842: ifnull +11 -> 853
    //   845: aload_2
    //   846: invokestatic 758	com/qq/taf/jce/HexUtil:hexStr2Bytes	(Ljava/lang/String;)[B
    //   849: astore_2
    //   850: goto -721 -> 129
    //   853: ldc_w 498
    //   856: astore_2
    //   857: goto -12 -> 845
    //   860: astore_2
    //   861: aconst_null
    //   862: astore_2
    //   863: goto -734 -> 129
    //   866: astore_2
    //   867: aload_2
    //   868: invokevirtual 761	java/io/IOException:printStackTrace	()V
    //   871: aload 4
    //   873: astore_2
    //   874: goto -723 -> 151
    //   877: astore_2
    //   878: aconst_null
    //   879: astore_3
    //   880: aload 4
    //   882: astore_2
    //   883: aload_3
    //   884: ifnull -733 -> 151
    //   887: aload_3
    //   888: invokevirtual 697	java/io/FileInputStream:close	()V
    //   891: aload 4
    //   893: astore_2
    //   894: goto -743 -> 151
    //   897: astore_2
    //   898: aload_2
    //   899: invokevirtual 761	java/io/IOException:printStackTrace	()V
    //   902: aload 4
    //   904: astore_2
    //   905: goto -754 -> 151
    //   908: astore_0
    //   909: aconst_null
    //   910: astore_3
    //   911: aload_3
    //   912: ifnull +7 -> 919
    //   915: aload_3
    //   916: invokevirtual 697	java/io/FileInputStream:close	()V
    //   919: aload_0
    //   920: athrow
    //   921: astore_2
    //   922: aload_2
    //   923: invokevirtual 761	java/io/IOException:printStackTrace	()V
    //   926: goto -7 -> 919
    //   929: iconst_1
    //   930: istore_1
    //   931: goto -760 -> 171
    //   934: sipush 1001
    //   937: istore 8
    //   939: goto -738 -> 201
    //   942: aload_0
    //   943: invokeinterface 468 1 0
    //   948: ldc 8
    //   950: iload_1
    //   951: invokeinterface 474 3 0
    //   956: invokeinterface 477 1 0
    //   961: pop
    //   962: return
    //   963: astore_0
    //   964: goto -53 -> 911
    //   967: astore_2
    //   968: goto -88 -> 880
    //   971: aconst_null
    //   972: astore_2
    //   973: goto -844 -> 129
    //   976: iconst_m1
    //   977: istore 5
    //   979: iconst_m1
    //   980: istore 6
    //   982: goto -951 -> 31
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	985	0	paramString	String
    //   0	985	1	paramInt	int
    //   0	985	2	paramQQAppInterface	QQAppInterface
    //   112	804	3	localObject	Object
    //   102	801	4	localQQAppInterface	QQAppInterface
    //   29	949	5	i1	int
    //   23	958	6	i2	int
    //   74	309	7	i3	int
    //   199	739	8	i4	int
    //   54	278	9	i5	int
    //   60	283	10	i6	int
    //   71	340	11	i7	int
    //   179	379	12	i8	int
    //   613	22	13	l1	long
    //   618	176	15	l2	long
    //   829	3	17	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   113	129	815	java/lang/UnsatisfiedLinkError
    //   836	841	860	java/io/IOException
    //   845	850	860	java/io/IOException
    //   144	148	866	java/io/IOException
    //   104	113	877	java/io/IOException
    //   887	891	897	java/io/IOException
    //   104	113	908	finally
    //   915	919	921	java/io/IOException
    //   113	129	963	finally
    //   129	134	963	finally
    //   816	831	963	finally
    //   836	841	963	finally
    //   845	850	963	finally
    //   113	129	967	java/io/IOException
    //   129	134	967	java/io/IOException
    //   816	831	967	java/io/IOException
  }
  
  private static void a(String paramString, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    if (paramString == null) {
      return;
    }
    Object localObject1 = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject1).inJustDecodeBounds = true;
    for (;;)
    {
      try
      {
        BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject1);
        i6 = ((BitmapFactory.Options)localObject1).outWidth;
        i7 = ((BitmapFactory.Options)localObject1).outHeight;
        i2 = paramInt1;
        if (paramInt1 != 0)
        {
          i2 = paramInt1;
          if (paramInt1 != 1)
          {
            i2 = paramInt1;
            if (paramInt1 != 3000) {
              i2 = 5;
            }
          }
        }
        i3 = paramInt2;
        if (paramInt2 != 0)
        {
          i3 = paramInt2;
          if (paramInt2 != 1)
          {
            i3 = paramInt2;
            if (paramInt2 != 3000) {
              i3 = 5;
            }
          }
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        try
        {
          int i6;
          int i7;
          int i2;
          int i3;
          localObject1 = Environment.getExternalStorageDirectory().toString();
          if ((localObject1 != null) && (paramString.contains((CharSequence)localObject1)))
          {
            localObject1 = paramString.replace((CharSequence)localObject1, "");
            paramInt1 = ((String)localObject1).lastIndexOf("/");
            Object localObject2 = localObject1;
            if (paramInt1 != -1) {
              localObject2 = ((String)localObject1).substring(0, paramInt1);
            }
            localObject1 = ((String)localObject2).replace("/", "//");
            int i8 = Calendar.getInstance().get(11);
            paramInt2 = -1;
            localObject2 = new File(paramString);
            paramInt1 = paramInt2;
            if (!paramBoolean2)
            {
              paramInt1 = paramInt2;
              if (((File)localObject2).exists())
              {
                paramInt2 = (int)((System.currentTimeMillis() - ((File)localObject2).lastModified()) / 60000L);
                paramInt1 = paramInt2;
                if (paramInt2 == 0) {
                  paramInt1 = 1;
                }
              }
            }
            int i1;
            if (paramString.toLowerCase(Locale.US).contains("gif"))
            {
              i1 = 0;
              paramInt2 = i1;
              int i4 = i7;
              int i5 = i6;
              if (paramString.contains(AppConstants.br))
              {
                paramString = paramString.split("#");
                paramInt2 = i1;
                i4 = i7;
                i5 = i6;
                if (paramString.length >= 4)
                {
                  i5 = Integer.parseInt(paramString[1]);
                  i4 = Integer.parseInt(paramString[2]);
                  if (Integer.parseInt(paramString[3]) != 3) {
                    continue;
                  }
                  paramInt2 = 0;
                }
              }
              i1 = PhotoUtils.a(i5, i4);
              i6 = NetworkUtil.a(BaseApplication.getContext());
              if (QLog.isDevelopLevel()) {
                QLog.d("StatisticConstants", 4, "sendPhotoSourceDetailUrlStatistic url=" + (String)localObject1 + ",uinType = " + i2 + ",batchCnt = " + paramInt7 + ",sizeType = " + i1 + ",isRAW = " + paramBoolean1 + ",isForward = " + paramBoolean2 + ",age = " + paramInt3 + ",gender = " + paramInt4 + ",reprotHour = " + i8 + ",width = " + i5 + ",height = " + i4 + ",interval = " + paramInt1 + ",suffixType = " + paramInt2 + ",nettype = " + i6 + ",forwardSourceUinType = " + i3 + ",urlType = " + paramInt6 + ",userType = " + paramInt5 + ",fileName = " + ((File)localObject2).getName());
              }
              paramString = new HashMap();
              paramString.put("param_sourceDetailUrl", localObject1);
              paramString.put("param_uinType", i2 + "");
              paramString.put("param_forwardSourceUinType", i3 + "");
              paramString.put("param_picSizeType", i1 + "");
              paramString.put("param_isForward", paramBoolean2 + "");
              paramString.put("param_age", paramInt3 + "");
              paramString.put("param_gender", paramInt4 + "");
              paramString.put("param_userType", paramInt5 + "");
              paramString.put("param_picReportHour", i8 + "");
              paramString.put("param_picInterval", paramInt1 + "");
              paramString.put("param_isRAWPic", paramBoolean1 + "");
              paramString.put("param_fileName", ((File)localObject2).getName());
              paramString.put("param_picSuffixType", paramInt2 + "");
              paramString.put("param_netType", i6 + "");
              paramString.put("param_urlType", paramInt6 + "");
              paramString.put("param_picBatchCount", paramInt7 + "");
              StatisticCollector.a(BaseApplication.getContext()).a(null, "actPhotoSourceDetailUrl", false, 0L, 0L, paramString, "", false);
              return;
              localOutOfMemoryError = localOutOfMemoryError;
              QLog.e("StatisticConstants", 4, "sendPhotoSourceDetailUrlStatistic OutOfMemoryError ");
            }
            else
            {
              i1 = 1;
              continue;
            }
            paramInt2 = 1;
          }
          else
          {
            localObject1 = paramString;
          }
        }
        catch (Exception paramString)
        {
          return;
        }
      }
    }
  }
  
  public static void a(boolean paramBoolean, long paramLong1, long paramLong2, long paramLong3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_compressSuccess", paramBoolean + "");
    localHashMap.put("param_compressTime", paramLong1 + "");
    localHashMap.put("param_file_source_size", paramLong2 + "");
    localHashMap.put("param_file_target_sze", paramLong3 + "");
    StatisticCollector.a(BaseApplication.getContext()).a(null, "actVideoCompressTime", false, 0L, 0L, localHashMap, "", false);
    if (QLog.isColorLevel()) {
      QLog.d("StatisticConstants", 2, "reportVideoCompressTime, success =" + paramBoolean + ", compressTime = " + paramLong1 + ", fileSourceSize =" + paramLong2 + ", fileTargetSize = " + paramLong3);
    }
  }
  
  public static void a(String[] paramArrayOfString, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, QQAppInterface paramQQAppInterface)
  {
    if (paramArrayOfString == null) {}
    do
    {
      return;
      paramQQAppInterface = (NearbyCardManager)paramQQAppInterface.getManager(105);
      int i20 = paramArrayOfString.length;
      int i15 = -1;
      int i16 = -1;
      if (paramQQAppInterface != null)
      {
        i15 = paramQQAppInterface.a();
        i16 = paramQQAppInterface.b();
      }
      if (DeviceProfileManager.a().a(DeviceProfileManager.AccountDpcManager.DpcAccountNames.picpredownload_whitelist.name())) {}
      int i1;
      int i2;
      int i6;
      int i4;
      int i5;
      int i14;
      int i7;
      int i8;
      int i9;
      int i10;
      int i11;
      int i12;
      int i13;
      String str2;
      for (int i17 = 1002;; i17 = 1001)
      {
        i1 = 0;
        i2 = 0;
        i6 = 0;
        i4 = 0;
        i5 = 0;
        i14 = 0;
        i7 = 0;
        i8 = 0;
        i9 = 0;
        i10 = 0;
        i11 = 0;
        i12 = 0;
        i13 = 0;
        int i21 = paramArrayOfString.length;
        int i18 = 0;
        for (;;)
        {
          if (i18 >= i21) {
            break label929;
          }
          str2 = paramArrayOfString[i18];
          if (str2 != null) {
            break;
          }
          i18 += 1;
        }
      }
      String str1 = str2.toLowerCase(Locale.US);
      String str3 = FileUtil.b(str1);
      paramQQAppInterface = null;
      try
      {
        str1 = new File(str1).getParentFile().getName();
        paramQQAppInterface = str1;
      }
      catch (Exception localException)
      {
        int i3;
        int i19;
        for (;;) {}
      }
    } while ((str3 == null) || (paramQQAppInterface == null));
    if (str3.contains("/tencent/")) {
      if (str3.contains("/qq_collection/"))
      {
        i14 += 1;
        i3 = i2;
        i19 = 1001;
        i2 = i1;
        i1 = i3;
        i3 = i19;
      }
    }
    for (;;)
    {
      a(str2, paramInt1, paramBoolean1, paramBoolean2, paramInt2, i15, i16, i17, i3, i20);
      i3 = i2;
      i2 = i1;
      i1 = i3;
      break;
      if ((paramQQAppInterface.equals("qq_images")) || (str3.contains("/mobileqq/photo")) || (str3.contains("/mobileqq/diskcache")) || (str3.contains("/AIO_FORWARD/")))
      {
        i7 += 1;
        i19 = i1;
        i3 = 1002;
        i1 = i2;
        i2 = i19;
      }
      else if (paramQQAppInterface.equals("qqfile_recv"))
      {
        i8 += 1;
        i19 = i1;
        i3 = 1003;
        i1 = i2;
        i2 = i19;
      }
      else if (paramQQAppInterface.equals("qq_favorite"))
      {
        i10 += 1;
        i19 = i1;
        i3 = 1004;
        i1 = i2;
        i2 = i19;
      }
      else if (str3.contains("/zebra/cache"))
      {
        i9 += 1;
        i19 = i1;
        i3 = 1005;
        i1 = i2;
        i2 = i19;
      }
      else if ((paramQQAppInterface.equals("weixin")) || (paramQQAppInterface.equals("wechat")) || (paramQQAppInterface.equals("micromsg")))
      {
        i11 += 1;
        i19 = i1;
        i3 = 1006;
        i1 = i2;
        i2 = i19;
      }
      else if (str3.contains("/qqinput/exp/"))
      {
        i13 += 1;
        i19 = i1;
        i3 = 1013;
        i1 = i2;
        i2 = i19;
      }
      else if (a(str3))
      {
        i4 += 1;
        i19 = i1;
        i3 = 1007;
        i1 = i2;
        i2 = i19;
      }
      else
      {
        i5 += 1;
        i19 = i1;
        i3 = 1008;
        i1 = i2;
        i2 = i19;
        continue;
        if (paramQQAppInterface.equals("qq_screenshot"))
        {
          i19 = i2 + 1;
          i2 = i1;
          i3 = 1009;
          i1 = i19;
        }
        else if ((str3.contains("screenshot")) || (str3.contains("截屏")) || (str3.contains("截图")) || (str3.equals("screen_cap")) || (str3.equals("ScreenCapture")))
        {
          i6 += 1;
          i19 = i1;
          i3 = 1010;
          i1 = i2;
          i2 = i19;
        }
        else if ((paramQQAppInterface.contains("camera")) || (paramQQAppInterface.equals("dcim")) || (paramQQAppInterface.equals("100MEDIA")) || (paramQQAppInterface.equals("100ANDRO")) || (paramQQAppInterface.contains("相机")) || (paramQQAppInterface.contains("照片")) || (paramQQAppInterface.contains("相片")))
        {
          i3 = 1011;
          i19 = i1 + 1;
          i1 = i2;
          i2 = i19;
        }
        else if (str3.contains("/sogou/.expression/"))
        {
          i12 += 1;
          i19 = i1;
          i3 = 1012;
          i1 = i2;
          i2 = i19;
        }
        else if (a(str3))
        {
          i4 += 1;
          i19 = i1;
          i3 = 1007;
          i1 = i2;
          i2 = i19;
        }
        else
        {
          i5 += 1;
          i19 = i1;
          i3 = 1008;
          i1 = i2;
          i2 = i19;
        }
      }
    }
    label929:
    a(i1, i2, i6, i4, i5, i14, i7, i8, i9, i10, i11, i12, i13, i15, i16, i17);
  }
  
  public static boolean a(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return false;
      String[] arrayOfString = new String[14];
      arrayOfString[0] = "/weibo";
      arrayOfString[1] = "/sina/news/save/";
      arrayOfString[2] = "/faceq/";
      arrayOfString[3] = "/newsreader/";
      arrayOfString[4] = "/tieba";
      arrayOfString[5] = "/baidu";
      arrayOfString[6] = "/UCDownloads";
      arrayOfString[7] = "/taobao";
      arrayOfString[8] = "/news_article/";
      arrayOfString[9] = "/sohunewsdown/";
      arrayOfString[10] = "/pitu/";
      arrayOfString[11] = "/pins/";
      arrayOfString[12] = "/tumblr/";
      arrayOfString[13] = "/download";
      int i1 = 0;
      while (i1 < arrayOfString.length)
      {
        if (paramString.contains(arrayOfString[i1])) {
          return true;
        }
        i1 += 1;
      }
    }
  }
  
  public static void b()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("StatisticConstants", 4, "sendNomalCameraPreviewStatistic ");
    }
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
    long l1 = localSharedPreferences.getLong("PhotoConst.last_send_camera_preview_rate", 0L);
    long l2 = System.currentTimeMillis();
    int i1 = localSharedPreferences.getInt("PhotoConst.camerapreviewactivity_send_times", 0) + 1;
    if (l2 - l1 > 86400000L)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_sendCount", i1 + "");
      int i2 = localSharedPreferences.getInt("PhotoConst.camerapreviewactivity_enter_times", 0);
      localHashMap.put("param_cameraCount", i2 + "");
      if (i2 > 0) {
        localHashMap.put("param_sendPercent", i1 / i2 + "");
      }
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actPSdayCameraSend", false, 0L, 0L, localHashMap, "", false);
      localSharedPreferences.edit().putLong("PhotoConst.last_send_camera_preview_rate", l2).putInt("PhotoConst.camerapreviewactivity_send_times", 0).putInt("PhotoConst.camerapreviewactivity_enter_times", 0).commit();
      return;
    }
    localSharedPreferences.edit().putInt("PhotoConst.camerapreviewactivity_send_times", i1).commit();
  }
  
  public static void b(long paramLong)
  {
    if (paramLong <= 0L) {
      if (QLog.isColorLevel()) {
        QLog.d("StatisticConstants", 2, "reportActPSprogressTime,size <= 0,return! duration = " + paramLong);
      }
    }
    do
    {
      return;
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_consumTime", paramLong + "");
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actPSprogressTime", false, 0L, 0L, localHashMap, "", false);
    } while (!QLog.isColorLevel());
    QLog.d("StatisticConstants", 2, "reportActPSprogressTime,WastedSize =" + paramLong);
  }
  
  public static void b(Intent paramIntent, int paramInt)
  {
    if (!paramIntent.hasExtra("param_initTime")) {}
    long l1;
    do
    {
      do
      {
        do
        {
          return;
          l1 = paramIntent.getLongExtra("param_initTime", 0L);
          if (l1 != 0L) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("StatisticConstants", 2, "reportActPScancelSend,initTime == 0,return!");
        return;
        l1 = System.currentTimeMillis() - l1;
      } while (l1 > 86400000L);
      HashMap localHashMap = new HashMap();
      int i1 = NetworkUtil.a(BaseApplication.getContext());
      localHashMap.put("param_netType", i1 + "");
      localHashMap.put("param_selNum", paramInt + "");
      localHashMap.put("param_residentTime", l1 + "");
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actPScancelSend", false, 0L, 0L, localHashMap, "", false);
      paramIntent.removeExtra("param_initTime");
      paramIntent.removeExtra("param_cancelSelNum");
      paramIntent.removeExtra("param_totalSelNum");
    } while (!QLog.isColorLevel());
    QLog.d("StatisticConstants", 2, "reportActPScancelSend,param_residentTime =" + l1 + ",param_selNum = " + paramInt);
  }
  
  public static void c()
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
    int i1 = localSharedPreferences.getInt("PhotoConst.camerapreviewactivity_enter_times_fast", 0);
    localSharedPreferences.edit().putInt("PhotoConst.camerapreviewactivity_enter_times_fast", i1 + 1).commit();
  }
  
  public static void d()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("StatisticConstants", 4, "sendFastImageCameraPreviewStatistic ");
    }
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
    long l1 = localSharedPreferences.getLong("PhotoConst.last_send_camera_preview_rate_fast", 0L);
    long l2 = System.currentTimeMillis();
    int i1 = localSharedPreferences.getInt("PhotoConst.camerapreviewactivity_send_times_fast", 0) + 1;
    if (l2 - l1 > 86400000L)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_sendCount", i1 + "");
      int i2 = localSharedPreferences.getInt("PhotoConst.camerapreviewactivity_enter_times_fast", 0);
      localHashMap.put("param_browseCount", i2 + "");
      if (i2 > 0) {
        localHashMap.put("param_sendPercent", i1 / i2 + "");
      }
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actPSdayQuickSend", false, 0L, 0L, localHashMap, "", false);
      localSharedPreferences.edit().putLong("PhotoConst.last_send_camera_preview_rate_fast", l2).putInt("PhotoConst.camerapreviewactivity_send_times_fast", 0).putInt("PhotoConst.camerapreviewactivity_enter_times_fast", 0).commit();
      return;
    }
    localSharedPreferences.edit().putInt("PhotoConst.camerapreviewactivity_send_times_fast", i1).commit();
  }
  
  public static void e()
  {
    HashMap localHashMap = new HashMap();
    if (DeviceProfileManager.a().a(DeviceProfileManager.AccountDpcManager.DpcAccountNames.picpredownload_whitelist.name())) {}
    for (int i1 = 1002;; i1 = 1001)
    {
      int i2 = NetworkUtil.a(BaseApplication.getContext());
      int i3 = a();
      localHashMap.put("param_netType", i2 + "");
      localHashMap.put("param_phone_type", i3 + "");
      localHashMap.put("param_userType", i1 + "");
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actPSCompressTimeOut", false, 0L, 0L, localHashMap, "", false);
      if (QLog.isColorLevel()) {
        QLog.d("StatisticConstants", 2, "reportPresendCompressTimeOut");
      }
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\photo\StatisticConstants.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */