import android.view.View;
import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.systemmsg.FriendSystemMsgController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.List;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgAction;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;

public class kjr
  implements ActionSheet.OnButtonClickListener
{
  public kjr(AddRequestActivity paramAddRequestActivity, ActionSheet paramActionSheet)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
    }
    if (NetworkUtil.e(BaseApplication.getContext()))
    {
      long l1 = FriendSystemMsgController.a().b();
      AddRequestActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddRequestActivity, FriendSystemMsgController.a().a(Long.valueOf(l1)));
      if (AddRequestActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddRequestActivity) != null)
      {
        paramInt = AddRequestActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddRequestActivity).msg_type.get();
        l1 = AddRequestActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddRequestActivity).msg_seq.get();
        long l2 = AddRequestActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddRequestActivity).req_uin.get();
        int i = AddRequestActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddRequestActivity).msg.sub_type.get();
        int j = AddRequestActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddRequestActivity).msg.src_id.get();
        int k = AddRequestActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddRequestActivity).msg.sub_src_id.get();
        int m = AddRequestActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddRequestActivity).msg.group_msg_type.get();
        paramView = AddRequestActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddRequestActivity).msg.actions.get();
        if ((paramView != null) && (1 < paramView.size()))
        {
          ((structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)paramView.get(1)).action_info.get()).blacklist.set(true);
          AddRequestActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddRequestActivity, true);
          this.jdField_a_of_type_ComTencentMobileqqActivityAddRequestActivity.app.a().a().a(paramInt, l1, l2, i, j, k, m, (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)paramView.get(1)).action_info.get(), 1, null, false);
          AddRequestActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddRequestActivity, 2131368647, 1000L, false);
        }
      }
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAddRequestActivity.app, "CliOper", "", "", "Verification_msg", "Vfc_shield_clk", 0, 0, "", "", "", "");
      break;
      StringBuilder localStringBuilder = new StringBuilder().append("shield, ");
      if (paramView != null) {}
      for (paramInt = paramView.size();; paramInt = -1)
      {
        QLog.d("Q.systemmsg.AddRequestActivity", 1, paramInt);
        break;
      }
      QLog.d("Q.systemmsg.AddRequestActivity", 1, "shield");
      continue;
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddRequestActivity, 2131369008, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAddRequestActivity.getTitleBarHeight());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kjr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */