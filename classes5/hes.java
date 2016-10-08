import com.tencent.biz.PoiMapActivity;
import com.tencent.biz.PoiMapActivity.ShopListAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

public class hes
  implements AbsListView.OnScrollListener
{
  public hes(PoiMapActivity paramPoiMapActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (paramAbsListView.t() == paramAbsListView.d_() - 1) && (this.a.a.a)) {
      this.a.a.a();
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */