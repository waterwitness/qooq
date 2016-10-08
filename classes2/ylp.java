import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class ylp
  implements DialogInterface.OnDismissListener
{
  ylp(ylo paramylo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.a.a.a != null) {
      this.a.a.a.onDismiss(paramDialogInterface);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ylp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */