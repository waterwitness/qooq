import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.immersive.ImmersiveTitleBar2;

public class lau
  implements AbsListView.OnScrollListener
{
  protected int a;
  
  public lau(ChatSettingForTroop paramChatSettingForTroop)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private int a(AbsListView paramAbsListView)
  {
    int i = 0;
    View localView = paramAbsListView.getChildAt(0);
    if (localView == null) {
      return 0;
    }
    int j = paramAbsListView.s();
    int k = localView.getTop();
    if (j >= 1) {
      i = paramAbsListView.getHeight();
    }
    k = -k;
    return i + (localView.getHeight() * j + k);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt) {}
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = a(paramAbsListView);
    Object localObject = null;
    if ((paramInt1 > this.jdField_a_of_type_Int) && (paramInt1 >= this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.au) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0))
    {
      paramAbsListView = this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_AndroidViewAnimationAlphaAnimation;
      if ((paramAbsListView != null) && (paramAbsListView != this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_AndroidWidgetRelativeLayout.getAnimation()))
      {
        paramAbsListView.reset();
        this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_AndroidWidgetRelativeLayout.startAnimation(paramAbsListView);
        this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.startAnimation(paramAbsListView);
        if (paramAbsListView != this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_AndroidViewAnimationAlphaAnimation) {
          break label186;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130838587);
        this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130843454);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = paramInt1;
      return;
      paramAbsListView = (AbsListView)localObject;
      if (paramInt1 >= this.jdField_a_of_type_Int) {
        break;
      }
      paramAbsListView = (AbsListView)localObject;
      if (paramInt1 > this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.au) {
        break;
      }
      paramAbsListView = (AbsListView)localObject;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0) {
        break;
      }
      paramAbsListView = this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_b_of_type_AndroidViewAnimationAlphaAnimation;
      break;
      label186:
      if (paramAbsListView == this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_b_of_type_AndroidViewAnimationAlphaAnimation)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130840081);
        this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130840080);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lau.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */