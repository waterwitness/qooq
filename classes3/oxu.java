import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatActivityUtils.StartVideoListener;
import com.tencent.mobileqq.activity.recent.RecentT9SearchActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.t9search.T9KeyBoard;
import com.tencent.mobileqq.utils.SharedPreUtils;

public class oxu
  implements ChatActivityUtils.StartVideoListener
{
  public oxu(RecentT9SearchActivity paramRecentT9SearchActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a() {}
  
  public void b() {}
  
  public void c()
  {
    RecentT9SearchActivity.a(this.a).a();
    if (!TextUtils.isEmpty(RecentT9SearchActivity.a(this.a))) {
      SharedPreUtils.c(this.a, this.a.app.a(), RecentT9SearchActivity.a(this.a));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\oxu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */