import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.PluginPreloadReportUtils;
import cooperation.comic.PluginPreloadStrategy;
import cooperation.comic.PluginPreloader.ExtraResult;
import cooperation.plugin.IPluginManager;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public final class yae
  implements Runnable
{
  public yae(PluginPreloadStrategy paramPluginPreloadStrategy)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.a().a();
    int i = (int)(DeviceInfoUtil.d() >> 20);
    Object localObject1;
    Object localObject2;
    try
    {
      PluginPreloader.ExtraResult localExtraResult = new PluginPreloader.ExtraResult();
      localObject1 = ((ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity")).getRunningAppProcesses();
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject1).next();
          if (this.a.jdField_b_of_type_JavaLangString.equals(((ActivityManager.RunningAppProcessInfo)localObject2).processName))
          {
            if (QLog.isColorLevel()) {
              QLog.d("PluginPreloader", 2, "pluginType:" + this.a.jdField_b_of_type_Int + "  preload:fail:procexist " + this.a.jdField_b_of_type_JavaLangString);
            }
            PluginPreloadReportUtils.a(localAppRuntime, 1, this.a.jdField_b_of_type_Int, this.a.jdField_c_of_type_Int, 3, "preload:fail:procexist", i, new String[] { String.valueOf(this.a.d) });
            return;
          }
        }
      }
      if (!this.a.a(localExtraResult))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PluginPreloader", 2, this.a.jdField_b_of_type_JavaLangString + " is not allowed to preload.");
        }
        PluginPreloadReportUtils.a(localAppRuntime, 1, this.a.jdField_b_of_type_Int, this.a.jdField_c_of_type_Int, localExtraResult.jdField_a_of_type_Int, localExtraResult.jdField_a_of_type_JavaLangString, i, new String[] { String.valueOf(this.a.d) });
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PluginPreloader", 2, "pluginType:" + this.a.jdField_b_of_type_Int + " preload:fail:exception " + localException.getMessage());
      }
      PluginPreloadReportUtils.a(localAppRuntime, 1, this.a.jdField_b_of_type_Int, this.a.jdField_c_of_type_Int, 3, "preload:fail:exception", i, new String[] { String.valueOf(this.a.d), localException.getMessage() });
      return;
    }
    if (i < this.a.jdField_a_of_type_Int)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PluginPreloader", 2, "pluginType:" + this.a.jdField_b_of_type_Int + "  preload:fail:memorylimit (" + i + "MB)");
      }
      PluginPreloadReportUtils.a(localAppRuntime, 1, this.a.jdField_b_of_type_Int, this.a.jdField_c_of_type_Int, 3, "preload:fail:memorylimit", i, new String[] { String.valueOf(this.a.d), String.valueOf(this.a.jdField_a_of_type_Int) });
      return;
    }
    if (!this.a.b(localException))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PluginPreloader", 2, "the plugin is inactive.");
      }
      PluginPreloadReportUtils.a(localAppRuntime, 1, this.a.jdField_b_of_type_Int, this.a.jdField_c_of_type_Int, localException.jdField_a_of_type_Int, localException.jdField_a_of_type_JavaLangString, i, new String[] { String.valueOf(this.a.d) });
      return;
    }
    if (this.a.jdField_c_of_type_JavaLangString != null)
    {
      localObject1 = (IPluginManager)localAppRuntime.getManager(26);
      if (localObject1 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PluginPreloader", 2, "pluginType:" + this.a.jdField_b_of_type_Int + " preload:fail:nopluginmanager");
        }
        PluginPreloadReportUtils.a(localAppRuntime, 1, this.a.jdField_b_of_type_Int, this.a.jdField_c_of_type_Int, 3, "preload:fail:nopluginmanager", i, new String[] { String.valueOf(this.a.d) });
        return;
      }
      localObject2 = ((IPluginManager)localObject1).a(this.a.jdField_c_of_type_JavaLangString);
      if (localObject2 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PluginPreloader", 2, "pluginType:" + this.a.jdField_b_of_type_Int + " preload:fail:noplugininfo");
        }
        PluginPreloadReportUtils.a(localAppRuntime, 1, this.a.jdField_b_of_type_Int, this.a.jdField_c_of_type_Int, 3, "preload:fail:noplugininfo", i, new String[] { String.valueOf(this.a.d) });
        return;
      }
      if (((PluginBaseInfo)localObject2).mState == 4)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PluginPreloader", 2, "plugin already installed, do preload.");
        }
        PluginPreloadReportUtils.a(localAppRuntime, 0, this.a.jdField_b_of_type_Int, this.a.jdField_c_of_type_Int, localException.jdField_a_of_type_Int, localException.jdField_a_of_type_JavaLangString, i, new String[] { String.valueOf(this.a.d) });
        this.a.a();
        return;
      }
      if ((this.a.jdField_a_of_type_Boolean) && (NetworkUtil.i(BaseApplicationImpl.getContext())))
      {
        ((IPluginManager)localObject1).installPlugin(this.a.jdField_c_of_type_JavaLangString, new yaf(this, localAppRuntime, localException, i));
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PluginPreloader", 2, "pluginType:" + this.a.jdField_b_of_type_Int + " preload:fail:uninstall");
      }
      PluginPreloadReportUtils.a(localAppRuntime, 1, this.a.jdField_b_of_type_Int, this.a.jdField_c_of_type_Int, 3, "preload:fail:uninstall", i, new String[] { String.valueOf(this.a.d) });
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PluginPreloader", 2, "do preload");
    }
    PluginPreloadReportUtils.a(localAppRuntime, 0, this.a.jdField_b_of_type_Int, this.a.jdField_c_of_type_Int, localException.jdField_a_of_type_Int, localException.jdField_a_of_type_JavaLangString, i, new String[] { String.valueOf(this.a.d) });
    this.a.a();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */