import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.Rotate3dAnimation;

class gll
  implements Runnable
{
  gll(glk paramglk)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Rotate3dAnimation localRotate3dAnimation = new Rotate3dAnimation(-90.0F, 0.0F, this.a.jdField_a_of_type_Float, this.a.b, 150.0F, false);
    localRotate3dAnimation.setDuration(500L);
    localRotate3dAnimation.setInterpolator(new DecelerateInterpolator());
    this.a.jdField_a_of_type_AndroidWidgetImageView.startAnimation(localRotate3dAnimation);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gll.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */