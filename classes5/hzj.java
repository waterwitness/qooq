import com.tencent.biz.pubaccount.readinjoy.model.SubscriptionInfoModule;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hzj
  implements Runnable
{
  public hzj(SubscriptionInfoModule paramSubscriptionInfoModule)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    TroopBarAssistantManager localTroopBarAssistantManager = TroopBarAssistantManager.a();
    SubscriptionInfoModule.a(this.a, localTroopBarAssistantManager.b((QQAppInterface)this.a.a));
    this.a.a(SubscriptionInfoModule.a(this.a));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hzj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */