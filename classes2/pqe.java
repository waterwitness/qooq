import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;

public class pqe
  implements Runnable
{
  public pqe(ApolloManager paramApolloManager, SessionInfo paramSessionInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) {
        ApolloManager.a(this.jdField_a_of_type_ComTencentMobileqqApolloApolloManager.a, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "C2CAIO");
      }
      while ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloManager.b(this.jdField_a_of_type_ComTencentMobileqqApolloApolloManager.a.f()) == 1) && (NetworkUtil.i(this.jdField_a_of_type_ComTencentMobileqqApolloApolloManager.a.getApplication())))
      {
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloManager.a != null)) {
          ((ApolloManager)this.jdField_a_of_type_ComTencentMobileqqApolloApolloManager.a.getManager(152)).b();
        }
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ApolloManager", 2, "doAfterOpenAIO error", localException);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\pqe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */