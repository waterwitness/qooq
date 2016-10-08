package com.tencent.biz.pubaccount.readinjoy.common;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.util.PubAccountHttpDownloader;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import hxi;
import hxj;
import hxk;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class ReadInJoyUtils
{
  public static final int a = 1;
  private static Handler jdField_a_of_type_AndroidOsHandler;
  private static ReadInJoySSOHandlerThread jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoySSOHandlerThread;
  private static Object jdField_a_of_type_JavaLangObject;
  public static String a;
  public static SimpleDateFormat a;
  public static Comparator a;
  private static Map jdField_a_of_type_JavaUtilMap;
  private static volatile boolean jdField_a_of_type_Boolean = false;
  public static final int b = 2;
  private static Handler b;
  public static String b;
  public static final int c = 3;
  public static String c;
  public static final int d = 4;
  private static final String d = "ReadInJoyUtils";
  public static final int e = 5;
  private static final String e = "ReadInJoySSOHandlerThread";
  public static final int f = 6;
  private static final String f = "kandian_lastest_disallow_time";
  public static final int g = 7;
  private static final String g = "picWidth";
  public static final int h = 8;
  private static final String h = "picHeigth";
  public static final int i = 9;
  public static int j = 0;
  public static int k = 0;
  public static int l = 0;
  public static final int m = 1;
  public static final int n = 2;
  public static final int o = 3;
  public static final int p = 4;
  public static final int q = 5;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
    jdField_a_of_type_JavaLangString = "0";
    jdField_b_of_type_JavaLangString = "1";
    c = "2";
    j = 7;
    jdField_a_of_type_JavaUtilMap = new HashMap();
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_a_of_type_JavaUtilComparator = new hxk();
  }
  
  public static int a()
  {
    try
    {
      k += 1;
      int i1 = k;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static int a(BaseArticleInfo paramBaseArticleInfo)
  {
    int i1 = 3;
    if (paramBaseArticleInfo == null) {
      i1 = -2;
    }
    do
    {
      return i1;
      if (a(paramBaseArticleInfo))
      {
        if (paramBaseArticleInfo.mVideoType == 0) {
          return 5;
        }
        return 6;
      }
      if ((paramBaseArticleInfo.mPictures != null) && (paramBaseArticleInfo.mPictures.length >= 3)) {
        return 2;
      }
      if (paramBaseArticleInfo.mShowBigPicture)
      {
        if (paramBaseArticleInfo.mIsGallery == 0) {
          return 1;
        }
        return 8;
      }
      if (TextUtils.isEmpty(paramBaseArticleInfo.mFirstPagePicUrl)) {
        return 4;
      }
    } while (paramBaseArticleInfo.mIsGallery == 0);
    return 9;
  }
  
  public static long a()
  {
    AppRuntime localAppRuntime = null;
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.a();
    if (localBaseApplicationImpl != null) {
      localAppRuntime = localBaseApplicationImpl.a();
    }
    if (localAppRuntime == null) {
      return 0L;
    }
    return localAppRuntime.getLongAccountUin();
  }
  
  public static long a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = ReadInJoyHelper.a(paramQQAppInterface, 1);
    if (paramQQAppInterface == null) {
      return 0L;
    }
    return paramQQAppInterface.getLong("kandian_lastest_disallow_time", 0L);
  }
  
  public static Handler a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoySSOHandlerThread == null)
      {
        jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoySSOHandlerThread = new ReadInJoySSOHandlerThread("ReadInJoySSOHandlerThread");
        jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoySSOHandlerThread.start();
        jdField_a_of_type_AndroidOsHandler = new Handler(jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoySSOHandlerThread.getLooper());
      }
      Handler localHandler = jdField_a_of_type_AndroidOsHandler;
      return localHandler;
    }
    finally {}
  }
  
  public static MessageForStructing a(QQAppInterface paramQQAppInterface)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      MessageForStructing localMessageForStructing = (MessageForStructing)jdField_a_of_type_JavaUtilMap.get(paramQQAppInterface.a());
      jdField_a_of_type_JavaUtilMap.remove(paramQQAppInterface.a());
      return localMessageForStructing;
    }
  }
  
  public static String a()
  {
    AppRuntime localAppRuntime = null;
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.a();
    if (localBaseApplicationImpl != null) {
      localAppRuntime = localBaseApplicationImpl.a();
    }
    if (localAppRuntime == null) {
      return "0";
    }
    if (localAppRuntime.getAccount() == null) {
      return "0";
    }
    return localAppRuntime.getAccount();
  }
  
  public static String a(int paramInt)
  {
    if (l != 0) {
      try
      {
        Object localObject = new JSONObject();
        ((JSONObject)localObject).put("folder_status", l);
        ((JSONObject)localObject).put("channel_id", paramInt);
        localObject = ((JSONObject)localObject).toString();
        return (String)localObject;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return "";
      }
    }
    return Integer.toString(paramInt);
  }
  
  public static String a(int paramInt1, int paramInt2)
  {
    if (l != 0) {
      try
      {
        Object localObject = new JSONObject();
        ((JSONObject)localObject).put("folder_status", l);
        ((JSONObject)localObject).put("channel_id", paramInt1);
        ((JSONObject)localObject).put("current_channel_id", paramInt2);
        localObject = ((JSONObject)localObject).toString();
        return (String)localObject;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return "";
      }
    }
    return Integer.toString(paramInt1);
  }
  
  public static String a(long paramLong, int paramInt)
  {
    Object localObject = "";
    if (l != 0) {}
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("folder_status", l);
      ((JSONObject)localObject).put("algorithm_id", paramLong);
      ((JSONObject)localObject).put("feeds_friends_interaction", paramInt);
      localObject = ((JSONObject)localObject).toString();
      return (String)localObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return "";
  }
  
  public static String a(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (l != 0) {
      try
      {
        Object localObject = new JSONObject();
        ((JSONObject)localObject).put("algorithm_id", paramLong);
        ((JSONObject)localObject).put("folder_status", l);
        ((JSONObject)localObject).put("feeds_type", paramInt1);
        ((JSONObject)localObject).put("channel_id", paramInt2);
        ((JSONObject)localObject).put("feeds_channel_entrance", paramInt3);
        ((JSONObject)localObject).put("feeds_friends_interaction", paramInt4);
        localObject = ((JSONObject)localObject).toString();
        return (String)localObject;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return "";
      }
    }
    return Long.toString(paramLong);
  }
  
  public static String a(String paramString)
  {
    paramString = a(paramString);
    if ((paramString != null) && (paramString.length() > 0))
    {
      Object localObject = paramString.optJSONObject(0);
      if (localObject != null)
      {
        paramString = ((JSONObject)localObject).optString("vid");
        int i3 = ((JSONObject)localObject).optInt("duration");
        String str1 = ((JSONObject)localObject).optString("thirdIcon");
        String str2 = ((JSONObject)localObject).optString("thirdName");
        String str3 = ((JSONObject)localObject).optString("thirdAction");
        String str4 = ((JSONObject)localObject).optString("innerUniqueID");
        String str5 = ((JSONObject)localObject).optString("width", "0");
        String str6 = ((JSONObject)localObject).optString("height", "0");
        int i2 = ((JSONObject)localObject).optInt("busiType");
        int i1 = i2;
        if (i2 == 0) {
          i1 = 1;
        }
        String str7 = ((JSONObject)localObject).optString("third_uin", "");
        String str8 = ((JSONObject)localObject).optString("third_uin_name", "");
        localObject = ((JSONObject)localObject).optString("file_size", "0");
        return paramString + ";" + i3 + ";" + str1 + ";" + str2 + ";" + str3 + ";" + str4 + ";" + i1 + ";" + str5 + ";" + str6 + ";" + str7 + ";" + str8 + ";" + (String)localObject;
      }
    }
    return null;
  }
  
  public static String a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!ReadInJoyHelper.b(a()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyUtils", 2, "smart crop switch is false ! url : " + paramString);
      }
      return paramString;
    }
    double d2 = 1.0D * paramInt1 / paramInt2;
    double d1 = Double.MAX_VALUE;
    Object localObject1 = null;
    int i2 = ReadInJoyConstants.a.length;
    Object localObject2 = ReadInJoyConstants.a;
    int i1 = 0;
    label74:
    if (i1 < i2)
    {
      double d3 = 1.0D * ((Integer)localObject2[i1].second).intValue() / ((Integer)localObject2[i1].first).intValue();
      if (Math.abs(d3 - d2) >= d1) {
        break label346;
      }
      d1 = Math.abs(d3 - d2);
      localObject1 = localObject2[i1];
    }
    label346:
    for (;;)
    {
      i1 += 1;
      break label74;
      if (localObject1 == null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyUtils", 2, "the picture size : w : " + paramInt2 + " h : " + paramInt1 + ", select scale : " + ((Pair)localObject1).first + ":" + ((Pair)localObject1).second + " bias : " + d1 + " from : " + paramInt3);
      }
      localObject2 = paramString.split("/");
      localObject2 = localObject2[(localObject2.length - 1)];
      return paramString.replace("_open/" + (String)localObject2, "_open_" + ((Pair)localObject1).first + "_" + ((Pair)localObject1).second + "/" + (String)localObject2);
    }
  }
  
  public static String a(String paramString1, String paramString2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("aid", paramString2);
      localJSONObject.put("vid", paramString1);
      paramString1 = localJSONObject.toString();
      return paramString1;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
    return "";
  }
  
  public static URL a(String paramString)
  {
    paramString = a(paramString);
    if ((paramString != null) && (paramString.length() > 0))
    {
      paramString = paramString.optJSONObject(0);
      if (paramString != null) {
        try
        {
          paramString = PubAccountHttpDownloader.a(paramString.optString("picture"), 3);
          return paramString;
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
        }
      }
    }
    return null;
  }
  
  public static URL a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = paramString;
    if (a(paramString)) {
      if (!paramBoolean1) {
        break label57;
      }
    }
    label57:
    for (localObject = ReadInJoyDisplayUtils.b();; localObject = ReadInJoyDisplayUtils.a())
    {
      localObject = a(paramString, ((Integer)((Pair)localObject).second).intValue(), ((Integer)((Pair)localObject).first).intValue(), 3);
      return b((String)localObject);
    }
  }
  
  public static AppRuntime a()
  {
    AppRuntime localAppRuntime = null;
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.a();
    if (localBaseApplicationImpl != null) {
      localAppRuntime = localBaseApplicationImpl.a();
    }
    return localAppRuntime;
  }
  
  private static JSONArray a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      try
      {
        paramString = (JSONObject)new JSONTokener(paramString).nextValue();
        if ((paramString != null) && (!TextUtils.isEmpty(paramString.toString())))
        {
          paramString = paramString.optJSONArray("videos");
          if (paramString != null)
          {
            int i1 = paramString.length();
            if (i1 >= 1) {
              continue;
            }
          }
          return null;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return null;
      }
    }
    return null;
  }
  
  public static void a()
  {
    try
    {
      localObject = BaseApplicationImpl.a().a();
      if (!(localObject instanceof QQAppInterface)) {
        break label109;
      }
      localObject = ((QQAppInterface)localObject).a();
      if (localObject == null) {
        break label109;
      }
      localObject = ((QQMessageFacade)localObject).a(AppConstants.ba, 7220);
      if (localObject == null) {
        break label225;
      }
      if (((MessageRecord)localObject).extInt == 1) {
        break label230;
      }
      if (((MessageRecord)localObject).extInt != 3) {
        break label144;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject;
        label109:
        label144:
        int i1;
        if (QLog.isColorLevel())
        {
          QLog.d("ReadInJoyUtils", 2, "obtainMergeKandianFolderStatus except " + localException.toString());
          continue;
          if (i1 == 1)
          {
            l = 2;
            continue;
            label225:
            i1 = 0;
            continue;
            label230:
            i1 = 0;
            continue;
            label235:
            i1 = 1;
          }
        }
      }
    }
    if ((localObject != null) && (((MessageRecord)localObject).isread)) {}
    for (l = 1;; l = 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyUtils", 2, "update mergefolder status " + l);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyUtils", 2, "current mergefolder status is " + l);
      }
      return;
      if (((MessageRecord)localObject).extInt == 2) {
        break label235;
      }
      if (((MessageRecord)localObject).extInt != 4) {
        break label225;
      }
      break label235;
      if (i1 != 0) {
        break;
      }
    }
  }
  
  public static void a(float paramFloat, Resources paramResources)
  {
    if ((paramFloat == 0.0F) || (paramResources == null)) {
      return;
    }
    j = (int)(paramFloat / AIOUtils.a(66.0F, paramResources) + 0.5F);
  }
  
  public static void a(int paramInt)
  {
    l = paramInt;
  }
  
  public static void a(Context paramContext, String paramString, boolean paramBoolean, HashMap paramHashMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "reportKandianVideoInfo, success =" + paramBoolean);
    }
    StatisticCollector.a(paramContext).a(paramString, "actKandianVideo", paramBoolean, -1L, 0L, paramHashMap, null);
  }
  
  public static void a(BaseArticleInfo paramBaseArticleInfo)
  {
    boolean bool1 = true;
    try
    {
      if ((paramBaseArticleInfo.mDislikeInfos == null) || (paramBaseArticleInfo.mDislikeInfos.size() <= 0)) {
        paramBaseArticleInfo.mDislikeInfos = DislikeInfo.a(paramBaseArticleInfo.mDiskLikeInfoString);
      }
      paramBaseArticleInfo.mPictures = a(paramBaseArticleInfo.mJsonPictureList);
      Object localObject = paramBaseArticleInfo.mFirstPagePicUrl;
      boolean bool2 = paramBaseArticleInfo.mShowBigPicture;
      if (paramBaseArticleInfo.mVideoType == 0) {}
      for (;;)
      {
        paramBaseArticleInfo.mSinglePicture = a((String)localObject, bool2, bool1);
        if (!TextUtils.isEmpty(paramBaseArticleInfo.mJsonVideoList))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyUtils", 2, "preParseArticleJsonParam article.mArticleID:" + paramBaseArticleInfo.mArticleID + " article.mTitle:" + paramBaseArticleInfo.mTitle + " article.mSummary:" + paramBaseArticleInfo.mSummary + "mJsonVideoList:" + paramBaseArticleInfo.mJsonVideoList);
          }
          paramBaseArticleInfo.mVideoCoverUrl = a(paramBaseArticleInfo.mJsonVideoList);
          localObject = a(paramBaseArticleInfo.mJsonVideoList);
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            localObject = ((String)localObject).split(";");
            paramBaseArticleInfo.mVideoVid = localObject[0];
            paramBaseArticleInfo.mVideoDuration = Integer.valueOf(localObject[1]).intValue();
            paramBaseArticleInfo.thirdIcon = localObject[2];
            paramBaseArticleInfo.thirdName = localObject[3];
            paramBaseArticleInfo.thirdAction = localObject[4];
            paramBaseArticleInfo.innerUniqueID = localObject[5];
            paramBaseArticleInfo.busiType = Integer.valueOf(localObject[6]).intValue();
            paramBaseArticleInfo.mVideoJsonWidth = Integer.valueOf(localObject[7]).intValue();
            paramBaseArticleInfo.mVideoJsonHeight = Integer.valueOf(localObject[8]).intValue();
            if (localObject.length == 12)
            {
              paramBaseArticleInfo.thirdUin = localObject[9];
              paramBaseArticleInfo.thirdUinName = localObject[10];
              paramBaseArticleInfo.mFileSize = Long.valueOf(localObject[11]).longValue();
            }
          }
        }
        return;
        bool1 = false;
      }
      return;
    }
    catch (Exception paramBaseArticleInfo)
    {
      paramBaseArticleInfo.printStackTrace();
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    Object localObject = paramQQAppInterface.a();
    long l1 = 0L;
    if (localObject != null)
    {
      localObject = ((QQMessageFacade)localObject).a(AppConstants.ba, 7220);
      if (localObject != null) {}
    }
    do
    {
      return;
      l1 = ((QQMessageFacade.Message)localObject).time;
      paramQQAppInterface = ReadInJoyHelper.a(paramQQAppInterface, 1);
    } while (paramQQAppInterface == null);
    paramQQAppInterface = paramQQAppInterface.edit();
    paramQQAppInterface.putLong("kandian_lastest_disallow_time", l1);
    ReadInJoyHelper.a(paramQQAppInterface, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageForStructing paramMessageForStructing)
  {
    if (paramMessageForStructing == null) {
      return;
    }
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      MessageForStructing localMessageForStructing = (MessageForStructing)jdField_a_of_type_JavaUtilMap.get(paramQQAppInterface.a());
      if (localMessageForStructing == null) {
        jdField_a_of_type_JavaUtilMap.put(paramQQAppInterface.a(), paramMessageForStructing);
      }
      long l1;
      do
      {
        QLog.i("ReadInJoyUtils", 1, "updateNewKandianMsgCache :" + paramMessageForStructing.getBaseInfoString());
        return;
        l1 = localMessageForStructing.time;
      } while (paramMessageForStructing.time <= l1);
      jdField_a_of_type_JavaUtilMap.put(paramQQAppInterface.a(), paramMessageForStructing);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, List paramList)
  {
    HotChatManager localHotChatManager = null;
    int i1;
    label15:
    Object localObject;
    if (paramList == null)
    {
      i1 = 0;
      i1 -= 1;
      if (i1 < 0) {
        break label214;
      }
      localObject = (RecentUser)paramList.get(i1);
      if (localObject != null) {
        break label65;
      }
      paramList.remove(i1);
    }
    label65:
    label214:
    label215:
    label218:
    for (;;)
    {
      i1 -= 1;
      break label15;
      i1 = paramList.size();
      break;
      if ((TextUtils.isEmpty(((RecentUser)localObject).uin)) || (TextUtils.isEmpty(((RecentUser)localObject).uin.trim())))
      {
        paramList.remove(i1);
      }
      else
      {
        if ((((RecentUser)localObject).type == 1) && ((((RecentUser)localObject).lFlag & 1L) != 0L))
        {
          if ((localHotChatManager != null) || (paramQQAppInterface == null)) {
            break label215;
          }
          localHotChatManager = paramQQAppInterface.a(true);
        }
        for (;;)
        {
          if ((localHotChatManager == null) || (localHotChatManager.b(((RecentUser)localObject).uin))) {
            break label218;
          }
          paramList.remove(i1);
          break;
          if ((((RecentUser)localObject).type == 3000) && (paramQQAppInterface != null))
          {
            localObject = ((DiscussionManager)paramQQAppInterface.getManager(52)).a(((RecentUser)localObject).uin);
            if ((localObject != null) && (((DiscussionInfo)localObject).isUIControlFlag_Hidden_RecentUser())) {
              paramList.remove(i1);
            }
          }
          break;
          return;
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    MobileQQ localMobileQQ = paramQQAppInterface.getApplication();
    paramQQAppInterface = paramQQAppInterface.f();
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      SettingCloneUtil.writeValue(localMobileQQ, paramQQAppInterface, null, "qqsetting_kandian_key", paramBoolean);
      return;
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, boolean paramBoolean, long paramLong, int paramInt)
  {
    if ((paramAppRuntime == null) || (paramLong < 0L) || (paramLong > 50000L)) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("retCode", String.valueOf(paramInt));
    StatisticCollector.a(paramAppRuntime.getApplication()).a(null, "actKandianRefreshSuccAndCost", paramBoolean, paramLong, 0L, localHashMap, null);
  }
  
  public static boolean a()
  {
    return (a() instanceof QQAppInterface);
  }
  
  public static boolean a(int paramInt)
  {
    return paramInt == 0;
  }
  
  public static boolean a(Context paramContext)
  {
    Object localObject = (ActivityManager)paramContext.getApplicationContext().getSystemService("activity");
    paramContext = paramContext.getApplicationContext().getPackageName();
    String str = paramContext + ":readinjoy";
    localObject = ((ActivityManager)localObject).getRunningAppProcesses();
    if (localObject == null) {
      return false;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
      if (((localRunningAppProcessInfo.processName.equals(paramContext)) || (localRunningAppProcessInfo.processName.equals(str))) && (localRunningAppProcessInfo.importance == 100)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo == null) {}
    while ((paramBaseArticleInfo.mVideoCoverUrl == null) || (TextUtils.isEmpty(paramBaseArticleInfo.mVideoVid))) {
      return false;
    }
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    boolean bool = true;
    if (!SettingCloneUtil.readValue(paramQQAppInterface.getApplication(), paramQQAppInterface.f(), null, "qqsetting_kandian_key", true)) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyUtils", 2, "isDeleteNewKandian, flag = " + bool);
      }
      return bool;
      bool = false;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    boolean bool1 = false;
    boolean bool3 = false;
    boolean bool2 = bool3;
    if (paramMessageRecord != null)
    {
      bool2 = bool3;
      if (TextUtils.equals(paramMessageRecord.frienduin, AppConstants.aZ))
      {
        if (paramMessageRecord.istroop == 1008) {
          break label43;
        }
        bool2 = bool3;
      }
    }
    return bool2;
    label43:
    if ((NetworkUtil.b(paramQQAppInterface.a())) && ((jdField_a_of_type_Boolean) || ((ReadInJoyHelper.a(paramQQAppInterface)) && ((BaseActivity.sTopActivity instanceof ReadInJoyFeedsActivity))))) {}
    for (bool3 = true;; bool3 = false)
    {
      boolean bool4 = a(paramMessageRecord);
      boolean bool5 = ReadInJoyHelper.h(paramQQAppInterface);
      if ((bool3) || (bool4) || (bool5)) {
        bool1 = true;
      }
      bool2 = bool1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ReadInJoyUtils", 2, "neadShowXinKandianMsg, neadShow=" + bool1 + ", showFlag1=" + bool3 + ", showFlag2=" + bool4 + ", showFlag3=" + bool5);
      return bool1;
    }
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    boolean bool = true;
    if (paramMessageRecord == null) {
      return false;
    }
    if ((paramMessageRecord.extStr != null) && ((paramMessageRecord.extLong & 0x1) == 1) && (paramMessageRecord.extStr.contains("lockDisplay")) && (paramMessageRecord.getExtInfoFromExtStr("lockDisplay").equals("true"))) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyUtils", 2, "neadForceNotification, ret=" + bool + ", mr=" + paramMessageRecord);
      }
      return bool;
      bool = false;
    }
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      do
      {
        return false;
        paramString = paramString.split("/");
      } while (paramString.length < 2);
      paramString = paramString[(paramString.length - 2)].split("_");
    } while (paramString.length < 1);
    return "open".equals(paramString[(paramString.length - 1)]);
  }
  
  public static URL[] a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    for (;;)
    {
      try
      {
        paramString = (JSONObject)new JSONTokener(paramString).nextValue();
        if ((paramString == null) || (paramString.length() <= 0)) {
          break;
        }
        JSONArray localJSONArray = paramString.optJSONArray("pictures");
        if ((localJSONArray != null) && (localJSONArray.length() > 0))
        {
          URL[] arrayOfURL = new URL[localJSONArray.length()];
          Pair localPair = ReadInJoyDisplayUtils.a();
          int i1 = 0;
          if (i1 < localJSONArray.length())
          {
            paramString = localJSONArray.optJSONObject(i1).optString("picture");
            if (!TextUtils.isEmpty(paramString))
            {
              if (a(paramString))
              {
                paramString = a(paramString, ((Integer)localPair.second).intValue(), ((Integer)localPair.first).intValue(), 1);
                arrayOfURL[i1] = PubAccountHttpDownloader.a(paramString, 3);
              }
            }
            else {
              i1 += 1;
            }
          }
          else
          {
            return arrayOfURL;
          }
        }
        else
        {
          return null;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return null;
      }
    }
    return null;
  }
  
  /* Error */
  public static long b(QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 12
    //   3: invokestatic 828	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTime	()J
    //   6: lstore 13
    //   8: getstatic 87	com/tencent/biz/pubaccount/readinjoy/common/ReadInJoyUtils:j	I
    //   11: istore 6
    //   13: iload 6
    //   15: iconst_2
    //   16: isub
    //   17: istore 7
    //   19: aload_0
    //   20: ifnull +8 -> 28
    //   23: iload 6
    //   25: ifgt +33 -> 58
    //   28: ldc 24
    //   30: iconst_1
    //   31: new 299	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 300	java/lang/StringBuilder:<init>	()V
    //   38: ldc_w 830
    //   41: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: lload 13
    //   46: invokevirtual 528	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   49: invokevirtual 310	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokestatic 326	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   55: lload 13
    //   57: lreturn
    //   58: invokestatic 835	com/tencent/mobileqq/activity/recent/RecentDataListManager:a	()Lcom/tencent/mobileqq/activity/recent/RecentDataListManager;
    //   61: getfield 838	com/tencent/mobileqq/activity/recent/RecentDataListManager:a	Ljava/util/List;
    //   64: astore_3
    //   65: aload_0
    //   66: invokevirtual 841	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/proxy/ProxyManager;
    //   69: invokevirtual 846	com/tencent/mobileqq/app/proxy/ProxyManager:a	()Lcom/tencent/mobileqq/app/proxy/RecentUserProxy;
    //   72: iconst_0
    //   73: invokevirtual 851	com/tencent/mobileqq/app/proxy/RecentUserProxy:a	(Z)Ljava/util/List;
    //   76: astore 4
    //   78: aload_0
    //   79: aload 4
    //   81: invokestatic 853	com/tencent/biz/pubaccount/readinjoy/common/ReadInJoyUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/util/List;)V
    //   84: aload_0
    //   85: invokevirtual 764	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   88: invokevirtual 856	com/tencent/qphone/base/util/BaseApplication:getApplicationContext	()Landroid/content/Context;
    //   91: astore 5
    //   93: aload 4
    //   95: ifnull +227 -> 322
    //   98: aload 4
    //   100: invokeinterface 633 1 0
    //   105: istore 8
    //   107: aload 4
    //   109: aload_0
    //   110: aload 5
    //   112: aload_3
    //   113: iload 8
    //   115: invokestatic 861	com/tencent/mobileqq/activity/recent/ConversationDataFactory:a	(Ljava/util/List;Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Ljava/util/List;I)V
    //   118: aload_3
    //   119: getstatic 101	com/tencent/biz/pubaccount/readinjoy/common/ReadInJoyUtils:jdField_a_of_type_JavaUtilComparator	Ljava/util/Comparator;
    //   122: invokestatic 867	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   125: aload_3
    //   126: invokeinterface 721 1 0
    //   131: astore 4
    //   133: aload 4
    //   135: invokeinterface 726 1 0
    //   140: ifeq +198 -> 338
    //   143: aload 4
    //   145: invokeinterface 729 1 0
    //   150: checkcast 869	com/tencent/mobileqq/activity/recent/RecentBaseData
    //   153: astore 5
    //   155: aload 5
    //   157: ifnull -24 -> 133
    //   160: aload 5
    //   162: checkcast 871	com/tencent/mobileqq/activity/recent/data/RecentUserBaseData
    //   165: astore 5
    //   167: aload 5
    //   169: getfield 874	com/tencent/mobileqq/activity/recent/data/RecentUserBaseData:a	Lcom/tencent/mobileqq/data/RecentUser;
    //   172: ifnull -39 -> 133
    //   175: aload 5
    //   177: getfield 874	com/tencent/mobileqq/activity/recent/data/RecentUserBaseData:a	Lcom/tencent/mobileqq/data/RecentUser;
    //   180: getfield 642	com/tencent/mobileqq/data/RecentUser:type	I
    //   183: sipush 1008
    //   186: if_icmpne -53 -> 133
    //   189: aload_0
    //   190: aload 5
    //   192: getfield 874	com/tencent/mobileqq/activity/recent/data/RecentUserBaseData:a	Lcom/tencent/mobileqq/data/RecentUser;
    //   195: getfield 636	com/tencent/mobileqq/data/RecentUser:uin	Ljava/lang/String;
    //   198: invokestatic 879	com/tencent/biz/pubaccount/serviceAccountFolder/ServiceAccountFolderManager:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Z
    //   201: ifeq -68 -> 133
    //   204: aload 4
    //   206: invokeinterface 881 1 0
    //   211: goto -78 -> 133
    //   214: astore_0
    //   215: iconst_0
    //   216: istore 11
    //   218: iload 6
    //   220: istore 9
    //   222: ldc 24
    //   224: iconst_1
    //   225: new 299	java/lang/StringBuilder
    //   228: dup
    //   229: invokespecial 300	java/lang/StringBuilder:<init>	()V
    //   232: ldc_w 883
    //   235: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: aload_0
    //   239: invokevirtual 457	java/lang/Exception:toString	()Ljava/lang/String;
    //   242: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: invokevirtual 310	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   248: invokestatic 326	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   251: iload 9
    //   253: istore 8
    //   255: iload 11
    //   257: istore 6
    //   259: iload 6
    //   261: ifeq +431 -> 692
    //   264: iconst_0
    //   265: istore 6
    //   267: iload 12
    //   269: istore 9
    //   271: iload 6
    //   273: iload 8
    //   275: if_icmpge +215 -> 490
    //   278: aload_3
    //   279: iload 6
    //   281: invokeinterface 628 2 0
    //   286: checkcast 869	com/tencent/mobileqq/activity/recent/RecentBaseData
    //   289: astore_0
    //   290: aload_0
    //   291: ifnull +22 -> 313
    //   294: aload_0
    //   295: checkcast 871	com/tencent/mobileqq/activity/recent/data/RecentUserBaseData
    //   298: getfield 874	com/tencent/mobileqq/activity/recent/data/RecentUserBaseData:a	Lcom/tencent/mobileqq/data/RecentUser;
    //   301: getfield 886	com/tencent/mobileqq/data/RecentUser:showUpTime	J
    //   304: lstore 15
    //   306: lload 15
    //   308: lconst_0
    //   309: lcmp
    //   310: ifle +176 -> 486
    //   313: iload 6
    //   315: iconst_1
    //   316: iadd
    //   317: istore 6
    //   319: goto -52 -> 267
    //   322: iconst_0
    //   323: istore 8
    //   325: goto -218 -> 107
    //   328: astore 4
    //   330: aload 4
    //   332: invokevirtual 402	java/lang/Exception:printStackTrace	()V
    //   335: goto -210 -> 125
    //   338: aload_3
    //   339: invokeinterface 633 1 0
    //   344: istore 8
    //   346: iload 6
    //   348: istore 9
    //   350: iload 6
    //   352: iload 8
    //   354: if_icmple +7 -> 361
    //   357: iload 8
    //   359: istore 9
    //   361: iconst_0
    //   362: istore 10
    //   364: iconst_0
    //   365: istore 6
    //   367: iload 10
    //   369: iload 9
    //   371: if_icmpge +108 -> 479
    //   374: iload 6
    //   376: istore 11
    //   378: aload_3
    //   379: iload 10
    //   381: invokeinterface 628 2 0
    //   386: checkcast 869	com/tencent/mobileqq/activity/recent/RecentBaseData
    //   389: astore_0
    //   390: iload 6
    //   392: istore 11
    //   394: aload_0
    //   395: ifnull +337 -> 732
    //   398: iload 6
    //   400: istore 11
    //   402: aload_0
    //   403: checkcast 871	com/tencent/mobileqq/activity/recent/data/RecentUserBaseData
    //   406: astore_0
    //   407: iload 6
    //   409: istore 8
    //   411: iload 6
    //   413: istore 11
    //   415: aload_0
    //   416: getfield 889	com/tencent/mobileqq/activity/recent/data/RecentUserBaseData:H	I
    //   419: ifle +6 -> 425
    //   422: iconst_1
    //   423: istore 8
    //   425: iload 8
    //   427: istore 11
    //   429: aload_0
    //   430: invokevirtual 890	com/tencent/mobileqq/activity/recent/data/RecentUserBaseData:a	()Ljava/lang/String;
    //   433: getstatic 437	com/tencent/mobileqq/app/AppConstants:ba	Ljava/lang/String;
    //   436: invokestatic 758	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   439: istore 19
    //   441: iload 8
    //   443: istore 11
    //   445: iload 19
    //   447: ifeq +285 -> 732
    //   450: iload 10
    //   452: istore 6
    //   454: iload 8
    //   456: istore 7
    //   458: iload 10
    //   460: iconst_1
    //   461: iadd
    //   462: istore 10
    //   464: iload 7
    //   466: istore 8
    //   468: iload 6
    //   470: istore 7
    //   472: iload 8
    //   474: istore 6
    //   476: goto -109 -> 367
    //   479: iload 9
    //   481: istore 8
    //   483: goto -224 -> 259
    //   486: iload 6
    //   488: istore 9
    //   490: iload 9
    //   492: iload 7
    //   494: if_icmplt +93 -> 587
    //   497: ldc 24
    //   499: iconst_1
    //   500: new 299	java/lang/StringBuilder
    //   503: dup
    //   504: invokespecial 300	java/lang/StringBuilder:<init>	()V
    //   507: ldc_w 892
    //   510: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   513: lload 13
    //   515: invokevirtual 528	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   518: invokevirtual 310	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   521: invokestatic 326	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   524: lload 13
    //   526: lreturn
    //   527: astore_0
    //   528: ldc 24
    //   530: iconst_1
    //   531: new 299	java/lang/StringBuilder
    //   534: dup
    //   535: invokespecial 300	java/lang/StringBuilder:<init>	()V
    //   538: ldc_w 894
    //   541: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   544: aload_0
    //   545: invokevirtual 457	java/lang/Exception:toString	()Ljava/lang/String;
    //   548: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   551: invokevirtual 310	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   554: invokestatic 326	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   557: ldc 24
    //   559: iconst_1
    //   560: new 299	java/lang/StringBuilder
    //   563: dup
    //   564: invokespecial 300	java/lang/StringBuilder:<init>	()V
    //   567: ldc_w 892
    //   570: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   573: lload 13
    //   575: invokevirtual 528	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   578: invokevirtual 310	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   581: invokestatic 326	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   584: lload 13
    //   586: lreturn
    //   587: invokestatic 898	java/lang/Math:random	()D
    //   590: iload 7
    //   592: iload 9
    //   594: isub
    //   595: i2d
    //   596: dmul
    //   597: d2i
    //   598: iconst_1
    //   599: iadd
    //   600: iload 9
    //   602: iadd
    //   603: istore 6
    //   605: aload_3
    //   606: iload 6
    //   608: iconst_1
    //   609: isub
    //   610: invokeinterface 628 2 0
    //   615: checkcast 871	com/tencent/mobileqq/activity/recent/data/RecentUserBaseData
    //   618: astore_0
    //   619: aload_3
    //   620: iload 6
    //   622: invokeinterface 628 2 0
    //   627: checkcast 871	com/tencent/mobileqq/activity/recent/data/RecentUserBaseData
    //   630: astore_3
    //   631: aload_0
    //   632: getfield 874	com/tencent/mobileqq/activity/recent/data/RecentUserBaseData:a	Lcom/tencent/mobileqq/data/RecentUser;
    //   635: getfield 901	com/tencent/mobileqq/data/RecentUser:lastmsgtime	J
    //   638: aload_0
    //   639: getfield 874	com/tencent/mobileqq/activity/recent/data/RecentUserBaseData:a	Lcom/tencent/mobileqq/data/RecentUser;
    //   642: getfield 904	com/tencent/mobileqq/data/RecentUser:lastmsgdrafttime	J
    //   645: invokestatic 908	java/lang/Math:max	(JJ)J
    //   648: lstore 15
    //   650: aload_3
    //   651: getfield 874	com/tencent/mobileqq/activity/recent/data/RecentUserBaseData:a	Lcom/tencent/mobileqq/data/RecentUser;
    //   654: getfield 901	com/tencent/mobileqq/data/RecentUser:lastmsgtime	J
    //   657: aload_3
    //   658: getfield 874	com/tencent/mobileqq/activity/recent/data/RecentUserBaseData:a	Lcom/tencent/mobileqq/data/RecentUser;
    //   661: getfield 904	com/tencent/mobileqq/data/RecentUser:lastmsgdrafttime	J
    //   664: invokestatic 908	java/lang/Math:max	(JJ)J
    //   667: lstore 17
    //   669: invokestatic 898	java/lang/Math:random	()D
    //   672: dstore_1
    //   673: lload 15
    //   675: lload 15
    //   677: lload 17
    //   679: lsub
    //   680: l2d
    //   681: dload_1
    //   682: dmul
    //   683: d2l
    //   684: lsub
    //   685: lconst_1
    //   686: lsub
    //   687: lstore 13
    //   689: goto -132 -> 557
    //   692: ldc 24
    //   694: iconst_1
    //   695: new 299	java/lang/StringBuilder
    //   698: dup
    //   699: invokespecial 300	java/lang/StringBuilder:<init>	()V
    //   702: ldc_w 910
    //   705: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   708: iload 8
    //   710: invokevirtual 309	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   713: ldc_w 912
    //   716: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   719: invokevirtual 310	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   722: invokestatic 326	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   725: goto -168 -> 557
    //   728: astore_0
    //   729: goto -507 -> 222
    //   732: iload 7
    //   734: istore 6
    //   736: iload 11
    //   738: istore 7
    //   740: goto -282 -> 458
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	743	0	paramQQAppInterface	QQAppInterface
    //   672	10	1	d1	double
    //   64	594	3	localObject1	Object
    //   76	129	4	localObject2	Object
    //   328	3	4	localException	Exception
    //   91	100	5	localObject3	Object
    //   11	724	6	i1	int
    //   17	722	7	i2	int
    //   105	604	8	i3	int
    //   220	383	9	i4	int
    //   362	101	10	i5	int
    //   216	521	11	i6	int
    //   1	267	12	i7	int
    //   6	682	13	l1	long
    //   304	372	15	l2	long
    //   667	11	17	l3	long
    //   439	7	19	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   65	93	214	java/lang/Exception
    //   98	107	214	java/lang/Exception
    //   107	118	214	java/lang/Exception
    //   125	133	214	java/lang/Exception
    //   133	155	214	java/lang/Exception
    //   160	211	214	java/lang/Exception
    //   330	335	214	java/lang/Exception
    //   338	346	214	java/lang/Exception
    //   118	125	328	java/lang/Exception
    //   278	290	527	java/lang/Exception
    //   294	306	527	java/lang/Exception
    //   497	524	527	java/lang/Exception
    //   587	673	527	java/lang/Exception
    //   378	390	728	java/lang/Exception
    //   402	407	728	java/lang/Exception
    //   415	422	728	java/lang/Exception
    //   429	441	728	java/lang/Exception
  }
  
  public static Handler b()
  {
    if (jdField_b_of_type_AndroidOsHandler == null) {}
    try
    {
      if (jdField_b_of_type_AndroidOsHandler == null) {
        jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
      }
      return jdField_b_of_type_AndroidOsHandler;
    }
    finally {}
  }
  
  public static String b()
  {
    String str = SettingCloneUtil.readValue(BaseApplicationImpl.getContext(), a(), null, "qqsetting_kandian_video_auto_flag", jdField_b_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyUtils", 2, "getVideoAutoPlaySetting, autoSetting = " + str);
    }
    return str;
  }
  
  public static String b(int paramInt)
  {
    if (l != 0) {
      try
      {
        Object localObject = new JSONObject();
        ((JSONObject)localObject).put("folder_status", l);
        ((JSONObject)localObject).put("time", System.currentTimeMillis());
        ((JSONObject)localObject).put("channel_id", paramInt);
        localObject = ((JSONObject)localObject).toString();
        return (String)localObject;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return "";
      }
    }
    return Long.toString(System.currentTimeMillis());
  }
  
  public static String b(long paramLong, int paramInt)
  {
    if (l != 0) {
      try
      {
        Object localObject = new JSONObject();
        ((JSONObject)localObject).put("folder_status", l);
        ((JSONObject)localObject).put("algorithm_id", paramLong);
        ((JSONObject)localObject).put("feeds_friends_interaction", paramInt);
        localObject = ((JSONObject)localObject).toString();
        return (String)localObject;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return "";
      }
    }
    return Long.toString(paramLong);
  }
  
  public static String b(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (l != 0) {
      try
      {
        Object localObject = new JSONObject();
        ((JSONObject)localObject).put("algorithm_id", paramLong);
        ((JSONObject)localObject).put("folder_status", l);
        ((JSONObject)localObject).put("feeds_type", paramInt1);
        ((JSONObject)localObject).put("time", System.currentTimeMillis());
        ((JSONObject)localObject).put("channel_id", paramInt2);
        ((JSONObject)localObject).put("feeds_channel_entrance", paramInt3);
        ((JSONObject)localObject).put("feeds_friends_interaction", paramInt4);
        localObject = ((JSONObject)localObject).toString();
        return (String)localObject;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return "";
      }
    }
    return Long.toString(System.currentTimeMillis());
  }
  
  public static String b(String paramString)
  {
    if (l != 0) {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("folder_status", l);
        localJSONObject.put("time", System.currentTimeMillis());
        localJSONObject.put("algorithm_id", paramString);
        paramString = localJSONObject.toString();
        return paramString;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return "";
      }
    }
    return Long.toString(System.currentTimeMillis());
  }
  
  public static URL b(String paramString)
  {
    return PubAccountHttpDownloader.a(paramString, 3);
  }
  
  public static void b(Context paramContext, String paramString, boolean paramBoolean, HashMap paramHashMap)
  {
    StatisticCollector.a(paramContext).a(paramString, "actKandianVideoPreload", paramBoolean, -1L, 0L, paramHashMap, null);
  }
  
  public static void b(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.a(new hxi(paramQQAppInterface), 8, null, false);
  }
  
  public static boolean b(int paramInt)
  {
    return (paramInt == 40003) || (paramInt == 40004);
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.a();
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.a(AppConstants.ba, 7220);
      if ((paramQQAppInterface != null) && (!paramQQAppInterface.isread)) {
        return true;
      }
    }
    return false;
  }
  
  private static boolean b(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    return (paramQQAppInterface.a() != null) && (paramQQAppInterface.a().c(paramString, paramInt) > 0);
  }
  
  public static String c()
  {
    Object localObject = "";
    if (l != 0) {}
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("folder_status", l);
      localObject = ((JSONObject)localObject).toString();
      return (String)localObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return "";
  }
  
  public static String c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    if (paramString.length() < 4) {
      return paramString + "|" + paramString.length();
    }
    return paramString.substring(0, 4) + "|" + paramString.length();
  }
  
  public static void c(Context paramContext, String paramString, boolean paramBoolean, HashMap paramHashMap)
  {
    StatisticCollector.a(paramContext).a(paramString, "actKandianVideoGetUrl", paramBoolean, -1L, 0L, paramHashMap, null);
  }
  
  public static void c(QQAppInterface paramQQAppInterface)
  {
    jdField_a_of_type_Boolean = true;
    ThreadManager.a(new hxj(paramQQAppInterface), 8, null, false);
  }
  
  public static boolean c(int paramInt)
  {
    return paramInt == 9999;
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface)
  {
    Object localObject = BaseActivity.sTopActivity;
    if ((localObject instanceof SplashActivity))
    {
      if (((SplashActivity)localObject).a() != MainFragment.a)
      {
        QLog.d("ReadInJoyUtils", 1, "r:Not in conversationtab");
        return false;
      }
    }
    else
    {
      QLog.d("ReadInJoyUtils", 1, "r:top activity is not splash");
      return false;
    }
    if (!ReadInJoyHelper.d(paramQQAppInterface))
    {
      QLog.d("ReadInJoyUtils", 1, "r:config false");
      return false;
    }
    if (!SettingCloneUtil.readValue(paramQQAppInterface.a(), paramQQAppInterface.getAccount(), null, "qqsetting_kandian_key", true))
    {
      QLog.d("ReadInJoyUtils", 1, "kandian push disabled");
      return false;
    }
    localObject = ReadInJoyHelper.a(paramQQAppInterface);
    String str = jdField_a_of_type_JavaTextSimpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
    int i1 = Calendar.getInstance().get(11);
    if ((!TextUtils.equals((CharSequence)localObject, str)) && (i1 >= 6))
    {
      if (!b(paramQQAppInterface))
      {
        QLog.d("ReadInJoyUtils", 1, "r:true to get individual push");
        return true;
      }
      QLog.d("ReadInJoyUtils", 1, "r:already has red point");
    }
    for (;;)
    {
      return false;
      QLog.d("ReadInJoyUtils", 1, "r:hour:" + i1);
    }
  }
  
  public static void d(QQAppInterface paramQQAppInterface)
  {
    jdField_a_of_type_Boolean = false;
  }
  
  public static void e(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      MessageForStructing localMessageForStructing;
      QQMessageFacade localQQMessageFacade;
      do
      {
        do
        {
          return;
          localMessageForStructing = a(paramQQAppInterface);
        } while ((a(paramQQAppInterface)) || (localMessageForStructing == null));
        localQQMessageFacade = paramQQAppInterface.a();
      } while (localQQMessageFacade == null);
      localMessageForStructing.time = NetConnInfoCenter.getServerTime();
      MessageRecord localMessageRecord = ((KandianMergeManager)paramQQAppInterface.getManager(161)).a(localMessageForStructing);
      if (localMessageRecord != null) {
        localQQMessageFacade.a(localMessageRecord, paramQQAppInterface.f());
      }
      localQQMessageFacade.a(localMessageForStructing, paramQQAppInterface.f());
    } while (!QLog.isColorLevel());
    QLog.d("ReadInJoyUtils", 2, "notifyXinKandianMsg");
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\readinjoy\common\ReadInJoyUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */