import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qqhotspot.WifiConversationManager;
import cooperation.qqhotspot.WifiConversationManager.FocusApInfo;

public class ldw
  implements Runnable
{
  public ldw(Conversation paramConversation)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (!WifiConversationManager.a())
    {
      WifiConversationManager.FocusApInfo localFocusApInfo = WifiConversationManager.a().a();
      if ((localFocusApInfo != null) && (localFocusApInfo.a != null) && (localFocusApInfo.c == 1))
      {
        this.a.a.a(3, 2);
        this.a.a.a(3, null);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ldw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */