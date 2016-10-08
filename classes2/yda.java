import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import cooperation.huangye.ipc.HYRemoteManager;
import cooperation.huangye.ipc.IHuangyeService.Stub;
import mqq.app.MobileQQ;

public class yda
  implements ServiceConnection
{
  public yda(HYRemoteManager paramHYRemoteManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    this.a.jdField_a_of_type_Boolean = false;
    this.a.jdField_a_of_type_CooperationHuangyeIpcIHuangyeService = IHuangyeService.Stub.a(paramIBinder);
    if (QLog.isColorLevel()) {
      QLog.d("HYRemoteManager", 2, "mHuangyeService connected");
    }
    HYRemoteManager.a(this.a);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    try
    {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().unbindService(HYRemoteManager.a(this.a));
      this.a.jdField_a_of_type_CooperationHuangyeIpcIHuangyeService = null;
      this.a.jdField_a_of_type_Boolean = false;
      if (QLog.isColorLevel()) {
        QLog.d("HYRemoteManager", 2, "mHuangyeService disconnected");
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


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yda.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */