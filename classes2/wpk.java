import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.msfmqpsdkbridge.MSFIntChkStrike;

public class wpk
  implements DialogInterface.OnDismissListener
{
  public wpk(MSFIntChkStrike paramMSFIntChkStrike)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    MSFIntChkStrike.a(this.a, false);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wpk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */