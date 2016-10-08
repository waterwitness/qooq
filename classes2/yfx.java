import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RegisterProxySvcPackHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqdataline.ipc.DatalineRemoteManager;
import cooperation.qqdataline.ipc.IDatalineService.Stub;
import mqq.app.MobileQQ;

public class yfx
  implements ServiceConnection
{
  public yfx(DatalineRemoteManager paramDatalineRemoteManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    this.a.jdField_a_of_type_Boolean = false;
    this.a.jdField_a_of_type_CooperationQqdatalineIpcIDatalineService = IDatalineService.Stub.a(paramIBinder);
    if (QLog.isColorLevel()) {
      QLog.d("DatalineRemoteManager", 2, "mDatalineService connected");
    }
    paramComponentName = (RegisterProxySvcPackHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(10);
    this.a.a(paramComponentName.a(), paramComponentName.g(), paramComponentName.i(), paramComponentName.j(), paramComponentName.a());
    DatalineRemoteManager.c(this.a);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().unbindService(DatalineRemoteManager.a(this.a));
    this.a.jdField_a_of_type_CooperationQqdatalineIpcIDatalineService = null;
    this.a.jdField_a_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("DatalineRemoteManager", 2, "mDatalineService disconnected");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yfx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */