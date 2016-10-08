import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.PaConfigAttr.PaConfigInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.Switch;

public class hlp
  implements DialogInterface.OnClickListener
{
  public hlp(AccountDetailActivity paramAccountDetailActivity, PaConfigAttr.PaConfigInfo paramPaConfigInfo, Switch paramSwitch, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 0) {
      if ((3 == this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo.e) && (this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo.d == 0))
      {
        paramDialogInterface = this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity;
        localPaConfigInfo = this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo;
        localSwitch = this.jdField_a_of_type_ComTencentWidgetSwitch;
        if (!this.jdField_a_of_type_Boolean)
        {
          bool = true;
          paramDialogInterface.a(localPaConfigInfo, localSwitch, bool);
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo, this.jdField_a_of_type_ComTencentWidgetSwitch);
        this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.a(true);
        this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.f();
        this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.j = false;
      }
    }
    while (paramInt != 1) {
      for (;;)
      {
        PaConfigAttr.PaConfigInfo localPaConfigInfo;
        Switch localSwitch;
        return;
        boolean bool = false;
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo, this.jdField_a_of_type_ComTencentWidgetSwitch, this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.a(true);
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.f();
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.j = false;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hlp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */