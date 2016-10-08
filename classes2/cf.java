import android.view.View;
import com.dataline.activities.PrinterActivity;
import com.dataline.util.PrinterSessionAdapter;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.PrinterHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.XListView;

public class cf
  implements OverScrollViewListener
{
  public cf(PrinterActivity paramPrinterActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, View paramView, ListView paramListView) {}
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    paramInt = PrinterActivity.a(this.a).a.a();
    if (paramInt > 0)
    {
      PrinterActivity.a(this.a).a.a.b();
      this.a.a.setSelectionFromBottom(paramInt, 0);
      PrinterActivity.a(this.a).a.a.notifyDataSetChanged();
    }
    return false;
  }
  
  public void b(int paramInt, View paramView, ListView paramListView) {}
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */