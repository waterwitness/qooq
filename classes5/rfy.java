import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.dating.MsgBoxListActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearpeople.NearbyRecommender.ChatPushCarrierHelper;
import java.util.List;

class rfy
  implements Runnable
{
  rfy(rfw paramrfw, List paramList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Rfw.a.jdField_a_of_type_ComTencentMobileqqNearpeopleNearbyRecommenderChatPushCarrierHelper != null)
    {
      if (this.jdField_a_of_type_JavaUtilList != null) {
        this.jdField_a_of_type_Rfw.a.jdField_a_of_type_ComTencentMobileqqNearpeopleNearbyRecommenderChatPushCarrierHelper.a(this.jdField_a_of_type_JavaUtilList);
      }
      this.jdField_a_of_type_Rfw.a.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_Rfw.a.jdField_a_of_type_ComTencentMobileqqNearpeopleNearbyRecommenderChatPushCarrierHelper.a();
      this.jdField_a_of_type_Rfw.a.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_Rfw.a.jdField_d_of_type_AndroidViewView);
      this.jdField_a_of_type_Rfw.a.jdField_d_of_type_Boolean = true;
      if ((this.jdField_a_of_type_Rfw.a.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) && ((this.jdField_a_of_type_Rfw.a.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_Rfw.a.jdField_a_of_type_JavaUtilList.size() == 0))) {
        this.jdField_a_of_type_Rfw.a.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.notifyDataSetChanged();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rfy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */