import android.widget.Button;
import android.widget.EditText;
import com.tencent.mobileqq.activity.RegisterVerifyCodeActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.Utils;

public class mjm
  implements Runnable
{
  public mjm(RegisterVerifyCodeActivity paramRegisterVerifyCodeActivity, String paramString1, String paramString2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    String str = Utils.a(this.jdField_a_of_type_JavaLangString, this.b);
    if ((str != null) && (str.length() > 0) && (RegisterVerifyCodeActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterVerifyCodeActivity) != null))
    {
      RegisterVerifyCodeActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterVerifyCodeActivity).setText(str);
      RegisterVerifyCodeActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterVerifyCodeActivity).setEnabled(true);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mjm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */