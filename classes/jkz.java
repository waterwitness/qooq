import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import com.tencent.common.galleryactivity.AbstractGalleryScene;
import com.tencent.common.galleryactivity.GalleryPageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class jkz
  implements Animation.AnimationListener
{
  public jkz(GalleryPageView paramGalleryPageView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.jdField_a_of_type_AndroidWidgetTextView.clearAnimation();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (!this.a.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractGalleryScene.d()) {
      this.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\jkz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */