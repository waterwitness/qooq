import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mobileqq.activity.recent.RecentT9SearchActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class oxy
  implements View.OnFocusChangeListener
{
  public oxy(RecentT9SearchActivity paramRecentT9SearchActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    RecentT9SearchActivity.a(this.a, paramView);
    if (paramBoolean) {
      this.a.b();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\oxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */