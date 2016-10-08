import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.av.widget.stageview.StageEffectView;
import com.tencent.av.widget.stageview.StageMemberView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hcp
  implements Animation.AnimationListener
{
  public hcp(StageEffectView paramStageEffectView, boolean paramBoolean, StageMemberView paramStageMemberView, Drawable paramDrawable, ImageView paramImageView, float paramFloat1, float paramFloat2)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvWidgetStageviewStageMemberView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    this.jdField_a_of_type_AndroidWidgetImageView.post(new hcq(this));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\hcp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */