import android.content.Intent;
import android.os.Handler;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class mub
  implements Runnable
{
  public mub(TroopMemberListActivity paramTroopMemberListActivity, Intent paramIntent, FriendsManager paramFriendsManager, TroopManager paramTroopManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    boolean bool2 = false;
    ??? = "";
    int i;
    if (this.jdField_a_of_type_AndroidContentIntent != null)
    {
      i = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("memberOperationFlag", 0);
      ??? = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("memberOperateUin");
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberListActivityget_troop_member", 2, "onActivityResult, REQUEST_CODE_SHOW_MEMBER_CARD, optFlg=" + i + ", optUin=" + (String)???);
      }
      if ((i & 0x1) != 0) {
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.a((String)???);
      }
      for (;;)
      {
        if (((i & 0x4) != 0) && (this.jdField_a_of_type_ComTencentMobileqqAppTroopManager != null))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.k);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopowneruin != null) {
              this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.n = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopowneruin;
            }
            if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.Administrator != null) {
              this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.o = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.Administrator;
            }
            ??? = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity;
            boolean bool1;
            if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopowneruin == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopowneruin.equals(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.app.a())))
            {
              bool1 = bool2;
              if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.o != null)
              {
                bool1 = bool2;
                if (!this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.o.contains(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.app.a())) {}
              }
            }
            else
            {
              bool1 = true;
            }
            ((TroopMemberListActivity)???).jdField_a_of_type_Boolean = bool1;
            if (QLog.isColorLevel()) {
              QLog.d("TroopMemberListActivityget_troop_member", 2, "onActivityResult, REQUEST_CODE_SHOW_MEMBER_CARD, admins:" + this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.o + " owner:" + this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.n);
            }
          }
        }
        if ((i != 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter != null)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(9);
        }
        return;
        if ((i & 0x2) != 0)
        {
          Object localObject3 = DBUtils.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.k, (String)???);
          TroopMemberCardInfo localTroopMemberCardInfo = DBUtils.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.k, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.L);
          if ((localTroopMemberCardInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.J == 6)) {}
          synchronized (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.L, localTroopMemberCardInfo);
            if ((localObject3 != null) && (this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager != null))
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.a((String)???);
              synchronized (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_JavaUtilList)
              {
                localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.a((TroopMemberInfo)localObject3, this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager);
                this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_JavaUtilList.add(localObject3);
              }
            }
          }
        }
      }
      i = 0;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */