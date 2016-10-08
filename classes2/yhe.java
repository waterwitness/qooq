import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqhotspot.WifiConversationManager;
import mqq.os.MqqHandler;

public class yhe
  implements Runnable
{
  public yhe(WifiConversationManager paramWifiConversationManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.a().a();
    RecentUserProxy localRecentUserProxy = ((QQAppInterface)localObject).a().a();
    RecentUser localRecentUser = localRecentUserProxy.a(AppConstants.aV, 9505);
    if (localRecentUser != null)
    {
      localRecentUserProxy.b(localRecentUser);
      localObject = ((QQAppInterface)localObject).a(Conversation.class);
      if (localObject != null) {
        ((MqqHandler)localObject).sendEmptyMessage(1009);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i(this.a.a, 2, "removeQQHotSpotConversation()");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yhe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */