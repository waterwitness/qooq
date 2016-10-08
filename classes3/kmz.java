import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.ProfileCardUtil;

public class kmz
  implements View.OnClickListener
{
  public kmz(BaseChatPie paramBaseChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.dismissDialog(230);
    ProfileCardUtil.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, null, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 1101);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kmz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */