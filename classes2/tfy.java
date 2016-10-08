import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.utils.MusicCacheManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;

public class tfy
  implements Runnable
{
  public tfy(QQPlayerService paramQQPlayerService)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    SharedPreferences localSharedPreferences = this.a.getSharedPreferences("QQPlayerService.sp", 0);
    long l1 = localSharedPreferences.getLong("del_timestamp", 0L);
    long l2 = localCalendar.getTimeInMillis();
    if (l1 < l2)
    {
      localSharedPreferences.edit().putLong("del_timestamp", l2).commit();
      if (QLog.isColorLevel()) {
        QLog.d("MusicCacheManager", 2, "lastDel<today =====>> delCacheByTimeAndSpace");
      }
      MusicCacheManager.b();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tfy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */