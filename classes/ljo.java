import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ljo
  implements View.OnClickListener
{
  public ljo(ForwardRecentActivity paramForwardRecentActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    this.a.a(ForwardRecentActivity.a(this.a), paramView, paramView.getId());
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ljo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */