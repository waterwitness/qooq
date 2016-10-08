import android.content.Context;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.plugin.IQZonePluginManager.OnPluginReadyListener;
import cooperation.qzone.plugin.IQZonePluginManager.PluginParams;
import cooperation.qzone.plugin.OnQZonePluginInstallListner.Stub;

class yny
  extends OnQZonePluginInstallListner.Stub
{
  yny(ynx paramynx, IQZonePluginManager.OnPluginReadyListener paramOnPluginReadyListener, Context paramContext, IQZonePluginManager.PluginParams paramPluginParams)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(String paramString) {}
  
  public void a(String paramString, float paramFloat, long paramLong) {}
  
  public void a(String paramString, int paramInt)
  {
    if (paramInt == 2)
    {
      this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager$OnPluginReadyListener.a(true, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager$PluginParams);
      return;
    }
    this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager$OnPluginReadyListener.a(false, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager$PluginParams);
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager$OnPluginReadyListener.a(true, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager$PluginParams);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yny.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */