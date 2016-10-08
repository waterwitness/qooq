import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.activity.weather.WeatherManager.WeatherUpdaterListener;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class mfx
  implements WeatherManager.WeatherUpdaterListener
{
  public mfx(QQSettingMe paramQQSettingMe)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (this.a.b)
    {
      if (!paramBoolean) {
        break label312;
      }
      if ((this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (ApolloManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "drawer", null) <= 0) || (!ApolloManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, Boolean.valueOf(false)))) {
        break label72;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "weatherUpdateResult update but show cmShow");
      }
    }
    label72:
    label312:
    int i;
    do
    {
      String str1;
      String str2;
      do
      {
        do
        {
          return;
          paramInt = paramBundle.getInt("show_flag");
          if (QLog.isColorLevel()) {
            QLog.d("QQSettingRedesign", 2, "onWeatherUpdateResult show_flag:" + paramInt);
          }
          if (paramInt == 0)
          {
            this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
            this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setClickable(false);
            return;
          }
        } while (paramInt != 1);
        str1 = paramBundle.getString("KEY_TEMPER");
        str2 = paramBundle.getString("o_wea_code");
        paramBundle = paramBundle.getString("area_name");
        if (QLog.isColorLevel()) {
          QLog.d("QQSettingRedesign", 2, "onWeatherUpdateResult temp:" + str1 + " o_wea_code:" + str2 + " area_name:" + paramBundle);
        }
      } while ((str1 == null) || (str1.equals("")) || (paramBundle == null) || (paramBundle.equals("")));
      this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setClickable(true);
      this.a.d.setText(str1);
      this.a.f.setText(paramBundle);
      this.a.e.setText("o");
      QQSettingMe.a(this.a, str2);
      return;
      i = paramBundle.getInt("uint32_result");
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "onWeatherUpdateResult resultCode:" + i);
      }
    } while ((paramInt != 6666) || (i != 191005));
    SosoInterface.a(new mfy(this, 0, true, true, 60000L, true, false, "QQSettingRedesign"));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mfx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */