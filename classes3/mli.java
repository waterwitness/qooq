import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mobileqq.activity.SnapScreenActivity;
import com.tencent.mobileqq.app.ScreenShotDisableListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;

public class mli
  implements View.OnClickListener
{
  public mli(SnapScreenActivity paramSnapScreenActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    this.a.a();
    if ((this.a.a instanceof ScreenShotDisableListener)) {
      ((ScreenShotDisableListener)this.a.a).a();
    }
    SettingCloneUtil.writeValue(this.a.a, null, this.a.getString(2131367835), "qqsetting_screenshot_key", false);
    Toast.makeText(this.a.a, 2131368165, 1).show();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mli.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */