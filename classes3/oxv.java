import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.recent.RecentT9SearchActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.t9search.T9SearchResultAdapter.ViewHolder;

public class oxv
  implements View.OnClickListener
{
  public oxv(RecentT9SearchActivity paramRecentT9SearchActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof T9SearchResultAdapter.ViewHolder))
    {
      paramView = ((T9SearchResultAdapter.ViewHolder)paramView.getTag()).a;
      RecentT9SearchActivity.a(this.a, paramView);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\oxv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */