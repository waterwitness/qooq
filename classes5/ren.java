import com.tencent.mobileqq.dating.DatingTopListActivity;
import com.tencent.mobileqq.dating.GodListConfig;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.XListView;
import java.util.List;

public class ren
  implements Runnable
{
  public ren(DatingTopListActivity paramDatingTopListActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    List localList = DatingTopListActivity.a(this.a, this.a.g);
    DatingTopListActivity.a(this.a).a(localList);
    DatingTopListActivity.a(this.a).notifyDataSetChanged();
    if (DatingTopListActivity.d(this.a))
    {
      DatingTopListActivity.a(this.a).setSelection(0);
      DatingTopListActivity.d(this.a, false);
      if (localList == null) {
        break label150;
      }
      DatingTopListActivity.a(this.a).b(true);
      if (!DatingTopListActivity.a(this.a).hasMore) {
        break label137;
      }
      DatingTopListActivity.a(this.a).b();
    }
    for (;;)
    {
      this.a.b("0X8005275");
      return;
      DatingTopListActivity.a(this.a).setSelection(DatingTopListActivity.a(this.a).visiblePos);
      break;
      label137:
      DatingTopListActivity.a(this.a).c();
    }
    label150:
    DatingTopListActivity.a(this.a).b(false);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ren.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */