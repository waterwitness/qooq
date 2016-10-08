import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoInviteFull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.ThemeSwitchDlgActivity;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.theme.ThemeSwitchManager;
import com.tencent.mobileqq.theme.ThemeUtil.ThemeInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class uzu
  implements Runnable
{
  uzu(uzt paramuzt, Activity paramActivity, Bundle paramBundle, ThemeUtil.ThemeInfo paramThemeInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ThemeSwitch", 2, "checkTopActivity is running");
    }
    this.jdField_a_of_type_Uzt.a.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_a_of_type_Uzt.a.jdField_a_of_type_JavaLangRunnable);
    Object localObject1 = this.jdField_a_of_type_Uzt.a.a(this.jdField_a_of_type_Uzt.a.jdField_a_of_type_AndroidContentContext);
    if (localObject1 == null)
    {
      this.jdField_a_of_type_Uzt.a.jdField_a_of_type_MqqOsMqqHandler = null;
      return;
    }
    Object localObject2 = localObject1[1];
    if ((!localObject1[0].equals(this.jdField_a_of_type_Uzt.a.jdField_a_of_type_AndroidContentContext.getPackageName())) || (AVActivity.class.getName().equals(localObject2)) || (VideoInviteFull.class.getName().equals(localObject2)) || (AIOGalleryActivity.class.getName().equals(localObject2)))
    {
      this.jdField_a_of_type_Uzt.a.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_a_of_type_Uzt.a.jdField_a_of_type_JavaLangRunnable, 3000L);
      return;
    }
    if ((this.jdField_a_of_type_AndroidAppActivity != null) && (SplashActivity.class.getName().equals(localObject2)) && ((this.jdField_a_of_type_AndroidAppActivity instanceof SplashActivity)) && (((SplashActivity)this.jdField_a_of_type_AndroidAppActivity).a() == 3))
    {
      this.jdField_a_of_type_AndroidOsBundle.putSerializable("themeinfo", this.jdField_a_of_type_ComTencentMobileqqThemeThemeUtil$ThemeInfo);
      if (this.jdField_a_of_type_Uzt.a.a()) {
        this.jdField_a_of_type_Uzt.a.a(true, false, this.jdField_a_of_type_AndroidOsBundle);
      }
      this.jdField_a_of_type_Uzt.a.b(BaseApplicationImpl.a.a(), this.jdField_a_of_type_ComTencentMobileqqThemeThemeUtil$ThemeInfo);
    }
    for (;;)
    {
      this.jdField_a_of_type_Uzt.a.d = true;
      this.jdField_a_of_type_Uzt.a.jdField_a_of_type_MqqOsMqqHandler = null;
      this.jdField_a_of_type_Uzt.a.jdField_a_of_type_JavaLangRunnable = null;
      if (this.jdField_a_of_type_Uzt.a.jdField_a_of_type_AndroidContentBroadcastReceiver == null) {
        break;
      }
      this.jdField_a_of_type_Uzt.a.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_Uzt.a.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_Uzt.a.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
      return;
      if (this.jdField_a_of_type_Uzt.a.a())
      {
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("themedownloadalert", true);
        ((Intent)localObject1).putExtra("themeID", this.jdField_a_of_type_ComTencentMobileqqThemeThemeUtil$ThemeInfo.themeId);
        ((Intent)localObject1).setClass(this.jdField_a_of_type_Uzt.a.jdField_a_of_type_AndroidContentContext, ThemeSwitchDlgActivity.class);
        if (BaseActivity.sTopActivity != null)
        {
          BaseActivity.sTopActivity.startActivity((Intent)localObject1);
        }
        else
        {
          ((Intent)localObject1).setFlags(268435456);
          this.jdField_a_of_type_Uzt.a.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uzu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */