import android.text.Layout;
import android.text.TextPaint;
import android.widget.TextView;
import com.tencent.mobileqq.activity.bless.BlessBaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public class ofs
  implements Runnable
{
  public ofs(BlessBaseActivity paramBlessBaseActivity, TextView paramTextView, StringBuilder paramStringBuilder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i = 0;
    int j = this.jdField_a_of_type_AndroidWidgetTextView.getLineCount();
    String str1;
    if (j == 4)
    {
      j = this.jdField_a_of_type_AndroidWidgetTextView.getLayout().getLineEnd(j - 1);
      if (j < this.jdField_a_of_type_JavaLangStringBuilder.length())
      {
        str1 = String.format(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessBaseActivity.getString(2131372365), new Object[] { "...", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessBaseActivity.a.size()) });
        float f = this.jdField_a_of_type_AndroidWidgetTextView.getPaint().measureText(str1);
        if (i < this.jdField_a_of_type_JavaLangStringBuilder.length())
        {
          String str2 = this.jdField_a_of_type_JavaLangStringBuilder.substring(j - i, j);
          if (this.jdField_a_of_type_AndroidWidgetTextView.getPaint().measureText(str2) < f) {
            break label244;
          }
          this.jdField_a_of_type_JavaLangStringBuilder.setLength(j - i);
        }
        BlessBaseActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessBaseActivity, this.jdField_a_of_type_JavaLangStringBuilder.toString());
        if (!BlessBaseActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessBaseActivity).endsWith("、 ")) {
          break label253;
        }
        this.jdField_a_of_type_JavaLangStringBuilder.setLength(this.jdField_a_of_type_JavaLangStringBuilder.length() - 2);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaLangStringBuilder.append(str1);
      BlessBaseActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessBaseActivity, this.jdField_a_of_type_JavaLangStringBuilder.toString());
      this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(null);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(BlessBaseActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessBaseActivity));
      return;
      label244:
      i += 1;
      break;
      label253:
      if (BlessBaseActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessBaseActivity).endsWith("、")) {
        this.jdField_a_of_type_JavaLangStringBuilder.setLength(this.jdField_a_of_type_JavaLangStringBuilder.length() - 1);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ofs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */