import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.TranslucentActivity;

public class ylr
  implements DialogInterface.OnDismissListener
{
  public ylr(TranslucentActivity paramTranslucentActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ylr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */