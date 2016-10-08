import com.tencent.mobileqq.freshnews.FreshNewsDetailActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.nearby.ipc.NearbyProcManager;

public class sot
  implements Runnable
{
  public sot(FreshNewsDetailActivity paramFreshNewsDetailActivity, long paramLong)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i = ((Integer)NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsDetailActivity.a.getAccount(), "blacklist_sequence", Integer.valueOf(0))).intValue();
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsDetailActivity.a.a().a(this.jdField_a_of_type_Long, i);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */