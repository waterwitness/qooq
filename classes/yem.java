import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qlink.QQProxyForQlink;

public class yem
  implements DialogInterface.OnClickListener
{
  public yem(QQProxyForQlink paramQQProxyForQlink)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a("0X8004857", 1);
    paramDialogInterface.dismiss();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\yem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */