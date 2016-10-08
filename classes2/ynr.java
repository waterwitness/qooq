import android.content.Context;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.plugin.IQZonePluginManager;
import cooperation.qzone.plugin.IQZonePluginManager.OnPluginReadyListener;
import cooperation.qzone.plugin.IQZonePluginManager.PluginParams;
import cooperation.qzone.plugin.QZonePluginMangerHelper;
import cooperation.qzone.plugin.QZonePluginMangerHelper.OnQzonePluginClientReadyListner;

public final class ynr
  implements QZonePluginMangerHelper.OnQzonePluginClientReadyListner
{
  public ynr(Context paramContext, IQZonePluginManager.PluginParams paramPluginParams, IQZonePluginManager.OnPluginReadyListener paramOnPluginReadyListener)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(IQZonePluginManager paramIQZonePluginManager)
  {
    if (paramIQZonePluginManager == null)
    {
      QZonePluginMangerHelper.a(this.jdField_a_of_type_AndroidContentContext, this);
      return;
    }
    paramIQZonePluginManager.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager$PluginParams, this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager$OnPluginReadyListener);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ynr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */