import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.QQSettingUtil;
import com.tencent.qphone.base.util.QLog;

class mfa
  implements Runnable
{
  mfa(mez parammez)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    boolean bool2 = false;
    for (;;)
    {
      boolean bool1;
      int j;
      try
      {
        localObject = new SpannableStringBuilder();
        localResources = this.a.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources();
        if (this.a.a.jdField_a_of_type_ComTencentMobileqqDataCard.bSuperVipOpen != 1) {
          break label374;
        }
        bool1 = true;
        if (this.a.a.jdField_a_of_type_ComTencentMobileqqDataCard.bQQVipOpen == 1) {
          bool2 = true;
        }
        j = this.a.a.jdField_a_of_type_ComTencentMobileqqDataCard.iQQVipLevel;
        if (!QLog.isColorLevel()) {
          break label357;
        }
        QLog.d("QQSettingRedesign", 2, "updateLevelAndVip bSuperVipOpen=" + bool1 + ",bQQVipOpen=" + bool2 + ",VipLevel=" + j + ",QQLevel=" + this.a.a.jdField_a_of_type_ComTencentMobileqqDataCard.iQQLevel);
      }
      catch (Throwable localThrowable)
      {
        Object localObject;
        Resources localResources;
        localThrowable.printStackTrace();
        return;
      }
      int i = Math.max(j, 1);
      ((SpannableStringBuilder)localObject).append(QQSettingUtil.a(this.a.a.b, localResources, bool1, bool2, i));
      ((SpannableStringBuilder)localObject).append(QQSettingUtil.a(localResources, this.a.a.jdField_a_of_type_ComTencentMobileqqDataCard.iQQLevel));
      this.a.a.b.setText((CharSequence)localObject);
      this.a.a.a(bool1, bool2, i);
      if (AppSetting.j)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(QQSettingMe.a(this.a.a));
        if (bool1)
        {
          ((StringBuilder)localObject).append("你是尊贵的超级会员");
          if (this.a.a.jdField_a_of_type_ComTencentMobileqqDataCard.iQQLevel > 0) {
            ((StringBuilder)localObject).append(" 等级").append(this.a.a.jdField_a_of_type_ComTencentMobileqqDataCard.iQQLevel);
          }
          this.a.a.jdField_a_of_type_AndroidViewView.setContentDescription(((StringBuilder)localObject).toString());
          return;
        }
        if (bool2)
        {
          ((StringBuilder)localObject).append("你是尊贵的会员");
          continue;
          label357:
          if (!bool1)
          {
            i = j;
            if (!bool2) {}
          }
        }
      }
      else
      {
        return;
        label374:
        bool1 = false;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mfa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */