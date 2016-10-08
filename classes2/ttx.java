import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.portal.HongBaoShareActivity;
import com.tencent.widget.ActionSheet;

public class ttx
  implements View.OnClickListener
{
  public ttx(HongBaoShareActivity paramHongBaoShareActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (HongBaoShareActivity.a(this.a).isShowing()) {
      HongBaoShareActivity.a(this.a).dismiss();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ttx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */