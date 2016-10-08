import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vas.VasH5PayUtil;

public class mvi
  implements View.OnClickListener
{
  public mvi(TroopMemberListActivity paramTroopMemberListActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = new Bundle();
    paramView.putString(VasH5PayUtil.f, "超级会员");
    paramView.putString(VasH5PayUtil.g, "CJCLUBT");
    paramView.putString(VasH5PayUtil.e, "1450000516");
    paramView.putInt(VasH5PayUtil.c, 3);
    paramView.putString(VasH5PayUtil.j, "http://imgcache.qq.com/club/platform/lib/pay/wv_proxy.html?_wv=524289&_fv=0&aid=" + "mvip.pt.vipsite.tqtips_chengyuan");
    paramView.putString(VasH5PayUtil.h, "svip");
    paramView.putString(VasH5PayUtil.b, this.a.app.a());
    VasH5PayUtil.a(this.a.app, this.a, paramView);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mvi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */