import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.UpgradeDetailActivity;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ltc
  implements DialogInterface.OnClickListener
{
  public ltc(LoginActivity paramLoginActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = (UpgradeDetailWrapper)this.a.getIntent().getParcelableExtra(UpgradeDetailWrapper.class.getSimpleName());
    UpgradeDetailActivity.a(this.a, paramDialogInterface, true, false, false);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ltc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */