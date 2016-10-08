import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.ContactUtils;

public class mgd
  implements Runnable
{
  public mgd(QQSettingMe paramQQSettingMe, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    String str2 = ContactUtils.j(this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (!"".equals(str2.trim())) {}
    }
    else
    {
      str1 = this.jdField_a_of_type_JavaLangString;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new mge(this, str1));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mgd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */