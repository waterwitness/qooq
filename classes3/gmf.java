import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import com.tencent.av.random.ui.RandomMultiActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class gmf
  implements View.OnClickListener
{
  public gmf(RandomMultiActivity paramRandomMultiActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (this.a.b != null)
    {
      paramView = AnimationUtils.loadAnimation(paramView.getContext(), 2130968682);
      paramView.setFillBefore(true);
      paramView.setAnimationListener(new gmg(this));
      this.a.b.startAnimation(paramView);
      ReportController.b(null, "CliOper", "", "", "0X8006970", "0X8006970", 0, 0, "", "", "", "");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gmf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */