import android.app.Dialog;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import com.tencent.biz.qqstory.pgc.QQStoryDiscoverActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ikv
  implements Animation.AnimationListener
{
  public ikv(QQStoryDiscoverActivity paramQQStoryDiscoverActivity, TranslateAnimation paramTranslateAnimation1, View paramView, TranslateAnimation paramTranslateAnimation2, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPgcQQStoryDiscoverActivity.a.show();
      this.jdField_a_of_type_AndroidViewView.setAnimation(null);
      this.jdField_a_of_type_ComTencentBizQqstoryPgcQQStoryDiscoverActivity.b.setVisibility(8);
    }
    while (paramAnimation != this.b) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setAnimation(null);
    this.jdField_a_of_type_AndroidViewView.offsetTopAndBottom(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidViewView.requestLayout();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ikv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */