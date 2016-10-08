import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.facetoface.Face2FaceFriendBubbleView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class rmz
  implements Animation.AnimationListener
{
  public static final int a = 0;
  public static final int b = 1;
  private View jdField_a_of_type_AndroidViewView;
  private int c;
  
  public rmz(Face2FaceFriendBubbleView paramFace2FaceFriendBubbleView, int paramInt, View paramView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.c = 0;
    this.c = paramInt;
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {}
    do
    {
      return;
      if (this.c == 0)
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        return;
      }
    } while (this.c != 1);
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\rmz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */