import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.AbsListView;

public class xro
  implements Runnable
{
  public xro(AbsListView paramAbsListView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.g)
    {
      AbsListView localAbsListView = this.a;
      this.a.h = false;
      localAbsListView.g = false;
      AbsListView.a(this.a, false);
      if ((AbsListView.n(this.a) & 0x2) == 0) {
        AbsListView.b(this.a, false);
      }
      if (!this.a.isAlwaysDrawnWithCacheEnabled()) {
        this.a.invalidate();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\xro.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */