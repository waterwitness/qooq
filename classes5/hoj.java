import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import com.tencent.biz.pubaccount.MultiVideoPlayActivity;
import com.tencent.biz.pubaccount.VideoPlayMgr;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.immersive.ImmersiveUtils;

public class hoj
  implements Animation.AnimationListener
{
  public hoj(MultiVideoPlayActivity paramMultiVideoPlayActivity, View paramView, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    MultiVideoPlayActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountMultiVideoPlayActivity, false);
    if ((this.jdField_a_of_type_Boolean) && (ImmersiveUtils.isSupporImmersive() == 1) && (!this.jdField_a_of_type_ComTencentBizPubaccountMultiVideoPlayActivity.a.e)) {
      this.jdField_a_of_type_ComTencentBizPubaccountMultiVideoPlayActivity.getWindow().setFlags(1024, 1024);
    }
    if (MultiVideoPlayActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountMultiVideoPlayActivity))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      paramAnimation = new TranslateAnimation(0, 0.0F, 0, 0.0F, 1, -1.0F, 1, 0.0F);
      paramAnimation.setDuration(600L);
      this.jdField_a_of_type_AndroidViewView.startAnimation(paramAnimation);
      if ((this.jdField_a_of_type_Boolean) && (ImmersiveUtils.isSupporImmersive() == 1) && (!this.jdField_a_of_type_ComTencentBizPubaccountMultiVideoPlayActivity.a.e)) {
        this.jdField_a_of_type_ComTencentBizPubaccountMultiVideoPlayActivity.getWindow().clearFlags(1024);
      }
    }
    MultiVideoPlayActivity.b(this.jdField_a_of_type_ComTencentBizPubaccountMultiVideoPlayActivity, false);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hoj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */