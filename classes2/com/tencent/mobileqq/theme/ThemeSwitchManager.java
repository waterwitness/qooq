package com.tencent.mobileqq.theme;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.HttpContinueDownloadFileProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import uzr;
import uzs;
import uzt;

public class ThemeSwitchManager
{
  public static final int a = 1;
  private static volatile ThemeSwitchManager jdField_a_of_type_ComTencentMobileqqThemeThemeSwitchManager;
  public static final String a = "ThemeSwitch";
  public static boolean a = false;
  public static final int b = 2;
  static final String b = "theme_bg_record_for_night_mode";
  public static boolean b = false;
  public static final int c = 3;
  static final String c = "series_id_record_for_night_mode";
  public static final int d = 256;
  public static final int e = 257;
  public static final int f = 258;
  public static final int g = 259;
  public static final int h = 260;
  public static final int i = 261;
  public static final int j = 262;
  public static final int k = 512;
  public static final int l = 513;
  public static final int m = 514;
  private static final int n = 501;
  public BroadcastReceiver a;
  public Context a;
  public Bitmap a;
  private View jdField_a_of_type_AndroidViewView;
  public ImageView a;
  public QQProgressDialog a;
  public Runnable a;
  public WeakReference a;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  public HashMap a;
  public MqqHandler a;
  private uzt jdField_a_of_type_Uzt;
  public boolean c;
  public String d;
  public boolean d;
  
  private ThemeSwitchManager(Activity paramActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.c = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentContext = paramActivity.getApplicationContext();
    a(paramActivity);
  }
  
  public static ThemeSwitchManager a(Activity paramActivity)
  {
    if (jdField_a_of_type_ComTencentMobileqqThemeThemeSwitchManager == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqThemeThemeSwitchManager == null) {
        jdField_a_of_type_ComTencentMobileqqThemeThemeSwitchManager = new ThemeSwitchManager(paramActivity);
      }
      return jdField_a_of_type_ComTencentMobileqqThemeThemeSwitchManager;
    }
    finally {}
  }
  
  private void a(View paramView)
  {
    if (paramView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ThemeSwitch", 2, "doAnimation, view is null");
      }
      return;
    }
    this.c = true;
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.1F);
    localAlphaAnimation.setDuration(501L);
    localAlphaAnimation.setInterpolator(new LinearInterpolator());
    localAlphaAnimation.setFillAfter(true);
    paramView.setAnimation(localAlphaAnimation);
  }
  
  private void a(AppRuntime paramAppRuntime)
  {
    if ((this.jdField_a_of_type_Uzt != null) || (!(paramAppRuntime instanceof QQAppInterface))) {
      return;
    }
    this.jdField_a_of_type_Uzt = new uzt(this, null);
    this.jdField_a_of_type_Uzt.a(new Class[] { HttpContinueDownloadFileProcessor.class });
    ((QQAppInterface)paramAppRuntime).a().a(this.jdField_a_of_type_Uzt);
  }
  
  public static void c()
  {
    b = false;
    jdField_a_of_type_Boolean = false;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    }
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ThemeSwitch", 2, "onPostThemeChanged rootView is null");
      }
      return;
    }
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.c))
    {
      a(this.jdField_a_of_type_AndroidWidgetImageView);
      this.jdField_a_of_type_AndroidViewView.postDelayed(new uzr(this), 601L);
    }
    this.jdField_a_of_type_AndroidViewView = null;
  }
  
  public void a(Activity paramActivity)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() == paramActivity)) {
      return;
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
  }
  
  public void a(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ThemeSwitch", 2, "failAlert result=" + paramBundle.getInt("result", -1) + ",message=" + paramBundle.getString("message"));
    }
    int i1 = paramBundle.getInt("result", -1);
    AppRuntime localAppRuntime;
    if ((i1 & 0x100) == 256)
    {
      a(false, true, paramBundle);
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131368389), 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492908));
      localAppRuntime = BaseApplicationImpl.a.a();
      if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
        ReportController.b((QQAppInterface)localAppRuntime, "CliOper", "", "", "Setting_tab", "Night_mode_dl_fail", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      try
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("param_FailCode", paramBundle.getString("resultMsg"));
        localHashMap.put("theme_id", paramBundle.getString("resultTheme_id"));
        localHashMap.put("theme_version", paramBundle.getString("resultTheme_version"));
        localHashMap.put("param_netType", String.valueOf(NetworkUtil.a(this.jdField_a_of_type_AndroidContentContext)));
        StatisticCollector.a(this.jdField_a_of_type_AndroidContentContext).a(((QQAppInterface)localAppRuntime).getAccount(), "VipNightThemeDowned", false, 1L, 0L, localHashMap, "", false);
        return;
      }
      catch (Exception paramBundle) {}
      if ((i1 & 0x200) == 512)
      {
        a(false, true, paramBundle);
        return;
      }
    }
  }
  
  public void a(ThemeSwitchManager.ThemeSwitchCallback paramThemeSwitchCallback, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramThemeSwitchCallback != null) && (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramThemeSwitchCallback))) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramThemeSwitchCallback);
    }
    if ((paramBoolean2) && (paramThemeSwitchCallback != null)) {
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramThemeSwitchCallback);
    }
  }
  
  public void a(AppRuntime paramAppRuntime, ThemeUtil.ThemeInfo paramThemeInfo)
  {
    Bundle localBundle = new Bundle();
    String str3;
    String str1;
    String str2;
    long l1;
    int i1;
    Object localObject;
    try
    {
      str3 = paramThemeInfo.downloadUrl;
      str1 = paramThemeInfo.version;
      str2 = paramThemeInfo.themeId;
      l1 = paramThemeInfo.size;
      if (!paramThemeInfo.isVoiceTheme) {
        break label1261;
      }
      i1 = 1;
      localBundle.putCharSequence("param_Url", str3);
      if (QLog.isColorLevel()) {
        QLog.d("ThemeSwitch", 2, "ThemeSwitchManager start download theme ver=" + str1 + ",id=" + str2 + ",size=" + l1 + ",isSound=" + i1);
      }
      if (!Utils.b())
      {
        if (QLog.isColorLevel()) {
          QLog.d("ThemeSwitch", 2, "SDCard not available.");
        }
        localBundle.putInt("result", 257);
        localBundle.putCharSequence("message", "SDCard not available.");
        localBundle.putCharSequence("resultMsg", "NSD");
        a(localBundle);
        return;
      }
      long l2 = Utils.b();
      if (l2 < 5242880 + l1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ThemeSwitch", 2, "Insufficient SDCard space, required:" + l1 + "| reserved:" + 5242880 + "|available:" + l2);
        }
        localBundle.putInt("result", 258);
        localBundle.putCharSequence("message", "Insufficient SDCard space.");
        localBundle.putCharSequence("resultMsg", "ISSD");
        a(localBundle);
        return;
      }
    }
    catch (Exception paramThemeInfo)
    {
      b = false;
      localBundle.putInt("result", 256);
      localBundle.putBoolean("isDownloadingInProgress", false);
      a(localBundle);
      paramThemeInfo.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.i("ThemeSwitch", 2, "Err, " + paramThemeInfo.getMessage());
      }
      try
      {
        paramThemeInfo = new HashMap();
        paramThemeInfo.put("param_Url", "-unknow-");
        paramThemeInfo.put("param_FailCode", "UNN");
        StatisticCollector.a(this.jdField_a_of_type_AndroidContentContext).a(((QQAppInterface)paramAppRuntime).getAccount(), "VipNightThemeDowned", false, 1L, 0L, paramThemeInfo, "", false);
        return;
      }
      catch (Exception paramAppRuntime)
      {
        return;
      }
      if (!NetworkUtil.e(paramAppRuntime.getApplication()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ThemeSwitch", 2, "No network access.");
        }
        localBundle.putInt("result", 259);
        localBundle.putCharSequence("message", "No network access.");
        localBundle.putCharSequence("resultMsg", "NNet");
        a(localBundle);
        return;
      }
      if (b)
      {
        localObject = (ThemeUtil.ThemeInfo)this.jdField_a_of_type_JavaUtilHashMap.get(str2);
        if ((this.jdField_d_of_type_JavaLangString.equals(str2)) && (localObject != null) && (str1.equals(((ThemeUtil.ThemeInfo)localObject).version)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ThemeSwitch", 2, "Redundant downloading request for one theme.");
          }
          localBundle.putInt("result", 260);
          localBundle.putCharSequence("message", "Downloading of theme=" + str2 + ",version=" + str1 + " already in progress.");
          localBundle.putCharSequence("resultMsg", "DOWNING");
          a(localBundle);
          return;
        }
        if (!QLog.isColorLevel()) {
          break label1267;
        }
        QLog.d("ThemeSwitch", 2, "pause downloading currentTheme");
      }
    }
    label635:
    label716:
    label756:
    String str4;
    if (a(paramAppRuntime.getApplication(), paramThemeInfo))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ThemeSwitch", 2, "Theme already exists, themeId=" + str2 + ",version=" + str1 + ",size=" + l1);
      }
      localObject = ThemeUtil.getThemeInfo(paramAppRuntime.getApplication(), str2);
      if (localObject == null)
      {
        paramThemeInfo.downsize = l1;
        paramThemeInfo.size = l1;
        paramThemeInfo.themeId = str2;
        paramThemeInfo.version = str1;
        paramThemeInfo.status = "3";
        if (i1 != 1) {
          break label1274;
        }
        bool = true;
        paramThemeInfo.isVoiceTheme = bool;
        ThemeUtil.setThemeInfo(paramAppRuntime.getApplication(), paramThemeInfo);
        localBundle.putInt("result", 261);
        localBundle.putCharSequence("message", "Download target exists in local storage.");
        localBundle.putCharSequence("resultMsg", "DOWNED");
        b(BaseApplicationImpl.a.a(), paramThemeInfo);
      }
    }
    else
    {
      str4 = ThemeUtil.getThemeDownloadFilePath(paramAppRuntime.getApplication(), str2, str1);
      b = true;
      localObject = (ThemeUtil.ThemeInfo)this.jdField_a_of_type_JavaUtilHashMap.get(str2);
      paramThemeInfo = (ThemeUtil.ThemeInfo)localObject;
      if (localObject == null)
      {
        localObject = ThemeUtil.getThemeInfo(paramAppRuntime.getApplication(), str2);
        paramThemeInfo = (ThemeUtil.ThemeInfo)localObject;
        if (localObject != null)
        {
          ((ThemeUtil.ThemeInfo)localObject).downloadUrl = str3;
          paramThemeInfo = (ThemeUtil.ThemeInfo)localObject;
        }
      }
      if ((paramThemeInfo == null) || (!paramThemeInfo.version.equals(str1)))
      {
        paramThemeInfo = new ThemeUtil.ThemeInfo();
        paramThemeInfo.themeId = str2;
        paramThemeInfo.downloadUrl = str3;
        paramThemeInfo.size = l1;
        paramThemeInfo.downsize = 0L;
        paramThemeInfo.version = str1;
        paramThemeInfo.status = "1";
        if (i1 != 1) {
          break label1280;
        }
      }
    }
    label1261:
    label1267:
    label1274:
    label1280:
    for (boolean bool = true;; bool = false)
    {
      paramThemeInfo.isVoiceTheme = bool;
      for (;;)
      {
        this.jdField_a_of_type_JavaUtilHashMap.put(str2, paramThemeInfo);
        this.jdField_d_of_type_JavaLangString = str2;
        a(paramAppRuntime);
        localObject = ((QQAppInterface)paramAppRuntime).a();
        if ((localObject != null) && (((TransFileController)localObject).c(str3, str4, l1))) {
          if (QLog.isColorLevel()) {
            QLog.i("ThemeSwitch", 2, "wifi network start downloading of theme=" + str2 + ",version=" + str1 + ",themeInfo=" + paramThemeInfo.toString());
          }
        }
        for (;;)
        {
          ThemeReporter.a((QQAppInterface)paramAppRuntime, "theme_detail", "201", 153, NetworkUtil.a(null), 7, str2, str1, ThemeReporter.t, "");
          return;
          if ((localObject == null) || (((TransFileController)localObject).a(str3) == null)) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.i("ThemeSwitch", 2, "wifi network is downloading of theme=" + str2 + ",version=" + str1 + ",themeInfo=" + paramThemeInfo.toString());
          }
        }
        if (QLog.isColorLevel()) {
          QLog.i("ThemeSwitch", 2, "Err, Start downloading of theme=" + str2 + ",version=" + str1);
        }
        localBundle.putInt("result", 262);
        localBundle.putBoolean("isDownloadingInProgress", false);
        this.jdField_a_of_type_JavaUtilHashMap.remove(str2);
        b = false;
        localBundle.putCharSequence("resultMsg", "STF");
        a(localBundle);
        return;
      }
      paramThemeInfo = (ThemeUtil.ThemeInfo)localObject;
      break label716;
      i1 = 0;
      break;
      if (localObject == null) {
        break label635;
      }
      break label635;
      bool = false;
      break label756;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, Bundle paramBundle)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      ThemeSwitchManager.ThemeSwitchCallback localThemeSwitchCallback = (ThemeSwitchManager.ThemeSwitchCallback)localIterator.next();
      if (paramBoolean1) {
        localThemeSwitchCallback.c(paramBundle);
      } else if (paramBoolean2) {
        localThemeSwitchCallback.d(paramBundle);
      }
    }
  }
  
  public boolean a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.a.a();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      return ((QQAppInterface)localAppRuntime).isLogin();
    }
    return false;
  }
  
  public boolean a(Context paramContext, ThemeUtil.ThemeInfo paramThemeInfo)
  {
    paramContext = ThemeUtil.getThemeDownloadFilePath(paramContext, paramThemeInfo.themeId, paramThemeInfo.version);
    File localFile = new File(paramContext);
    if ((!localFile.exists()) && (QLog.isColorLevel())) {
      QLog.d("ThemeSwitch", 2, "themeZipFile is not exit");
    }
    if ((!localFile.isFile()) && (QLog.isColorLevel())) {
      QLog.d("ThemeSwitch", 2, "themeZipFile is not file");
    }
    if ((localFile.length() != paramThemeInfo.size) && (QLog.isColorLevel())) {
      QLog.d("ThemeSwitch", 2, "themeZipFile is not size:" + paramContext.length() + "-" + paramThemeInfo.size);
    }
    if ((localFile.exists()) && (localFile.isFile()) && (localFile.length() == paramThemeInfo.size))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ThemeSwitch", 2, "themeZipFile:" + paramThemeInfo.themeId + "," + paramThemeInfo.version + "," + paramThemeInfo.size + " already exists.");
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ThemeSwitch", 2, "themeZipFile:" + paramThemeInfo.themeId + "," + paramThemeInfo.version + "," + paramThemeInfo.size + " not exist.");
    }
    return false;
  }
  
  public String[] a(Context paramContext)
  {
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1);
    if (paramContext != null)
    {
      String[] arrayOfString = new String[2];
      arrayOfString[0] = "";
      arrayOfString[1] = "";
      arrayOfString[0] = ((ActivityManager.RunningTaskInfo)paramContext.get(0)).baseActivity.getPackageName();
      arrayOfString[1] = ((ActivityManager.RunningTaskInfo)paramContext.get(0)).topActivity.getClassName();
      return arrayOfString;
    }
    if (QLog.isColorLevel()) {
      QLog.w("ThemeSwitch", 2, "getTopActivity ret is null");
    }
    return null;
  }
  
  public void b()
  {
    try
    {
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
      {
        Object localObject1 = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localObject1 == null)
        {
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.d("ThemeSwitch", 2, "doScreenShot, currActivityRef is null");
          return;
        }
        if (this.jdField_a_of_type_AndroidViewView == null)
        {
          localObject1 = ((Activity)localObject1).getWindow();
          if (localObject1 != null)
          {
            localObject1 = ((Window)localObject1).getDecorView();
            if (localObject1 != null) {
              this.jdField_a_of_type_AndroidViewView = ((View)localObject1).getRootView();
            }
          }
        }
        if (this.jdField_a_of_type_AndroidViewView == null)
        {
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.d("ThemeSwitch", 2, "doScreenShot, rootView is null");
          return;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ThemeSwitch", 2, "screen shot oom, no animation", localThrowable);
        }
        this.jdField_a_of_type_AndroidGraphicsBitmap = null;
        if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_AndroidWidgetImageView.getParent() != null)) {
          ((ViewGroup)this.jdField_a_of_type_AndroidWidgetImageView.getParent()).removeView(this.jdField_a_of_type_AndroidWidgetImageView);
        }
        this.jdField_a_of_type_AndroidWidgetImageView = null;
        while (QLog.isColorLevel())
        {
          QLog.d("ThemeSwitch", 2, "drawingCache is:" + this.jdField_a_of_type_AndroidGraphicsBitmap);
          return;
          boolean bool1 = this.jdField_a_of_type_AndroidViewView.isDrawingCacheEnabled();
          boolean bool2 = this.jdField_a_of_type_AndroidViewView.willNotCacheDrawing();
          this.jdField_a_of_type_AndroidViewView.setDrawingCacheEnabled(true);
          this.jdField_a_of_type_AndroidViewView.setWillNotCacheDrawing(false);
          localObject2 = this.jdField_a_of_type_AndroidViewView.getDrawingCache();
          if (localObject2 != null)
          {
            this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap((Bitmap)localObject2);
            this.jdField_a_of_type_AndroidWidgetImageView = new ImageView((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
            this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
            localObject2 = (ViewGroup)this.jdField_a_of_type_AndroidViewView;
            this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            ((ViewGroup)localObject2).addView(this.jdField_a_of_type_AndroidWidgetImageView);
          }
          this.jdField_a_of_type_AndroidViewView.setDrawingCacheEnabled(bool1);
          this.jdField_a_of_type_AndroidViewView.setWillNotCacheDrawing(bool2);
        }
        Object localObject2 = null;
      }
    }
  }
  
  public void b(AppRuntime paramAppRuntime, ThemeUtil.ThemeInfo paramThemeInfo)
  {
    String str1 = paramThemeInfo.themeId;
    String str2 = paramThemeInfo.version;
    int i1;
    if (paramThemeInfo.isVoiceTheme)
    {
      i1 = 1;
      paramThemeInfo = ThemeUtil.getThemeInfo(paramAppRuntime.getApplication(), str1);
      if (paramThemeInfo != null) {
        if (!paramThemeInfo.isVoiceTheme) {
          break label206;
        }
      }
    }
    label168:
    label174:
    label206:
    for (int i2 = 1;; i2 = 0)
    {
      if (i2 != i1) {
        if (i1 != 1) {
          break label168;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        paramThemeInfo.isVoiceTheme = bool;
        ThemeUtil.setThemeInfo(paramAppRuntime.getApplication(), paramThemeInfo);
        if (QLog.isColorLevel()) {
          QLog.i("ThemeSwitch", 2, "ThemeSwitchManager setup,themeId=" + str1 + ",version=" + str2 + ",isSound=" + i1);
        }
        if (jdField_a_of_type_Boolean) {
          break label174;
        }
        new uzs(this, paramAppRuntime).execute(new Object[] { str1, str2 });
        return;
        i1 = 0;
        break;
      }
      paramAppRuntime = new Bundle();
      paramAppRuntime.putInt("result", 513);
      paramAppRuntime.putCharSequence("message", "is switching theme");
      a(paramAppRuntime);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\theme\ThemeSwitchManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */