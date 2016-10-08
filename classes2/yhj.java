import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qqhotspot.hotspotnode.QQHotSpotWiFiScanTool;

public class yhj
  extends BroadcastReceiver
{
  public yhj(QQHotSpotWiFiScanTool paramQQHotSpotWiFiScanTool)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("android.net.wifi.SCAN_RESULTS"))
    {
      QQHotSpotWiFiScanTool.a(this.a);
      BaseApplication.getContext().unregisterReceiver(QQHotSpotWiFiScanTool.a(this.a));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yhj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */