import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qqhotspot.hotspotnode.QQHotSpotWiFiScanTool;
import java.util.Timer;
import java.util.TimerTask;

public class yhl
  extends TimerTask
{
  public yhl(QQHotSpotWiFiScanTool paramQQHotSpotWiFiScanTool)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    QQHotSpotWiFiScanTool.b(this.a);
    QQHotSpotWiFiScanTool.a(this.a).cancel();
    QQHotSpotWiFiScanTool.a(this.a, null);
    BaseApplication.getContext().unregisterReceiver(QQHotSpotWiFiScanTool.b(this.a));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yhl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */