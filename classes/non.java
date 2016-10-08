import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.item.ShakeItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShakeWindow;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class non
  implements View.OnClickListener
{
  public non(ShakeItemBuilder paramShakeItemBuilder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.shakemsg", 2, "shake msg onClick() is called");
    }
    AIOUtils.l = true;
    if (ShakeItemBuilder.a(this.a)) {
      return;
    }
    if (SystemClock.uptimeMillis() - ShakeItemBuilder.a(this.a) < 3000L)
    {
      QLog.d("Q.msg.shakemsg", 2, "shake return cause:too much click in a very short time!");
      return;
    }
    paramView = (MessageForShakeWindow)AIOUtils.a(paramView);
    if (((this.a.jdField_a_of_type_AndroidContentContext instanceof ChatActivity)) || ((this.a.jdField_a_of_type_AndroidContentContext instanceof SplashActivity)))
    {
      FragmentActivity localFragmentActivity = (FragmentActivity)this.a.jdField_a_of_type_AndroidContentContext;
      ShakeItemBuilder.a(this.a, SystemClock.uptimeMillis());
      localFragmentActivity.getChatFragment().a().aj();
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramView.frienduin, false);
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramView.frienduin, false);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\non.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */