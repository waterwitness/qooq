import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.app.PstnSessionInfo;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public final class ktv
  implements DialogInterface.OnClickListener
{
  public ktv(QQAppInterface paramQQAppInterface, Context paramContext, PstnSessionInfo paramPstnSessionInfo, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.d, this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.b, true, null, true, true, null, "from_internal");
    paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (this.jdField_a_of_type_Int == 5) {}
    for (paramInt = 2;; paramInt = 3)
    {
      ReportController.b(paramDialogInterface, "CliOper", "", "", "0X80063FC", "0X80063FC", paramInt, 0, "", "", "", "");
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ktv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */