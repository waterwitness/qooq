package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.etrump.mixlayout.FontManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.servlet.GameCenterManagerImp;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.AvatarPendantMarketActivity;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import wac;
import wad;

public final class AvatarPendantUtil
{
  public static final int a = 1;
  private static long a = 0L;
  public static String a;
  public static Vector a;
  public static ConcurrentHashMap a;
  public static final int b = 2;
  private static final long b = 604800000L;
  public static final String b;
  public static final int c = 3;
  public static String c;
  public static final int d = 4;
  public static final String d = "sp_key_entrance_card";
  public static final int e = 5;
  public static final String e = "sp_key_entrance_card_face_preview";
  public static final int f = 6;
  private static final String f = "AvatarPendantUtil";
  public static final int g = 7;
  private static final String g = "sp_pendant_market_open_time_%s";
  public static final int h = 8;
  public static final int i = 1;
  public static final int j = 0;
  private static final int k = 5000;
  private static final int l = 5;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    jdField_a_of_type_JavaLangString = "http://i.gtimg.cn/qqshow/admindata/comdata/AndroidIconZip/icon.zip";
    b = AppConstants.bj + "avatarPendantIcons";
    c = b + "/icon";
    jdField_a_of_type_JavaUtilVector = new Vector();
    jdField_a_of_type_Long = -1L;
  }
  
  public static String a(long paramLong, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.bY).append(paramLong).append(File.separator);
    switch (paramInt)
    {
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append("aio_static_50.png");
      continue;
      localStringBuilder.append("aio_file.zip");
      continue;
      localStringBuilder.append("aio_file");
      continue;
      localStringBuilder.append("market_static_50.png");
      continue;
      localStringBuilder.append("market_dynamic_50.gif");
      continue;
      localStringBuilder.append("thumbnail_50.png");
      continue;
      localStringBuilder.append("config.json");
      continue;
      localStringBuilder.append("crop_portrait.png");
    }
  }
  
  public static String a(File paramFile)
  {
    String str2 = "";
    String str1 = str2;
    if (paramFile != null)
    {
      str1 = str2;
      if (!paramFile.exists()) {}
    }
    try
    {
      paramFile = new String(FileUtils.a(paramFile));
      int m = paramFile.indexOf("\"seriesID\":");
      str1 = str2;
      if (m != -1)
      {
        int n = paramFile.indexOf(",", m + 10);
        str1 = str2;
        if (n != -1) {
          str1 = paramFile.substring(m + 11, n);
        }
      }
      return str1;
    }
    catch (Exception paramFile) {}
    return "";
  }
  
  public static void a()
  {
    File localFile = new File(AppConstants.bj + "avatarPendantDefaultHead");
    if (!localFile.exists()) {
      localFile.mkdir();
    }
    localFile = new File(AppConstants.bY);
    if (!localFile.exists()) {
      localFile.mkdir();
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, long paramLong)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      if (QLog.isColorLevel()) {
        QLog.d("AvatarPendantUtil", 2, "saveMarketOpenTime, entrance=" + paramString1 + ", uin=" + paramString2 + ", context=" + paramContext);
      }
    }
    do
    {
      return;
      paramContext = paramContext.getSharedPreferences(String.format("sp_pendant_market_open_time_%s", new Object[] { paramString2 }), 0);
    } while (paramContext == null);
    paramContext.edit().putLong(paramString1, paramLong).commit();
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    boolean bool3 = true;
    if ((paramQQAppInterface == null) || (jdField_a_of_type_JavaUtilVector == null) || (jdField_a_of_type_JavaUtilVector.size() == 0)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("AvatarPendantUtil", 2, "bulkGetStrangerPendantId, size=" + jdField_a_of_type_JavaUtilVector.size());
    }
    boolean bool1;
    if (jdField_a_of_type_JavaUtilVector.size() >= 5)
    {
      bool1 = true;
      label70:
      bool2 = bool3;
      if (jdField_a_of_type_Long != -1L) {
        if (System.currentTimeMillis() - jdField_a_of_type_Long < 5000L) {
          break label166;
        }
      }
    }
    label166:
    for (boolean bool2 = bool3;; bool2 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AvatarPendantUtil", 2, "bulkGetStrangerPendantId, thresholdReached=" + bool1 + ", intervalReached=" + bool2);
      }
      if ((bool1) || (bool2)) {
        break label171;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AvatarPendantUtil", 2, "bulkGetStrangerPendantId, condition unavailable, abort");
      return;
      bool1 = false;
      break label70;
    }
    label171:
    ThreadManager.a(new wac(paramQQAppInterface), 8, null, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    a(paramQQAppInterface, paramContext, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, PreloadProcHitSession paramPreloadProcHitSession)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      if (QLog.isColorLevel()) {
        QLog.d("AvatarPendantUtil", 2, "preloadWebProcess, entrance=" + paramString1 + ", uin=" + paramString2 + ", context=" + paramContext + ", app=" + paramQQAppInterface);
      }
    }
    do
    {
      long l1;
      do
      {
        do
        {
          return;
        } while (paramQQAppInterface == null);
        paramQQAppInterface = (WebProcessManager)paramQQAppInterface.getManager(12);
        if (paramQQAppInterface == null) {
          break;
        }
        l1 = paramContext.getSharedPreferences(String.format("sp_pendant_market_open_time_%s", new Object[] { paramString2 }), 0).getLong(paramString1, 0L);
      } while (System.currentTimeMillis() - l1 >= 604800000L);
      if (QLog.isColorLevel()) {
        QLog.d("AvatarPendantUtil", 2, "preloadWebProcess, startWebProcess");
      }
      paramQQAppInterface.a(-1, new wad(paramPreloadProcHitSession));
      return;
    } while (!QLog.isColorLevel());
    QLog.d("AvatarPendantUtil", 2, "preloadWebProcess, web process alive aready");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    Intent localIntent = new Intent(paramContext, AvatarPendantMarketActivity.class);
    GameCenterManagerImp localGameCenterManagerImp = (GameCenterManagerImp)paramQQAppInterface.getManager(11);
    int m = localGameCenterManagerImp.a("100005.100006");
    RedTouchManager localRedTouchManager;
    int n;
    int i1;
    label126:
    int i2;
    label141:
    int i3;
    label156:
    int i4;
    label171:
    int i5;
    if ((m == 1) || (m == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AvatarPendantUtil", 2, "Clear pendant red flag");
      }
      localIntent.putExtra("key_update_flag", true);
      localRedTouchManager = (RedTouchManager)paramQQAppInterface.getManager(35);
      localRedTouchManager.b("100005.100006");
      if (localGameCenterManagerImp.a("100005.100003") == -1) {
        break label400;
      }
      n = 1;
      if (localGameCenterManagerImp.a("100005.100002") == -1) {
        break label406;
      }
      i1 = 1;
      if (localGameCenterManagerImp.a("100005.100001") == -1) {
        break label412;
      }
      i2 = 1;
      if (localGameCenterManagerImp.a("100005.100018") == -1) {
        break label418;
      }
      i3 = 1;
      if (localGameCenterManagerImp.a("100005.100020") == -1) {
        break label424;
      }
      i4 = 1;
      if (localGameCenterManagerImp.a("100005.100021") == -1) {
        break label430;
      }
      i5 = 1;
      label186:
      if (!((FontManager)paramQQAppInterface.getManager(41)).a) {
        break label450;
      }
      if (localGameCenterManagerImp.a("100005.100011") == -1) {
        break label436;
      }
      m = 1;
    }
    for (;;)
    {
      label216:
      if ((n == 0) && (i1 == 0) && (i2 == 0) && (i3 == 0) && (m == 0) && (i4 == 0) && (i5 == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AvatarPendantUtil", 2, "Clear parent red flag");
        }
        localRedTouchManager.b("100005");
      }
      localIntent.putExtra("hide_left_button", false);
      localIntent.putExtra("show_right_close_button", false);
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      localIntent.putExtra("url", IndividuationUrlHelper.a(paramContext, "pendant", ""));
      localIntent.putExtra("business", 512L);
      if (paramBoolean) {}
      for (m = 40202;; m = 40201)
      {
        localIntent.putExtra("individuation_url_type", m);
        VasWebviewUtil.insertVasWbPluginToIntent(512L, localIntent);
        localIntent.putExtra("isShowAd", false);
        paramContext.startActivity(localIntent);
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "PendantMarket", "OtherEntrance", 0, 0, "", "", "", "");
        return;
        label400:
        n = 0;
        break;
        label406:
        i1 = 0;
        break label126;
        label412:
        i2 = 0;
        break label141;
        label418:
        i3 = 0;
        break label156;
        label424:
        i4 = 0;
        break label171;
        label430:
        i5 = 0;
        break label186;
        label436:
        m = 0;
        break label216;
      }
      label450:
      m = 0;
    }
  }
  
  public static void a(String paramString)
  {
    if (paramString == null) {}
    while (jdField_a_of_type_JavaUtilVector.contains(paramString)) {
      return;
    }
    jdField_a_of_type_JavaUtilVector.add(paramString);
  }
  
  public static boolean a(long paramLong)
  {
    Integer localInteger = (Integer)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
    if (localInteger == null) {
      return true;
    }
    if (localInteger.intValue() == 1) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static String b(long paramLong, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("http://i.gtimg.cn/qqshow/admindata/comdata/vipFaceAddon_").append(paramLong).append(File.separator);
    switch (paramInt)
    {
    }
    for (;;)
    {
      return EmosmUtils.a("VIP_avatar", localStringBuilder.toString());
      localStringBuilder.append("aio_50.png");
      continue;
      localStringBuilder.append("aio_file.zip");
      continue;
      localStringBuilder.append("list_50.png");
      continue;
      localStringBuilder.append("preview_50.gif");
      continue;
      localStringBuilder.append("thumb_nail_50.png");
      continue;
      localStringBuilder.append("xydata.js");
      continue;
      localStringBuilder.append("avatarfit.png");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\utils\AvatarPendantUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */