import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.facetoface.Face2FaceDetailBaseView;
import com.tencent.mobileqq.facetoface.Face2FaceDetailBaseView.IFace2faceContext;
import com.tencent.mobileqq.facetoface.Face2FaceFriendBubbleView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class rmw
  implements Animation.AnimationListener
{
  public rmw(Face2FaceDetailBaseView paramFace2FaceDetailBaseView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.setVisibility(4);
    this.a.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendBubbleView.b();
    this.a.c.setBackgroundDrawable(null);
    this.a.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceDetailBaseView$IFace2faceContext.d();
    if (QLog.isColorLevel()) {
      QLog.d("Face2FaceDetailBaseView", 2, "animHide, onAnimationEnd " + hashCode());
    }
    Face2FaceDetailBaseView.a(this.a, true);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Face2FaceDetailBaseView", 2, "animHide, onAnimationStart " + hashCode());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\rmw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */