import MQQ.VipUserInfo;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.app.VipInfoObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class mfl
  extends VipInfoObserver
{
  public mfl(QQSettingMe paramQQSettingMe)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((paramInt == VipInfoHandler.a) && (paramBoolean))
    {
      paramObject = (VipUserInfo)paramObject;
      if (paramObject != null)
      {
        paramObject = ((VipUserInfo)paramObject).sUri;
        if (paramObject != null)
        {
          QQSettingMe.b(this.a, (String)paramObject);
          if (QLog.isColorLevel()) {
            QLog.d("QQSettingRedesign", 2, "vip url = " + (String)paramObject);
          }
          paramObject = this.a.a.getApplication().getSharedPreferences(this.a.a.a(), 4).edit().putString("VIPCenter_url_key", (String)paramObject);
          if (Build.VERSION.SDK_INT >= 9) {
            break label123;
          }
          ((SharedPreferences.Editor)paramObject).commit();
        }
      }
    }
    return;
    label123:
    ((SharedPreferences.Editor)paramObject).apply();
  }
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    if ((paramBoolean) && (paramInt >= 0) && (this.a.a != null))
    {
      Object localObject = this.a.a.getPreferences();
      if (localObject != null) {
        ((SharedPreferences)localObject).edit().putInt("key_selfvip_growthvalue", paramInt).commit();
      }
      localObject = this.a.a.a();
      this.a.b((String)localObject);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mfl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */