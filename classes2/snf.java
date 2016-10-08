import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.app.NearbyHandler;
import com.tencent.mobileqq.fragment.MineFragment;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;

public class snf
  implements OverScrollViewListener
{
  public snf(MineFragment paramMineFragment)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.c(0L);
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(this.a.b);
    if (this.a.d) {}
    do
    {
      return true;
      if (NetworkUtil.e(this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity))
      {
        paramView = (NearbyHandler)this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(3);
        if (paramView != null)
        {
          paramView.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a());
          this.a.d = true;
        }
      }
    } while (this.a.d);
    paramView = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, 0, 0);
    this.a.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramView, 1000L);
    return true;
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.b(this.a.b);
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\snf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */