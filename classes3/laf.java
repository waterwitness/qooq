import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class laf
  implements Runnable
{
  public laf(ChatSettingForTroop paramChatSettingForTroop)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.app != null) {
      ((TroopManager)this.a.app.getManager(51)).b(this.a.a);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\laf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */