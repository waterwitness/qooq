import android.view.View;
import com.tencent.biz.ui.IPullRefreshHeader;
import com.tencent.biz.ui.RefreshView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;

public class jgc
  implements OverScrollViewListener
{
  public jgc(RefreshView paramRefreshView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    if (this.a.g == 2)
    {
      this.a.a.a();
      return;
    }
    this.a.a.c(0L);
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    if (this.a.g != 2)
    {
      RefreshView.a(this.a, false);
      this.a.b(RefreshView.a(this.a));
      this.a.a.a(0L);
      this.a.g = 2;
      RefreshView.a(this.a);
    }
    return false;
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    if (this.a.g != 2) {
      this.a.a.b(0L);
    }
  }
  
  public void c(int paramInt, View paramView, ListView paramListView)
  {
    this.a.b();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jgc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */