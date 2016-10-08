package cooperation.weiyun;

import android.content.Context;
import android.content.Intent;
import com.qq.jce.wup.BasicClassTypeUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.core.WyLog;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.PluginRuntime;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.weiyun.sdk.Global;
import com.weiyun.sdk.IWyFileSystem;
import com.weiyun.sdk.WyConfiguration;
import com.weiyun.sdk.WyFileSystemFactory;
import cooperation.weiyun.channel.WySender;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import mqq.app.AppRuntime;
import yuf;

public class WeiyunHelper
{
  private static IWyFileSystem a;
  public static final String a = "enter_file_assit";
  public static final String b = "exit_file_assit";
  private static final String c = "com.weiyun.plugin.app.WeiyunRuntime";
  
  public WeiyunHelper()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static PluginRuntime a(BaseApplicationImpl paramBaseApplicationImpl)
  {
    try
    {
      Class localClass = Class.forName("com.weiyun.plugin.app.WeiyunRuntime");
      paramBaseApplicationImpl = localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      try
      {
        ClassLoader localClassLoader = PluginStatic.getOrCreateClassLoader(paramBaseApplicationImpl, "WeiyunPlugin.apk");
        paramBaseApplicationImpl = localClassLoader.loadClass("com.weiyun.plugin.app.WeiyunRuntime");
        BasicClassTypeUtil.setClassLoader(true, localClassLoader);
      }
      catch (ClassNotFoundException paramBaseApplicationImpl)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
      do
      {
        return null;
        paramBaseApplicationImpl = paramBaseApplicationImpl.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      } while ((paramBaseApplicationImpl == null) || (!(paramBaseApplicationImpl instanceof PluginRuntime)));
      paramBaseApplicationImpl = (PluginRuntime)paramBaseApplicationImpl;
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
    if (paramBaseApplicationImpl == null) {
      return null;
    }
  }
  
  public static IWyFileSystem a()
  {
    if (a == null) {}
    try
    {
      if (a == null)
      {
        IWyFileSystem localIWyFileSystem = WyFileSystemFactory.getWyFileSystem();
        AppRuntime localAppRuntime = BaseApplicationImpl.a().a();
        localIWyFileSystem.startup(localAppRuntime.getApplication(), localAppRuntime.getAccount(), WySender.a(), WyLog.a(), new WyConfiguration(FMSettings.a().b()));
        a = localIWyFileSystem;
        if (!Global.isInit()) {
          Global.init(localAppRuntime.getApplication(), new yuf());
        }
      }
      return a;
    }
    finally {}
  }
  
  public static void a()
  {
    if (a != null) {
      try
      {
        if (a != null)
        {
          a.shutdown();
          a = null;
        }
        return;
      }
      finally {}
    }
  }
  
  public static void a(Context paramContext)
  {
    paramContext.sendBroadcast(new Intent("enter_file_assit"), "com.tencent.msg.permission.pushnotify");
  }
  
  public static void b(Context paramContext)
  {
    paramContext.sendBroadcast(new Intent("exit_file_assit"), "com.tencent.msg.permission.pushnotify");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\weiyun\WeiyunHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */