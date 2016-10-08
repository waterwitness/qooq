package cooperation.qzone;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.hitrate.PreloadProcHitPluginSession;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.statistics.StatisticHitRateCollector;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.plugin.QZonePluginUtils;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;
import ylk;
import yll;
import ylm;
import yln;
import ylq;

public class QzonePluginProxyActivity
  extends PluginProxyActivity
{
  public static final String a = "com.qzone";
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString;
  static final String jdField_b_of_type_JavaLangString = "QZone";
  private static final String[] jdField_b_of_type_ArrayOfJavaLangString;
  static final String c = "qzone_plugin.apk";
  public static final String d = "qzone_plugin_activity_name";
  public static final String e = "QZoneExtra.Plugin.isloading";
  private static final String f = "Crash_Count_In_CNFException";
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "com.qzone.preview.QzonePictureViewer", "com.qzone.preview.LocalPictureViewer" };
    b = new String[] { "com.qzone.module.vipcomponent.ui.DiamondYellowOpenActivity", "com.qzone.common.activities.QzoneAdaptVideoActivity", "com.qzone.log.CrashNotificationActivity", "com.qzone.common.activities.NotificationActivity", "com.qzone.cover.ui.activity.QZoneCoverSetCustomActivity", "com.qzone.web.QZoneTranslucentActivity", "com.qzone.bulletscreen.BulletScreenActivity" };
  }
  
  public static ClassLoader a(Context paramContext)
  {
    return PluginStatic.getOrCreateClassLoader(paramContext, "qzone_plugin.apk");
  }
  
  public static String a()
  {
    return "qzone_plugin.apk";
  }
  
  public static String a(Intent paramIntent)
  {
    return paramIntent.getStringExtra("qzone_plugin_activity_name");
  }
  
  private static ConcurrentHashMap a()
  {
    try
    {
      Object localObject = PluginStatic.class.getDeclaredField("sPackageInfoMap");
      ((Field)localObject).setAccessible(true);
      localObject = (ConcurrentHashMap)((Field)localObject).get(PluginStatic.class);
      return (ConcurrentHashMap)localObject;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      QLog.w("QzonePluginProxyActivity", 1, "Get PluginStatic sPackageInfoMap Failed!", localNoSuchFieldException);
      return null;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        QLog.w("QzonePluginProxyActivity", 1, "Get PluginStatic sPackageInfoMap Failed!", localIllegalAccessException);
      }
    }
  }
  
  public static void a(Activity paramActivity, String paramString, Intent paramIntent, int paramInt)
  {
    a(paramActivity, paramString, paramIntent, paramInt, null);
  }
  
  public static void a(Activity paramActivity, String paramString, Intent paramIntent, int paramInt, DialogInterface.OnDismissListener paramOnDismissListener, boolean paramBoolean)
  {
    a(paramActivity, paramString, paramIntent, paramInt, paramOnDismissListener, paramBoolean, null);
  }
  
  public static void a(Activity paramActivity, String paramString, Intent paramIntent, int paramInt, DialogInterface.OnDismissListener paramOnDismissListener, boolean paramBoolean, PreloadProcHitPluginSession paramPreloadProcHitPluginSession)
  {
    b(paramActivity, paramString, paramIntent, paramInt, paramOnDismissListener, paramBoolean, paramPreloadProcHitPluginSession);
  }
  
  public static void a(Activity paramActivity, String paramString, Intent paramIntent, int paramInt, PreloadProcHitPluginSession paramPreloadProcHitPluginSession)
  {
    a(paramActivity, paramString, paramIntent, paramInt, null, true, paramPreloadProcHitPluginSession);
  }
  
  public static void a(Intent paramIntent, String paramString)
  {
    paramIntent.putExtra("qzone_plugin_activity_name", paramString);
  }
  
  public static void a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    paramBundle.putBoolean("cleartop", true);
    paramBundle.putBoolean("PhotoConst.IS_CALL_IN_PLUGIN", true);
    paramBundle.putString("PhotoConst.PLUGIN_NAME", "QZone");
    paramBundle.putString("PhotoConst.PLUGIN_APK", "qzone_plugin.apk");
  }
  
  public static ClassLoader b(Context paramContext)
  {
    return PluginStatic.getOrCreateClassLoader(paramContext, "Photoplus.apk");
  }
  
  private static void b(Activity paramActivity, String paramString, Intent paramIntent, int paramInt, DialogInterface.OnDismissListener paramOnDismissListener, boolean paramBoolean, PreloadProcHitPluginSession paramPreloadProcHitPluginSession)
  {
    if ((QZoneHelper.a) && ((paramActivity instanceof SplashActivity)))
    {
      paramInt = LocalMultiProcConfig.a("qzapp_vercode", 84);
      if (!LocalMultiProcConfig.a("qz_safe_mode_no_tip", false))
      {
        paramActivity = DialogUtil.a(paramActivity, 230, 2130904809, "启用空间保护模式", "空间出问题了，启用空间保护模式点\"确定\"；点击\"取消\"，保护模式不会生效。", "取消", "确定", new ylk(paramActivity, paramInt, paramString, paramIntent), new yll());
        ((CheckBox)paramActivity.findViewById(2131304301)).setOnCheckedChangeListener(new ylm());
        paramActivity.show();
      }
      while (QZoneHelper.a(paramActivity, paramInt, Long.valueOf(paramString).longValue(), "com.qzonex.app.tab.QZoneTabActivity")) {
        return;
      }
      QZoneHelper.a(paramIntent.getStringExtra("sid"), paramActivity);
      return;
    }
    if ((paramActivity instanceof FriendProfileCardActivity)) {
      StatisticHitRateCollector.a().c(paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.d("PluginDebug", 2, "launchPluingActivityForResult.isPluginInstalled start， showProgressDialog：" + paramBoolean);
    }
    QZoneHelper.a(paramBoolean, new yln(paramIntent, paramString, paramPreloadProcHitPluginSession, paramInt, paramActivity, paramOnDismissListener));
  }
  
  private static boolean b(String[] paramArrayOfString, String paramString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return false;
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (paramString.equals(paramArrayOfString[i])) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public static ClassLoader c(Context paramContext)
  {
    ClassLoader localClassLoader = null;
    String str = QZonePluginUtils.a();
    if (str.equals("qzone_live_video_plugin_hack.apk")) {
      localClassLoader = PluginStatic.getOrCreateClassLoader(paramContext, str);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("patch", 2, "getQzoneLiveClassLoader classsloader: " + localClassLoader);
      }
      return localClassLoader;
      if (str.equals("qzone_live_video_plugin.apk")) {
        localClassLoader = PluginStatic.getOrCreateClassLoader(paramContext, "qzone_live_video_plugin.apk");
      }
    }
  }
  
  public String getPluginID()
  {
    return "qzone_plugin.apk";
  }
  
  protected Class getProxyActivity(String paramString)
  {
    return ylq.a(paramString);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler)))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = new QZoneTopGestureLayout(this);
      ((FlingGestureHandler)this.mFlingHandler).setTopLayout(this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout);
    }
    Object localObject;
    if ((!TextUtils.isEmpty(this.mCreateErrorInfo)) && (!this.mCreateErrorInfo.equals("success"))) {
      if (paramBundle != null)
      {
        paramBundle = paramBundle.getString("pluginsdk_launchActivity");
        localObject = new StringBuffer("[插件启动失败] ");
        ((StringBuffer)localObject).append(paramBundle).append(" ").append(this.mCreateErrorInfo);
        QLog.e("QZLog", 1, ((StringBuffer)localObject).toString());
      }
    }
    do
    {
      do
      {
        return;
        paramBundle = getIntent().getExtras();
        break;
        localObject = getIntent().getExtras();
      } while (localObject == null);
      paramBundle = ((Bundle)localObject).getString("from_plugin");
      localObject = ((Bundle)localObject).getString("uin");
      getIntent().putExtra("from_plugin", "");
    } while ((TextUtils.isEmpty(paramBundle)) || (!paramBundle.equals("QZoneVideoPlugin")));
    a(this, (String)localObject, getIntent(), 1000);
  }
  
  protected boolean shouldHandleStartPluginFailed(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int i;
    label62:
    do
    {
      do
      {
        return false;
        if (QzoneConfig.a().a("QZoneSetting", "PluginPermissionErrorHandle", 1) != 0) {}
        int j;
        for (i = 1;; i = 0)
        {
          j = QzoneConfig.a().a("QZoneSetting", "PluginErrorHandleCount", -1);
          if (j != 0) {
            break label62;
          }
          if (i == 0) {
            break;
          }
          return super.shouldHandleStartPluginFailed(paramString);
        }
        paramString = paramString.toLowerCase();
        if (!paramString.contains("classnotfoundexception")) {
          break;
        }
        SharedPreferences localSharedPreferences = getSharedPreferences("Qz_setting", 0);
        int k = localSharedPreferences.getInt("Crash_Count_In_CNFException", 0);
        localSharedPreferences.edit().putInt("Crash_Count_In_CNFException", k + 1).commit();
        if (k == 0)
        {
          QLog.e("Plugin", 1, "kill process with first Exception:" + paramString);
          finish();
          Process.killProcess(Process.myPid());
        }
        for (;;)
        {
          return true;
          if ((j >= 0) && (k >= j)) {
            break;
          }
          QLog.e("Plugin", 1, "show dialog with non-first Exception:" + paramString);
          showNeedUninstanllAndInstallDialog();
        }
      } while (i == 0);
      return super.shouldHandleStartPluginFailed(paramString);
    } while (i == 0);
    return super.shouldHandleStartPluginFailed(paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\QzonePluginProxyActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */