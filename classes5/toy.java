import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel;
import com.tencent.widget.CustomImgView;

class toy
  implements Animation.AnimationListener
{
  toy(tos paramtos, PicInfo paramPicInfo, Drawable paramDrawable, CustomImgView paramCustomImgView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_Tos.a.jdField_a_of_type_ComTencentWidgetCustomImgView.post(new toz(this));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.jdField_a_of_type_Tos.a.jdField_a_of_type_ComTencentWidgetCustomImgView.setVisibility(4);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\toy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */