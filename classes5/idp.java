import com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class idp
  implements Runnable
{
  public idp(SubscriptFeedsActivity paramSubscriptFeedsActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ((PublicAccountDataManager)this.a.app.getManager(55)).a();
    TroopBarAssistantManager.a().d(this.a.app);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\idp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */