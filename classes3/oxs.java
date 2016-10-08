import com.tencent.mobileqq.activity.recent.RecentOptPopBar;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import com.tencent.widget.PopupMenuDialog.OnClickActionListener;

public class oxs
  implements PopupMenuDialog.OnClickActionListener
{
  public oxs(RecentOptPopBar paramRecentOptPopBar)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(PopupMenuDialog.MenuItem paramMenuItem)
  {
    switch (paramMenuItem.a)
    {
    default: 
      return;
    case 0: 
      this.a.h();
      return;
    case 1: 
      this.a.e();
      return;
    case 2: 
      this.a.c();
      return;
    case 3: 
      this.a.f();
      return;
    }
    this.a.a(8);
    this.a.a("KEY_CHARGE_REDTOUCH", false);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\oxs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */