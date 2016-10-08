import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.PaConfigAttr.PaConfigInfo;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hml
  implements View.OnClickListener
{
  public hml(AccountDetailActivity paramAccountDetailActivity, PaConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity, ScannerActivity.class);
    paramView.putExtra("from", AccountDetailActivity.class.getName());
    paramView.putExtra("finishAfterSucc", true);
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.startActivity(paramView);
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.e(this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo.a);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hml.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */