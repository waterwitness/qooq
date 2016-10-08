import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.pgc.QQStoryDiscoverActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class iky
  implements TextWatcher
{
  public iky(QQStoryDiscoverActivity paramQQStoryDiscoverActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    this.a.jdField_a_of_type_JavaLangString = this.a.b.getText().toString().trim();
    if (TextUtils.isEmpty(this.a.jdField_a_of_type_JavaLangString)) {
      this.a.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
    }
    for (;;)
    {
      this.a.a();
      this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText("搜索中，请稍候…");
      paramEditable = this.a.getResources().getDrawable(2130838321);
      this.a.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(paramEditable, null, null, null);
      ((Animatable)paramEditable).start();
      return;
      this.a.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iky.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */