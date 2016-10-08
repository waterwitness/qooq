import android.content.res.Resources;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.SoundAndVibrateActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.ThemeUtil.ThemeInfo;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class mlw
  implements CompoundButton.OnCheckedChangeListener
{
  public mlw(SoundAndVibrateActivity paramSoundAndVibrateActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int j = 1;
    int k = SettingCloneUtil.readValueForInt(this.a, this.a.app.a(), "sound_type", "qqsetting_notify_soundtype_key", SoundAndVibrateActivity.f);
    if (paramBoolean)
    {
      this.a.a.setClickable(true);
      this.a.a.setVisibility(0);
      SoundAndVibrateActivity.a(this.a).setVisibility(0);
      SoundAndVibrateActivity.a(this.a).setBackgroundResource(2130838357);
      paramCompoundButton = ThemeUtil.getUserCurrentThemeId(this.a.app);
      if (paramCompoundButton.equals("1000")) {
        break label1357;
      }
      paramCompoundButton = ThemeUtil.getThemeInfo(this.a, paramCompoundButton);
      if ((paramCompoundButton == null) || (!paramCompoundButton.isVoiceTheme)) {
        break label1357;
      }
    }
    label423:
    label445:
    label1252:
    label1352:
    label1357:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        SoundAndVibrateActivity.b(this.a).setBackgroundResource(2130838349);
        SoundAndVibrateActivity.b(this.a).setVisibility(0);
      }
      if (k == 2131165184)
      {
        SoundAndVibrateActivity.b(this.a).setRightIcon(this.a.getResources().getDrawable(2130843464));
        SoundAndVibrateActivity.c(this.a).setRightIcon(null);
        SoundAndVibrateActivity.d(this.a).setRightIcon(null);
        SoundAndVibrateActivity.e(this.a).setRightIcon(null);
        SoundAndVibrateActivity.a(this.a, 0);
        if (AppSetting.j)
        {
          SoundAndVibrateActivity.b(this.a).setContentDescription(this.a.getString(2131369451) + this.a.getString(2131371280));
          SoundAndVibrateActivity.c(this.a).setContentDescription(this.a.getString(2131369452) + this.a.getString(2131371281));
          SoundAndVibrateActivity.d(this.a).setContentDescription(this.a.getString(2131369453) + this.a.getString(2131371281));
          SoundAndVibrateActivity.e(this.a).setContentDescription(this.a.getString(2131369454) + this.a.getString(2131371281));
        }
        if (this.a.app.b() != 0) {
          break label1252;
        }
        this.a.a.setChecked(false);
        this.a.app.e(1);
        SoundAndVibrateActivity.c(this.a).setChecked(true);
        paramCompoundButton = this.a.app;
        if (!paramBoolean) {
          break label1352;
        }
      }
      for (i = j;; i = 0)
      {
        ReportController.b(paramCompoundButton, "CliOper", "", "", "Setting_tab", "Clk_notice_sound", 0, i, "", "", "", "");
        return;
        if (k == 2131165190)
        {
          SoundAndVibrateActivity.b(this.a).setRightIcon(null);
          SoundAndVibrateActivity.c(this.a).setRightIcon(this.a.getResources().getDrawable(2130843464));
          SoundAndVibrateActivity.d(this.a).setRightIcon(null);
          SoundAndVibrateActivity.e(this.a).setRightIcon(null);
          SoundAndVibrateActivity.a(this.a, 1);
          if (!AppSetting.j) {
            break;
          }
          SoundAndVibrateActivity.b(this.a).setContentDescription(this.a.getString(2131369451) + this.a.getString(2131371281));
          SoundAndVibrateActivity.c(this.a).setContentDescription(this.a.getString(2131369452) + this.a.getString(2131371280));
          SoundAndVibrateActivity.d(this.a).setContentDescription(this.a.getString(2131369453) + this.a.getString(2131371281));
          SoundAndVibrateActivity.e(this.a).setContentDescription(this.a.getString(2131369454) + this.a.getString(2131371281));
          break;
        }
        if (k == SoundAndVibrateActivity.e)
        {
          SoundAndVibrateActivity.b(this.a).setRightIcon(null);
          SoundAndVibrateActivity.c(this.a).setRightIcon(null);
          SoundAndVibrateActivity.d(this.a).setRightIcon(this.a.getResources().getDrawable(2130843464));
          SoundAndVibrateActivity.e(this.a).setRightIcon(null);
          SoundAndVibrateActivity.a(this.a, 2);
          if (!AppSetting.j) {
            break;
          }
          SoundAndVibrateActivity.b(this.a).setContentDescription(this.a.getString(2131369451) + this.a.getString(2131371281));
          SoundAndVibrateActivity.c(this.a).setContentDescription(this.a.getString(2131369452) + this.a.getString(2131371281));
          SoundAndVibrateActivity.d(this.a).setContentDescription(this.a.getString(2131369453) + this.a.getString(2131371280));
          SoundAndVibrateActivity.e(this.a).setContentDescription(this.a.getString(2131369454) + this.a.getString(2131371281));
          break;
        }
        if (k != SoundAndVibrateActivity.f) {
          break;
        }
        SoundAndVibrateActivity.b(this.a).setRightIcon(null);
        SoundAndVibrateActivity.c(this.a).setRightIcon(null);
        SoundAndVibrateActivity.d(this.a).setRightIcon(null);
        SoundAndVibrateActivity.e(this.a).setRightIcon(this.a.getResources().getDrawable(2130843464));
        SoundAndVibrateActivity.a(this.a, 3);
        if (!AppSetting.j) {
          break;
        }
        SoundAndVibrateActivity.b(this.a).setContentDescription(this.a.getString(2131369451) + this.a.getString(2131371281));
        SoundAndVibrateActivity.c(this.a).setContentDescription(this.a.getString(2131369452) + this.a.getString(2131371281));
        SoundAndVibrateActivity.d(this.a).setContentDescription(this.a.getString(2131369453) + this.a.getString(2131371281));
        SoundAndVibrateActivity.e(this.a).setContentDescription(this.a.getString(2131369454) + this.a.getString(2131371280));
        break;
        this.a.a.setChecked(true);
        break label423;
        SoundAndVibrateActivity.a(this.a).setBackgroundResource(2130838349);
        this.a.a.setVisibility(8);
        SoundAndVibrateActivity.a(this.a).setVisibility(8);
        SoundAndVibrateActivity.b(this.a).setVisibility(8);
        SoundAndVibrateActivity.b(this.a).setBackgroundResource(2130838349);
        SoundAndVibrateActivity.b(this.a).setVisibility(8);
        this.a.app.e(0);
        break label445;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mlw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */