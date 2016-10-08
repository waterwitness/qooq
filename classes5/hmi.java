import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.PaConfigAttr.PaConfigInfo;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class hmi
  implements View.OnClickListener
{
  public hmi(AccountDetailActivity paramAccountDetailActivity, PaConfigAttr.PaConfigInfo paramPaConfigInfo, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity, QQMapActivity.class);
    paramView.putExtra("lat", this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo.g);
    paramView.putExtra("lon", this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo.f);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      paramView.putExtra("loc", this.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.startActivity(paramView);
    ReportController.b(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.a, "CliOper", "", "", "Biz_card", "Biz_card_map", 0, 0, this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.p, "", "", "");
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.e(this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo.jdField_a_of_type_JavaLangString);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hmi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */