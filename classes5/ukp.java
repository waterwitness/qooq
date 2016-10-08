import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.activity.GroupSearchActivity;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.mobileqq.statistics.ReportController;

public class ukp
  implements View.OnClickListener
{
  public ukp(GroupSearchActivity paramGroupSearchActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    int i = 2;
    this.a.a.setText(GroupSearchActivity.a(this.a));
    this.a.a.setSelection(GroupSearchActivity.a(this.a).length());
    if (GroupSearchActivity.e == 2) {
      i = 3;
    }
    for (;;)
    {
      ReportController.b(null, "CliOper", "", "", "Search", "Last_search", i, 0, "", "", "", "");
      return;
      if (GroupSearchActivity.e != 10) {
        if (GroupSearchActivity.e == 1) {
          i = 1;
        } else {
          i = 0;
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ukp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */