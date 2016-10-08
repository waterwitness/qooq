import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.utils.TroopGagMgr.SelfGagInfo;

public class ocz
  implements Runnable
{
  public ocz(TroopChatPie paramTroopChatPie, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    TroopGagMgr.SelfGagInfo localSelfGagInfo = ((TroopGagMgr)this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, this.jdField_a_of_type_Boolean);
    Message localMessage = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.b.obtainMessage(2);
    localMessage.obj = localSelfGagInfo;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.b.sendMessage(localMessage);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ocz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */