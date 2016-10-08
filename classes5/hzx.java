import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.VideoPlayParam;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class hzx
  implements Animation.AnimationListener
{
  hzx(hzw paramhzw)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((VideoPlayManager.a(this.a.a.a) == null) || (VideoPlayManager.a(this.a.a.a).a == null)) {
      return;
    }
    VideoPlayManager.a(this.a.a.a).a.setVisibility(4);
    VideoPlayManager.a(this.a.a.a).a.clearAnimation();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hzx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */