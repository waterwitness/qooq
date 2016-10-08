import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

public class mdw
  implements View.OnClickListener
{
  public mdw(QQMapActivity paramQQMapActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (this.a.a == null)
    {
      this.a.a = ((ActionSheet)ActionSheetHelper.a(this.a, null));
      this.a.a.c(2131366010);
      this.a.a.c(2131365886);
      this.a.a.d(2131367262);
      this.a.a.a(new mdx(this));
    }
    if (!this.a.a.isShowing()) {
      this.a.a.show();
    }
    ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "rec_locate", "click_menu", 0, 0, "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mdw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */