import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;

public class not
  implements Runnable
{
  public not(ShortVideoItemBuilder paramShortVideoItemBuilder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    boolean bool = false;
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    SharedPreferences localSharedPreferences = this.a.a.getPreferences();
    long l1 = localSharedPreferences.getLong("key_check_temp", 0L);
    long l2 = localCalendar.getTimeInMillis();
    if (l1 < l2) {
      bool = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "TempCleanTask, lastCheck=" + l1 + ", today:" + l2 + ", needClean : " + bool);
    }
    if (bool)
    {
      localSharedPreferences.edit().putLong("key_check_temp", l2).commit();
      ShortVideoUtils.a("", true);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\not.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */