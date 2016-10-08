import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.HotChatUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.os.MqqHandler;

public class koa
  implements Runnable
{
  public koa(BaseChatPie paramBaseChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    BaseChatPie.b(this.a, this.a.c());
    Object localObject = this.a;
    if (BaseChatPie.d(this.a) > 0) {}
    ArrayList localArrayList;
    for (boolean bool = true;; bool = false)
    {
      BaseChatPie.a((BaseChatPie)localObject, bool);
      BaseChatPie.a(this.a, BaseChatPie.d(this.a));
      localObject = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a();
      localArrayList = new ArrayList();
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 0) {
        break label218;
      }
      if ((localObject == null) || (((List)localObject).isEmpty())) {
        break;
      }
      int i = ((List)localObject).size() - 1;
      while (i >= 0)
      {
        ChatMessage localChatMessage = (ChatMessage)((List)localObject).get(i);
        if (((localChatMessage instanceof MessageForPoke)) && (!localChatMessage.isSend())) {
          localArrayList.add((MessageForPoke)localChatMessage);
        }
        i -= 1;
      }
    }
    if (localArrayList.size() > 0)
    {
      localObject = (MessageForPoke)localArrayList.get(0);
      if (!((MessageForPoke)localObject).isPlayed) {
        this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a.put(Long.valueOf(((MessageForPoke)localObject).uniseq), localObject);
      }
    }
    label218:
    this.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(16711689, 300000L);
    if (BaseChatPie.b(this.a)) {
      ChatActivityFacade.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, true, true);
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
        HotChatUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
      BaseChatPie.b(this.a, true);
      this.a.Y();
      return;
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Long == -1L) {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Long = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\koa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */