import android.content.Intent;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyAccountDetailActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import cooperation.readinjoy.ReadInJoyHelper;

public class hwm
  implements ActionSheet.OnButtonClickListener
{
  public hwm(ReadInJoyAccountDetailActivity paramReadInJoyAccountDetailActivity, ActionSheet paramActionSheet)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      SettingCloneUtil.writeValue(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyAccountDetailActivity, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyAccountDetailActivity.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), null, "qqsetting_kandian_key", false);
      ReadInJoyHelper.a(false);
      paramView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyAccountDetailActivity.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      RecentUser localRecentUser = paramView.b(ReadInJoyAccountDetailActivity.jdField_a_of_type_JavaLangString, 1008);
      if (localRecentUser != null) {
        paramView.b(localRecentUser);
      }
      ReportController.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyAccountDetailActivity.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800676D", "0X800676D", 0, 0, "", "", "", "");
      paramView = new Intent();
      paramView.putExtra("isNeedFinish", true);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyAccountDetailActivity.setResult(-1, paramView);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyAccountDetailActivity.finish();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hwm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */