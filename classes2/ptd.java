import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.apollo.utils.ApolloDaoManager;
import com.tencent.mobileqq.apollo.view.ApolloPanel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionPackage;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ptd
  implements Runnable
{
  public ptd(ApolloPanel paramApolloPanel, ApolloActionPackage paramApolloActionPackage)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.a != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.a.a != null))
    {
      ApolloDaoManager localApolloDaoManager = (ApolloDaoManager)this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.a.a.getManager(154);
      if (localApolloDaoManager != null) {
        localApolloDaoManager.a(this.jdField_a_of_type_ComTencentMobileqqDataApolloActionPackage);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ptd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */