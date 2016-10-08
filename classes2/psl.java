import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.task.ApolloActionTask;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class psl
  implements Runnable
{
  public psl(ApolloActionTask paramApolloActionTask, QQAppInterface paramQQAppInterface, ApolloActionData paramApolloActionData)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ((ApolloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152)).a(this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData, 4);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\psl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */