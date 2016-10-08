import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForTroopNotification;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.vipgift.VipGiftManager;

public class nqg
  implements View.OnClickListener
{
  public nqg(StructingMsgItemBuilder paramStructingMsgItemBuilder, AbsShareMsg paramAbsShareMsg, MessageForStructing paramMessageForStructing, long paramLong, View.OnClickListener paramOnClickListener)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID == 70) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_talk", "", "obj", "Clk_talk", 0, 0, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.uin, "", "", "");
    }
    for (;;)
    {
      com.tencent.mobileqq.activity.aio.AIOUtils.l = true;
      if (!StructingMsgItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder)) {
        break;
      }
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID == 81) {
        StoryReportor.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing, "clk_play");
      }
    }
    if ((((VipGiftManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(75)).b(this.jdField_a_of_type_Long)) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID == 38)) {
      label137:
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.istroop == 7100)
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mContentTitle;
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mContentTitle)) {
          break label329;
        }
        paramView = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mContentTitle.substring(0, Math.min(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mContentTitle.length(), 10));
      }
    }
    label329:
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80054B7", "0X80054B7", 0, 0, "", "", paramView + "", "");
      if (!(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing instanceof MessageForTroopNotification)) {
        break;
      }
      paramView = (MessageForTroopNotification)this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_bulletin", "", "AIOchat", "obj_clk", 0, 0, paramView.frienduin, "" + paramView.feedType, "", "");
      return;
      this.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(paramView);
      break label137;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nqg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */