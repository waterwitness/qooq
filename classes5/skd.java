import android.database.DataSetObserver;
import com.tencent.mobileqq.filemanager.widget.QfileHorizontalListView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class skd
  extends DataSetObserver
{
  public skd(QfileHorizontalListView paramQfileHorizontalListView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onChanged()
  {
    synchronized (this.a)
    {
      QfileHorizontalListView.a(this.a, true);
      this.a.invalidate();
      this.a.requestLayout();
      return;
    }
  }
  
  public void onInvalidated()
  {
    QfileHorizontalListView.a(this.a);
    this.a.invalidate();
    this.a.requestLayout();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\skd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */