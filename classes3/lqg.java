import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.LbsBaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lqg
  implements View.OnClickListener
{
  public lqg(LbsBaseActivity paramLbsBaseActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if ((LbsBaseActivity.b(this.a) != null) && (LbsBaseActivity.b(this.a).isShowing())) {
      this.a.a(LbsBaseActivity.b(this.a));
    }
    this.a.a();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lqg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */