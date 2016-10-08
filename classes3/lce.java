import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.portal.PortalManager;

public class lce
  implements View.OnClickListener
{
  public lce(Conversation paramConversation)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    Conversation.a(this.a).removeView(Conversation.a(this.a));
    paramView = (PortalManager)this.a.a.getManager(78);
    if (paramView != null) {
      paramView.a(this.a.a(), false);
    }
    Conversation.a(this.a, null);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */