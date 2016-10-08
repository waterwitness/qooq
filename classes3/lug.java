import android.widget.Button;
import android.widget.EditText;
import com.tencent.mobileqq.activity.LoginVerifyCodeActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.Utils;

public class lug
  implements Runnable
{
  public lug(LoginVerifyCodeActivity paramLoginVerifyCodeActivity, String paramString1, String paramString2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    String str = Utils.b(this.jdField_a_of_type_JavaLangString, this.b);
    if ((str != null) && (str.length() > 0) && (LoginVerifyCodeActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityLoginVerifyCodeActivity) != null))
    {
      LoginVerifyCodeActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityLoginVerifyCodeActivity).setText(str);
      LoginVerifyCodeActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityLoginVerifyCodeActivity).setEnabled(true);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lug.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */