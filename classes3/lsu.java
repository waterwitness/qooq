import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mqsafeedit.libsafeedit;
import com.tencent.mobileqq.widget.CustomSafeEditText;

public class lsu
  implements View.OnClickListener
{
  public lsu(LoginActivity paramLoginActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if ((this.a.b != null) && (this.a.b.isShown())) {
      this.a.b.setVisibility(8);
    }
    this.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setText("");
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setText("");
    libsafeedit.clearPassBuffer();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lsu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */