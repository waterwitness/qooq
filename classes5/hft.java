import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.app.MobileQQ;

public final class hft
  implements Runnable
{
  public hft(QQAppInterface paramQQAppInterface, long paramLong)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "RedTouchExManager_GetTime", 0);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putLong("last_get_time", System.currentTimeMillis() / 1000L);
      ((SharedPreferences.Editor)localObject).putLong("interval_time", this.jdField_a_of_type_Long);
      ((SharedPreferences.Editor)localObject).commit();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hft.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */