import android.view.View;
import android.widget.ListAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.AbsListView;

public class xrs
  extends xsc
  implements Runnable
{
  private xrs(AbsListView paramAbsListView)
  {
    super(paramAbsListView, null);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i = this.a.ab;
    View localView = this.a.getChildAt(i - this.a.au);
    long l;
    if (localView != null)
    {
      i = this.a.ab;
      l = this.a.a.getItemId(this.a.ab);
      if ((!a()) || (this.a.r)) {
        break label122;
      }
    }
    label122:
    for (boolean bool = this.a.b(localView, i, l);; bool = false)
    {
      if (bool)
      {
        this.a.ag = -1;
        this.a.setPressed(false);
        localView.setPressed(false);
        return;
      }
      this.a.ag = 2;
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\xrs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */