import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qlink.QQProxyForQlink;

public class owp
  implements View.OnClickListener
{
  public owp(BannerManager paramBannerManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    BannerManager.a(this.a).app.a().a("0X800474F", 1);
    QQProxyForQlink.a(BannerManager.a(this.a), 4, null);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\owp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */