import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.maproam.Utils;

public final class tcb
  implements DialogInterface.OnDismissListener
{
  public tcb()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (paramDialogInterface == Utils.a) {
      Utils.a = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tcb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */