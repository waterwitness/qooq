import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qqfav.ipc.IQfavRemoteProxyInterface.Stub;
import cooperation.qqfav.ipc.QfavRemoteProxyForQQ;

public class ygr
  implements ServiceConnection
{
  public ygr(QfavRemoteProxyForQQ paramQfavRemoteProxyForQQ)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    this.a.jdField_a_of_type_CooperationQqfavIpcIQfavRemoteProxyInterface = IQfavRemoteProxyInterface.Stub.a(paramIBinder);
    if (this.a.jdField_a_of_type_CooperationQqfavIpcIQfavRemoteProxyInterface != null)
    {
      paramComponentName = new ygs(this);
      paramComponentName.setName("QfavRemoteProxyForQQ.remoteProxyCallThread");
      paramComponentName.start();
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    this.a.jdField_a_of_type_CooperationQqfavIpcIQfavRemoteProxyInterface = null;
    this.a.jdField_a_of_type_Boolean = false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ygr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */