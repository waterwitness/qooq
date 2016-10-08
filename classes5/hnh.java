import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.AccountDetail.bean.DynamicInfo;
import com.tencent.biz.pubaccount.AccountDetail.bean.MsgAttr;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.AccountDetailActivity.AccountDetailAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class hnh
  implements View.OnClickListener
{
  public hnh(AccountDetailActivity.AccountDetailAdapter paramAccountDetailAdapter, int paramInt, String paramString, DynamicInfo paramDynamicInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Int == 1) {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity$AccountDetailAdapter.a.b(this.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity$AccountDetailAdapter.a.a, "dc00899", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity$AccountDetailAdapter.a.p, "0X8006981", "0X8006981", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanDynamicInfo.a.jdField_a_of_type_Long), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanDynamicInfo.a.d), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanDynamicInfo.a.jdField_a_of_type_Int), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanDynamicInfo.a.b));
      return;
      if (this.jdField_a_of_type_Int == 2) {
        this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity$AccountDetailAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanDynamicInfo);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hnh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */