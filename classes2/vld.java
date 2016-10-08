import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.browser.TroopWebviewPlugin;

public class vld
  implements DialogInterface.OnDismissListener
{
  public vld(TroopWebviewPlugin paramTroopWebviewPlugin)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (paramDialogInterface == this.a.a) {
      this.a.a = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vld.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */