import android.content.Intent;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class pup
  implements Runnable
{
  public pup(BrowserAppInterface paramBrowserAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.a.isBackground_Stop) && (BaseActivity.sTopActivity == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d(BrowserAppInterface.a, 2, "no activity running, reboot for tbs now");
      }
      localIntent = new Intent();
      localIntent.putExtra("qq_mode_foreground", true);
      BrowserAppInterface.a(this.a, localIntent);
    }
    while (!QLog.isColorLevel())
    {
      Intent localIntent;
      return;
    }
    QLog.d(BrowserAppInterface.a, 2, "activity still running, cannot reboot");
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\pup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */