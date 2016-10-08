import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class vqn
  implements Runnable
{
  public vqn(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vqn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */