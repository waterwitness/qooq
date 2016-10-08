package com.tencent.mobileqq.theme;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.DisplayMetrics;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThemeHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.IndividuationConfigInfo;
import com.tencent.mobileqq.vaswebviewplugin.ThemeJsPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TimeZone;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;
import uzw;
import uzx;

public class ThemeUtil
{
  public static final String DEFAULT_THEME_ID = "1000";
  public static final String DIY_STYLE_START = "5000";
  public static final String DIY_THEME_ID = "999";
  public static final String DIY_THEME_VERSION = "580";
  public static final String PKG_SUFFIX = ".zip";
  public static final int SET_SKIN_THEME_STATUS_CHANGE = 1;
  public static final int SET_SKIN_THEME_STATUS_FAIL = -1;
  public static final int SET_SKIN_THEME_STATUS_KEEP = 0;
  public static final String SP_KEY_AUTH_TIME = "authTime";
  public static final String TAG = "Theme.ThemeUtil";
  public static final String THEME_DEBUG_KEY = "ThemeDebugKeyLog:";
  public static final String THEME_ERROR_ID_LIST = "listOfErrorThemeSrc";
  public static final String THEME_ID = "themeId";
  public static final String THEME_ID_NIGHTMODE = "1103";
  public static final String THEME_ISSOUND = "isSound";
  public static final String THEME_KEY_CURRENT_THEME_ID = "currentThemeId_6.3.5";
  public static final String THEME_KEY_CURRENT_THEME_VERSION = "currentThemeVersion";
  public static final String THEME_KEY_NIGHT_MODE = "night_theme_info_";
  public static final String THEME_KEY_USER_DOWNLOAD = "userDownloadTheme";
  public static final String THEME_KEY_USER_SWITCH_TIMES = "user_switch_theme_times";
  public static final String THEME_MSSAGE_VOICE_NAME = "message.mp3";
  public static final String THEME_PATH = "themePath";
  static final String THEME_SET_TIME_KEY = "themeSetTimeKey";
  public static final String THEME_SHARED_PREFERENCES = "userThemeSharedPreferences";
  public static final String THEME_SIZE = "size";
  public static final String THEME_STATUS = "themeStatus";
  public static final String THEME_STATUS_COMPLETE = "5";
  public static final String THEME_STATUS_DOWNLOAD_END = "3";
  public static final String THEME_STATUS_DOWNLOAD_NONE = "1";
  public static final String THEME_STATUS_DOWNLOAD_PAUSE = "4";
  public static final String THEME_STATUS_DOWNLOAD_PROGRESS = "2";
  public static final String THEME_TYPE = "themeType";
  public static final int THEME_TYPE_FROM_SERVER = 1;
  public static final String THEME_URL = "url";
  public static final String THEME_VERSION = "version";
  public static final String THEME_VOICE_BASE_HOME = "voice";
  public static final String THEME_VOICE_SETTING = "theme_voice_setting_";
  public static final String WEEK_KEY_INDEX = "themeIndex";
  public static final String WEEK_KEY_SERIES_ID = "seriesID";
  public static final String WEEK_KEY_THEME_ARRAY = "themeArray";
  public static final String WEEK_KEY_THEME_LENGTH = "themeLength";
  public static final String WEEK_KEY_THEME_START_TIME = "startTime";
  static boolean isSharedspSync;
  static String uin;
  
  public ThemeUtil()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static String getCurrentThemeId()
  {
    String str2 = getCurrentThemeInfo().getString("themeId");
    String str1 = str2;
    if (android.text.TextUtils.isEmpty(str2)) {
      str1 = "1000";
    }
    return str1;
  }
  
  public static Bundle getCurrentThemeInfo()
  {
    Bundle localBundle = new Bundle();
    try
    {
      localBundle.putString("themeId", "1000");
      localBundle.putString("version", "0");
      String str = SkinEngine.getInstances().getSkinRootPath();
      localBundle.putString("themePath", str);
      if (QLog.isColorLevel()) {
        QLog.i("Theme.ThemeUtil", 2, "getCurrentThemeInfo,currentThemeResPath=" + str);
      }
      if ((str != null) && (str.length() > 0))
      {
        Object localObject = str;
        if (str.endsWith(File.separator)) {
          localObject = str.substring(0, str.length() - 1);
        }
        str = ((String)localObject).substring(((String)localObject).lastIndexOf("/") + 1);
        if (QLog.isColorLevel()) {
          QLog.i("Theme.ThemeUtil", 2, "getCurrentThemeInfo,currentThemeResPath=" + (String)localObject + ",themeIdVersion=" + str);
        }
        if (str != null)
        {
          localObject = str.split("_");
          if (localObject.length == 2)
          {
            localBundle.putString("themeId", localObject[0]);
            localBundle.putString("version", localObject[1]);
          }
        }
      }
      return localBundle;
    }
    catch (Exception localException)
    {
      QLog.e("Theme.ThemeUtil", 1, "getCurrentThemeInfo, exception:", localException);
    }
    return localBundle;
  }
  
  public static int getErrorThemeId(Context paramContext, String paramString)
  {
    int j = 0;
    paramContext = getThemePreferences(paramContext).getString("listOfErrorThemeSrc", "");
    int i = j;
    if (paramContext != null)
    {
      i = j;
      if (paramContext.length() <= 0) {}
    }
    try
    {
      paramContext = new JSONObject(paramContext);
      i = j;
      if (paramContext.has(paramString)) {
        i = paramContext.getInt(paramString);
      }
    }
    catch (Exception paramContext)
    {
      do
      {
        i = j;
      } while (!QLog.isColorLevel());
      QLog.d("Theme.ThemeUtil", 2, "getErrorThemeId error:" + paramContext.getMessage());
    }
    return i;
    return 0;
  }
  
  public static boolean getIsDIYTheme(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = getCurrentThemeId();
    }
    boolean bool2 = "999".equals(str);
    boolean bool1 = bool2;
    if (!bool2)
    {
      bool1 = bool2;
      if (str != null)
      {
        if ((Integer.parseInt(str) < Integer.parseInt("5000")) || (Integer.parseInt(str) >= Integer.parseInt("5000") + 1000)) {
          break label61;
        }
        bool1 = true;
      }
    }
    return bool1;
    label61:
    return false;
  }
  
  public static String getThemeDensity(Context paramContext)
  {
    if (paramContext == null) {
      return "xh";
    }
    paramContext = paramContext.getResources().getDisplayMetrics();
    if (paramContext.densityDpi <= 160) {
      return "m";
    }
    if ((paramContext.densityDpi > 160) && (paramContext.densityDpi < 320)) {
      return "h";
    }
    return "xh";
  }
  
  public static String getThemeDownloadFilePath(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = AppConstants.cG;
    return paramContext + paramString1 + "_" + paramString2 + ".zip";
  }
  
  public static int getThemeDownloadNum(Context paramContext)
  {
    int m = 0;
    int n = 0;
    int i = 0;
    paramContext = getThemePreferences(paramContext).getString("userDownloadTheme", "");
    k = n;
    if (paramContext != null)
    {
      int j = m;
      k = n;
      try
      {
        if (paramContext.length() > 0)
        {
          j = m;
          paramContext = new JSONObject(paramContext);
          j = m;
          Iterator localIterator = paramContext.keys();
          for (;;)
          {
            j = i;
            k = i;
            if (!localIterator.hasNext()) {
              break;
            }
            j = i;
            String str = paramContext.getJSONObject(String.valueOf(localIterator.next())).getString("status");
            j = i;
            if (!str.equals("5"))
            {
              j = i;
              boolean bool = str.equals("3");
              if (!bool) {}
            }
            else
            {
              i += 1;
            }
          }
        }
        return k;
      }
      catch (Exception paramContext)
      {
        k = j;
        if (QLog.isColorLevel())
        {
          QLog.d("Theme.ThemeUtil", 2, "getThemeDownloadNum error:" + paramContext.getMessage());
          k = j;
        }
      }
    }
  }
  
  public static ThemeUtil.ThemeInfo getThemeInfo(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (android.text.TextUtils.isEmpty(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Theme.ThemeUtil", 2, "getThemeInfo error, themeId:" + paramString);
      }
      paramContext = null;
    }
    do
    {
      for (;;)
      {
        return paramContext;
        paramContext = getThemePreferences(paramContext).getString("userDownloadTheme", "");
        if (paramContext == null) {
          break label244;
        }
        try
        {
          if (paramContext.length() <= 0) {
            break label244;
          }
          paramContext = new JSONObject(paramContext);
          if (!paramContext.has(paramString)) {
            break label244;
          }
          JSONObject localJSONObject = paramContext.getJSONObject(paramString);
          ThemeUtil.ThemeInfo localThemeInfo = new ThemeUtil.ThemeInfo();
          try
          {
            localThemeInfo.themeId = paramString;
            localThemeInfo.version = localJSONObject.getString("version");
            localThemeInfo.size = localJSONObject.getLong("size");
            localThemeInfo.status = localJSONObject.getString("status");
            localThemeInfo.downsize = localJSONObject.getLong("downsize");
            if (localJSONObject.has("sound")) {
              localThemeInfo.isVoiceTheme = localJSONObject.getBoolean("sound");
            }
            paramContext = localThemeInfo;
            if (localJSONObject.has("fileNum"))
            {
              localThemeInfo.fileNum = localJSONObject.getInt("fileNum");
              return localThemeInfo;
            }
          }
          catch (Exception localException1)
          {
            paramString = localThemeInfo;
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            paramString = null;
          }
        }
      }
      paramContext = paramString;
    } while (!QLog.isColorLevel());
    QLog.d("Theme.ThemeUtil", 2, "getThemeInfo error:" + localException1.getMessage());
    return paramString;
    label244:
    return null;
  }
  
  public static SharedPreferences getThemePreferences(Context paramContext)
  {
    Context localContext = paramContext;
    if (paramContext == null)
    {
      paramContext = BaseApplicationImpl.a.getApplicationContext();
      localContext = paramContext;
      if (QLog.isColorLevel())
      {
        QLog.d("Theme.ThemeUtil", 2, "getThemePreferences null == context");
        localContext = paramContext;
      }
    }
    return localContext.getSharedPreferences("userThemeSharedPreferences", 4);
  }
  
  public static String getThemeResourcePath(Context paramContext, String paramString1, String paramString2)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject1 = localObject3;
    if (!android.text.TextUtils.isEmpty(paramString1))
    {
      localObject1 = localObject3;
      if (!android.text.TextUtils.isEmpty(paramString2))
      {
        localObject1 = localObject3;
        if (android.text.TextUtils.equals(paramString1, "1000")) {}
      }
    }
    do
    {
      for (;;)
      {
        try
        {
          if (Utils.c()) {
            paramContext = AppConstants.cz + "using_theme_res";
          }
        }
        catch (Exception paramString1)
        {
          paramContext = (Context)localObject2;
        }
        try
        {
          localObject1 = paramContext + File.separator + paramString1 + "_" + paramString2;
          return (String)localObject1;
        }
        catch (Exception paramString1)
        {
          for (;;) {}
        }
        paramContext = paramContext.getDir("mobileqq_theme", 0).getAbsolutePath();
      }
      localObject1 = paramContext;
    } while (!QLog.isColorLevel());
    QLog.d("Theme.ThemeUtil", 2, "getThemeResourcePath error:" + paramString1.getMessage());
    return paramContext;
  }
  
  public static int getThemeSwitchTimes(QQAppInterface paramQQAppInterface)
  {
    int j = getUinThemePreferences(paramQQAppInterface).getInt("user_switch_theme_times", -1);
    int i = j;
    if (-1 == j) {
      i = paramQQAppInterface.getPreferences().getInt("user_switch_theme_times", 0);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Theme.ThemeUtil", 2, "getThemeSwitchTimes userSwitchThemeTimes=" + i);
    }
    return i;
  }
  
  public static String getThemeVoiceRootPath()
  {
    Object localObject = SkinEngine.getInstances().getSkinRootPath();
    if (!android.text.TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = new File((String)localObject + File.separatorChar + "voice");
      if (((File)localObject).exists()) {
        return ((File)localObject).getAbsolutePath();
      }
    }
    return null;
  }
  
  public static SharedPreferences getUinThemePreferences(AppRuntime paramAppRuntime)
  {
    AppRuntime localAppRuntime = paramAppRuntime;
    if (paramAppRuntime == null)
    {
      paramAppRuntime = BaseApplicationImpl.a.a();
      localAppRuntime = paramAppRuntime;
      if (QLog.isColorLevel())
      {
        QLog.d("Theme.ThemeUtil", 2, "getUinThemePreferences null == application");
        localAppRuntime = paramAppRuntime;
      }
    }
    String str = localAppRuntime.getAccount();
    paramAppRuntime = str;
    if (str == null)
    {
      str = "noLogin";
      paramAppRuntime = str;
      if (QLog.isColorLevel())
      {
        QLog.d("Theme.ThemeUtil", 2, "ThemeUtil getUinThemePreferences,uin=noLogin");
        paramAppRuntime = str;
      }
    }
    return localAppRuntime.getApplication().getSharedPreferences(paramAppRuntime + "_theme", 4);
  }
  
  public static String getUserCurrentThemeId(AppRuntime paramAppRuntime)
  {
    Object localObject1 = paramAppRuntime;
    if (paramAppRuntime == null)
    {
      paramAppRuntime = BaseApplicationImpl.a.a();
      if (QLog.isColorLevel()) {
        QLog.d("Theme.ThemeUtil", 2, "getUserCurrentThemeId,application == null");
      }
      localObject1 = paramAppRuntime;
      if (paramAppRuntime == null)
      {
        localObject2 = "1000";
        return (String)localObject2;
      }
    }
    SharedPreferences localSharedPreferences = getUinThemePreferences((AppRuntime)localObject1);
    paramAppRuntime = localSharedPreferences.getString("currentThemeId_6.3.5", null);
    Object localObject2 = ((AppRuntime)localObject1).getAccount();
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = "noLogin";
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        QLog.d("Theme.ThemeUtil", 2, "getUserCurrentThemeId, uin=noLogin");
        localObject1 = localObject2;
      }
    }
    long l1 = localSharedPreferences.getLong("themeSetTimeKey", 0L);
    int i;
    if (!isSharedspSync)
    {
      isSharedspSync = true;
      localObject2 = BaseApplicationImpl.a();
      Object localObject3 = (String)localObject1 + "_stheme";
      if (Build.VERSION.SDK_INT > 8)
      {
        i = 4;
        label146:
        localObject3 = ((BaseApplicationImpl)localObject2).getSystemSharedPreferences((String)localObject3, i);
        long l2 = ((SharedPreferences)localObject3).getLong("themeSetTimeKey", 0L);
        if (l2 <= l1) {
          break label381;
        }
        localObject2 = ((SharedPreferences)localObject3).getString("currentThemeId_6.3.5", null);
        localObject3 = ((SharedPreferences)localObject3).getString("currentThemeVersion", "0");
        if (android.text.TextUtils.isEmpty((CharSequence)localObject2))
        {
          paramAppRuntime = localSharedPreferences.edit();
          paramAppRuntime.putString("currentThemeId_6.3.5", (String)localObject2);
          paramAppRuntime.putString("currentThemeVersion", (String)localObject3);
          paramAppRuntime.putLong("themeSetTimeKey", l2);
          paramAppRuntime.commit();
        }
        paramAppRuntime = (AppRuntime)localObject2;
        if (QLog.isColorLevel())
        {
          QLog.d("Theme.ThemeUtil", 2, "getUserCurrentThemeId, sysSpTime > spTime, currentThemeVersion=" + (String)localObject3 + "currentThemeId=" + (String)localObject2);
          paramAppRuntime = (AppRuntime)localObject2;
        }
      }
    }
    label381:
    for (;;)
    {
      if (android.text.TextUtils.isEmpty(paramAppRuntime))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Theme.ThemeUtil", 2, "ThemeUtil getCurrentTheme,null == currentThemeId, currentThemeId= ThemeUtil.DEFAULT_THEME_ID");
        }
        return "1000";
        i = 0;
        break label146;
      }
      localObject2 = paramAppRuntime;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Theme.ThemeUtil", 2, "ThemeUtil getCurrentTheme,uin=" + com.tencent.mobileqq.text.TextUtils.a((String)localObject1, 2) + ",currentThemeId=" + paramAppRuntime);
      return paramAppRuntime;
    }
  }
  
  public static String getUserCurrentThemeVersion(AppInterface paramAppInterface)
  {
    AppInterface localAppInterface2;
    if (paramAppInterface == null)
    {
      paramAppInterface = (AppInterface)BaseApplicationImpl.a.a();
      if (QLog.isColorLevel()) {
        QLog.d("Theme.ThemeUtil", 2, "getUserCurrentThemeVersion,application == null");
      }
      localAppInterface2 = paramAppInterface;
      if (paramAppInterface == null)
      {
        paramAppInterface = "0";
        return paramAppInterface;
      }
    }
    else
    {
      localAppInterface2 = paramAppInterface;
    }
    SharedPreferences localSharedPreferences = getUinThemePreferences(localAppInterface2);
    paramAppInterface = localAppInterface2.getAccount();
    AppInterface localAppInterface1 = paramAppInterface;
    if (paramAppInterface == null)
    {
      paramAppInterface = "noLogin";
      localAppInterface1 = paramAppInterface;
      if (QLog.isColorLevel())
      {
        QLog.d("Theme.ThemeUtil", 2, "getUserCurrentThemeVersion , uin=noLogin");
        localAppInterface1 = paramAppInterface;
      }
    }
    paramAppInterface = localSharedPreferences.getString("currentThemeVersion", null);
    long l1 = localSharedPreferences.getLong("themeSetTimeKey", 0L);
    Object localObject1;
    int i;
    if (!isSharedspSync)
    {
      isSharedspSync = true;
      localObject1 = BaseApplicationImpl.a();
      Object localObject2 = localAppInterface1 + "_stheme";
      if (Build.VERSION.SDK_INT > 8)
      {
        i = 4;
        label152:
        localObject2 = ((BaseApplicationImpl)localObject1).getSystemSharedPreferences((String)localObject2, i);
        long l2 = ((SharedPreferences)localObject2).getLong("themeSetTimeKey", 0L);
        if (l2 <= l1) {
          break label430;
        }
        localObject1 = ((SharedPreferences)localObject2).getString("currentThemeVersion", null);
        localObject2 = ((SharedPreferences)localObject2).getString("currentThemeId_6.3.5", null);
        if (android.text.TextUtils.isEmpty((CharSequence)localObject2))
        {
          paramAppInterface = localSharedPreferences.edit();
          paramAppInterface.putString("currentThemeId_6.3.5", (String)localObject2);
          paramAppInterface.putString("currentThemeVersion", (String)localObject1);
          paramAppInterface.putLong("themeSetTimeKey", l2);
          paramAppInterface.commit();
        }
        paramAppInterface = (AppInterface)localObject1;
        if (QLog.isColorLevel())
        {
          QLog.d("Theme.ThemeUtil", 2, "getUserCurrentThemeVersion, sysSpTime > spTime, currentThemeVersion=" + (String)localObject1 + "currentThemeId=" + (String)localObject2);
          paramAppInterface = (AppInterface)localObject1;
        }
      }
    }
    label430:
    for (;;)
    {
      localObject1 = paramAppInterface;
      if (android.text.TextUtils.isEmpty(paramAppInterface))
      {
        localAppInterface2.getApplication().getSharedPreferences(localAppInterface1, 4);
        paramAppInterface = localSharedPreferences.getString("currentThemeVersion", "0");
        localObject1 = paramAppInterface;
        if (QLog.isColorLevel())
        {
          QLog.d("Theme.ThemeUtil", 2, "getUserCurrentThemeVersion,currentThemeVersion == null, currentThemeVersion=" + paramAppInterface);
          localObject1 = paramAppInterface;
        }
      }
      paramAppInterface = (AppInterface)localObject1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Theme.ThemeUtil", 2, "ThemeUtil getCurrentTheme,uin=" + com.tencent.mobileqq.text.TextUtils.a(localAppInterface1, 2) + ",currentThemeVersion=" + (String)localObject1);
      return (String)localObject1;
      i = 0;
      break label152;
    }
  }
  
  private static String getUserThemeIDForReset(AppInterface paramAppInterface)
  {
    Object localObject2 = getUinThemePreferences(paramAppInterface);
    if (((SharedPreferences)localObject2).contains("currentThemeId_6.3.5"))
    {
      localObject1 = ((SharedPreferences)localObject2).getString("currentThemeId_6.3.5", "1000");
      if (QLog.isColorLevel()) {
        QLog.d("Theme.ThemeUtil", 2, "initTheme current qq already set theme:" + (String)localObject1);
      }
      if ("1103".equals(localObject1)) {}
      for (paramAppInterface = null; !android.text.TextUtils.isEmpty(paramAppInterface); paramAppInterface = getWeekLoopTheme(paramAppInterface))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Theme.ThemeUtil", 2, "initTheme current qq already set weekThemeId:" + paramAppInterface);
        }
        return paramAppInterface;
      }
    }
    QLog.d("Theme.ThemeUtil", 1, "initTheme sp.THEME_KEY_CURRENT_THEME_ID == null");
    Object localObject3 = new ArrayList();
    Object localObject1 = ((SharedPreferences)localObject2).getAll();
    if (localObject1 == null) {
      localObject1 = new HashMap();
    }
    for (;;)
    {
      Object localObject4 = ((Map)localObject1).entrySet().iterator();
      while (((Iterator)localObject4).hasNext())
      {
        String str = (String)((Map.Entry)((Iterator)localObject4).next()).getKey();
        if (str.startsWith("currentThemeId_")) {
          ((List)localObject3).add(str);
        }
      }
      if (((List)localObject3).isEmpty())
      {
        QLog.d("Theme.ThemeUtil", 1, "initTheme list.isEmpty()");
        setCurrentThemeIdVersion(paramAppInterface, "1000", "0");
        return "1000";
      }
      if (QLog.isColorLevel()) {
        QLog.i("Theme.ThemeUtil", 2, "set previous theme!");
      }
      Collections.sort((List)localObject3);
      localObject4 = (String)((List)localObject3).get(((List)localObject3).size() - 1);
      localObject3 = ((SharedPreferences)localObject2).getString("currentThemeVersion", "0");
      if (IndividuationConfigInfo.a("6.0", "6.5.5"))
      {
        localObject2 = (String)((Map)localObject1).get(localObject4);
        localObject1 = localObject2;
        if (!"1000".equals(localObject2))
        {
          localObject1 = localObject2;
          if ((paramAppInterface instanceof QQAppInterface)) {
            ((ThemeHandler)((QQAppInterface)paramAppInterface).a(14)).b((String)localObject2, (String)localObject3);
          }
        }
      }
      for (localObject1 = localObject2;; localObject1 = "1000")
      {
        setCurrentThemeIdVersion(paramAppInterface, (String)localObject1, (String)localObject3);
        return (String)localObject1;
        if (QLog.isColorLevel()) {
          QLog.i("Theme.ThemeUtil", 2, "old version or app == null.");
        }
      }
    }
    return (String)localObject1;
  }
  
  public static String getWeekLoopTheme(AppInterface paramAppInterface)
  {
    SharedPreferences localSharedPreferences = getUinThemePreferences(paramAppInterface);
    for (;;)
    {
      int j;
      try
      {
        str = localSharedPreferences.getString("themeArray", null);
        if ((!android.text.TextUtils.isEmpty(localSharedPreferences.getString("seriesID", null))) && (!android.text.TextUtils.isEmpty(str)))
        {
          i = localSharedPreferences.getInt("themeLength", 7);
          j = localSharedPreferences.getInt("themeIndex", 0);
          long l = localSharedPreferences.getLong("startTime", -28800L);
          int k = TimeZone.getTimeZone("GMT+8").getRawOffset();
          if (System.currentTimeMillis() <= l) {
            break label503;
          }
          i = ((int)Math.ceil((System.currentTimeMillis() + k) / 86400000L) - (int)Math.ceil((l + k) / 86400000L)) % i;
          if (QLog.isColorLevel()) {
            QLog.d("Theme.ThemeUtil", 2, "getWeekLoopTheme nIndex:" + j + ", tIndex:" + i);
          }
          if (j != i)
          {
            localJSONArray = new JSONArray(str);
            if (localJSONArray.length() > 0)
            {
              if (i < localJSONArray.length()) {
                break label500;
              }
              i = 0;
              localObject2 = localJSONArray.getJSONObject(i);
              if (localObject2 != null)
              {
                str = ((JSONObject)localObject2).getString("id");
                if (localObject2 == null) {
                  continue;
                }
                localObject2 = ((JSONObject)localObject2).getString("version");
                if ((android.text.TextUtils.isEmpty(str)) || (android.text.TextUtils.isEmpty((CharSequence)localObject2))) {
                  continue;
                }
                ThemeUtil.ThemeInfo localThemeInfo = getThemeInfo(paramAppInterface.a(), str);
                if ((localThemeInfo == null) || (!((String)localObject2).equals(localThemeInfo.version))) {
                  continue;
                }
                boolean bool = "5".equals(localThemeInfo.status);
                if (!bool) {
                  continue;
                }
              }
            }
          }
        }
      }
      catch (Exception localException1)
      {
        String str;
        JSONArray localJSONArray;
        Object localObject2;
        paramAppInterface = null;
        QLog.e("Theme.ThemeUtil", 1, "getWeekLoopTheme error:" + localException1.getMessage());
        return paramAppInterface;
      }
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("Theme.ThemeUtil", 2, "getWeekLoopTheme ok: sThemeId = " + str);
        }
        setCurrentThemeIdVersion(paramAppInterface, str, (String)localObject2);
        paramAppInterface = localSharedPreferences.edit();
        paramAppInterface.putInt("themeIndex", i);
        paramAppInterface.commit();
        paramAppInterface = str;
      }
      catch (Exception localException3)
      {
        paramAppInterface = localException1;
        Object localObject1 = localException3;
        continue;
      }
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("Theme.ThemeUtil", 2, "getWeekLoopTheme seriesID || themeArray = null");
        }
        return paramAppInterface;
      }
      catch (Exception localException2)
      {
        continue;
      }
      str = null;
      continue;
      localObject2 = null;
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("Theme.ThemeUtil", 2, "getWeekLoopTheme waitting: sThemeId = " + str);
      }
      ((ThemeHandler)((QQAppInterface)paramAppInterface).a(14)).a(localJSONArray, i, "206", 0);
      paramAppInterface = null;
      continue;
      label500:
      continue;
      label503:
      int i = j;
    }
  }
  
  public static void initTheme(QQAppInterface paramQQAppInterface)
  {
    if ((!paramQQAppInterface.isLogin()) || ((!android.text.TextUtils.isEmpty(uin)) && (uin.equals(paramQQAppInterface.a())))) {}
    BaseApplicationImpl localBaseApplicationImpl;
    String str1;
    String str2;
    label231:
    String str3;
    File localFile;
    do
    {
      return;
      uin = paramQQAppInterface.a();
      localBaseApplicationImpl = BaseApplicationImpl.a;
      localObject = getCurrentThemeInfo().getString("themeId");
      str1 = getUserThemeIDForReset(paramQQAppInterface);
      str2 = getUserCurrentThemeVersion(paramQQAppInterface);
      if (QLog.isColorLevel()) {
        QLog.i("Theme.ThemeUtil", 2, "initTheme,userThemeId=" + str1 + ",currentThemeId=" + (String)localObject);
      }
      if (str1.equals("1000"))
      {
        i = getUinThemePreferences(paramQQAppInterface).getInt("themeAuthResult", 0);
        if (i != 0)
        {
          if (Build.VERSION.SDK_INT <= 8) {
            break label231;
          }
          getUinThemePreferences(paramQQAppInterface).edit().putInt("stripUserTheme", i).remove("themeAuthResult").apply();
        }
      }
      for (;;)
      {
        if (((String)localObject).equals(str1)) {
          break label597;
        }
        if (!str1.equals("1000")) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.i("Theme.ThemeUtil", 1, "initTheme reset user to default theme, currentThemeId:" + (String)localObject);
        }
        SkinEngine.getInstances().setSkinRootPath(localBaseApplicationImpl, null);
        return;
        getUinThemePreferences(paramQQAppInterface).edit().putInt("stripUserTheme", i).remove("themeAuthResult").commit();
      }
      str3 = getThemeResourcePath(localBaseApplicationImpl, str1, str2);
      localFile = new File(str3);
      if (QLog.isColorLevel()) {
        QLog.i("Theme.ThemeUtil", 2, "initTheme reset user theme resourcePath=" + str3 + ",dir exists=" + localFile.exists() + ", currentThemeId:" + (String)localObject);
      }
      if (!localFile.exists()) {
        break;
      }
      SkinEngine.getInstances().setSkinRootPath(localBaseApplicationImpl, str3);
    } while (!QLog.isColorLevel());
    int i = ThemeJsPlugin.getFileNumInFile(localFile);
    QLog.i("Theme.ThemeUtil", 1, "initTheme set theme: userThemePath:" + str3 + ", fileNum:" + i);
    return;
    QLog.i("Theme.ThemeUtil", 1, "initTheme reset user to default theme: !userThemeDir.exists(), userThemePath:" + str3);
    Object localObject = getThemeInfo(localBaseApplicationImpl, str1);
    if ((localObject != null) && (!android.text.TextUtils.isEmpty(((ThemeUtil.ThemeInfo)localObject).version)) && (!((ThemeUtil.ThemeInfo)localObject).version.equals(str2)))
    {
      localObject = getThemeResourcePath(localBaseApplicationImpl, str1, ((ThemeUtil.ThemeInfo)localObject).version);
      if (new File((String)localObject).exists())
      {
        SkinEngine.getInstances().setSkinRootPath(localBaseApplicationImpl, (String)localObject);
        QLog.i("Theme.ThemeUtil", 1, "initTheme set theme: nextPath:" + (String)localObject);
        return;
      }
      QLog.i("Theme.ThemeUtil", 1, "initTheme reset user to default theme: !nextThemeDir.exists(), nextPath:" + (String)localObject);
      SkinEngine.getInstances().setSkinRootPath(localBaseApplicationImpl, null);
      setCurrentThemeIdVersion(paramQQAppInterface, "1000", "0");
      return;
    }
    SkinEngine.getInstances().setSkinRootPath(localBaseApplicationImpl, null);
    setCurrentThemeIdVersion(paramQQAppInterface, "1000", "0");
    return;
    label597:
    paramQQAppInterface = SkinEngine.getInstances().getSkinRootPath();
    if ((paramQQAppInterface != null) && (paramQQAppInterface.length() > 0) && (((String)localObject).equals("1000")))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Theme.ThemeUtil", 2, "initTheme reset user to default theme for old version,currentThemeResPath=" + paramQQAppInterface);
      }
      SkinEngine.getInstances().setSkinRootPath(localBaseApplicationImpl, null);
    }
    QLog.i("Theme.ThemeUtil", 1, "initTheme theme currentThemeResPath:" + paramQQAppInterface);
  }
  
  public static boolean isDefaultOrDIYTheme()
  {
    String str = getUserCurrentThemeId(null);
    return ("1000".equals(str)) || ("999".equals(str));
  }
  
  public static boolean isInNightMode(AppRuntime paramAppRuntime)
  {
    return "1103".equals(getUserCurrentThemeId(paramAppRuntime));
  }
  
  public static boolean isNowThemeIsDefault(AppRuntime paramAppRuntime, boolean paramBoolean, String paramString)
  {
    String str = paramString;
    if (android.text.TextUtils.isEmpty(paramString)) {
      if (!paramBoolean) {
        break label25;
      }
    }
    label25:
    for (str = getUserCurrentThemeId(paramAppRuntime);; str = getCurrentThemeId()) {
      return "1000".equals(str);
    }
  }
  
  public static boolean isNowThemeIsNight(AppRuntime paramAppRuntime, boolean paramBoolean, String paramString)
  {
    String str = paramString;
    if (android.text.TextUtils.isEmpty(paramString)) {
      if (!paramBoolean) {
        break label25;
      }
    }
    label25:
    for (str = getUserCurrentThemeId(paramAppRuntime);; str = getCurrentThemeId()) {
      return "1103".equals(str);
    }
  }
  
  public static void resetThemeSwitchTimes(QQAppInterface paramQQAppInterface)
  {
    getUinThemePreferences(paramQQAppInterface).edit().putInt("user_switch_theme_times", 0).commit();
    paramQQAppInterface = paramQQAppInterface.getPreferences().edit();
    paramQQAppInterface.putInt("user_switch_theme_times", 0);
    paramQQAppInterface.commit();
    if (QLog.isColorLevel()) {
      QLog.d("Theme.ThemeUtil", 2, "resetThemeSwitchTimes");
    }
  }
  
  public static Boolean setCurrentThemeIdVersion(AppRuntime paramAppRuntime, String paramString1, String paramString2)
  {
    AppRuntime localAppRuntime1;
    if (paramAppRuntime == null)
    {
      paramAppRuntime = (AppInterface)BaseApplicationImpl.a.a();
      QLog.e("Theme.ThemeUtil", 1, "setCurrentThemeIdVersion,application == null");
      localAppRuntime1 = paramAppRuntime;
      if (paramAppRuntime == null) {
        return Boolean.valueOf(false);
      }
    }
    else
    {
      localAppRuntime1 = paramAppRuntime;
    }
    if ((android.text.TextUtils.isEmpty(paramString1)) || (android.text.TextUtils.isEmpty(paramString2)))
    {
      if (QLog.isColorLevel()) {
        QLog.e("Theme.ThemeUtil", 1, "setCurrentThemeIdVersion,themeId or version == null, themeId:" + paramString1 + "version:" + paramString2);
      }
      return Boolean.valueOf(false);
    }
    long l = System.currentTimeMillis();
    Object localObject1 = getUinThemePreferences(localAppRuntime1);
    paramAppRuntime = localAppRuntime1.getAccount();
    AppRuntime localAppRuntime2 = paramAppRuntime;
    if (paramAppRuntime == null)
    {
      paramAppRuntime = "noLogin";
      localAppRuntime2 = paramAppRuntime;
      if (QLog.isColorLevel())
      {
        QLog.d("Theme.ThemeUtil", 2, "setCurrentThemeIdVersion , uin=noLogin");
        localAppRuntime2 = paramAppRuntime;
      }
    }
    String str1 = ((SharedPreferences)localObject1).getString("currentThemeId_6.3.5", "1000");
    int j = ((SharedPreferences)localObject1).getInt("user_switch_theme_times", 0) + 1;
    paramAppRuntime = ((SharedPreferences)localObject1).edit();
    paramAppRuntime.putString("currentThemeId_6.3.5", paramString1);
    paramAppRuntime.putString("currentThemeVersion", paramString2);
    paramAppRuntime.putInt("user_switch_theme_times", j);
    paramAppRuntime.putLong("themeSetTimeKey", l);
    boolean bool3 = paramAppRuntime.commit();
    localObject1 = localAppRuntime1.getApplication().getSharedPreferences(localAppRuntime2, 4);
    Object localObject2 = ((SharedPreferences)localObject1).edit();
    ((SharedPreferences.Editor)localObject2).putString("currentThemeId_6.3.5", paramString1);
    ((SharedPreferences.Editor)localObject2).putString("currentThemeVersion", paramString2);
    ((SharedPreferences.Editor)localObject2).putInt("user_switch_theme_times", j);
    boolean bool2 = ((SharedPreferences.Editor)localObject2).commit();
    int i;
    boolean bool1;
    if (!bool3)
    {
      localObject2 = BaseApplicationImpl.a();
      String str2 = localAppRuntime2 + "_stheme";
      if (Build.VERSION.SDK_INT > 8)
      {
        i = 4;
        ((BaseApplicationImpl)localObject2).getSystemSharedPreferences(str2, i);
        localObject1 = ((SharedPreferences)localObject1).edit();
        ((SharedPreferences.Editor)localObject1).putString("currentThemeId_6.3.5", paramString1);
        ((SharedPreferences.Editor)localObject1).putString("currentThemeVersion", paramString2);
        ((SharedPreferences.Editor)localObject1).putInt("user_switch_theme_times", j);
        paramAppRuntime.putLong("themeSetTimeKey", l);
        bool1 = ((SharedPreferences.Editor)localObject1).commit();
        if (!bool1) {
          break label635;
        }
        paramAppRuntime = "1";
        label419:
        QLog.d("Theme.ThemeUtil", 1, "ThemeUtil setCurrentThemeIdVersion,uin=" + com.tencent.mobileqq.text.TextUtils.a(localAppRuntime2, 2) + ",currentThemeId=" + str1 + ",set new themeId=" + paramString1 + ",set new version=" + paramString2 + ", userSwitchThemeTimes=" + j + ",commitSuss=" + bool3 + ", commitSussOld=" + bool2);
      }
    }
    for (;;)
    {
      try
      {
        paramString2 = new HashMap();
        paramString2.put("param_themeId", paramString1);
        paramString2.put("param_oldSp", String.valueOf(bool2));
        paramString2.put("param_singleSp", String.valueOf(bool3));
        paramString2.put("param_sysSp", String.valueOf(paramAppRuntime));
        paramAppRuntime = StatisticCollector.a(localAppRuntime1.getApplication().getApplicationContext());
        if (bool3) {
          break label666;
        }
        if (!bool1) {
          continue;
        }
      }
      catch (Exception paramAppRuntime)
      {
        label635:
        continue;
      }
      paramAppRuntime.a(localAppRuntime2, "VipSetCurrentThemeIdVersion", bool2, 1L, 0L, paramString2, "", false);
      if ((bool3) || (bool1))
      {
        bool1 = true;
        return Boolean.valueOf(bool1);
        i = 0;
        break;
        paramAppRuntime = "2";
        break label419;
        bool2 = false;
        continue;
      }
      bool1 = false;
      continue;
      bool1 = false;
      paramAppRuntime = "0";
      break label419;
      label666:
      bool2 = true;
    }
  }
  
  public static void setErrorThemeId(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = getThemePreferences(paramContext);
    SharedPreferences.Editor localEditor = paramContext.edit();
    paramContext = paramContext.getString("listOfErrorThemeSrc", "");
    if (QLog.isColorLevel()) {
      QLog.d("Theme.ThemeUtil", 2, "ThemeUtil setErrorThemeID themeId=" + paramString);
    }
    label179:
    label198:
    label199:
    label203:
    for (;;)
    {
      int i;
      try
      {
        if (android.text.TextUtils.isEmpty(paramContext))
        {
          paramContext = new JSONObject();
          if (!paramContext.has(paramString)) {
            break label199;
          }
          i = paramContext.getInt(paramString);
          break label179;
          paramContext.put(paramString, i);
          localEditor.putString("listOfErrorThemeSrc", paramContext.toString()).commit();
          return;
        }
        paramContext = new JSONObject(paramContext);
        continue;
        i = i % 100000 + 300001;
        continue;
        QLog.d("Theme.ThemeUtil", 2, "setErrorThemeId error:" + paramContext.getMessage());
      }
      catch (Exception paramContext)
      {
        if (!QLog.isColorLevel()) {
          break label198;
        }
      }
      return;
      for (;;)
      {
        if (!paramBoolean) {
          break label203;
        }
        i = i % 100000 + 500000;
        break;
        return;
        i = 0;
      }
    }
  }
  
  public static int setSkinTheme(AppInterface paramAppInterface, String paramString1, String paramString2, Bundle paramBundle)
  {
    boolean bool = false;
    String str1 = paramString1;
    if (android.text.TextUtils.isEmpty(paramString1)) {
      str1 = "1000";
    }
    String str2 = paramString2;
    if (android.text.TextUtils.isEmpty(paramString2)) {
      str2 = "0";
    }
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.a;
    if (paramAppInterface == null) {
      QLog.e("Theme.ThemeUtil", 1, "setSkinTheme app == null");
    }
    paramString2 = getCurrentThemeInfo();
    paramString1 = paramString2.getString("themeId");
    paramString2 = paramString2.getString("version");
    if (QLog.isColorLevel()) {
      QLog.i("Theme.ThemeUtil", 2, "setSkinTheme start engineThemeId:" + paramString1 + ", engineVersion:" + paramString2 + ", id:" + str1 + ",version:" + str2);
    }
    int i;
    if (str1.equals("1000"))
    {
      if (str1.equals(paramString1)) {
        break label857;
      }
      i = 1;
    }
    for (;;)
    {
      int k = i;
      String str3;
      Object localObject;
      label185:
      int j;
      if (1 == i)
      {
        str3 = getThemeResourcePath(localBaseApplicationImpl, str1, str2);
        if (android.text.TextUtils.isEmpty(str3))
        {
          localObject = null;
          if ((localObject == null) || (((File)localObject).exists())) {
            break label506;
          }
          QLog.e("Theme.ThemeUtil", 1, "setSkinTheme error userThemePath:" + str3 + ", id:" + str1 + ",version:" + str2 + ",status:" + i);
          if ((paramBundle == null) || ("5".equals(paramBundle.getString("themeStatus"))) || (paramAppInterface == null)) {
            break label849;
          }
          NetworkUtil.a(null);
          ThreadManager.a(new uzw(paramAppInterface, paramBundle), 8, null, true);
          j = 0;
          paramAppInterface = paramString2;
        }
      }
      for (;;)
      {
        label306:
        if (QLog.isColorLevel()) {
          QLog.d("Theme.ThemeUtil", 2, "setSkinTheme end stId:" + paramString1 + ", stVersion:" + paramAppInterface + ", id:" + str1 + ",version:" + str2 + ", status:" + j);
        }
        if (!str1.equals(paramString1)) {
          QLog.e("Theme.ThemeUtil", 1, "setSkinTheme id error, stId:" + paramString1 + ", stVersion:" + paramAppInterface + ", id:" + str1 + ",version:" + str2 + ", status:" + j);
        }
        label506:
        while ((str1.equals("1000")) || (str2.equals(paramAppInterface)))
        {
          return j;
          if (str1.equals(paramString1))
          {
            if (str2.equals(paramString2)) {
              break label857;
            }
            i = 0;
            break;
          }
          i = 1;
          break;
          localObject = new File(str3);
          break label185;
          j = i;
          if (paramBundle != null)
          {
            j = i;
            if (paramBundle.getInt("themeType") == 1)
            {
              j = i;
              if ("1103".equals(paramString1))
              {
                ThemeSwitchUtil.a(paramAppInterface, str1, str2);
                if (QLog.isColorLevel()) {
                  QLog.d("Theme.ThemeUtil", 2, "setSkinTheme, THEME_ID_NIGHTMODE.");
                }
                j = 0;
              }
            }
          }
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder().append("setSkinTheme ok userThemePath:").append(str3).append(", id:").append(str1).append(",version:").append(str2).append(",status:").append(j).append(", tInfo:");
            if (paramBundle != null) {
              bool = true;
            }
            QLog.d("Theme.ThemeUtil", 2, bool);
          }
          k = j;
          if (1 != j) {
            break label840;
          }
          SkinEngine.getInstances().setSkinRootPath(localBaseApplicationImpl, str3);
          if (paramBundle != null)
          {
            setCurrentThemeIdVersion(paramAppInterface, str1, str2);
            if ((paramAppInterface != null) && ((paramAppInterface instanceof QQAppInterface)) && (((QQAppInterface)paramAppInterface).a(paramAppInterface.getApplication())) && (paramBundle.getInt("themeType") == 1)) {
              ThreadManager.c().post(new uzx(paramAppInterface));
            }
          }
          paramAppInterface = str2;
          paramString1 = str1;
          break label306;
        }
        QLog.e("Theme.ThemeUtil", 1, "setSkinTheme version error, stId:" + paramString1 + ", stVersion:" + paramAppInterface + ", id:" + str1 + ",version:" + str2 + ", status:" + j);
        return j;
        label840:
        paramAppInterface = paramString2;
        j = k;
        continue;
        label849:
        j = 0;
        paramAppInterface = paramString2;
      }
      label857:
      i = 0;
    }
  }
  
  public static Boolean setThemeInfo(Context paramContext, ThemeUtil.ThemeInfo paramThemeInfo)
  {
    paramContext = getThemePreferences(paramContext);
    SharedPreferences.Editor localEditor = paramContext.edit();
    paramContext = paramContext.getString("userDownloadTheme", "");
    if (QLog.isColorLevel()) {
      QLog.d("Theme.ThemeUtil", 2, "ThemeUtil setThemeInfo themeInfo=" + paramThemeInfo.toString() + ",userTheme=" + paramContext);
    }
    String str = paramThemeInfo.themeId;
    if (str != null)
    {
      if (paramContext != null) {}
      try
      {
        if (paramContext.length() > 0)
        {
          paramContext = new JSONObject(paramContext);
          if (!paramContext.has(str)) {
            break label267;
          }
        }
        label267:
        for (JSONObject localJSONObject = paramContext.getJSONObject(str);; localJSONObject = new JSONObject())
        {
          localJSONObject.put("downsize", paramThemeInfo.downsize);
          localJSONObject.put("size", paramThemeInfo.size);
          localJSONObject.put("version", paramThemeInfo.version);
          localJSONObject.put("status", paramThemeInfo.status);
          paramContext.put(str, localJSONObject);
          localJSONObject.put("sound", paramThemeInfo.isVoiceTheme);
          localJSONObject.put("fileNum", paramThemeInfo.fileNum);
          boolean bool = localEditor.putString("userDownloadTheme", paramContext.toString()).commit();
          if ((!bool) && (QLog.isColorLevel())) {
            QLog.d("Theme.ThemeUtil", 2, "setThemeInfo sp comit rt=" + bool);
          }
          return Boolean.valueOf(bool);
          paramContext = new JSONObject();
          break;
        }
        if (!QLog.isColorLevel()) {
          break label334;
        }
      }
      catch (Exception paramContext)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Theme.ThemeUtil", 2, "ThemeUtil setThemeInfo error:" + paramContext.getMessage());
        }
        return Boolean.valueOf(false);
      }
    }
    QLog.d("Theme.ThemeUtil", 2, "ThemeUtil setThemeInfo error themeId is null");
    label334:
    return Boolean.valueOf(false);
  }
  
  public static boolean setWeekLoopTheme(AppRuntime paramAppRuntime, String paramString1, String paramString2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Theme.ThemeUtil", 2, "setWeekLoopTheme, seriesID=" + paramString1 + ", themeArray=" + paramString2 + ", startTime=" + paramLong);
    }
    SharedPreferences localSharedPreferences = getUinThemePreferences(paramAppRuntime);
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    boolean bool2;
    if (android.text.TextUtils.isEmpty(paramString1))
    {
      if (!android.text.TextUtils.isEmpty(localSharedPreferences.getString("seriesID", null)))
      {
        localEditor.putString("seriesID", "");
        localEditor.putString("themeArray", "");
        bool2 = localEditor.commit();
        return bool2;
      }
    }
    else
    {
      try
      {
        localEditor.putString("seriesID", paramString1);
        localEditor.putString("themeArray", paramString2);
        if (android.text.TextUtils.isEmpty(paramString2)) {
          break label318;
        }
        j = new JSONArray(paramString2).length();
        if (j <= 0)
        {
          QLog.e("Theme.ThemeUtil", 2, "setWeekLoopTheme themeJsonArr Error:0 == length");
          return false;
        }
        i = TimeZone.getTimeZone("GMT+8").getRawOffset();
        if (System.currentTimeMillis() <= paramLong) {
          break label430;
        }
        i = ((int)Math.ceil((System.currentTimeMillis() + i) / 86400000L) - (int)Math.ceil((i + paramLong) / 86400000L)) % j;
      }
      catch (Exception paramAppRuntime)
      {
        for (;;)
        {
          int j;
          label286:
          label318:
          label405:
          boolean bool1 = true;
          continue;
          int i = 0;
        }
      }
      localEditor.putInt("themeLength", j);
      localEditor.putInt("themeIndex", i);
      localEditor.putLong("startTime", paramLong);
      if ((paramAppRuntime instanceof QQAppInterface))
      {
        paramAppRuntime = (QQAppInterface)paramAppRuntime;
        if (paramAppRuntime == null) {
          break label405;
        }
        ((ThemeHandler)paramAppRuntime.a(14)).a(new JSONArray(paramString2), i + 1, "203", 2);
      }
      for (;;)
      {
        bool1 = localEditor.commit();
        bool2 = bool1;
        try
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Theme.ThemeUtil", 2, "setWeekLoopTheme , setWeekLoopTheme is ok:" + bool1);
          return bool1;
        }
        catch (Exception paramAppRuntime) {}
        QLog.e("Theme.ThemeUtil", 2, "setWeekLoopTheme json Error:" + paramAppRuntime.getMessage());
        return bool1;
        paramAppRuntime = null;
        break label286;
        if (QLog.isColorLevel()) {
          QLog.d("Theme.ThemeUtil", 2, "setWeekLoopTheme , goto download null != qapp");
        }
      }
    }
    label430:
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\theme\ThemeUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */