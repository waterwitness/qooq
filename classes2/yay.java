import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.dingdong.DingdongPluginBridgeActivity;

public class yay
  implements DialogInterface.OnDismissListener
{
  public yay(DingdongPluginBridgeActivity paramDingdongPluginBridgeActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */