import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqhotspot.hotspotnode.QQHotSpotWiFiScanTool;
import java.util.Timer;

public class yhk
  extends BroadcastReceiver
{
  public yhk(QQHotSpotWiFiScanTool paramQQHotSpotWiFiScanTool)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("android.net.wifi.WIFI_STATE_CHANGED")) {}
    switch (paramIntent.getIntExtra("wifi_state", 4))
    {
    default: 
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(this.a.a, 2, "mWiFiStateReceiver: WIFI_STATE_CHANGED_ACTION, wifi enabled, now start to scan ap");
    }
    if (QQHotSpotWiFiScanTool.a(this.a) != null)
    {
      QQHotSpotWiFiScanTool.a(this.a).cancel();
      QQHotSpotWiFiScanTool.a(this.a, null);
    }
    QQHotSpotWiFiScanTool.b(this.a);
    BaseApplication.getContext().unregisterReceiver(QQHotSpotWiFiScanTool.b(this.a));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yhk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */