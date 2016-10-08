import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.OverScroller;

public class xtn
  implements Runnable
{
  public xtn(HorizontalListView paramHorizontalListView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.a.y != -1) || (HorizontalListView.a(this.a) != -1)) {}
    do
    {
      do
      {
        return;
      } while (!this.a.a.a());
      if (HorizontalListView.g) {
        this.a.a("mFlingRunnable", new Object[] { Integer.valueOf(this.a.y) });
      }
    } while (!this.a.a.a(this.a.getScrollX() + this.a.i, this.a.getScrollY(), this.a.i, this.a.i, 0, 0));
    this.a.y = 6;
    if (HorizontalListView.g) {
      this.a.a("mFlingRunnable", new Object[] { "TOUCH_MODE_OVERFLING" });
    }
    this.a.g(4099);
    this.a.invalidate();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xtn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */