import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.util.ProfileParams;
import com.tencent.mobileqq.forward.ForwardSdkShareOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hlh
  implements DialogInterface.OnClickListener
{
  public hlh(AccountDetailActivity paramAccountDetailActivity, Activity paramActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.l = true;
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.doOnBackPressed();
      ForwardSdkShareOption.a(this.jdField_a_of_type_AndroidAppActivity, true, "shareToQQ", Long.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.a.b()).longValue());
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.e();
    paramDialogInterface.dismiss();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hlh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */