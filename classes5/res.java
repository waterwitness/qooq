import com.tencent.mobileqq.dating.DatingHandler;
import com.tencent.mobileqq.dating.DatingTopListActivity;
import com.tencent.mobileqq.dating.GodListConfig;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class res
  implements Runnable
{
  public res(DatingTopListActivity paramDatingTopListActivity, GodListConfig paramGodListConfig, boolean paramBoolean1, long paramLong, boolean paramBoolean2)
  {
    paramBoolean1 = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    DatingHandler localDatingHandler = DatingTopListActivity.a(this.jdField_a_of_type_ComTencentMobileqqDatingDatingTopListActivity);
    int i = this.jdField_a_of_type_ComTencentMobileqqDatingGodListConfig.listType;
    int j = this.jdField_a_of_type_ComTencentMobileqqDatingGodListConfig.lastTime;
    if (this.jdField_a_of_type_Boolean) {}
    for (long l = 0L;; l = this.jdField_a_of_type_ComTencentMobileqqDatingGodListConfig.lastTinyId)
    {
      localDatingHandler.a(i, j, l, this.jdField_a_of_type_ComTencentMobileqqDatingGodListConfig.fetchAccount, this.jdField_a_of_type_Long, this.b);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\res.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */