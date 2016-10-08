import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.biz.qqstory.takevideo.rmw.RMWServiceProxy;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class iyx
  extends Handler
{
  private RMWServiceProxy a;
  
  public iyx(RMWServiceProxy paramRMWServiceProxy)
  {
    super(Looper.getMainLooper());
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramRMWServiceProxy;
  }
  
  public void a()
  {
    this.a = null;
  }
  
  public void handleMessage(Message paramMessage)
  {
    RMWServiceProxy localRMWServiceProxy = this.a;
    if (localRMWServiceProxy != null) {
      RMWServiceProxy.a(localRMWServiceProxy, Message.obtain(paramMessage));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iyx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */