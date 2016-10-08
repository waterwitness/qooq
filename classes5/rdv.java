import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.mobileqq.dating.DatingDestinationActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.XListView;

public class rdv
  implements TextWatcher
{
  public rdv(DatingDestinationActivity paramDatingDestinationActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if ((paramEditable != null) && (paramEditable.length() > 0))
    {
      this.a.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
      if (this.a.jdField_a_of_type_Boolean) {
        this.a.a(paramEditable.toString(), this.a.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro);
      }
      return;
    }
    this.a.d();
    this.a.b.setVisibility(8);
    this.a.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(4);
    this.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rdv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */