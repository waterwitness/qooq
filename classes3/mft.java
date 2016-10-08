import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.theme.NightModeLogic.NightModeCallback;
import com.tencent.qphone.base.util.QLog;

public class mft
  extends NightModeLogic.NightModeCallback
{
  public mft(QQSettingMe paramQQSettingMe)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(Bundle paramBundle)
  {
    this.a.n();
  }
  
  public void b(Bundle paramBundle)
  {
    int i = paramBundle.getInt("start_status");
    if (i == 1) {
      this.a.n();
    }
    do
    {
      return;
      if (i == 2)
      {
        this.a.n();
        return;
      }
    } while (i != 3);
    if ((this.a.b.getDrawable() instanceof Animatable)) {}
    for (;;)
    {
      i = paramBundle.getInt("percent");
      paramBundle = this.a.a.getString(2131370944);
      paramBundle = paramBundle + "  " + String.valueOf(i) + "%";
      this.a.c.setText(paramBundle);
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.d("QQSettingRedesign", 4, "NIGHTMODE_ACTION_DOWNLOADING: " + i);
      return;
      Drawable localDrawable = this.a.a.getResources().getDrawable(2130841273);
      this.a.b.setImageDrawable(localDrawable);
      if ((localDrawable instanceof Animatable)) {
        ((Animatable)localDrawable).start();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mft.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */