package cooperation.comic;

import com.qq.jce.wup.BasicClassTypeUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import mqq.app.AppRuntime;

public class VipComicHelper
{
  public static final int a = 3001;
  private static QQAppInterface a;
  public static final String a = "begin_to_load_comic_plugin";
  public static AtomicReference a;
  public static final int b = 1000;
  public static final String b = "pluginFinished";
  public static final int c = 5000;
  public static final String c = "tencent.qqcomic.push.msg";
  public static final int d = 10000;
  public static final String d = "tencent.qqcomic.show.dialog";
  private static final int e = 4097;
  public static final String e = "msg";
  public static final String f = "qqcomic_preload_first_screen_data";
  private static final String g = "ComicHelper";
  private static final String h = "com.qqcomic.app.VipComicPluginRuntime";
  private static final String i = "plugin_state";
  private static final String j = "plugin_progress";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference = new AtomicReference("");
  }
  
  public static QQAppInterface a()
  {
    return jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  }
  
  public static AppRuntime a(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    if ((paramBaseApplicationImpl == null) || (paramString == null)) {
      return null;
    }
    if ((paramBaseApplicationImpl.a().getRunningModuleSize() > 0) && (VipComicReportUtils.a.get() != 2)) {
      VipComicReportUtils.a.set(3);
    }
    try
    {
      Class localClass1 = Class.forName("com.qqcomic.app.VipComicPluginRuntime");
      if (localClass1 != null) {}
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        try
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("ComicHelper", 2, "createCOMICRuntime: load class failed");
        }
        catch (ClassNotFoundException paramBaseApplicationImpl)
        {
          ClassLoader localClassLoader;
          paramBaseApplicationImpl.printStackTrace();
        }
        localClassNotFoundException = localClassNotFoundException;
        localClassLoader = PluginStatic.getOrCreateClassLoader(paramBaseApplicationImpl, "comic_plugin.apk");
        Class localClass2 = localClassLoader.loadClass("com.qqcomic.app.VipComicPluginRuntime");
        BasicClassTypeUtil.setClassLoader(true, localClassLoader);
        continue;
        do
        {
          return null;
          paramBaseApplicationImpl = localClass2.getDeclaredConstructor(new Class[] { BaseApplicationImpl.class, String.class }).newInstance(new Object[] { paramBaseApplicationImpl, paramString });
        } while ((paramBaseApplicationImpl == null) || (!(paramBaseApplicationImpl instanceof AppRuntime)));
        paramBaseApplicationImpl = (AppRuntime)paramBaseApplicationImpl;
        return paramBaseApplicationImpl;
      }
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
    return null;
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if ((jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == paramQQAppInterface)) {
      jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\comic\VipComicHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */