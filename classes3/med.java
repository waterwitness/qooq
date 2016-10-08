import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class med
  implements DialogInterface.OnDismissListener
{
  public med(QQMapActivity paramQQMapActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if ((this.a.m) && (!this.a.n) && (!this.a.l)) {
      this.a.finish();
    }
    this.a.n = false;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\med.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */