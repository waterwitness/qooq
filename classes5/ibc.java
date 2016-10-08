import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

class ibc
  implements Animator.AnimatorListener
{
  ibc(ibb paramibb)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyBaseAdapter", 2, "view:" + this.a.a + " onAnimationCancel");
      }
      this.a.a.setLayerType(0, null);
      return;
    }
    catch (Exception paramAnimator)
    {
      paramAnimator.printStackTrace();
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyBaseAdapter", 2, "view:" + this.a.a + " onAnimationEnd");
      }
      this.a.a.setLayerType(0, null);
      return;
    }
    catch (Exception paramAnimator)
    {
      paramAnimator.printStackTrace();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyBaseAdapter", 2, "view:" + this.a.a + " onAnimationStart");
      }
      return;
    }
    catch (Exception paramAnimator)
    {
      paramAnimator.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ibc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */