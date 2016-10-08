import android.view.View;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.PaConfigAttr.PaConfigInfo;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.ecshopassit.EcshopReportHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class hlu
  implements ActionSheet.OnButtonClickListener
{
  public hlu(AccountDetailActivity paramAccountDetailActivity, PaConfigAttr.PaConfigInfo paramPaConfigInfo, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.t) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.t = true;
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.b(this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo, paramInt + 1);
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.b.dismiss();
    } while ((!((EcShopAssistantManager)this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.a.getManager(87)).a(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.p)) || (this.jdField_a_of_type_Int == paramInt));
    ((EcshopReportHandler)this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.a.a(88)).a(134243867, this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.p, null, null, null, paramInt + 1, false);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hlu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */