import android.database.DataSetObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.HorizontalListView;

public class xtq
  extends DataSetObserver
{
  public xtq(HorizontalListView paramHorizontalListView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onChanged()
  {
    HorizontalListView.a(this.a, true);
    HorizontalListView.b(this.a, false);
    HorizontalListView.a(this.a);
    this.a.invalidate();
    this.a.requestLayout();
  }
  
  public void onInvalidated()
  {
    HorizontalListView.b(this.a, false);
    HorizontalListView.a(this.a);
    HorizontalListView.b(this.a);
    this.a.invalidate();
    this.a.requestLayout();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xtq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */