import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.biz.pubaccount.ecshopassit.EcshopReportHandler;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;

public class obf
  implements Runnable
{
  public obf(PublicAccountChatPie paramPublicAccountChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    EcshopReportHandler localEcshopReportHandler = (EcshopReportHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(88);
    Object localObject;
    String str1;
    if (this.a.T)
    {
      this.a.T = false;
      localObject = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      if ((localObject == null) || (((List)localObject).isEmpty()) || (localEcshopReportHandler == null)) {
        return;
      }
      localObject = (ChatMessage)((List)localObject).get(((List)localObject).size() - 1);
      str1 = ((ChatMessage)localObject).getExtInfoFromExtStr("public_account_msg_id");
      if (!(localObject instanceof MessageForArkApp)) {
        break label199;
      }
      localEcshopReportHandler.a(134243863, ((ChatMessage)localObject).senderuin, str1, null, null, 0L, false);
    }
    for (;;)
    {
      int i = this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getIntExtra("jump_from", 4);
      if ((this.a.U) && (i != 2)) {
        break;
      }
      this.a.U = true;
      localEcshopReportHandler.a(134243865, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, null, null, null, i, false);
      return;
      label199:
      if ("1".equals(((ChatMessage)localObject).getExtInfoFromExtStr("is_AdArrive_Msg")))
      {
        String str2 = ((ChatMessage)localObject).getExtInfoFromExtStr("key");
        localEcshopReportHandler.a(134243860, ((ChatMessage)localObject).senderuin, str1, str2, null, 0L, true);
      }
      else
      {
        localEcshopReportHandler.a(134243857, ((ChatMessage)localObject).senderuin, str1, null, null, 0L, false);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\obf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */