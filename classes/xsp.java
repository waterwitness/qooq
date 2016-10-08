import android.database.DataSetObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.AdapterViewPagerAdapter;

public class xsp
  extends DataSetObserver
{
  public xsp(AdapterViewPagerAdapter paramAdapterViewPagerAdapter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onChanged()
  {
    this.a.notifyDataSetChanged();
  }
  
  public void onInvalidated()
  {
    super.onInvalidated();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\xsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */