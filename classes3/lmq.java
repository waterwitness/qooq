import android.content.res.Resources;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.FriendProfileImageActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lmq
  implements Runnable
{
  public lmq(FriendProfileImageActivity paramFriendProfileImageActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.f = false;
    if (!this.a.jdField_c_of_type_Boolean) {
      this.a.b.setVisibility(0);
    }
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, this.a.getResources().getDimension(2131493192), 0.0F);
    localTranslateAnimation.setDuration(300L);
    localTranslateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
    this.a.jdField_c_of_type_AndroidWidgetRelativeLayout.startAnimation(localTranslateAnimation);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lmq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */