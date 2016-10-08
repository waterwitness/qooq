import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.ResultReceiver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.qphone.base.util.QLog;
import cooperation.buscard.BuscardHelper;
import mqq.app.AppRuntime;

public class xym
  implements OnPluginInstallListener, Runnable
{
  private Intent jdField_a_of_type_AndroidContentIntent;
  private ResultReceiver jdField_a_of_type_AndroidOsResultReceiver;
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  
  public xym(AppRuntime paramAppRuntime, Intent paramIntent)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    if (paramIntent != null) {
      this.jdField_a_of_type_AndroidOsResultReceiver = ((ResultReceiver)paramIntent.getParcelableExtra("result"));
    }
  }
  
  public IBinder asBinder()
  {
    return null;
  }
  
  public void onInstallBegin(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BuscardHelper", 2, "onInstallBegin");
    }
  }
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BuscardHelper", 2, "onInstallDownloadProgress");
    }
    if (this.jdField_a_of_type_AndroidOsResultReceiver != null) {
      this.jdField_a_of_type_AndroidOsResultReceiver.send(1, null);
    }
  }
  
  public void onInstallError(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BuscardHelper", 2, "onInstallError");
    }
    if (this.jdField_a_of_type_AndroidOsResultReceiver != null)
    {
      paramString = new Bundle();
      paramString.putParcelable("nfcIntent", this.jdField_a_of_type_AndroidContentIntent);
      this.jdField_a_of_type_AndroidOsResultReceiver.send(-2, paramString);
    }
  }
  
  public void onInstallFinish(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BuscardHelper", 2, "onInstallFinish");
    }
    if (this.jdField_a_of_type_AndroidOsResultReceiver != null)
    {
      paramString = new Bundle();
      paramString.putParcelable("nfcIntent", this.jdField_a_of_type_AndroidContentIntent);
      this.jdField_a_of_type_AndroidOsResultReceiver.send(4, paramString);
    }
  }
  
  public void run()
  {
    BuscardHelper.a(this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_AndroidContentIntent, null);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xym.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */