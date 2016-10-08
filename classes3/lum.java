import android.widget.Button;
import android.widget.EditText;
import com.tencent.mobileqq.activity.LoginVerifyCodeActivity2;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.Utils;

public class lum
  implements Runnable
{
  public lum(LoginVerifyCodeActivity2 paramLoginVerifyCodeActivity2, String paramString1, String paramString2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    String str = Utils.b(this.jdField_a_of_type_JavaLangString, this.b);
    if ((str != null) && (str.length() > 0) && (LoginVerifyCodeActivity2.a(this.jdField_a_of_type_ComTencentMobileqqActivityLoginVerifyCodeActivity2) != null))
    {
      LoginVerifyCodeActivity2.a(this.jdField_a_of_type_ComTencentMobileqqActivityLoginVerifyCodeActivity2).setText(str);
      LoginVerifyCodeActivity2.a(this.jdField_a_of_type_ComTencentMobileqqActivityLoginVerifyCodeActivity2).setEnabled(true);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */