import android.view.View;
import android.view.animation.Animation;
import android.widget.TextView;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.PullToZoomListView;
import com.tencent.widget.immersive.ImmersiveTitleBar2;

public class lln
  implements AbsListView.OnScrollListener
{
  public lln(FriendProfileCardActivity paramFriendProfileCardActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (this.a.jdField_d_of_type_Int != paramInt) {
      this.a.jdField_d_of_type_Int = paramInt;
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    paramAbsListView = this.a.jdField_a_of_type_ComTencentWidgetPullToZoomListView.getChildAt(0);
    if ((paramAbsListView == null) || (paramInt1 != 0) || (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.a == 33) || (this.a.jdField_d_of_type_AndroidWidgetTextView == null)) {
      return;
    }
    paramInt1 = Math.abs(paramAbsListView.getTop());
    Object localObject = null;
    if ((paramInt1 > this.a.c) && (paramInt1 >= this.a.e) && (this.a.jdField_d_of_type_AndroidWidgetTextView.getVisibility() == 8)) {
      paramAbsListView = this.a.jdField_a_of_type_AndroidViewAnimationAlphaAnimation;
    }
    for (;;)
    {
      if ((paramAbsListView != null) && (paramAbsListView != this.a.jdField_d_of_type_AndroidWidgetTextView.getAnimation()))
      {
        paramAbsListView.reset();
        this.a.jdField_d_of_type_AndroidWidgetTextView.startAnimation(paramAbsListView);
        this.a.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.startAnimation(paramAbsListView);
      }
      this.a.c = paramInt1;
      return;
      paramAbsListView = (AbsListView)localObject;
      if (paramInt1 < this.a.c)
      {
        paramAbsListView = (AbsListView)localObject;
        if (paramInt1 <= this.a.e)
        {
          paramAbsListView = (AbsListView)localObject;
          if (this.a.jdField_d_of_type_AndroidWidgetTextView.getVisibility() == 0) {
            paramAbsListView = this.a.b;
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lln.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */