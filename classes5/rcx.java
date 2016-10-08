import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.dating.DatingBaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;

public class rcx
  implements View.OnClickListener
{
  public rcx(DatingBaseActivity paramDatingBaseActivity, NearbyAppInterface paramNearbyAppInterface, Activity paramActivity, int paramInt, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDatingDatingBaseActivity.a != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDatingDatingBaseActivity.a.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqDatingDatingBaseActivity.a = null;
    }
    DatingBaseActivity.b(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rcx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */