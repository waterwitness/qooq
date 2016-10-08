import android.os.Bundle;
import com.tencent.mobileqq.activity.QQSettingSettingActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.observer.GameCenterObserver;

public class mgw
  extends GameCenterObserver
{
  public mgw(QQSettingSettingActivity paramQQSettingSettingActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    QQSettingSettingActivity.a(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mgw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */