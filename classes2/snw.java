import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.fragment.NearbyFragment;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;

public class snw
  implements View.OnClickListener
{
  public snw(NearbyFragment paramNearbyFragment)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if ((this.a.jdField_a_of_type_AndroidAppDialog != null) && (!this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.isFinishing()))
    {
      this.a.jdField_a_of_type_AndroidAppDialog.dismiss();
      this.a.jdField_a_of_type_AndroidAppDialog = null;
      paramView = new ProfileActivity.AllInOne(this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(), 0);
      Intent localIntent = new Intent(this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, NearbyPeopleProfileActivity.class);
      localIntent.putExtra("param_mode", 1);
      localIntent.putExtra("AllInOne", paramView);
      localIntent.putExtra("frome_where", -2);
      this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.startActivity(localIntent);
      NearbyFragment.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a());
      this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a("CliOper", "0X80059BA");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\snw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */