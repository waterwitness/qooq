import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.LbsBaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbySPUtil;

public class lql
  implements View.OnClickListener
{
  public lql(LbsBaseActivity paramLbsBaseActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    NearbySPUtil.a(this.a.getAppInterface().getAccount(), true);
    if ((LbsBaseActivity.c(this.a) != null) && (LbsBaseActivity.c(this.a).isShowing())) {
      this.a.a(LbsBaseActivity.c(this.a));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lql.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */