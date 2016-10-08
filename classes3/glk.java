import android.graphics.Bitmap;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.av.random.ui.RandomDoubleActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class glk
  implements Animation.AnimationListener
{
  public glk(RandomDoubleActivity paramRandomDoubleActivity, ImageView paramImageView, Bitmap paramBitmap, float paramFloat1, float paramFloat2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
    this.jdField_a_of_type_AndroidWidgetImageView.post(new gll(this));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\glk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */