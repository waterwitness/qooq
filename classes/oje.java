import com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListView;
import com.tencent.mobileqq.adapter.SystemMsgListAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

public class oje
  implements AbsListView.OnScrollListener
{
  public oje(SystemMsgListView paramSystemMsgListView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if ((SystemMsgListView.a(this.a) != null) && (paramInt == 0) && (SystemMsgListView.a(this.a) == SystemMsgListView.a(this.a).getCount())) {
      SystemMsgListView.b(this.a);
    }
    if ((paramInt != 0) && (paramInt != 1))
    {
      SystemMsgListView.a(this.a).f();
      return;
    }
    SystemMsgListView.a(this.a).g();
    SystemMsgListView.a(this.a).e();
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    SystemMsgListView.a(this.a, paramInt1 + paramInt2 - 1);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oje.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */