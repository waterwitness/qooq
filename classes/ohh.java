import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ohh
  implements View.OnClickListener
{
  public ohh(ClassificationSearchActivity paramClassificationSearchActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    this.a.jdField_a_of_type_AndroidWidgetEditText.setText("");
    if (this.a.d == ClassificationSearchActivity.jdField_a_of_type_Int)
    {
      ClassificationSearchActivity.a(this.a);
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment.g();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ohh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */