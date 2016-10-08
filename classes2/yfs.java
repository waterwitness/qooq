import android.os.Bundle;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qqdataline.QQProxyForDataline;
import cooperation.qqdataline.ipc.DatalineRemoteManager;

public class yfs
  implements Runnable
{
  public yfs(DatalineRemoteManager paramDatalineRemoteManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (BaseActivity.sTopActivity == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("string_from", true);
    localBundle.putBoolean("string_uin", false);
    localBundle.putLong("device_din", 0L);
    localBundle.putInt("sTitleID", 0);
    QQProxyForDataline.a(BaseActivity.sTopActivity, localBundle, "com.qqdataline.activity.LiteWifiphotoActivity");
    BaseActivity.sTopActivity.overridePendingTransition(2130968592, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yfs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */