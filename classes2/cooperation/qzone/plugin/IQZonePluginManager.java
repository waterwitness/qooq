package cooperation.qzone.plugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.pluginsdk.PluginProxyBroadcastReceiver;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;
import com.tencent.mobileqq.pluginsdk.SplashDialogWrapper;
import com.tencent.mobileqq.statistics.PluginStatisticsCollector;
import com.tencent.mobileqq.widget.QzoneProgressDialog;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppRuntime;
import ynn;
import yno;
import ynp;
import ynq;
import ynr;

public abstract class IQZonePluginManager
  extends QZoneRemotePluginManager.Stub
{
  public IQZonePluginManager()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(Activity paramActivity, IQZonePluginManager.PluginParams paramPluginParams)
  {
    if (paramPluginParams.f != null)
    {
      localObject = Toast.makeText(BaseApplicationImpl.getContext(), paramPluginParams.f, 0);
      ((Toast)localObject).setGravity(17, 0, 0);
      ((Toast)localObject).show();
    }
    Object localObject = new ynn();
    if ((paramPluginParams.jdField_a_of_type_AndroidAppDialog != null) && (!paramActivity.isFinishing())) {
      new SplashDialogWrapper(paramActivity, paramPluginParams.jdField_a_of_type_AndroidAppDialog, paramPluginParams.d, paramPluginParams.jdField_b_of_type_JavaLangString, paramPluginParams.jdField_a_of_type_Boolean, paramPluginParams.c).show();
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.a.a();
    if (!(localAppRuntime instanceof QQAppInterface))
    {
      b(paramActivity, paramPluginParams, (IQZonePluginManager.OnPluginReadyListener)localObject);
      return;
    }
    ((IQZonePluginManager)((QQAppInterface)localAppRuntime).getManager(174)).a(paramActivity, paramPluginParams, (IQZonePluginManager.OnPluginReadyListener)localObject);
  }
  
  public static void a(Context paramContext, IQZonePluginManager.PluginParams paramPluginParams)
  {
    yno localyno = new yno();
    AppRuntime localAppRuntime = BaseApplicationImpl.a.a();
    if (!(localAppRuntime instanceof QQAppInterface))
    {
      b(paramContext, paramPluginParams, localyno);
      return;
    }
    ((IQZonePluginManager)((QQAppInterface)localAppRuntime).getManager(174)).a(paramContext, paramPluginParams, localyno);
  }
  
  public static void b(Activity paramActivity, IQZonePluginManager.PluginParams paramPluginParams)
  {
    if ((paramPluginParams == null) || (paramActivity == null) || (paramPluginParams.jdField_a_of_type_AndroidContentIntent == null)) {}
    for (;;)
    {
      return;
      paramPluginParams.jdField_a_of_type_AndroidContentIntent.setClass(paramActivity, paramPluginParams.jdField_a_of_type_JavaLangClass);
      if (TextUtils.isEmpty(paramPluginParams.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin")))
      {
        paramPluginParams.jdField_a_of_type_AndroidContentIntent.putExtra("uin", paramPluginParams.jdField_a_of_type_JavaLangString);
        paramPluginParams.jdField_a_of_type_AndroidContentIntent.putExtra("qzone_uin", paramPluginParams.jdField_a_of_type_JavaLangString);
      }
      paramPluginParams.jdField_a_of_type_AndroidContentIntent.putExtra("pluginsdk_selfuin", paramPluginParams.jdField_a_of_type_JavaLangString);
      paramPluginParams.jdField_a_of_type_AndroidContentIntent.putExtra("clsUploader", PluginStatisticsCollector.class.getName());
      try
      {
        File localFile = new File(QZonePluginUtils.a(paramActivity), "qzone_live_video_plugin_hack.apk");
        PluginProxyActivity.openActivityForResult(paramActivity, paramPluginParams.d, paramPluginParams.jdField_b_of_type_JavaLangString, localFile.getCanonicalPath(), paramPluginParams.e, paramPluginParams.jdField_a_of_type_AndroidContentIntent, paramPluginParams.jdField_b_of_type_Int);
        if ((paramPluginParams.jdField_a_of_type_AndroidAppDialog != null) && ((paramPluginParams.jdField_a_of_type_AndroidAppDialog instanceof QzoneProgressDialog)) && (paramActivity != null))
        {
          paramActivity.overridePendingTransition(2130968662, 2130968662);
          return;
        }
      }
      catch (Exception paramActivity)
      {
        QLog.e("feilongzou", 1, paramActivity, new Object[0]);
      }
    }
  }
  
  public static void b(Context paramContext, IQZonePluginManager.PluginParams paramPluginParams)
  {
    ynp localynp = new ynp();
    AppRuntime localAppRuntime = BaseApplicationImpl.a.a();
    if (!(localAppRuntime instanceof QQAppInterface))
    {
      b(paramContext, paramPluginParams, localynp);
      return;
    }
    ((IQZonePluginManager)((QQAppInterface)localAppRuntime).getManager(174)).a(paramContext, paramPluginParams, localynp);
  }
  
  private static void b(Context paramContext, IQZonePluginManager.PluginParams paramPluginParams, IQZonePluginManager.OnPluginReadyListener paramOnPluginReadyListener)
  {
    QZonePluginMangerHelper.a(paramContext, new ynr(paramContext, paramPluginParams, paramOnPluginReadyListener));
  }
  
  public static void c(Context paramContext, IQZonePluginManager.PluginParams paramPluginParams)
  {
    if ((TextUtils.isEmpty(paramPluginParams.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin"))) && (!TextUtils.isEmpty(paramPluginParams.jdField_a_of_type_JavaLangString)))
    {
      paramPluginParams.jdField_a_of_type_AndroidContentIntent.putExtra("uin", paramPluginParams.jdField_a_of_type_JavaLangString);
      paramPluginParams.jdField_a_of_type_AndroidContentIntent.putExtra("qzone_uin", paramPluginParams.jdField_a_of_type_JavaLangString);
    }
    paramPluginParams.jdField_a_of_type_AndroidContentIntent.putExtra("pluginsdk_selfuin", paramPluginParams.jdField_a_of_type_JavaLangString);
    paramPluginParams.jdField_a_of_type_AndroidContentIntent.putExtra("clsUploader", PluginStatisticsCollector.class.getName());
    File localFile = new File(QZonePluginUtils.a(paramContext), "qzone_live_video_plugin_hack.apk");
    try
    {
      PluginProxyBroadcastReceiver.sendBroadcastReceiver(paramContext, paramPluginParams.d, paramPluginParams.jdField_b_of_type_JavaLangString, localFile.getCanonicalPath(), paramPluginParams.e, paramPluginParams.jdField_a_of_type_AndroidContentIntent);
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("PluginDebug", 2, "doLaunchPluginBroadcast", paramContext);
    }
  }
  
  public static void d(Context paramContext, IQZonePluginManager.PluginParams paramPluginParams)
  {
    if ((TextUtils.isEmpty(paramPluginParams.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin"))) && (!TextUtils.isEmpty(paramPluginParams.jdField_a_of_type_JavaLangString)))
    {
      paramPluginParams.jdField_a_of_type_AndroidContentIntent.putExtra("uin", paramPluginParams.jdField_a_of_type_JavaLangString);
      paramPluginParams.jdField_a_of_type_AndroidContentIntent.putExtra("qzone_uin", paramPluginParams.jdField_a_of_type_JavaLangString);
    }
    paramPluginParams.jdField_a_of_type_AndroidContentIntent.putExtra("pluginsdk_selfuin", paramPluginParams.jdField_a_of_type_JavaLangString);
    paramPluginParams.jdField_a_of_type_AndroidContentIntent.putExtra("clsUploader", PluginStatisticsCollector.class.getName());
    Object localObject = new File(QZonePluginUtils.a(paramContext), "qzone_live_video_plugin_hack.apk");
    try
    {
      localObject = ((File)localObject).getCanonicalPath();
      if (paramPluginParams.jdField_a_of_type_AndroidContentServiceConnection != null)
      {
        PluginProxyService.bindService(paramContext, paramPluginParams.d, paramPluginParams.jdField_b_of_type_JavaLangString, (String)localObject, paramPluginParams.e, paramPluginParams.jdField_a_of_type_AndroidContentIntent, paramPluginParams.jdField_a_of_type_AndroidContentServiceConnection);
        return;
      }
      ThreadManager.a(new ynq(paramContext, paramPluginParams, (String)localObject), 5, null, false);
      return;
    }
    catch (Exception paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PluginDebug", 2, "doLaunchPluginService", paramContext);
      }
    }
  }
  
  public abstract PluginRecord a(String paramString);
  
  public abstract void a();
  
  public abstract void a(Context paramContext, IQZonePluginManager.PluginParams paramPluginParams, IQZonePluginManager.OnPluginReadyListener paramOnPluginReadyListener);
  
  public abstract boolean a();
  
  public abstract boolean a(String paramString);
  
  public abstract boolean a(String paramString, OnQZonePluginInstallListner paramOnQZonePluginInstallListner);
  
  public abstract boolean b(String paramString);
  
  public abstract boolean c(String paramString);
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\plugin\IQZonePluginManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */