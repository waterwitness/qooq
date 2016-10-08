import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.tencent.arrange.ui.CreateArrageActivity;
import com.tencent.av.utils.PstnUtils;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public final class nea
  implements ActionSheet.OnButtonClickListener
{
  public nea(ActionSheet paramActionSheet, QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
        ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, true, true, null, null);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004863", "0X8004863", 0, 0, "", "", "", "");
        return;
        if (this.b == 0)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005560", "0X8005560", 0, 0, "", "", "", "");
          paramView = new Intent(this.jdField_a_of_type_AndroidAppActivity, CreateArrageActivity.class);
          paramView.putExtra("uin", this.jdField_a_of_type_JavaLangString);
          paramView.putExtra("uintype", this.jdField_a_of_type_Int);
          paramView.putExtra("forward_type", "create_mode");
          this.jdField_a_of_type_AndroidAppActivity.startActivityForResult(paramView, 2000);
          return;
        }
      } while (this.b != 1);
      if ((this.c == 3) || (this.c == 4))
      {
        ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, true, true, true, null, null, 1, 0);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006407", "0X8006407", 3, 0, "", "", "", "");
        return;
      }
      if (this.c == 5)
      {
        PstnUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, 2, 9);
        return;
      }
      ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, true, true, null, null);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004863", "0X8004863", 0, 0, "", "", "", "");
      return;
    } while (!QLog.isColorLevel());
    QLog.d("PlusPanelUtils", 2, "enterGAudioWithActionSheet");
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nea.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */