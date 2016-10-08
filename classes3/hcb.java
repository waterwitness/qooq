import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.qphone.base.util.QLog;

public final class hcb
  implements Runnable
{
  public hcb(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, boolean paramBoolean, String paramString)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoMsgTools", 2, "addMessage");
    }
    if ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) || (QQUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.jdField_a_of_type_Boolean);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoMsgTools", 2, "addMessage end");
      }
      return;
      QQMessageFacade localQQMessageFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (localQQMessageFacade != null) {
        localQQMessageFacade.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.jdField_a_of_type_JavaLangString);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\hcb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */