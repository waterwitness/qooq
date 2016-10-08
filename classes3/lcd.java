import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.portal.PortalManager;

public class lcd
  implements View.OnTouchListener
{
  public lcd(Conversation paramConversation)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      Conversation.a(this.a).removeView(Conversation.a(this.a));
      paramView = (PortalManager)this.a.a.getManager(78);
      if (paramView != null) {
        paramView.a(this.a.a(), true);
      }
      Conversation.a(this.a, null);
    }
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lcd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */