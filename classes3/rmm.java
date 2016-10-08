import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.QQCustomDialog;

class rmm
  implements DialogInterface.OnDismissListener
{
  rmm(rmj paramrmj)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    rmj.a(this.a).dismiss();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\rmm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */