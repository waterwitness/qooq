import android.view.View;
import com.tencent.av.gaudio.AVPhoneUserInfo;
import com.tencent.av.gaudio.AVPhoneUserInfo.TelInfo;
import com.tencent.av.utils.PstnUtils;
import com.tencent.av.utils.VideoActionSheet;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.qcall.QCallDetailActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.ArrayList;
import java.util.List;

public class tzk
  implements ActionSheet.OnButtonClickListener
{
  public tzk(QCallDetailActivity paramQCallDetailActivity, VideoActionSheet paramVideoActionSheet)
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
    if ((QCallDetailActivity.c(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity) == 3) || (QCallDetailActivity.c(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity) == 4))
    {
      paramView = PstnUtils.a(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.app, QCallDetailActivity.c(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity), 3000);
      ArrayList localArrayList = new ArrayList();
      if (paramView != null)
      {
        paramInt = 0;
        while (paramInt < paramView.size())
        {
          localArrayList.add(((AVPhoneUserInfo)paramView.get(paramInt)).telInfo.mobile);
          paramInt += 1;
        }
      }
      ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.app, this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity, QCallDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity), QCallDetailActivity.c(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity), true, true, true, null, localArrayList, 1, 2);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.app, "CliOper", "", "", "0X8006407", "0X8006407", 1, 0, "", "", "", "");
      return;
    }
    if (QCallDetailActivity.c(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity) == 5)
    {
      PstnUtils.a(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.app, this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity, 2, 10);
      return;
    }
    QCallDetailActivity.b(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tzk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */