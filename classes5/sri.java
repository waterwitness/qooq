import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.freshnews.FreshNewsManager;
import com.tencent.mobileqq.freshnews.MyFreshNewsFragment;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;

public class sri
  implements OverScrollViewListener
{
  public sri(MyFreshNewsFragment paramMyFreshNewsFragment)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    MyFreshNewsFragment.a(this.a).c(MyFreshNewsFragment.a(this.a));
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    MyFreshNewsFragment.a(this.a).a(MyFreshNewsFragment.a(this.a));
    if (NetworkUtil.e(this.a.getActivity())) {
      if (MyFreshNewsFragment.a(this.a).d()) {
        this.a.a(null);
      }
    }
    for (;;)
    {
      return true;
      paramView = MyFreshNewsFragment.a(this.a).obtainMessage(10, 0, 0);
      MyFreshNewsFragment.a(this.a).sendMessageDelayed(paramView, 1000L);
    }
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    MyFreshNewsFragment.a(this.a).b(MyFreshNewsFragment.a(this.a));
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sri.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */