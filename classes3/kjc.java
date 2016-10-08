import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class kjc
  implements Runnable
{
  kjc(kjb paramkjb, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    TextView localTextView;
    if ((AddFriendVerifyActivity.b(this.jdField_a_of_type_Kjb.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity).isShown()) && (this.jdField_a_of_type_Kjb.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.b.isShown()))
    {
      localTextView = AddFriendVerifyActivity.b(this.jdField_a_of_type_Kjb.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Kjb.jdField_a_of_type_JavaLangString)) {
        break label84;
      }
    }
    label84:
    for (String str = this.jdField_a_of_type_JavaLangString;; str = this.jdField_a_of_type_Kjb.jdField_a_of_type_JavaLangString)
    {
      localTextView.setText(str);
      this.jdField_a_of_type_Kjb.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.b.setText(this.jdField_a_of_type_JavaLangString);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kjc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */