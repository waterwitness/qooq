import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.freshnews.FreshNewsFeedAdapter;
import com.tencent.mobileqq.freshnews.FreshNewsManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.nearby.ipc.NearbyProcManager;

public class sqb
  implements Runnable
{
  public sqb(FreshNewsFeedAdapter paramFreshNewsFeedAdapter, long paramLong, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i = ((Integer)NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter.a.getAccount(), "blacklist_sequence", Integer.valueOf(0))).intValue();
    ((NearbyAppInterface)this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter.a).a().a(this.jdField_a_of_type_Long, i);
    FreshNewsManager localFreshNewsManager = (FreshNewsManager)this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter.a.getManager(211);
    if (localFreshNewsManager != null)
    {
      localFreshNewsManager.c = this.jdField_a_of_type_JavaLangString;
      localFreshNewsManager.h(this.jdField_a_of_type_Long);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sqb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */