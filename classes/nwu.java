import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.rebuild.BusinessCmrTmpChatPie;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;

public class nwu
  implements View.OnClickListener
{
  public nwu(BusinessCmrTmpChatPie paramBusinessCmrTmpChatPie, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    com.tencent.mobileqq.activity.aio.AIOUtils.l = true;
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBusinessCmrTmpChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Two_call", "Clk_aio_right", 0, 0, String.valueOf(0), "", "", "");
    if (this.jdField_a_of_type_Boolean)
    {
      paramView = ActionSheet.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBusinessCmrTmpChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      paramView.c(2131368096);
      paramView.d(2131367262);
      paramView.a(new nwv(this));
      paramView.a(new nww(this, paramView));
      paramView.show();
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBusinessCmrTmpChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80049E2", "0X80049E2", 0, 0, "", "", "", "");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nwu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */