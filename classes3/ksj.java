import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.multimsg.LongTextMsgManager;
import com.tencent.qphone.base.util.QLog;

public final class ksj
  implements Runnable
{
  public ksj(boolean paramBoolean, QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      if (this.jdField_a_of_type_Boolean)
      {
        ((LongTextMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(165)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, false);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, null);
      return;
    }
    catch (Exception localException)
    {
      QLog.e(ChatActivityFacade.a(), 1, "life circle2:", localException);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ksj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */