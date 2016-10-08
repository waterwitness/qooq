import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qve
  implements View.OnClickListener
{
  public qve(BusinessCardEditActivity paramBusinessCardEditActivity, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardEditActivity.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardEditActivity.jdField_a_of_type_AndroidAppDialog.isShowing()))
    {
      this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardEditActivity.jdField_a_of_type_AndroidAppDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardEditActivity.jdField_a_of_type_AndroidAppDialog = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardEditActivity.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\qve.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */