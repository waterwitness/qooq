import android.view.View;
import android.widget.ListAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.HorizontalListView;

public class xto
  extends xtv
  implements Runnable
{
  private xto(HorizontalListView paramHorizontalListView)
  {
    super(paramHorizontalListView, null);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    boolean bool2 = false;
    boolean bool1;
    if (this.a.b()) {
      bool1 = ((View)this.a.getParent()).performLongClick();
    }
    while (bool1)
    {
      this.a.y = -1;
      HorizontalListView.a(this.a);
      return;
      int i = HorizontalListView.b(this.a);
      View localView = this.a.getChildAt(i - this.a.getFirstVisiblePosition());
      bool1 = bool2;
      if (localView != null)
      {
        i = HorizontalListView.b(this.a);
        long l = this.a.a.getItemId(HorizontalListView.b(this.a));
        bool1 = bool2;
        if (a())
        {
          bool1 = bool2;
          if (!HorizontalListView.a(this.a)) {
            bool1 = this.a.a(localView, i, l);
          }
        }
      }
    }
    this.a.y = 2;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */