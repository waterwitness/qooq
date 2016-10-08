package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.widget.Toast;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.DcReportUtil;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.webview.swift.WebViewPluginFactory;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.VipComicReportUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import wfp;

public class VasWebviewUtil
{
  public static final String SP_PARSE_ASYNC_COOKIE = "read_vas_asyncCookie";
  public static final String TAG = "VasWebviewUtil";
  public static ConcurrentHashMap mAsyncCookiesForVas = new ConcurrentHashMap();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static String decodeUrl(Context paramContext, String paramString, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VasWebviewUtil", 2, "decodeUrl:" + paramString);
    }
    String str1 = paramString.replace("[uin]", BaseApplicationImpl.a.a().getAccount()).replace("[client]", "androidQQ").replace("[version]", "6.5.5.2880").replace("[platformId]", "2").replace("[device]", Build.DEVICE).replace("[system]", Build.VERSION.RELEASE);
    String str2 = paramIntent.getStringExtra("updateTime");
    paramString = str1;
    if (str2 != null)
    {
      paramString = str1;
      if (str2.length() > 0) {
        paramString = str1.replace("[updateTime]", str2);
      }
    }
    String str3 = paramIntent.getStringExtra("adTag");
    str1 = paramString;
    if (str2 != null)
    {
      str1 = paramString;
      if (str2.length() > 0) {
        str1 = paramString.replace("[adTag]", str3);
      }
    }
    paramContext = str1.replace("[updateFlag]", Boolean.valueOf(paramIntent.getBooleanExtra("updateFlag", false)).toString()).replace("[updateId]", "" + paramIntent.getIntExtra("updateId", 0)).replace("[density]", ThemeUtil.getThemeDensity(paramContext));
    int i = paramIntent.getIntExtra("bubbleId", -1);
    paramString = paramContext;
    if (i != -1)
    {
      paramString = paramContext;
      if (paramIntent.getBooleanExtra("fromAIO", false)) {
        paramString = paramContext + "&id=" + i;
      }
    }
    i = paramIntent.getIntExtra("fontId", -1);
    paramContext = paramString;
    if (i != -1)
    {
      paramContext = paramString;
      if (paramIntent.getBooleanExtra("fromAIO", false)) {
        paramContext = paramString + "&adtag=mvip.gexinghua.mobile.font.client_tab_store&id=" + i;
      }
    }
    paramString = paramContext;
    if (paramIntent.hasExtra("extra_theme_id"))
    {
      str1 = paramIntent.getStringExtra("extra_theme_id");
      paramString = paramContext;
      if (!TextUtils.isEmpty(str1)) {
        paramString = paramContext + "&id=" + str1;
      }
    }
    long l = paramIntent.getLongExtra("pendantId", -1L);
    paramContext = paramString;
    if (l != -1L)
    {
      paramContext = paramString;
      if (paramIntent.getBooleanExtra("fromAIO", false)) {
        paramContext = paramString + "&adtag=mvip.gexinghua.mobile.faceaddon.client_tab_store&id=" + l;
      }
    }
    return paramContext;
  }
  
  public static String handleEmojiUrl(Intent paramIntent, Context paramContext, long paramLong, String paramString)
  {
    int j = paramIntent.getIntExtra("emojimall_src", 1);
    int i = 1;
    if (paramLong == 4L)
    {
      i = 3;
      if ((i != 1) && (i != 3)) {
        break label822;
      }
      paramString = IndividuationUrlHelper.a(paramContext, "emoji", "");
      if ((j != 8) && (j != 4)) {
        break label97;
      }
      paramContext = IndividuationUrlHelper.a(paramContext, "emojiDetail", "[id]", "");
    }
    for (;;)
    {
      if (TextUtils.isEmpty(paramContext))
      {
        localObject = "";
        return (String)localObject;
        if (paramLong != 8L) {
          break;
        }
        i = 2;
        break;
        label97:
        if (j == 11)
        {
          paramContext = IndividuationUrlHelper.a(paramContext, "smallEmojiList", "[id]", "");
          continue;
        }
        if (j == 5)
        {
          paramContext = IndividuationUrlHelper.a(paramContext, "emojiAuthorDetail", "[id]", "");
          continue;
        }
        if (j == 6)
        {
          paramString = IndividuationUrlHelper.a(BaseApplicationImpl.a, "magicPlus", "");
          paramContext = paramString;
          if (TextUtils.isEmpty(paramString)) {
            continue;
          }
          paramContext = paramString.replace("[uin]", BaseApplicationImpl.a.a().getAccount()).replace("[client]", "androidQQ").replace("[version]", "6.5.5.2880").replace("[platformId]", "2").replace("[device]", Build.DEVICE).replace("[system]", Build.VERSION.RELEASE);
          continue;
        }
        if (j == 9)
        {
          paramContext = paramContext.getSharedPreferences("mobileQQ", 0).getString("magic_promotion_jump_url", "");
          localObject = paramContext;
          if (!TextUtils.isEmpty(paramContext))
          {
            localObject = paramContext.replace("[uin]", BaseApplicationImpl.a.a().getAccount()).replace("[client]", "androidQQ").replace("[version]", "6.5.5.2880").replace("[platformId]", "2").replace("[device]", Build.DEVICE).replace("[system]", Build.VERSION.RELEASE);
            paramString = (String)localObject;
          }
          paramContext = paramString;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("VasWebviewUtil", 2, "promotion_jump_url:" + (String)localObject);
          paramContext = paramString;
          continue;
        }
        paramContext = paramString;
        if (j != 3) {
          continue;
        }
        localObject = paramIntent.getStringExtra("currentId");
        paramContext = paramString;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          continue;
        }
        paramContext = paramString;
        if (TextUtils.isEmpty(paramString)) {
          continue;
        }
        if (paramString.contains("?"))
        {
          paramContext = paramString + "&rec_id=" + (String)localObject;
          continue;
        }
        paramContext = paramString + "?rec_id=" + (String)localObject;
        continue;
      }
      i = 1;
      Object localObject = "vip.gongneng.mobile.biaoqing.client_tab_store";
      if ((j == 8) || (j == 4))
      {
        paramString = paramIntent.getStringExtra("emojimall_detail_id");
        if (TextUtils.isEmpty(paramString))
        {
          i = 0;
          paramString = paramContext;
          paramContext = (Context)localObject;
          label511:
          localObject = paramString;
          paramString = paramContext;
          paramContext = (Context)localObject;
        }
      }
      for (;;)
      {
        label521:
        localObject = paramContext;
        if (i == 0) {
          break;
        }
        paramContext = paramContext.replace("[adtag]", paramString).replace("[systemInt]", Integer.toString(Build.VERSION.SDK_INT));
        if (QLog.isColorLevel()) {
          QLog.d("VasWebviewUtil", 2, "loadHomePage:" + paramContext);
        }
        i = paramIntent.getIntExtra("emomall_new_time", -1);
        if (i > 0) {}
        for (paramContext = paramContext.replace("[updateTime]", "" + i);; paramContext = paramContext.replace("[updateTime]", "0"))
        {
          paramContext = paramContext.replace("[updateFlag]", Boolean.valueOf(paramIntent.getBooleanExtra("updateFlag", false)).toString()).replace("[updateId]", "" + paramIntent.getIntExtra("updateId", 0));
          localObject = paramContext;
          if (!paramIntent.hasExtra("EXTRA_KEY_IS_SMALL_EMOTICON")) {
            break;
          }
          localObject = paramContext;
          if (!paramIntent.getBooleanExtra("EXTRA_KEY_IS_SMALL_EMOTICON", false)) {
            break;
          }
          return paramContext + "&emojiType=5";
          paramString = paramContext.replace("[id]", paramString).replace("[type]", "view");
          paramContext = "vip.gongneng.mobile.biaoqing.client_manager_item";
          i = 1;
          break label511;
          if ((j == 2) || (j == 3))
          {
            paramString = "vip.gongneng.mobile.biaoqing.client_manager_top";
            break label521;
          }
          if (j == 7)
          {
            paramString = "vip.gongneng.mobile.biaoqing.client_index_banner";
            break label521;
          }
          if (j != 6) {
            break label815;
          }
          paramString = "vip.gongneng.mobile.biaoqing.client_aio_magic";
          break label521;
        }
        label815:
        paramString = "vip.gongneng.mobile.biaoqing.client_tab_store";
      }
      label822:
      paramContext = paramString;
    }
  }
  
  public static Intent insertVasWbPluginToIntent(long paramLong, Intent paramIntent)
  {
    Intent localIntent;
    if (paramIntent == null) {
      localIntent = null;
    }
    String str;
    do
    {
      do
      {
        return localIntent;
        localIntent = paramIntent;
      } while (paramLong <= 0L);
      str = String.valueOf(paramLong);
      localIntent = paramIntent;
    } while (!WebViewPluginFactory.a.containsKey(str));
    paramIntent.putExtra("insertPluginsArray", new String[] { str });
    return paramIntent;
  }
  
  public static boolean isExternalStorageOK(Context paramContext)
  {
    if (!Utils.b())
    {
      Toast.makeText(paramContext, paramContext.getString(2131368967), 0).show();
      return false;
    }
    if (Utils.b() < 5242880L)
    {
      Toast.makeText(paramContext, paramContext.getString(2131368968), 0).show();
      return false;
    }
    return true;
  }
  
  public static void openQQBrowserActivity(Context paramContext, String paramString, long paramLong, Intent paramIntent, boolean paramBoolean, int paramInt)
  {
    long l = System.currentTimeMillis();
    if (paramContext == null) {
      return;
    }
    if (paramIntent != null) {
      paramIntent.setClass(paramContext, QQBrowserActivity.class);
    }
    for (;;)
    {
      String str = paramString;
      if (mAsyncCookiesForVas != null)
      {
        str = paramString;
        if (mAsyncCookiesForVas.size() > 0)
        {
          str = paramString;
          if ("1".equalsIgnoreCase((String)mAsyncCookiesForVas.get(String.valueOf(paramLong))))
          {
            str = paramString;
            if (!TextUtils.isEmpty(paramString))
            {
              str = paramString;
              if (!paramString.contains("async_cookie=1"))
              {
                paramString = HtmlOffline.a(paramString, "async_cookie=1");
                str = paramString;
                if (QLog.isColorLevel())
                {
                  QLog.i("VasWebviewUtil", 1, "now business id " + paramLong + "  use async_cookie");
                  str = paramString;
                }
              }
            }
          }
        }
      }
      if (!TextUtils.isEmpty(str)) {
        paramIntent.putExtra("url", str);
      }
      paramIntent.putExtra("business", paramLong);
      insertVasWbPluginToIntent(paramLong, paramIntent);
      if (paramIntent.getLongExtra("startOpenPageTime", 0L) <= 0L) {
        paramIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      }
      paramIntent.putExtra("isShowAd", false);
      if (QLog.isColorLevel())
      {
        paramLong = System.currentTimeMillis();
        QLog.i("VasWebviewUtil", 2, "opeen vas webview cost: " + (paramLong - l));
      }
      if ((!paramBoolean) || (!(paramContext instanceof Activity))) {
        break;
      }
      ((Activity)paramContext).startActivityForResult(paramIntent, paramInt);
      return;
      paramIntent = new Intent(paramContext, QQBrowserActivity.class);
    }
    paramContext.startActivity(paramIntent);
  }
  
  public static void openQQBrowserWithoutAD(Context paramContext, String paramString, long paramLong, Intent paramIntent, boolean paramBoolean, int paramInt)
  {
    if (paramContext == null) {
      if (QLog.isDevelopLevel()) {
        QLog.d("VasWebviewUtil", 4, "open qqbrowser erro context");
      }
    }
    long l;
    do
    {
      return;
      l = System.currentTimeMillis();
    } while ((paramLong == 4194304L) && (!isExternalStorageOK(paramContext)));
    if (paramIntent != null) {
      paramIntent.setClass(paramContext, QQBrowserActivity.class);
    }
    for (Intent localIntent = paramIntent;; localIntent = new Intent(paramContext, QQBrowserActivity.class))
    {
      if ((paramLong != 2L) && (paramLong != 4L))
      {
        paramIntent = paramString;
        if (paramLong != 8L) {}
      }
      else
      {
        String str = handleEmojiUrl(localIntent, paramContext, paramLong, paramString);
        paramString = str;
        if (localIntent != null)
        {
          paramIntent = str;
          if (localIntent.getBooleanExtra("is_small_emoji", false)) {
            paramIntent = str + "&emojiType=5";
          }
          str = localIntent.getStringExtra("emoji_ids");
          paramString = paramIntent;
          if (str != null)
          {
            paramString = paramIntent;
            if (!str.equals("")) {
              paramString = paramIntent + "&id=" + str;
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.i("VasWebviewUtil", 2, "small emoji url = " + paramString);
        }
        paramIntent = paramString;
      }
      paramString = paramIntent;
      if (mAsyncCookiesForVas != null)
      {
        paramString = paramIntent;
        if (mAsyncCookiesForVas.size() > 0)
        {
          paramString = paramIntent;
          if ("1".equalsIgnoreCase((String)mAsyncCookiesForVas.get(String.valueOf(paramLong))))
          {
            paramString = paramIntent;
            if (!TextUtils.isEmpty(paramIntent))
            {
              paramString = paramIntent;
              if (!paramIntent.contains("async_cookie=1"))
              {
                paramIntent = HtmlOffline.a(paramIntent, "async_cookie=1");
                paramString = paramIntent;
                if (QLog.isColorLevel())
                {
                  QLog.i("VasWebviewUtil", 1, "now business id " + paramLong + "  use async_cookie");
                  paramString = paramIntent;
                }
              }
            }
          }
        }
      }
      if (!TextUtils.isEmpty(paramString)) {
        localIntent.putExtra("url", paramString);
      }
      localIntent.putExtra("business", paramLong);
      localIntent.putExtra("vasUsePreWebview", true);
      insertVasWbPluginToIntent(paramLong, localIntent);
      if (localIntent.getLongExtra("startOpenPageTime", 0L) <= 0L) {
        localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      }
      localIntent.putExtra("isShowAd", false);
      if (QLog.isColorLevel())
      {
        paramLong = System.currentTimeMillis();
        QLog.i("VasWebviewUtil", 2, "opeen vas webview cost: " + (paramLong - l));
      }
      if ((!paramBoolean) || (!(paramContext instanceof Activity))) {
        break;
      }
      ((Activity)paramContext).startActivityForResult(localIntent, paramInt);
      return;
    }
    paramContext.startActivity(localIntent);
  }
  
  public static void preparePareAsyncCookie()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasWebviewUtil", 2, "prepare to read async cookie!");
    }
    ThreadManager.a(new wfp(), 5, null, true);
  }
  
  public static void reportVASTo00145(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String... paramVarArgs)
  {
    if (paramAppInterface == null) {}
    label572:
    for (;;)
    {
      return;
      if ((paramAppInterface instanceof QQAppInterface)) {}
      for (QQAppInterface localQQAppInterface = (QQAppInterface)paramAppInterface;; localQQAppInterface = null)
      {
        if (localQQAppInterface == null) {
          break label572;
        }
        String str = paramAppInterface.a();
        Object localObject = paramAppInterface.a();
        if ((str == null) || (localObject == null)) {
          break;
        }
        if (TextUtils.isEmpty(VipComicReportUtils.k)) {
          if (VipComicReportUtils.a == null) {
            VipComicReportUtils.a = (TelephonyManager)((Context)localObject).getSystemService("phone");
          }
        }
        try
        {
          VipComicReportUtils.k = VipComicReportUtils.a.getDeviceId();
          if (VipComicReportUtils.k == null) {
            VipComicReportUtils.k = "";
          }
          int j = HttpUtil.a();
          if (j >= 0)
          {
            i = j;
            if (j < AppConstants.b.length) {}
          }
          else
          {
            i = 0;
          }
          paramAppInterface = AppConstants.b[i];
          if (TextUtils.isEmpty(VipComicReportUtils.l))
          {
            localObject = ((Context)localObject).getResources().getDisplayMetrics();
            VipComicReportUtils.l = ((DisplayMetrics)localObject).widthPixels + "*" + ((DisplayMetrics)localObject).heightPixels;
          }
          localObject = new String[9];
          System.arraycopy(paramVarArgs, 0, localObject, 0, Math.min(9, paramVarArgs.length));
          int i = 0;
          j = localObject.length;
          while (i < j)
          {
            if (localObject[i] == null) {
              localObject[i] = "";
            }
            i += 1;
          }
          paramAppInterface = Arrays.asList(new String[] { str, VipComicReportUtils.k, "", "android", "201", Build.VERSION.RELEASE, "3001", "3001013", "", "", paramString1, "", "", "", paramString2, "", paramString3, "", "", paramString4, "", "", "6.5.5", "", "", "", "", "", "android", paramAppInterface, VipComicReportUtils.l, "", localObject[0], localObject[1], localObject[2], localObject[3], localObject[4], localObject[5], localObject[6], localObject[7], localObject[8] });
          VipComicReportUtils.a(localQQAppInterface, "dc00145", paramAppInterface);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("VasWebviewUtil", 2, "reportVASTo00145 paramList=" + paramAppInterface.toString());
          return;
        }
        catch (Exception paramAppInterface)
        {
          for (;;) {}
        }
      }
    }
  }
  
  public static void reportVasStatus(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    reportVasStatus(paramString1, paramString2, paramString3, paramInt1, paramInt2, 0, 0, "", "");
  }
  
  public static void reportVasStatus(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString4, String paramString5)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1).append("|");
    localStringBuilder.append(paramString2).append("|");
    paramString1 = paramString3;
    if (TextUtils.isEmpty(paramString3)) {
      paramString1 = "0";
    }
    localStringBuilder.append(paramString1).append("|");
    localStringBuilder.append(paramInt1).append("|");
    localStringBuilder.append(paramInt2).append("|");
    localStringBuilder.append(paramInt3).append("|");
    localStringBuilder.append(paramInt4).append("|");
    localStringBuilder.append(paramString4).append("|");
    localStringBuilder.append(paramString5);
    DcReportUtil.a(null, "sendtdbank|b_sng_qqvip_vas_status_report|vas_status_report", localStringBuilder.toString(), true);
  }
  
  public static void reportVipKeywords(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1).append("|");
    localStringBuilder.append(paramString2).append("|");
    localStringBuilder.append(paramString3).append("|");
    localStringBuilder.append(paramString4).append("|");
    localStringBuilder.append(paramString5).append("|");
    localStringBuilder.append(paramString6).append("|");
    localStringBuilder.append(paramString7).append("|");
    localStringBuilder.append(paramString8).append("|");
    localStringBuilder.append(paramString9).append("|");
    localStringBuilder.append(paramString10);
    DcReportUtil.a(null, "sendtdbank|b_sng_qqvip_key_word_grey_keyword_show_new|key_word_grey", localStringBuilder.toString(), true);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vaswebviewplugin\VasWebviewUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */