import com.tencent.mobileqq.activity.main.MainAssistObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class ole
  implements Runnable
{
  public ole(MainAssistObserver paramMainAssistObserver, QQMessageFacade paramQQMessageFacade, QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.e();
    if (QLog.isColorLevel()) {
      QLog.d("MainAssistObserver", 2, "updateTab = " + i);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new olf(this, i));
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ole.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */