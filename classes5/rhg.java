import android.database.DataSetObserver;
import com.tencent.mobileqq.emosm.view.DragSortListView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class rhg
  extends DataSetObserver
{
  public rhg(DragSortListView paramDragSortListView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private void a()
  {
    if (this.a.j == 4) {
      this.a.a();
    }
  }
  
  public void onChanged()
  {
    a();
  }
  
  public void onInvalidated()
  {
    a();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rhg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */