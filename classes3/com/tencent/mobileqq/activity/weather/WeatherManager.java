package com.tencent.mobileqq.activity.weather;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.manager.Manager;
import mqq.observer.BusinessObserver;

public class WeatherManager
  implements Manager, BusinessObserver
{
  public static final String a = "weatherManager";
  public static final String b = "pa_send_time";
  public static final String c = "show_flag";
  public static final String d = "cur_temp";
  public static final String e = "cur_city";
  public static final String f = "cur_code";
  public static final String g = "WeatherResource.zip";
  public static final String h = "weather_resources";
  public static final String i = "key_weather_res_version";
  public static final String j = "http://weather.mp.qq.com/?_wv=5127&asyncMode=1";
  public static final String k = "http://imgcache.qq.com/zzapp/widget/city_selector/city.html?_wv=5127&redirect_url=http%3A%2F%2Fweather.mp.qq.com%2F";
  public static String l;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private WeatherManager.WeatherUpdaterListener jdField_a_of_type_ComTencentMobileqqActivityWeatherWeatherManager$WeatherUpdaterListener;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public WeatherManager(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    paramQQAppInterface = BaseApplicationImpl.getContext();
    l = paramQQAppInterface.getFilesDir().getAbsoluteFile() + File.separator + "WeatherResource";
    this.jdField_a_of_type_AndroidContentSharedPreferences = BaseApplicationImpl.a().getSharedPreferences("weather_resources", 0);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this);
  }
  
  public static String a(String paramString)
  {
    return l + File.separator + "WeatherResource" + File.separator + paramString + "_bg.jpg";
  }
  
  public static boolean a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("weatherManager", 2, "isWeatherResourceExist jpgfilepath: " + a(paramString));
    }
    return FileUtils.b(a(paramString));
  }
  
  public long a()
  {
    long l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("key_weather_res_version", 0L);
    if (QLog.isColorLevel()) {
      QLog.d("weatherManager", 2, "getConfigVersion version=" + l1);
    }
    return l1;
  }
  
  public void a()
  {
    Long localLong = Long.valueOf(BaseApplicationImpl.getContext().getSharedPreferences("public_account_weather", 0).getLong("pa_send_time", 0L));
    if (QLog.isColorLevel()) {
      QLog.d("weatherManager", 2, "updateWeatherInfo successTime:" + localLong + ",currentTime:" + System.currentTimeMillis());
    }
    if (Math.abs(System.currentTimeMillis() - localLong.longValue()) > 3600000L) {
      WeatherServlet.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("weatherManager", 2, "updateResourceVersion version=" + paramLong);
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("key_weather_res_version", paramLong).commit();
  }
  
  public void a(WeatherManager.WeatherUpdaterListener paramWeatherUpdaterListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityWeatherWeatherManager$WeatherUpdaterListener = paramWeatherUpdaterListener;
  }
  
  public boolean a(long paramLong, String paramString)
  {
    boolean bool = true;
    try
    {
      FileUtils.a(l, false);
      FileUtils.a(paramString, l, false);
      if (bool)
      {
        a(paramLong);
        return bool;
      }
    }
    catch (Exception paramString)
    {
      do
      {
        for (;;)
        {
          paramString.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.e("weatherManager", 2, "pareseRulesFromZip : delete and uncompress Exception=>", paramString);
          }
          bool = false;
        }
      } while (!QLog.isColorLevel());
      QLog.d("weatherManager", 2, "pareseRulesFromZip : delete and uncompressZip failure, parse from Res");
    }
    return bool;
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this);
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("weatherManager", 2, "WeatherManager onReceive isSucess:" + paramBoolean);
    }
    int m;
    SharedPreferences.Editor localEditor;
    if (paramBoolean)
    {
      String str1 = paramBundle.getString("KEY_TEMPER");
      String str2 = paramBundle.getString("area_name");
      String str3 = paramBundle.getString("o_wea_code");
      m = paramBundle.getInt("show_flag");
      if (QLog.isColorLevel()) {
        QLog.d("weatherManager", 2, "onReceive show_flag:" + m + ",temp:" + str1 + ",area_name" + str2 + ",o_wea_code" + str3);
      }
      localEditor = BaseApplicationImpl.getContext().getSharedPreferences("public_account_weather", 0).edit();
      if (m != 1) {
        break label284;
      }
      if ((str1 != null) && (!str1.equals("")) && (str2 != null) && (!str2.equals("")))
      {
        localEditor.putLong("pa_send_time", Long.valueOf(System.currentTimeMillis()).longValue());
        localEditor.putString("cur_temp", str1);
        localEditor.putString("cur_code", str3);
        localEditor.putString("cur_city", str2);
        localEditor.putBoolean("show_flag", true);
      }
    }
    for (;;)
    {
      localEditor.commit();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityWeatherWeatherManager$WeatherUpdaterListener == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityWeatherWeatherManager$WeatherUpdaterListener.a(paramInt, paramBoolean, paramBundle);
      return;
      label284:
      if (m == 0) {
        localEditor.putBoolean("show_flag", false);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\weather\WeatherManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */