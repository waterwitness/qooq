import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import com.tencent.mobileqq.businessCard.views.BusinessCardViewScroller;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qxh
  extends AnimatorListenerAdapter
{
  public qxh(BusinessCardViewScroller paramBusinessCardViewScroller, Runnable paramRunnable)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_JavaLangRunnable.run();
    }
    this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller.a.removeAllListeners();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\qxh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */