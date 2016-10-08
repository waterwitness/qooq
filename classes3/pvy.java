import com.tencent.mobileqq.activity.weather.WeatherManager;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.MobileQQ;

public class pvy
  implements Runnable
{
  public pvy(ConfigHandler paramConfigHandler, String paramString, WeatherManager paramWeatherManager, long paramLong)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    boolean bool = false;
    File localFile = new File(this.jdField_a_of_type_ComTencentMobileqqAppConfigHandler.b.getApplication().getFilesDir(), "WeatherResource.zip");
    String str = MsfSdkUtils.insertMtype("ConfigCheck", this.jdField_a_of_type_JavaLangString);
    int i = HttpDownloadUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppConfigHandler.b, str, localFile);
    if (QLog.isColorLevel()) {
      QLog.d("weatherManager", 2, "handleWeatherResources download: " + i + ",downloadpath" + localFile.getAbsolutePath());
    }
    if (i == 0) {
      bool = this.jdField_a_of_type_ComTencentMobileqqActivityWeatherWeatherManager.a(this.jdField_a_of_type_Long, localFile.getAbsolutePath());
    }
    this.jdField_a_of_type_ComTencentMobileqqAppConfigHandler.a(9, bool, null);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pvy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */