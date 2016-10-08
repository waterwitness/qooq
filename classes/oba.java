import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class oba
  implements DialogInterface.OnDismissListener
{
  public oba(PublicAccountChatPie paramPublicAccountChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.g = null;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */