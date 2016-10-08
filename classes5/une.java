import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.model.ContactSearchModelGlobalTroop;
import com.tencent.mobileqq.search.model.ContactSearchModelGlobalTroopMember;
import com.tencent.mobileqq.search.model.IContactSearchModel;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public final class une
  implements Runnable
{
  public une(View paramView, IContactSearchModel paramIContactSearchModel)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int j = -1;
    HashMap localHashMap = new HashMap();
    Object localObject = (Integer)this.jdField_a_of_type_AndroidViewView.getTag(2131296490);
    int i;
    if (localObject != null)
    {
      i = ((Integer)localObject).intValue();
      localHashMap.put("itemLinePosition", String.valueOf(i + 1));
      localHashMap.put("matchDegree", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqSearchModelIContactSearchModel.b()));
      localHashMap.put("className", this.jdField_a_of_type_ComTencentMobileqqSearchModelIContactSearchModel.getClass().getSimpleName());
      localHashMap.put("keyword", this.jdField_a_of_type_ComTencentMobileqqSearchModelIContactSearchModel.b());
      if (this.jdField_a_of_type_ComTencentMobileqqSearchModelIContactSearchModel.jdField_a_of_type_JavaUtilHashMap != null) {
        localHashMap.putAll(this.jdField_a_of_type_ComTencentMobileqqSearchModelIContactSearchModel.jdField_a_of_type_JavaUtilHashMap);
      }
      if (!(this.jdField_a_of_type_ComTencentMobileqqSearchModelIContactSearchModel instanceof ContactSearchModelGlobalTroopMember)) {
        break label329;
      }
      localObject = ((ContactSearchModelGlobalTroopMember)this.jdField_a_of_type_ComTencentMobileqqSearchModelIContactSearchModel).a;
    }
    for (;;)
    {
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (this.jdField_a_of_type_ComTencentMobileqqSearchModelIContactSearchModel.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
      {
        int k = this.jdField_a_of_type_ComTencentMobileqqSearchModelIContactSearchModel.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b((String)localObject);
        localHashMap.put("troopMask", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqSearchModelIContactSearchModel.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b((String)localObject)));
        TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqSearchModelIContactSearchModel.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
        i = j;
        if (localTroopManager != null)
        {
          localObject = localTroopManager.b((String)localObject);
          i = j;
          if (localObject != null) {
            i = ((TroopInfo)localObject).wMemberNum;
          }
        }
        localHashMap.put("troopMask", String.valueOf(k));
        localHashMap.put("troopMemberNum", String.valueOf(i));
        if (QLog.isColorLevel()) {
          QLog.d("searchUtils", 2, "Report troop member click, troopMask:" + k + " troopMemberNum:" + i);
        }
      }
      StatisticCollector.a(BaseApplicationImpl.a()).a(null, "ContactSearchMatchDegree", true, 0L, 0L, SearchUtils.a(localHashMap), "", false);
      return;
      i = -1;
      break;
      label329:
      if ((this.jdField_a_of_type_ComTencentMobileqqSearchModelIContactSearchModel instanceof ContactSearchModelGlobalTroop)) {
        localObject = ((ContactSearchModelGlobalTroop)this.jdField_a_of_type_ComTencentMobileqqSearchModelIContactSearchModel).a;
      } else {
        localObject = "";
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\une.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */