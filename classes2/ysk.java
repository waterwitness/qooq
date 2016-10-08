import android.os.Handler;
import android.os.IBinder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyPluginInstallActivity;

public class ysk
  implements OnPluginInstallListener
{
  public ysk(ReadInJoyPluginInstallActivity paramReadInJoyPluginInstallActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public IBinder asBinder()
  {
    return null;
  }
  
  public void onInstallBegin(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i(ReadInJoyPluginInstallActivity.jdField_a_of_type_JavaLangString, 2, "onInstallBegin, pluginId:" + paramString);
    }
    this.a.b = 0;
    this.a.jdField_a_of_type_Int = 0;
  }
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(ReadInJoyPluginInstallActivity.jdField_a_of_type_JavaLangString, 2, "onInstallDownloadProgress, pluginId:" + paramString + ",offset:" + paramInt1 + ",total:" + paramInt2);
    }
    this.a.b = paramInt1;
    this.a.jdField_a_of_type_Int = paramInt2;
  }
  
  public void onInstallError(String paramString, int paramInt)
  {
    QLog.w(ReadInJoyPluginInstallActivity.jdField_a_of_type_JavaLangString, 1, String.format("onInstallError, download:%d/%d", new Object[] { Integer.valueOf(this.a.b), Integer.valueOf(this.a.jdField_a_of_type_Int) }));
    QLog.w(ReadInJoyPluginInstallActivity.jdField_a_of_type_JavaLangString, 1, String.format("onInstallError, pluginId:%s, errorCode:%d", new Object[] { paramString, Integer.valueOf(paramInt) }));
    if (this.a.jdField_a_of_type_Int > 0) {
      ReportController.b(null, "CliOper", "", "", "0X8005F72", "0X8005F72", 0, 0, Integer.toString(paramInt), Integer.toString(this.a.jdField_a_of_type_Int), Integer.toString(this.a.b * 100 / this.a.jdField_a_of_type_Int), "");
    }
    if (ReadInJoyPluginInstallActivity.a(this.a) != null) {
      ReadInJoyPluginInstallActivity.a(this.a).post(new ysl(this));
    }
  }
  
  public void onInstallFinish(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(ReadInJoyPluginInstallActivity.jdField_a_of_type_JavaLangString, 2, "onInstallFinish, pluginId:" + paramString);
    }
    if (this.a.jdField_a_of_type_Int > 0) {
      ReportController.b(null, "CliOper", "", "", "0X8005F71", "0X8005F71", 0, 0, "0", Integer.toString(this.a.jdField_a_of_type_Int), "100", "");
    }
    if (ReadInJoyPluginInstallActivity.a(this.a) != null) {
      ReadInJoyPluginInstallActivity.a(this.a).post(new ysm(this));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ysk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */