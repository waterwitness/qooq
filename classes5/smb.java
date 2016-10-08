import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.forward.ForwardSdkShareOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class smb
  implements DialogInterface.OnDismissListener
{
  public smb(ForwardSdkShareOption paramForwardSdkShareOption)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if ((this.a.a instanceof DirectForwardActivity)) {
      this.a.a.finish();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\smb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */