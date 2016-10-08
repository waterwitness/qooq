import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.common.offline.AsyncCallBack;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.viewplugin.ViewPluginContext;
import com.tencent.biz.viewplugin.ViewPluginManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.PluginUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import dalvik.system.DexClassLoader;
import java.io.File;

public class jgg
  implements AsyncCallBack
{
  public jgg(ViewPluginManager paramViewPluginManager, long paramLong, Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ViewPluginManager", 2, "transToLocalUrl loadMode:" + paramInt + "," + " time:" + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("ViewPluginManager", 4, "transToLocalUrl transUrl:" + paramString);
    }
    ViewPluginManager.a(this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager, HtmlOffline.d(this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.f));
    paramString = HtmlOffline.a(this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.f) + this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.f + "/" + this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.g;
    try
    {
      Object localObject = new File(this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.h);
      if (!this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.jdField_a_of_type_AndroidContentSharedPreferences.getString("SearchViewPluginVersion", "-1").equals(ViewPluginManager.a(this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager)))
      {
        if (!((File)localObject).exists()) {
          break label330;
        }
        FileUtils.a(((File)localObject).getAbsolutePath());
        this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString("SearchViewPluginVersion", HtmlOffline.d(this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.f)).commit();
        ((File)localObject).mkdirs();
      }
      for (;;)
      {
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdirs();
        }
        localObject = PluginUtils.getPluginLibPath(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.g).getCanonicalPath();
        this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.jdField_a_of_type_JavaLangClassLoader = new DexClassLoader(paramString, this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.h, (String)localObject, this.jdField_a_of_type_AndroidContentContext.getClassLoader());
        this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.jdField_a_of_type_ComTencentBizViewpluginViewPluginContext = new ViewPluginContext(this.jdField_a_of_type_AndroidContentContext, 0, paramString, null);
        return;
        label330:
        ((File)localObject).mkdirs();
      }
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ViewPluginManager", 2, "create classloader failed:" + paramString.toString());
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jgg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */