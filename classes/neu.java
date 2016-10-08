import android.view.View;
import android.view.animation.Animation;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.anim.ComboAnimation3;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.util.AnimateUtils.AnimationAdapter;

public class neu
  extends AnimateUtils.AnimationAdapter
{
  public neu(ComboAnimation3 paramComboAnimation3)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((ComboAnimation3.a(this.a) != null) && (ComboAnimation3.a(this.a).isShown())) {
      this.a.a.post(new nev(this));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\neu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */