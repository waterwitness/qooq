import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.VideoPlayParam;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class hzw
  implements Runnable
{
  hzw(hzu paramhzu)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((VideoPlayManager.a(this.a.a) != null) && (VideoPlayManager.a(this.a.a).jdField_a_of_type_AndroidWidgetRelativeLayout != null))
    {
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      localAlphaAnimation.setDuration(800L);
      localAlphaAnimation.setFillEnabled(true);
      localAlphaAnimation.setFillAfter(true);
      localAlphaAnimation.setAnimationListener(new hzx(this));
      VideoPlayManager.a(this.a.a).jdField_a_of_type_AndroidWidgetRelativeLayout.startAnimation(localAlphaAnimation);
    }
    if ((VideoPlayManager.a(this.a.a) != null) && (VideoPlayManager.a(this.a.a).jdField_a_of_type_AndroidViewView != null))
    {
      VideoPlayManager.a(this.a.a).jdField_a_of_type_AndroidViewView.setBackgroundColor(VideoPlayManager.a(this.a.a).getResources().getColor(2131427409));
      this.a.a.d();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hzw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */