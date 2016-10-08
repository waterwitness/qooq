import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class jbh
  implements DialogInterface.OnClickListener
{
  public jbh(QRDisplayActivity paramQRDisplayActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jbh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */