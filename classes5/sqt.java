import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.freshnews.FreshNewsManager;
import com.tencent.mobileqq.freshnews.FreshNewsNotifyFragment;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;

public class sqt
  implements OverScrollViewListener
{
  public sqt(FreshNewsNotifyFragment paramFreshNewsNotifyFragment)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    FreshNewsNotifyFragment.a(this.a).c(FreshNewsNotifyFragment.a(this.a));
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    FreshNewsNotifyFragment.a(this.a).a(FreshNewsNotifyFragment.a(this.a));
    if (NetworkUtil.e(this.a.getActivity())) {
      FreshNewsNotifyFragment.a(this.a, FreshNewsNotifyFragment.a(this.a).e, FreshNewsNotifyFragment.a(this.a).f);
    }
    for (;;)
    {
      return true;
      paramView = FreshNewsNotifyFragment.a(this.a).obtainMessage(10, 0, 0);
      FreshNewsNotifyFragment.a(this.a).sendMessageDelayed(paramView, 1000L);
    }
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    FreshNewsNotifyFragment.a(this.a).b(FreshNewsNotifyFragment.a(this.a));
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sqt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */