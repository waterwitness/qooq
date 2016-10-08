import com.tencent.mobileqq.app.PPCLoginAuthHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;

public class qbt
  implements Runnable
{
  public qbt(PPCLoginAuthHandler paramPPCLoginAuthHandler)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    EntityManager localEntityManager = this.a.a.a(this.a.a.a()).createEntityManager();
    ExtensionInfo localExtensionInfo = (ExtensionInfo)localEntityManager.a(ExtensionInfo.class, this.a.a.getAccount());
    if (localExtensionInfo != null)
    {
      localExtensionInfo.commingRingId = 0L;
      localEntityManager.a(localExtensionInfo);
    }
    for (;;)
    {
      localEntityManager.a();
      return;
      localExtensionInfo = new ExtensionInfo();
      localExtensionInfo.uin = this.a.a.getAccount();
      localEntityManager.a(localExtensionInfo);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qbt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */