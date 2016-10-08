import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.qrcode.activity.QRCardActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class jav
  implements DialogInterface.OnDismissListener
{
  public jav(QRCardActivity paramQRCardActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.c = false;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jav.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */