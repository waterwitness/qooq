import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.View;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.ThemeUtil.ThemeInfo;
import java.util.HashMap;

public class luq
  implements Runnable
{
  public luq(MainFragment paramMainFragment)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.getActivity() == null) {
      return;
    }
    MainFragment.a(this.a, PreferenceManager.getDefaultSharedPreferences(MainFragment.a(this.a).a()));
    if (MainFragment.a(this.a).getBoolean("theme_voice_setting_" + MainFragment.a(this.a).a(), true))
    {
      Object localObject = ThemeUtil.getUserCurrentThemeId(MainFragment.a(this.a));
      localObject = ThemeUtil.getThemeInfo(this.a.getActivity(), (String)localObject);
      if ((localObject == null) || (!((ThemeUtil.ThemeInfo)localObject).status.equals("5")) || (!((ThemeUtil.ThemeInfo)localObject).isVoiceTheme)) {}
    }
    for (boolean bool = false;; bool = true)
    {
      if (MainFragment.a(this.a) != null)
      {
        if (MainFragment.a(this.a).get("消息") != null) {
          ((View)MainFragment.a(this.a).get("消息")).setSoundEffectsEnabled(bool);
        }
        if (MainFragment.a(this.a).get("联系人") != null) {
          ((View)MainFragment.a(this.a).get("联系人")).setSoundEffectsEnabled(bool);
        }
        if (MainFragment.a(this.a).get("动态") != null) {
          ((View)MainFragment.a(this.a).get("动态")).setSoundEffectsEnabled(bool);
        }
        if (MainFragment.a(this.a).get("电话") != null) {
          ((View)MainFragment.a(this.a).get("电话")).setSoundEffectsEnabled(bool);
        }
        if (MainFragment.a(this.a).get("NOW") != null) {
          ((View)MainFragment.a(this.a).get("NOW")).setSoundEffectsEnabled(bool);
        }
      }
      if (MultiMsgManager.a().a()) {
        break;
      }
      MultiMsgManager.a().a(MainFragment.a(this.a));
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\luq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */