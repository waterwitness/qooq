import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;
import cooperation.qqhotspot.ipc.QQHotSpotRemoteManager;

public class yie
  extends RemoteCommand
{
  public yie(QQHotSpotRemoteManager paramQQHotSpotRemoteManager, String paramString)
  {
    super(paramString);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public Bundle invoke(Bundle paramBundle, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener)
  {
    if (paramBundle != null) {
      paramBundle.setClassLoader(getClass().getClassLoader());
    }
    paramBundle = QQHotSpotRemoteManager.a(this.a, paramBundle);
    if (paramBundle != null) {
      paramBundle.setClassLoader(getClass().getClassLoader());
    }
    if (paramOnInvokeFinishLinstener != null) {
      paramOnInvokeFinishLinstener.onInvokeFinish(paramBundle);
    }
    return paramBundle;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yie.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */