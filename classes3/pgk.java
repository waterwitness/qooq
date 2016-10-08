import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.selectmember.ContactFriendInnerFrame;
import com.tencent.mobileqq.activity.selectmember.PhoneContactTabView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

class pgk
  implements DialogInterface.OnClickListener
{
  pgk(pgi parampgi)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.a.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberContactFriendInnerFrame.g();
    ReportController.b(this.a.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80063FA", "0X80063FA", 1, 0, "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pgk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */