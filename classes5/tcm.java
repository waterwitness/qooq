import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.maproam.activity.VipMapRoamActivity;
import com.tencent.mobileqq.maproam.activity.VipMapRoamActivity.UiHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;

public class tcm
  implements OverScrollViewListener
{
  public tcm(VipMapRoamActivity paramVipMapRoamActivity)
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
    if (NetworkUtil.e(this.a.getApplication()))
    {
      this.a.a(true, true);
      return true;
    }
    paramView = this.a.jdField_a_of_type_ComTencentMobileqqMaproamActivityVipMapRoamActivity$UiHandler.obtainMessage(101, 200, 0);
    this.a.jdField_a_of_type_ComTencentMobileqqMaproamActivityVipMapRoamActivity$UiHandler.sendMessageDelayed(paramView, 1000L);
    return true;
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.b(this.a.b);
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tcm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */