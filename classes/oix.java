import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListView;
import com.tencent.mobileqq.adapter.SystemMsgListAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.SwipListView;

public class oix
  extends Handler
{
  public oix(SystemMsgListView paramSystemMsgListView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 1013: 
    default: 
    case 1012: 
    case 1014: 
    case 1015: 
      do
      {
        do
        {
          do
          {
            return;
          } while (SystemMsgListView.a(this.a) == null);
          this.a.i();
          SystemMsgListView.a(this.a).notifyDataSetChanged();
          return;
        } while (SystemMsgListView.a(this.a).m() <= 0);
        SystemMsgListView.a(this.a).a(SystemMsgListView.a(this.a));
        return;
      } while (SystemMsgListView.a(this.a) == null);
      SystemMsgListView.a(this.a).a(SystemMsgListView.a(this.a));
      SystemMsgListView.a(this.a).setVisibility(0);
      return;
    }
    paramMessage = SystemMsgListView.a(this.a).getResources().getString(2131367432);
    QQToast.a(SystemMsgListView.a(this.a), 1, paramMessage, 0).b(this.a.a());
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oix.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */