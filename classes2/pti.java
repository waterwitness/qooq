import com.tencent.mobileqq.apollo.view.ApolloPanel;
import com.tencent.mobileqq.apollo.view.ApolloPanelAdapter;
import com.tencent.mobileqq.apollo.view.ApolloViewBinder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.widget.HorizontalListView;
import java.util.List;

public class pti
  implements Runnable
{
  public pti(ApolloPanel paramApolloPanel, List paramList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter.notifyDataSetChanged();
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.b.clear();
      int i = 0;
      int k;
      for (int j = 0; i < this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.jdField_a_of_type_JavaUtilList.size(); j = k)
      {
        k = j;
        if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.b != null)
        {
          k = j + ((ApolloViewBinder)this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.jdField_a_of_type_JavaUtilList.get(i)).a();
          this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.b.add(Integer.valueOf(k - 1));
        }
        i += 1;
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(ApolloPanel.jdField_a_of_type_Int, false);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.a(ApolloPanel.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.jdField_a_of_type_ComTencentWidgetHorizontalListView != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.jdField_a_of_type_ComTencentWidgetHorizontalListView.postDelayed(new ptj(this), 500L);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\pti.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */