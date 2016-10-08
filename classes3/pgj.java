import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.utils.PstnUtils;
import com.tencent.mobileqq.activity.selectmember.PhoneContactTabView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

class pgj
  implements DialogInterface.OnClickListener
{
  pgj(pgi parampgi)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    PstnUtils.a(this.a.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.a.a.jdField_a_of_type_AndroidContentContext, 2, 12);
    ReportController.b(this.a.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80063F9", "0X80063F9", 1, 0, "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pgj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */