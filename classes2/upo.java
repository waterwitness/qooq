import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.servlet.QZoneNotifyServlet;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;

public class upo
  implements Runnable
{
  public upo(QZoneNotifyServlet paramQZoneNotifyServlet)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(QZoneNotifyServlet.a(), 2, "QZone scheduled QZoneFeedTimeTask run. currentTime:" + System.currentTimeMillis());
    }
    AppRuntime localAppRuntime = this.a.getAppRuntime();
    if (localAppRuntime == null) {
      return;
    }
    NewIntent localNewIntent = new NewIntent(localAppRuntime.getApplication(), QZoneNotifyServlet.class);
    localNewIntent.setAction("Qzone_Get_NewAndUnread_Count");
    localNewIntent.putExtra("bNotWorkInBackGround", true);
    localNewIntent.putExtra("qzone_send_by_time", 4);
    localAppRuntime.startServlet(localNewIntent);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\upo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */