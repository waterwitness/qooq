import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.PaConfigAttr.PaConfigInfo;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class hmk
  implements View.OnClickListener
{
  public hmk(AccountDetailActivity paramAccountDetailActivity, String paramString, PaConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.b(this.jdField_a_of_type_JavaLangString);
    PublicAccountHandler.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.a, this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.p, "Grp_tribe", "interest_data", "Clk_msg");
    if ((this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo.jdField_a_of_type_JavaLangString.contains("历史")))
    {
      ReportController.b(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.a, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.p, "0X8005A29", "0X8005A29", 0, 0, "", "", "", "");
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.e(this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo.jdField_a_of_type_JavaLangString);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hmk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */