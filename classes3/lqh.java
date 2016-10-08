import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.LbsBaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lqh
  implements View.OnClickListener
{
  public lqh(LbsBaseActivity paramLbsBaseActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    this.a.startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 10);
    this.a.b();
    if ((LbsBaseActivity.b(this.a) != null) && (LbsBaseActivity.b(this.a).isShowing())) {
      this.a.a(LbsBaseActivity.b(this.a));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lqh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */