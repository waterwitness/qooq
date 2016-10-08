import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class mcl
  implements Runnable
{
  public mcl(QQBrowserActivity paramQQBrowserActivity, TextView paramTextView1, TextView paramTextView2, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetTextView.getText().toString()))
    {
      this.b.setText(this.jdField_a_of_type_JavaLangString);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.setTitle(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mcl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */