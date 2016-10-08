import com.tencent.mobileqq.dating.DatingTopListActivity;
import com.tencent.mobileqq.dating.GodListConfig;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.List;

public class ret
  implements Runnable
{
  public ret(DatingTopListActivity paramDatingTopListActivity, GodListConfig paramGodListConfig, boolean paramBoolean, List paramList, long paramLong, int paramInt)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    GodListConfig localGodListConfig = this.jdField_a_of_type_ComTencentMobileqqDatingGodListConfig;
    DatingTopListActivity.a(this.jdField_a_of_type_ComTencentMobileqqDatingDatingTopListActivity, localGodListConfig);
    List localList1;
    if (this.jdField_a_of_type_Boolean)
    {
      localList1 = this.jdField_a_of_type_JavaUtilList;
      if (this.jdField_a_of_type_Long != 0L) {
        break label222;
      }
      DatingTopListActivity.a(this.jdField_a_of_type_ComTencentMobileqqDatingDatingTopListActivity, localList1, localGodListConfig.listType, true);
      if (DatingTopListActivity.c(this.jdField_a_of_type_ComTencentMobileqqDatingDatingTopListActivity) == 0)
      {
        List localList2 = DatingTopListActivity.a(this.jdField_a_of_type_ComTencentMobileqqDatingDatingTopListActivity, localGodListConfig.listType);
        DatingTopListActivity.a(this.jdField_a_of_type_ComTencentMobileqqDatingDatingTopListActivity).a(localList2);
        DatingTopListActivity.a(this.jdField_a_of_type_ComTencentMobileqqDatingDatingTopListActivity).notifyDataSetChanged();
        DatingTopListActivity.a(this.jdField_a_of_type_ComTencentMobileqqDatingDatingTopListActivity).b(true);
        if (QLog.isColorLevel()) {
          QLog.i("DatingTopListActivity", 2, "DatingTopListActivity loadDataFromServerFinish CITY cfg.hasMore =  " + localGodListConfig.hasMore);
        }
        if (localGodListConfig.hasMore) {
          break label238;
        }
        DatingTopListActivity.a(this.jdField_a_of_type_ComTencentMobileqqDatingDatingTopListActivity).c();
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Int >= 0) && (localList1 != null) && (localList1.size() > 0))
      {
        if (QLog.isColorLevel()) {
          QLog.i("DatingTopListActivity", 2, "DatingTopListActivity loadDataFromServerFinish CITY setSelection " + this.jdField_a_of_type_Int);
        }
        DatingTopListActivity.a(this.jdField_a_of_type_ComTencentMobileqqDatingDatingTopListActivity).setSelection(this.jdField_a_of_type_Int);
      }
      return;
      label222:
      DatingTopListActivity.a(this.jdField_a_of_type_ComTencentMobileqqDatingDatingTopListActivity, localList1, localGodListConfig.listType, false);
      break;
      label238:
      DatingTopListActivity.a(this.jdField_a_of_type_ComTencentMobileqqDatingDatingTopListActivity).b();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ret.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */