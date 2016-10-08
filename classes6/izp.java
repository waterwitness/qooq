import android.os.Handler;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.qqstory.view.AnimationPoint;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class izp
  implements Runnable
{
  public izp(AnimationPoint paramAnimationPoint)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.jdField_a_of_type_Boolean) {
      return;
    }
    if ((System.currentTimeMillis() - this.a.c < this.a.b) || (this.a.b < 0L)) {
      this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(this, 30L);
    }
    for (;;)
    {
      this.a.invalidate();
      return;
      if (this.a.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener != null) {
        this.a.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener.onAnimationEnd(null);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\izp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */