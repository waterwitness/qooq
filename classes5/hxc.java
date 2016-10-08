import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class hxc
  implements Runnable
{
  public hxc(ReadInJoySettingActivity paramReadInJoySettingActivity, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoySettingActivity.jdField_a_of_type_Int > 0) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoySettingActivity.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoySettingActivity.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(this.jdField_a_of_type_Int);
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoySettingActivity.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoySettingActivity.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hxc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */