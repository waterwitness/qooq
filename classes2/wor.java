import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.TabBarView;

public class wor
  implements View.OnClickListener
{
  public wor(TabBarView paramTabBarView, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a < 500L) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a = l;
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(this.jdField_a_of_type_Int, true);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */