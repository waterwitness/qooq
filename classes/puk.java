import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class puk
  implements Runnable
{
  public puk(BrowserAppInterface paramBrowserAppInterface, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("qb_info", 4);
    if (!localSharedPreferences.getString("LastUIN", "").equals(this.jdField_a_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.d(BrowserAppInterface.jdField_a_of_type_JavaLangString, 2, "User account changed, need remove all cookies.");
      }
      BrowserAppInterface.a(1);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        localSharedPreferences.edit().putString("LastUIN", this.jdField_a_of_type_JavaLangString).commit();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\puk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */