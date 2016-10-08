import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class jbw
  implements DialogInterface.OnDismissListener
{
  public jbw(QRDisplayActivity paramQRDisplayActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.d = false;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jbw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */