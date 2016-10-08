import com.tencent.mobileqq.apollo.data.ApolloActionRecentData;
import com.tencent.mobileqq.apollo.utils.ApolloDaoManager;
import com.tencent.mobileqq.apollo.utils.ApolloRecentManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class pss
  implements Runnable
{
  public pss(ApolloRecentManager paramApolloRecentManager, ApolloActionRecentData paramApolloActionRecentData1, ApolloActionRecentData paramApolloActionRecentData2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloRecentManager.a == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloDataApolloActionRecentData == null)
    {
      ApolloDaoManager.b(this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloRecentManager.a, this.b);
      return;
    }
    ApolloDaoManager.a(this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloRecentManager.a, this.b, this.jdField_a_of_type_ComTencentMobileqqApolloDataApolloActionRecentData);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\pss.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */