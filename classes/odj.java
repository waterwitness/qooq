import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.data.TroopMessageManager;
import com.tencent.mobileqq.utils.NetworkUtil;

public class odj
  implements Runnable
{
  public odj(TroopChatPie paramTroopChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    TroopInfo localTroopInfo = ((TroopManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    int i = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    TroopMessageManager localTroopMessageManager = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    int j = NetworkUtil.a(BaseApplicationImpl.getContext());
    if (((i == 1) || (i == 4) || ((i == -1) && (localTroopMessageManager.d > 0))) && (localTroopMessageManager.jdField_a_of_type_Boolean) && (localTroopInfo != null) && (localTroopInfo.wMemberNum < localTroopMessageManager.c) && ((j == 4) || (j == 1))) {
      localTroopMessageManager.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, Math.min(this.a.ee, localTroopMessageManager.jdField_a_of_type_Int));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\odj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */