import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.SettingUncommUsedContactsActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class mky
  implements CompoundButton.OnCheckedChangeListener
{
  public mky(SettingUncommUsedContactsActivity paramSettingUncommUsedContactsActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = true;
    if (((paramCompoundButton == this.a.a.a()) || (paramCompoundButton == this.a.b.a())) && (!NetworkUtil.e(this.a.getActivity())))
    {
      this.a.a(2131371901, 1);
      SettingUncommUsedContactsActivity localSettingUncommUsedContactsActivity = this.a;
      if (!paramBoolean)
      {
        paramBoolean = bool;
        SettingUncommUsedContactsActivity.a(localSettingUncommUsedContactsActivity, paramCompoundButton, paramBoolean);
      }
    }
    do
    {
      return;
      paramBoolean = false;
      break;
      if (paramCompoundButton == this.a.a.a())
      {
        this.a.app.e(paramBoolean, true);
        return;
      }
    } while (paramCompoundButton != this.a.b.a());
    this.a.app.f(paramBoolean, true);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mky.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */