import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.PaConfigAttr.PaConfigInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.Switch;

public class hlo
  implements DialogInterface.OnCancelListener
{
  public hlo(AccountDetailActivity paramAccountDetailActivity, PaConfigAttr.PaConfigInfo paramPaConfigInfo, Switch paramSwitch)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo, this.jdField_a_of_type_ComTencentWidgetSwitch);
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.j = false;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hlo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */