import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

class onb
  implements DialogInterface.OnClickListener
{
  onb(omz paramomz, String paramString1, String paramString2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_Omz.a.a(this.jdField_a_of_type_JavaLangString, this.b, false, 3);
    ReportController.b(this.jdField_a_of_type_Omz.a.app, "CliOper", "", "", "0X8005FD9", "0X8005FD9", 0, 0, "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\onb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */