package com.tencent.mobileqq.vas;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import wec;

public class ClubContentJsonTask
{
  private static final byte jdField_a_of_type_Byte = 0;
  public static final int a = 1;
  public static ClubContentJsonTask.PersonalCardUrlInfo a;
  public static ClubContentJsonTask.TaskInfo a;
  static DownloadListener jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new wec();
  public static final String a = "ClubContentJsonTask";
  public static HashMap a;
  public static ClubContentJsonTask.TaskInfo[] a;
  private static final byte b = 2;
  public static final int b = 2;
  public static ClubContentJsonTask.TaskInfo b;
  public static final String b = "clubContentVersion";
  public static final int c = 3;
  public static ClubContentJsonTask.TaskInfo c;
  public static final String c = "";
  private static final int d = 5;
  public static ClubContentJsonTask.TaskInfo d;
  public static final String d = "clubContentPendantMarketJsonUpdate";
  public static ClubContentJsonTask.TaskInfo e;
  public static String e;
  public static ClubContentJsonTask.TaskInfo f;
  public static final String f = "individuation_predownload_resource_config";
  public static ClubContentJsonTask.TaskInfo g;
  public static final String g = "pendant_id_list";
  public static ClubContentJsonTask.TaskInfo h;
  private static final String h = "checked";
  public static ClubContentJsonTask.TaskInfo i;
  private static final String i = "counter";
  public static ClubContentJsonTask.TaskInfo j;
  public static ClubContentJsonTask.TaskInfo k;
  public static ClubContentJsonTask.TaskInfo l;
  public static ClubContentJsonTask.TaskInfo m;
  public static ClubContentJsonTask.TaskInfo n;
  public static ClubContentJsonTask.TaskInfo o;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ComTencentMobileqqVasClubContentJsonTask$TaskInfo = new ClubContentJsonTask.TaskInfo("recommendEmotion.json", "http://i.gtimg.cn/qqshow/admindata/comdata/vipData_emoji_aioPanal/", "http://i.gtimg.cn/qqshow/admindata/comdata/vipData_emoji_aioPanal/xydata.json", "recommendEmotionVersion", "vipData_emoji_aio_recommend.json");
    b = new ClubContentJsonTask.TaskInfo("IndividuationUrls.json", "", "http://i.gtimg.cn/qqshow/admindata/comdata/vipData_individuation_url/android.json", "individuationUrlJsonNewVersion", "vipData_individuation_url_json");
    c = new ClubContentJsonTask.TaskInfo("personalCard.json", "", "http://i.gtimg.cn/qqshow/admindata/comdata/vip_personal_card/config.json", "personalCardVersion", "personal_card_json");
    d = new ClubContentJsonTask.TaskInfo("Individuation.json", "http://i.gtimg.cn/qqshow/admindata/comdata/vipData_individuation/", "http://i.gtimg.cn/qqshow/admindata/comdata/vipData_individuation/xydata.json", "IndividuationVersion", "individ_json");
    jdField_e_of_type_ComTencentMobileqqVasClubContentJsonTask$TaskInfo = new ClubContentJsonTask.TaskInfo("EmoticonWording.json", "", "http://i.gtimg.cn/club/item/parcel/client_wording.json", "EmoticonWordingVersion", "wording_json");
    f = new ClubContentJsonTask.TaskInfo("keyword.json", "", IndividuationUrlHelper.a("emoticonKeyword"), "EmoticonKeywordVersion", "keyword.json");
    g = new ClubContentJsonTask.TaskInfo("themeActivity.json", "", "http://i.gtimg.cn/qqshow/admindata/comdata/viptheme_act_autoswitch/xydata.json", "ThemeActivityVersion", "theme_autoswitch_json");
    h = new ClubContentJsonTask.TaskInfo("themeDIYDataList.json", "", "http://i.gtimg.cn/qqshow/admindata/comdata/vipList_diytheme_data/diythemeData.json", "themeDIYDataListVersion", "diytheme_data_json");
    i = new ClubContentJsonTask.TaskInfo("WebviewCrashReport.json", "", "http://i.gtimg.cn/qqshow/admindata/comdata/vip_crash_report/WebviewCrashReport.json", "WebviewCrashJSONVersion", "WebviewCrashReport.json");
    j = new ClubContentJsonTask.TaskInfo("Qutu_xydata.json", "", "http://i.gtimg.cn/qqshow/admindata/comdata/vipQutu_release_zip/xydata.json", "QutuXYDataJsonVersion", "xydata.json");
    k = new ClubContentJsonTask.TaskInfo("iRedPacket_v2.json", "http://i.gtimg.cn/qqshow/admindata/comdata/vipRedPacketDataV2/", "http://i.gtimg.cn/qqshow/admindata/comdata/vipRedPacketDataV2/xydata.mobile.v1.json", "vipRedPacketData_json_v2", "vipRedPacketData_json_v2");
    l = new ClubContentJsonTask.TaskInfo("UrlIntercept.json", "http://i.gtimg.cn/qqshow/admindata/comdata/vipData_url_to_api", "http://i.gtimg.cn/qqshow/admindata/comdata/vipData_url_to_api/android.json", "UrlIntercept_json", "UrlIntercept_json");
    m = new ClubContentJsonTask.TaskInfo("pendant_market.json", "", "http://i.gtimg.cn/qqshow/admindata/comdata/vipList_faceAddon_data/xydata.android.v1.json", "pendantMarketVersion", "pendant_market_json");
    n = new ClubContentJsonTask.TaskInfo("font_info.json", "http://i.gtimg.cn/qqshow/admindata/comdata/vipList_font_data", "http://i.gtimg.cn/qqshow/admindata/comdata/vipList_font_data/version.json", "FontInfoList_json", "FontInfoList_json");
    o = new ClubContentJsonTask.TaskInfo("changeVoice.json", "", "http://i.gtimg.cn/xydata/changeVoice/app/List/xydata.json", "changeVoice.json", "changeVoice.json");
    jdField_a_of_type_ArrayOfComTencentMobileqqVasClubContentJsonTask$TaskInfo = new ClubContentJsonTask.TaskInfo[] { jdField_a_of_type_ComTencentMobileqqVasClubContentJsonTask$TaskInfo, d, jdField_e_of_type_ComTencentMobileqqVasClubContentJsonTask$TaskInfo };
    jdField_e_of_type_JavaLangString = "http://i.gtimg.cn/xydata";
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static int a()
  {
    Object localObject = new File(ApolloUtil.c);
    if ((((File)localObject).exists()) && (((File)localObject).isFile()))
    {
      localObject = FileUtils.a((File)localObject);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        try
        {
          long l1 = new JSONObject((String)localObject).optLong("timeStamp") / 1000L;
          return (int)l1;
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.e("ClubContentJsonTask", 2, "getApolloPanelJsonVer fail", localException);
          }
        }
      }
    }
    return 0;
  }
  
  public static int a(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("clubContentVersion", 0);
    if (QLog.isColorLevel()) {
      QLog.d("ClubContentJsonTask", 2, "--getJsonVersion ,key=" + paramString + ",version:" + paramContext.getInt(paramString, 0));
    }
    return paramContext.getInt(paramString, 0);
  }
  
  public static JSONArray a(QQAppInterface paramQQAppInterface)
  {
    b(paramQQAppInterface, jdField_e_of_type_ComTencentMobileqqVasClubContentJsonTask$TaskInfo);
    paramQQAppInterface = FileUtils.a(new File(paramQQAppInterface.getApplication().getApplicationContext().getFilesDir(), jdField_e_of_type_ComTencentMobileqqVasClubContentJsonTask$TaskInfo.jdField_b_of_type_JavaLangString));
    if (paramQQAppInterface != null) {
      try
      {
        paramQQAppInterface = new JSONObject(paramQQAppInterface).getJSONArray("wording");
        return paramQQAppInterface;
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ClubContentJsonTask", 2, paramQQAppInterface.getMessage());
        }
      }
    }
    return null;
  }
  
  public static JSONObject a(QQAppInterface paramQQAppInterface, ClubContentJsonTask.TaskInfo paramTaskInfo, boolean paramBoolean)
  {
    Object localObject = paramQQAppInterface.getApplication().getApplicationContext();
    String str = paramTaskInfo.jdField_b_of_type_JavaLangString;
    localObject = new File(((Context)localObject).getFilesDir(), str);
    if (((File)localObject).exists()) {
      try
      {
        paramQQAppInterface = FileUtils.a((File)localObject);
        if (paramQQAppInterface == null) {}
      }
      catch (OutOfMemoryError paramQQAppInterface)
      {
        for (;;)
        {
          try
          {
            paramQQAppInterface = new JSONObject(paramQQAppInterface);
            return paramQQAppInterface;
          }
          catch (OutOfMemoryError paramQQAppInterface)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.e("ClubContentJsonTask", 2, "getJsonError,JSONObject_OOM:" + str + paramQQAppInterface.getMessage());
            ((File)localObject).delete();
            return null;
          }
          catch (JSONException paramQQAppInterface)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.e("ClubContentJsonTask", 2, "getJsonError,JSONException:" + str + paramQQAppInterface.getMessage());
            continue;
          }
          catch (NumberFormatException paramQQAppInterface)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.e("ClubContentJsonTask", 2, "getJsonError,NumberFormatException:" + str + paramQQAppInterface.getMessage());
            continue;
          }
          catch (ArrayIndexOutOfBoundsException paramQQAppInterface)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.e("ClubContentJsonTask", 2, "getJsonError,ArrayIndexOutOfBoundsException:" + str + paramQQAppInterface.getMessage());
            continue;
          }
          catch (ArrayStoreException paramQQAppInterface)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.e("ClubContentJsonTask", 2, "getJsonError,ArrayStoreException:" + str + paramQQAppInterface.getMessage());
            continue;
          }
          catch (Exception paramQQAppInterface)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.e("ClubContentJsonTask", 2, "getJsonError,Exception:" + str + paramQQAppInterface.getMessage());
            continue;
          }
          paramQQAppInterface = paramQQAppInterface;
          if (QLog.isColorLevel()) {
            QLog.e("ClubContentJsonTask", 2, "getJsonOOM,json_name:" + str + paramQQAppInterface.getMessage());
          }
          paramQQAppInterface = null;
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.w("ClubContentJsonTask", 2, "getJsonFromLocalFile not exist,json_name:" + str + " _ " + paramBoolean);
      }
      if (paramBoolean) {
        b(paramQQAppInterface, paramTaskInfo);
      }
    }
  }
  
  public static void a()
  {
    Object localObject2 = (QQAppInterface)BaseApplicationImpl.a.a();
    if (localObject2 == null) {
      if (QLog.isColorLevel()) {
        QLog.e("ClubContentJsonTask", 2, "checkPredownloadResource, app null, return");
      }
    }
    Object localObject3;
    do
    {
      do
      {
        do
        {
          return;
          localObject1 = ((QQAppInterface)localObject2).a().getSharedPreferences("individuation_predownload_resource_config", 0);
          if (!((SharedPreferences)localObject1).getBoolean("checked", false)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("ClubContentJsonTask", 2, "checkPredownloadResource, checked, abort");
        return;
        i1 = ((SharedPreferences)localObject1).getInt("counter", 0);
        if (i1 < 5) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ClubContentJsonTask", 2, "checkPredownloadResource, checkedCount achieve max try count, abort");
      return;
      localObject1 = ((SharedPreferences)localObject1).edit();
      localObject3 = new File(((QQAppInterface)localObject2).getApplication().getFilesDir(), d.jdField_b_of_type_JavaLangString);
    } while ((localObject3 == null) || (!((File)localObject3).exists()));
    ((SharedPreferences.Editor)localObject1).putInt("counter", i1 + 1);
    try
    {
      localObject3 = d.a(((QQAppInterface)localObject2).getApplication().getApplicationContext());
      if ((localObject3 == null) || (!((JSONObject)localObject3).has("data"))) {
        break label1037;
      }
      localObject3 = ((JSONObject)localObject3).getJSONObject("data");
      if ((localObject3 == null) || (!((JSONObject)localObject3).has("redPacketPrepare"))) {
        break label1135;
      }
      localObject3 = ((JSONObject)localObject3).getJSONArray("redPacketPrepare");
      if ((localObject3 == null) || (((JSONArray)localObject3).length() <= 0)) {
        break label1037;
      }
      localObject3 = ((JSONArray)localObject3).getJSONObject(0);
      if (localObject3 == null) {
        break label1037;
      }
      if (!((JSONObject)localObject3).has("weihao")) {
        break label1163;
      }
      localObject4 = ((JSONObject)localObject3).getJSONArray("weihao");
      if ((localObject4 == null) || (((JSONArray)localObject4).length() <= 0)) {
        break label1163;
      }
      localObject5 = ((QQAppInterface)localObject2).a();
      i1 = 0;
      i2 = ((JSONArray)localObject4).length();
      if (i1 >= i2) {
        break label1163;
      }
      if (!((String)localObject5).endsWith(String.valueOf(((JSONArray)localObject4).getInt(i1)))) {
        break label676;
      }
      bool2 = true;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        Object localObject4;
        Object localObject5;
        int i2;
        boolean bool2;
        boolean bool1;
        label676:
        label822:
        label1037:
        label1045:
        if (QLog.isColorLevel())
        {
          QLog.e("ClubContentJsonTask", 2, "jsonDownloadListener, onDone, exception=" + MsfSdkUtils.getStackTraceString(localException2));
          continue;
          if (!bool1)
          {
            ((SharedPreferences.Editor)localObject1).putBoolean("checked", true);
            if (QLog.isColorLevel())
            {
              QLog.d("ClubContentJsonTask", 2, "checkPredownloadResource, downloadSwitchOn false");
              continue;
              ((SharedPreferences.Editor)localObject1).putBoolean("checked", true);
              if (QLog.isColorLevel())
              {
                QLog.d("ClubContentJsonTask", 2, "checkPredownloadResource, no config for redPacketPrepare");
                continue;
                bool2 = false;
                continue;
                bool1 = bool2;
                if (i1 == 1) {
                  bool1 = true;
                }
              }
            }
          }
        }
      }
    }
    bool1 = false;
    if (((JSONObject)localObject3).has("switch"))
    {
      if (((JSONObject)localObject3).getInt("switch") == 1) {
        bool1 = true;
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("ClubContentJsonTask", 2, "checkPredownloadResource, uinMatchResult=" + bool2 + ", downloadSwitchOn=" + bool1);
      }
      if ((!bool2) || (!bool1)) {
        break label1102;
      }
    }
    for (;;)
    {
      try
      {
        i1 = NetworkUtil.a(((QQAppInterface)localObject2).getApplication());
        if (QLog.isColorLevel()) {
          QLog.d("ClubContentJsonTask", 2, "checkPredownloadResource, netType=" + i1);
        }
        if (i1 == 0) {
          break label1045;
        }
        localObject4 = ((JSONObject)localObject3).getString("network");
        bool2 = false;
        if ("2G".equals(localObject4))
        {
          bool1 = true;
          if (QLog.isColorLevel()) {
            QLog.d("ClubContentJsonTask", 2, "checkPredownloadResource, network=" + (String)localObject4 + ", shouldDownload=" + bool1);
          }
          if (!bool1) {
            break label1037;
          }
          ((SharedPreferences.Editor)localObject1).putBoolean("checked", true);
          if (!((JSONObject)localObject3).has("bubble")) {
            break label822;
          }
          localObject4 = ((JSONObject)localObject3).getString("bubble");
          if (QLog.isColorLevel()) {
            QLog.d("ClubContentJsonTask", 2, "checkPredownloadResource, bubbleIds=" + (String)localObject4);
          }
          if (TextUtils.isEmpty((CharSequence)localObject4)) {
            break label822;
          }
          localObject4 = ((String)localObject4).split(",");
          if ((localObject4 == null) || (localObject4.length <= 0)) {
            break label822;
          }
          ReportController.b(null, "P_CliOper", "redPacketPrepare", "", "0X8006293", "0X8006293", 0, 1, "bubble", "", "", "");
          localObject5 = (BubbleManager)((QQAppInterface)localObject2).getManager(43);
        }
        try
        {
          i2 = localObject4.length;
          i1 = 0;
          if (i1 >= i2) {
            break label822;
          }
          CharSequence localCharSequence2 = localObject4[i1];
          if (!TextUtils.isEmpty(localCharSequence2)) {
            ((BubbleManager)localObject5).c(Integer.parseInt(localCharSequence2), null);
          }
          i1 += 1;
          continue;
          i1 += 1;
        }
        catch (Exception localException4)
        {
          if (!QLog.isColorLevel()) {
            break label822;
          }
          QLog.e("ClubContentJsonTask", 2, "checkPredownloadResource, parse bubble id, exception=" + MsfSdkUtils.getStackTraceString(localException4));
        }
        bool1 = false;
      }
      catch (Exception localException3)
      {
        i1 = 0;
        continue;
        if ("3G".equals(localException3))
        {
          bool1 = bool2;
          if (i1 == 2) {
            continue;
          }
          bool1 = true;
          continue;
        }
        if ("4G".equals(localException3))
        {
          bool1 = bool2;
          if (i1 == 2) {
            continue;
          }
          bool1 = bool2;
          if (i1 == 3) {
            continue;
          }
          bool1 = true;
          continue;
        }
        if (!"wifi".equals(localException3)) {
          break label1169;
        }
      }
      bool1 = bool2;
      if (i1 == 1) {
        bool1 = true;
      }
    }
    if (((JSONObject)localObject3).has("faceAddon"))
    {
      localObject3 = ((JSONObject)localObject3).getString("faceAddon");
      if (QLog.isColorLevel()) {
        QLog.d("ClubContentJsonTask", 2, "checkPredownloadResource, pendantStr=" + (String)localObject3);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject3))
      {
        ((SharedPreferences.Editor)localObject1).putString("pendant_id_list", (String)localObject3);
        localObject3 = ((String)localObject3).split(",");
        if ((localObject3 != null) && (localObject3.length > 0))
        {
          ReportController.b(null, "P_CliOper", "redPacketPrepare", "", "0X8006293", "0X8006293", 0, 1, "faceAddon", "", "", "");
          localObject2 = (AvatarPendantManager)((QQAppInterface)localObject2).getManager(45);
          if (localObject2 != null) {
            try
            {
              i2 = localObject3.length;
              i1 = 0;
              while (i1 < i2)
              {
                CharSequence localCharSequence1 = localObject3[i1];
                if (!TextUtils.isEmpty(localCharSequence1)) {
                  ((AvatarPendantManager)localObject2).a(Long.parseLong(localCharSequence1)).a(null, 2, PendantInfo.p);
                }
                i1 += 1;
              }
              ((SharedPreferences.Editor)localObject1).commit();
            }
            catch (Exception localException1)
            {
              if (QLog.isColorLevel()) {
                QLog.e("ClubContentJsonTask", 2, "checkPredownloadResource, parse bubble id, exception=" + MsfSdkUtils.getStackTraceString(localException1));
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.e("ClubContentJsonTask", 2, "checkPredownloadResource, no network");
      }
    }
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ClubContentJsonTask", 2, "setJsonVersion ,key=" + paramString + ",version:" + paramInt);
    }
    paramContext.getSharedPreferences("clubContentVersion", 0).edit().putInt(paramString, paramInt).commit();
  }
  
  public static void a(AppInterface paramAppInterface, ClubContentJsonTask.TaskInfo paramTaskInfo, String paramString, File paramFile, Bundle paramBundle)
  {
    if (paramFile == null) {}
    String str1;
    do
    {
      return;
      str1 = paramString;
    } while ((paramString == null) && (paramTaskInfo == null));
    label453:
    label459:
    label462:
    for (;;)
    {
      try
      {
        str1 = paramTaskInfo.c;
        if (paramTaskInfo != null)
        {
          paramTaskInfo = paramTaskInfo.jdField_b_of_type_JavaLangString;
          paramString = paramBundle.getString("method");
          if (paramString != null) {
            break label462;
          }
          paramString = "other";
          String str2 = paramBundle.getString("ifromet");
          if (str2 != null) {
            break label459;
          }
          str2 = "false";
          if (!paramBundle.containsKey("forceUpdate")) {
            break label453;
          }
          bool = paramBundle.getBoolean("forceUpdate");
          int i1 = paramBundle.getInt("version", 0);
          String str3 = paramTaskInfo + "_" + i1;
          if (QLog.isColorLevel()) {
            QLog.d("ClubContentJsonTask", 2, "club_downloadFile,method:" + paramString + ",key:" + paramTaskInfo + ", server version:" + i1 + ",ifromet:" + str2);
          }
          if ((!bool) && (jdField_a_of_type_JavaUtilHashMap.containsKey(str3)) && (((Boolean)jdField_a_of_type_JavaUtilHashMap.get(str3)).booleanValue())) {
            break;
          }
          jdField_a_of_type_JavaUtilHashMap.put(str3, Boolean.valueOf(true));
          paramFile = new DownloadTask(str1, paramFile);
          paramFile.l = true;
          paramFile.jdField_a_of_type_JavaLangString = paramTaskInfo;
          if (o.jdField_b_of_type_JavaLangString.equals(paramTaskInfo)) {
            paramFile.b = true;
          }
          ((DownloaderFactory)paramAppInterface.getManager(46)).a(1).a(paramFile, jdField_a_of_type_ComTencentMobileqqVipDownloadListener, paramBundle);
          if (QLog.isColorLevel()) {
            QLog.d("ClubContentJsonTask", 2, paramString + ",cdownloadFile url=" + str1);
          }
          try
          {
            paramString = new HashMap();
            paramString.put("param_key", paramTaskInfo);
            paramString.put("param_ifromet", str2);
            StatisticCollector.a(paramAppInterface.getApplication().getApplicationContext()).a(paramAppInterface.getAccount(), "VipClubContentJsonTaskLoad", true, 1L, 0L, paramString, "", false);
          }
          catch (Exception paramAppInterface) {}
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("ClubContentJsonTask", 2, "downloadFile, downloadFile error=" + paramAppInterface.toString());
          break;
        }
      }
      finally {}
      paramTaskInfo = paramFile.getName();
      continue;
      boolean bool = false;
      continue;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface.getApplication().getApplicationContext();
    int i1 = 0;
    while (i1 < jdField_a_of_type_ArrayOfComTencentMobileqqVasClubContentJsonTask$TaskInfo.length)
    {
      b(paramQQAppInterface, jdField_a_of_type_ArrayOfComTencentMobileqqVasClubContentJsonTask$TaskInfo[i1]);
      i1 += 1;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ClubContentJsonTask.TaskInfo paramTaskInfo) {}
  
  public static void a(QQAppInterface paramQQAppInterface, ClubContentJsonTask.TaskInfo paramTaskInfo, int paramInt, boolean paramBoolean)
  {
    File localFile = new File(paramQQAppInterface.getApplication().getApplicationContext().getFilesDir(), paramTaskInfo.jdField_b_of_type_JavaLangString);
    Bundle localBundle = new Bundle();
    localBundle.putInt("version", paramInt);
    localBundle.putString("version_key", paramTaskInfo.jdField_e_of_type_JavaLangString);
    localBundle.putString("method", "updateJson");
    localBundle.putString("ifromet", String.valueOf(paramBoolean));
    a(paramQQAppInterface, paramTaskInfo, null, localFile, localBundle);
  }
  
  public static boolean a(JSONObject paramJSONObject, String paramString, boolean paramBoolean)
  {
    JSONArray localJSONArray;
    int i1;
    for (;;)
    {
      try
      {
        if ((paramJSONObject.has("AList")) && ((paramJSONObject.get("AList") instanceof JSONArray)))
        {
          localJSONArray = paramJSONObject.getJSONArray("AList");
          break label215;
          if (i1 >= localJSONArray.length()) {
            break;
          }
          if (!paramString.equals(localJSONArray.getString(i1))) {
            break label88;
          }
          return true;
        }
        localJSONArray = new JSONArray();
      }
      catch (Exception paramJSONObject)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ClubContentJsonTask", 2, paramJSONObject.getMessage());
        }
      }
      label86:
      return true;
      label88:
      i1 += 1;
    }
    if ((paramJSONObject.has("BList")) && ((paramJSONObject.get("BList") instanceof JSONArray))) {
      localJSONArray = paramJSONObject.getJSONArray("BList");
    }
    for (;;)
    {
      if (i1 < localJSONArray.length())
      {
        if (!paramString.equals(localJSONArray.getString(i1))) {
          break label227;
        }
        return false;
        localJSONArray = new JSONArray();
      }
      else
      {
        i1 = Integer.parseInt(paramJSONObject.getString("ARate"));
        int i2 = Integer.parseInt(paramString.substring(paramString.length() - 2));
        if (paramBoolean)
        {
          if (i2 < i1) {
            break label86;
          }
          return false;
        }
        if (i2 <= i1) {
          break label86;
        }
        return false;
        label215:
        i1 = 0;
        break;
      }
      i1 = 0;
      continue;
      label227:
      i1 += 1;
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface)
  {
    Object localObject = a(paramQQAppInterface, c, false);
    if (localObject == null) {
      return;
    }
    for (;;)
    {
      int i1;
      int i2;
      try
      {
        jdField_a_of_type_ComTencentMobileqqVasClubContentJsonTask$PersonalCardUrlInfo = new ClubContentJsonTask.PersonalCardUrlInfo();
        ClubContentJsonTask.PersonalCardUrlInfo localPersonalCardUrlInfo = jdField_a_of_type_ComTencentMobileqqVasClubContentJsonTask$PersonalCardUrlInfo;
        if (!((JSONObject)localObject).has("h5Pay")) {
          break label297;
        }
        i1 = ((JSONObject)localObject).getInt("h5Pay");
        localPersonalCardUrlInfo.jdField_a_of_type_Int = i1;
        localPersonalCardUrlInfo = jdField_a_of_type_ComTencentMobileqqVasClubContentJsonTask$PersonalCardUrlInfo;
        if (!((JSONObject)localObject).has("x5KernelVer")) {
          break label302;
        }
        i1 = ((JSONObject)localObject).getInt("x5KernelVer");
        localPersonalCardUrlInfo.jdField_b_of_type_Int = i1;
        i1 = ((JSONObject)localObject).optInt("frequency");
        if (i1 != 0) {
          VasUserData.a(paramQQAppInterface, "ticketInterval", Integer.toString(i1));
        }
        if (!((JSONObject)localObject).has("vipPersonalCard")) {
          break label307;
        }
        paramQQAppInterface = ((JSONObject)localObject).getJSONArray("vipPersonalCard");
        if ((paramQQAppInterface == null) || (paramQQAppInterface.length() <= 0)) {
          break;
        }
        i1 = 0;
        if (i1 >= paramQQAppInterface.length()) {
          break;
        }
        localObject = (JSONObject)paramQQAppInterface.get(i1);
        if (!((JSONObject)localObject).has("platformid")) {
          break label312;
        }
        i2 = ((JSONObject)localObject).getInt("platformid");
      }
      catch (JSONException paramQQAppInterface)
      {
        label172:
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ClubContentJsonTask", 2, "jsonexception");
        paramQQAppInterface.printStackTrace();
        return;
      }
      if (((JSONObject)localObject).has("masterUrl"))
      {
        paramQQAppInterface = ((JSONObject)localObject).getString("masterUrl");
        if (!((JSONObject)localObject).has("guestUrl")) {
          break label324;
        }
        localObject = ((JSONObject)localObject).getString("guestUrl");
        jdField_a_of_type_ComTencentMobileqqVasClubContentJsonTask$PersonalCardUrlInfo.jdField_a_of_type_JavaLangString = paramQQAppInterface;
        jdField_a_of_type_ComTencentMobileqqVasClubContentJsonTask$PersonalCardUrlInfo.jdField_b_of_type_JavaLangString = ((String)localObject);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ClubContentJsonTask", 2, "personalcardurlInfo : platformId = " + i2 + ";masterUrl = " + paramQQAppInterface + ";guestUrl = " + (String)localObject);
        return;
        label297:
        i1 = 0;
        continue;
        label302:
        i1 = 0;
        continue;
        label307:
        paramQQAppInterface = null;
        continue;
        label312:
        i2 = -1;
        break label337;
      }
      paramQQAppInterface = "";
      continue;
      label324:
      localObject = "";
      continue;
      label337:
      do
      {
        i1 += 1;
        break;
        if (i2 == 0) {
          break label172;
        }
      } while (i2 != 2);
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, ClubContentJsonTask.TaskInfo paramTaskInfo)
  {
    int i1 = 10;
    int i2 = 0;
    if ((paramQQAppInterface == null) || (paramTaskInfo == null)) {}
    do
    {
      return;
      File localFile = new File(paramQQAppInterface.getApplication().getApplicationContext().getFilesDir(), paramTaskInfo.jdField_b_of_type_JavaLangString);
      if (!localFile.exists())
      {
        if (QLog.isColorLevel()) {
          QLog.d("ClubContentJsonTask", 2, "downloadIfNotExist, not exist: " + paramTaskInfo.jdField_b_of_type_JavaLangString);
        }
        for (;;)
        {
          try
          {
            localObject = String.valueOf(NetConnInfoCenter.getServerTime());
            if (((String)localObject).length() <= 10) {
              continue;
            }
            localObject = ((String)localObject).substring(0, i1);
            i1 = i2;
            if (Long.parseLong((String)localObject) < 2147483647L) {
              i1 = Integer.parseInt((String)localObject);
            }
          }
          catch (Exception localException)
          {
            Object localObject;
            QLog.e("ClubContentJsonTask", 1, "downloadIfNotExist, Integer.parseInt Err:" + localException.getMessage());
            i1 = i2;
            continue;
          }
          localObject = new Bundle();
          ((Bundle)localObject).putInt("version", i1);
          ((Bundle)localObject).putString("version_key", paramTaskInfo.jdField_e_of_type_JavaLangString);
          ((Bundle)localObject).putString("method", "downloadIfNotExist");
          ((Bundle)localObject).putString("ifromet", "null1");
          a(paramQQAppInterface, paramTaskInfo, EmosmUtils.a("VIP_emosm", paramTaskInfo.c), localFile, (Bundle)localObject);
          return;
          i1 = ((String)localObject).length();
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("ClubContentJsonTask", 2, "downloadIfNotExist, exists.");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vas\ClubContentJsonTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */