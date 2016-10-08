package com.tencent.mobileqq.theme.diy;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.theme.ThemeReporter;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.ThemeUtil.ThemeInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vaswebviewplugin.ThemeJsPlugin;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONObject;

public class ThemeDiyStyleLogic
{
  static final String BUNDLE_KEY_INDEX = "index";
  static final String BUNDLE_KEY_PATH = "path";
  static final String BUNDLE_KEY_THEME_INDEX = "themeIndex";
  static final String BUNDLE_OPERATE_BACK_CODE = "operateBackCode";
  static final String BUNDLE_OPERATE_NEXT = "nextOperate";
  static final String BUNDLE_OPERATE_NOW = "nowOperate";
  static final String DIR_SCREENSHOT = AppConstants.bj + "custom_background/";
  static final String DIR_SCREENSHOT_BG = DIR_SCREENSHOT + "bg/";
  static final String DIR_SCREENSHOT_THEME = DIR_SCREENSHOT + "theme/";
  public static final int OPERATE_CODE_GO_ERROR = 8;
  public static final int OPERATE_CODE_GO_OFF = 6;
  public static final int OPERATE_CODE_GO_ON = 4;
  public static final int OPERATE_CODE_GO_WAIT = 2;
  public static final int OPERATE_CODE_NONE = 0;
  public static final int OPERATE_KEY_DEAL_BG = 14;
  public static final int OPERATE_KEY_DOWN_BG = 13;
  public static final int OPERATE_KEY_DOWN_STYLE = 12;
  public static final int OPERATE_KEY_PREPARE = 11;
  public static final int OPERATE_KEY_SAVE = 10;
  public static final int OPERATE_KEY_SAVE_SERVER = 16;
  public static final int OPERATE_KEY_SWITCH_THEME = 15;
  static final String RES_MALL_URL = "http://i.gtimg.cn/qqshow/admindata/comdata/";
  static final String RES_SHARED_PREFERENCES = "themeDIY_res_shared_key";
  public static final String SPLIT_KEY = "__";
  static final String TAG = "ThemeDiyStyleLogic";
  QQAppInterface app;
  Context mContext;
  DownloadListener mThemeDownloadListener = new ThemeDiyStyleLogic.1(this, "param_WIFIThemeDownloadFlow", "param_XGThemeDownloadFlow");
  public HashMap reportMap = new HashMap();
  public ThemeDiyStyleLogic.StyleCallBack saveDealCallBack;
  public int styleState;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ThemeDiyStyleLogic(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.app = paramQQAppInterface;
    this.mContext = paramContext;
  }
  
  public static void delOldResDir(String paramString1, String paramString2)
  {
    int i = 0;
    if (paramString1 != null) {
      try
      {
        if ((paramString1.length() > 0) && (paramString2 != null) && (paramString2.length() > 0))
        {
          paramString2 = paramString2.substring(0, paramString2.lastIndexOf(File.separator));
          File[] arrayOfFile = new File(paramString2).listFiles();
          if ((arrayOfFile != null) && (arrayOfFile.length > 0)) {
            while (i < arrayOfFile.length)
            {
              String str = arrayOfFile[i].getName();
              if (str.startsWith(paramString1))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("ThemeDiyStyleLogic", 2, "delete old theme res dir,themeId=" + paramString1 + ",dirName=" + str);
                }
                com.tencent.mobileqq.utils.FileUtils.a(paramString2 + File.separator + str);
              }
              i += 1;
            }
          }
        }
        return;
      }
      catch (Exception paramString1)
      {
        if (QLog.isColorLevel()) {
          QLog.i("ThemeDiyStyleLogic", 2, "delOldResDir Exception:" + paramString1.getMessage());
        }
      }
    }
  }
  
  public static String getDealFileName(ResData paramResData, int paramInt)
  {
    if (paramResData == null) {
      return null;
    }
    return paramInt + "__" + paramResData.id + "__" + paramResData.name;
  }
  
  public static String getDownFileName(ResData paramResData)
  {
    if (paramResData == null) {
      return "__4999__" + System.currentTimeMillis() + ".jpg";
    }
    return "__" + paramResData.id + "__" + paramResData.name;
  }
  
  public static String getPreviewBgFileName(ResData paramResData)
  {
    if (paramResData == null) {
      return null;
    }
    return "p__" + paramResData.id + "__" + paramResData.name;
  }
  
  public static int getThemeDownloadNum(Context paramContext)
  {
    paramContext.getSharedPreferences("themeDIY_res_shared_key", 0).getString("test", "");
    return 0;
  }
  
  static ThemeUtil.ThemeInfo getThemeInfoByDensity(Context paramContext, ResItemHolder paramResItemHolder)
  {
    long l = 0L;
    Object localObject2;
    Object localObject1;
    if (paramResItemHolder != null)
    {
      if (paramResItemHolder.themeInfo != null) {
        return paramResItemHolder.themeInfo;
      }
      if (paramResItemHolder.themeJson == null)
      {
        localObject2 = ThemeUtil.getThemeInfo(paramContext, "999");
        if (localObject2 == null)
        {
          localObject1 = new ThemeUtil.ThemeInfo();
          ((ThemeUtil.ThemeInfo)localObject1).downsize = 0L;
          ((ThemeUtil.ThemeInfo)localObject1).themeId = "999";
          ((ThemeUtil.ThemeInfo)localObject1).status = "1";
        }
        for (;;)
        {
          ((ThemeUtil.ThemeInfo)localObject1).isVoiceTheme = false;
          ((ThemeUtil.ThemeInfo)localObject1).version = "580";
          paramResItemHolder.themeInfo = ((ThemeUtil.ThemeInfo)localObject1);
          ThemeUtil.setThemeInfo(paramContext, (ThemeUtil.ThemeInfo)localObject1);
          return (ThemeUtil.ThemeInfo)localObject1;
          localObject1 = localObject2;
          if (!"580".equals(((ThemeUtil.ThemeInfo)localObject2).version))
          {
            ((ThemeUtil.ThemeInfo)localObject2).status = "1";
            localObject1 = localObject2;
          }
        }
      }
    }
    for (;;)
    {
      String str1;
      ThemeUtil.ThemeInfo localThemeInfo;
      try
      {
        localObject1 = paramResItemHolder.themeJson;
        String str2 = String.valueOf(paramResItemHolder.id);
        str1 = ((JSONObject)localObject1).getString("zipVersion");
        localObject2 = ThemeUtil.getThemeDensity(paramContext);
        if (QLog.isColorLevel()) {
          QLog.d("ThemeDiyStyleLogic", 2, "getThemeInfoByDensity, density:" + (String)localObject2);
        }
        if (!((String)localObject2).equals("m")) {
          break label336;
        }
        l = Long.valueOf(((JSONObject)localObject1).getString("m_size")).longValue();
        localObject1 = paramResItemHolder.pageUrl + ((JSONObject)localObject1).getString("zipm");
        localThemeInfo = ThemeUtil.getThemeInfo(paramContext, str2);
        if (localThemeInfo != null) {
          break label448;
        }
        localObject2 = new ThemeUtil.ThemeInfo();
        ((ThemeUtil.ThemeInfo)localObject2).downsize = 0L;
        ((ThemeUtil.ThemeInfo)localObject2).themeId = str2;
        ((ThemeUtil.ThemeInfo)localObject2).status = "1";
        ((ThemeUtil.ThemeInfo)localObject2).isVoiceTheme = false;
        ((ThemeUtil.ThemeInfo)localObject2).downloadUrl = ((String)localObject1);
        ((ThemeUtil.ThemeInfo)localObject2).size = l;
        ((ThemeUtil.ThemeInfo)localObject2).version = str1;
        paramResItemHolder.themeInfo = ((ThemeUtil.ThemeInfo)localObject2);
        ThemeUtil.setThemeInfo(paramContext, (ThemeUtil.ThemeInfo)localObject2);
        return (ThemeUtil.ThemeInfo)localObject2;
      }
      catch (Exception paramContext)
      {
        QLog.e("ThemeDiyStyleLogic", 1, "getThemeInfoByDensity, err=" + paramContext.getMessage());
      }
      return null;
      label336:
      if (((String)localObject2).equals("h"))
      {
        l = Long.valueOf(((JSONObject)localObject1).getString("h_size")).longValue();
        localObject1 = paramResItemHolder.pageUrl + ((JSONObject)localObject1).getString("ziph");
      }
      else if (((String)localObject2).equals("xh"))
      {
        l = Long.valueOf(((JSONObject)localObject1).getString("xh_size")).longValue();
        localObject1 = paramResItemHolder.pageUrl + ((JSONObject)localObject1).getString("zipxh");
        continue;
        label448:
        localObject2 = localThemeInfo;
        if (!str1.equals(localThemeInfo.version))
        {
          localThemeInfo.status = "1";
          localObject2 = localThemeInfo;
        }
      }
      else
      {
        localObject1 = "";
      }
    }
  }
  
  public static boolean isNeedDealDarkBri(ThemeDIYData paramThemeDIYData, int paramInt)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramThemeDIYData != null) && (paramThemeDIYData.dealInt != 0) && ((paramInt != 0) || (paramThemeDIYData.position != 0)))
    {
      bool1 = bool2;
      if (paramInt != 0)
      {
        bool1 = bool2;
        if (paramThemeDIYData.position != 1) {}
      }
    }
    else
    {
      bool1 = false;
    }
    return bool1;
  }
  
  public int dealDarkBrightness(ThemeDIYData paramThemeDIYData, Bundle paramBundle)
  {
    if ((paramThemeDIYData != null) && (paramThemeDIYData.bgDiyPicRes != null))
    {
      if (paramThemeDIYData.bgDiyPicRes.state == 5) {
        return 4;
      }
      if (paramThemeDIYData.bgDiyPicRes.state == 2)
      {
        if (isNeedDealDarkBri(paramThemeDIYData, paramBundle.getInt("themeIndex")))
        {
          paramThemeDIYData.bgDiyPicRes.state = 5;
          return 4;
        }
        paramBundle = getDealFileName(paramThemeDIYData.bgDiyPicRes, paramThemeDIYData.position);
        if (new File(paramThemeDIYData.bgDiyPicRes.path, paramBundle).exists())
        {
          paramThemeDIYData.bgDiyPicRes.state = 5;
          return 4;
        }
        String str = paramThemeDIYData.bgDiyPicRes.path + getDownFileName(paramThemeDIYData.bgDiyPicRes);
        Bundle localBundle = new Bundle();
        localBundle.putInt("nowOperate", 11);
        new ThemeDiyStyleLogic.DarkBrightnessTask(this.mContext, this.app, str, paramBundle, paramThemeDIYData, localBundle, this.saveDealCallBack).execute(new Object[0]);
      }
      return 2;
    }
    return 8;
  }
  
  public int downLoadBgPic(ResData paramResData, Bundle paramBundle)
  {
    if (paramResData == null) {
      return 8;
    }
    Object localObject = new File(paramResData.path, getDownFileName(paramResData));
    if (((File)localObject).exists())
    {
      paramResData.state = 2;
      if (QLog.isColorLevel()) {
        QLog.i("ThemeDiyStyleLogic", 2, "downLoadBgPic : file exists:" + paramResData.url);
      }
      return 4;
    }
    localObject = new DownloadTask(paramResData.url, (File)localObject);
    ((DownloaderFactory)this.app.getManager(46)).a(1).a((DownloadTask)localObject, this.mThemeDownloadListener, paramBundle);
    paramResData.state = 1;
    if (QLog.isColorLevel()) {
      QLog.i("ThemeDiyStyleLogic", 2, "downLoadBgPic : DownloaderFactory:" + paramResData.url);
    }
    return 2;
  }
  
  public int downLoadStyleZip(ResItemHolder paramResItemHolder, Bundle paramBundle, boolean paramBoolean)
  {
    if (paramResItemHolder == null)
    {
      paramBundle.putString("operateBackCode", "0");
      QLog.e("ThemeDiyStyleLogic", 1, "downLoadStyleZip : resItem == null");
      ThemeReporter.a(this.app, "theme_detail", "201", 153, NetworkUtil.a(null), -8, "", "", ThemeReporter.t, "");
      return 8;
    }
    paramResItemHolder = getThemeInfoByDensity(this.mContext, paramResItemHolder);
    if (paramResItemHolder == null)
    {
      paramBundle.putString("operateBackCode", "1");
      QLog.e("ThemeDiyStyleLogic", 1, "downLoadStyleZip : themeInfo == null");
      ThemeReporter.a(this.app, "theme_detail", "201", 153, NetworkUtil.a(null), -7, "", "", ThemeReporter.t, "");
      return 8;
    }
    QLog.i("ThemeDiyStyleLogic", 1, "downLoadStyleZip : needDown:" + paramBoolean + ", themeInfo.status:" + paramResItemHolder.status + ", themeInfo.themeId:" + paramResItemHolder.themeId + ", themeInfo.version:" + paramResItemHolder.version);
    ThemeReporter.a(this.app, "theme_detail", "201", 153, NetworkUtil.a(null), 7, paramResItemHolder.themeId, paramResItemHolder.version, ThemeReporter.t, "");
    Object localObject1 = ThemeUtil.getThemeResourcePath(this.mContext, paramResItemHolder.themeId, paramResItemHolder.version);
    Object localObject2;
    int i;
    if (paramResItemHolder.status.equals("5"))
    {
      localObject2 = new File((String)localObject1);
      if (!((File)localObject2).exists()) {
        break label674;
      }
      i = ThemeJsPlugin.getFileNumInFile((File)localObject2);
      if ((i > 0) && (i >= paramResItemHolder.fileNum))
      {
        if (QLog.isColorLevel()) {
          QLog.i("ThemeDiyStyleLogic", 2, "downLoadStyleZip fileNum ok, themeInfo.fileNum:" + paramResItemHolder.fileNum + ", fileNum:" + i + ",themeId:" + paramResItemHolder.themeId + ",version:" + paramResItemHolder.version);
        }
        ThemeReporter.a(this.app, "theme_detail", "201", 153, NetworkUtil.a(null), 3, paramResItemHolder.themeId, paramResItemHolder.version, ThemeReporter.t, "");
        return 4;
      }
      QLog.e("ThemeDiyStyleLogic", 1, "downLoadStyleZip fileNum Error, themeInfo.fileNum:" + paramResItemHolder.fileNum + ", fileNum:" + i + ",themeId:" + paramResItemHolder.themeId + ",version:" + paramResItemHolder.version);
    }
    try
    {
      localObject2 = new HashMap();
      ((HashMap)localObject2).put("param_ThemeID", paramResItemHolder.themeId);
      ((HashMap)localObject2).put("param_FailCode", "e0");
      StatisticCollector.a(this.mContext).a(this.app.getAccount(), "VipThemeDIYLocalFilesNum", false, 1L, 0L, (HashMap)localObject2, "", false);
      ThemeReporter.a(this.app, "theme_detail", "201", 153, NetworkUtil.a(null), 101, paramResItemHolder.themeId, paramResItemHolder.version, ThemeReporter.t, "");
      while ("999".equals(paramResItemHolder.themeId))
      {
        com.tencent.open.base.FileUtils.a(this.mContext, "999_540", (String)localObject1);
        paramBundle = new File((String)localObject1);
        if (paramBundle.exists())
        {
          i = ThemeJsPlugin.getFileNumInFile(paramBundle);
          if (i > 0) {
            paramResItemHolder.fileNum = i;
          }
        }
        paramResItemHolder.status = "5";
        ThemeUtil.setThemeInfo(this.mContext, paramResItemHolder);
        ThemeReporter.a(this.app, "theme_detail", "201", 153, NetworkUtil.a(null), 9, paramResItemHolder.themeId, paramResItemHolder.version, ThemeReporter.t, "");
        return 4;
        label674:
        QLog.i("ThemeDiyStyleLogic", 1, "downLoadStyleZip themeResPath dir is not exists,themeResPath=" + (String)localObject1);
      }
      localObject2 = ThemeUtil.getThemeDownloadFilePath(this.mContext, paramResItemHolder.themeId, paramResItemHolder.version);
      File localFile1 = new File((String)localObject2);
      if (localFile1.exists())
      {
        if (QLog.isColorLevel()) {
          QLog.i("ThemeDiyStyleLogic", 2, "downLoadStyleZip themePkgFile is exists,themePkgFile=" + localFile1 + ",status=" + paramResItemHolder.status);
        }
        if (localFile1.length() != paramResItemHolder.size) {
          break label1349;
        }
        delOldResDir(paramResItemHolder.themeId, (String)localObject1);
        i = 0;
        boolean bool = false;
        try
        {
          com.tencent.mobileqq.utils.FileUtils.a((String)localObject2, (String)localObject1, false);
          i = 1;
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            File localFile2;
            File localFile3;
            QLog.e("ThemeDiyStyleLogic", 1, "themediy downLoadStyleZip FileUtils.uncompressZip IOException:" + localIOException.getMessage());
          }
          QLog.e("ThemeDiyStyleLogic", 1, "themediy downLoadStyleZip unzip error, fileNum <= 0");
        }
        if (i == 0)
        {
          localFile2 = new File((String)localObject1);
          localFile3 = new File((String)localObject2);
          QLog.e("ThemeDiyStyleLogic", 1, "themediy downLoadStyleZip DownloaderFactory.unzipResource,!uncompressZipOk, themePkgPath:" + (String)localObject2);
          bool = DownloaderFactory.a(localFile3, localFile2, false);
        }
        if ((i != 0) || (bool))
        {
          localObject1 = new File((String)localObject1);
          if (((File)localObject1).exists())
          {
            i = ThemeJsPlugin.getFileNumInFile((File)localObject1);
            if (i > 0)
            {
              paramResItemHolder.status = "5";
              paramResItemHolder.fileNum = i;
              paramBoolean = ThemeUtil.setThemeInfo(this.mContext, paramResItemHolder).booleanValue();
              QLog.i("ThemeDiyStyleLogic", 1, "themediy downLoadStyleZip unzip ok, fileNum:" + i + ", saveThemeInfo:" + paramBoolean);
              ThemeReporter.a(this.app, "theme_detail", "201", 154, NetworkUtil.a(null), 30, paramResItemHolder.themeId, paramResItemHolder.version, ThemeReporter.t, "");
              return 4;
            }
          }
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("ThemeDiyStyleLogic", 2, "downLoadStyleZip themePkgFile zip error");
        }
        ThemeReporter.a(this.app, "theme_detail", "201", 154, NetworkUtil.a(null), 135, paramResItemHolder.themeId, paramResItemHolder.version, ThemeReporter.t, "");
        paramBundle.putString("operateBackCode", "3");
        com.tencent.mobileqq.utils.FileUtils.d((String)localObject2);
        QLog.e("ThemeDiyStyleLogic", 1, "themediy downLoadStyleZip FileUtils.deleteFile(themePkgPath)");
        if (!paramBoolean) {
          break;
        }
        localObject1 = new DownloadTask(paramResItemHolder.downloadUrl, localFile1);
        paramBundle.putString("id", paramResItemHolder.themeId);
        paramBundle.putString("version", paramResItemHolder.version);
        ((DownloaderFactory)this.app.getManager(46)).a(1).a((DownloadTask)localObject1, this.mThemeDownloadListener, paramBundle);
        if (QLog.isColorLevel()) {
          QLog.i("ThemeDiyStyleLogic", 2, "downLoadStyleZip : DownloaderFactory, themeId:" + paramResItemHolder.themeId + ", themeInfo.version:" + paramResItemHolder.version);
        }
        this.reportMap.put(Integer.valueOf((paramResItemHolder.themeId + "_" + paramResItemHolder.version).hashCode()), ThemeReporter.u);
        ThemeReporter.a(this.app, "theme_detail", "201", 154, NetworkUtil.a(null), 8, paramResItemHolder.themeId, paramResItemHolder.version, ThemeReporter.t, "");
        return 2;
        label1349:
        QLog.e("ThemeDiyStyleLogic", 1, "downLoadStyleZip Size Error:len=" + localFile1.length() + ", info.size=" + paramResItemHolder.size);
      }
      return 8;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\theme\diy\ThemeDiyStyleLogic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */