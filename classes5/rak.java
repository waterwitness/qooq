import com.tencent.mobileqq.config.NearbyDataManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.utils.FileUtils;
import java.util.ArrayList;

public class rak
  implements Runnable
{
  public rak(NearbyDataManager paramNearbyDataManager, ArrayList paramArrayList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    FileUtils.a(NearbyDataManager.a(this.jdField_a_of_type_ComTencentMobileqqConfigNearbyDataManager).a() + "entered_ids", this.jdField_a_of_type_JavaUtilArrayList);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */