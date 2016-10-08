import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.qzonestatus.QzoneContactsFeedManager;
import com.tencent.qphone.base.util.QLog;

public class uew
  implements Runnable
{
  public uew(QzoneContactsFeedManager paramQzoneContactsFeedManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QzoneContactsFeedManager", 2, "updateQzoneFeeds:" + QzoneContactsFeedManager.a(this.a).a());
    }
    Object localObject = QzoneContactsFeedManager.a(this.a);
    long l2 = ((SharedPreferences)localObject).getLong("last_click_time", 0L);
    long l1 = System.currentTimeMillis();
    l2 = l1 - l2;
    if (l2 < QzoneContactsFeedManager.a()) {
      return;
    }
    long l3 = this.a.a();
    if ((l3 <= 0L) || (l2 >= QzoneContactsFeedManager.b())) {
      this.a.b();
    }
    for (;;)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putLong("last_click_time", l1);
      if (Build.VERSION.SDK_INT >= 9) {
        break;
      }
      ((SharedPreferences.Editor)localObject).commit();
      return;
      this.a.a(l3, this.a.a());
    }
    ((SharedPreferences.Editor)localObject).apply();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uew.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */