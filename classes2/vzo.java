import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SecSvcObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.AntiFraudConfigFileUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class vzo
  extends SecSvcObserver
{
  public vzo(AntiFraudConfigFileUtil paramAntiFraudConfigFileUtil)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void b(int paramInt, Bundle paramBundle)
  {
    Object localObject = (QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localObject != null) {
      ((QQAppInterface)localObject).b(AntiFraudConfigFileUtil.a(this.a));
    }
    if (paramInt != 1) {
      if (QLog.isColorLevel()) {
        QLog.d("SecSvcObserver", 2, "invalid notification type for onGetUinSafetyWordingConfig:" + Integer.toString(paramInt));
      }
    }
    while (paramBundle == null) {
      return;
    }
    String str = paramBundle.getString("config_name");
    localObject = str;
    if (!TextUtils.isEmpty(str))
    {
      localObject = str;
      if (TextUtils.equals("SenstiveMessageTipsCfg", str)) {
        localObject = "SensMsgTipsCfg";
      }
    }
    ThreadManager.a(new vzp(this, (String)localObject, paramBundle.getInt("effect_time", 0), paramBundle.getString("md5"), paramBundle.getString("download_url")), 5, null, false);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vzo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */