import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.qqstory.pgc.QQStoryDiscoverActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ikq
  implements Animation.AnimationListener
{
  public ikq(QQStoryDiscoverActivity paramQQStoryDiscoverActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.a.c != null)
    {
      this.a.c.setVisibility(8);
      this.a.c.setClickable(false);
      this.a.c.setOnClickListener(null);
    }
    try
    {
      ((ViewGroup)this.a.c.getParent()).removeView(this.a.c);
      this.a.e = false;
      return;
    }
    catch (Exception paramAnimation)
    {
      for (;;) {}
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ikq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */