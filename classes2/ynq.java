import android.content.Context;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;
import cooperation.qzone.plugin.IQZonePluginManager.PluginParams;

public final class ynq
  implements Runnable
{
  public ynq(Context paramContext, IQZonePluginManager.PluginParams paramPluginParams, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    PluginProxyService.openService(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager$PluginParams.d, this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager$PluginParams.b, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager$PluginParams.e, this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager$PluginParams.a);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ynq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */