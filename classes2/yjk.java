import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qwallet.open.OpenPayActivity;

public class yjk
  implements DialogInterface.OnCancelListener
{
  public yjk(OpenPayActivity paramOpenPayActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (!this.a.isFinishing()) {
      this.a.a(64532, "Pay Cancelled.", null, null);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yjk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */