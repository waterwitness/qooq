import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qqdataline.ipc.DatalineRemoteManager;

public class yfw
  implements DialogInterface.OnDismissListener
{
  public yfw(DatalineRemoteManager paramDatalineRemoteManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (!this.a.b) {
      DatalineRemoteManager.a(this.a, 1);
    }
    this.a.b = false;
    this.a.a = null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yfw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */