import android.os.AsyncTask;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.FriendProfileImageActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lmp
  implements Animation.AnimationListener
{
  public lmp(FriendProfileImageActivity paramFriendProfileImageActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.a.execute(new Void[0]);
    this.a.f = false;
    if (this.a.d) {
      FriendProfileImageActivity.a(this.a).setVisibility(8);
    }
    while (this.a.c) {
      return;
    }
    FriendProfileImageActivity.a(this.a).setVisibility(0);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lmp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */