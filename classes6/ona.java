import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

class ona
  implements DialogInterface.OnClickListener
{
  ona(omz paramomz)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ReportController.b(this.a.a.app, "CliOper", "", "", "0X8005FDA", "0X8005FDA", 0, 0, "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ona.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */