import android.os.IBinder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.PluginPreloadReportUtils;
import cooperation.comic.PluginPreloadStrategy;
import cooperation.comic.PluginPreloader.ExtraResult;
import mqq.app.AppRuntime;

class yaf
  implements OnPluginInstallListener
{
  yaf(yae paramyae, AppRuntime paramAppRuntime, PluginPreloader.ExtraResult paramExtraResult, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public IBinder asBinder()
  {
    return null;
  }
  
  public void onInstallBegin(String paramString) {}
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2) {}
  
  public void onInstallError(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PluginPreloader", 2, "pluginType:" + this.jdField_a_of_type_Yae.a.b + " preload:fail:installerror");
    }
    PluginPreloadReportUtils.a(this.jdField_a_of_type_MqqAppAppRuntime, 1, this.jdField_a_of_type_Yae.a.b, this.jdField_a_of_type_Yae.a.c, 3, "preload:fail:installerror", this.jdField_a_of_type_Int, new String[] { String.valueOf(this.jdField_a_of_type_Yae.a.d) });
  }
  
  public void onInstallFinish(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PluginPreloader", 2, "plugin install success, do preload.");
    }
    PluginPreloadReportUtils.a(this.jdField_a_of_type_MqqAppAppRuntime, 0, this.jdField_a_of_type_Yae.a.b, this.jdField_a_of_type_Yae.a.c, this.jdField_a_of_type_CooperationComicPluginPreloader$ExtraResult.jdField_a_of_type_Int, this.jdField_a_of_type_CooperationComicPluginPreloader$ExtraResult.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, new String[] { String.valueOf(this.jdField_a_of_type_Yae.a.d) });
    this.jdField_a_of_type_Yae.a.a();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yaf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */