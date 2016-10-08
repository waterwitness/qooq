import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.activity.LoginPhoneNumActivity2;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qqconnect.wtlogin.Login;

public class xhg
  implements View.OnClickListener
{
  public xhg(Login paramLogin)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.a.jdField_a_of_type_AndroidWidgetButton) {
      this.a.b();
    }
    do
    {
      return;
      if (paramView == this.a.leftView)
      {
        this.a.setResult(0);
        this.a.finish();
        return;
      }
      if (paramView == this.a.jdField_a_of_type_AndroidViewView)
      {
        this.a.jdField_a_of_type_AndroidWidgetEditText.setText("");
        return;
      }
      if (paramView == this.a.jdField_b_of_type_AndroidViewView)
      {
        this.a.jdField_b_of_type_AndroidWidgetEditText.setText("");
        return;
      }
    } while (paramView != this.a.jdField_a_of_type_AndroidWidgetTextView);
    paramView = new Intent(this.a, LoginPhoneNumActivity2.class);
    paramView.putExtra("key_req_src", this.a.j);
    this.a.startActivityForResult(paramView, 10000);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xhg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */