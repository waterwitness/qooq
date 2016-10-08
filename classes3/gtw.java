import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.av.ui.GAudioMembersCtrlActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gtw
  implements DialogInterface.OnDismissListener
{
  public gtw(GAudioMembersCtrlActivity paramGAudioMembersCtrlActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.b();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gtw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */