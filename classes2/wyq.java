import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.qidian.QidianProfileCardActivity;

public class wyq
  implements View.OnClickListener
{
  public wyq(QidianProfileCardActivity paramQidianProfileCardActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    ProfileCardUtil.a(this.a, this.a.jdField_a_of_type_AndroidWidgetImageView, this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.a);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wyq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */