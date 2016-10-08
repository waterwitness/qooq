import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.ChatHistory.ChatHistoryAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class kvv
  implements View.OnClickListener
{
  public kvv(ChatHistory paramChatHistory)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (this.a.c > 1)
    {
      this.a.b.setEnabled(true);
      this.a.b.setImageResource(2130838124);
      paramView = this.a;
      paramView.c -= 1;
      if (this.a.c <= 1)
      {
        this.a.jdField_a_of_type_AndroidWidgetImageView.setEnabled(false);
        this.a.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838647);
      }
      this.a.e = ((this.a.c - 1) * 8);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a(this.a.d, this.a.jdField_a_of_type_Int, this.a.e);
      this.a.jdField_a_of_type_AndroidWidgetEditText.setText(String.valueOf(this.a.c));
      this.a.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.a.jdField_a_of_type_AndroidWidgetEditText.getText().length());
      this.a.k();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kvv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */