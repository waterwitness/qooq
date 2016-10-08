import android.os.Handler;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

class ocr
  implements Runnable
{
  ocr(ocq paramocq, List paramList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_Ocq.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    TroopInfo localTroopInfo = localTroopManager.a(this.jdField_a_of_type_Ocq.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    if (localTroopInfo == null) {}
    while (StringUtil.b(localTroopInfo.troopowneruin)) {
      return;
    }
    localTroopInfo.Administrator = "";
    int i;
    int j;
    label71:
    Object localObject;
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      i = 0;
      j = 0;
      if (j >= i) {
        break label204;
      }
      localObject = (oidb_0x899.memberlist)this.jdField_a_of_type_JavaUtilList.get(j);
      if ((localObject != null) && (((oidb_0x899.memberlist)localObject).uint64_member_uin.has())) {
        break label130;
      }
    }
    for (;;)
    {
      j += 1;
      break label71;
      i = this.jdField_a_of_type_JavaUtilList.size();
      break;
      label130:
      localObject = String.valueOf(((oidb_0x899.memberlist)localObject).uint64_member_uin.get());
      if ((localObject != null) && (!"".equals(((String)localObject).trim())) && (!localTroopInfo.troopowneruin.equals(((String)localObject).trim()))) {
        localTroopInfo.Administrator = (localTroopInfo.Administrator + (String)localObject + "|");
      }
    }
    label204:
    localTroopManager.b(localTroopInfo);
    if (QLog.isColorLevel()) {
      QLog.i("Q.aio.TroopChatPie", 2, localTroopInfo.Administrator);
    }
    this.jdField_a_of_type_Ocq.a.b.removeMessages(1);
    this.jdField_a_of_type_Ocq.a.b.sendEmptyMessage(1);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ocr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */