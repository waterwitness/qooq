import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.SoundAndVibrateActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class mlx
  implements CompoundButton.OnCheckedChangeListener
{
  public mlx(SoundAndVibrateActivity paramSoundAndVibrateActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i = 1;
    if (paramBoolean)
    {
      this.a.b.setVisibility(0);
      SoundAndVibrateActivity.d(this.a).setBackgroundResource(2130838357);
      if (this.a.app.c() == 0)
      {
        this.a.b.setChecked(false);
        this.a.app.f(1);
        label64:
        paramCompoundButton = this.a.app;
        if (!paramBoolean) {
          break label153;
        }
      }
    }
    for (;;)
    {
      ReportController.b(paramCompoundButton, "CliOper", "", "", "Setting_tab", "Clk_notice_shake", 0, i, "", "", "", "");
      return;
      this.a.b.setChecked(true);
      break;
      this.a.b.setVisibility(8);
      SoundAndVibrateActivity.d(this.a).setBackgroundResource(2130838349);
      this.a.app.f(0);
      break label64;
      label153:
      i = 0;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mlx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */