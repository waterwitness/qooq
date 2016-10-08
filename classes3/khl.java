import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import mqq.os.MqqHandler;

public class khl
  implements View.OnClickListener
{
  public khl(AccountManageActivity paramAccountManageActivity)
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
    label102:
    int i;
    if (!this.a.b)
    {
      bool = true;
      paramView.b = bool;
      if (!this.a.b) {
        break label205;
      }
      this.a.rightViewText.setVisibility(8);
      this.a.rightHighLView.setVisibility(0);
      this.a.rightViewText.setText(2131368729);
      this.a.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.a.getResources().getColor(2131428306));
      if (this.a.jdField_a_of_type_AndroidViewView != null)
      {
        paramView = AccountManageActivity.a(this.a, this.a.jdField_a_of_type_AndroidViewView);
        if ((paramView instanceof ShaderAnimLayout)) {
          ((ShaderAnimLayout)paramView).d();
        }
        this.a.jdField_a_of_type_AndroidViewView = null;
      }
      int j = this.a.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      i = 0;
      label163:
      if (i >= j) {
        break label309;
      }
      paramView = this.a.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
      if ((paramView != null) && (paramView.getTag() != null)) {
        break label265;
      }
    }
    for (;;)
    {
      i += 1;
      break label163;
      bool = false;
      break;
      label205:
      this.a.rightViewText.setVisibility(0);
      this.a.rightHighLView.setVisibility(8);
      this.a.rightViewText.setText(2131368747);
      this.a.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.a.getResources().getColorStateList(2131428268));
      break label102;
      label265:
      paramView = paramView.findViewById(2131296828);
      if (paramView != null)
      {
        ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
        localLayoutParams.width = ((int)(AccountManageActivity.a(this.a) * AccountManageActivity.b(this.a)));
        paramView.setLayoutParams(localLayoutParams);
      }
    }
    label309:
    this.a.b();
    this.a.a(this.a.b);
    this.a.c = false;
    AccountManageActivity.a(this.a).postDelayed(new khm(this), 400L);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\khl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */