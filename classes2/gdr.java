import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.arrange.ui.CreateArrageActivity;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.ArrayList;

class gdr
  implements View.OnClickListener
{
  gdr(gdq paramgdq)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = (String)paramView.getTag();
    if (paramView == null) {}
    while (!paramView.equals(this.a.a.getString(2131369432))) {
      return;
    }
    ReportController.b(this.a.a.app, "CliOper", "", "", "0X8005562", "0X8005562", 0, 0, "", "", "", "");
    paramView = new Intent(this.a.a, SelectMemberActivity.class);
    ArrayList localArrayList = new ArrayList(CreateArrageActivity.a(this.a.a));
    paramView.putStringArrayListExtra("param_uins_selected_default", localArrayList);
    paramView.putExtra("param_groupcode", CreateArrageActivity.a(this.a.a));
    paramView.putExtra("param_max", 100 - localArrayList.size());
    this.a.a.startActivityForResult(paramView, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\gdr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */