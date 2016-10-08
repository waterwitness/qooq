import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.fragment.NearbyFragment;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbyReportManager;
import com.tencent.mobileqq.nearby.NearbyUserBehaviorReport;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;

public class snr
  implements OverScrollViewListener
{
  public snr(NearbyFragment paramNearbyFragment)
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
    if (NetworkUtil.e(this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity))
    {
      this.a.c(true, true);
      paramView = (NearbyReportManager)this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(218);
      if (paramView != null)
      {
        paramView.a();
        paramView.a = false;
      }
    }
    for (;;)
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyUserBehaviorReport != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyUserBehaviorReport.b(10);
      }
      return true;
      paramView = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(3, 1, 0);
      this.a.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramView, 1000L);
    }
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.b(this.a.b);
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\snr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */