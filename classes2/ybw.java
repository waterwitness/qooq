import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ybw
  implements DialogInterface.OnDismissListener
{
  public ybw()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface) {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ybw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */