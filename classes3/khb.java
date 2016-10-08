import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import mqq.os.MqqHandler;

public class khb
  implements View.OnClickListener
{
  public khb(AccountManageActivity paramAccountManageActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (!this.a.c) {
      return;
    }
    paramView = this.a;
    boolean bool;
    if (!this.a.b)
    {
      bool = true;
      paramView.b = bool;
      if (!this.a.b) {
        break label234;
      }
      this.a.rightViewText.setVisibility(8);
      this.a.rightHighLView.setVisibility(0);
      this.a.rightViewText.setText(2131368729);
      this.a.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.a.getResources().getColor(2131428306));
    }
    for (;;)
    {
      if (this.a.jdField_a_of_type_AndroidViewView != null)
      {
        paramView = AccountManageActivity.a(this.a, this.a.jdField_a_of_type_AndroidViewView);
        if ((paramView instanceof ShaderAnimLayout)) {
          ((ShaderAnimLayout)paramView).d();
        }
        this.a.jdField_a_of_type_AndroidViewView = null;
      }
      this.a.b();
      this.a.a(this.a.b);
      this.a.c = false;
      AccountManageActivity.a(this.a).postDelayed(new khc(this), 400L);
      ReportController.b(this.a.app, "CliOper", "", "", "Setting_tab", "Clk_acc_edit", 0, 0, "", "", "", "");
      return;
      bool = false;
      break;
      label234:
      this.a.rightViewText.setVisibility(0);
      this.a.rightHighLView.setVisibility(8);
      this.a.rightViewText.setText(2131368747);
      this.a.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.a.getResources().getColorStateList(2131428268));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\khb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */