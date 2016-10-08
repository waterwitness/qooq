import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;
import cooperation.huangye.ipc.HYRemoteManager;

public class ydd
  extends RemoteCommand
{
  public ydd(HYRemoteManager paramHYRemoteManager, String paramString)
  {
    super(paramString);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public Bundle invoke(Bundle paramBundle, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener)
  {
    if (paramBundle != null) {
      paramBundle.setClassLoader(getClass().getClassLoader());
    }
    paramBundle = HYRemoteManager.a(this.a, paramBundle);
    if (paramBundle != null) {
      paramBundle.setClassLoader(getClass().getClassLoader());
    }
    if (paramOnInvokeFinishLinstener != null) {
      paramOnInvokeFinishLinstener.onInvokeFinish(paramBundle);
    }
    return paramBundle;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ydd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */