import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class ohg
  implements View.OnClickListener
{
  public ohg(ClassificationSearchActivity paramClassificationSearchActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if ((TextUtils.isEmpty(this.a.jdField_a_of_type_AndroidWidgetEditText.getText())) || (this.a.d == ClassificationSearchActivity.c))
    {
      this.a.setResult(0);
      this.a.finish();
      return;
    }
    paramView = this.a.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    if (this.a.d == ClassificationSearchActivity.jdField_a_of_type_Int)
    {
      this.a.a(paramView);
      ClassificationSearchActivity.a(this.a, paramView);
      ReportController.b(null, "dc00899", "Pb_account_lifeservice", "", "0X80067C4", "0X80067C4", 0, 0, "", "", paramView, "");
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment.a(paramView, false);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ohg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */