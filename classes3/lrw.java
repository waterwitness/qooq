import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.LebaEnabledPluginsActivity;
import com.tencent.mobileqq.activity.LebaListMgrActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lrw
  implements View.OnClickListener
{
  public lrw(LebaListMgrActivity paramLebaListMgrActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, LebaEnabledPluginsActivity.class);
    this.a.startActivityForResult(paramView, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lrw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */