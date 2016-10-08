import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qlink.QQProxyForQlink;

public class yen
  implements DialogInterface.OnDismissListener
{
  public yen(QQProxyForQlink paramQQProxyForQlink)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    QQProxyForQlink.a(this.a, null);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\yen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */