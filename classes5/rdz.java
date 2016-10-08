import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;
import appoint.define.appoint_define.LocaleInfo;
import com.tencent.mobileqq.dating.DatingManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import mqq.app.MobileQQ;

public class rdz
  implements Runnable
{
  public rdz(DatingManager paramDatingManager, appoint_define.LocaleInfo paramLocaleInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqDatingDatingManager.a.getApplication().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqDatingDatingManager.a.a(), 0);
    String str = new String(Base64.encode(this.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo.toByteArray(), 0));
    localSharedPreferences.edit().putString("publish_dep_local_msg", str).commit();
    long l = System.currentTimeMillis();
    localSharedPreferences.edit().putLong("publish_dep_local_time", l).commit();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rdz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */