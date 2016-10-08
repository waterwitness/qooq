import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendAnim;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class rmr
  implements Animation.AnimationListener
{
  public rmr(Face2FaceAddFriendAnim paramFace2FaceAddFriendAnim)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    ((Face2FaceAddFriendActivity)this.a.jdField_a_of_type_AndroidContentContext).i();
    this.a.jdField_a_of_type_AndroidViewAnimationRotateAnimation = null;
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\rmr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */