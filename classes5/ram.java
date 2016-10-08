import com.tencent.mobileqq.config.NearbyDataManager;
import com.tencent.mobileqq.config.NearbyDataManager.INearbyBannerListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Iterator;
import java.util.LinkedList;

public class ram
  implements Runnable
{
  public ram(NearbyDataManager paramNearbyDataManager, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramBoolean1 = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqConfigNearbyDataManager.a.iterator();
    while (localIterator.hasNext()) {
      ((NearbyDataManager.INearbyBannerListener)localIterator.next()).a(this.jdField_a_of_type_Boolean, this.b);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ram.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */