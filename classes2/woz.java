import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public final class woz
  implements DialogInterface.OnClickListener
{
  public woz(String paramString1, int paramInt1, int paramInt2, QQMessageFacade paramQQMessageFacade, String paramString2, int paramInt3, long paramLong)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ReportController.b(null, "P_CliOper", "Safe_SensMsg", this.jdField_a_of_type_JavaLangString, "Alert_Dialog", "Other", this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, "", "", "", "");
    ThreadManager.b(new wpa(this));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\woz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */