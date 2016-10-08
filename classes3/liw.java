import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.FontSettingActivity;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class liw
  implements View.OnClickListener
{
  public liw(FontSettingActivity paramFontSettingActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (FontSettingManager.a(this.a, FontSettingActivity.a(this.a), true)) {
      FontSettingManager.a();
    }
    this.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\liw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */