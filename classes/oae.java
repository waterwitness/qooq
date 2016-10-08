import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class oae
  implements DialogInterface.OnDismissListener
{
  public oae(PublicAccountChatPie paramPublicAccountChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.Y = false;
    ReportController.b(this.a.a, "CliOper", "", "", "0X8004EFA", "0X8004EFA", 0, 0, "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */