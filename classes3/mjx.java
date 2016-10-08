import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.SearchTroopListActivity;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.XListView;
import java.util.List;

public class mjx
  extends TroopObserver
{
  private int jdField_a_of_type_Int;
  
  public mjx(SearchTroopListActivity paramSearchTroopListActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = -2;
  }
  
  protected void a(int paramInt1, boolean paramBoolean, int paramInt2, List paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity.removeObserver(SearchTroopListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity));
    Object localObject;
    if (paramInt1 == 0)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity.jdField_a_of_type_AndroidAppDialog != null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity.jdField_b_of_type_Int == 0)) {
        this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity.jdField_a_of_type_JavaUtilList.clear();
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity;
      ((SearchTroopListActivity)localObject).jdField_b_of_type_Int += 1;
      this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity.jdField_a_of_type_JavaUtilList.addAll(paramList);
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity.jdField_a_of_type_JavaUtilList.isEmpty())
      {
        this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity.setTitle(2131368231);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity.jdField_a_of_type_AndroidWidgetTextView.setText(2131368205);
      this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
      this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity.a();
      paramList = (ProgressBar)this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity.jdField_a_of_type_AndroidViewView.findViewById(2131297005);
      localObject = (ImageView)this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity.jdField_a_of_type_AndroidViewView.findViewById(2131298469);
      paramList.setVisibility(8);
      ((ImageView)localObject).setVisibility(0);
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity.jdField_a_of_type_AndroidAppDialog != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity.jdField_a_of_type_Mjy);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity.jdField_a_of_type_Mjy.notifyDataSetChanged();
      if (paramBoolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity.jdField_a_of_type_AndroidViewView.findViewById(2131297005).setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity.jdField_a_of_type_AndroidViewView.findViewById(2131298469).setVisibility(8);
        paramList = (TextView)this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity.jdField_a_of_type_AndroidViewView.findViewById(2131298457);
        paramList.setVisibility(0);
        paramList.setText("没有更多");
        this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity.a();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity.jdField_a_of_type_ComTencentWidgetXListView.b(this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity.jdField_a_of_type_ComTencentWidgetXListView.b(this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity.jdField_a_of_type_AndroidViewView.setVisibility(0);
      continue;
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity.jdField_a_of_type_AndroidAppDialog != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity.jdField_b_of_type_AndroidWidgetTextView.setText(2131369737);
        this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity.a();
        return;
      }
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity, "加载失败", 0).b(this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity.c);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mjx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */