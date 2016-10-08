import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.activity.recent.RecentT9SearchActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class oxx
  implements View.OnClickListener
{
  public oxx(RecentT9SearchActivity paramRecentT9SearchActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    RecentT9SearchActivity.a(this.a).setCursorVisible(true);
    RecentT9SearchActivity.a(this.a, paramView);
    this.a.b();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\oxx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */