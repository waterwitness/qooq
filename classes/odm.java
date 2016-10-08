import android.os.Message;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;
import mqq.os.MqqHandler;

public class odm
  implements Runnable
{
  public odm(TroopChatPie paramTroopChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = (TroopInfoManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
    if (localObject != null) {
      ((TroopInfoManager)localObject).a(Long.valueOf(Long.parseLong(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)), true).a();
    }
    TroopNotificationHelper.c(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    localObject = TroopChatPie.j(this.a).obtainMessage(29);
    ((Message)localObject).arg1 = 1;
    TroopChatPie.k(this.a).sendMessage((Message)localObject);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\odm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */