import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;

public class mme
  implements Runnable
{
  public mme(SplashActivity paramSplashActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    boolean bool = SettingCloneUtil.readValue(this.a.app.a(), this.a.app.getAccount(), null, "pcactive_notice_key", false);
    if ((!SettingCloneUtil.readValue(this.a.app.a(), this.a.app.getAccount(), null, "pcactive_has_notice", false)) && (bool))
    {
      SettingCloneUtil.writeValue(this.a.app.a(), this.a.app.getAccount(), null, "pcactive_has_notice", true);
      Intent localIntent = new Intent("mqq.intent.action.NOTICE_ON_PCACTIVE");
      localIntent.addFlags(268435456);
      localIntent.putExtra("uin", this.a.app.getAccount());
      BaseApplicationImpl.a().startActivity(localIntent);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\mme.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */