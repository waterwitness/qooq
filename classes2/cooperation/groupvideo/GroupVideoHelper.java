package cooperation.groupvideo;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.qq.jce.wup.BasicClassTypeUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class GroupVideoHelper
{
  public static final int a = 1;
  public static final String a = "com.gvideo.com.tencent.av.ui.GroupVideoActivity";
  public static final String b = "mqqapi://gvideo/open_plugin?src_type=app";
  private static final String c = "com.gvideo.com.tencent.av.app.GroupVideoAppInterface";
  
  public GroupVideoHelper()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static AppRuntime a(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    if ((paramBaseApplicationImpl == null) || (paramString == null)) {
      return null;
    }
    try
    {
      Class localClass1 = Class.forName("com.gvideo.com.tencent.av.app.GroupVideoAppInterface");
      if (localClass1 != null) {}
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      Class localClass2;
      for (;;)
      {
        try
        {
          QLog.e("GroupVideoLog", 1, "*createGroupVideoAppInterface load class fail");
          return null;
        }
        catch (ClassNotFoundException paramBaseApplicationImpl)
        {
          ClassLoader localClassLoader;
          paramBaseApplicationImpl.printStackTrace();
        }
        localClassNotFoundException = localClassNotFoundException;
        localClassLoader = PluginStatic.getOrCreateClassLoader(paramBaseApplicationImpl, "group_video_plugin.apk");
        localClass2 = localClassLoader.loadClass("com.gvideo.com.tencent.av.app.GroupVideoAppInterface");
        BasicClassTypeUtil.setClassLoader(true, localClassLoader);
      }
      do
      {
        return null;
        paramBaseApplicationImpl = localClass2.getDeclaredConstructor(new Class[] { paramBaseApplicationImpl.getClass(), paramString.getClass() }).newInstance(new Object[] { paramBaseApplicationImpl, paramString });
      } while ((paramBaseApplicationImpl == null) || (!(paramBaseApplicationImpl instanceof AppInterface)));
      paramBaseApplicationImpl = (AppInterface)paramBaseApplicationImpl;
      return paramBaseApplicationImpl;
    }
    catch (IllegalArgumentException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (IllegalAccessException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (InstantiationException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (InvocationTargetException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (NoSuchMethodException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (Exception paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, ServiceConnection paramServiceConnection)
  {
    if ((paramAppRuntime == null) || (paramServiceConnection == null)) {
      return;
    }
    try
    {
      paramAppRuntime.getApplication().unbindService(paramServiceConnection);
      return;
    }
    catch (IllegalArgumentException paramAppRuntime)
    {
      QLog.d("GroupVideoHelper", 2, "unbindService error" + paramAppRuntime.getMessage());
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, Class paramClass, ServiceConnection paramServiceConnection, String paramString)
  {
    if ((paramAppRuntime == null) || (paramServiceConnection == null)) {
      return;
    }
    paramClass = new Intent(paramAppRuntime.getApplication(), paramClass);
    paramClass.putExtra("useSkinEngine", 1);
    paramClass.putExtra("userQqResources", 2);
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(1);
    localPluginParams.b = "group_video_plugin.apk";
    localPluginParams.d = "群视频";
    localPluginParams.jdField_a_of_type_JavaLangString = paramAppRuntime.getAccount();
    localPluginParams.e = paramString;
    localPluginParams.jdField_a_of_type_AndroidContentIntent = paramClass;
    localPluginParams.jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
    IPluginManager.b(paramAppRuntime.getApplication(), localPluginParams);
  }
  
  public static boolean a(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
      if (paramContext != null)
      {
        paramContext = paramContext.iterator();
        while (paramContext.hasNext()) {
          if ("com.tencent.mobileqq:groupvideo".compareTo(((ActivityManager.RunningAppProcessInfo)paramContext.next()).processName) == 0) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public static boolean a(AppInterface paramAppInterface, Activity paramActivity, Intent paramIntent, int paramInt)
  {
    if ((paramAppInterface == null) || (paramActivity == null)) {
      return false;
    }
    if ((paramIntent != null) && (paramIntent.getIntExtra("Type", 0) == 0)) {
      paramIntent.putExtra("isInviteMode", true);
    }
    for (;;)
    {
      GVideoProxyActivity.a(paramActivity, paramIntent, GVideoProxyActivity.a(paramActivity), "com.gvideo.com.tencent.av.ui.GroupVideoActivity", paramAppInterface.a(), paramInt);
      return true;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, Intent paramIntent, int paramInt)
  {
    if ((paramQQAppInterface == null) || (!(paramContext instanceof Activity))) {
      return false;
    }
    paramContext = (Activity)paramContext;
    IPluginManager localIPluginManager = (IPluginManager)paramQQAppInterface.getManager(26);
    if (localIPluginManager == null) {
      return false;
    }
    if (localIPluginManager.isPlugininstalled("group_video_plugin.apk")) {
      return a(paramQQAppInterface, paramContext, paramIntent, paramInt);
    }
    paramIntent.setClass(paramContext, GVideoPluginInstallerActivity.class);
    paramContext.startActivityForResult(paramIntent, paramInt);
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\groupvideo\GroupVideoHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */