import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.SwipListView;

public class oja
  implements View.OnClickListener
{
  public oja(SystemMsgListView paramSystemMsgListView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == SystemMsgListView.a(this.a))
    {
      SystemMsgListView.a(this.a).a(SystemMsgListView.a(this.a));
      this.a.l();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oja.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */