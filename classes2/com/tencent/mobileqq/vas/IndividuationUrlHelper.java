package com.tencent.mobileqq.vas;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

public final class IndividuationUrlHelper
{
  private static final String A = "http://imgcache.qq.com/qqshow/admindata/comdata/vipfont_[id]/aio.png";
  private static final String B = "http://imgcache.qq.com/club/themes/mobile/act/2014/actTpl/html/home.html?app=vipActTpl_mobile_widgetLink";
  private static final String C = "http://imgcache.qq.com/club/themes/mobile/act/2014/actTpl/html/home.html?app=gjjbzh&type=1&_wv=1025";
  private static final String D = "http://imgcache.qq.com/qqshow/admindata/comdata/vipList_signature_data/xydata.json";
  private static final String E = "http://imgcache.qq.com/club/themes/mobile/bq/html/category.html?uin=[uin]&platformId=[platformId]&client=[client]&_lv=0&name=魔法表情&system=[system]&systemInt=[systemInt]&device=[device]&adtag=[adtag]&version=[version]&_bid=102&key=011&_wv=3";
  private static final String F = "http://imgcache.qq.com/qqshow/admindata/comdata/viptheme_DIY_theme/";
  private static final String G = "http://imgcache.qq.com/club/client/card/rel/active.html?_bid=238&bgId=%1$s&ADTAG=inside.myCardBackground&_wv=5123";
  private static final String H = "http://imgcache.qq.com/club/item/parcel/json/keyword_2.json";
  private static final String I = "http://imgcache.qq.com/qqshow/admindata/comdata/vipRing_item_[id]/[id]_2.mp3";
  private static final String J = "http://imgcache.qq.com/qqshow/admindata/comdata/vipRing_item_[id]/preview.jpg";
  private static final String K = "http://imgcache.qq.com/qqshow/admindata/comdata/vipRing_item_[id]/config.json";
  private static final String L = "http://imgcache.qq.com/club/themes/mobile/font/myfont/html/myfont.html?_wv=3";
  private static final String M;
  private static final String N;
  private static final String O = "http://imgcache.qq.com/club/themes/mobile/qutu/html/index.html?_wv=3&_bid=2196";
  private static final String P = "http://imgcache.qq.com/club/themes/mobile/funcall/html/mine.html?_wv=5123&_bid=2382";
  private static final String Q = "0";
  private static final String R = "2";
  private static final int jdField_a_of_type_Int = 1;
  public static final String a = "IndividuationUrlHelper";
  public static HashMap a;
  private static Map jdField_a_of_type_JavaUtilMap;
  private static final boolean jdField_a_of_type_Boolean = true;
  private static final int jdField_b_of_type_Int = 2;
  private static final String jdField_b_of_type_JavaLangString;
  private static Map jdField_b_of_type_JavaUtilMap;
  private static final int jdField_c_of_type_Int = 4;
  private static final String jdField_c_of_type_JavaLangString;
  private static Map jdField_c_of_type_JavaUtilMap;
  private static final String d;
  private static final String e;
  private static final String f;
  private static final String g;
  private static final String h;
  private static final String i;
  private static final String j;
  private static final String k;
  private static final String l;
  private static final String m;
  private static final String n;
  private static final String o;
  private static final String p;
  private static final String q;
  private static final String r;
  private static final String s;
  private static final String t;
  private static final String u;
  private static final String v;
  private static final String w;
  private static final String x;
  private static final String y;
  private static final String z = "http://imgcache.qq.com/club/mobile/profile/template/summary_card_word.json";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("uin=[uin]").append("&client=androidQQ").append("&version=").append("6.5.5.2880").append("&platformId=2").append("&device=").append(Build.DEVICE).append("&system=").append(Build.VERSION.RELEASE).append("&density=[density]");
    x = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder("http://imgcache.qq.com/club/themes/mobile/theme_new/html/index.html");
    ((StringBuilder)localObject).append("?").append(x).append("&_bid=2034").append("&_wv=1027").append("&asyncMode=1");
    jdField_b_of_type_JavaLangString = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder("http://imgcache.qq.com/club/themes/mobile/theme_new/html/detail.html");
    ((StringBuilder)localObject).append("?").append(x).append("&_bid=2034").append("&_wv=1027").append("&id=[id]");
    jdField_c_of_type_JavaLangString = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder("http://imgcache.qq.com/club/themes/mobile/bubble/html/index.html");
    ((StringBuilder)localObject).append("?").append(x).append("&_bid=122").append("&_wv=1027").append("&asyncMode=1");
    d = ((StringBuilder)localObject).toString();
    e = "&show_type=dialog&id=[id]";
    localObject = new StringBuilder("http://imgcache.qq.com/club/themes/mobile/bq/html/index.html");
    ((StringBuilder)localObject).append("?").append(x).append("&_wv=1027").append("&_bid=102");
    f = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder("http://imgcache.qq.com/club/themes/mobile/bq/html/detail.html");
    ((StringBuilder)localObject).append("?").append(x).append("&_wv=16778241").append("&_bid=102").append("&type=view").append("&id=[id]");
    g = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder("http://imgcache.qq.com/club/themes/mobile/bq/html/author.html");
    ((StringBuilder)localObject).append("?").append(x).append("&_wv=3").append("&_bid=102").append("&type=view").append("&id=[id]");
    h = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder("http://imgcache.qq.com/club/themes/mobile/head_pendant/html/index.html");
    ((StringBuilder)localObject).append("?").append(x).append("&_bid=160").append("&_wv=3").append("&asyncMode=1");
    i = ((StringBuilder)localObject).toString();
    j = "&show_type=dialog&id=[id]";
    localObject = new StringBuilder("http://imgcache.qq.com/club/themes/mobile/font/index.html");
    ((StringBuilder)localObject).append("?").append(x).append("&_bid=182").append("&_wv=1027").append("&asyncMode=1");
    k = ((StringBuilder)localObject).toString();
    l = "&show_type=dialog&id=[id]";
    localObject = new StringBuilder("http://imgcache.qq.com/club/themes/mobile/suit/index.html");
    ((StringBuilder)localObject).append("?").append(x).append("&_bid=239").append("&_wv=5123");
    m = ((StringBuilder)localObject).toString();
    n = "&id=[id]";
    localObject = new StringBuilder("http://imgcache.qq.com/club/themes/mobile/color_ring/index.html");
    ((StringBuilder)localObject).append("?").append(x).append("&_bid=293").append("&_wv=1027");
    o = ((StringBuilder)localObject).toString();
    p = "&id=[id]";
    q = "http://imgcache.qq.com/club/themes/mobile/red_pack/index.html?_bid=2330&_wv=1031&from=[from]";
    localObject = new StringBuilder("http://imgcache.qq.com/club/themes/mobile/chat_background/index.html");
    ((StringBuilder)localObject).append("?").append(x).append("&_bid=310").append("&_wv=1027");
    r = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder("http://imgcache.qq.com/club/themes/mobile/chat_background/preview.html");
    ((StringBuilder)localObject).append("?").append(x).append("&_bid=310").append("&_wv=16782339").append("&bgId=[id]");
    s = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder("http://imgcache.qq.com/club/themes/mobile/funcall/html/index.html");
    ((StringBuilder)localObject).append("?").append(x).append("&_bid=2382").append("&_wv=5123");
    t = ((StringBuilder)localObject).toString();
    u = "&id=[id]";
    localObject = new StringBuilder("http://imgcache.qq.com/club/client/card/rel/mall_v54.html?");
    ((StringBuilder)localObject).append("&_bid=238").append("&closeSpecialLogic=1").append("&isCache=1").append("&entryId=2").append("&tabId=1").append("&_wv=5123");
    v = ((StringBuilder)localObject).toString();
    w = "&id=[id]";
    localObject = new StringBuilder("http://gxh.vip.qq.com/club/themes/mobile/bq/html/category.html?");
    ((StringBuilder)localObject).append("adtag=vip.gongneng.mobile.biaoqing.index").append("&_bid=102&_lv=0").append("&key=012").append("&name=%E5%B0%8F%E8%A1%A8%E6%83%85").append("&src=category_list&_wv=1027");
    y = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder("http://imgcache.qq.com/club/themes/mobile/my_dress/index.html");
    ((StringBuilder)localObject).append("?uin=[uin]").append("&client=androidQQ").append("&version=").append("6.5.5.2880").append("&platformId=2").append("&device=").append(Build.DEVICE).append("&system=").append(Build.VERSION.RELEASE).append("&density=[density]").append("&_bid=182").append("&_wv=3");
    M = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder("http://imgcache.qq.com/club/themes/mobile/search/html/index.html");
    ((StringBuilder)localObject).append("?uin=[uin]").append("&client=androidQQ").append("&version=").append("6.5.5.2880").append("&platformId=2").append("&device=").append(Build.DEVICE).append("&system=").append(Build.VERSION.RELEASE).append("&density=[density]").append("&adtag=mvip.gxh.android.search").append("&_bid=2229").append("&_wv=1027");
    N = ((StringBuilder)localObject).toString();
    jdField_a_of_type_JavaUtilMap = new HashMap();
    jdField_b_of_type_JavaUtilMap = new HashMap();
    jdField_c_of_type_JavaUtilMap = new HashMap();
    jdField_c_of_type_JavaUtilMap.put("bubble", d);
    jdField_c_of_type_JavaUtilMap.put("theme", jdField_b_of_type_JavaLangString);
    jdField_c_of_type_JavaUtilMap.put("pendant", i);
    jdField_c_of_type_JavaUtilMap.put("emoji", f);
    jdField_c_of_type_JavaUtilMap.put("font", k);
    jdField_c_of_type_JavaUtilMap.put("suit", m);
    jdField_c_of_type_JavaUtilMap.put("background", r);
    jdField_c_of_type_JavaUtilMap.put("ring", o);
    jdField_c_of_type_JavaUtilMap.put("hongbao", q);
    jdField_c_of_type_JavaUtilMap.put("card", v);
    jdField_c_of_type_JavaUtilMap.put("call", t);
    jdField_c_of_type_JavaUtilMap.put("bubbleDetail", e);
    jdField_c_of_type_JavaUtilMap.put("themeDetail", jdField_c_of_type_JavaLangString);
    jdField_c_of_type_JavaUtilMap.put("pendantDetail", j);
    jdField_c_of_type_JavaUtilMap.put("emojiDetail", g);
    jdField_c_of_type_JavaUtilMap.put("emojiAuthorDetail", h);
    jdField_c_of_type_JavaUtilMap.put("fontDetail", l);
    jdField_c_of_type_JavaUtilMap.put("suitDetail", n);
    jdField_c_of_type_JavaUtilMap.put("backgroundDetail", s);
    jdField_c_of_type_JavaUtilMap.put("ringDetail", p);
    jdField_c_of_type_JavaUtilMap.put("cardDetail", w);
    jdField_c_of_type_JavaUtilMap.put("callDetail", u);
    jdField_c_of_type_JavaUtilMap.put("cardWord", "http://imgcache.qq.com/club/mobile/profile/template/summary_card_word.json");
    jdField_c_of_type_JavaUtilMap.put("fontAioImg", "http://imgcache.qq.com/qqshow/admindata/comdata/vipfont_[id]/aio.png");
    jdField_c_of_type_JavaUtilMap.put("linkPendantSet", "http://imgcache.qq.com/club/themes/mobile/act/2014/actTpl/html/home.html?app=vipActTpl_mobile_widgetLink");
    jdField_c_of_type_JavaUtilMap.put("rarePendantActivity", "http://imgcache.qq.com/club/themes/mobile/act/2014/actTpl/html/home.html?app=gjjbzh&type=1&_wv=1025");
    jdField_c_of_type_JavaUtilMap.put("signatureTemplate", "http://imgcache.qq.com/qqshow/admindata/comdata/vipList_signature_data/xydata.json");
    jdField_c_of_type_JavaUtilMap.put("magicPlus", "http://imgcache.qq.com/club/themes/mobile/bq/html/category.html?uin=[uin]&platformId=[platformId]&client=[client]&_lv=0&name=魔法表情&system=[system]&systemInt=[systemInt]&device=[device]&adtag=[adtag]&version=[version]&_bid=102&key=011&_wv=3");
    jdField_c_of_type_JavaUtilMap.put("themeDiy", "http://imgcache.qq.com/qqshow/admindata/comdata/viptheme_DIY_theme/");
    jdField_c_of_type_JavaUtilMap.put("rareCard", "http://imgcache.qq.com/club/client/card/rel/active.html?_bid=238&bgId=%1$s&ADTAG=inside.myCardBackground&_wv=5123");
    jdField_c_of_type_JavaUtilMap.put("emoticonKeyword", "http://imgcache.qq.com/club/item/parcel/json/keyword_2.json");
    jdField_c_of_type_JavaUtilMap.put("colorringAudio", "http://imgcache.qq.com/qqshow/admindata/comdata/vipRing_item_[id]/[id]_2.mp3");
    jdField_c_of_type_JavaUtilMap.put("colorringCover", "http://imgcache.qq.com/qqshow/admindata/comdata/vipRing_item_[id]/preview.jpg");
    jdField_c_of_type_JavaUtilMap.put("colorringConfig", "http://imgcache.qq.com/qqshow/admindata/comdata/vipRing_item_[id]/config.json");
    jdField_c_of_type_JavaUtilMap.put("myFont", "http://imgcache.qq.com/club/themes/mobile/font/myfont/html/myfont.html?_wv=3");
    jdField_c_of_type_JavaUtilMap.put("myIndividuation", M);
    jdField_c_of_type_JavaUtilMap.put("individuationSearch", N);
    jdField_c_of_type_JavaUtilMap.put("funnyPic", "http://imgcache.qq.com/club/themes/mobile/qutu/html/index.html?_wv=3&_bid=2196");
    jdField_c_of_type_JavaUtilMap.put("funCallMine", "http://imgcache.qq.com/club/themes/mobile/funcall/html/mine.html?_wv=5123&_bid=2382");
    jdField_c_of_type_JavaUtilMap.put("smallEmojiList", y);
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    localObject = new IndividuationUrlHelper.MarketParams("2034", "1027");
    jdField_a_of_type_JavaUtilHashMap.put("theme", localObject);
    jdField_a_of_type_JavaUtilHashMap.put("themeDetail", localObject);
    localObject = new IndividuationUrlHelper.MarketParams("122", "1027");
    jdField_a_of_type_JavaUtilHashMap.put("bubble", localObject);
    jdField_a_of_type_JavaUtilHashMap.put("bubbleDetail", localObject);
    localObject = new IndividuationUrlHelper.MarketParams("102", "1027");
    jdField_a_of_type_JavaUtilHashMap.put("emoji", localObject);
    localObject = new IndividuationUrlHelper.MarketParams("102", "16778241");
    jdField_a_of_type_JavaUtilHashMap.put("emojiDetail", localObject);
    localObject = new IndividuationUrlHelper.MarketParams("102", "3");
    jdField_a_of_type_JavaUtilHashMap.put("emojiAuthorDetail", localObject);
    jdField_a_of_type_JavaUtilHashMap.put("magicPlus", localObject);
    localObject = new IndividuationUrlHelper.MarketParams("160", "3");
    jdField_a_of_type_JavaUtilHashMap.put("pendant", localObject);
    jdField_a_of_type_JavaUtilHashMap.put("pendantDetail", localObject);
    localObject = new IndividuationUrlHelper.MarketParams("182", "1027");
    jdField_a_of_type_JavaUtilHashMap.put("font", localObject);
    jdField_a_of_type_JavaUtilHashMap.put("fontDetail", localObject);
    localObject = new IndividuationUrlHelper.MarketParams("239", "5123");
    jdField_a_of_type_JavaUtilHashMap.put("suit", localObject);
    jdField_a_of_type_JavaUtilHashMap.put("suitDetail", localObject);
    localObject = new IndividuationUrlHelper.MarketParams("293", "1027");
    jdField_a_of_type_JavaUtilHashMap.put("ring", localObject);
    jdField_a_of_type_JavaUtilHashMap.put("ringDetail", localObject);
    localObject = new IndividuationUrlHelper.MarketParams("", "16778247");
    jdField_a_of_type_JavaUtilHashMap.put("hongbao", localObject);
    localObject = new IndividuationUrlHelper.MarketParams("310", "1027");
    jdField_a_of_type_JavaUtilHashMap.put("background", localObject);
    jdField_a_of_type_JavaUtilHashMap.put("backgroundDetail", localObject);
    localObject = new IndividuationUrlHelper.MarketParams("313", "5123");
    jdField_a_of_type_JavaUtilHashMap.put("call", localObject);
    jdField_a_of_type_JavaUtilHashMap.put("callDetail", localObject);
    localObject = new IndividuationUrlHelper.MarketParams("238", "5123");
    jdField_a_of_type_JavaUtilHashMap.put("card", localObject);
    jdField_a_of_type_JavaUtilHashMap.put("cardDetail", localObject);
    localObject = new IndividuationUrlHelper.MarketParams("2229", "1027");
    jdField_a_of_type_JavaUtilHashMap.put("individuationSearch", localObject);
    localObject = new IndividuationUrlHelper.MarketParams("182", "3");
    jdField_a_of_type_JavaUtilHashMap.put("myIndividuation", localObject);
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    return b(paramContext, a(paramString1), paramString2);
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    return b(paramContext, a(paramString1), paramString2, paramString3);
  }
  
  public static String a(String paramString)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      do
      {
        return (String)localObject2;
        localObject2 = localObject1;
        if (jdField_a_of_type_JavaUtilMap.containsKey(paramString))
        {
          localObject1 = (String)jdField_a_of_type_JavaUtilMap.get(paramString);
          localObject2 = localObject1;
          if (QLog.isColorLevel())
          {
            QLog.d("IndividuationUrlHelper", 2, "getUrl, from config, id=" + paramString + ", url=" + (String)localObject1);
            localObject2 = localObject1;
          }
        }
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject2 = (String)jdField_b_of_type_JavaUtilMap.get(paramString);
          localObject1 = localObject2;
          if (QLog.isColorLevel())
          {
            QLog.d("IndividuationUrlHelper", 2, "getUrl, from default, id=" + paramString + ", url=" + (String)localObject2);
            localObject1 = localObject2;
          }
        }
        localObject2 = localObject1;
      } while (!TextUtils.isEmpty((CharSequence)localObject1));
      localObject1 = a(BaseApplicationImpl.a.a(), (String)jdField_c_of_type_JavaUtilMap.get(paramString), paramString);
      localObject2 = localObject1;
    } while (!QLog.isColorLevel());
    QLog.d("IndividuationUrlHelper", 2, "getUrl, from raw default, id=" + paramString + ", url=" + (String)localObject1);
    return (String)localObject1;
  }
  
  private static String a(AppRuntime paramAppRuntime, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return paramString1;
    }
    localObject = paramString1;
    for (;;)
    {
      try
      {
        paramString1 = paramString1.replace("[client]", "androidQQ");
        localObject = paramString1;
        paramString1 = paramString1.replace("[version]", "6.5.5.2880");
        localObject = paramString1;
        paramString1 = paramString1.replace("[platformId]", "2");
        localObject = paramString1;
        paramString1 = paramString1.replace("[device]", URLEncoder.encode(Build.DEVICE, "UTF-8"));
        localObject = paramString1;
        paramString1 = paramString1.replace("[system]", URLEncoder.encode(Build.VERSION.RELEASE, "UTF-8"));
        AppRuntime localAppRuntime = paramAppRuntime;
        if (paramAppRuntime == null) {}
        try
        {
          localAppRuntime = BaseApplicationImpl.a.a();
          if (localAppRuntime != null)
          {
            paramAppRuntime = paramString1.replace("[uin]", localAppRuntime.getAccount());
            localObject = paramAppRuntime;
            paramString1 = paramAppRuntime.replace("[density]", ThemeUtil.getThemeDensity(localAppRuntime.getApplication()));
            return paramString1;
          }
          QLog.e("IndividuationUrlHelper", 1, String.format("replaceCommonParams null == app, url=%s, urlId=%s", new Object[] { paramString1, paramString2 }));
          continue;
        }
        catch (Exception paramAppRuntime) {}
      }
      catch (Exception paramAppRuntime)
      {
        paramString1 = (String)localObject;
        continue;
      }
      tmp175_172[0] = paramString1;
      Object[] tmp179_175 = tmp175_172;
      tmp179_175[1] = paramString2;
      Object[] tmp183_179 = tmp179_175;
      tmp183_179[2] = MsfSdkUtils.getStackTraceString(paramAppRuntime);
      QLog.e("IndividuationUrlHelper", 1, String.format("replaceCommonParams, url=%s, urlId=%s, exception=%s", tmp183_179));
    }
  }
  
  public static Map a()
  {
    return jdField_a_of_type_JavaUtilMap;
  }
  
  public static void a(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null) {}
    Object localObject1;
    Object localObject2;
    String str1;
    for (;;)
    {
      try
      {
        QLog.e("IndividuationUrlHelper", 1, "parseJson, app null");
        return;
      }
      finally {}
      long l1 = System.currentTimeMillis();
      jdField_a_of_type_JavaUtilMap.clear();
      jdField_b_of_type_JavaUtilMap.clear();
      localObject1 = jdField_c_of_type_JavaUtilMap.entrySet().iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        str1 = (String)((Map.Entry)localObject2).getKey();
        localObject2 = a(paramAppRuntime, (String)((Map.Entry)localObject2).getValue(), str1);
        jdField_b_of_type_JavaUtilMap.put(str1, localObject2);
      }
      else
      {
        localObject1 = new File(paramAppRuntime.getApplication().getFilesDir(), ClubContentJsonTask.b.jdField_b_of_type_JavaLangString);
        if (localObject1 == null) {
          break label744;
        }
        boolean bool = ((File)localObject1).exists();
        if (!bool) {
          break label744;
        }
        try
        {
          localObject1 = FileUtils.a((File)localObject1);
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label732;
          }
          localObject1 = new JSONArray((String)localObject1);
          if ((localObject1 != null) && (((JSONArray)localObject1).length() >= 1)) {
            break;
          }
          QLog.e("IndividuationUrlHelper", 1, "parseJson, no IndividuationAddress element");
        }
        catch (Exception paramAppRuntime)
        {
          QLog.e("IndividuationUrlHelper", 1, "parseJson, exception=" + MsfSdkUtils.getStackTraceString(paramAppRuntime));
        }
        label230:
        if (!QLog.isColorLevel()) {
          break label754;
        }
        QLog.d("IndividuationUrlHelper", 2, "parseJson, duration=" + (System.currentTimeMillis() - l1));
      }
    }
    int i4 = ((JSONArray)localObject1).length();
    int i2 = 0;
    label279:
    String str2;
    int i3;
    int i1;
    int i5;
    if (i2 < i4)
    {
      localObject2 = ((JSONArray)localObject1).getJSONObject(i2);
      str1 = ((JSONObject)localObject2).optString("business");
      str2 = ((JSONObject)localObject2).optString("url");
      if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)))
      {
        QLog.e("IndividuationUrlHelper", 1, "parseJson, config error, no business or url, config=" + localObject2);
      }
      else
      {
        if (!((JSONObject)localObject2).has("userType")) {
          break label781;
        }
        i3 = ((JSONObject)localObject2).getInt("userType");
        i1 = 1;
        if (i3 != -1)
        {
          i1 = 1;
          i5 = VipUtils.a(paramAppRuntime, null);
          if ((i5 & 0x4) == 0) {
            break label787;
          }
          i1 = 4;
          break label765;
        }
      }
    }
    for (;;)
    {
      label405:
      if (i1 != 0)
      {
        i3 = 1;
        i1 = i3;
        String str3;
        if (((JSONObject)localObject2).has("minVersion"))
        {
          str3 = ((JSONObject)localObject2).getString("minVersion");
          i1 = i3;
          if (!TextUtils.isEmpty(str3))
          {
            i1 = i3;
            if (!IndividuationConfigInfo.a(str3, "6.5.5")) {
              i1 = 0;
            }
          }
        }
        i3 = i1;
        if (i1 != 0)
        {
          i3 = i1;
          if (((JSONObject)localObject2).has("maxVersion"))
          {
            str3 = ((JSONObject)localObject2).getString("maxVersion");
            i3 = i1;
            if (!TextUtils.isEmpty(str3))
            {
              i3 = i1;
              if (!IndividuationConfigInfo.a("6.5.5", str3)) {
                i3 = 0;
              }
            }
          }
        }
        if (i3 != 0)
        {
          str3 = paramAppRuntime.getAccount();
          i1 = ((JSONObject)localObject2).optInt("startIndex");
          i3 = ((JSONObject)localObject2).optInt("endIndex");
          if (i1 >= i3)
          {
            i5 = str3.length();
            if ((i5 >= i1) && (i5 >= i3))
            {
              long l2 = Long.parseLong(str3.substring(i5 - i1, i5 - i3 + 1));
              long l3 = ((JSONObject)localObject2).optLong("min");
              long l4 = ((JSONObject)localObject2).optLong("max");
              if ((l2 >= l3) && (l2 <= l4))
              {
                localObject2 = a(paramAppRuntime, str2, str1);
                jdField_a_of_type_JavaUtilMap.put(str1, localObject2);
              }
            }
            else
            {
              QLog.e("IndividuationUrlHelper", 1, "parseJson, index config error, uin length=" + i5 + ", config=" + localObject2);
            }
          }
          else
          {
            QLog.e("IndividuationUrlHelper", 1, "parseJson, startIndex < endIndex, element=" + localObject2);
            break label756;
            label732:
            QLog.e("IndividuationUrlHelper", 1, "parseJson, jsonStr null");
            break label230;
            label744:
            QLog.e("IndividuationUrlHelper", 1, "parseJson, no json file");
            break label230;
            label754:
            break;
          }
        }
      }
      label756:
      i2 += 1;
      break label279;
      break label230;
      for (;;)
      {
        label765:
        if ((i3 & i1) != i1) {
          break label800;
        }
        i1 = 1;
        break label405;
        label781:
        i3 = -1;
        break;
        label787:
        if ((i5 & 0x2) != 0) {
          i1 = 2;
        }
      }
      label800:
      i1 = 0;
    }
  }
  
  private static String b(Context paramContext, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("IndividuationUrlHelper", 2, "decodeMarketUrl:" + paramString1);
    }
    if (TextUtils.isEmpty(paramString1)) {
      paramContext = null;
    }
    do
    {
      return paramContext;
      paramContext = paramString1;
    } while (TextUtils.isEmpty(paramString2));
    return paramString1 + "&adtag=" + paramString2;
  }
  
  private static String b(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      paramContext = null;
    }
    do
    {
      return paramContext;
      if (QLog.isColorLevel()) {
        QLog.i("IndividuationUrlHelper", 2, "decodeMarketDetailUrl:" + paramString1 + ", id=" + paramString2);
      }
      paramString1 = b(paramContext, paramString1, paramString3);
      paramContext = paramString1;
    } while (TextUtils.isEmpty(paramString1));
    return paramString1.replace("[id]", paramString2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vas\IndividuationUrlHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */