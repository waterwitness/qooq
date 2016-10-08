import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneVipInfoManager;
import mqq.app.AppRuntime;

public class yld
  implements SharedPreferences.OnSharedPreferenceChangeListener
{
  public yld(QZoneVipInfoManager paramQZoneVipInfoManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString)
  {
    paramSharedPreferences = BaseApplicationImpl.a().a();
    if (QLog.isColorLevel()) {
      QLog.d(QZoneVipInfoManager.a, 2, "onSharedPreferenceChanged key = " + paramString);
    }
    if ((!QZoneVipInfoManager.a(this.a)) && ((QZoneVipInfoManager.a(this.a, paramSharedPreferences.getAccount()).equals(paramString)) || (QZoneVipInfoManager.b(this.a, paramSharedPreferences.getAccount()).equals(paramString))) && (QZoneVipInfoManager.a(this.a) != null))
    {
      QZoneVipInfoManager.a(this.a, QZoneVipInfoManager.a(this.a).getInt(paramString, 0));
      QZoneVipInfoManager.c(this.a, QZoneVipInfoManager.a(this.a).getString(paramString, null));
      if (QLog.isColorLevel()) {
        QLog.d(QZoneVipInfoManager.a, 2, "onSharedPreferenceChanged value = " + QZoneVipInfoManager.a(this.a) + " personlizedYellowVipUrl = " + QZoneVipInfoManager.a(this.a));
      }
    }
    QZoneVipInfoManager.a(this.a, false);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yld.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */