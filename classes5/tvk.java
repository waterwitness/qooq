import android.graphics.drawable.TransitionDrawable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.profile.VipProfileCardPreviewActivity;

public class tvk
  implements Runnable
{
  public tvk(VipProfileCardPreviewActivity paramVipProfileCardPreviewActivity, TransitionDrawable paramTransitionDrawable)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableTransitionDrawable.reverseTransition(1500);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tvk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */