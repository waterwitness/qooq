import android.widget.ImageView;
import com.tencent.mobileqq.dating.widget.CustomTabBarView;
import com.tencent.mobileqq.dating.widget.CustomTabBarView.OnTabChangeListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class rgn
  implements Runnable
{
  public rgn(CustomTabBarView paramCustomTabBarView, int paramInt, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (CustomTabBarView.a(this.jdField_a_of_type_ComTencentMobileqqDatingWidgetCustomTabBarView) != null) {
      CustomTabBarView.a(this.jdField_a_of_type_ComTencentMobileqqDatingWidgetCustomTabBarView).a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean);
    }
    this.jdField_a_of_type_ComTencentMobileqqDatingWidgetCustomTabBarView.a.clearAnimation();
    this.jdField_a_of_type_ComTencentMobileqqDatingWidgetCustomTabBarView.f = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqDatingWidgetCustomTabBarView.requestLayout();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rgn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */