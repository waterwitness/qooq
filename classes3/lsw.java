import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lsw
  implements DialogInterface.OnDismissListener
{
  public lsw(LoginActivity paramLoginActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    LoginActivity.b(this.a, false);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lsw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */