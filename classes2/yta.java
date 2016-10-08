import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.thirdpay.NFCPayPluginProxyActivity;

public class yta
  implements DialogInterface.OnClickListener
{
  public yta(NFCPayPluginProxyActivity paramNFCPayPluginProxyActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.startActivity(new Intent("android.settings.NFC_SETTINGS"));
    paramDialogInterface.dismiss();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yta.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */