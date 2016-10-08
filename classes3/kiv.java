import android.app.Dialog;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.anonymous.QQAnonymousDialog;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.QQToast;

public class kiv
  implements View.OnClickListener
{
  public kiv(AddFriendVerifyActivity paramAddFriendVerifyActivity, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.a != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.getWindow().setSoftInputMode(2);
      this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.a.hideSoftInputFromWindow(AddFriendVerifyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity).getWindowToken(), 0);
      AddFriendVerifyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity).clearFocus();
    }
    paramView = AddFriendVerifyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity).getText().toString();
    if (TextUtils.isEmpty(paramView))
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.isFinishing())
      {
        paramView = new QQAnonymousDialog(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity);
        paramView.jdField_a_of_type_AndroidWidgetTextView.setText("请输入答案");
        paramView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841304);
        paramView.a();
      }
      return;
    }
    if (!paramView.equals(this.jdField_a_of_type_JavaLangString))
    {
      AddFriendVerifyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity).setVisibility(0);
      return;
    }
    AddFriendVerifyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity).setVisibility(8);
    if (paramView.length() > 90)
    {
      paramView = new Dialog(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity, 2131558973);
      paramView.setContentView(2130904920);
      ((TextView)paramView.findViewById(2131296852)).setText(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.getString(2131368981));
      ((ProgressBar)paramView.findViewById(2131296851)).setVisibility(8);
      ((ImageView)paramView.findViewById(2131304261)).setImageResource(2130838454);
      paramView.show();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.a(AddFriendVerifyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity).getText().toString(), true);
    if (NetworkUtil.e(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity))
    {
      AddFriendVerifyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity, AddFriendVerifyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity), AddFriendVerifyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity).getText().toString(), this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.getIntent().getIntExtra("stat_option", 0));
      return;
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity, 1, 2131369008, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.getTitleBarHeight());
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kiv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */