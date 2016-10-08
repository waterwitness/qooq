import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ScreenShot;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.util.ReflectionUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.KapalaiAdapterUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.MobileIssueSettings;
import com.tencent.qphone.base.util.QLog;

class pud
  implements Runnable
{
  pud(puc parampuc, BaseActivity paramBaseActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    boolean bool = true;
    Object localObject;
    if (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isResume())
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSharedPreferences("screen_shot", 4).getString("currentactivity", null);
      bool = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getClass().getName().equals(localObject);
    }
    if ((!bool) || (!SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131367835), "qqsetting_screenshot_key", false)) || (!ReflectionUtil.a(BaseApplicationImpl.a)) || (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isSupportScreenShot())) {}
    label218:
    label246:
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.screenShot == null)
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isResume())
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getApplicationContext();
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.screenShot = new ScreenShot((Context)localObject, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow());
        }
      }
      else
      {
        bool = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.screenShot.a();
        if (bool) {
          continue;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.screenShot.b()) {
          break label218;
        }
        BaseActivity.access$000(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label246;
        }
        QLog.d("BaseActivity", 2, "snapshot activate " + bool);
        return;
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
        break;
        if ((!MobileIssueSettings.g) && (Build.VERSION.SDK_INT < 11)) {
          KapalaiAdapterUtil.a().a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow());
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\pud.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */