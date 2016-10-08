import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.av.ui.MultiIncomingCallsActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gus
  implements DialogInterface.OnCancelListener
{
  public gus(MultiIncomingCallsActivity paramMultiIncomingCallsActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.a.a(true, null);
    this.a.b();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */