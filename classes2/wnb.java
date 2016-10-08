import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.PaFlashLightView;

public class wnb
  implements Animation.AnimationListener
{
  public wnb(PaFlashLightView paramPaFlashLightView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.jdField_a_of_type_Boolean = true;
    switch (this.a.jdField_c_of_type_Int)
    {
    }
    for (;;)
    {
      this.a.jdField_c_of_type_Int = ((this.a.jdField_c_of_type_Int + 1) % 3);
      return;
      this.a.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      this.a.jdField_a_of_type_Wnc.sendEmptyMessageDelayed(0, 3250L);
      continue;
      this.a.b.setVisibility(8);
      this.a.jdField_a_of_type_Wnc.sendEmptyMessageDelayed(0, 1050L);
      continue;
      this.a.jdField_c_of_type_ComTencentImageURLImageView.setVisibility(8);
      this.a.jdField_a_of_type_Wnc.sendEmptyMessageDelayed(0, 3250L);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wnb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */