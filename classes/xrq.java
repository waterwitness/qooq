import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AdapterView.AdapterDataSetObserver;
import com.tencent.widget.FastScroller;

public class xrq
  extends AdapterView.AdapterDataSetObserver
{
  public xrq(AbsListView paramAbsListView)
  {
    super(paramAbsListView);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onChanged()
  {
    super.onChanged();
    if (this.a.a != null) {
      this.a.a.c();
    }
  }
  
  public void onInvalidated()
  {
    super.onInvalidated();
    if (this.a.a != null) {
      this.a.a.c();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\xrq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */