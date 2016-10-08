import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.biz.qqstory.takevideo.rmw.RMWServiceProxy;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class iyy
  implements ServiceConnection
{
  private RMWServiceProxy a;
  
  public iyy(RMWServiceProxy paramRMWServiceProxy)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramRMWServiceProxy;
  }
  
  public void a()
  {
    this.a = null;
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    RMWServiceProxy localRMWServiceProxy = this.a;
    if (localRMWServiceProxy != null) {
      RMWServiceProxy.a(localRMWServiceProxy, paramComponentName, paramIBinder);
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    RMWServiceProxy localRMWServiceProxy = this.a;
    if (localRMWServiceProxy != null) {
      RMWServiceProxy.a(localRMWServiceProxy, paramComponentName);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iyy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */