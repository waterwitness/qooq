import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder.Holder;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class nhr
  implements View.OnClickListener
{
  public nhr(ApolloItemBuilder paramApolloItemBuilder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if ((!this.a.d) || (ApolloItemBuilder.b(this.a)) || (!ApolloManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication())) || (System.currentTimeMillis() - ApolloItemBuilder.a(this.a) < 500L)) {}
    ApolloItemBuilder.Holder localHolder;
    MessageForApollo localMessageForApollo;
    do
    {
      return;
      ApolloItemBuilder.a(this.a, System.currentTimeMillis());
      ApolloManager.b.clear();
      localHolder = (ApolloItemBuilder.Holder)AIOUtils.a(paramView);
      localMessageForApollo = (MessageForApollo)localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if ((localMessageForApollo.mApolloMessage == null) || (localMessageForApollo.mApolloMessage.id == 99999))
      {
        QQToast.a(paramView.getContext(), "消息接收失败，请查看其他消息", 0).a();
        return;
      }
      int j = localMessageForApollo.mApolloMessage.id;
      if (!localMessageForApollo.isDoubleAction()) {
        break label646;
      }
      i = 1;
      if (ApolloUtil.a(j, i)) {
        break;
      }
      paramView = (ApolloManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152);
      if ((paramView != null) && (paramView.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f()) != 2))
      {
        localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
        if (!ApolloManager.a.contains(Long.valueOf(localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))) {
          ApolloManager.a.add(Long.valueOf(localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq));
        }
      }
    } while (!NetworkUtil.h(this.a.jdField_a_of_type_AndroidContentContext));
    Object localObject = (ApolloManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152);
    paramView = (VasExtensionHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71);
    ArrayList localArrayList;
    if (paramView != null)
    {
      localArrayList = new ArrayList(2);
      if (!localMessageForApollo.isSend())
      {
        ApolloBaseInfo localApolloBaseInfo = ((ApolloManager)localObject).b(localMessageForApollo.senderuin);
        if ((localApolloBaseInfo == null) || (NetConnInfoCenter.getServerTime() - localApolloBaseInfo.apolloUpdateTime > 300L)) {
          localArrayList.add(localMessageForApollo.senderuin);
        }
        if ((QLog.isColorLevel()) && (localApolloBaseInfo != null) && (localApolloBaseInfo.apolloStatus != 1))
        {
          if (localApolloBaseInfo == null) {
            break label652;
          }
          i = localApolloBaseInfo.apolloStatus;
          label377:
          QLog.d("ApolloItemBuilder", 2, "apollo status is not opened uin: " + localMessageForApollo.senderuin + ", status: " + i);
        }
      }
      if ((localMessageForApollo.isDoubleAction()) && (localMessageForApollo.mApolloMessage.peer_uin > 0L) && (localMessageForApollo.mApolloMessage.peer_uin != this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin()))
      {
        localObject = ((ApolloManager)localObject).b(localMessageForApollo.mApolloMessage.peer_uin + "");
        if ((localObject == null) || (NetConnInfoCenter.getServerTime() - ((ApolloBaseInfo)localObject).apolloUpdateTime > 300L)) {
          localArrayList.add(localMessageForApollo.mApolloMessage.peer_uin + "");
        }
        if ((QLog.isColorLevel()) && (localObject != null) && (((ApolloBaseInfo)localObject).apolloStatus != 1)) {
          if (localObject == null) {
            break label658;
          }
        }
      }
    }
    label646:
    label652:
    label658:
    for (int i = ((ApolloBaseInfo)localObject).apolloStatus;; i = 0)
    {
      QLog.d("ApolloItemBuilder", 2, "apollo status is not opened uin: " + localMessageForApollo.mApolloMessage.peer_uin + ", status: " + i);
      if (!localArrayList.isEmpty()) {
        paramView.a((String[])localArrayList.toArray(new String[0]));
      }
      this.a.a(localHolder, 2);
      return;
      i = 0;
      break;
      i = 0;
      break label377;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nhr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */