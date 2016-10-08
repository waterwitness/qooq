import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopTipsMsgMgr;
import java.util.Iterator;
import java.util.List;

public class oed
  implements Runnable
{
  public oed(TroopChatPie paramTroopChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    TroopManager localTroopManager = (TroopManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    Object localObject = localTroopManager.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    long l;
    TroopMemberInfo localTroopMemberInfo;
    if (localObject != null)
    {
      l = NetConnInfoCenter.getServerTime();
      localObject = ((List)localObject).iterator();
      l += 2592000L;
      if (((Iterator)localObject).hasNext())
      {
        localTroopMemberInfo = (TroopMemberInfo)((Iterator)localObject).next();
        if ((localTroopMemberInfo.mUniqueTitleExpire > 0) && (localTroopMemberInfo.mUniqueTitleExpire - NetConnInfoCenter.getServerTime() < 259200L) && (!localTroopManager.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, localTroopMemberInfo.memberuin)))
        {
          ((TroopTipsMsgMgr)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(80)).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, this.a.a(localTroopMemberInfo), NetConnInfoCenter.getServerTime(), localTroopMemberInfo.mUniqueTitleExpire, 0);
          localTroopManager.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, localTroopMemberInfo.memberuin, true);
          ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_manage", "", "grp_aio", "exp_expire", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "", "", "");
        }
      }
    }
    for (;;)
    {
      break;
      if ((localTroopMemberInfo.mUniqueTitleExpire != 0) && (localTroopMemberInfo.mUniqueTitleExpire != -1) && (localTroopMemberInfo.mUniqueTitleExpire < l))
      {
        l = localTroopMemberInfo.mUniqueTitleExpire;
        continue;
        localTroopManager.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, l);
        return;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */