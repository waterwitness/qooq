import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.NearPeopleFilterActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.config.NearbyDataManager;
import com.tencent.mobileqq.fragment.NearbyFragment;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.widget.QQToast;

public class sod
  implements View.OnClickListener
{
  public sod(NearbyFragment paramNearbyFragment)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqConfigNearbyDataManager.a())
    {
      QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, 0, this.a.getString(2131371561), 0).b(this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getTitleBarHeight());
      return;
    }
    NearPeopleFilterActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, this.a, this.a.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters, 100);
    this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a("CliOper", "0X8004441");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\sod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */