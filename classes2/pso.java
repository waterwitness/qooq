import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ItemBuilderFactory;
import com.tencent.mobileqq.apollo.task.ApolloMsgPlayController;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class pso
  implements Runnable
{
  public pso(ApolloMsgPlayController paramApolloMsgPlayController, ChatMessage paramChatMessage, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloMsgPlayController", 2, "mListView:" + this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloMsgPlayController.jdField_a_of_type_ComTencentWidgetXListView);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloMsgPlayController.jdField_a_of_type_ComTencentWidgetXListView == null) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
        } while ((this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloMsgPlayController.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloMsgPlayController.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a == null));
        localObject = this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloMsgPlayController.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloMsgPlayController.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
      } while ((!(localObject instanceof ApolloItemBuilder)) || (!(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForApollo)));
      localObject = (ApolloItemBuilder)localObject;
    } while (!(AIOUtils.a(this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloMsgPlayController.jdField_a_of_type_ComTencentWidgetXListView, this.jdField_a_of_type_Int) instanceof BaseChatItemLayout));
    ((ApolloItemBuilder)localObject).a((BaseChatItemLayout)AIOUtils.a(this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloMsgPlayController.jdField_a_of_type_ComTencentWidgetXListView, this.jdField_a_of_type_Int), (MessageForApollo)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\pso.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */