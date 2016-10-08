import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.PaConfigAttr.PaConfigInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hms
  implements View.OnClickListener
{
  public hms(AccountDetailActivity paramAccountDetailActivity, PaConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.F = this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo.d;
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo, this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.F);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hms.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */