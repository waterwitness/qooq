import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.activity.PubAccBindTroopListActivity;
import java.util.List;

public class vfh
  implements Runnable
{
  public vfh(PubAccBindTroopListActivity paramPubAccBindTroopListActivity, List paramList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopActivityPubAccBindTroopListActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a() == -1) && (this.jdField_a_of_type_ComTencentMobileqqTroopActivityPubAccBindTroopListActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityPubAccBindTroopListActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(11);
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityPubAccBindTroopListActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.b(this.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityPubAccBindTroopListActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.notifyDataSetChanged();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vfh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */