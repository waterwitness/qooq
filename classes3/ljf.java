import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ForceLogoutActivity;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ljf
  implements View.OnClickListener
{
  public ljf(ForceLogoutActivity paramForceLogoutActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    this.a.finish();
    this.a.startActivity(new Intent(this.a, LoginActivity.class).addFlags(67108864));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ljf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */