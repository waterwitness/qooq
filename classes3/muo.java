import android.os.Handler;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DBUtils;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class muo
  implements Runnable
{
  public muo(TroopMemberListActivity paramTroopMemberListActivity, FriendsManager paramFriendsManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject1 = DBUtils.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.k, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.L);
    TroopMemberCardInfo localTroopMemberCardInfo = DBUtils.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.k, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.L);
    if ((localTroopMemberCardInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.J == 6)) {}
    synchronized (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.L, localTroopMemberCardInfo);
      if ((localObject1 != null) && (this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager != null)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.L);
      }
    }
    synchronized (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_JavaUtilList)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.a((TroopMemberInfo)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager);
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_JavaUtilList.add(localObject1);
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(9);
      return;
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\muo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */