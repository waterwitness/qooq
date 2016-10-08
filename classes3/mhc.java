import com.tencent.mobileqq.activity.QQSettingSettingActivity;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class mhc
  extends ConfigObserver
{
  public mhc(QQSettingSettingActivity paramQQSettingSettingActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, UpgradeDetailWrapper paramUpgradeDetailWrapper)
  {
    QQSettingSettingActivity.a(this.a, paramUpgradeDetailWrapper);
    QQSettingSettingActivity.b(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mhc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */