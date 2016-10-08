import android.os.Handler;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.RecentCallHelper;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class lch
  extends FriendListObserver
{
  public lch(Conversation paramConversation)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "refresh recent, from_onupdaterecentlist");
    }
    this.a.a(0L);
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "onUpdateFriendInfo uin = " + paramString + ", isSc = " + paramBoolean);
    }
    if (!paramBoolean) {}
    while (Utils.a(paramString, this.a.a.getAccount())) {
      return;
    }
    this.a.a(0L);
    this.a.s();
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean == true)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "refresh recent, from_onupdatedelfriend");
      }
      this.a.a(0L);
      this.a.s();
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, " Conversation.onUpdateCustomHead: uin:" + paramString + ", success :" + paramBoolean);
    }
    if (!paramBoolean) {
      return;
    }
    if (!Utils.a(paramString, this.a.a.a()))
    {
      this.a.b(new lci(this, paramString));
      return;
    }
    Conversation.a(this.a).a.sendEmptyMessage(3);
  }
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
  {
    if (paramBoolean) {
      this.a.a(1009, 500L, true);
    }
  }
  
  protected void a(boolean paramBoolean, Map paramMap)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("onSetGenralSettingsTroopFilter: isSuc = ").append(paramBoolean).append(", size = ");
      if (paramMap != null) {
        break label64;
      }
    }
    label64:
    for (int i = 0;; i = paramMap.size())
    {
      QLog.d("Q.recent", 2, i);
      if ((paramMap != null) && (paramMap.size() != 0)) {
        break;
      }
      return;
    }
    Object localObject = (ProxyManager)this.a.a.getManager(17);
    label109:
    String str;
    if (localObject == null)
    {
      localObject = null;
      paramMap = paramMap.entrySet().iterator();
      if (!paramMap.hasNext()) {
        break label325;
      }
      str = (String)((Map.Entry)paramMap.next()).getKey();
      i = this.a.a.b(str);
      if (i != 2) {
        break label307;
      }
      TroopAssistantManager.a().a(str, this.a.a);
    }
    for (;;)
    {
      if ((i == 3) && (localObject != null)) {}
      try
      {
        RecentUser localRecentUser = ((RecentUserProxy)localObject).b(str, 1);
        if (localRecentUser != null)
        {
          ((RecentUserProxy)localObject).b(localRecentUser);
          RecentDataListManager.a().a(localRecentUser.uin + "-" + localRecentUser.type);
          ((RecentUserProxy)localObject).b(localRecentUser);
          RecentUtil.b(this.a.a, localRecentUser.uin, 1);
          this.a.a.a().c(localRecentUser.uin, localRecentUser.type);
        }
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
      this.a.a(9, str, 1);
      break label109;
      localObject = ((ProxyManager)localObject).a();
      break;
      label307:
      TroopAssistantManager.a().c(str, this.a.a);
    }
    label325:
    this.a.a(9, AppConstants.am, 5000);
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "refresh recent, from_onupdatefriendlist");
      }
      this.a.a(0L);
      this.a.s();
    }
  }
  
  protected void b(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      this.a.b(new lcj(this, paramString));
    }
  }
  
  protected void b(boolean paramBoolean, String[] paramArrayOfString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "onUpdateOnlineFriend| isSuc = " + paramBoolean);
    }
    if (paramBoolean) {
      this.a.a(0L);
    }
    if ((Conversation.a(this.a) != null) && (Conversation.a(this.a).c))
    {
      this.a.b(new lck(this, paramBoolean));
      return;
    }
    if ((paramBoolean) && (Conversation.a(this.a) != null)) {
      this.a.b(new lcl(this));
    }
    this.a.s();
  }
  
  protected void c(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject2 = null;
    Object localObject1 = (ProxyManager)this.a.a.getManager(17);
    if (localObject1 == null)
    {
      localObject1 = null;
      TroopAssistantManager.a().h(this.a.a);
      if (localObject1 != null) {
        break label176;
      }
    }
    for (;;)
    {
      if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
        break label186;
      }
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        RecentUser localRecentUser = (RecentUser)((Iterator)localObject2).next();
        if ((localRecentUser.type == 1) && (this.a.a.b(localRecentUser.uin) == 3))
        {
          if (localObject1 != null) {
            ((RecentUserProxy)localObject1).b(localRecentUser);
          }
          RecentUtil.b(this.a.a, localRecentUser.uin, 1);
          this.a.a.a().c(localRecentUser.uin, localRecentUser.type);
        }
      }
      localObject1 = ((ProxyManager)localObject1).a();
      break;
      label176:
      localObject2 = ((RecentUserProxy)localObject1).a(false);
    }
    label186:
    this.a.a(9, AppConstants.am, 5000);
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "refresh recent, from_onGetGenralSettings");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */