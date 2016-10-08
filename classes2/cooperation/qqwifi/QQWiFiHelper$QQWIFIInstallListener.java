package cooperation.qqwifi;

import android.content.Intent;
import android.os.IBinder;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import yjh;

public class QQWiFiHelper$QQWIFIInstallListener
  implements OnPluginInstallListener
{
  private int jdField_a_of_type_Int;
  private Intent jdField_a_of_type_AndroidContentIntent;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  
  public QQWiFiHelper$QQWIFIInstallListener(BaseActivity paramBaseActivity, int paramInt, AppInterface paramAppInterface, Intent paramIntent)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
  }
  
  public IBinder asBinder()
  {
    return null;
  }
  
  public void onInstallBegin(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQWiFiHelper", 2, "onInstallBegin, pluginId:" + paramString);
    }
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return;
    }
    paramString = new Intent("campus_wifi_state_changed");
    paramString.putExtra("state", 6);
    BaseApplication.getContext().sendBroadcast(paramString);
  }
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQWiFiHelper", 2, "onInstallDownloadProgress, pluginId:" + paramString + ",offset:" + paramInt1 + ",total:" + paramInt2);
    }
  }
  
  public void onInstallError(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQWiFiHelper", 2, "onInstallError, pluginId:" + paramString + ",errorCode:" + paramInt);
    }
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return;
    }
    paramString = new Intent("campus_wifi_state_changed");
    paramString.putExtra("state", 3);
    BaseApplication.getContext().sendBroadcast(paramString);
  }
  
  public void onInstallFinish(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQWiFiHelper", 2, "onInstallFinish, pluginId:" + paramString);
    }
    Intent localIntent = new Intent("com.tencent.mobileqq.cooperation.plugin." + paramString);
    localIntent.putExtra("plugin", paramString);
    BaseApplication.getContext().sendBroadcast(localIntent);
    switch (this.jdField_a_of_type_Int)
    {
    default: 
    case 0: 
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new yjh(this));
      return;
    }
    if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) && (this.jdField_a_of_type_AndroidContentIntent != null))
    {
      QQWiFiHelper.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_AndroidContentIntent);
      return;
    }
    paramString = new Intent("campus_wifi_state_changed");
    paramString.putExtra("state", 3);
    BaseApplication.getContext().sendBroadcast(paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qqwifi\QQWiFiHelper$QQWIFIInstallListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */