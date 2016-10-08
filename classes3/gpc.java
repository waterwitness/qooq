import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.av.ui.AVActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gpc
  implements DialogInterface.OnDismissListener
{
  public gpc(AVActivity paramAVActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.l();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gpc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */