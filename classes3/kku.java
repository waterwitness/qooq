import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.AuthDevActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class kku
  implements DialogInterface.OnDismissListener
{
  public kku(AuthDevActivity paramAuthDevActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (paramDialogInterface == AuthDevActivity.a(this.a)) {
      AuthDevActivity.a(this.a, null);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kku.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */