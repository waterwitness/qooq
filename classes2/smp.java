import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.fragment.FreshNewsFragment;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;

public class smp
  implements View.OnClickListener
{
  public smp(FreshNewsFragment paramFreshNewsFragment)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsTopicTopicInfo = null;
    this.a.h();
    this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.c("CliOper", "", "", "0X800577E", "0X800577E", 0, 0, "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\smp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */