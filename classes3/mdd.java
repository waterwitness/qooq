import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class mdd
  implements Runnable
{
  public mdd(QQLSActivity paramQQLSActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject1 = (ActivityManager)this.a.getSystemService("activity");
    try
    {
      Object localObject2 = ((ActivityManager)localObject1).getRunningTasks(1);
      localObject1 = Build.MANUFACTURER + "-" + Build.MODEL;
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        localObject2 = ((ActivityManager.RunningTaskInfo)((List)localObject2).get(0)).topActivity.getClassName();
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "qqlsActivity onpause by :" + (String)localObject2);
        }
        if (((String)localObject2).equals("com.tencent.mobileqq.activity.GesturePWDUnlockActivity"))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQLSActivity", 2, "qqlsActivity onpause by locking activity need to front");
          }
          localObject2 = QQLSActivity.a(this.a).obtainMessage(10);
          if (((String)localObject1).equalsIgnoreCase("Xiaomi-2013022"))
          {
            QQLSActivity.a(this.a).sendMessageDelayed((Message)localObject2, 600L);
            return;
          }
          QQLSActivity.a(this.a).sendMessage((Message)localObject2);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "qqlsActivity MSG_SETTO_FRONT by locking activity not to front e=" + localException);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mdd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */