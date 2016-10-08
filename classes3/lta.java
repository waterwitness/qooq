import android.graphics.Bitmap;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class lta
  implements Runnable
{
  lta(lsz paramlsz, Bitmap paramBitmap)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      this.jdField_a_of_type_Lsz.a.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
      this.jdField_a_of_type_Lsz.a.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setDuration(500L);
      this.jdField_a_of_type_Lsz.a.jdField_a_of_type_AndroidWidgetImageView.startAnimation(this.jdField_a_of_type_Lsz.a.jdField_a_of_type_AndroidViewAnimationAlphaAnimation);
      return;
    }
    this.jdField_a_of_type_Lsz.a.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838678);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lta.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */