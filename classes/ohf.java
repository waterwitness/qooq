import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class ohf
  implements TextView.OnEditorActionListener
{
  public ohf(ClassificationSearchActivity paramClassificationSearchActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramInt != 3)
    {
      bool1 = bool2;
      if (paramKeyEvent != null)
      {
        bool1 = bool2;
        if (paramKeyEvent.getKeyCode() != 66) {}
      }
    }
    else
    {
      paramTextView = this.a.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
      if (!TextUtils.isEmpty(paramTextView))
      {
        if (this.a.d != ClassificationSearchActivity.jdField_a_of_type_Int) {
          break label108;
        }
        this.a.a(paramTextView);
        ReportController.b(null, "dc00899", "Pb_account_lifeservice", "", "0X80067C4", "0X80067C4", 0, 0, "", "", paramTextView, "");
        ClassificationSearchActivity.a(this.a, paramTextView);
      }
    }
    for (;;)
    {
      bool1 = true;
      return bool1;
      label108:
      this.a.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment.a(paramTextView, false);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ohf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */