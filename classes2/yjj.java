import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqwifi.QQWiFiPluginInstallActivity;

public class yjj
  extends BroadcastReceiver
{
  private yjj(QQWiFiPluginInstallActivity paramQQWiFiPluginInstallActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("qqwifi.plugin.onresume.broadcast".equals(paramIntent.getAction()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("IphoneTitleBarActivity", 2, "WiFiPluginOnResumeReceiver, onReceive");
      }
      this.a.finish();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yjj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */