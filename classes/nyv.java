import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

class nyv
  implements View.OnClickListener
{
  nyv(nyt paramnyt, Dialog paramDialog)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    this.jdField_a_of_type_Nyt.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.h = new Dialog(this.jdField_a_of_type_Nyt.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.a(), 2131558973);
    this.jdField_a_of_type_Nyt.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.h.setContentView(2130903052);
    this.jdField_a_of_type_Nyt.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.h.setCancelable(true);
    ((TextView)this.jdField_a_of_type_Nyt.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.h.findViewById(2131296852)).setText(this.jdField_a_of_type_Nyt.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.a().getString(2131368647));
    this.jdField_a_of_type_Nyt.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.h.show();
    ((HotChatHandler)this.jdField_a_of_type_Nyt.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(35)).a(this.jdField_a_of_type_Nyt.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Nyt.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, this.jdField_a_of_type_Nyt.jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin, this.jdField_a_of_type_Nyt.jdField_a_of_type_JavaLangString);
    ReportController.b(this.jdField_a_of_type_Nyt.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005D55", "0X8005D55", 0, 0, "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nyv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */