import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.dating.DatingBaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class rcy
  implements DialogInterface.OnDismissListener
{
  public rcy(DatingBaseActivity paramDatingBaseActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.a.a != null) {
      this.a.a = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rcy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */