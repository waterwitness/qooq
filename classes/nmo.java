import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.item.MixedMsgItemBuilder;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class nmo
  implements View.OnClickListener
{
  public nmo(MixedMsgItemBuilder paramMixedMsgItemBuilder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    int i = 1;
    int j = 0;
    if (MixedMsgItemBuilder.c(this.a)) {
      return;
    }
    ChatMessage localChatMessage = AIOUtils.a(paramView);
    if ((localChatMessage instanceof MessageForMixedMsg))
    {
      paramView = (MessageRecord)((MessageForMixedMsg)localChatMessage).msgElemList.get(0);
      if (!(paramView instanceof MessageForReplyText)) {
        break label270;
      }
      paramView = (MessageForReplyText)paramView;
    }
    for (;;)
    {
      if (i == 0)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.w(MixedMsgItemBuilder.a(), 2, "MixedMsgItemBuilder onClickListener: AIOUtils.getMessage(v) is not MessageForMixedMsg or not contain replyText");
        return;
        if (!(localChatMessage instanceof MessageForLongMsg)) {
          break label261;
        }
        paramView = (MessageForLongMsg)localChatMessage;
        if (paramView.longMsgFragmentList == null) {
          break label261;
        }
        paramView = paramView.longMsgFragmentList;
        if (paramView.size() <= 0) {
          break label261;
        }
        paramView = (MessageRecord)paramView.get(0);
        if (!(paramView instanceof MessageForMixedMsg)) {
          break label261;
        }
        paramView = (MessageRecord)((MessageForMixedMsg)paramView).msgElemList.get(0);
        if (!(paramView instanceof MessageForReplyText)) {
          break label261;
        }
        paramView = (MessageForReplyText)paramView;
        i = 1;
        continue;
      }
      if (!(this.a.a instanceof FragmentActivity)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.w(MixedMsgItemBuilder.a(), 2, "MixedMsgItemBuilder onClickListener: isReplyMsg = true");
      }
      BaseChatPie localBaseChatPie = ((FragmentActivity)this.a.a).getChatFragment().a();
      if (!(localBaseChatPie instanceof TroopChatPie)) {
        break;
      }
      ((TroopChatPie)localBaseChatPie).a(14, paramView.mSourceMsgInfo.mSourceMsgSeq, (int)(localChatMessage.shmsgseq - paramView.mSourceMsgInfo.mSourceMsgSeq), localChatMessage);
      MessageForReplyText.reportReplyMsg(null, "replyMsg_bubble", "clk_original", localChatMessage.frienduin, localChatMessage);
      return;
      label261:
      paramView = null;
      i = j;
      continue;
      label270:
      paramView = null;
      i = 0;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nmo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */