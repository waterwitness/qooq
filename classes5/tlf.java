import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.nearby.profilecard.InterestGuide;
import com.tencent.mobileqq.statistics.ReportController;

public class tlf
  implements Runnable
{
  public tlf(InterestGuide paramInterestGuide)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    NearbySPUtil.a(this.a.d, "interest_guide_key", Boolean.FALSE);
    Context localContext = this.a.a.getContext();
    if ((localContext instanceof BaseActivity)) {
      ReportController.b(((BaseActivity)localContext).app, "dc00898", "", "", "0X8006991", "0X8006991", 0, 0, "", "", "", "");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tlf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */