package com.tencent.mobileqq.filemanager.activity.fileviewer.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FMConfig;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.fileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import rsc;
import rsd;
import rse;
import rsf;
import rsg;

public class FileViewerFacade
{
  static final String a = "<FileAssistant>FileViewerFacade";
  
  public FileViewerFacade()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static int a(String paramString)
  {
    Object localObject = BaseApplication.getContext().getPackageManager();
    try
    {
      localObject = ((PackageManager)localObject).getInstalledPackages(0).iterator();
      while (((Iterator)localObject).hasNext())
      {
        PackageInfo localPackageInfo = (PackageInfo)((Iterator)localObject).next();
        if (localPackageInfo.packageName.equalsIgnoreCase(paramString))
        {
          int i = localPackageInfo.versionCode;
          return i;
        }
      }
    }
    catch (Exception paramString) {}
    return -1;
  }
  
  public static void a(Activity paramActivity, QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if (paramQQAppInterface == null) {
      if (QLog.isColorLevel()) {
        QLog.e("<FileAssistant>FileViewerFacade", 2, "app is null");
      }
    }
    do
    {
      return;
      if ((paramString1 == null) || (!FileUtil.a(paramString1)))
      {
        FMToastUtil.a(2131362811);
        return;
      }
      if (FileManagerUtil.b(paramQQAppInterface, paramString2) == true)
      {
        b(paramActivity, paramQQAppInterface, paramString1, paramString2);
        return;
      }
    } while (FileManagerUtil.a(paramQQAppInterface, paramString2) != true);
    c(paramActivity, paramQQAppInterface, paramString1, paramString2);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, FileManagerEntity paramFileManagerEntity, IFileBrowser paramIFileBrowser)
  {
    String str1 = paramFileManagerEntity.getFilePath();
    if (QLog.isColorLevel()) {
      QLog.i("<FileAssistant>FileViewerFacade", 2, "open[" + str1 + "]");
    }
    if ((str1 != null) && (str1.lastIndexOf(".rename") > 0))
    {
      String str3 = str1.replace(".rename", "");
      String str2 = str3.substring(0, str3.lastIndexOf("."));
      str3 = str3.substring(str3.lastIndexOf(".")).replaceAll("[0-9]*", "").replace("(", "").replace(")", "");
      str2 = str2 + str3;
      if (QLog.isColorLevel()) {
        QLog.i("<FileAssistant>FileViewerFacade", 2, "file maybe renmaed,realName[" + str2 + "]");
      }
      FMDialogUtil.a(paramActivity, paramActivity.getString(2131362790), 2131362792, new rsc(str2, str1, paramFileManagerEntity, paramQQAppInterface, paramActivity, paramIFileBrowser));
      return;
    }
    FileManagerUtil.b(paramActivity, paramFileManagerEntity.getFilePath());
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramString == null) || ("".equals(paramString))) {}
    int i;
    do
    {
      String str;
      do
      {
        return false;
        str = FMConfig.d(paramQQAppInterface.getApplication().getBaseContext(), "OpenForQQMusic", "SupportVersion");
      } while (str == null);
      i = Integer.valueOf(str).intValue();
    } while (a("com.tencent.qqmusic") < i);
    return b(paramQQAppInterface, paramString);
  }
  
  static void b(Activity paramActivity, QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    String str = FileUtil.a(paramString2);
    long l = FileUtil.a(paramString1);
    if (!a(paramQQAppInterface, paramString2))
    {
      paramString1 = new FileManagerReporter.fileAssistantReportData();
      paramString1.b = "file_local_qqmusic_uninstall";
      paramString1.c = str;
      paramString1.a = l;
      FileManagerReporter.a(paramQQAppInterface.a(), paramString1);
      DialogUtil.a(paramActivity, 233, paramActivity.getString(2131368409), paramActivity.getString(2131369302), new rsd(str, l, paramQQAppInterface, paramActivity), new rse()).show();
      return;
    }
    paramString2 = new FileManagerReporter.fileAssistantReportData();
    paramString2.b = "file_local_qqmusic_opened";
    paramString2.c = str;
    paramString2.a = l;
    FileManagerReporter.a(paramQQAppInterface.a(), paramString2);
    paramQQAppInterface = new Intent("com.tencent.qqmusic.forthird.activity.PLAYER2");
    paramQQAppInterface.putExtra("file_path", paramString1);
    paramQQAppInterface.putExtra("from", 268435457);
    paramActivity.startActivity(paramQQAppInterface);
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = FMConfig.d(paramQQAppInterface.getApplication().getBaseContext(), "OpenForQQMusic", "FormatSupport");
    String str = FileUtil.a(paramString);
    if ((paramQQAppInterface != null) && (str != null) && (str.length() > 0) && (paramQQAppInterface.indexOf(str) >= 0)) {}
    while (FileManagerUtil.a(paramString) == 1) {
      return true;
    }
    return false;
  }
  
  static void c(Activity paramActivity, QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    String str = FileUtil.a(paramString2);
    long l = FileUtil.a(paramString1);
    if (!c(paramQQAppInterface, paramString2))
    {
      paramString1 = new FileManagerReporter.fileAssistantReportData();
      paramString1.b = "file_local_qqbrowse_uninstall";
      paramString1.c = str;
      paramString1.a = l;
      FileManagerReporter.a(paramQQAppInterface.a(), paramString1);
      DialogUtil.a(paramActivity, 233, paramActivity.getString(2131369193), paramActivity.getString(2131369303), new rsf(str, l, paramQQAppInterface, paramActivity), new rsg()).show();
      return;
    }
    paramString2 = new FileManagerReporter.fileAssistantReportData();
    paramString2.b = "file_local_qqbrowse_opened";
    paramString2.c = str;
    paramString2.a = l;
    FileManagerReporter.a(paramQQAppInterface.a(), paramString2);
    paramQQAppInterface = new Intent("com.tencent.QQBrowser.action.sdk.document");
    paramQQAppInterface.setPackage("com.tencent.mtt");
    paramQQAppInterface.setFlags(268435456);
    paramString2 = new File(paramString1);
    paramQQAppInterface.putExtra("key_reader_sdk_id", 2);
    paramQQAppInterface.putExtra("ChannelID", paramActivity.getApplicationInfo().processName);
    paramQQAppInterface.putExtra("PosID", "4");
    paramQQAppInterface.putExtra("key_reader_sdk_path", paramString1);
    paramQQAppInterface.putExtra("key_reader_sdk_type", 0);
    paramQQAppInterface.setData(Uri.fromFile(paramString2));
    paramActivity.startActivity(paramQQAppInterface);
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramString == null) || ("".equals(paramString))) {}
    while (a("com.tencent.mtt") < 561300) {
      return false;
    }
    return FileManagerUtil.a(paramQQAppInterface, paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\activity\fileviewer\base\FileViewerFacade.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */