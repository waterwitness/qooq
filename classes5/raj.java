import com.tencent.mobileqq.config.NearbyDataManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.FileUtils;
import java.util.ArrayList;
import java.util.List;

public class raj
  implements Runnable
{
  public raj(NearbyDataManager paramNearbyDataManager, String paramString, List paramList, long paramLong, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    FileUtils.a(this.jdField_a_of_type_JavaLangString, new Object[] { this.jdField_a_of_type_JavaUtilList, Long.valueOf(this.jdField_a_of_type_Long), Boolean.valueOf(this.jdField_a_of_type_Boolean) });
    this.jdField_a_of_type_ComTencentMobileqqConfigNearbyDataManager.a(new ArrayList());
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\raj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */