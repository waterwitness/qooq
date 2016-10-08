import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.PaConfigAttr.PaConfigInfo;
import com.tencent.biz.troopbar.ShareActionSheet;
import com.tencent.biz.troopbar.ShareActionSheet.Detail;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hmn
  implements View.OnClickListener
{
  public hmn(AccountDetailActivity paramAccountDetailActivity, PaConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    ShareActionSheet.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity, new ShareActionSheet.Detail(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.a.uin, this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.a.name, this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.a.summary), this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.b(), this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.b());
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.e(this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo.a);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hmn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */