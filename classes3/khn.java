import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;

public class khn
  implements View.OnClickListener
{
  public khn(AccountManageActivity paramAccountManageActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (!PhoneNumLoginImpl.a().a(this.a.app, this.a)) {}
    while ((this.a.b != null) && (this.a.b.isShowing())) {
      return;
    }
    AccountManageActivity.a(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\khn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */