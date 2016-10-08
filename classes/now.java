import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

class now
  implements DialogInterface.OnClickListener
{
  now(nou paramnou, QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80061FC", "0X80061FC", 0, 0, "0", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\now.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */