import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.EditInfoActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lhl
  implements View.OnClickListener
{
  public lhl(EditInfoActivity paramEditInfoActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    this.a.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(true);
    this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.a.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842146);
    EditInfoActivity.a(this.a, false);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lhl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */