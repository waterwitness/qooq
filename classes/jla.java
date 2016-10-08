import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import com.tencent.common.galleryactivity.GalleryPageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class jla
  implements Animation.AnimationListener
{
  public jla(GalleryPageView paramGalleryPageView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.a.clearAnimation();
    this.a.a.setVisibility(4);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\jla.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */