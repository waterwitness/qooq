import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.util.WeakReference;

public class qdq
  implements Runnable
{
  private final WeakReference a;
  private final WeakReference b;
  
  public qdq(QQAppInterface paramQQAppInterface, PublicAccountDataManager paramPublicAccountDataManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new WeakReference(paramQQAppInterface);
    this.b = new WeakReference(paramPublicAccountDataManager);
  }
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.get();
    PublicAccountDataManager localPublicAccountDataManager = (PublicAccountDataManager)this.b.get();
    if ((localQQAppInterface != null) && (localPublicAccountDataManager != null))
    {
      TroopBarAssistantManager.a().a(localQQAppInterface, localPublicAccountDataManager.a());
      ServiceAccountFolderManager.a().c(localQQAppInterface);
      TroopBarAssistantManager.a().i(localQQAppInterface);
      ReadInJoyLogicEngine.a().g();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qdq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */