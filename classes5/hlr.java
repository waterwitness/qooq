import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hlr
  implements DialogInterface.OnDismissListener
{
  public hlr(AccountDetailActivity paramAccountDetailActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.s = false;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hlr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */