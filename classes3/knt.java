import android.os.Message;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.mobileqq.apollo.task.ApolloActionHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class knt
  implements Runnable
{
  public knt(BaseChatPie paramBaseChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (ApolloActionHelper.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) != 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie", 2, "Apollo switch NOT open.");
      }
      this.a.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(62).sendToTarget();
      return;
    }
    ApolloEngine.a();
    this.a.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(65).sendToTarget();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\knt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */