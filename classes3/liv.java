import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.FontSettingActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class liv
  implements View.OnClickListener
{
  public liv(FontSettingActivity paramFontSettingActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    FontSettingActivity.a(this.a).dismiss();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\liv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */