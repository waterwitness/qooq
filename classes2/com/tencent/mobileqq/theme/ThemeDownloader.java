package com.tencent.mobileqq.theme;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vaswebviewplugin.ThemeJsPlugin;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import uzq;

public class ThemeDownloader
{
  public static final int a = 1;
  static final String jdField_a_of_type_JavaLangString = "ThemeDownloader";
  public static final int b = 2;
  public static final String b = "withoutFlowTips";
  public static final int c = 3;
  public static final String c = "isJumpTop";
  public static final String d = "getStatus";
  public static final String e = "errCode";
  public static final String f = "net_type";
  public Bundle a;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  public QQAppInterface a;
  public ThemeDownloader.ThemeDownloadListener a;
  ThemeDownloader.ThemeUnzipListener jdField_a_of_type_ComTencentMobileqqThemeThemeDownloader$ThemeUnzipListener;
  ThemeUtil.ThemeInfo jdField_a_of_type_ComTencentMobileqqThemeThemeUtil$ThemeInfo;
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  DownloadListener jdField_a_of_type_ComTencentMobileqqVipDownloadListener;
  String g;
  
  public ThemeDownloader(AppInterface paramAppInterface, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new uzq(this, "param_WIFIThemeDownloadFlow", "param_XGThemeDownloadFlow");
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.g = paramString;
    if ((paramAppInterface instanceof QQAppInterface))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramAppInterface);
      if (QLog.isColorLevel()) {
        QLog.i("ThemeDownloader", 2, "ThemeDownloader qqApp == null!!");
      }
    }
    if (paramAppInterface == null) {
      QLog.e("ThemeDownloader", 1, "ThemeDownloader app == null!!");
    }
  }
  
  void a(Context paramContext, ThemeUtil.ThemeInfo paramThemeInfo, Bundle paramBundle)
  {
    if ((paramContext == null) || (paramThemeInfo == null))
    {
      QLog.e("ThemeDownloader", 2, "ThemeDownloader startDownload null == context || null == themeInfo;");
      a(paramBundle, -8, null);
      return;
    }
    paramContext = new File(ThemeUtil.getThemeDownloadFilePath(paramContext, paramThemeInfo.themeId, paramThemeInfo.version));
    paramContext = new DownloadTask(paramThemeInfo.downloadUrl, paramContext);
    if (paramBundle == null) {}
    for (boolean bool = true;; bool = paramBundle.getBoolean("isJumpTop", true))
    {
      paramContext.b = bool;
      int i = (int)(paramThemeInfo.size / 50L);
      if (i > 2048) {
        paramContext.b(i);
      }
      paramContext.b(false);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
        break;
      }
      ((DownloaderFactory)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46)).a(1).a(paramContext, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, paramBundle);
      return;
    }
  }
  
  void a(Bundle paramBundle, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqThemeThemeDownloader$ThemeUnzipListener != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqThemeThemeDownloader$ThemeUnzipListener.a(paramBundle, paramInt, this);
      if (QLog.isColorLevel()) {
        QLog.d("ThemeDownloader", 2, "unzipCallback stateCode:" + paramInt + ", from:" + this.g);
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ThemeDownloader", 2, "ThemeDownloader unzipCallback outSideListener == null;");
  }
  
  public void a(Bundle paramBundle, int paramInt, DownloadTask paramDownloadTask)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqThemeThemeDownloader$ThemeDownloadListener != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqThemeThemeDownloader$ThemeDownloadListener.a(paramBundle, paramInt, paramDownloadTask, this);
      if (QLog.isColorLevel()) {
        QLog.d("ThemeDownloader", 2, "callback stateCode:" + paramInt + ", from:" + this.g);
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ThemeDownloader", 2, "ThemeDownloader callback outSideListener == null;");
  }
  
  public boolean a(Context paramContext, Bundle paramBundle, ThemeDownloader.ThemeDownloadListener paramThemeDownloadListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqThemeThemeDownloader$ThemeDownloadListener = paramThemeDownloadListener;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    boolean bool;
    if ((paramContext == null) || (paramBundle == null))
    {
      paramThemeDownloadListener = new StringBuilder().append("downloadTheme input data Error1:");
      if (paramContext == null)
      {
        bool = true;
        paramContext = paramThemeDownloadListener.append(bool);
        if (paramBundle != null) {
          break label123;
        }
      }
      label123:
      for (bool = true;; bool = false)
      {
        QLog.e("ThemeDownloader", 1, bool + ", from:" + this.g);
        a(paramBundle, -8, null);
        ThemeReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "theme_detail", this.g, 153, -1, -8, "", "", ThemeReporter.t, "0");
        return false;
        bool = false;
        break;
      }
    }
    paramThemeDownloadListener = paramBundle.getString("url");
    String str1 = paramBundle.getString("themeId");
    String str2 = paramBundle.getString("version");
    long l1 = paramBundle.getLong("size", 0L);
    int j = paramBundle.getInt("isSound", 0);
    if (QLog.isColorLevel()) {
      QLog.d("ThemeDownloader", 2, "downloadTheme themeId=" + str1 + ",ver=" + str2 + ",size=" + l1 + ",isSound=" + j + ", url=" + paramThemeDownloadListener + ", from:" + this.g);
    }
    if ("999".equals(str1))
    {
      a(this.jdField_a_of_type_AndroidOsBundle, 2, null);
      return true;
    }
    if ((TextUtils.isEmpty(paramThemeDownloadListener)) || (TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)) || (l1 == 0L))
    {
      paramContext = new StringBuilder().append("downloadTheme input data Error2:").append(TextUtils.isEmpty(paramThemeDownloadListener)).append(TextUtils.isEmpty(str1)).append(TextUtils.isEmpty(str2));
      if (l1 == 0L) {}
      for (bool = true;; bool = false)
      {
        QLog.e("ThemeDownloader", 1, bool + ", from:" + this.g);
        a(paramBundle, -8, null);
        ThemeReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "theme_detail", this.g, 153, -1, -8, "", "", ThemeReporter.t, "1");
        return false;
      }
    }
    String str3 = EmosmUtils.a("VIP_theme", paramThemeDownloadListener);
    ThemeReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "theme_detail", this.g, 153, -1, 7, str1, str2, ThemeReporter.t, "");
    paramThemeDownloadListener = ThemeUtil.getThemeInfo(paramContext, str1);
    int i;
    if (paramThemeDownloadListener == null)
    {
      paramThemeDownloadListener = new ThemeUtil.ThemeInfo();
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        paramThemeDownloadListener.themeId = str1;
        paramThemeDownloadListener.version = str2;
        paramThemeDownloadListener.size = l1;
        paramThemeDownloadListener.downsize = 0L;
        if (j != 1) {
          break label644;
        }
      }
      label644:
      for (bool = true;; bool = false)
      {
        paramThemeDownloadListener.isVoiceTheme = bool;
        paramThemeDownloadListener.fileNum = 0;
        paramThemeDownloadListener.status = "1";
        if (!a(paramContext, str1, str2, paramThemeDownloadListener.fileNum)) {
          break label650;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ThemeDownloader", 2, "downloadTheme isThemeFilesExist=true , from:" + this.g);
        }
        if (i != 0)
        {
          paramThemeDownloadListener.status = "5";
          ThemeUtil.setThemeInfo(paramContext, paramThemeDownloadListener);
        }
        a(paramBundle, 3, null);
        return true;
        if ((str2.equals(paramThemeDownloadListener.version)) && (l1 == paramThemeDownloadListener.size)) {
          break label1185;
        }
        i = 1;
        break;
      }
      label650:
      if (QLog.isColorLevel()) {
        QLog.d("ThemeDownloader", 2, "downloadTheme isThemeFilesExist=false , from:" + this.g);
      }
      if (a(paramContext, str1, str2, l1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ThemeDownloader", 2, "downloadTheme isThemeZipExist=true , from:" + this.g);
        }
        if ((i != 0) || (!"5".equals(paramThemeDownloadListener.status)))
        {
          paramThemeDownloadListener.status = "3";
          ThemeUtil.setThemeInfo(paramContext, paramThemeDownloadListener);
        }
        a(paramBundle, 2, null);
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ThemeDownloader", 2, "downloadTheme isThemeZipExist=false , from:" + this.g);
      }
      if (!Utils.b())
      {
        QLog.e("ThemeDownloader", 1, "downloadTheme SDCard not available., from:" + this.g);
        a(paramBundle, -11, null);
        return false;
      }
      long l2 = Utils.b();
      if (l2 < 5242880 + l1)
      {
        QLog.e("ThemeDownloader", 1, "downloadTheme Insufficient SDCard space, required:" + l1 + "| reserved:" + 5242880 + "|available:" + l2 + " from:" + this.g);
        a(paramBundle, -12, null);
        return false;
      }
      if (!NetworkUtil.e(paramContext))
      {
        QLog.e("ThemeDownloader", 1, "downloadTheme I No network access., from:" + this.g);
        a(paramBundle, -13, null);
        return false;
      }
      if (i != 0) {
        ThemeUtil.setThemeInfo(paramContext, paramThemeDownloadListener);
      }
      this.jdField_a_of_type_ComTencentMobileqqThemeThemeUtil$ThemeInfo = paramThemeDownloadListener;
      this.jdField_a_of_type_ComTencentMobileqqThemeThemeUtil$ThemeInfo.downloadUrl = str3;
      this.jdField_a_of_type_AndroidOsBundle.putInt("srcType", 4);
      i = paramBundle.getInt("net_type", 2);
      j = NetworkUtil.a(paramContext);
      switch (i)
      {
      }
      do
      {
        do
        {
          a(paramContext, this.jdField_a_of_type_ComTencentMobileqqThemeThemeUtil$ThemeInfo, this.jdField_a_of_type_AndroidOsBundle);
          return true;
        } while (2 != j);
        a(paramBundle, -41, null);
        if (QLog.isColorLevel()) {
          QLog.d("ThemeDownloader", 2, "downloadTheme NET_TYPE_WITHOUT_G2 return net not match, from:" + this.g);
        }
        return false;
      } while (1 == j);
      a(paramBundle, -41, null);
      if (QLog.isColorLevel()) {
        QLog.d("ThemeDownloader", 2, "downloadTheme NET_TYPE_ONLY_WIFI return net not match, from:" + this.g);
      }
      return false;
      label1185:
      i = 0;
    }
  }
  
  public boolean a(Context paramContext, Bundle paramBundle, ThemeDownloader.ThemeUnzipListener paramThemeUnzipListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqThemeThemeDownloader$ThemeUnzipListener = paramThemeUnzipListener;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    if ((paramContext == null) || (paramBundle == null))
    {
      paramThemeUnzipListener = new StringBuilder().append("ThemeDownloader.unzipTheme input data Error1:");
      if (paramContext == null)
      {
        bool = true;
        paramContext = paramThemeUnzipListener.append(bool);
        if (paramBundle != null) {
          break label96;
        }
      }
      label96:
      for (bool = true;; bool = false)
      {
        QLog.e("ThemeDownloader", 1, bool + ",from:" + this.g);
        a(paramBundle, -8);
        return false;
        bool = false;
        break;
      }
    }
    paramThemeUnzipListener = paramBundle.getString("url");
    String str1 = paramBundle.getString("themeId");
    String str2 = paramBundle.getString("version");
    long l = paramBundle.getLong("size", 0L);
    int n = paramBundle.getInt("isSound", 0);
    if (QLog.isColorLevel()) {
      QLog.d("ThemeDownloader", 2, "ThemeDownloader.unzipTheme themeId=" + str1 + ",ver=" + str2 + ",size=" + l + ",isSound=" + n + ", url=" + paramThemeUnzipListener + ",from:" + this.g);
    }
    if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)))
    {
      QLog.e("ThemeDownloader", 1, "ThemeDownloader.unzipTheme input data Error2:" + TextUtils.isEmpty(str1) + TextUtils.isEmpty(str2) + ",from:" + this.g);
      a(paramBundle, -8);
      return false;
    }
    String str3 = ThemeUtil.getThemeDownloadFilePath(paramContext, str1, str2);
    Object localObject = ThemeUtil.getThemeResourcePath(paramContext, str1, str2);
    int m;
    int i;
    int k;
    int j;
    if (str3 != null)
    {
      paramThemeUnzipListener = new File(str3);
      m = 0;
      i = 0;
      k = 0;
      if ((paramThemeUnzipListener != null) && (paramThemeUnzipListener.exists()) && (paramThemeUnzipListener.isFile()) && (l > 0L) && (paramThemeUnzipListener.length() == l)) {
        j = m;
      }
    }
    else
    {
      try
      {
        com.tencent.mobileqq.utils.FileUtils.a(str3, (String)localObject, false);
        j = m;
        paramThemeUnzipListener = new File((String)localObject);
        j = m;
        if (paramThemeUnzipListener.exists())
        {
          j = m;
          i = ThemeJsPlugin.getFileNumInFile(paramThemeUnzipListener);
        }
        if (i <= 0) {
          break label904;
        }
        j = 1;
        label438:
        k = j;
        j = i;
        i = k;
      }
      catch (IOException paramThemeUnzipListener)
      {
        for (;;)
        {
          File localFile;
          QLog.e("ThemeDownloader", 1, "ThemeDownloader.unzipTheme FileUtils.uncompressZip IOException:" + paramThemeUnzipListener.getMessage());
          i = 0;
        }
      }
      if (i != 0) {
        break label1182;
      }
      paramThemeUnzipListener = new File((String)localObject);
      localFile = new File(str3);
      QLog.d("ThemeDownloader", 1, "ThemeDownloader.unzipTheme DownloaderFactory.unzipResource, themeZipPath:" + str3);
    }
    label567:
    label651:
    label904:
    label1048:
    label1055:
    label1061:
    label1155:
    label1182:
    for (boolean bool = DownloaderFactory.a(localFile, paramThemeUnzipListener, false);; bool = false)
    {
      if ((i == 0) && (!bool))
      {
        com.tencent.mobileqq.utils.FileUtils.d(str3);
        QLog.e("ThemeDownloader", 1, "Theme.ThemeHandler  DownloaderFactory.unzipResource error, themeResPath" + (String)localObject);
        k = j;
        j = i;
        i = k;
      }
      for (;;)
      {
        if (j == 0)
        {
          k = i;
          if (!bool) {}
        }
        else
        {
          paramThemeUnzipListener = new File((String)localObject);
          if (paramThemeUnzipListener.exists())
          {
            j = i;
            if (i <= 0) {
              j = ThemeJsPlugin.getFileNumInFile(paramThemeUnzipListener);
            }
            k = j;
            if (j > 0) {
              break label1048;
            }
            QLog.e("ThemeDownloader", 1, "ThemeDownloader.unZipRet fileNum == 0 ,from:" + this.g);
            if (j <= 0) {
              break label1061;
            }
            localObject = ThemeUtil.getThemeInfo(paramContext, str1);
            paramThemeUnzipListener = (ThemeDownloader.ThemeUnzipListener)localObject;
            if (localObject == null) {
              paramThemeUnzipListener = new ThemeUtil.ThemeInfo();
            }
            paramThemeUnzipListener.status = "5";
            paramThemeUnzipListener.fileNum = j;
            paramThemeUnzipListener.downsize = l;
            paramThemeUnzipListener.size = l;
            paramThemeUnzipListener.themeId = str1;
            paramThemeUnzipListener.version = str2;
            if (n != 1) {
              break label1055;
            }
          }
        }
        for (bool = true;; bool = false)
        {
          paramThemeUnzipListener.isVoiceTheme = bool;
          bool = ThemeUtil.setThemeInfo(paramContext, paramThemeUnzipListener).booleanValue();
          if (QLog.isColorLevel()) {
            QLog.d("ThemeDownloader", 1, "ThemeDownloader.unzipTheme saveThemeInfo:" + bool + ", fileNum:" + j + ", themeZipPath:" + str3 + ",from:" + this.g);
          }
          if (!bool) {
            QLog.e("ThemeDownloader", 1, "ThemeDownloader.unzipTheme error, saveThemeInfo:" + bool + ", fileNum:" + j + ", themeZipPath:" + str3);
          }
          a(paramBundle, 1);
          ThemeReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "theme_detail", "201", 153, 1, 9, str1, str2, ThemeReporter.t, "");
          return true;
          paramThemeUnzipListener = null;
          break;
          j = i;
          QLog.e("ThemeDownloader", 1, "ThemeDownloader.unzipTheme fileNum == 0 ,from:" + this.g);
          j = k;
          break label438;
          if (!"999".equals(str1)) {
            break label1155;
          }
          com.tencent.open.base.FileUtils.a(paramContext, "999_540", (String)localObject);
          bool = true;
          i = 0;
          j = 1;
          break label567;
          QLog.e("ThemeDownloader", 1, "Theme.ThemeHandler error, unZipRet error, themeZipPath:" + str3);
          com.tencent.mobileqq.utils.FileUtils.d(str3);
          k = i;
          j = k;
          break label651;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ThemeDownloader", 1, "ThemeDownloader.unzipTheme false fileNum:" + j + ", themeZipPath:" + str3 + ",from:" + this.g);
        }
        ThemeReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "theme_detail", "201", 154, 1, 135, str1, str2, ThemeReporter.t, "");
        a(paramBundle, -30);
        return false;
        bool = false;
        i = 0;
        j = 0;
        continue;
        k = i;
        i = j;
        j = k;
      }
    }
  }
  
  public boolean a(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    if (paramInt > 0)
    {
      paramContext = new File(ThemeUtil.getThemeResourcePath(paramContext, paramString1, paramString2));
      if ((paramContext.exists()) && (paramContext.isDirectory()))
      {
        int i = ThemeJsPlugin.getFileNumInFile(paramContext);
        if ((i > 0) && (i >= paramInt))
        {
          if (QLog.isColorLevel()) {
            QLog.i("ThemeDownloader", 1, "isThemeFilesExist,themeId:" + paramString1 + ",version:" + paramString2 + ", themeInfo.fileNum:" + paramInt + ", fileNum:" + i + ",from:" + this.g);
          }
          return true;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("ThemeDownloader", 1, "isThemeFilesExist return false ,themeId:" + paramString1 + ",version:" + paramString2 + ", themeInfo.fileNum:" + paramInt + ",from:" + this.g);
    }
    return false;
  }
  
  public boolean a(Context paramContext, String paramString1, String paramString2, long paramLong)
  {
    paramContext = new File(ThemeUtil.getThemeDownloadFilePath(paramContext, paramString1, paramString2));
    if ((paramContext.exists()) && (paramContext.isFile()) && (paramContext.length() == paramLong))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ThemeDownloader", 2, "themeZipFile themeid:" + paramString1 + ", version:" + paramString2 + ", size" + paramLong + " already exists.from:" + this.g);
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ThemeDownloader", 2, "themeZipFile themeid:" + paramString1 + ", version:" + paramString2 + ", size" + paramLong + " not exists.from:" + this.g);
    }
    return false;
  }
  
  public boolean b(Context paramContext, Bundle paramBundle, ThemeDownloader.ThemeDownloadListener paramThemeDownloadListener)
  {
    boolean bool = true;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      if (QLog.isColorLevel()) {
        QLog.e("ThemeDownloader", 1, "downloadTheme null == app");
      }
    }
    label104:
    do
    {
      return false;
      paramThemeDownloadListener = paramBundle;
      if (paramBundle == null) {
        paramThemeDownloadListener = this.jdField_a_of_type_AndroidOsBundle;
      }
      if ((paramContext == null) || (paramThemeDownloadListener == null))
      {
        paramBundle = new StringBuilder().append("stopDownladTheme input data Error1:");
        if (paramContext == null)
        {
          bool = true;
          paramContext = paramBundle.append(bool);
          if (paramThemeDownloadListener != null) {
            break label104;
          }
        }
        for (bool = true;; bool = false)
        {
          QLog.e("ThemeDownloader", 1, bool);
          return false;
          bool = false;
          break;
        }
      }
      paramContext = paramThemeDownloadListener.getString("url");
      if (QLog.isColorLevel()) {
        QLog.d("ThemeDownloader", 2, "stopDownladTheme url=" + paramContext);
      }
      if (!TextUtils.isEmpty(paramContext)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("ThemeDownloader", 1, "downloadTheme input data Error2:" + TextUtils.isEmpty(paramContext));
    return false;
    paramContext = EmosmUtils.a("VIP_theme", paramContext);
    if (((DownloaderFactory)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46)).a(1).a(false, paramContext) == 0) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\theme\ThemeDownloader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */