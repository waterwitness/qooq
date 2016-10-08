package com.tencent.mobileqq.vas;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vipav.VipFunCallManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

public class IndividuationConfigInfo
{
  private static final byte a = 0;
  public static final int a = 1;
  public static final String a = "emoji";
  public static HashMap a;
  private static final byte b = 2;
  public static final int b = 2;
  public static final String b = "bubble";
  public static final int c = 3;
  public static final String c = "theme";
  public static final int d = 4;
  public static final String d = "font";
  private static HashMap d;
  public static final int e = 5;
  public static final String e = "pendant";
  public static final int f = 1;
  public static final String f = "card";
  public static final int g = 2;
  public static final String g = "call";
  public static final String h = "suit";
  public static final String i = "background";
  public static final String j = "ring";
  public static final String k = "hongbao";
  public static final String l = "ui-tag-new";
  public static final String m = "ui-tag-hot";
  public static final String n = "#F2F2F2";
  private static final String r = "IndividuationConfigInfo";
  private static final String s = "isDisplay";
  private static final String t = "platformId";
  private static final String u = "startVers";
  private static final String v = "endVers";
  public IndividuationConfigInfo.BannerConfig a;
  public IndividuationConfigInfo.PayBtnConfig a;
  public IndividuationConfigInfo.ShapedImgConfig a;
  public ArrayList a;
  public ArrayList b;
  public HashMap b;
  public ArrayList c;
  public HashMap c;
  public String o;
  public String p;
  public String q;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    d = new HashMap();
    d.put(Integer.valueOf(100001), "emoji");
    d.put(Integer.valueOf(100003), "bubble");
    d.put(Integer.valueOf(100002), "theme");
    d.put(Integer.valueOf(100011), "font");
    d.put(Integer.valueOf(100006), "pendant");
    d.put(Integer.valueOf(100012), "card");
    d.put(Integer.valueOf(100019), "call");
    d.put(Integer.valueOf(100020), "suit");
    d.put(Integer.valueOf(100021), "background");
    d.put(Integer.valueOf(100018), "ring");
    d.put(Integer.valueOf(100028), "hongbao");
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaUtilHashMap.put("1", new IndividuationConfigInfo.BizExtraInfo(2, true, 1, 1));
    jdField_a_of_type_JavaUtilHashMap.put("2", new IndividuationConfigInfo.BizExtraInfo(2, false, 1, 2));
    jdField_a_of_type_JavaUtilHashMap.put("3", new IndividuationConfigInfo.BizExtraInfo(3, true, 2, 3));
    jdField_a_of_type_JavaUtilHashMap.put("4", new IndividuationConfigInfo.BizExtraInfo(3, true, 1, 4));
    jdField_a_of_type_JavaUtilHashMap.put("5", new IndividuationConfigInfo.BizExtraInfo(3, true, 1, 5));
  }
  
  public static IndividuationConfigInfo a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IndividuationConfigInfo", 2, "parse, config content=" + paramString);
    }
    if ((TextUtils.isEmpty(paramString)) || (paramQQAppInterface == null))
    {
      QLog.e("IndividuationConfigInfo", 1, "parse, app=" + paramQQAppInterface + ", configContent=" + paramString);
      return null;
    }
    long l3 = System.currentTimeMillis();
    IndividuationConfigInfo localIndividuationConfigInfo = new IndividuationConfigInfo();
    JSONObject localJSONObject;
    int i1;
    int i2;
    Object localObject1;
    label239:
    Object localObject2;
    label329:
    Object localObject3;
    int i3;
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject(paramString);
        if (localJSONObject.has("backgroundImage"))
        {
          paramString = localJSONObject.getJSONArray("backgroundImage");
          if ((paramString != null) && (paramString.length() > 0))
          {
            i1 = 0;
            i2 = paramString.length();
            if (i1 < i2)
            {
              localObject1 = paramString.getJSONObject(i1);
              if ((localObject1 == null) || (!b((JSONObject)localObject1)) || (!a((JSONObject)localObject1)) || (!((JSONObject)localObject1).has("image"))) {
                break label2893;
              }
              localObject1 = ((JSONObject)localObject1).getString("image");
              if (TextUtils.isEmpty((CharSequence)localObject1)) {
                break label2893;
              }
              localIndividuationConfigInfo.o = ((String)localObject1);
            }
          }
        }
        if (localJSONObject.has("animationImage"))
        {
          localObject1 = localJSONObject.getJSONArray("animationImage");
          if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
          {
            i1 = 0;
            i2 = ((JSONArray)localObject1).length();
            if (i1 < i2)
            {
              paramString = ((JSONArray)localObject1).getJSONObject(i1);
              if ((paramString == null) || (!a(paramString)) || (!b(paramString)) || (!paramString.has("image"))) {
                break label2908;
              }
              paramString = paramString.getString("image");
              if (TextUtils.isEmpty(paramString)) {
                break label2908;
              }
              localObject1 = paramQQAppInterface.getApplication().getSharedPreferences("sp_individuation_mainpage2", 0);
              localObject2 = ((SharedPreferences)localObject1).getString("sp_key_last_festival_animation_zip_url", null);
              i1 = 0;
              if (paramString.equals(localObject2)) {
                continue;
              }
              i1 = 1;
              if (i1 != 0)
              {
                paramQQAppInterface.getApplication();
                localObject2 = new File(MobileQQ.getContext().getFilesDir(), "IndividuationAnimation.zip");
                if (((File)localObject2).exists()) {
                  ((File)localObject2).delete();
                }
                localObject3 = new DownloadTask(paramString, (File)localObject2);
                ((DownloadTask)localObject3).f = "IndividuationAnimation";
                if (DownloaderFactory.a((DownloadTask)localObject3, paramQQAppInterface) != 0) {
                  break label767;
                }
                i1 = 1;
                localObject3 = new File(AppConstants.bZ);
                FileUtils.a(((File)localObject3).getAbsolutePath());
                if (i1 == 0) {
                  break label805;
                }
                FileUtils.a(((File)localObject2).getAbsolutePath(), ((File)localObject3).getAbsolutePath(), false);
                paramQQAppInterface = a(paramQQAppInterface);
                if ((paramQQAppInterface != null) && (paramQQAppInterface.exists())) {
                  break label773;
                }
                QLog.e("IndividuationConfigInfo", 1, "unzip failed, url=" + paramString + ",size=" + ((File)localObject2).length());
                if (((File)localObject2).exists()) {
                  ((File)localObject2).delete();
                }
              }
            }
          }
        }
        if (localJSONObject.has("backgroundColor")) {
          localIndividuationConfigInfo.q = localJSONObject.getString("backgroundColor");
        }
        if (!localJSONObject.has("HeadViewPos")) {
          break label1068;
        }
        localObject2 = localJSONObject.getJSONArray("HeadViewPos");
        if ((localObject2 == null) || (((JSONArray)localObject2).length() <= 0)) {
          break label1068;
        }
        localIndividuationConfigInfo.jdField_b_of_type_JavaUtilHashMap = new HashMap();
        i3 = ((JSONArray)localObject2).length();
        i1 = 0;
        label580:
        if (i1 >= i3) {
          break label1068;
        }
        localObject3 = ((JSONArray)localObject2).getJSONObject(i1);
        if (localObject3 == null) {
          break label2884;
        }
        if (!((JSONObject)localObject3).has("bussinessType")) {
          break label2917;
        }
        paramQQAppInterface = ((JSONObject)localObject3).getString("bussinessType");
        label620:
        if (!TextUtils.isEmpty(paramQQAppInterface)) {
          break;
        }
        break label2884;
        localObject2 = a(paramQQAppInterface);
        if ((localObject2 == null) || (!((File)localObject2).exists())) {
          break label2902;
        }
        localIndividuationConfigInfo.p = ((File)localObject2).getAbsolutePath();
        continue;
        if (!QLog.isColorLevel()) {
          break label764;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("IndividuationConfigInfo", 2, "parse, exception=" + MsfSdkUtils.getStackTraceString(paramQQAppInterface));
        }
      }
      label697:
      QLog.d("IndividuationConfigInfo", 2, "parse, duration=" + (System.currentTimeMillis() - l3));
      QLog.d("IndividuationConfigInfo", 2, "parse, result=" + localIndividuationConfigInfo.toString());
      label764:
      return localIndividuationConfigInfo;
      label767:
      i1 = 0;
      continue;
      label773:
      localIndividuationConfigInfo.p = paramQQAppInterface.getAbsolutePath();
      ((SharedPreferences)localObject1).edit().putString("sp_key_last_festival_animation_zip_url", paramString).commit();
      continue;
      label805:
      QLog.e("IndividuationConfigInfo", 1, "download failed, url=" + paramString);
    }
    label854:
    label874:
    label942:
    label969:
    label996:
    label1023:
    label1049:
    label1068:
    label1108:
    label1202:
    label1229:
    label1258:
    label1319:
    label1384:
    label1407:
    label1430:
    label1453:
    label1474:
    label1497:
    label1520:
    label1976:
    label2042:
    label2062:
    label2082:
    label2103:
    label2239:
    long l1;
    label2283:
    long l2;
    label2302:
    long l4;
    if (((JSONObject)localObject3).has("minVersion"))
    {
      paramString = ((JSONObject)localObject3).getString("minVersion");
      if (!((JSONObject)localObject3).has("maxVersion")) {
        break label2927;
      }
      localObject1 = ((JSONObject)localObject3).getString("maxVersion");
      if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (a(paramString, "6.5.5")) && (a("6.5.5", (String)localObject1)))
      {
        localObject1 = new IndividuationConfigInfo.ButtonConfig();
        ((IndividuationConfigInfo.ButtonConfig)localObject1).jdField_a_of_type_JavaLangString = paramQQAppInterface;
        if (!((JSONObject)localObject3).has("x")) {
          break label2932;
        }
        i2 = ((JSONObject)localObject3).getInt("x");
        ((IndividuationConfigInfo.ButtonConfig)localObject1).jdField_a_of_type_Int = i2;
        if (!((JSONObject)localObject3).has("y")) {
          break label2938;
        }
        i2 = ((JSONObject)localObject3).getInt("y");
        ((IndividuationConfigInfo.ButtonConfig)localObject1).jdField_b_of_type_Int = i2;
        if (!((JSONObject)localObject3).has("width")) {
          break label2944;
        }
        i2 = ((JSONObject)localObject3).getInt("width");
        ((IndividuationConfigInfo.ButtonConfig)localObject1).c = i2;
        if (!((JSONObject)localObject3).has("height")) {
          break label2950;
        }
        i2 = ((JSONObject)localObject3).getInt("height");
        ((IndividuationConfigInfo.ButtonConfig)localObject1).d = i2;
        if (!((JSONObject)localObject3).has("defaultImgUrl")) {
          break label2956;
        }
        paramString = ((JSONObject)localObject3).getString("defaultImgUrl");
        ((IndividuationConfigInfo.ButtonConfig)localObject1).jdField_b_of_type_JavaLangString = paramString;
        localIndividuationConfigInfo.jdField_b_of_type_JavaUtilHashMap.put(paramQQAppInterface, localObject1);
        break label2884;
        if (localJSONObject.has("advertisement"))
        {
          paramQQAppInterface = localJSONObject.getJSONArray("advertisement");
          if ((paramQQAppInterface != null) && (paramQQAppInterface.length() > 0))
          {
            i1 = 0;
            i2 = paramQQAppInterface.length();
            if (i1 < i2)
            {
              paramString = paramQQAppInterface.getJSONObject(i1);
              if ((paramString == null) || (!b(paramString)) || (!c(paramString)) || (!d(paramString)) || (!paramString.has("url")) || (!paramString.has("image"))) {
                break label2985;
              }
              localIndividuationConfigInfo.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo$BannerConfig = new IndividuationConfigInfo.BannerConfig();
              localObject1 = localIndividuationConfigInfo.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo$BannerConfig;
              if (!paramString.has("url")) {
                break label2970;
              }
              paramQQAppInterface = paramString.getString("url");
              ((IndividuationConfigInfo.BannerConfig)localObject1).c = paramQQAppInterface;
              localObject1 = localIndividuationConfigInfo.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo$BannerConfig;
              if (!paramString.has("image")) {
                break label2975;
              }
              paramQQAppInterface = paramString.getString("image");
              ((IndividuationConfigInfo.BannerConfig)localObject1).jdField_a_of_type_JavaLangString = paramQQAppInterface;
              localObject1 = localIndividuationConfigInfo.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo$BannerConfig;
              if (!paramString.has("cornerMark")) {
                break label2980;
              }
              paramQQAppInterface = paramString.getString("cornerMark");
              ((IndividuationConfigInfo.BannerConfig)localObject1).jdField_b_of_type_JavaLangString = paramQQAppInterface;
            }
          }
        }
        if (localJSONObject.has("activities"))
        {
          paramString = localJSONObject.getJSONArray("activities");
          if ((paramString != null) && (paramString.length() > 0))
          {
            localIndividuationConfigInfo.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramString.length());
            i2 = paramString.length();
            i1 = 0;
            if (i1 < i2)
            {
              localObject2 = paramString.getJSONObject(i1);
              if ((localObject2 == null) || (!b((JSONObject)localObject2)) || (!c((JSONObject)localObject2)) || (!d((JSONObject)localObject2))) {
                break label2961;
              }
              localObject1 = new IndividuationConfigInfo.ActivityConfig();
              if (!((JSONObject)localObject2).has("id")) {
                break label2994;
              }
              paramQQAppInterface = ((JSONObject)localObject2).getString("id");
              ((IndividuationConfigInfo.ActivityConfig)localObject1).jdField_a_of_type_JavaLangString = paramQQAppInterface;
              if (!((JSONObject)localObject2).has("name")) {
                break label2999;
              }
              paramQQAppInterface = ((JSONObject)localObject2).getString("name");
              ((IndividuationConfigInfo.ActivityConfig)localObject1).c = paramQQAppInterface;
              if (!((JSONObject)localObject2).has("description")) {
                break label3004;
              }
              paramQQAppInterface = ((JSONObject)localObject2).getString("description");
              ((IndividuationConfigInfo.ActivityConfig)localObject1).d = paramQQAppInterface;
              if (!((JSONObject)localObject2).has("url")) {
                break label3009;
              }
              paramQQAppInterface = ((JSONObject)localObject2).getString("url");
              ((IndividuationConfigInfo.ActivityConfig)localObject1).e = paramQQAppInterface;
              if (!((JSONObject)localObject2).has("image")) {
                break label3014;
              }
              paramQQAppInterface = ((JSONObject)localObject2).getString("image");
              ((IndividuationConfigInfo.ActivityConfig)localObject1).jdField_b_of_type_JavaLangString = paramQQAppInterface;
              if (!((JSONObject)localObject2).has("cornerMark")) {
                break label3019;
              }
              paramQQAppInterface = ((JSONObject)localObject2).getString("cornerMark");
              ((IndividuationConfigInfo.ActivityConfig)localObject1).f = paramQQAppInterface;
              if (!((JSONObject)localObject2).has("useAnimation")) {
                break label3024;
              }
              paramQQAppInterface = ((JSONObject)localObject2).getString("useAnimation");
              ((IndividuationConfigInfo.ActivityConfig)localObject1).g = paramQQAppInterface;
              localIndividuationConfigInfo.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
              break label2961;
            }
          }
        }
        paramQQAppInterface = null;
        if (localJSONObject.has("sortInfo")) {
          paramQQAppInterface = localJSONObject.getJSONArray("sortInfo");
        }
        if ((paramQQAppInterface == null) || (paramQQAppInterface.length() < 1))
        {
          paramQQAppInterface = new JSONArray();
          paramString = new JSONObject();
          paramString.put("module", "emoji");
          paramString.put("name", "热门表情");
          paramString.put("style", 1);
          paramQQAppInterface.put(paramString);
          paramString = new JSONObject();
          paramString.put("module", "bubble");
          paramString.put("name", "热门气泡");
          paramString.put("style", 2);
          paramQQAppInterface.put(paramString);
          paramString = new JSONObject();
          paramString.put("module", "hongbao");
          paramString.put("name", "热门红包");
          paramString.put("style", 5);
          paramQQAppInterface.put(paramString);
          paramString = new JSONObject();
          paramString.put("module", "font");
          paramString.put("name", "热门字体");
          paramString.put("style", 2);
          paramQQAppInterface.put(paramString);
          paramString = new JSONObject();
          paramString.put("module", "pendant");
          paramString.put("name", "热门挂件");
          paramString.put("style", 3);
          paramQQAppInterface.put(paramString);
          paramString = new JSONObject();
          paramString.put("module", "theme");
          paramString.put("name", "热门主题");
          paramString.put("style", 4);
          paramQQAppInterface.put(paramString);
          paramString = new JSONObject();
          paramString.put("module", "card");
          paramString.put("name", "热门名片");
          paramString.put("style", 4);
          paramQQAppInterface.put(paramString);
          paramString = new JSONObject();
          paramString.put("module", "call");
          paramString.put("name", "热门来电");
          paramString.put("style", 4);
          paramQQAppInterface.put(paramString);
          paramString = new JSONObject();
          paramString.put("module", "ring");
          paramString.put("name", "热门铃声");
          paramString.put("style", 4);
          paramQQAppInterface.put(paramString);
          if ((paramQQAppInterface != null) && (paramQQAppInterface.length() > 0))
          {
            localIndividuationConfigInfo.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
            i1 = 0;
            while (i1 < paramQQAppInterface.length())
            {
              localObject3 = (JSONObject)paramQQAppInterface.get(i1);
              if (!((JSONObject)localObject3).has("module")) {
                break label3029;
              }
              paramString = ((JSONObject)localObject3).getString("module");
              if (!((JSONObject)localObject3).has("name")) {
                break label3036;
              }
              localObject1 = ((JSONObject)localObject3).getString("name");
              if (!((JSONObject)localObject3).has("moreUrl")) {
                break label3043;
              }
              localObject2 = ((JSONObject)localObject3).getString("moreUrl");
              if (!((JSONObject)localObject3).has("style")) {
                break label3050;
              }
              localObject3 = ((JSONObject)localObject3).getString("style");
              IndividuationConfigInfo.BizRecommendConfig localBizRecommendConfig = new IndividuationConfigInfo.BizRecommendConfig();
              localBizRecommendConfig.jdField_a_of_type_JavaLangString = paramString;
              localBizRecommendConfig.jdField_b_of_type_JavaLangString = ((String)localObject1);
              localBizRecommendConfig.c = ((String)localObject2);
              localBizRecommendConfig.d = ((String)localObject3);
              if (localJSONObject.has(paramString))
              {
                paramString = a(localJSONObject.getJSONArray(paramString));
                if (localBizRecommendConfig != null) {
                  localBizRecommendConfig.jdField_a_of_type_JavaUtilArrayList = paramString;
                }
              }
              localIndividuationConfigInfo.jdField_b_of_type_JavaUtilArrayList.add(localBizRecommendConfig);
              i1 += 1;
            }
          }
          if (localJSONObject.has("redDotImg"))
          {
            paramString = localJSONObject.getJSONArray("redDotImg");
            if ((paramString != null) && (paramString.length() > 0))
            {
              localIndividuationConfigInfo.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
              i3 = paramString.length();
              i1 = 0;
              if (i1 < i3)
              {
                localObject2 = paramString.getJSONObject(i1);
                if ((localObject2 == null) || (!b((JSONObject)localObject2))) {
                  break label3069;
                }
                if (!((JSONObject)localObject2).has("begin")) {
                  break label3078;
                }
                l1 = ((JSONObject)localObject2).getLong("begin");
                if (!((JSONObject)localObject2).has("end")) {
                  break label3084;
                }
                l2 = ((JSONObject)localObject2).getLong("end");
                l4 = System.currentTimeMillis();
                if ((l1 > l4) || (l4 > l2)) {
                  break label3058;
                }
                label2326:
                localObject1 = new IndividuationConfigInfo.ShapedImgConfig();
                if (!((JSONObject)localObject2).has("reddotBusiness")) {
                  break label3092;
                }
                paramQQAppInterface = ((JSONObject)localObject2).getString("reddotBusiness");
                label2352:
                ((IndividuationConfigInfo.ShapedImgConfig)localObject1).jdField_a_of_type_JavaLangString = paramQQAppInterface;
                if (!((JSONObject)localObject2).has("image")) {
                  break label3097;
                }
                paramQQAppInterface = ((JSONObject)localObject2).getString("image");
                label2373:
                ((IndividuationConfigInfo.ShapedImgConfig)localObject1).jdField_b_of_type_JavaLangString = paramQQAppInterface;
                if (!((JSONObject)localObject2).has("imageId")) {
                  break label3102;
                }
                paramQQAppInterface = ((JSONObject)localObject2).getString("imageId");
                label2396:
                ((IndividuationConfigInfo.ShapedImgConfig)localObject1).c = paramQQAppInterface;
                ((IndividuationConfigInfo.ShapedImgConfig)localObject1).jdField_a_of_type_Long = l1;
                ((IndividuationConfigInfo.ShapedImgConfig)localObject1).jdField_b_of_type_Long = l2;
                if (localIndividuationConfigInfo.jdField_c_of_type_JavaUtilArrayList.size() == 0)
                {
                  localIndividuationConfigInfo.jdField_c_of_type_JavaUtilArrayList.add(localObject1);
                  break label3069;
                }
                int i4 = localIndividuationConfigInfo.jdField_c_of_type_JavaUtilArrayList.size();
                i2 = 0;
                label2450:
                if (i2 >= i4) {
                  break label3069;
                }
                paramQQAppInterface = (IndividuationConfigInfo.ShapedImgConfig)localIndividuationConfigInfo.jdField_c_of_type_JavaUtilArrayList.get(i2);
                if (((IndividuationConfigInfo.ShapedImgConfig)localObject1).jdField_a_of_type_Long <= paramQQAppInterface.jdField_a_of_type_Long)
                {
                  localIndividuationConfigInfo.jdField_c_of_type_JavaUtilArrayList.add(i2, localObject1);
                  break label3069;
                }
                if (i2 + 1 < i4)
                {
                  paramQQAppInterface = (IndividuationConfigInfo.ShapedImgConfig)localIndividuationConfigInfo.jdField_c_of_type_JavaUtilArrayList.get(i2 + 1);
                  if (((IndividuationConfigInfo.ShapedImgConfig)localObject1).jdField_a_of_type_Long > paramQQAppInterface.jdField_a_of_type_Long) {
                    break label3107;
                  }
                  localIndividuationConfigInfo.jdField_c_of_type_JavaUtilArrayList.add(i2 + 1, localObject1);
                  break label3107;
                }
                localIndividuationConfigInfo.jdField_c_of_type_JavaUtilArrayList.add(localObject1);
                break label3107;
              }
            }
          }
          if (localJSONObject.has("holidayImg"))
          {
            paramString = localJSONObject.getJSONArray("holidayImg");
            if ((paramString != null) && (paramString.length() > 0))
            {
              localIndividuationConfigInfo.jdField_c_of_type_JavaUtilHashMap = new HashMap();
              i2 = paramString.length();
              i1 = 0;
              label2618:
              if (i1 < i2)
              {
                localObject2 = paramString.getJSONObject(i1);
                if ((localObject2 == null) || (!b((JSONObject)localObject2)) || (!a((JSONObject)localObject2))) {
                  break label3116;
                }
                localObject1 = new IndividuationConfigInfo.FestivalImgConfig();
                if (!((JSONObject)localObject2).has("reddotBusiness")) {
                  break label3125;
                }
                paramQQAppInterface = ((JSONObject)localObject2).getString("reddotBusiness");
                label2676:
                ((IndividuationConfigInfo.FestivalImgConfig)localObject1).jdField_a_of_type_JavaLangString = paramQQAppInterface;
                if (!((JSONObject)localObject2).has("image")) {
                  break label3130;
                }
              }
            }
          }
        }
      }
    }
    label2806:
    label2829:
    label2871:
    label2876:
    label2884:
    label2893:
    label2902:
    label2908:
    label2917:
    label2927:
    label2932:
    label2938:
    label2944:
    label2950:
    label2956:
    label2961:
    label2970:
    label2975:
    label2980:
    label2985:
    label2994:
    label2999:
    label3004:
    label3009:
    label3014:
    label3019:
    label3024:
    label3029:
    label3036:
    label3043:
    label3050:
    label3058:
    label3069:
    label3078:
    label3084:
    label3092:
    label3097:
    label3102:
    label3107:
    label3116:
    label3125:
    label3130:
    for (paramQQAppInterface = ((JSONObject)localObject2).getString("image");; paramQQAppInterface = null)
    {
      ((IndividuationConfigInfo.FestivalImgConfig)localObject1).jdField_b_of_type_JavaLangString = paramQQAppInterface;
      if (!TextUtils.isEmpty(((IndividuationConfigInfo.FestivalImgConfig)localObject1).jdField_a_of_type_JavaLangString))
      {
        localIndividuationConfigInfo.jdField_c_of_type_JavaUtilHashMap.put(((IndividuationConfigInfo.FestivalImgConfig)localObject1).jdField_a_of_type_JavaLangString, localObject1);
        break label3116;
        if (!localJSONObject.has("vipPayBtnColor")) {
          break label697;
        }
        paramQQAppInterface = localJSONObject.getJSONArray("vipPayBtnColor");
        if ((paramQQAppInterface == null) || (paramQQAppInterface.length() <= 0)) {
          break label697;
        }
        localObject1 = paramQQAppInterface.getJSONObject(0);
        if ((!b((JSONObject)localObject1)) || (!a((JSONObject)localObject1))) {
          break label697;
        }
        paramString = new IndividuationConfigInfo.PayBtnConfig();
        if (((JSONObject)localObject1).has("normal"))
        {
          paramQQAppInterface = ((JSONObject)localObject1).getString("normal");
          paramString.jdField_a_of_type_JavaLangString = paramQQAppInterface;
          if (!((JSONObject)localObject1).has("pressed")) {
            break label2871;
          }
          paramQQAppInterface = ((JSONObject)localObject1).getString("pressed");
          paramString.jdField_b_of_type_JavaLangString = paramQQAppInterface;
          if (!((JSONObject)localObject1).has("textClr")) {
            break label2876;
          }
        }
        for (paramQQAppInterface = ((JSONObject)localObject1).getString("textClr");; paramQQAppInterface = null)
        {
          paramString.c = paramQQAppInterface;
          localIndividuationConfigInfo.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo$PayBtnConfig = paramString;
          break;
          paramQQAppInterface = null;
          break label2806;
          paramQQAppInterface = null;
          break label2829;
        }
        break label1976;
        i1 += 1;
        break label580;
        i1 += 1;
        break;
        i1 = 1;
        break label329;
        i1 += 1;
        break label239;
        paramQQAppInterface = null;
        break label620;
        paramString = null;
        break label854;
        localObject1 = null;
        break label874;
        i2 = 0;
        break label942;
        i2 = 0;
        break label969;
        i2 = 0;
        break label996;
        i2 = 0;
        break label1023;
        paramString = null;
        break label1049;
        i1 += 1;
        break label1319;
        paramQQAppInterface = null;
        break label1202;
        paramQQAppInterface = null;
        break label1229;
        paramQQAppInterface = null;
        break label1258;
        i1 += 1;
        break label1108;
        paramQQAppInterface = null;
        break label1384;
        paramQQAppInterface = null;
        break label1407;
        paramQQAppInterface = null;
        break label1430;
        paramQQAppInterface = null;
        break label1453;
        paramQQAppInterface = null;
        break label1474;
        paramQQAppInterface = null;
        break label1497;
        paramQQAppInterface = null;
        break label1520;
        paramString = "";
        break label2042;
        localObject1 = "";
        break label2062;
        localObject2 = "";
        break label2082;
        localObject3 = "";
        break label2103;
        if (l1 >= l4) {
          break label2326;
        }
        i1 += 1;
        break label2239;
        l1 = 0L;
        break label2283;
        l2 = Long.MAX_VALUE;
        break label2302;
        paramQQAppInterface = null;
        break label2352;
        paramQQAppInterface = null;
        break label2373;
        paramQQAppInterface = null;
        break label2396;
        i2 += 1;
        break label2450;
      }
      i1 += 1;
      break label2618;
      paramQQAppInterface = null;
      break label2676;
    }
  }
  
  public static File a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return null;
    }
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append(AppConstants.bZ).append("index.html");
    return new File(paramQQAppInterface.toString());
  }
  
  private static ArrayList a(JSONArray paramJSONArray)
  {
    Object localObject;
    if ((paramJSONArray == null) || (paramJSONArray.length() <= 0)) {
      localObject = null;
    }
    ArrayList localArrayList;
    for (;;)
    {
      return (ArrayList)localObject;
      localArrayList = new ArrayList(paramJSONArray.length());
      try
      {
        int i2 = paramJSONArray.length();
        int i1 = 0;
        localObject = localArrayList;
        if (i1 < i2)
        {
          JSONObject localJSONObject = paramJSONArray.getJSONObject(i1);
          IndividuationConfigInfo.BizRecommendConfigDetail localBizRecommendConfigDetail;
          if ((localJSONObject != null) && (b(localJSONObject)) && (c(localJSONObject)) && (d(localJSONObject)))
          {
            localBizRecommendConfigDetail = new IndividuationConfigInfo.BizRecommendConfigDetail();
            if (!localJSONObject.has("itemId")) {
              break label294;
            }
            localObject = localJSONObject.getString("itemId");
            label110:
            localBizRecommendConfigDetail.jdField_a_of_type_JavaLangString = ((String)localObject);
            if (!localJSONObject.has("description")) {
              break label299;
            }
            localObject = localJSONObject.getString("description");
            label135:
            localBizRecommendConfigDetail.jdField_b_of_type_JavaLangString = ((String)localObject);
            if (!localJSONObject.has("image")) {
              break label304;
            }
            localObject = localJSONObject.getString("image");
            label158:
            localBizRecommendConfigDetail.d = ((String)localObject);
            if (!localJSONObject.has("cornerMark")) {
              break label309;
            }
            localObject = localJSONObject.getString("cornerMark");
            label183:
            localBizRecommendConfigDetail.c = ((String)localObject);
            if (!localJSONObject.has("head")) {
              break label314;
            }
            localObject = localJSONObject.getString("head");
            label208:
            localBizRecommendConfigDetail.e = ((String)localObject);
            if (!localJSONObject.has("image_bgColor")) {
              break label319;
            }
            localObject = localJSONObject.getString("image_bgColor");
            label233:
            localBizRecommendConfigDetail.f = ((String)localObject);
            if (!localJSONObject.has("url")) {
              break label324;
            }
          }
          label294:
          label299:
          label304:
          label309:
          label314:
          label319:
          label324:
          for (localObject = localJSONObject.getString("url");; localObject = null)
          {
            localBizRecommendConfigDetail.g = ((String)localObject);
            if (TextUtils.isEmpty(localBizRecommendConfigDetail.f)) {
              localBizRecommendConfigDetail.f = "#F2F2F2";
            }
            localArrayList.add(localBizRecommendConfigDetail);
            i1 += 1;
            break;
            localObject = null;
            break label110;
            localObject = null;
            break label135;
            localObject = null;
            break label158;
            localObject = null;
            break label183;
            localObject = null;
            break label208;
            localObject = null;
            break label233;
          }
          if (!QLog.isColorLevel()) {}
        }
      }
      catch (Exception paramJSONArray)
      {
        localObject = localArrayList;
      }
    }
    QLog.e("IndividuationConfigInfo", 2, "convertJsonArray2RecommendConfigList, exception=" + MsfSdkUtils.getStackTraceString(paramJSONArray));
    return localArrayList;
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool3 = true;
    boolean bool4 = true;
    boolean bool5 = true;
    boolean bool1 = true;
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString1)))
    {
      bool1 = true;
      return bool1;
    }
    if ("pendant".equals(paramString1))
    {
      paramQQAppInterface = ((FriendsManager)paramQQAppInterface.getManager(50)).a(paramQQAppInterface.a(), false);
      if ((paramQQAppInterface == null) || (!String.valueOf(paramQQAppInterface.pendantId).equals(paramString2))) {
        break label525;
      }
    }
    label501:
    label507:
    label513:
    label525:
    for (bool1 = true;; bool1 = false)
    {
      return bool1;
      if ("emoji".equals(paramString1))
      {
        paramQQAppInterface = ((EmoticonManager)paramQQAppInterface.getManager(13)).a().iterator();
        do
        {
          if (!paramQQAppInterface.hasNext()) {
            break;
          }
        } while (!((EmoticonPackage)paramQQAppInterface.next()).epId.equals(paramString2));
      }
      for (;;)
      {
        return bool1;
        if ("bubble".equals(paramString1)) {
          if (!String.valueOf(((SVIPHandler)paramQQAppInterface.a(13)).e()).equals(paramString2)) {
            break label513;
          }
        }
        for (bool1 = bool3;; bool1 = false)
        {
          return bool1;
          if ("theme".equals(paramString1))
          {
            paramQQAppInterface = ThemeUtil.getCurrentThemeInfo().getString("themeId");
            bool1 = bool2;
            if (TextUtils.isEmpty(paramQQAppInterface)) {
              break;
            }
            bool1 = bool2;
            if (!paramQQAppInterface.equals(paramString2)) {
              break;
            }
            return true;
          }
          if ("font".equals(paramString1)) {
            if (!String.valueOf(((SVIPHandler)paramQQAppInterface.a(13)).a()).equals(paramString2)) {
              break label507;
            }
          }
          for (bool1 = bool4;; bool1 = false)
          {
            return bool1;
            if ("card".equals(paramString1))
            {
              paramQQAppInterface = ((FriendsManager)paramQQAppInterface.getManager(50)).a(paramQQAppInterface.a());
              bool1 = bool2;
              if (paramQQAppInterface == null) {
                break;
              }
              bool1 = bool2;
              if (!String.valueOf(paramQQAppInterface.lCurrentBgId).equals(paramString2)) {
                break;
              }
              return true;
            }
            if ("call".equals(paramString1)) {
              if (!String.valueOf(VipFunCallManager.a(paramQQAppInterface, paramQQAppInterface.getAccount(), 6, true, null)).equals(paramString2)) {
                break label501;
              }
            }
            for (bool1 = bool5;; bool1 = false)
            {
              return bool1;
              bool1 = bool2;
              if ("suit".equals(paramString1)) {
                break;
              }
              if ("background".equals(paramString1))
              {
                paramQQAppInterface = ((ChatBackgroundManager)paramQQAppInterface.getManager(62)).c(paramQQAppInterface.a());
                bool1 = bool2;
                if (TextUtils.isEmpty(paramQQAppInterface)) {
                  break;
                }
                bool1 = bool2;
                if (!paramQQAppInterface.equals(paramString2)) {
                  break;
                }
                return true;
              }
              if ("ring".equals(paramString1))
              {
                paramQQAppInterface = ((FriendsManager)paramQQAppInterface.getManager(50)).a(paramQQAppInterface.a(), false);
                bool1 = bool2;
                if (paramQQAppInterface == null) {
                  break;
                }
                if (!String.valueOf(paramQQAppInterface.colorRingId).equals(paramString2))
                {
                  bool1 = bool2;
                  if (!String.valueOf(paramQQAppInterface.commingRingId).equals(paramString2)) {
                    break;
                  }
                }
                return true;
              }
              bool1 = bool2;
              if ("hongbao".equals(paramString1)) {
                break;
              }
              return true;
            }
          }
        }
        bool1 = false;
      }
    }
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    do
    {
      return false;
      paramString1 = paramString1.split("\\.");
      paramString2 = paramString2.split("\\.");
    } while ((paramString1 == null) || (paramString2 == null));
    int i4 = Math.max(paramString1.length, paramString2.length);
    int i3 = 0;
    label52:
    if (i3 < i4) {
      if (i3 >= paramString1.length) {
        break label157;
      }
    }
    for (;;)
    {
      try
      {
        i1 = Integer.parseInt(paramString1[i3]);
        if (i3 >= paramString2.length) {
          break label151;
        }
      }
      catch (Exception localException1)
      {
        try
        {
          i2 = Integer.parseInt(paramString2[i3]);
          if (i3 == i4 - 1) {
            break label135;
          }
          if (i2 > i1)
          {
            return true;
            localException1 = localException1;
            i1 = 0;
          }
        }
        catch (Exception localException2)
        {
          i2 = 0;
          continue;
        }
      }
      if (i2 < i1) {
        break;
      }
      label135:
      do
      {
        i3 += 1;
        break label52;
        break;
        if (i2 >= i1) {
          return true;
        }
      } while (i2 >= i1);
      return false;
      label151:
      int i2 = 0;
      continue;
      label157:
      int i1 = 0;
    }
  }
  
  private static boolean a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return false;
    }
    long l1;
    long l2;
    if (paramJSONObject.has("begin"))
    {
      l1 = paramJSONObject.getLong("begin");
      if (!paramJSONObject.has("end")) {
        break label72;
      }
      l2 = paramJSONObject.getLong("end");
      label42:
      long l3 = System.currentTimeMillis();
      if ((l3 < l1) || (l3 > l2)) {
        break label79;
      }
    }
    label72:
    label79:
    for (boolean bool = true;; bool = false)
    {
      return bool;
      l1 = 0L;
      break;
      l2 = Long.MAX_VALUE;
      break label42;
    }
  }
  
  private static final boolean b(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return false;
    }
    if (!paramJSONObject.has("isDisplay")) {
      return true;
    }
    Object localObject = null;
    try
    {
      paramJSONObject = paramJSONObject.getString("isDisplay");
      return "1".equals(paramJSONObject);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramJSONObject = (JSONObject)localObject;
        if (QLog.isColorLevel())
        {
          QLog.e("IndividuationConfigInfo", 2, "shouldDisplay, exception=" + MsfSdkUtils.getStackTraceString(localException));
          paramJSONObject = (JSONObject)localObject;
        }
      }
    }
  }
  
  private static boolean c(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    do
    {
      return false;
      if (!paramJSONObject.has("platformId")) {
        return true;
      }
      try
      {
        paramJSONObject = paramJSONObject.getString("platformId");
        if (TextUtils.isEmpty("platformId")) {
          return true;
        }
        i1 = Byte.parseByte(paramJSONObject);
      }
      catch (Exception paramJSONObject)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("IndividuationConfigInfo", 2, "isConfigForAndroid, exception=" + MsfSdkUtils.getStackTraceString(paramJSONObject));
          }
          int i1 = -1;
        }
      }
    } while ((i1 != 0) && (i1 != 2));
    return true;
  }
  
  private static boolean d(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (;;)
    {
      return false;
      if ((!paramJSONObject.has("startVers")) && (!paramJSONObject.has("endVers"))) {
        return true;
      }
      try
      {
        if (paramJSONObject.has("startVers"))
        {
          String str = paramJSONObject.getString("startVers");
          if ((!TextUtils.isEmpty(str)) && (!a(str, "6.5.5"))) {}
        }
        else if (paramJSONObject.has("endVers"))
        {
          paramJSONObject = paramJSONObject.getString("endVers");
          if (!TextUtils.isEmpty(paramJSONObject))
          {
            boolean bool = a("6.5.5", paramJSONObject);
            if (!bool) {
              continue;
            }
          }
        }
      }
      catch (Exception paramJSONObject)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("IndividuationConfigInfo", 2, "isValidVersion, exception=" + MsfSdkUtils.getStackTraceString(paramJSONObject));
          }
        }
      }
    }
    return true;
  }
  
  public IndividuationConfigInfo.ShapedImgConfig a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null) {
      return null;
    }
    this.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo$ShapedImgConfig = null;
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_b_of_type_JavaUtilHashMap != null) && (this.jdField_b_of_type_JavaUtilHashMap.containsKey(paramString))) {
      this.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo$ShapedImgConfig = null;
    }
    label206:
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("IndividuationConfigInfo", 2, "updateCurrentShapeImgConfig, currentRedpointBiz=" + paramString + ", currentShapeImgConfig=" + this.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo$ShapedImgConfig);
      }
      return this.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo$ShapedImgConfig;
      if ((this.jdField_c_of_type_JavaUtilArrayList != null) && (this.jdField_c_of_type_JavaUtilArrayList.size() > 0))
      {
        int i2 = this.jdField_c_of_type_JavaUtilArrayList.size();
        int i1 = 0;
        for (;;)
        {
          if (i1 >= i2) {
            break label206;
          }
          IndividuationConfigInfo.ShapedImgConfig localShapedImgConfig = (IndividuationConfigInfo.ShapedImgConfig)this.jdField_c_of_type_JavaUtilArrayList.get(i1);
          if ((localShapedImgConfig != null) && (this.jdField_b_of_type_JavaUtilHashMap != null) && (this.jdField_b_of_type_JavaUtilHashMap.containsKey(localShapedImgConfig.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(localShapedImgConfig.c)) && (!a(paramQQAppInterface, localShapedImgConfig.jdField_a_of_type_JavaLangString, localShapedImgConfig.c)))
          {
            this.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo$ShapedImgConfig = localShapedImgConfig;
            break;
          }
          i1 += 1;
        }
      }
    }
  }
  
  public String a(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject1 = null;
    Object localObject3 = null;
    Object localObject2 = localObject3;
    if (paramQQAppInterface != null)
    {
      if (!TextUtils.isEmpty(paramString)) {
        break label27;
      }
      localObject2 = localObject3;
    }
    label27:
    do
    {
      do
      {
        do
        {
          return (String)localObject2;
          paramQQAppInterface = (QQAppInterface)localObject1;
          if (this.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo$ShapedImgConfig != null)
          {
            paramQQAppInterface = (QQAppInterface)localObject1;
            if (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo$ShapedImgConfig.jdField_a_of_type_JavaLangString)) {
              paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo$ShapedImgConfig.jdField_b_of_type_JavaLangString;
            }
          }
          localObject1 = paramQQAppInterface;
          if (TextUtils.isEmpty(paramQQAppInterface))
          {
            localObject1 = paramQQAppInterface;
            if (this.jdField_c_of_type_JavaUtilHashMap != null)
            {
              localObject1 = paramQQAppInterface;
              if (this.jdField_c_of_type_JavaUtilHashMap.containsKey(paramString)) {
                localObject1 = ((IndividuationConfigInfo.FestivalImgConfig)this.jdField_c_of_type_JavaUtilHashMap.get(paramString)).jdField_b_of_type_JavaLangString;
              }
            }
          }
          localObject2 = localObject1;
        } while (!TextUtils.isEmpty((CharSequence)localObject1));
        localObject2 = localObject1;
      } while (this.jdField_b_of_type_JavaUtilHashMap == null);
      localObject2 = localObject1;
    } while (!this.jdField_b_of_type_JavaUtilHashMap.containsKey(paramString));
    return ((IndividuationConfigInfo.ButtonConfig)this.jdField_b_of_type_JavaUtilHashMap.get(paramString)).jdField_b_of_type_JavaLangString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("IndividuationConfigInfo: ").append("backgroudImgUrl=").append(this.o).append("\r\n").append("pullBgColor=").append(this.q).append("\r\n").append("bannerConfig=").append(this.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo$BannerConfig).append("\r\n").append("activityConfigs=").append(this.jdField_a_of_type_JavaUtilArrayList).append("\r\n").append("recommendConfigs=").append(this.jdField_b_of_type_JavaUtilArrayList).append("\r\n").append("shapedImgConfigs=").append(this.jdField_c_of_type_JavaUtilArrayList);
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vas\IndividuationConfigInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */