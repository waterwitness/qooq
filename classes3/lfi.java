import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.DevlockQuickLoginActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class lfi
  implements DialogInterface.OnClickListener
{
  lfi(lfh paramlfh)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a.a();
    DevlockQuickLoginActivity.c(this.a.a);
    DevlockQuickLoginActivity.b(this.a.a, 0, 2130968593);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lfi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */