import android.os.Bundle;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;
import cooperation.qqreader.QRRemoteAsynCommond;

public class yjd
  extends PublicAccountObserver
{
  public yjd(QRRemoteAsynCommond paramQRRemoteAsynCommond, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    paramString = new Bundle();
    paramString.putBoolean("isSuccess", paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqPluginsdkIpcRemoteCommand$OnInvokeFinishLinstener.onInvokeFinish(paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yjd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */