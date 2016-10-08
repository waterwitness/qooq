import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qlink.QlinkBridgeActivity;

public class yet
  implements DialogInterface.OnDismissListener
{
  public yet(QlinkBridgeActivity paramQlinkBridgeActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */