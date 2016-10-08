import android.app.Dialog;
import android.view.View;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.mobileqq.activity.aio.PlusPanel;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class ndt
  implements ActionSheet.OnButtonClickListener
{
  public ndt(PlusPanel paramPlusPanel, ActionSheet paramActionSheet)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.a == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.a.isShowing())) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.a.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.a = null;
      if ((paramInt < 0) && (paramInt >= 2)) {
        return;
      }
      if (paramInt == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.c();
        ReportController.b(PlusPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel), "CliOper", "", "", "0X8005DC6", "0X8005DC6", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        try
        {
          this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
          return;
        }
        catch (Exception paramView)
        {
          return;
        }
        if (paramInt == 1)
        {
          VideoMsgTools.a(PlusPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel), PlusPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel).a, PlusPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel).d);
          ReportController.b(PlusPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel), "CliOper", "", "", "0X8005DC7", "0X8005DC7", 0, 0, "", "", "", "");
        }
      }
    }
    catch (Exception paramView)
    {
      for (;;) {}
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ndt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */