import android.os.Bundle;
import com.tencent.biz.webviewbase.WebAIOController;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class jgv
  extends Client.onRemoteRespObserver
{
  public jgv(WebAIOController paramWebAIOController)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onBindedToClient()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOBanner", 2, "-->onBindedToClient");
    }
  }
  
  public void onDisconnectWithService()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOBanner", 2, "-->onDisconnectWithService");
    }
  }
  
  public void onPushMsg(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOBanner", 2, "-->onPushMsg");
    }
  }
  
  public void onResponse(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOBanner", 2, "-->onResponse");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jgv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */