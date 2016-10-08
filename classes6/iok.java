import android.graphics.Bitmap;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.playvideo.CustomViewPager;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class iok
  implements Animation.AnimationListener
{
  public iok(StoryPlayVideoActivity paramStoryPlayVideoActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.setResult(-1);
    this.a.finish();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(0);
    if (StoryPlayVideoActivity.a(this.a) != null)
    {
      this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramAnimation = (RelativeLayout.LayoutParams)this.a.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      paramAnimation.width = this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.getWidth();
      paramAnimation.height = (paramAnimation.width * StoryPlayVideoActivity.b(this.a).getHeight() / StoryPlayVideoActivity.c(this.a).getWidth());
      this.a.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramAnimation);
      this.a.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(StoryPlayVideoActivity.d(this.a));
    }
    paramAnimation = new AlphaAnimation(1.0F, 0.0F);
    paramAnimation.setFillAfter(true);
    paramAnimation.setDuration(300L);
    this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoCustomViewPager.startAnimation(paramAnimation);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iok.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */