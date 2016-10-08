import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;

public class kuv
  implements View.OnClickListener
{
  public kuv(ChatHistory paramChatHistory)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (NetworkUtil.e(BaseApplication.getContext()))
    {
      this.a.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.a.b.setVisibility(8);
      if (this.a.jdField_a_of_type_Int == 0) {
        this.a.h();
      }
      return;
    }
    this.a.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
    if (this.a.jdField_a_of_type_AndroidAppDialog != null) {
      this.a.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    this.a.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.a.b.setVisibility(0);
    this.a.c.setText(this.a.getString(2131367256));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kuv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */