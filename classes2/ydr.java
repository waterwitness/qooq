import android.content.Context;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;
import cooperation.plugin.IPluginManager.PluginParams;

public final class ydr
  implements Runnable
{
  public ydr(Context paramContext, IPluginManager.PluginParams paramPluginParams)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    PluginProxyService.openService(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams.d, this.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams.b, this.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams.c, this.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams.e, this.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams.a);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ydr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */