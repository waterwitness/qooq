import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.recent.RecommendCallHelper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class oyj
  implements View.OnClickListener
{
  public oyj(RecommendCallHelper paramRecommendCallHelper)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_AndroidViewView$OnClickListener != null) {
      this.a.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(paramView);
    }
    this.a.jdField_a_of_type_AndroidViewView.setVisibility(8);
    RecommendCallHelper.a(this.a, false);
    RecommendCallHelper.b(this.a, true);
    ReportController.b(null, "CliOper", "", "", "0X8004C0E", "0X8004C0E", 0, 0, "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\oyj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */