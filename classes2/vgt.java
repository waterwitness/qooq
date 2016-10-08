import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;

public class vgt
  implements Animation.AnimationListener
{
  public vgt(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.i = false;
    paramAnimation.setAnimationListener(null);
    this.a.finish();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vgt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */