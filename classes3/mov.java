import android.os.Bundle;
import com.tencent.mobileqq.activity.ThemeSwitchDlgActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.theme.NightModeLogic.NightModeCallback;

public class mov
  extends NightModeLogic.NightModeCallback
{
  public mov(ThemeSwitchDlgActivity paramThemeSwitchDlgActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(Bundle paramBundle)
  {
    this.a.finish();
  }
  
  public void b(Bundle paramBundle)
  {
    if (paramBundle.getInt("start_status") == 2) {}
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mov.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */