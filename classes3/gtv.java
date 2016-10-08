import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.ui.GAudioMembersCtrlActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;

public class gtv
  implements View.OnClickListener
{
  public gtv(GAudioMembersCtrlActivity paramGAudioMembersCtrlActivity, ActionSheet paramActionSheet)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentAvUiGAudioMembersCtrlActivity.a.a().R) {
      if (this.jdField_a_of_type_ComTencentAvUiGAudioMembersCtrlActivity.a.a().l == 1) {
        ReportController.b(null, "CliOper", "", "", "0X8005C28", "0X8005C28", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      paramView = this.jdField_a_of_type_ComTencentAvUiGAudioMembersCtrlActivity.a;
      if (!this.jdField_a_of_type_ComTencentAvUiGAudioMembersCtrlActivity.a.a().R) {
        bool = true;
      }
      paramView.a(bool);
      this.jdField_a_of_type_ComTencentAvUiGAudioMembersCtrlActivity.b();
      try
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
        return;
      }
      catch (Throwable paramView)
      {
        paramView.printStackTrace();
      }
      if (this.jdField_a_of_type_ComTencentAvUiGAudioMembersCtrlActivity.a.a().l == 3000)
      {
        ReportController.b(null, "CliOper", "", "", "0X8005C23", "0X8005C23", 0, 0, "", "", "", "");
        continue;
        if (this.jdField_a_of_type_ComTencentAvUiGAudioMembersCtrlActivity.a.a().l == 1) {
          ReportController.b(null, "CliOper", "", "", "0X8005C27", "0X8005C27", 0, 0, "", "", "", "");
        } else if (this.jdField_a_of_type_ComTencentAvUiGAudioMembersCtrlActivity.a.a().l == 3000) {
          ReportController.b(null, "CliOper", "", "", "0X8005C22", "0X8005C22", 0, 0, "", "", "", "");
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gtv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */