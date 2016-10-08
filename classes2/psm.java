import android.text.TextUtils;
import com.tencent.mobileqq.apollo.task.ApolloActionManager;
import com.tencent.mobileqq.apollo.task.ApolloMsgPlayController;
import com.tencent.mobileqq.apollo.utils.ApolloDaoManager;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.VipUtils;

public class psm
  implements Runnable
{
  public psm(ApolloMsgPlayController paramApolloMsgPlayController, int paramInt1, ChatMessage paramChatMessage, ApolloActionManager paramApolloActionManager, int paramInt2, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject2;
    if ((2 == this.jdField_a_of_type_Int) && (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) && ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForApollo)))
    {
      localObject2 = (MessageForApollo)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) && (((MessageForApollo)localObject2).mApolloMessage != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloActionManager.a != null)) {
        break label58;
      }
    }
    label58:
    QQAppInterface localQQAppInterface;
    int i;
    label203:
    do
    {
      return;
      localObject1 = ((ApolloDaoManager)this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloActionManager.a.getManager(154)).a(((MessageForApollo)localObject2).mApolloMessage.id);
      if (((1 == this.b) || (3000 == this.b)) && (localObject1 != null))
      {
        localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloActionManager.a;
        int j;
        if (this.jdField_a_of_type_Boolean)
        {
          i = 0;
          j = ApolloUtil.a(this.b);
          localObject2 = Integer.toString(((MessageForApollo)localObject2).mApolloMessage.id);
          if (((ApolloActionData)localObject1).personNum != 0) {
            break label203;
          }
        }
        for (localObject1 = "0";; localObject1 = "1")
        {
          VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "g_msg_clk", i, j, new String[] { localObject2, localObject1, this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloActionManager.h, "" });
          return;
          i = 1;
          break;
        }
      }
    } while (this.b != 0);
    if (!TextUtils.isEmpty(((MessageForApollo)localObject2).inputText)) {}
    for (Object localObject1 = "1";; localObject1 = "0")
    {
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloActionManager.a;
      if (this.jdField_a_of_type_Boolean) {}
      for (i = 0;; i = 1)
      {
        VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "msg_clk", i, 0, new String[] { Integer.toString(((MessageForApollo)localObject2).mApolloMessage.id), localObject1, "", this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin });
        return;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\psm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */