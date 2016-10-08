import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.huangye.HYBridgeActivity;

public class yck
  implements DialogInterface.OnDismissListener
{
  public yck(HYBridgeActivity paramHYBridgeActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    HYBridgeActivity.a(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */