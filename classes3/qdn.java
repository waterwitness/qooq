import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qdn
  implements Runnable
{
  public qdn(PublicAccountHandler paramPublicAccountHandler)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    EcShopAssistantManager localEcShopAssistantManager = (EcShopAssistantManager)this.a.b.getManager(87);
    if (localEcShopAssistantManager != null) {
      localEcShopAssistantManager.a(null, "FollowList");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qdn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */