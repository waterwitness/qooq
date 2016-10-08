import android.os.Bundle;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqhotspot.ipc.QQHotSpotRemoteManager;

public class yib
  extends PublicAccountObserver
{
  public yib(QQHotSpotRemoteManager paramQQHotSpotRemoteManager, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQHotSpotRemoteManager", 2, "onFollowPublicAccount isSuccess: " + paramBoolean + " | uin: " + paramString);
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "BusinessHandler_follow_public_account");
    localBundle.putInt("listinfoprotoex_seq", this.i);
    localBundle.putString("publicaccount_uin", paramString);
    localBundle.putBoolean("result", paramBoolean);
    QQHotSpotRemoteManager.a(this.a, localBundle, true);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yib.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */