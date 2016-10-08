import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;

public class upw
  implements Runnable
{
  public upw(PtvTemplateManager paramPtvTemplateManager, AppInterface paramAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (PtvFilterSoLoad.b())
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager.c(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\upw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */