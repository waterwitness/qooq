import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.freshnews.FreshNewsDetailActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;

public class soj
  implements OverScrollViewListener
{
  public soj(FreshNewsDetailActivity paramFreshNewsDetailActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.c(this.a.b);
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(this.a.b);
    if (NetworkUtil.e(this.a)) {
      this.a.h();
    }
    for (;;)
    {
      return true;
      paramView = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(0, 0, 0);
      this.a.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramView, 1000L);
    }
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.b(this.a.b);
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\soj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */