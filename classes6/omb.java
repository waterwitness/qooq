import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.messagesearch.C2CMessageResultAdapter;
import com.tencent.mobileqq.activity.messagesearch.C2CMessageSearchDialog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;

public class omb
  implements TextWatcher
{
  public omb(C2CMessageSearchDialog paramC2CMessageSearchDialog)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = this.a.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim();
    if (paramEditable.length() == 0)
    {
      this.a.c = "";
      this.a.findViewById(2131300880).setVisibility(8);
      this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageResultAdapter.a();
      this.a.b.setVisibility(8);
    }
    while (this.a.c.equals(paramEditable)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(C2CMessageSearchDialog.jdField_a_of_type_JavaLangString, 2, "afterTextChanged, lastChangedKeyword = " + this.a.c + ",lastKeyWord:" + paramEditable);
    }
    this.a.c = paramEditable;
    String str = this.a.jdField_a_of_type_AndroidContentContext.getString(2131368081, new Object[] { paramEditable });
    int i = str.indexOf(paramEditable);
    SpannableString localSpannableString = new SpannableString(str);
    localSpannableString.setSpan(new ForegroundColorSpan(2131428302), 0, i, 18);
    localSpannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#0079ff")), i, paramEditable.length() + i, 34);
    localSpannableString.setSpan(new ForegroundColorSpan(2131428302), paramEditable.length() + i, str.length(), 33);
    this.a.jdField_a_of_type_AndroidWidgetTextView.setText(localSpannableString);
    C2CMessageSearchDialog.a(this.a, 1, null);
    this.a.findViewById(2131300880).setVisibility(0);
    this.a.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\omb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */