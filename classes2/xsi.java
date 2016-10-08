import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ActionSheet;

public class xsi
  implements Runnable
{
  public xsi(ActionSheet paramActionSheet)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ActionSheet.a(this.a, new TranslateAnimation(0.0F, 0.0F, 0.0F, ActionSheet.a(this.a).getLeft()));
    ActionSheet.a(this.a).setInterpolator(AnimationUtils.loadInterpolator(ActionSheet.a(this.a), 17432582));
    ActionSheet.a(this.a).setDuration(200L);
    ActionSheet.a(this.a).setFillAfter(true);
    ActionSheet.a(this.a).startAnimation(ActionSheet.a(this.a));
    ActionSheet.a(this.a).setAnimationListener(new xsj(this));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xsi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */