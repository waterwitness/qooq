import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.pubaccount.VideoUIController;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class htn
  implements Animation.AnimationListener
{
  public htn(VideoUIController paramVideoUIController, ViewGroup paramViewGroup, View paramView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((!this.jdField_a_of_type_ComTencentBizPubaccountVideoUIController.c) && (!this.jdField_a_of_type_ComTencentBizPubaccountVideoUIController.b))
    {
      this.jdField_a_of_type_AndroidViewViewGroup.clearAnimation();
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("Q.pubaccount.video.VideoUIController", 2, "changeUIControllerVisibility() onAnimationEnd() mIsShowingErrorView=" + this.jdField_a_of_type_ComTencentBizPubaccountVideoUIController.c + ", mIsShowingEndingView=" + this.jdField_a_of_type_ComTencentBizPubaccountVideoUIController.b);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\htn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */