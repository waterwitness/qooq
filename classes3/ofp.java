import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.bless.BlessBaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ofp
  implements DialogInterface.OnDismissListener
{
  public ofp(BlessBaseActivity paramBlessBaseActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.z();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ofp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */