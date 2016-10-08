import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.text.QQText;

class lab
  implements Runnable
{
  lab(laa paramlaa, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    TextView localTextView = (TextView)this.jdField_a_of_type_Laa.jdField_a_of_type_AndroidViewView.findViewById(2131297124);
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!localTextView.getText().equals(this.jdField_a_of_type_JavaLangString))) {
      localTextView.setText(new QQText(this.jdField_a_of_type_JavaLangString, 3));
    }
    while ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (localTextView.getText().equals(this.jdField_a_of_type_JavaLangString))) {
      return;
    }
    localTextView.setText(new QQText(this.jdField_a_of_type_Laa.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.getString(2131365073), 3));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */