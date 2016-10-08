import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.PaConfigAttr.PaConfigInfo;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class hmu
  implements View.OnClickListener
{
  public hmu(AccountDetailActivity paramAccountDetailActivity, String paramString, PaConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.b(this.jdField_a_of_type_JavaLangString);
    if ((this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo.jdField_a_of_type_JavaLangString.contains("历史")))
    {
      int i = PublicAccountUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.accountFlag);
      if ((i == -3) || (i == -4))
      {
        if (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.n)
        {
          paramView = "new";
          if (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.followType != 1) {
            break label132;
          }
        }
        label132:
        for (String str = "1";; str = "0")
        {
          ReportController.b(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.p, "0X8005A29", "0X8005A29", 0, 0, paramView, str, "", "");
          return;
          paramView = "old";
          break;
        }
      }
      ReportController.b(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.p, "0X8005A29", "0X8005A29", 0, 0, "", "", "", "");
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.e(this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo.jdField_a_of_type_JavaLangString);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hmu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */