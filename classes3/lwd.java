import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.fragment.NearbyBaseFragment;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class lwd
  implements ViewPager.OnPageChangeListener
{
  public lwd(NearbyActivity paramNearbyActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    if (QLog.isColorLevel()) {
      NearbyUtils.a("onPageSelected", new Object[] { Integer.valueOf(this.a.jdField_b_of_type_Int), Integer.valueOf(this.a.f), Integer.valueOf(paramInt) });
    }
    Object localObject = this.a;
    int i = ((Integer)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).intValue();
    ((NearbyActivity)localObject).jdField_b_of_type_Int = i;
    NearbyBaseFragment.l = i;
    if ((this.a.jdField_b_of_type_Long == 0L) && (this.a.jdField_b_of_type_Int == 2))
    {
      this.a.jdField_b_of_type_Long = System.currentTimeMillis();
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("WebSpeedTrace", "mClickTime", new Object[] { "onPageSelected", Long.valueOf(this.a.jdField_b_of_type_Long) });
      }
    }
    if (this.a.f != paramInt) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(paramInt, true);
    }
    localObject = this.a.b(paramInt);
    if (localObject != null) {
      ((NearbyBaseFragment)localObject).c();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lwd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */