import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import mqq.app.MobileQQ;

public class mgc
  implements Runnable
{
  public mgc(QQSettingMe paramQQSettingMe)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = (RedTouchManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35);
    this.a.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo = ((RedTouchManager)localObject).a(String.valueOf(100190));
    this.a.b = ((RedTouchManager)localObject).a(String.valueOf(100007));
    this.a.c = ((RedTouchManager)localObject).a(String.valueOf(100005));
    SharedPreferences localSharedPreferences = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
    if ((this.a.c != null) && (this.a.c.iNewFlag.get() == 1)) {
      localSharedPreferences.edit().putBoolean("individuationIsForcePullSpKey", true).commit();
    }
    for (;;)
    {
      this.a.e = ((RedTouchManager)localObject).a(String.valueOf(100400));
      this.a.f = ((RedTouchManager)localObject).a(String.valueOf(100160));
      this.a.g = ((RedTouchManager)localObject).a(String.valueOf(100450));
      this.a.h = ((RedTouchManager)localObject).a(String.valueOf(100180));
      this.a.i = ((RedTouchManager)localObject).a(String.valueOf(103000));
      this.a.k = ((RedTouchManager)localObject).a(String.valueOf(100460));
      this.a.c();
      localObject = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(0);
      this.a.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
      return;
      localSharedPreferences.edit().putBoolean("individuationIsForcePullSpKey", false).commit();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mgc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */