import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.dating.DatingDestinationActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class rdo
  implements View.OnClickListener
{
  public rdo(DatingDestinationActivity paramDatingDestinationActivity, Dialog paramDialog)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_AndroidAppDialog.cancel();
    this.jdField_a_of_type_ComTencentMobileqqDatingDatingDestinationActivity.a = null;
    this.jdField_a_of_type_ComTencentMobileqqDatingDatingDestinationActivity.d();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rdo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */