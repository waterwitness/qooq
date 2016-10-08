import android.os.Build;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import com.tencent.av.random.ui.RandomDoubleActivity;
import com.tencent.av.utils.QQAnimationListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class glm
  extends QQAnimationListener
{
  public glm(RandomDoubleActivity paramRandomDoubleActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    this.a.h = false;
  }
  
  public void b() {}
  
  public void c() {}
  
  public void d()
  {
    this.a.h = true;
    if ("GT-I9100G".equals(Build.MODEL))
    {
      if (QLog.isColorLevel()) {
        QLog.d("RandomDoubleActivity", 2, "Model is 9100G, don't do animation");
      }
      return;
    }
    ImageView localImageView = (ImageView)this.a.findViewById(2131299060);
    if (QLog.isColorLevel()) {
      QLog.d("RandomDoubleActivity", 2, "setScreenDarken");
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(500L);
    localAlphaAnimation.setFillAfter(true);
    localImageView.setVisibility(0);
    localImageView.startAnimation(localAlphaAnimation);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\glm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */