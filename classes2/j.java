import android.view.View;
import com.dataline.activities.DLRouterActivity;
import com.dataline.util.RouterSessionAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RouterHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.XListView;

public class j
  implements OverScrollViewListener
{
  public j(DLRouterActivity paramDLRouterActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, View paramView, ListView paramListView) {}
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    paramView = (RouterHandler)this.a.app.a(48);
    paramInt = paramView.a(this.a.b, 10);
    if (paramInt > 0)
    {
      paramView.a.b();
      this.a.a.setSelectionFromBottom(paramInt, 0);
      paramView.a.notifyDataSetChanged();
    }
    return false;
  }
  
  public void b(int paramInt, View paramView, ListView paramListView) {}
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */