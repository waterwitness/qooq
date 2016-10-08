import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.freshnews.FreshNewsFeedAdapter;
import com.tencent.mobileqq.freshnews.FreshNewsHandler;
import com.tencent.mobileqq.freshnews.FreshNewsManager;
import com.tencent.mobileqq.freshnews.data.FNBaseItemData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class spx
  implements View.OnClickListener
{
  public spx(FreshNewsFeedAdapter paramFreshNewsFeedAdapter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if ((this.a.jdField_a_of_type_AndroidAppDialog != null) && (this.a.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      this.a.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    this.a.b("正在删除");
    if (this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsDataFNBaseItemData.jdField_a_of_type_Int == 1) {
      ((FreshNewsHandler)this.a.jdField_a_of_type_ComTencentCommonAppAppInterface.a(1)).c(this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsDataFNBaseItemData.e);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsDataFNBaseItemData = null;
      return;
      if (this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsDataFNBaseItemData.jdField_a_of_type_Int == 3)
      {
        paramView = (FreshNewsManager)this.a.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(211);
        if (this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsDataFNBaseItemData.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo != null) {
          paramView.f(this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsDataFNBaseItemData.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo);
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\spx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */