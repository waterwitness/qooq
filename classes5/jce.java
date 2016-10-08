import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.biz.qrcode.activity.QRLoginActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class jce
  implements DialogInterface.OnCancelListener
{
  public jce(QRLoginActivity paramQRLoginActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */