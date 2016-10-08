import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.view.ApolloLinearLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class psu
  implements Runnable
{
  public psu(ApolloLinearLayout paramApolloLinearLayout, ApolloActionData paramApolloActionData)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayout.a == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayout.a.a == null)) {
      return;
    }
    ((ApolloManager)this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayout.a.a.getManager(152)).a(this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData, 4);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\psu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */