import android.view.animation.Animation;
import com.tencent.common.galleryactivity.AbstractAnimationManager;
import com.tencent.common.galleryactivity.AbstractGalleryScene;
import com.tencent.common.galleryactivity.GalleryManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.util.AnimateUtils.AnimationAdapter;

public class jks
  extends AnimateUtils.AnimationAdapter
{
  public jks(AbstractGalleryScene paramAbstractGalleryScene)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.a.a().e();
    this.a.a.a().a();
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.a.a.a().d();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\jks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */