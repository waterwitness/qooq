import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.ui.VChatActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class gyr
  implements DialogInterface.OnClickListener
{
  public gyr(VChatActivity paramVChatActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ReportController.b(null, "CliOper", "", "", "AV_module", "AV_module_install", 0, 0, "", "", "", "");
    paramDialogInterface.dismiss();
    this.a.a();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gyr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */