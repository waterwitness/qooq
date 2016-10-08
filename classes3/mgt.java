import android.view.View;
import com.tencent.mobileqq.activity.QQSettingMsgHistoryActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import mqq.os.MqqHandler;

public class mgt
  implements ActionSheet.OnButtonClickListener
{
  public mgt(QQSettingMsgHistoryActivity paramQQSettingMsgHistoryActivity, ActionSheet paramActionSheet)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMsgHistoryActivity.app, "CliOper", "", "", "Setting_tab", "Clean_chat_log", 0, 0, "0", "0", "", "");
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMsgHistoryActivity.isFinishing())
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
      this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMsgHistoryActivity.showDialog(1);
    }
    paramView = new mgu(this);
    ThreadManager.b().post(paramView);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mgt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */