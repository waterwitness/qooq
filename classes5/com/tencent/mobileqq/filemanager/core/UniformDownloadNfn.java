package com.tencent.mobileqq.filemanager.core;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.widget.RemoteViews;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.UniformDownloadUtil;
import com.tencent.mobileqq.filemanager.util.UniformDownloader;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import sag;
import sah;

public class UniformDownloadNfn
{
  public static final int a = 1;
  private static NotificationManager jdField_a_of_type_AndroidAppNotificationManager;
  private static UniformDownloadNfn jdField_a_of_type_ComTencentMobileqqFilemanagerCoreUniformDownloadNfn;
  public static String a;
  public static final int b = 2;
  public static final String b = "_notify_param_Id";
  public static final int c = 3;
  public static final String c = "_notify_param_Url";
  public static final int d = 4;
  public static final String d = "_notify_param_TickerText";
  public static final int e = 5;
  public static final String e = "_notify_param_ContentTitle";
  public static final int f = 6;
  public static final String f = "_notify_param_Content";
  public static final int g = 7;
  public static final String g = "_notify_param_When";
  public static final int h = -1;
  public static final String h = "_notify_param_Progress";
  public static final int i = 100;
  public static final String i = "_notify_param_FailedReaon";
  public static final String j = "_notify_param_FilePath";
  public static final String k = "_notify_param_Filename";
  public static final String l = "_notify_param_Filesize";
  public static final String m = "_notify_param_pkgname";
  public static final String n = "_notify_param_userdata";
  public static final String o = "_START_WAITING_";
  public static final String p = "_FILE_PROGRESS_";
  public static final String q = "_FILE_PATH_";
  public static final String r = "_FILE_SIZE_";
  public static final String s = "_NEW_N_ID_";
  public static final String t = "_PKG_NAME_";
  public static final String u = "_FILE_ERR_CODE_";
  public static final String v = "_FILE_ERR_STRING_";
  private long jdField_a_of_type_Long;
  protected Handler a;
  protected HandlerThread a;
  private sah jdField_a_of_type_Sah;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = "UniformDownloadNfn<FileAssistant>";
  }
  
  private UniformDownloadNfn()
  {
    try
    {
      jdField_a_of_type_AndroidAppNotificationManager = (NotificationManager)BaseApplicationImpl.getContext().getSystemService("notification");
      this.jdField_a_of_type_Sah = new sah(this, BaseApplicationImpl.getContext());
      this.jdField_a_of_type_Long = 123456L;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private int a()
  {
    return (int)(System.currentTimeMillis() & 0xFFFFFFF);
  }
  
  private long a(int paramInt)
  {
    if (paramInt == 0) {
      return this.jdField_a_of_type_Long - 30L;
    }
    if (1 == paramInt) {
      return this.jdField_a_of_type_Long - 20L;
    }
    if (2 == paramInt) {
      return this.jdField_a_of_type_Long - 10L;
    }
    if (3 == paramInt) {
      return this.jdField_a_of_type_Long;
    }
    return System.currentTimeMillis();
  }
  
  public static UniformDownloadNfn a()
  {
    if (jdField_a_of_type_ComTencentMobileqqFilemanagerCoreUniformDownloadNfn == null) {
      jdField_a_of_type_ComTencentMobileqqFilemanagerCoreUniformDownloadNfn = new UniformDownloadNfn();
    }
    return jdField_a_of_type_ComTencentMobileqqFilemanagerCoreUniformDownloadNfn;
  }
  
  private int b()
  {
    return (int)(System.currentTimeMillis() & 0xFFFFFFF);
  }
  
  public int a(UniformDownloader paramUniformDownloader, Bundle paramBundle, long paramLong, int paramInt)
  {
    if (-1 == paramInt)
    {
      paramInt = a();
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + paramLong + "]. attachDownloader.notificationId = " + paramInt);
    }
    while (paramUniformDownloader != null)
    {
      paramUniformDownloader.a(new sag(this, ThreadManager.b().getLooper(), paramInt, paramBundle, paramLong), false);
      return paramInt;
      QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + paramLong + "]. attachDownloader.here will using notificationid,maybe is not uinform id");
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + paramLong + "]. attachDownloader.dler = null. notificationId = " + paramInt);
    return paramInt;
  }
  
  public Notification a(Bundle paramBundle)
  {
    Notification localNotification = new Notification();
    if (paramBundle != null)
    {
      Object localObject = paramBundle.getString("_notify_param_ContentTitle");
      localNotification.icon = 2130840397;
      paramBundle = new RemoteViews(BaseApplication.getContext().getPackageName(), 2130904014);
      paramBundle.setImageViewResource(2131298849, 2130840393);
      paramBundle.setTextViewText(2131298851, (CharSequence)localObject);
      paramBundle.setProgressBar(2131298855, 100, 0, false);
      paramBundle.setViewVisibility(2131298853, 8);
      paramBundle.setViewVisibility(2131298854, 8);
      if (this.jdField_a_of_type_Sah.b() != null) {
        paramBundle.setTextColor(2131298851, this.jdField_a_of_type_Sah.b().intValue());
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Sah.a() != null)
        {
          paramBundle.setTextColor(2131298853, this.jdField_a_of_type_Sah.a().intValue());
          paramBundle.setTextColor(2131301005, this.jdField_a_of_type_Sah.a().intValue());
          label158:
          float f1 = this.jdField_a_of_type_Sah.a();
          if (this.jdField_a_of_type_Sah.a() <= 0.0F)
          {
            QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL]. initNotification param error. getTextSize failed. set defualt value:14");
            f1 = 14.0F;
          }
          paramBundle.setFloat(2131298853, "setTextSize", f1);
          paramBundle.setFloat(2131301005, "setTextSize", f1);
          float f2 = this.jdField_a_of_type_Sah.b();
          f1 = f2;
          if (f2 <= 0.0F)
          {
            QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL]. initNotification param error. getTitleSize failed. set defualt value:16");
            f1 = 16.0F;
          }
          paramBundle.setFloat(2131298851, "setTextSize", f1);
          localObject = BaseApplication.getContext().getApplicationInfo();
          if ((localObject == null) || (((ApplicationInfo)localObject).targetSdkVersion >= 10) || (Build.VERSION.SDK_INT <= 10)) {}
        }
        try
        {
          int i1 = this.jdField_a_of_type_Sah.b().intValue();
          paramBundle.setInt(2131301003, "setBackgroundColor", (i1 & 0xFF000000) + (-1 - i1));
          localNotification.contentView = paramBundle;
          return localNotification;
          QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL]. initNotification param error. getTitleColor failed.");
          this.jdField_a_of_type_Sah.a(BaseApplication.getContext(), true);
          if (this.jdField_a_of_type_Sah.b() != null)
          {
            paramBundle.setTextColor(2131298851, this.jdField_a_of_type_Sah.b().intValue());
          }
          else
          {
            QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL]. initNotification param error. getTitleColor failed. set defualt value");
            paramBundle.setTextColor(2131298851, -7829368);
            continue;
            QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL]. initNotification param error. getTextColor failed. ");
            this.jdField_a_of_type_Sah.a(BaseApplication.getContext(), true);
            if (this.jdField_a_of_type_Sah.a() != null)
            {
              paramBundle.setTextColor(2131298853, this.jdField_a_of_type_Sah.a().intValue());
              paramBundle.setTextColor(2131301005, this.jdField_a_of_type_Sah.a().intValue());
              break label158;
            }
            QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL]. initNotification param error. getTitleColor failed. set defualt value");
            paramBundle.setTextColor(2131298853, -7829368);
            paramBundle.setTextColor(2131301005, -7829368);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
      }
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL]. getNfn param error, NF");
    return null;
  }
  
  public void a(int paramInt)
  {
    if (jdField_a_of_type_AndroidAppNotificationManager != null) {
      jdField_a_of_type_AndroidAppNotificationManager.cancel(paramInt);
    }
  }
  
  public void a(int paramInt, Notification paramNotification, Bundle paramBundle1, Bundle paramBundle2)
  {
    if ((paramNotification == null) || (paramBundle1 == null) || (paramBundle2 == null)) {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL]. nfnUPDATE, param error. mId = " + paramInt);
    }
    label222:
    label272:
    label284:
    label296:
    for (;;)
    {
      return;
      paramNotification.tickerText = (BaseApplication.getContext().getString(2131362892) + " " + paramBundle1.getString("_notify_param_Filename"));
      paramNotification.contentView.setImageViewResource(2131298849, 2130840393);
      int i1 = paramBundle2.getInt("_START_WAITING_");
      if (1 == i1)
      {
        paramNotification.contentView.setTextViewText(2131301005, BaseApplication.getContext().getString(2131362893));
        paramNotification.contentView.setViewVisibility(2131298854, 0);
        paramNotification.contentView.setViewVisibility(2131298853, 8);
        paramNotification.contentView.setProgressBar(2131298855, 100, 0, false);
        paramNotification.flags = 34;
        paramBundle2 = new Intent("com.tencent.mobileqq.UniformDownloadNfn.PAUSE");
        paramBundle2.putExtra("_PARAM_EXTRA", paramBundle1);
        paramBundle1 = PendingIntent.getBroadcast(BaseApplication.getContext(), b(), paramBundle2, 134217728);
        if (1 != i1) {
          break label272;
        }
        paramNotification.when = a(2);
        if (Build.VERSION.SDK_INT >= 11) {
          break label284;
        }
        paramNotification.contentIntent = paramBundle1;
      }
      for (;;)
      {
        if (jdField_a_of_type_AndroidAppNotificationManager == null) {
          break label296;
        }
        try
        {
          jdField_a_of_type_AndroidAppNotificationManager.notify(paramInt, paramNotification);
          return;
        }
        catch (Exception paramNotification)
        {
          paramNotification.printStackTrace();
          return;
        }
        paramNotification.contentView.setTextViewText(2131301005, "0%");
        break;
        paramNotification.when = a(3);
        break label222;
        paramNotification.contentView.setOnClickPendingIntent(2131301003, paramBundle1);
      }
    }
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL]. sendPauseNotification param error, NF id:" + paramInt);
      return;
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL]. sendPauseNotification, NF id:" + paramInt);
    Bundle localBundle = new Bundle();
    localBundle.putInt("_FILE_PROGRESS_", paramBundle.getInt("_notify_param_Progress"));
    Notification localNotification = a(paramBundle);
    if (localNotification != null)
    {
      c(paramInt, localNotification, paramBundle, localBundle);
      UniformDownloadMgr.a().c(paramBundle.getString("_notify_param_Url"));
      return;
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL]. sendPauseNotification failed to getNfn, NF id:" + paramInt);
  }
  
  public void a(int paramInt, Bundle paramBundle1, Bundle paramBundle2)
  {
    if ((paramBundle1 == null) || (paramBundle2 == null))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL]. nfnSUCESS, param error. mId = " + paramInt);
      return;
    }
    if (jdField_a_of_type_AndroidAppNotificationManager != null) {
      jdField_a_of_type_AndroidAppNotificationManager.cancel(paramInt);
    }
    Notification localNotification = a(paramBundle1);
    String str1 = paramBundle2.getString("_FILE_PATH_");
    paramBundle2.getLong("_FILE_SIZE_");
    paramInt = paramBundle2.getInt("_NEW_N_ID_");
    String str2 = paramBundle2.getString("_PKG_NAME_");
    localNotification.tickerText = (BaseApplication.getContext().getString(2131362895) + " " + paramBundle1.getString("_notify_param_Filename"));
    Bitmap localBitmap = null;
    paramBundle2 = BaseApplication.getContext().getString(2131362897);
    if (UniformDownloadUtil.a(str1) != null)
    {
      localBitmap = UniformDownloadUtil.a(str1);
      paramBundle2 = BaseApplication.getContext().getString(2131362896);
    }
    if (localBitmap == null)
    {
      int i1 = FileManagerUtil.b(str1);
      if (i1 != 0)
      {
        localNotification.contentView.setImageViewResource(2131298849, i1);
        label195:
        localNotification.contentView.setImageViewResource(2131298849, 2130840395);
      }
    }
    for (;;)
    {
      localNotification.contentView.setViewVisibility(2131298853, 0);
      localNotification.contentView.setViewVisibility(2131298854, 8);
      localNotification.contentView.setTextViewText(2131298853, paramBundle2);
      localNotification.flags = 16;
      paramBundle2 = new Intent("com.tencent.mobileqq.UniformDownloadNfn.INSTALL");
      paramBundle2.putExtra("_PARAM_FILEPATH", str1);
      paramBundle2.putExtra("_PARAM_DL_SUC_NEW_NID", paramInt);
      if (str2 != null) {
        paramBundle2.putExtra("_PARAM_PKGNAME", str2);
      }
      localNotification.contentIntent = PendingIntent.getBroadcast(BaseApplication.getContext(), b(), paramBundle2, 134217728);
      paramBundle2 = new Intent("com.tencent.mobileqq.UniformDownloadNfn.BEDEL");
      paramBundle2.putExtra("_PARAM_DL_SUC_NEW_NID", paramInt);
      if (str2 != null) {
        paramBundle2.putExtra("_PARAM_PKGNAME", str2);
      }
      localNotification.deleteIntent = PendingIntent.getBroadcast(BaseApplication.getContext(), b(), paramBundle2, 134217728);
      localNotification.when = a(0);
      if (jdField_a_of_type_AndroidAppNotificationManager == null) {
        break;
      }
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL]. NF_SUC, NF. newNId = " + paramInt + " url:" + paramBundle1.getString("_notify_param_Url"));
      try
      {
        jdField_a_of_type_AndroidAppNotificationManager.notify(paramInt, localNotification);
        return;
      }
      catch (Exception paramBundle1)
      {
        paramBundle1.printStackTrace();
        return;
      }
      localNotification.contentView.setImageViewResource(2131298849, 2130840395);
      break label195;
      localNotification.contentView.setImageViewBitmap(2131298849, localBitmap);
    }
  }
  
  public void b(int paramInt, Notification paramNotification, Bundle paramBundle1, Bundle paramBundle2)
  {
    if ((paramNotification == null) || (paramBundle1 == null) || (paramBundle2 == null)) {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL]. nfnUPDATE, param error. mId = " + paramInt);
    }
    for (;;)
    {
      return;
      paramNotification.tickerText = null;
      paramNotification.contentView.setImageViewResource(2131298849, 2130840393);
      paramNotification.contentView.setViewVisibility(2131298853, 8);
      paramNotification.contentView.setViewVisibility(2131298854, 0);
      int i1 = paramBundle2.getInt("_FILE_PROGRESS_");
      paramNotification.contentView.setProgressBar(2131298855, 100, i1, false);
      paramNotification.contentView.setTextViewText(2131301005, "" + i1 + "%");
      paramNotification.flags = 34;
      paramBundle2 = new Intent("com.tencent.mobileqq.UniformDownloadNfn.PAUSE");
      paramBundle2.putExtra("_PARAM_EXTRA", paramBundle1);
      paramBundle1 = PendingIntent.getBroadcast(BaseApplication.getContext(), b(), paramBundle2, 134217728);
      paramNotification.when = a(3);
      if (Build.VERSION.SDK_INT < 11) {
        paramNotification.contentIntent = paramBundle1;
      }
      while (jdField_a_of_type_AndroidAppNotificationManager != null)
      {
        try
        {
          jdField_a_of_type_AndroidAppNotificationManager.notify(paramInt, paramNotification);
          return;
        }
        catch (Exception paramNotification)
        {
          paramNotification.printStackTrace();
          return;
        }
        paramNotification.contentView.setOnClickPendingIntent(2131301003, paramBundle1);
      }
    }
  }
  
  public void b(int paramInt, Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL]. sendStartAndWatingNotification param error, NF id:" + paramInt);
      return;
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL]. sendStartAndWatingNotification, NF id:" + paramInt);
    Bundle localBundle = new Bundle();
    localBundle.putInt("_FILE_PROGRESS_", 0);
    localBundle.putInt("_START_WAITING_", 1);
    Notification localNotification = a(paramBundle);
    if (localNotification != null)
    {
      a(paramInt, localNotification, paramBundle, localBundle);
      UniformDownloadMgr.a().a(paramBundle.getString("_notify_param_Url"), paramBundle.getString("_notify_param_Filename"), paramBundle.getLong("_notify_param_Filesize"), paramBundle.getBundle("_notify_param_userdata"), paramInt, true);
      return;
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL]. sendStartAndWatingNotification failed to getNfn, NF id:" + paramInt);
  }
  
  public void c(int paramInt, Notification paramNotification, Bundle paramBundle1, Bundle paramBundle2)
  {
    if ((paramNotification == null) || (paramBundle1 == null) || (paramBundle2 == null))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL]. nfnPUASE, param error. mId = " + paramInt);
      return;
    }
    if (jdField_a_of_type_AndroidAppNotificationManager != null) {
      jdField_a_of_type_AndroidAppNotificationManager.cancel(paramInt);
    }
    paramNotification.tickerText = null;
    int i1 = paramBundle2.getInt("_FILE_PROGRESS_");
    paramNotification.contentView.setImageViewResource(2131298849, 2130840396);
    paramNotification.contentView.setViewVisibility(2131298853, 0);
    paramNotification.contentView.setViewVisibility(2131298854, 8);
    paramNotification.contentView.setTextViewText(2131298853, BaseApplication.getContext().getString(2131362894));
    paramNotification.contentView.setProgressBar(2131298855, 100, i1, false);
    paramNotification.contentView.setTextViewText(2131301005, "" + i1 + "%");
    paramNotification.flags = 16;
    paramBundle2 = new Intent("com.tencent.mobileqq.UniformDownloadNfn.DO_DOWNLOAD");
    paramBundle2.putExtra("_PARAM_EXTRA", paramBundle1);
    paramBundle2 = PendingIntent.getBroadcast(BaseApplication.getContext(), b(), paramBundle2, 134217728);
    paramNotification.when = a(1);
    if (Build.VERSION.SDK_INT < 11) {
      paramNotification.contentIntent = paramBundle2;
    }
    for (;;)
    {
      paramBundle2 = new Intent("com.tencent.mobileqq.UniformDownloadNfn.BEDEL");
      paramBundle2.putExtra("_PARAM_EXTRA", paramBundle1);
      paramNotification.deleteIntent = PendingIntent.getBroadcast(BaseApplication.getContext(), b(), paramBundle2, 134217728);
      if (jdField_a_of_type_AndroidAppNotificationManager == null) {
        break;
      }
      try
      {
        jdField_a_of_type_AndroidAppNotificationManager.notify(paramInt, paramNotification);
        return;
      }
      catch (Exception paramNotification)
      {
        paramNotification.printStackTrace();
        return;
      }
      paramNotification.contentView.setOnClickPendingIntent(2131301003, paramBundle2);
    }
  }
  
  public void c(int paramInt, Bundle paramBundle)
  {
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL]. sendCancelNotification, NF id:" + paramInt);
    a(paramInt);
    if (paramBundle != null) {
      UniformDownloadMgr.a().c(paramBundle.getString("_notify_param_Url"));
    }
  }
  
  public void d(int paramInt, Notification paramNotification, Bundle paramBundle1, Bundle paramBundle2)
  {
    if ((paramNotification == null) || (paramBundle1 == null) || (paramBundle2 == null))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL]. nfnFAILED, param error. mId = " + paramInt);
      return;
    }
    if (jdField_a_of_type_AndroidAppNotificationManager != null) {
      jdField_a_of_type_AndroidAppNotificationManager.cancel(paramInt);
    }
    paramNotification.contentView.setViewVisibility(2131298854, 8);
    int i1 = paramBundle2.getInt("_FILE_ERR_CODE_");
    if (2 == i1)
    {
      paramNotification.tickerText = BaseApplication.getContext().getString(2131362898);
      paramNotification.contentView.setTextViewText(2131298853, BaseApplication.getContext().getString(2131362898));
      label113:
      paramNotification.contentView.setImageViewResource(2131298849, 2130840394);
      paramNotification.contentView.setViewVisibility(2131298853, 0);
      paramNotification.contentView.setTextViewText(2131301005, " ");
      paramNotification.flags = 16;
      paramBundle2 = new Intent("com.tencent.mobileqq.UniformDownloadNfn.TRY_DOWNLOAD");
      paramBundle2.putExtra("_PARAM_EXTRA", paramBundle1);
      paramBundle2 = PendingIntent.getBroadcast(BaseApplication.getContext(), b(), paramBundle2, 134217728);
      paramNotification.when = a(1);
      if (Build.VERSION.SDK_INT >= 11) {
        break label357;
      }
      paramNotification.contentIntent = paramBundle2;
    }
    for (;;)
    {
      paramBundle2 = new Intent("com.tencent.mobileqq.UniformDownloadNfn.BEDEL");
      paramBundle2.putExtra("_PARAM_EXTRA", paramBundle1);
      paramNotification.deleteIntent = PendingIntent.getBroadcast(BaseApplication.getContext(), b(), paramBundle2, 134217728);
      if (jdField_a_of_type_AndroidAppNotificationManager == null) {
        break;
      }
      try
      {
        jdField_a_of_type_AndroidAppNotificationManager.notify(paramInt, paramNotification);
        return;
      }
      catch (Exception paramNotification)
      {
        paramNotification.printStackTrace();
        return;
      }
      paramNotification.tickerText = (BaseApplication.getContext().getString(2131362899) + " " + paramBundle1.getString("_notify_param_Filename"));
      paramNotification.contentView.setTextViewText(2131298853, UniformDownloader.a(i1) + "，点击重试");
      break label113;
      label357:
      paramNotification.contentView.setOnClickPendingIntent(2131301003, paramBundle2);
    }
  }
  
  public void d(int paramInt, Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL]. sendResumeNotification param error, NF id:" + paramInt);
      return;
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL]. sendResumeNotification, NF id:" + paramInt);
    int i1 = paramBundle.getInt("_notify_param_Progress");
    Bundle localBundle = new Bundle();
    localBundle.putInt("_FILE_PROGRESS_", i1);
    Notification localNotification = a(paramBundle);
    if (localNotification != null)
    {
      e(paramInt, localNotification, paramBundle, localBundle);
      UniformDownloadMgr.a().a(paramBundle.getString("_notify_param_Url"), paramBundle.getString("_notify_param_Filename"), paramBundle.getLong("_notify_param_Filesize"), paramBundle.getBundle("_notify_param_userdata"), paramInt, true);
      return;
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL]. sendStartAndWatingNotification failed to getNfn, NF id:" + paramInt);
  }
  
  public void e(int paramInt, Notification paramNotification, Bundle paramBundle1, Bundle paramBundle2)
  {
    if ((paramNotification == null) || (paramBundle1 == null) || (paramBundle2 == null)) {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL]. nfnRESUME, param error. mId = " + paramInt);
    }
    for (;;)
    {
      return;
      if (jdField_a_of_type_AndroidAppNotificationManager != null) {
        jdField_a_of_type_AndroidAppNotificationManager.cancel(paramInt);
      }
      paramNotification.tickerText = null;
      paramNotification.contentView.setImageViewResource(2131298849, 2130840393);
      paramNotification.contentView.setViewVisibility(2131298853, 8);
      paramNotification.contentView.setViewVisibility(2131298854, 0);
      int i1 = paramBundle2.getInt("_FILE_PROGRESS_");
      paramNotification.contentView.setProgressBar(2131298855, 100, i1, false);
      paramNotification.contentView.setTextViewText(2131301005, BaseApplication.getContext().getString(2131362893));
      paramNotification.flags = 34;
      paramBundle2 = new Intent("com.tencent.mobileqq.UniformDownloadNfn.PAUSE");
      paramBundle2.putExtra("_PARAM_EXTRA", paramBundle1);
      paramBundle1 = PendingIntent.getBroadcast(BaseApplication.getContext(), b(), paramBundle2, 134217728);
      paramNotification.when = a(2);
      if (Build.VERSION.SDK_INT < 11) {
        paramNotification.contentIntent = paramBundle1;
      }
      while (jdField_a_of_type_AndroidAppNotificationManager != null)
      {
        try
        {
          jdField_a_of_type_AndroidAppNotificationManager.notify(paramInt, paramNotification);
          return;
        }
        catch (Exception paramNotification)
        {
          paramNotification.printStackTrace();
          return;
        }
        paramNotification.contentView.setOnClickPendingIntent(2131301003, paramBundle1);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\core\UniformDownloadNfn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */