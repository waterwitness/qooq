import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ItemBuilderFactory;
import com.tencent.mobileqq.apollo.task.ApolloMsgPlayController;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class psq
  implements Runnable
{
  public psq(ApolloMsgPlayController paramApolloMsgPlayController, ChatMessage paramChatMessage, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloMsgPlayController.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloMsgPlayController.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a == null)) {}
    Object localObject;
    BaseChatItemLayout localBaseChatItemLayout;
    do
    {
      do
      {
        return;
        localObject = this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloMsgPlayController.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloMsgPlayController.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
      } while (!(localObject instanceof ApolloItemBuilder));
      localObject = (ApolloItemBuilder)localObject;
      localBaseChatItemLayout = (BaseChatItemLayout)AIOUtils.a(this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloMsgPlayController.jdField_a_of_type_ComTencentWidgetXListView, this.jdField_a_of_type_Int);
    } while (localBaseChatItemLayout == null);
    ((ApolloItemBuilder)localObject).a(localBaseChatItemLayout, this.b, this.c);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\psq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */