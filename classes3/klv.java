import android.widget.Button;
import com.tencent.mobileqq.activity.AuthDevVerifyCodeActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.ClearableEditText;

public class klv
  implements Runnable
{
  public klv(AuthDevVerifyCodeActivity paramAuthDevVerifyCodeActivity, String paramString1, String paramString2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    String str = Utils.c(this.jdField_a_of_type_JavaLangString, this.b);
    if ((str != null) && (str.length() > 0) && (AuthDevVerifyCodeActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevVerifyCodeActivity) != null))
    {
      AuthDevVerifyCodeActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevVerifyCodeActivity).setText(str);
      AuthDevVerifyCodeActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevVerifyCodeActivity).setEnabled(true);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\klv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */