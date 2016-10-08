import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.RegisterQQNumberActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class miv
  implements View.OnClickListener
{
  public miv(RegisterQQNumberActivity paramRegisterQQNumberActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, LoginActivity.class);
    paramView.putExtra("uin", RegisterQQNumberActivity.a(this.a));
    paramView.putExtra("tab_index", MainFragment.a);
    paramView.addFlags(131072);
    this.a.startActivity(paramView);
    this.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\miv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */