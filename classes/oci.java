import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.TroopGiftManager;

public class oci
  implements Runnable
{
  public oci(TroopChatPie paramTroopChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    TroopGiftManager localTroopGiftManager = (TroopGiftManager)this.a.a.getManager(112);
    if (localTroopGiftManager != null) {
      localTroopGiftManager.f();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oci.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */