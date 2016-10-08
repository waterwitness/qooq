import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.contact.troop.RecommendTroopView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.activity.RecommendTroopAdapter;
import com.tencent.widget.SwipListView;
import java.util.ArrayList;
import java.util.List;

public class ojx
  implements Runnable
{
  public ojx(RecommendTroopView paramRecommendTroopView, List paramList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopRecommendTroopView.jdField_a_of_type_ComTencentMobileqqTroopActivityRecommendTroopAdapter.a(this.jdField_a_of_type_JavaUtilList);
    }
    for (;;)
    {
      RecommendTroopView.b(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopRecommendTroopView);
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopRecommendTroopView.d)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopRecommendTroopView.k();
        this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopRecommendTroopView.d = true;
      }
      return;
      ArrayList localArrayList = new ArrayList();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopRecommendTroopView.jdField_a_of_type_ComTencentMobileqqTroopActivityRecommendTroopAdapter.a(localArrayList);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopRecommendTroopView.jdField_a_of_type_ComTencentWidgetSwipListView.setEmptyView(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopRecommendTroopView.b);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopRecommendTroopView.f.setPadding(0, 0, 0, 0);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopRecommendTroopView.e.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopRecommendTroopView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      ReportController.b(null, "P_CliOper", "Grp_recom", "", "msg_page", "exp_blank", 0, 0, "", "", "", "");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ojx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */