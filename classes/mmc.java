import android.app.NotificationManager;
import android.content.IntentFilter;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.servlet.QZoneManagerImp;

public class mmc
  implements Runnable
{
  public mmc(SplashActivity paramSplashActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      NotificationManager localNotificationManager = (NotificationManager)this.a.getSystemService("notification");
      localNotificationManager.cancel(120);
      QZoneManagerImp localQZoneManagerImp = (QZoneManagerImp)this.a.app.getManager(9);
      if (localQZoneManagerImp != null) {
        localQZoneManagerImp.a(1, 0);
      }
      localNotificationManager.cancel(121);
      localNotificationManager.cancel(122);
      localNotificationManager.cancel(123);
      localNotificationManager.cancel(129);
      localNotificationManager.cancel(144);
      localNotificationManager.cancel(193);
      localNotificationManager.cancel(194);
      SplashActivity.a(this.a, new mmd(this));
      this.a.registerReceiver(SplashActivity.a(this.a), new IntentFilter("before_account_change"));
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\mmc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */