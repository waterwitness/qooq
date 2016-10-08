import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.HorizontalListView;

public final class xtp
  implements Runnable
{
  public xtp(HorizontalListView paramHorizontalListView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    View localView;
    int i;
    if (this.a.y == 0)
    {
      this.a.y = 1;
      if (!this.a.b()) {
        break label169;
      }
      localView = (View)this.a.getParent();
      if ((this.a.b()) || ((localView != null) && (!localView.hasFocusable())))
      {
        if ((HorizontalListView.a(this.a)) && (!this.a.b())) {
          break label215;
        }
        HorizontalListView.a(this.a, localView);
        i = ViewConfiguration.getLongPressTimeout();
        if (!this.a.b()) {
          break label195;
        }
      }
    }
    label169:
    label195:
    for (boolean bool = localView.isLongClickable();; bool = this.a.isLongClickable())
    {
      if (!bool) {
        break label206;
      }
      if (HorizontalListView.a(this.a) == null) {
        HorizontalListView.a(this.a, new xto(this.a, null));
      }
      HorizontalListView.a(this.a).a();
      this.a.postDelayed(HorizontalListView.a(this.a), i);
      return;
      localView = this.a.getChildAt(HorizontalListView.b(this.a) - this.a.getFirstVisiblePosition());
      break;
    }
    label206:
    this.a.y = 2;
    return;
    label215:
    this.a.y = 2;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xtp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */