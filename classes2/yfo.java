import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qqdataline.DatalineBridgeActivity;

public class yfo
  implements DialogInterface.OnDismissListener
{
  public yfo(DatalineBridgeActivity paramDatalineBridgeActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */