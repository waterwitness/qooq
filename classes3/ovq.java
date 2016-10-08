import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qrcode.activity.LoginManagerActivity;
import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ovq
  implements View.OnClickListener
{
  public ovq(BannerManager paramBannerManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131298557: 
    case 2131298558: 
    default: 
      return;
    case 2131298555: 
      paramView = new Intent(BannerManager.a(this.a), LoginManagerActivity.class);
      paramView.putExtra("loginInfo", this.a.e);
      BannerManager.a(this.a).startActivity(paramView);
      return;
    }
    this.a.b();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ovq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */