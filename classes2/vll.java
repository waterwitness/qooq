import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.activity.NearbyTroopsView.UIHandler;
import com.tencent.mobileqq.troop.data.NearbyTroopsExpandableListViewAdapter;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

public class vll
  implements AbsListView.OnScrollListener
{
  public vll(NearbyTroopsExpandableListViewAdapter paramNearbyTroopsExpandableListViewAdapter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramAbsListView.t() == paramAbsListView.d_() - 1) && (!this.a.d) && (this.a.c))
    {
      this.a.d = true;
      this.a.notifyDataSetChanged();
      if (this.a.a != null) {
        this.a.a.sendEmptyMessage(1);
      }
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vll.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */