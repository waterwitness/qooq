import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class met
  implements View.OnClickListener
{
  public met(QQMapActivity paramQQMapActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (this.a.m)
    {
      this.a.v();
      return;
    }
    if ("group_activity".equals(this.a.u))
    {
      this.a.n();
      return;
    }
    this.a.setResult(-1, this.a.a());
    this.a.finish();
    this.a.d();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\met.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */