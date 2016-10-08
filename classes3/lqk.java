import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.LbsBaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lqk
  implements View.OnClickListener
{
  public lqk(LbsBaseActivity paramLbsBaseActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if ((LbsBaseActivity.c(this.a) != null) && (LbsBaseActivity.c(this.a).isShowing())) {
      this.a.a(LbsBaseActivity.c(this.a));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lqk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */