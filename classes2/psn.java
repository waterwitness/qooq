import android.os.Message;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.apollo.task.ApolloActionManager;
import com.tencent.mobileqq.apollo.task.ApolloActionTask;
import com.tencent.mobileqq.apollo.task.ApolloMsgPlayController;
import com.tencent.mobileqq.apollo.task.ApolloMsgPlayParam;
import com.tencent.mobileqq.apollo.task.ApolloTaskParam;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.locks.ReentrantLock;
import mqq.os.MqqHandler;

public class psn
  implements Runnable
{
  public psn(ApolloMsgPlayController paramApolloMsgPlayController, ApolloMsgPlayParam paramApolloMsgPlayParam, ApolloActionManager paramApolloActionManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject2 = (MessageForApollo)this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloMsgPlayParam.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    int j = MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloMsgPlayParam.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloMsgPlayController.a);
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloActionManager.a();
    int i;
    if ((localObject1 != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloMsgPlayParam.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloMsgPlayParam.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq == ((ApolloActionTask)localObject1).a.jdField_a_of_type_Long))
    {
      i = 1;
      if (i == 0) {
        break label209;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloMsgPlayParam.b != 2) {
        break label194;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloMsgPlayController", 2, "stop current task.");
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloActionManager.a();
      if (localObject1 != null)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloActionManager.a;
        i = ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloMsgPlayParam.jdField_a_of_type_Int);
        str = Integer.toString(((ApolloTaskParam)localObject1).b);
        if (!((ApolloTaskParam)localObject1).jdField_a_of_type_Boolean) {
          break label188;
        }
        localObject1 = "0";
        VipUtils.a((AppInterface)localObject2, "cmshow", "Apollo", "msg_paly_stop", i, 0, new String[] { str, localObject1 });
      }
    }
    label188:
    label194:
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        String str;
        return;
        i = 0;
        break;
        localObject1 = "1";
      }
    }
    QLog.d("ApolloMsgPlayController", 2, "abandon repeat task.");
    return;
    label209:
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloActionManager.a();
    for (;;)
    {
      try
      {
        ((ReentrantLock)localObject1).lock();
        if (((MessageForApollo)localObject2).istroop == 0)
        {
          if (((MessageForApollo)localObject2).isSend())
          {
            this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloActionManager.g = ((MessageForApollo)localObject2).frienduin;
            this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloActionManager.f = ((MessageForApollo)localObject2).senderuin;
            this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloActionManager.d = true;
            if ((!this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloActionManager.b()) && (this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloActionManager.a != null))
            {
              localObject2 = this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloActionManager.a.a(ChatActivity.class);
              if (localObject2 != null) {
                ((MqqHandler)localObject2).obtainMessage(47, (int)((float)DeviceInfoUtil.i() / 7.0F) + 40, 0).sendToTarget();
              }
            }
            ((ReentrantLock)localObject1).unlock();
            if (QLog.isColorLevel()) {
              QLog.d("ApolloMsgPlayController", 2, "there is an unread apollo msg, set role uin first. recUin:" + this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloActionManager.g + ",sendUin:" + this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloActionManager.f);
            }
            this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloMsgPlayController.a(this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloMsgPlayParam.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloMsgPlayParam.c, this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloMsgPlayParam.b, this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloMsgPlayParam.jdField_a_of_type_Int, j);
            return;
          }
          this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloActionManager.g = ((MessageForApollo)localObject2).selfuin;
          continue;
        }
        if (((MessageForApollo)localObject3).istroop == 1) {
          break label456;
        }
      }
      finally
      {
        ((ReentrantLock)localObject1).unlock();
      }
      if (((MessageForApollo)localObject3).istroop == 3000) {
        label456:
        this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloActionManager.g = Long.toString(((MessageForApollo)localObject3).mApolloMessage.peer_uin);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\psn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */