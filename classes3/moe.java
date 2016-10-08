import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.SubLoginActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class moe
  implements DialogInterface.OnDismissListener
{
  public moe(SubLoginActivity paramSubLoginActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.b = false;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\moe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */