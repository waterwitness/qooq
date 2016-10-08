import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.RegisterVerifyCodeActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class mjn
  implements Runnable
{
  public mjn(RegisterVerifyCodeActivity paramRegisterVerifyCodeActivity, Bundle paramBundle)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_AndroidOsBundle == null) {}
    do
    {
      boolean bool1;
      boolean bool2;
      String str1;
      String str2;
      do
      {
        return;
        bool1 = this.jdField_a_of_type_AndroidOsBundle.getBoolean("visibility", false);
        localObject = this.jdField_a_of_type_AndroidOsBundle.getString("enableVersion");
        bool2 = this.jdField_a_of_type_AndroidOsBundle.getBoolean("checked", false);
        str1 = this.jdField_a_of_type_AndroidOsBundle.getString("openDevLockText");
        str2 = this.jdField_a_of_type_AndroidOsBundle.getString("openDevLockHelpText");
        RegisterVerifyCodeActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterVerifyCodeActivity, this.jdField_a_of_type_AndroidOsBundle.getString("openDevLockHelpURL"));
      } while ((!bool1) || (TextUtils.isEmpty(str1)) || (RegisterVerifyCodeActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterVerifyCodeActivity, "6.5.5", (String)localObject) < 0));
      if (QLog.isColorLevel()) {
        QLog.d("RegisterVerifyCodeActivity", 2, "update ui.");
      }
      if ((bool2) && (RegisterVerifyCodeActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterVerifyCodeActivity) != null)) {
        RegisterVerifyCodeActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterVerifyCodeActivity).setChecked(bool2);
      }
      Object localObject = SpannableString.valueOf(str1);
      if (!TextUtils.isEmpty(str2))
      {
        mjo localmjo = new mjo(this, str1);
        int i = str1.indexOf(str2);
        ((SpannableString)localObject).setSpan(localmjo, i, str2.length() + i, 33);
      }
      RegisterVerifyCodeActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterVerifyCodeActivity).setText((CharSequence)localObject);
      RegisterVerifyCodeActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterVerifyCodeActivity).setContentDescription((CharSequence)localObject);
      RegisterVerifyCodeActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterVerifyCodeActivity).setMovementMethod(LinkMovementMethod.getInstance());
    } while (RegisterVerifyCodeActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterVerifyCodeActivity) == null);
    RegisterVerifyCodeActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterVerifyCodeActivity).setVisibility(0);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mjn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */