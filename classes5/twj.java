import android.os.Build.VERSION;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;
import com.tencent.qphone.base.util.QLog;

public class twj
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public twj(ProfileHeaderView paramProfileHeaderView, View paramView1, View paramView2, ProfileCardInfo paramProfileCardInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onGlobalLayout()
  {
    int i = this.jdField_a_of_type_AndroidViewView.getWidth() - AIOUtils.a(45.0F, this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.getResources());
    int j = this.b.getWidth();
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "updateJueban widthLike = " + i + ", widthJueban = " + j);
    }
    if ((i != 0) && (j != 0))
    {
      localObject = (RelativeLayout.LayoutParams)this.b.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).rightMargin -= (j - i) / 2;
      this.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    Object localObject = new DataTag(34, null);
    this.b.setTag(localObject);
    this.b.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a);
    this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(true);
    this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(ProfileHeaderView.f, ProfileHeaderView.b);
    if (Build.VERSION.SDK_INT < 16)
    {
      this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\twj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */