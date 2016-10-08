import android.app.NotificationManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qer
  implements Runnable
{
  public qer(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      NotificationManager localNotificationManager = (NotificationManager)QQAppInterface.f(this.a).getSystemService("notification");
      localNotificationManager.cancel(121);
      localNotificationManager.cancel(119);
      localNotificationManager.cancel(122);
      localNotificationManager.cancel(123);
      localNotificationManager.cancel(129);
      localNotificationManager.cancel(135);
      localNotificationManager.cancel(140);
      localNotificationManager.cancel(144);
      localNotificationManager.cancel(193);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */