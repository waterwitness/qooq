import android.os.Handler;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class oeb
  implements Runnable
{
  public oeb(TroopChatPie paramTroopChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    TroopManager localTroopManager = (TroopManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    if ((localTroopManager != null) && (localTroopManager.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a) != null)) {
      this.a.b.sendEmptyMessage(7);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oeb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */