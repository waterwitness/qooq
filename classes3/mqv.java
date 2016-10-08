import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class mqv
  implements DialogInterface.OnDismissListener
{
  public mqv(TroopInfoActivity paramTroopInfoActivity)
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


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mqv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */