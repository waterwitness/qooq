import com.tencent.mobileqq.config.AboutConfig;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class rae
  implements Runnable
{
  public rae(AboutConfig paramAboutConfig, ResourcePluginInfo paramResourcePluginInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqConfigAboutConfig.a(this.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo);
    this.jdField_a_of_type_ComTencentMobileqqConfigAboutConfig.b();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\rae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */