import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;
import cooperation.qlink.QQProxyForQlink;
import cooperation.qlink.QlinkServiceManager;

public class yex
  extends RemoteCommand
{
  public yex(QlinkServiceManager paramQlinkServiceManager, String paramString)
  {
    super(paramString);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public Bundle invoke(Bundle paramBundle, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener)
  {
    QlinkServiceManager.a(this.a).a().c(paramBundle);
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\yex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */