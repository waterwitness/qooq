import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.dating.DatingDestinationActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;

public class rdk
  implements Runnable
{
  public rdk(DatingDestinationActivity paramDatingDestinationActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (!TextUtils.isEmpty(this.a.i))
    {
      this.a.jdField_a_of_type_AndroidViewView.setVisibility(0);
      if (!this.a.i.equals(this.a.jdField_a_of_type_Rds.a)) {
        this.a.jdField_a_of_type_Rds.a(this.a.i);
      }
      if (!this.a.g)
      {
        this.a.g = true;
        this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a("CliOper", "", "", "0X8004F30", "0X8004F30", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rdk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */