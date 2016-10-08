import com.tencent.mobileqq.activity.AboutActivity;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class kgl
  extends ConfigObserver
{
  public kgl(AboutActivity paramAboutActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, UpgradeDetailWrapper paramUpgradeDetailWrapper)
  {
    AboutActivity.a(this.a, paramUpgradeDetailWrapper);
    paramUpgradeDetailWrapper = this.a.app.a();
    AboutActivity.a(this.a, paramUpgradeDetailWrapper);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kgl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */