import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;
import cooperation.dingdong.DingdongPluginRemoteCmdHandler;

public class ybe
  extends RemoteCommand
{
  public ybe(DingdongPluginRemoteCmdHandler paramDingdongPluginRemoteCmdHandler, String paramString)
  {
    super(paramString);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public Bundle invoke(Bundle paramBundle, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener)
  {
    if ((paramBundle.getBoolean("_async_call_", true)) && (Thread.currentThread() != Looper.getMainLooper().getThread()))
    {
      new Handler(Looper.getMainLooper()).post(new ybf(this, paramBundle, paramOnInvokeFinishLinstener));
      paramBundle.putInt("_result_code_", 0);
      return paramBundle;
    }
    return this.a.a(paramBundle, paramOnInvokeFinishLinstener);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ybe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */