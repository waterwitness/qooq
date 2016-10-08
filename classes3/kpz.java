import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.text.ReplyedMessageSpan;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;

public class kpz
  implements View.OnClickListener
{
  public kpz(BaseChatPie paramBaseChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        return;
      } while ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) || (this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.getTag(2131296537) == null));
      paramView = (ReplyedMessageSpan)this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.getTag(2131296537);
    } while (paramView == null);
    if (QLog.isColorLevel()) {
      QLog.w("Q.aio.BaseChatPie", 2, "TextItemBuilder onClickListener: isReplyMsg = true, mSourceMsgSeq = " + paramView.a);
    }
    TroopChatPie localTroopChatPie = (TroopChatPie)this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getChatFragment().a();
    QQMessageFacade.Message localMessage = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    localTroopChatPie.a(14, paramView.a, (int)(localMessage.shmsgseq - paramView.a), null);
    MessageForReplyText.reportReplyMsg(null, "typebox", "clk_original", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, null);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kpz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */