import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.AbsListView;

public final class xrt
  implements Runnable
{
  public xrt(AbsListView paramAbsListView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject;
    int i;
    boolean bool;
    if (this.a.ag == 0)
    {
      this.a.ag = 1;
      localObject = this.a.getChildAt(this.a.ab - this.a.au);
      if ((localObject != null) && (!((View)localObject).hasFocusable()))
      {
        this.a.U = 0;
        if (this.a.r) {
          break label249;
        }
        ((View)localObject).setPressed(true);
        this.a.setPressed(true);
        this.a.v_();
        this.a.a(this.a.ab, (View)localObject);
        this.a.refreshDrawableState();
        i = ViewConfiguration.getLongPressTimeout();
        bool = this.a.isLongClickable();
        if (this.a.c != null)
        {
          localObject = this.a.c.getCurrent();
          if ((localObject != null) && ((localObject instanceof TransitionDrawable)))
          {
            if (!bool) {
              break label230;
            }
            ((TransitionDrawable)localObject).startTransition(i);
          }
        }
      }
    }
    while (bool)
    {
      if (AbsListView.a(this.a) == null) {
        AbsListView.a(this.a, new xrs(this.a, null));
      }
      AbsListView.a(this.a).a();
      this.a.postDelayed(AbsListView.a(this.a), i);
      return;
      label230:
      ((TransitionDrawable)localObject).resetTransition();
    }
    this.a.ag = 2;
    return;
    label249:
    this.a.ag = 2;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\xrt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */