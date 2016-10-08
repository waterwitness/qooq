import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.bless.BlessBaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;

public class ofr
  implements View.OnClickListener
{
  public ofr(BlessBaseActivity paramBlessBaseActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.h(this.a.getApplicationContext())) {
      QQToast.a(this.a, 2131371674, 1).a();
    }
    for (;;)
    {
      BlessBaseActivity.a(this.a).dismiss();
      return;
      this.a.n();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ofr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */