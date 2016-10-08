import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.JumpAction;

public class way
  implements DialogInterface.OnDismissListener
{
  public way(JumpAction paramJumpAction)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if ((this.a.a instanceof LoginActivity)) {
      ((LoginActivity)this.a.a).finish();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\way.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */