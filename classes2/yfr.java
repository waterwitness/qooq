import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;
import cooperation.qqdataline.ipc.DatalineRemoteManager;

public class yfr
  extends RemoteCommand
{
  public yfr(DatalineRemoteManager paramDatalineRemoteManager, String paramString)
  {
    super(paramString);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public Bundle invoke(Bundle paramBundle, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener)
  {
    if (paramBundle == null) {
      paramBundle = null;
    }
    Bundle localBundle;
    do
    {
      return paramBundle;
      paramBundle.setClassLoader(getClass().getClassLoader());
      localBundle = DatalineRemoteManager.a(this.a, paramBundle);
      if (localBundle != null) {
        localBundle.setClassLoader(getClass().getClassLoader());
      }
      paramBundle = localBundle;
    } while (paramOnInvokeFinishLinstener == null);
    paramOnInvokeFinishLinstener.onInvokeFinish(localBundle);
    return localBundle;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yfr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */