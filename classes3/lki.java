import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lki
  implements View.OnClickListener
{
  public lki(FriendProfileCardActivity paramFriendProfileCardActivity, SharedPreferences paramSharedPreferences)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("svip_profile_show_newer_guide_flag", true).commit();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lki.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */