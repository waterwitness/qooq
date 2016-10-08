import android.database.DataSetObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.PagerBaseAdapterWrapper;

public class xuf
  extends DataSetObserver
{
  public xuf(PagerBaseAdapterWrapper paramPagerBaseAdapterWrapper)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onChanged()
  {
    this.a.notifyDataSetChanged();
  }
  
  public void onInvalidated()
  {
    this.a.notifyDataSetInvalidated();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xuf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */