package com.tencent.smtt.sdk.stat;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MttLoader
{
  private static final int BROWSER_MTT = 2;
  private static final int BROWSER_NONE = -1;
  private static final int BROWSER_QBX = 0;
  private static final int BROWSER_QBX5 = 1;
  public static final String CHANNEL_ID = "ChannelID";
  public static final String ENTRY_ID = "entryId";
  @Deprecated
  public static final String KEY_ACTIVITY_NAME = "KEY_ACT";
  @Deprecated
  public static final String KEY_APP_NAME = "KEY_APPNAME";
  public static final String KEY_EUSESTAT = "KEY_EUSESTAT";
  @Deprecated
  public static final String KEY_PACKAGE = "KEY_PKG";
  public static final String KEY_PID = "KEY_PID";
  private static final String LOGIN_TYPE_KEY = "loginType";
  private static final String LOGIN_TYPE_KEY_ANCHOR_POINT = "AnchorPoint";
  private static final String LOGIN_TYPE_KEY_CONTENT_SIZE = "ContentSize";
  private static final int LOGIN_TYPE_VALUE_MM = 24;
  private static final int LOGIN_TYPE_VALUE_OTHERS = 26;
  private static final int LOGIN_TYPE_VALUE_QQ = 13;
  private static final int LOGIN_TYPE_VALUE_QQMICROBLOG = 15;
  private static final int LOGIN_TYPE_VALUE_QZONE = 14;
  public static final String MTT_ACTION = "com.tencent.QQBrowser.action.VIEW";
  public static final String MTT_ACTION_SP = "com.tencent.QQBrowser.action.VIEWSP";
  private static final String MTT_PACKAGE_MTT = "com.tencent.mtt";
  private static final String MTT_PACKAGE_MTT_X86 = "com.tencent.mtt.x86";
  private static final String MTT_PACKAGE_QBX = "com.tencent.qbx";
  private static final String MTT_PACKAGE_QBX5 = "com.tencent.qbx5";
  private static final String MTT_SIG = "3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a";
  public static final String PID_ARTICLE_NEWS = "21272";
  public static final String PID_MOBILE_QQ = "50079";
  public static final String PID_QQPIM = "50190";
  public static final String PID_QZONE = "10494";
  public static final String PID_WECHAT = "10318";
  public static final String POS_ID = "PosID";
  public static final String QQBROWSER_DIRECT_DOWNLOAD_URL = "http://mdc.html5.qq.com/d/directdown.jsp?channel_id=50079";
  public static final String QQBROWSER_DOWNLOAD_URL = "http://mdc.html5.qq.com/mh?channel_id=50079&u=";
  private static final String QQBROWSER_PARAMS_ENCODE = ",encoded=1";
  public static final String QQBROWSER_PARAMS_FROME = ",from=";
  public static final String QQBROWSER_PARAMS_PACKAGENAME = ",packagename=";
  public static final String QQBROWSER_PARAMS_PD = ",product=";
  public static final String QQBROWSER_PARAMS_VERSION = ",version=";
  public static final String QQBROWSER_SCHEME = "mttbrowser://url=";
  public static final int RESULT_INVALID_CONTEXT = 3;
  public static final int RESULT_INVALID_URL = 2;
  public static final int RESULT_NOT_INSTALL_QQBROWSER = 4;
  public static final int RESULT_OK = 0;
  public static final int RESULT_QQBROWSER_LOW = 5;
  public static final int RESULT_UNKNOWN = 1;
  public static final String STAT_KEY = "StatKey";
  private static final int SUPPORT_3RD_PARTY_CALL_VERSION = 33;
  private static final int SUPPORT_QB_SCHEME_VERSION = 42;
  private static final int VERSION_420 = 420000;
  private static final int VERSION_580 = 580000;
  private static final int VERSION_601 = 601000;
  
  private static String certToCharsString(Certificate paramCertificate)
    throws CertificateEncodingException
  {
    paramCertificate = paramCertificate.getEncoded();
    int k = paramCertificate.length;
    char[] arrayOfChar = new char[k * 2];
    int i = 0;
    if (i < k)
    {
      int m = paramCertificate[i];
      int j = m >> 4 & 0xF;
      if (j >= 10)
      {
        j = j + 97 - 10;
        label51:
        arrayOfChar[(i * 2)] = ((char)j);
        j = m & 0xF;
        if (j < 10) {
          break label102;
        }
        j = j + 97 - 10;
      }
      for (;;)
      {
        arrayOfChar[(i * 2 + 1)] = ((char)j);
        i += 1;
        break;
        j += 48;
        break label51;
        label102:
        j += 48;
      }
    }
    return new String(arrayOfChar);
  }
  
  private static BrowserPackageInfo chooseClassName(Context paramContext, Uri paramUri)
  {
    Object localObject = new Intent("com.tencent.QQBrowser.action.VIEW");
    ((Intent)localObject).setData(paramUri);
    paramUri = paramContext.getPackageManager().queryIntentActivities((Intent)localObject, 0);
    if (paramUri.size() <= 0) {
      return null;
    }
    paramContext = new BrowserPackageInfo(null);
    paramUri = paramUri.iterator();
    while (paramUri.hasNext())
    {
      localObject = (ResolveInfo)paramUri.next();
      String str = ((ResolveInfo)localObject).activityInfo.packageName;
      if (str.contains("com.tencent.mtt"))
      {
        paramContext.classname = ((ResolveInfo)localObject).activityInfo.name;
        paramContext.packagename = ((ResolveInfo)localObject).activityInfo.packageName;
        return paramContext;
      }
      if (str.contains("com.tencent.qbx"))
      {
        paramContext.classname = ((ResolveInfo)localObject).activityInfo.name;
        paramContext.packagename = ((ResolveInfo)localObject).activityInfo.packageName;
      }
    }
    return paramContext;
  }
  
  public static BrowserInfo getBrowserInfo(Context paramContext)
  {
    boolean bool = paramContext.getApplicationContext().getSharedPreferences("x5_proxy_setting", 0).getBoolean("qb_install_status", false);
    localBrowserInfo = new BrowserInfo();
    if (bool) {
      return localBrowserInfo;
    }
    for (;;)
    {
      try
      {
        localPackageManager = paramContext.getPackageManager();
        localObject1 = null;
        try
        {
          localObject6 = localPackageManager.getPackageInfo("com.tencent.mtt", 0);
          localObject1 = localObject6;
          localBrowserInfo.browserType = 2;
          localObject1 = localObject6;
          localBrowserInfo.packageName = "com.tencent.mtt";
          localObject1 = localObject6;
          localBrowserInfo.quahead = "ADRQB_";
          Object localObject3 = localObject6;
          if (localObject6 != null)
          {
            localObject1 = localObject6;
            localObject3 = localObject6;
            if (((PackageInfo)localObject6).versionCode > 420000)
            {
              localObject1 = localObject6;
              localBrowserInfo.ver = ((PackageInfo)localObject6).versionCode;
              localObject1 = localObject6;
              localBrowserInfo.quahead += ((PackageInfo)localObject6).versionName.replaceAll("\\.", "");
              localObject1 = localObject6;
              localBrowserInfo.vn = ((PackageInfo)localObject6).versionName.replaceAll("\\.", "");
              return localBrowserInfo;
            }
          }
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException3)
        {
          localObject4 = localObject1;
        }
      }
      catch (Exception paramContext)
      {
        PackageManager localPackageManager;
        Object localObject1;
        Object localObject6;
        Object localObject4;
        PackageInfo localPackageInfo1;
        Object localObject2;
        continue;
      }
      try
      {
        localObject1 = localPackageManager.getPackageInfo("com.tencent.qbx", 0);
        localObject4 = localObject1;
        localBrowserInfo.browserType = 0;
        localObject4 = localObject1;
        localBrowserInfo.packageName = "com.tencent.qbx";
        localObject4 = localObject1;
        localBrowserInfo.quahead = "ADRQBX_";
        paramContext = (Context)localObject1;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException1)
      {
        try
        {
          localPackageInfo1 = localPackageManager.getPackageInfo("com.tencent.qbx5", 0);
          localObject4 = localPackageInfo1;
          localBrowserInfo.browserType = 1;
          localObject4 = localPackageInfo1;
          localBrowserInfo.packageName = "com.tencent.qbx5";
          localObject4 = localPackageInfo1;
          localBrowserInfo.quahead = "ADRQBX5_";
          paramContext = localPackageInfo1;
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException2)
        {
          localObject2 = localObject4;
          try
          {
            localObject4 = localPackageManager.getPackageInfo("com.tencent.mtt", 0);
            localObject2 = localObject4;
            localBrowserInfo.packageName = "com.tencent.mtt";
            localObject2 = localObject4;
            localBrowserInfo.browserType = 2;
            localObject2 = localObject4;
            localBrowserInfo.quahead = "ADRQB_";
            paramContext = (Context)localObject4;
          }
          catch (PackageManager.NameNotFoundException localNameNotFoundException4)
          {
            try
            {
              PackageInfo localPackageInfo2 = localPackageManager.getPackageInfo("com.tencent.mtt.x86", 0);
              localObject2 = localPackageInfo2;
              localBrowserInfo.packageName = "com.tencent.mtt.x86";
              localObject2 = localPackageInfo2;
              localBrowserInfo.browserType = 2;
              localObject2 = localPackageInfo2;
              localBrowserInfo.quahead = "ADRQB_";
              paramContext = localPackageInfo2;
            }
            catch (Exception localException)
            {
              Object localObject5 = localObject2;
              try
              {
                localObject6 = chooseClassName(paramContext, Uri.parse("http://mdc.html5.qq.com/mh?channel_id=50079&u="));
                paramContext = (Context)localObject2;
                if (localObject6 == null) {
                  continue;
                }
                paramContext = (Context)localObject2;
                localObject5 = localObject2;
                if (TextUtils.isEmpty(((BrowserPackageInfo)localObject6).packagename)) {
                  continue;
                }
                localObject5 = localObject2;
                paramContext = localPackageManager.getPackageInfo(((BrowserPackageInfo)localObject6).packagename, 0);
                localObject5 = paramContext;
                localBrowserInfo.packageName = ((BrowserPackageInfo)localObject6).packagename;
                localObject5 = paramContext;
                localBrowserInfo.browserType = 2;
                localObject5 = paramContext;
                localBrowserInfo.quahead = "ADRQB_";
              }
              catch (Exception paramContext)
              {
                paramContext = (Context)localObject5;
              }
            }
          }
        }
      }
    }
    if (paramContext != null)
    {
      localBrowserInfo.ver = paramContext.versionCode;
      localBrowserInfo.quahead += paramContext.versionName.replaceAll("\\.", "");
      localBrowserInfo.vn = paramContext.versionName.replaceAll("\\.", "");
    }
    return localBrowserInfo;
  }
  
  public static String getDownloadUrlWithQb(String paramString)
  {
    try
    {
      paramString = "http://mdc.html5.qq.com/mh?channel_id=50079&u=" + URLEncoder.encode(paramString, "UTF-8");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString.printStackTrace();
    }
    return "http://mdc.html5.qq.com/mh?channel_id=50079&u=";
  }
  
  private static int getLoginType(Context paramContext)
  {
    int i = 26;
    paramContext = paramContext.getApplicationInfo().processName;
    if (paramContext.equals("com.tencent.mobileqq")) {
      i = 13;
    }
    do
    {
      return i;
      if (paramContext.equals("com.qzone")) {
        return 14;
      }
      if (paramContext.equals("com.tencent.WBlog")) {
        return 15;
      }
    } while (!paramContext.equals("com.tencent.mm"));
    return 24;
  }
  
  public static String getValidQBUrl(Context paramContext, String paramString)
  {
    int i = 1;
    String str = paramString;
    if (paramString.toLowerCase().startsWith("qb://"))
    {
      paramContext = getBrowserInfo(paramContext);
      if (paramContext.browserType != -1) {
        break label43;
      }
    }
    for (;;)
    {
      str = paramString;
      if (i != 0) {
        str = getDownloadUrlWithQb(paramString);
      }
      return str;
      label43:
      if ((paramContext.browserType != 2) || (paramContext.ver >= 33)) {
        i = 0;
      }
    }
  }
  
  private static boolean hasValidProtocal(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    int i;
    int j;
    do
    {
      return false;
      paramString = paramString.trim();
      i = paramString.toLowerCase().indexOf("://");
      j = paramString.toLowerCase().indexOf('.');
    } while ((i > 0) && (j > 0) && (i > j));
    return paramString.toLowerCase().contains("://");
  }
  
  public static boolean isBrowserInstalled(Context paramContext)
  {
    return getBrowserInfo(paramContext).browserType != -1;
  }
  
  public static boolean isBrowserInstalledEx(Context paramContext)
  {
    paramContext = getBrowserInfo(paramContext);
    boolean bool = false;
    try
    {
      long l = Long.valueOf(paramContext.vn).longValue();
      if (l >= 6001500L) {
        bool = true;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        localNumberFormatException.printStackTrace();
      }
    }
    if (paramContext.ver >= 601500) {
      return true;
    }
    return bool;
  }
  
  public static boolean isGreatBrowserVer(Context paramContext, long paramLong1, long paramLong2)
  {
    paramContext = getBrowserInfo(paramContext);
    boolean bool = false;
    try
    {
      long l = Long.valueOf(paramContext.vn).longValue();
      if (l >= paramLong1) {
        bool = true;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        localNumberFormatException.printStackTrace();
      }
    }
    if (paramContext.ver >= paramLong2) {
      return true;
    }
    return bool;
  }
  
  public static boolean isSupportQBScheme(Context paramContext)
  {
    paramContext = getBrowserInfo(paramContext);
    if (paramContext.browserType == -1) {}
    while ((paramContext.browserType == 2) && (paramContext.ver < 42)) {
      return false;
    }
    return true;
  }
  
  public static boolean isSupportingTbsTips(Context paramContext)
  {
    paramContext = getBrowserInfo(paramContext);
    return (paramContext.browserType == 2) && (paramContext.ver >= 580000);
  }
  
  public static int loadUrl(Context paramContext, String paramString, HashMap<String, String> paramHashMap, WebView paramWebView)
  {
    if (paramContext == null) {
      return 3;
    }
    Object localObject1 = paramString;
    if (!hasValidProtocal(paramString)) {
      localObject1 = "http://" + paramString;
    }
    try
    {
      localObject1 = Uri.parse((String)localObject1);
      if (localObject1 == null) {
        return 2;
      }
    }
    catch (Exception paramContext)
    {
      return 2;
    }
    Object localObject2 = getBrowserInfo(paramContext);
    if (((BrowserInfo)localObject2).browserType == -1) {
      return 4;
    }
    if ((((BrowserInfo)localObject2).browserType == 2) && (((BrowserInfo)localObject2).ver < 33)) {
      return 5;
    }
    paramString = new Intent("android.intent.action.VIEW");
    if (((BrowserInfo)localObject2).browserType == 2) {
      if ((((BrowserInfo)localObject2).ver >= 33) && (((BrowserInfo)localObject2).ver <= 39)) {
        paramString.setClassName("com.tencent.mtt", "com.tencent.mtt.MainActivity");
      }
    }
    label606:
    for (;;)
    {
      paramString.setData((Uri)localObject1);
      if (paramHashMap != null)
      {
        localObject1 = paramHashMap.keySet();
        if (localObject1 != null)
        {
          localObject1 = ((Set)localObject1).iterator();
          for (;;)
          {
            if (((Iterator)localObject1).hasNext())
            {
              localObject2 = (String)((Iterator)localObject1).next();
              String str = (String)paramHashMap.get(localObject2);
              if (!TextUtils.isEmpty(str))
              {
                paramString.putExtra((String)localObject2, str);
                continue;
                if ((((BrowserInfo)localObject2).ver >= 40) && (((BrowserInfo)localObject2).ver <= 45))
                {
                  paramString.setClassName("com.tencent.mtt", "com.tencent.mtt.SplashActivity");
                  break;
                }
                if (((BrowserInfo)localObject2).ver < 46) {
                  break label606;
                }
                paramString = new Intent("com.tencent.QQBrowser.action.VIEW");
                localObject2 = chooseClassName(paramContext, (Uri)localObject1);
                if ((localObject2 != null) && (!TextUtils.isEmpty(((BrowserPackageInfo)localObject2).classname))) {
                  paramString.setClassName(((BrowserPackageInfo)localObject2).packagename, ((BrowserPackageInfo)localObject2).classname);
                }
                break;
                if (((BrowserInfo)localObject2).browserType == 1)
                {
                  if (((BrowserInfo)localObject2).ver == 1)
                  {
                    paramString.setClassName("com.tencent.qbx5", "com.tencent.qbx5.MainActivity");
                    break;
                  }
                  if (((BrowserInfo)localObject2).ver != 2) {
                    break label606;
                  }
                  paramString.setClassName("com.tencent.qbx5", "com.tencent.qbx5.SplashActivity");
                  break;
                }
                if (((BrowserInfo)localObject2).browserType == 0)
                {
                  if ((((BrowserInfo)localObject2).ver >= 4) && (((BrowserInfo)localObject2).ver <= 6))
                  {
                    paramString.setClassName("com.tencent.qbx", "com.tencent.qbx.SplashActivity");
                    break;
                  }
                  if (((BrowserInfo)localObject2).ver <= 6) {
                    break label606;
                  }
                  paramString = new Intent("com.tencent.QQBrowser.action.VIEW");
                  localObject2 = chooseClassName(paramContext, (Uri)localObject1);
                  if ((localObject2 != null) && (!TextUtils.isEmpty(((BrowserPackageInfo)localObject2).classname))) {
                    paramString.setClassName(((BrowserPackageInfo)localObject2).packagename, ((BrowserPackageInfo)localObject2).classname);
                  }
                  break;
                }
                paramString = new Intent("com.tencent.QQBrowser.action.VIEW");
                localObject2 = chooseClassName(paramContext, (Uri)localObject1);
                if ((localObject2 != null) && (!TextUtils.isEmpty(((BrowserPackageInfo)localObject2).classname))) {
                  paramString.setClassName(((BrowserPackageInfo)localObject2).packagename, ((BrowserPackageInfo)localObject2).classname);
                }
                break;
              }
            }
          }
        }
      }
      try
      {
        paramString.putExtra("loginType", getLoginType(paramContext));
        paramString.addFlags(268435456);
        if (paramWebView != null)
        {
          paramString.putExtra("AnchorPoint", new Point(paramWebView.getScrollX(), paramWebView.getScrollY()));
          paramString.putExtra("ContentSize", new Point(paramWebView.getContentWidth(), paramWebView.getContentHeight()));
        }
        paramContext.startActivity(paramString);
        return 0;
      }
      catch (ActivityNotFoundException paramContext)
      {
        return 4;
      }
    }
  }
  
  public static int loadUrl(Context paramContext, String paramString1, HashMap<String, String> paramHashMap, String paramString2, WebView paramWebView)
  {
    j = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      try
      {
        localObject = paramContext.getPackageManager();
        if (localObject == null) {
          continue;
        }
        localObject = ((PackageManager)localObject).getPackageInfo("com.tencent.mtt", 0);
        if (localObject == null) {
          continue;
        }
        i = ((PackageInfo)localObject).versionCode;
        if (i <= 601000) {
          continue;
        }
        i = 1;
      }
      catch (Throwable localThrowable)
      {
        Object localObject;
        int i = 0;
        continue;
        String str = "";
        continue;
        i = 0;
        continue;
      }
      try
      {
        localObject = URLEncoder.encode(paramString1, "UTF-8");
        if (i != 0) {
          paramString1 = (String)localObject;
        }
      }
      catch (Exception localException)
      {
        i = j;
      }
    }
    if (i != 0)
    {
      localObject = ",encoded=1";
      localStringBuilder.append("mttbrowser://url=").append(paramString1).append(",product=").append("TBS").append(",packagename=").append(paramContext.getPackageName()).append(",from=").append(paramString2).append(",version=").append("2.2.0.1095").append((String)localObject);
      return loadUrl(paramContext, localStringBuilder.toString(), paramHashMap, paramWebView);
    }
  }
  
  public static boolean openDocWithQb(Context paramContext, String paramString1, int paramInt, String paramString2, HashMap<String, String> paramHashMap)
  {
    return openDocWithQb(paramContext, paramString1, paramInt, paramString2, paramHashMap, null);
  }
  
  public static boolean openDocWithQb(Context paramContext, String paramString1, int paramInt, String paramString2, HashMap<String, String> paramHashMap, Bundle paramBundle)
  {
    Intent localIntent;
    try
    {
      localIntent = new Intent("com.tencent.QQBrowser.action.sdk.document");
      if (paramHashMap != null)
      {
        Object localObject = paramHashMap.keySet();
        if (localObject != null)
        {
          localObject = ((Set)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            String str1 = (String)((Iterator)localObject).next();
            String str2 = (String)paramHashMap.get(str1);
            if (!TextUtils.isEmpty(str2)) {
              localIntent.putExtra(str1, str2);
            }
          }
        }
      }
      paramHashMap = new File(paramString1);
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      return false;
    }
    localIntent.putExtra("key_reader_sdk_id", 3);
    localIntent.putExtra("key_reader_sdk_type", paramInt);
    if (paramInt == 0) {
      localIntent.putExtra("key_reader_sdk_path", paramString1);
    }
    for (;;)
    {
      localIntent.putExtra("key_reader_sdk_format", paramString2);
      localIntent.setData(Uri.fromFile(paramHashMap));
      localIntent.putExtra("loginType", getLoginType(paramContext.getApplicationContext()));
      if (paramBundle != null) {
        localIntent.putExtra("key_reader_sdk_extrals", paramBundle);
      }
      paramContext.startActivity(localIntent);
      return true;
      if (paramInt == 1) {
        localIntent.putExtra("key_reader_sdk_url", paramString1);
      }
    }
  }
  
  public static boolean openVideoWithQb(Context paramContext, String paramString, HashMap<String, String> paramHashMap)
  {
    Object localObject = Uri.parse(paramString);
    paramString = new Intent("android.intent.action.VIEW");
    paramString.setFlags(268435456);
    paramString.setDataAndType((Uri)localObject, "video/*");
    if (paramHashMap != null)
    {
      localObject = paramHashMap.keySet();
      if (localObject != null)
      {
        localObject = ((Set)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str1 = (String)((Iterator)localObject).next();
          String str2 = (String)paramHashMap.get(str1);
          if (!TextUtils.isEmpty(str2)) {
            paramString.putExtra(str1, str2);
          }
        }
      }
    }
    try
    {
      paramString.putExtra("loginType", getLoginType(paramContext));
      paramString.setComponent(new ComponentName("com.tencent.mtt", "com.tencent.mtt.browser.video.H5VideoThrdcallActivity"));
      paramContext.startActivity(paramString);
      i = 1;
    }
    catch (Throwable paramHashMap)
    {
      for (;;)
      {
        try
        {
          paramString.setComponent(null);
          paramContext.startActivity(paramString);
          return true;
        }
        catch (Throwable paramContext)
        {
          int i;
          paramContext.printStackTrace();
        }
        paramHashMap = paramHashMap;
        i = 0;
      }
    }
    if (i == 0) {}
    return false;
  }
  
  /* Error */
  public static boolean verifySignature(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: aconst_null
    //   5: astore_1
    //   6: new 569	java/util/jar/JarFile
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 572	java/util/jar/JarFile:<init>	(Ljava/io/File;)V
    //   14: astore_0
    //   15: aload_2
    //   16: astore_1
    //   17: aload_0
    //   18: ldc_w 574
    //   21: invokevirtual 578	java/util/jar/JarFile:getJarEntry	(Ljava/lang/String;)Ljava/util/jar/JarEntry;
    //   24: astore_3
    //   25: aload_3
    //   26: ifnonnull +25 -> 51
    //   29: iconst_0
    //   30: ifeq +11 -> 41
    //   33: new 580	java/lang/NullPointerException
    //   36: dup
    //   37: invokespecial 581	java/lang/NullPointerException:<init>	()V
    //   40: athrow
    //   41: aload_0
    //   42: ifnull +7 -> 49
    //   45: aload_0
    //   46: invokevirtual 584	java/util/jar/JarFile:close	()V
    //   49: iconst_0
    //   50: ireturn
    //   51: aload_2
    //   52: astore_1
    //   53: sipush 8192
    //   56: newarray <illegal type>
    //   58: astore 4
    //   60: aload_2
    //   61: astore_1
    //   62: aload_0
    //   63: aload_3
    //   64: invokevirtual 588	java/util/jar/JarFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   67: astore_2
    //   68: aload_2
    //   69: astore_1
    //   70: aload_2
    //   71: aload 4
    //   73: iconst_0
    //   74: aload 4
    //   76: arraylength
    //   77: invokevirtual 594	java/io/InputStream:read	([BII)I
    //   80: iconst_m1
    //   81: if_icmpne -13 -> 68
    //   84: aload_2
    //   85: astore_1
    //   86: aload_2
    //   87: invokevirtual 595	java/io/InputStream:close	()V
    //   90: aload_2
    //   91: astore_1
    //   92: aload_3
    //   93: invokevirtual 601	java/util/jar/JarEntry:getCertificates	()[Ljava/security/cert/Certificate;
    //   96: astore_3
    //   97: aload_2
    //   98: astore_1
    //   99: aload_3
    //   100: arraylength
    //   101: istore 5
    //   103: iload 5
    //   105: iconst_1
    //   106: if_icmpge +24 -> 130
    //   109: aload_2
    //   110: ifnull +7 -> 117
    //   113: aload_2
    //   114: invokevirtual 595	java/io/InputStream:close	()V
    //   117: aload_0
    //   118: ifnull -69 -> 49
    //   121: aload_0
    //   122: invokevirtual 584	java/util/jar/JarFile:close	()V
    //   125: iconst_0
    //   126: ireturn
    //   127: astore_0
    //   128: iconst_0
    //   129: ireturn
    //   130: aload_2
    //   131: astore_1
    //   132: aload_3
    //   133: iconst_0
    //   134: aaload
    //   135: invokestatic 603	com/tencent/smtt/sdk/stat/MttLoader:certToCharsString	(Ljava/security/cert/Certificate;)Ljava/lang/String;
    //   138: astore_3
    //   139: aload_3
    //   140: ifnull +108 -> 248
    //   143: aload_2
    //   144: astore_1
    //   145: aload_3
    //   146: ldc 82
    //   148: invokevirtual 356	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   151: istore 6
    //   153: iload 6
    //   155: ifeq +93 -> 248
    //   158: aload_2
    //   159: ifnull +7 -> 166
    //   162: aload_2
    //   163: invokevirtual 595	java/io/InputStream:close	()V
    //   166: aload_0
    //   167: ifnull +7 -> 174
    //   170: aload_0
    //   171: invokevirtual 584	java/util/jar/JarFile:close	()V
    //   174: iconst_1
    //   175: ireturn
    //   176: astore_2
    //   177: aconst_null
    //   178: astore_0
    //   179: aload_1
    //   180: ifnull +7 -> 187
    //   183: aload_1
    //   184: invokevirtual 595	java/io/InputStream:close	()V
    //   187: aload_0
    //   188: ifnull +7 -> 195
    //   191: aload_0
    //   192: invokevirtual 584	java/util/jar/JarFile:close	()V
    //   195: aload_2
    //   196: athrow
    //   197: astore_0
    //   198: aconst_null
    //   199: astore_1
    //   200: aload_3
    //   201: astore_0
    //   202: aload_1
    //   203: ifnull +7 -> 210
    //   206: aload_1
    //   207: invokevirtual 595	java/io/InputStream:close	()V
    //   210: aload_0
    //   211: ifnull -162 -> 49
    //   214: aload_0
    //   215: invokevirtual 584	java/util/jar/JarFile:close	()V
    //   218: iconst_0
    //   219: ireturn
    //   220: astore_1
    //   221: goto -11 -> 210
    //   224: astore_1
    //   225: goto -38 -> 187
    //   228: astore_0
    //   229: goto -34 -> 195
    //   232: astore_1
    //   233: goto -192 -> 41
    //   236: astore_1
    //   237: goto -120 -> 117
    //   240: astore_1
    //   241: goto -75 -> 166
    //   244: astore_0
    //   245: goto -71 -> 174
    //   248: aload_2
    //   249: ifnull +7 -> 256
    //   252: aload_2
    //   253: invokevirtual 595	java/io/InputStream:close	()V
    //   256: aload_0
    //   257: ifnull -208 -> 49
    //   260: aload_0
    //   261: invokevirtual 584	java/util/jar/JarFile:close	()V
    //   264: iconst_0
    //   265: ireturn
    //   266: astore_1
    //   267: goto -11 -> 256
    //   270: astore_2
    //   271: goto -92 -> 179
    //   274: astore_1
    //   275: aconst_null
    //   276: astore_1
    //   277: goto -75 -> 202
    //   280: astore_1
    //   281: aload_2
    //   282: astore_1
    //   283: goto -81 -> 202
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	286	0	paramFile	File
    //   5	202	1	localInputStream1	java.io.InputStream
    //   220	1	1	localIOException1	java.io.IOException
    //   224	1	1	localIOException2	java.io.IOException
    //   232	1	1	localIOException3	java.io.IOException
    //   236	1	1	localIOException4	java.io.IOException
    //   240	1	1	localIOException5	java.io.IOException
    //   266	1	1	localIOException6	java.io.IOException
    //   274	1	1	localThrowable1	Throwable
    //   276	1	1	localObject1	Object
    //   280	1	1	localThrowable2	Throwable
    //   282	1	1	localObject2	Object
    //   3	160	2	localInputStream2	java.io.InputStream
    //   176	77	2	localObject3	Object
    //   270	12	2	localObject4	Object
    //   1	200	3	localObject5	Object
    //   58	17	4	arrayOfByte	byte[]
    //   101	6	5	i	int
    //   151	3	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   45	49	127	java/io/IOException
    //   121	125	127	java/io/IOException
    //   214	218	127	java/io/IOException
    //   260	264	127	java/io/IOException
    //   6	15	176	finally
    //   6	15	197	java/lang/Throwable
    //   206	210	220	java/io/IOException
    //   183	187	224	java/io/IOException
    //   191	195	228	java/io/IOException
    //   33	41	232	java/io/IOException
    //   113	117	236	java/io/IOException
    //   162	166	240	java/io/IOException
    //   170	174	244	java/io/IOException
    //   252	256	266	java/io/IOException
    //   17	25	270	finally
    //   53	60	270	finally
    //   62	68	270	finally
    //   70	84	270	finally
    //   86	90	270	finally
    //   92	97	270	finally
    //   99	103	270	finally
    //   132	139	270	finally
    //   145	153	270	finally
    //   17	25	274	java/lang/Throwable
    //   53	60	274	java/lang/Throwable
    //   62	68	274	java/lang/Throwable
    //   70	84	280	java/lang/Throwable
    //   86	90	280	java/lang/Throwable
    //   92	97	280	java/lang/Throwable
    //   99	103	280	java/lang/Throwable
    //   132	139	280	java/lang/Throwable
    //   145	153	280	java/lang/Throwable
  }
  
  public static class BrowserInfo
  {
    public int browserType = -1;
    public String packageName = null;
    public String quahead = "";
    public int ver = -1;
    public String vn = "0";
  }
  
  private static class BrowserPackageInfo
  {
    public String classname = "";
    public String packagename = "";
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\smtt\sdk\stat\MttLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */