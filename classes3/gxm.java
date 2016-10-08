import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.ui.PSTNC2CActivity;
import com.tencent.av.utils.PstnUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class gxm
  implements DialogInterface.OnClickListener
{
  public gxm(PSTNC2CActivity paramPSTNC2CActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    PstnUtils.a(this.a.app, this.a, 2, 12);
    ReportController.b(this.a.app, "CliOper", "", "", "0X80063F9", "0X80063F9", 5, 0, "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gxm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */