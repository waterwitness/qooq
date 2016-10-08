import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.conditionsearch.SearchResultActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;

public class qzq
  implements OverScrollViewListener
{
  public qzq(SearchResultActivity paramSearchResultActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    SearchResultActivity.a(this.a).c(SearchResultActivity.a(this.a));
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    SearchResultActivity.a(this.a).a(SearchResultActivity.a(this.a));
    if (NetworkUtil.e(this.a)) {
      SearchResultActivity.c(this.a);
    }
    for (;;)
    {
      SearchResultActivity.a(this.a, System.currentTimeMillis());
      return true;
      SearchResultActivity.a(this.a).a(1);
      paramView = Message.obtain();
      paramView.what = 3;
      SearchResultActivity.a(this.a).sendMessageDelayed(paramView, 1000L);
    }
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    SearchResultActivity.a(this.a).b(SearchResultActivity.a(this.a));
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qzq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */