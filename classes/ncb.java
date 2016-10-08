import android.widget.ImageButton;
import com.tencent.mobileqq.activity.activateFriend.SendBirthdayWishesActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ncb
  implements Runnable
{
  public ncb(SendBirthdayWishesActivity paramSendBirthdayWishesActivity, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Int == 2)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendSendBirthdayWishesActivity.a.setImageResource(2130837574);
      this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendSendBirthdayWishesActivity.a.setContentDescription("键盘");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendSendBirthdayWishesActivity.a.setImageResource(2130842146);
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendSendBirthdayWishesActivity.a.setContentDescription("表情功能面板");
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ncb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */