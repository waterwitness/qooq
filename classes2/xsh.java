import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ActionSheet;

public class xsh
  implements Runnable
{
  public xsh(ActionSheet paramActionSheet)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ActionSheet.a(this.a, new TranslateAnimation(0.0F, 0.0F, ActionSheet.a(this.a).getLeft(), 0.0F));
    ActionSheet.a(this.a).setFillEnabled(true);
    try
    {
      ActionSheet.a(this.a).setInterpolator(AnimationUtils.loadInterpolator(ActionSheet.a(this.a), 17432582));
      ActionSheet.a(this.a).setDuration(ActionSheet.a(this.a));
      ActionSheet.a(this.a, true);
      ActionSheet.a(this.a).startAnimation(ActionSheet.a(this.a));
      return;
    }
    catch (NoSuchFieldError localNoSuchFieldError)
    {
      for (;;) {}
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xsh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */