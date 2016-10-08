import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet.OnDismissListener;

public final class ndw
  implements ActionSheet.OnDismissListener
{
  public ndw(QQAppInterface paramQQAppInterface, int[] paramArrayOfInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004862", "0X8004862", 0, 0, "", "", "", "");
    if (this.jdField_a_of_type_ArrayOfInt[3] == 3) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005B05", "0X8005B05", 0, 0, "", "", "", "");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ndw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */