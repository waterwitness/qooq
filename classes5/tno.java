import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel;
import com.tencent.mobileqq.widget.BounceScrollView;

public class tno
  implements Runnable
{
  public tno(NearbyProfileEditPanel paramNearbyProfileEditPanel)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i = this.a.h.getTop();
    int j = (int)(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.a * 20.0F);
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.b(0, i - j);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tno.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */