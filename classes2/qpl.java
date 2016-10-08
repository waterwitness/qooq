import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import com.tencent.mobileqq.ar.RemoteArConfigManager;
import com.tencent.mobileqq.ar.aidl.ArConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArEffectConfig;
import com.tencent.mobileqq.ar.aidl.IArConfigManager;
import com.tencent.mobileqq.ar.aidl.IArConfigManager.Stub;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class qpl
  implements ServiceConnection
{
  public qpl(RemoteArConfigManager paramRemoteArConfigManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager = IArConfigManager.Stub.a(paramIBinder);
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_RemoteArConfigManager", 2, "onServiceConnected");
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager != null) {}
    try
    {
      this.a.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager.a(this.a.jdField_a_of_type_ComTencentMobileqqArAidlIArRemoteCallback);
      this.a.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo = this.a.a();
      if (this.a.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo == null) {
        this.a.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo = new ArConfigInfo();
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo != null)
      {
        paramComponentName = Message.obtain();
        paramComponentName.what = 1;
        paramComponentName.obj = this.a.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo;
        this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(paramComponentName);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig = this.a.a();
      if (this.a.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig == null) {
        this.a.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig = new ArEffectConfig();
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig != null)
      {
        paramComponentName = Message.obtain();
        paramComponentName.what = 2;
        paramComponentName.obj = this.a.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig;
        this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(paramComponentName);
      }
      return;
    }
    catch (RemoteException paramComponentName)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ArConfig_RemoteArConfigManager", 2, "registerArCallback: " + paramComponentName.getMessage());
        }
      }
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager != null) {}
    try
    {
      this.a.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager.b(this.a.jdField_a_of_type_ComTencentMobileqqArAidlIArRemoteCallback);
      this.a.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager = null;
      return;
    }
    catch (RemoteException paramComponentName)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ArConfig_RemoteArConfigManager", 2, "unregisterCallback: " + paramComponentName.getMessage());
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\qpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */