import android.text.TextUtils;
import com.tencent.mobileqq.activity.TroopTransferActivity;
import com.tencent.mobileqq.activity.TroopTransferActivity.TroopMemberItem;
import com.tencent.mobileqq.activity.TroopTransferActivity.TroopMemberListAdapter;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class myz
  implements Runnable
{
  public myz(TroopTransferActivity.TroopMemberListAdapter paramTroopMemberListAdapter, TroopTransferActivity paramTroopTransferActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int j = this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberListAdapter.jdField_a_of_type_JavaUtilArrayList.size();
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberListAdapter.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.app.getManager(51);
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberListAdapter.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.app.getManager(50);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < j)
    {
      TroopTransferActivity.TroopMemberItem localTroopMemberItem = (TroopTransferActivity.TroopMemberItem)this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberListAdapter.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (TextUtils.isEmpty(localTroopMemberItem.a)) {}
      for (;;)
      {
        i += 1;
        break;
        if (localFriendsManager == null)
        {
          localObject = null;
          label113:
          if ((localObject != null) && (!TextUtils.isEmpty(((Friends)localObject).name))) {
            localTroopMemberItem.g = ((Friends)localObject).name;
          }
          if ((localObject != null) && (!TextUtils.isEmpty(((Friends)localObject).remark))) {
            localTroopMemberItem.j = ((Friends)localObject).remark;
          }
          if (localTroopManager != null) {
            break label459;
          }
          localObject = null;
          label165:
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!((String)localObject).equals(localTroopMemberItem.a))) {
            break label482;
          }
          localObject = DBUtils.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberListAdapter.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.app, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberListAdapter.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.b), localTroopMemberItem.a);
          if ((localObject != null) && (!TextUtils.isEmpty(((TroopMemberInfo)localObject).troopnick))) {
            localTroopMemberItem.m = ((TroopMemberInfo)localObject).troopnick;
          }
          if ((localObject != null) && (!TextUtils.isEmpty(((TroopMemberInfo)localObject).troopremark))) {
            localTroopMemberItem.j = ((TroopMemberInfo)localObject).troopremark;
          }
          label265:
          if (TextUtils.isEmpty(localTroopMemberItem.j)) {
            break label491;
          }
          localTroopMemberItem.b = localTroopMemberItem.j;
          label286:
          if (TextUtils.isEmpty(localTroopMemberItem.b)) {
            break label573;
          }
          localTroopMemberItem.c = ChnToSpell.a(localTroopMemberItem.b, 2);
          localTroopMemberItem.d = ChnToSpell.a(localTroopMemberItem.b, 1);
          label325:
          if (TextUtils.isEmpty(localTroopMemberItem.g)) {
            break label590;
          }
          localTroopMemberItem.h = ChnToSpell.a(localTroopMemberItem.g, 2);
          localTroopMemberItem.i = ChnToSpell.a(localTroopMemberItem.g, 1);
          label364:
          if (TextUtils.isEmpty(localTroopMemberItem.j)) {
            break label607;
          }
          localTroopMemberItem.k = ChnToSpell.a(localTroopMemberItem.j, 2);
        }
        for (localTroopMemberItem.l = ChnToSpell.a(localTroopMemberItem.j, 1);; localTroopMemberItem.l = "")
        {
          if (TextUtils.isEmpty(localTroopMemberItem.m)) {
            break label624;
          }
          localTroopMemberItem.n = ChnToSpell.a(localTroopMemberItem.m, 2);
          localTroopMemberItem.o = ChnToSpell.a(localTroopMemberItem.m, 1);
          break;
          localObject = localFriendsManager.c(localTroopMemberItem.a);
          break label113;
          label459:
          localObject = localTroopManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberListAdapter.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.b, localTroopMemberItem.a);
          break label165;
          label482:
          localTroopMemberItem.m = ((String)localObject);
          break label265;
          label491:
          if (!TextUtils.isEmpty(localTroopMemberItem.m))
          {
            localTroopMemberItem.b = localTroopMemberItem.m;
            break label286;
          }
          if (!TextUtils.isEmpty(localTroopMemberItem.g))
          {
            localTroopMemberItem.b = localTroopMemberItem.g;
            break label286;
          }
          if (TextUtils.isEmpty(localTroopMemberItem.a)) {
            break label286;
          }
          localTroopMemberItem.b = localTroopMemberItem.a;
          localArrayList.add(localTroopMemberItem.a);
          break label286;
          label573:
          localTroopMemberItem.c = "";
          localTroopMemberItem.d = "";
          break label325;
          label590:
          localTroopMemberItem.h = "";
          localTroopMemberItem.i = "";
          break label364;
          label607:
          localTroopMemberItem.k = "";
        }
        label624:
        localTroopMemberItem.n = "";
        localTroopMemberItem.o = "";
      }
    }
    Object localObject = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberListAdapter.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.app.a(20);
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopdisband.transfer", 2, "init list data, size = " + localArrayList.size() + ", frh = " + localObject);
    }
    if ((localArrayList.size() > 0) && (localObject != null)) {
      ((TroopHandler)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberListAdapter.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.b, this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberListAdapter.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.c, localArrayList);
    }
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberListAdapter.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberListAdapter.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.isFinishing())) {
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberListAdapter.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.runOnUiThread(new mza(this));
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.troopdisband.transfer", 2, localException.toString());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\myz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */