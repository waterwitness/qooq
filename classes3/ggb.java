import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.service.IAVServiceForQQ.Stub;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ggb
  implements ServiceConnection
{
  public ggb(VideoAppInterface paramVideoAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    this.a.a = IAVServiceForQQ.Stub.a(paramIBinder);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    this.a.a = null;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ggb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */