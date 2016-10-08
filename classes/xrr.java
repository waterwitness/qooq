import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.AbsListView;

public class xrr
  extends xsc
  implements Runnable
{
  private xrr(AbsListView paramAbsListView)
  {
    super(paramAbsListView, null);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    View localView;
    if ((this.a.isPressed()) && (this.a.aF >= 0))
    {
      int i = this.a.aF;
      int j = this.a.au;
      localView = this.a.getChildAt(i - j);
      if (this.a.r) {
        break label107;
      }
      if (!a()) {
        break label125;
      }
    }
    label107:
    label125:
    for (boolean bool = this.a.b(localView, this.a.aF, this.a.e);; bool = false)
    {
      if (bool)
      {
        this.a.setPressed(false);
        localView.setPressed(false);
      }
      do
      {
        return;
        this.a.setPressed(false);
      } while (localView == null);
      localView.setPressed(false);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\xrr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */