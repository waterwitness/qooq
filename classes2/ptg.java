import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.apollo.view.ApolloPanel;
import com.tencent.mobileqq.apollo.view.ApolloRecentViewBinder;
import com.tencent.mobileqq.apollo.view.ApolloViewBinder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class ptg
  implements Runnable
{
  public ptg(ApolloPanel paramApolloPanel)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, "func updateLastApolloPanel begins. Thread id = " + Thread.currentThread().getId());
    }
    if (this.a.jdField_a_of_type_JavaUtilList == null) {}
    ApolloViewBinder localApolloViewBinder;
    do
    {
      return;
      localApolloViewBinder = (ApolloViewBinder)this.a.jdField_a_of_type_JavaUtilList.get(0);
    } while ((this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (!(localApolloViewBinder instanceof ApolloRecentViewBinder)));
    if (localApolloViewBinder.k == 2) {
      localApolloViewBinder.k = 0;
    }
    ((ApolloRecentViewBinder)localApolloViewBinder).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    this.a.j();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ptg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */