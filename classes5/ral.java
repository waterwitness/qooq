import com.tencent.mobileqq.config.NearbyDataManager;
import com.tencent.mobileqq.config.NearbyDataManager.INearbyBannerListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ral
  implements Runnable
{
  public ral(NearbyDataManager paramNearbyDataManager, List paramList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqConfigNearbyDataManager.a.iterator();
    while (localIterator.hasNext()) {
      ((NearbyDataManager.INearbyBannerListener)localIterator.next()).a(this.jdField_a_of_type_JavaUtilList);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ral.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */