import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailXListView;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.AccountDetailActivity.AccountDetailAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class hmo
  implements View.OnClickListener
{
  public hmo(AccountDetailActivity paramAccountDetailActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    this.a.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity$AccountDetailAdapter.a();
    this.a.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.setSelectionFromTop(2, this.a.H + this.a.I);
    this.a.a(this.a.jdField_a_of_type_AndroidWidgetButton, this.a.b);
    ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", this.a.p, "0X8006982", "0X8006982", 0, 0, "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hmo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */