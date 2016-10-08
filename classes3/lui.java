import android.os.Handler;
import android.widget.TextView;
import com.tencent.mobileqq.activity.LoginVerifyCodeActivity2;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lui
  implements Runnable
{
  public lui(LoginVerifyCodeActivity2 paramLoginVerifyCodeActivity2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (LoginVerifyCodeActivity2.a(this.a) == 1)
    {
      LoginVerifyCodeActivity2.a(this.a).setText(2131368540);
      LoginVerifyCodeActivity2.a(this.a).setEnabled(true);
      LoginVerifyCodeActivity2.a(this.a).setClickable(true);
      return;
    }
    LoginVerifyCodeActivity2.b(this.a);
    LoginVerifyCodeActivity2.a(this.a).setText(this.a.getString(2131368540) + "(" + LoginVerifyCodeActivity2.a(this.a) + ")");
    this.a.b.postDelayed(this, 1000L);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lui.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */