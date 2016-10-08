import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.QQStoryItemBuilder;
import com.tencent.mobileqq.activity.aio.item.QQStoryItemBuilder.QQStoryMsgHolder;
import com.tencent.mobileqq.data.MessageForQQStory;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.QLog;

public class nnm
  implements View.OnClickListener
{
  public nnm(QQStoryItemBuilder paramQQStoryItemBuilder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    for (;;)
    {
      try
      {
        QQStoryItemBuilder.QQStoryMsgHolder localQQStoryMsgHolder = (QQStoryItemBuilder.QQStoryMsgHolder)AIOUtils.a(paramView);
        MessageForQQStory localMessageForQQStory = (MessageForQQStory)localQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        if (TroopBusinessUtil.a(localMessageForQQStory) != null) {
          break label219;
        }
        bool = true;
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.share", 2, "storyMsg onClick:" + localMessageForQQStory.toString());
        }
        if (paramView == localQQStoryMsgHolder.jdField_a_of_type_AndroidWidgetFrameLayout)
        {
          JumpParser.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.b, localMessageForQQStory.srcAction).b();
          paramView = JumpParser.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.b, localMessageForQQStory.msgAction);
          QQStoryItemBuilder.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "clk_tail", paramView, bool);
          return;
        }
        if (paramView == localQQStoryMsgHolder.jdField_a_of_type_AndroidWidgetRelativeLayout)
        {
          paramView = JumpParser.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.b, localMessageForQQStory.msgAction);
          paramView.b();
          QQStoryItemBuilder.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "clk_play", paramView, bool);
          return;
        }
      }
      catch (Exception paramView)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.qqstory.share", 2, "onClick exp:", paramView);
        }
      }
      return;
      label219:
      boolean bool = false;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nnm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */