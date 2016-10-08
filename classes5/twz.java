import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.view.ProfileTagView;
import java.util.List;

public class twz
  implements Runnable
{
  public twz(ProfileTagView paramProfileTagView, ProfileCardInfo paramProfileCardInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    List localList = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.getLabelList();
    this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.a.runOnUiThread(new txa(this, localList));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\twz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */