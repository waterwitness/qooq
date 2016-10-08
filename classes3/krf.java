import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.tencent.mobileqq.activity.BookShareAdviceEditActivity;
import com.tencent.mobileqq.activity.book.BookEditText;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class krf
  implements TextWatcher
{
  public krf(BookShareAdviceEditActivity paramBookShareAdviceEditActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = this.a.jdField_a_of_type_ComTencentMobileqqActivityBookBookEditText.getText().toString();
    if ((paramEditable != null) && ("".equals(paramEditable))) {
      this.a.rightHighLView.setEnabled(false);
    }
    for (;;)
    {
      int i = this.a.jdField_a_of_type_ComTencentMobileqqActivityBookBookEditText.a(paramEditable);
      this.a.c = (40 - (i + 2) / 3);
      if (this.a.c < 0) {
        break;
      }
      this.a.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#9A9A9A"));
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(this.a.c));
      return;
      this.a.rightHighLView.setEnabled(true);
    }
    this.a.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-65536);
    this.a.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(this.a.c));
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\krf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */