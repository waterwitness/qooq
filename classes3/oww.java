import android.content.SharedPreferences;
import com.tencent.mobileqq.activity.recent.LightTalkTipsData;
import com.tencent.mobileqq.activity.recent.RecentCallHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.jumplightalk.CallRedDotLightalkLis;
import com.tencent.mobileqq.troop.widget.RedDotRadioButton;
import com.tencent.mobileqq.utils.SharedPreUtils;

public class oww
  implements CallRedDotLightalkLis
{
  public oww(RecentCallHelper paramRecentCallHelper)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    int k = 0;
    if (this.a.a != null) {}
    for (int i = SharedPreUtils.a(this.a.a.a()).getInt("show_tab_lightalk_tips", 0);; i = 0)
    {
      int j = k;
      if (i >= 0)
      {
        j = k;
        if (i < 3)
        {
          j = k;
          if (LightTalkTipsData.a() != null) {
            j = 1;
          }
        }
      }
      this.a.i = (j | this.a.i);
      if (RecentCallHelper.a(this.a) != null) {
        RecentCallHelper.a(this.a).a(this.a.i);
      }
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\oww.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */