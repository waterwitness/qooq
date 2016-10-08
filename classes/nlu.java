import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder;
import com.tencent.mobileqq.activity.aio.item.LongMsgItemBuilder;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class nlu
  implements View.OnClickListener
{
  public nlu(LongMsgItemBuilder paramLongMsgItemBuilder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (LongMsgItemBuilder.a(this.a)) {}
    BaseChatPie localBaseChatPie;
    do
    {
      do
      {
        do
        {
          return;
          paramView = AIOUtils.a(paramView);
          if ((paramView instanceof MessageForLongMsg)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.w(ChatItemBuilder.a, 2, "TextItemBuilder onClickListener: AIOUtils.getMessage(v) is not MessageForLongMsg");
        return;
        paramView = (MessageForLongMsg)paramView;
      } while ((paramView.mSourceMsgInfo == null) || (!(this.a.a instanceof FragmentActivity)));
      if (QLog.isColorLevel()) {
        QLog.w(ChatItemBuilder.a, 2, "TextItemBuilder onClickListener: isReplyMsg = true");
      }
      localBaseChatPie = ((FragmentActivity)this.a.a).getChatFragment().a();
    } while (!(localBaseChatPie instanceof TroopChatPie));
    ((TroopChatPie)localBaseChatPie).a(14, paramView.mSourceMsgInfo.mSourceMsgSeq, (int)(paramView.shmsgseq - paramView.mSourceMsgInfo.mSourceMsgSeq), paramView);
    MessageForReplyText.reportReplyMsg(null, "replyMsg_bubble", "clk_original", paramView.frienduin, paramView);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nlu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */