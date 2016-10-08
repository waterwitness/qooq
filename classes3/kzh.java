import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.util.Utils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class kzh
  implements Runnable
{
  public kzh(ChatSettingForTroop paramChatSettingForTroop)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) || (this.a.jdField_a_of_type_AndroidOsHandler == null)) {
      return;
    }
    for (;;)
    {
      Object localObject3;
      try
      {
        localObject3 = this.a.app.a().createEntityManager();
        if (localObject3 == null) {
          break label194;
        }
        Object localObject1 = ((EntityManager)localObject3).a(TroopMemberInfo.class, false, "troopuin=? ", new String[] { this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin }, null, null, null, null);
        ((EntityManager)localObject3).a();
        if (localObject1 == null) {
          break label191;
        }
        localObject3 = new ArrayList(((List)localObject1).size());
        localObject1 = ((List)localObject1).iterator();
        if (((Iterator)localObject1).hasNext())
        {
          TroopMemberInfo localTroopMemberInfo = (TroopMemberInfo)((Iterator)localObject1).next();
          if (!Utils.c(localTroopMemberInfo.memberuin)) {
            continue;
          }
          ((ArrayList)localObject3).add(localTroopMemberInfo.memberuin);
          continue;
        }
        if (this.a.jdField_a_of_type_AndroidOsHandler == null) {
          break label191;
        }
      }
      finally {}
      Message localMessage = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage();
      localMessage.what = 13;
      localMessage.obj = localObject3;
      this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
      label191:
      return;
      label194:
      localMessage = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kzh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */