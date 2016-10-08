import android.os.Handler;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AuthDevVerifyCodeActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class klp
  implements Runnable
{
  public klp(AuthDevVerifyCodeActivity paramAuthDevVerifyCodeActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (AuthDevVerifyCodeActivity.a(this.a) <= 1)
    {
      AuthDevVerifyCodeActivity.a(this.a).setText(2131368540);
      AuthDevVerifyCodeActivity.a(this.a).setEnabled(true);
      AuthDevVerifyCodeActivity.a(this.a).setClickable(true);
      return;
    }
    AuthDevVerifyCodeActivity.b(this.a);
    AuthDevVerifyCodeActivity.a(this.a).setText(this.a.getString(2131368540) + "(" + AuthDevVerifyCodeActivity.a(this.a) + ")");
    this.a.a.postDelayed(this, 1000L);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\klp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */