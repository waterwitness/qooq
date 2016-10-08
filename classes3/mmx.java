import android.view.View;
import com.tencent.mobileqq.activity.SubAccountMessageActivity;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;

public class mmx
  implements OverScrollViewListener
{
  public mmx(SubAccountMessageActivity paramSubAccountMessageActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    if (SubAccountMessageActivity.c(this.a))
    {
      SubAccountMessageActivity.a(this.a).a();
      return;
    }
    SubAccountMessageActivity.a(this.a).c(0L);
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    if (SubAccountMessageActivity.c(this.a)) {
      return true;
    }
    SubAccountMessageActivity.a(this.a).a(0L);
    SubAccountMessageActivity.c(this.a, true);
    SubAccountMessageActivity.a(this.a, SubAccountMessageActivity.a(this.a).subuin, false);
    return true;
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    if (SubAccountMessageActivity.c(this.a)) {
      return;
    }
    SubAccountMessageActivity.a(this.a).b(0L);
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mmx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */