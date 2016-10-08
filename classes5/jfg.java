import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.LayoutAnimationController;
import android.view.animation.LayoutAnimationController.AnimationParameters;
import com.tencent.biz.ui.CellLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class jfg
  extends LayoutAnimationController
{
  public jfg(CellLayout paramCellLayout, Animation paramAnimation)
  {
    super(paramAnimation);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected long getDelayForView(View paramView)
  {
    paramView = paramView.getLayoutParams().layoutAnimationParameters;
    if (paramView == null) {
      return 0L;
    }
    if (getAnimation() == this.a.a)
    {
      if (this.a.t == 1) {
        return paramView.index % this.a.r * 50;
      }
      switch (paramView.index / this.a.r)
      {
      case 0: 
      default: 
        return 0L;
      case 1: 
        return 30L;
      case 2: 
        return 60L;
      case 3: 
        return 80L;
      }
      return 80L;
    }
    if (this.a.t == 1) {
      return (this.a.r - paramView.index % this.a.r - 1) * 50;
    }
    return (this.a.s - paramView.index / this.a.r - 1) * 50;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */