import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.utils.ApolloDaoManager;
import com.tencent.mobileqq.apollo.view.ApolloPanel;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class ptf
  implements Runnable
{
  public ptf(ApolloPanel paramApolloPanel)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, "func initRencentData begins.");
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqApolloViewApolloRecentViewBinder != null))
    {
      localList = null;
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a != 0) {
        break label99;
      }
    }
    for (List localList = ApolloDaoManager.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a, "recent_c2c"); (this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a == null); localList = ApolloDaoManager.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a, "recent_troop"))
    {
      label75:
      return;
      label99:
      if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a != 1) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a != 3000)) {
        break label75;
      }
    }
    if ((localList == null) || (localList.size() == 0))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqApolloViewApolloRecentViewBinder.k = 2;
      this.a.j();
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqApolloViewApolloRecentViewBinder.k = 0;
    this.a.g();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ptf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */