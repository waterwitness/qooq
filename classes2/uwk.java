import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.data.MessageForTroopTopic;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout15;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout15.ViewHolder;
import com.tencent.mobileqq.troop.utils.TroopTopicMgr;
import com.tencent.qphone.base.util.QLog;

public class uwk
  implements View.OnClickListener
{
  public uwk(StructMsgItemLayout15 paramStructMsgItemLayout15)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag(2131296572);
    if ((this.a.a == null) || (!(this.a.a.message instanceof MessageForTroopTopic))) {
      if (QLog.isColorLevel()) {
        QLog.d(".troop.troop_topic", 2, "StructMsgItemLayout15 onClick message is null." + this.a.a);
      }
    }
    MessageForTroopTopic localMessageForTroopTopic;
    do
    {
      do
      {
        return;
        localMessageForTroopTopic = (MessageForTroopTopic)this.a.a.message;
      } while (!(localObject instanceof Integer));
      switch (((Integer)localObject).intValue())
      {
      default: 
        return;
      case 1: 
        if (QLog.isColorLevel()) {
          QLog.d(".troop.troop_topic", 2, "StructMsgItemLayout15 onClick TAG_ACTION_BUTTON");
        }
        if (!localMessageForTroopTopic.isExpand)
        {
          ((StructMsgItemLayout15.ViewHolder)paramView.getTag(2131296573)).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          ReportController.b(StructMsgItemLayout15.a(this.a), "dc00899", "Grp_talk", "", "obj", "unfold_full", 0, 0, localMessageForTroopTopic.frienduin + "", "", "", "");
        }
        for (;;)
        {
          this.a.a(paramView.getContext(), localMessageForTroopTopic);
          return;
          ReportController.b(StructMsgItemLayout15.a(this.a), "dc00899", "Grp_talk", "", "obj", "fold_full", 0, 0, localMessageForTroopTopic.frienduin + "", "", "", "");
        }
      case 2: 
        if (QLog.isColorLevel()) {
          QLog.d(".troop.troop_topic", 2, "StructMsgItemLayout15 onClick TAG_LIKE_BUTTON");
        }
        break;
      }
    } while (localMessageForTroopTopic.isLike);
    localMessageForTroopTopic.isLike = true;
    localMessageForTroopTopic.likeNum += 1L;
    localObject = (StructMsgItemLayout15.ViewHolder)paramView.getTag(2131296573);
    ((StructMsgItemLayout15.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840209);
    ((StructMsgItemLayout15.ViewHolder)localObject).b.setText("" + localMessageForTroopTopic.likeNum);
    localMessageForTroopTopic.syncFieldsToStruct();
    if ((this.a.a != null) && ((this.a.a instanceof StructMsgForGeneralShare)) && (!AnonymousChatHelper.a().a(localMessageForTroopTopic.frienduin)) && ((this.a.a.message instanceof MessageForTroopTopic)))
    {
      localObject = (MessageForTroopTopic)this.a.a.message;
      TroopTopicMgr.a(((FragmentActivity)paramView.getContext()).getChatFragment().a(), (MessageForTroopTopic)localObject);
    }
    ReportController.b(StructMsgItemLayout15.a(this.a), "dc00899", "Grp_talk", "", "obj", "obj_like", 0, 0, localMessageForTroopTopic.frienduin + "", "", "", "");
    return;
    if (QLog.isColorLevel()) {
      QLog.d(".troop.troop_topic", 2, "StructMsgItemLayout15 onClick TAG_COMMENT_BUTTON");
    }
    ((FragmentActivity)paramView.getContext()).getChatFragment().a().g(localMessageForTroopTopic);
    ReportController.b(StructMsgItemLayout15.a(this.a), "dc00899", "Grp_talk", "", "obj", "obj_reply", 0, 0, localMessageForTroopTopic.frienduin + "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uwk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */