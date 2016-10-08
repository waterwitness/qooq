import android.view.View;
import com.tencent.av.utils.PstnUtils;
import com.tencent.av.utils.VideoActionSheet;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.qcall.QCallDetailActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class tzm
  implements ActionSheet.OnButtonClickListener
{
  public tzm(QCallDetailActivity paramQCallDetailActivity, VideoActionSheet paramVideoActionSheet)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvUtilsVideoActionSheet.dismiss();
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      QCallDetailActivity.b(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity);
      return;
    }
    if ((QCallDetailActivity.c(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity) == 1) || (QCallDetailActivity.c(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity) == 2))
    {
      ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.app, this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity, this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.a, 2);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.app, "CliOper", "", "", "0X8006406", "0X8006406", 5, 0, "", "", "", "");
      return;
    }
    if (QCallDetailActivity.c(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity) == 5)
    {
      PstnUtils.a(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.app, this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity, 1, 5);
      return;
    }
    QCallDetailActivity.b(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tzm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */