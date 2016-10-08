import android.database.DataSetObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.XCursorAdapter;

public class xvs
  extends DataSetObserver
{
  private xvs(XCursorAdapter paramXCursorAdapter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onChanged()
  {
    this.a.a = true;
    this.a.notifyDataSetChanged();
  }
  
  public void onInvalidated()
  {
    this.a.a = false;
    this.a.notifyDataSetInvalidated();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xvs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */