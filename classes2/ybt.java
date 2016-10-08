import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.groupvideo.GVideoPluginInstallerActivity;

public class ybt
  extends Handler
{
  public ybt(GVideoPluginInstallerActivity paramGVideoPluginInstallerActivity, Looper paramLooper)
  {
    super(paramLooper);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void dispatchMessage(Message paramMessage)
  {
    if (paramMessage == null) {}
    do
    {
      return;
      switch (paramMessage.what)
      {
      default: 
        return;
      case 1: 
        GVideoPluginInstallerActivity.a(this.a);
        return;
      }
    } while ((!(paramMessage.obj instanceof String)) || (this.a.a == null));
    this.a.a.setText((String)paramMessage.obj);
    return;
    GVideoPluginInstallerActivity.b(this.a);
    return;
    this.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ybt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */