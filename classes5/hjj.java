import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.lebasearch.SearchActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class hjj
  implements View.OnClickListener
{
  public hjj(SearchActivity paramSearchActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getTag() != null)
    {
      this.a.i = 5;
      paramView = (String)paramView.getTag();
      this.a.a(paramView);
      this.a.d(paramView);
      this.a.c(paramView);
      this.a.a(true);
      ReportController.b(this.a.app, "CliOper", "", "", "0X800516F", "0X800516F", 0, 0, null, null, null, null);
      ReportController.b(this.a.app, "CliOper", "", "", "0X800516E", "0X800516E", 0, 0, "3", null, null, null);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hjj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */