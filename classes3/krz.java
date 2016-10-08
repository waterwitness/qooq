import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.apollo.task.ApolloActionManager;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForTroopTopic;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class krz
  implements ActionSheet.OnButtonClickListener
{
  krz(kry paramkry)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (ChatActivityFacade.a != null) {
        ChatActivityFacade.a.dismiss();
      }
      return;
      ChatActivityFacade.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      if ((((this.a.jdField_a_of_type_AndroidContentContext instanceof SplashActivity)) || ((this.a.jdField_a_of_type_AndroidContentContext instanceof ChatActivity))) && (((FragmentActivity)this.a.jdField_a_of_type_AndroidContentContext).getChatFragment() != null) && (((FragmentActivity)this.a.jdField_a_of_type_AndroidContentContext).getChatFragment().a() != null))
      {
        ((FragmentActivity)this.a.jdField_a_of_type_AndroidContentContext).getChatFragment().a().a(this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
        if ((this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForTroopTopic)) {
          ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_talk", "", "obj", "del_obj", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + "", "", "", "");
        }
        if ((StructLongMessageDownloadProcessor.b(this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage)) && ((this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForStructing)))
        {
          paramView = (MessageForStructing)this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
          StructLongMessageDownloadProcessor.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.uniseq);
        }
        if ((this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForApollo))
        {
          paramView = (MessageForApollo)this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
          if (paramView != null)
          {
            ApolloActionManager.a().a(paramView.uniseq);
            if (paramView.mApolloMessage != null) {
              VipUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "del_success", ApolloUtil.a(ApolloActionManager.a().c), 0, new String[] { Integer.toString(paramView.mApolloMessage.id) });
            }
          }
        }
      }
      else
      {
        ThreadManager.a(new ksa(this), 8, null, true);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\krz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */