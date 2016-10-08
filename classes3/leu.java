import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.DetailProfileActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class leu
  implements DialogInterface.OnDismissListener
{
  public leu(DetailProfileActivity paramDetailProfileActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.a(this.a.a, false);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\leu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */