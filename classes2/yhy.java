import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqhotspot.ipc.IQQHotSpotService.Stub;
import cooperation.qqhotspot.ipc.QQHotSpotRemoteManager;
import mqq.app.MobileQQ;

public class yhy
  implements ServiceConnection
{
  public yhy(QQHotSpotRemoteManager paramQQHotSpotRemoteManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    this.a.jdField_a_of_type_Boolean = false;
    this.a.jdField_a_of_type_CooperationQqhotspotIpcIQQHotSpotService = IQQHotSpotService.Stub.a(paramIBinder);
    if (QLog.isColorLevel()) {
      QLog.d("QQHotSpotRemoteManager", 2, "mQQHotSpotService connected");
    }
    QQHotSpotRemoteManager.a(this.a);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    try
    {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().unbindService(QQHotSpotRemoteManager.a(this.a));
      this.a.jdField_a_of_type_CooperationQqhotspotIpcIQQHotSpotService = null;
      this.a.jdField_a_of_type_Boolean = false;
      if (QLog.isColorLevel()) {
        QLog.d("QQHotSpotRemoteManager", 2, "mQQHotSpotService disconnected");
      }
      return;
    }
    catch (Exception paramComponentName)
    {
      for (;;)
      {
        paramComponentName.printStackTrace();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yhy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */