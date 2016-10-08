import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.testassister.activity.ShareAppLogActivity;
import com.tencent.widget.TCWDatePicker;
import com.tencent.widget.TCWDatePickerDialog.OnDateSetListener;

public class uyy
  implements TCWDatePickerDialog.OnDateSetListener
{
  public uyy(ShareAppLogActivity paramShareAppLogActivity, TextView paramTextView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(TCWDatePicker paramTCWDatePicker, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt1 + "-" + (paramInt2 + 1) + "-" + paramInt3);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uyy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */