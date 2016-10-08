import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class hmy
  implements View.OnClickListener
{
  public hmy(AccountDetailActivity paramAccountDetailActivity, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.x)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.y = true;
      if (this.jdField_a_of_type_Int == 0)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_public", "", "connect", "Clk_num", 0, 0, "", "", "", this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin);
        paramView = "http://qun.qq.com/qqweb/m/qun/qun_pub_bind/qun2pub.html?_wv=1027&scode=" + this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.p;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AccountDetailActivity.bindTroop", 2, "jumpTo:" + paramView);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.b(paramView);
      return;
      ReportController.b(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_public", "", "connect", "Clk_grp", 0, 0, "", "", "", this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin);
      paramView = "http://qun.qq.com/qqweb/m/qun/qun_pub_bind/qunlist.html?_wv=1027&power=1&scode=" + this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.p;
      continue;
      ReportController.b(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_public", "", "connect", "Clk_grp", 0, 0, "", "", "", this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin);
      paramView = "http://qun.qq.com/qqweb/m/qun/qun_pub_bind/qunlist.html?_wv=1027&scode=" + this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.p;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hmy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */