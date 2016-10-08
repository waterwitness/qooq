import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class mfm
  extends ConfigObserver
{
  public mfm(QQSettingMe paramQQSettingMe)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, UpgradeDetailWrapper paramUpgradeDetailWrapper)
  {
    QQSettingMe.a(this.a, paramUpgradeDetailWrapper);
    if (this.a.b) {
      this.a.o();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mfm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */