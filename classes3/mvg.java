import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

class mvg
  implements Runnable
{
  mvg(mvb parammvb, List paramList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject1 = (TroopManager)this.jdField_a_of_type_Mvb.a.app.getManager(51);
    TroopInfo localTroopInfo = ((TroopManager)localObject1).a(this.jdField_a_of_type_Mvb.a.k);
    if (localTroopInfo == null) {}
    label68:
    label127:
    label201:
    do
    {
      do
      {
        return;
      } while (StringUtil.b(localTroopInfo.troopowneruin));
      localTroopInfo.Administrator = "";
      int i;
      int j;
      Object localObject2;
      if (this.jdField_a_of_type_JavaUtilList == null)
      {
        i = 0;
        j = 0;
        if (j >= i) {
          break label201;
        }
        localObject2 = (oidb_0x899.memberlist)this.jdField_a_of_type_JavaUtilList.get(j);
        if ((localObject2 != null) && (((oidb_0x899.memberlist)localObject2).uint64_member_uin.has())) {
          break label127;
        }
      }
      for (;;)
      {
        j += 1;
        break label68;
        i = this.jdField_a_of_type_JavaUtilList.size();
        break;
        localObject2 = String.valueOf(((oidb_0x899.memberlist)localObject2).uint64_member_uin.get());
        if ((localObject2 != null) && (!"".equals(((String)localObject2).trim())) && (!localTroopInfo.troopowneruin.equals(((String)localObject2).trim()))) {
          localTroopInfo.Administrator = (localTroopInfo.Administrator + (String)localObject2 + "|");
        }
      }
      ((TroopManager)localObject1).b(localTroopInfo);
      localObject1 = this.jdField_a_of_type_Mvb.a.a.obtainMessage();
      ((Message)localObject1).what = 11;
      ((Message)localObject1).obj = localTroopInfo;
      this.jdField_a_of_type_Mvb.a.a.sendMessage((Message)localObject1);
    } while (!QLog.isColorLevel());
    QLog.i("TroopMemberListActivityget_troop_member", 2, localTroopInfo.Administrator);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mvg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */