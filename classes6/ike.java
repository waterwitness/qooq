import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.pgc.QQStoryContentActivity;
import com.tencent.biz.qqstory.pgc.view.ContentEmptyView;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.ref.SoftReference;

public class ike
  implements Animation.AnimationListener
{
  public ike(QQStoryContentActivity paramQQStoryContentActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = (QQStoryManager)this.a.app.getManager(180);
    View localView = (View)paramAnimation.a.get();
    if ((localView != null) && (localView.getVisibility() != 0))
    {
      localView.setVisibility(0);
      paramAnimation.a.clear();
    }
    this.a.setResult(-1);
    QQStoryContentActivity.a(this.a);
    QQStoryContentActivity.a(this.a, 0, 0);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.a.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundColor(0);
    paramAnimation = QQStoryContentActivity.a(this.a);
    FrameLayout.LayoutParams localLayoutParams;
    if (paramAnimation != null)
    {
      localLayoutParams = (FrameLayout.LayoutParams)this.a.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      localLayoutParams.width = this.a.jdField_a_of_type_AndroidWidgetFrameLayout.getWidth();
      localLayoutParams.height = (localLayoutParams.width * paramAnimation.getHeight() / paramAnimation.getWidth());
      this.a.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
      this.a.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramAnimation);
    }
    for (;;)
    {
      if (this.a.b.getVisibility() == 0)
      {
        paramAnimation = new AlphaAnimation(1.0F, 0.0F);
        paramAnimation.setFillAfter(true);
        paramAnimation.setDuration(300L);
        this.a.b.startAnimation(paramAnimation);
      }
      if ((this.a.jdField_a_of_type_ComTencentBizQqstoryPgcViewContentEmptyView != null) && (this.a.jdField_a_of_type_ComTencentBizQqstoryPgcViewContentEmptyView.getVisibility() == 0))
      {
        paramAnimation = new AlphaAnimation(1.0F, 0.0F);
        paramAnimation.setFillAfter(true);
        paramAnimation.setDuration(300L);
        this.a.jdField_a_of_type_ComTencentBizQqstoryPgcViewContentEmptyView.startAnimation(paramAnimation);
      }
      paramAnimation = new AlphaAnimation(1.0F, 0.0F);
      paramAnimation.setFillAfter(true);
      paramAnimation.setDuration(300L);
      this.a.jdField_a_of_type_AndroidSupportV4ViewViewPager.startAnimation(paramAnimation);
      return;
      paramAnimation = BitmapUtils.a((View)((QQStoryManager)this.a.app.getManager(180)).a.get());
      if (paramAnimation != null)
      {
        localLayoutParams = (FrameLayout.LayoutParams)this.a.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
        localLayoutParams.width = this.a.jdField_a_of_type_AndroidWidgetFrameLayout.getWidth();
        localLayoutParams.height = (localLayoutParams.width * paramAnimation.getHeight() / paramAnimation.getWidth());
        this.a.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
        this.a.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramAnimation);
      }
      else
      {
        this.a.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(new ColorDrawable(-16777216));
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ike.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */