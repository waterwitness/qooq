import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import com.tencent.biz.lebasearch.LebaSearchPluginManagerActivity;
import com.tencent.biz.pubaccount.AccountDetailBounceScrollView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class hix
  extends Handler
{
  hix(hiw paramhiw)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (this.a.jdField_a_of_type_Int == this.a.jdField_a_of_type_ComTencentBizLebasearchLebaSearchPluginManagerActivity.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBounceScrollView.getScrollY())
    {
      if ((this.a.jdField_a_of_type_Int > 0) && (!this.a.jdField_a_of_type_ComTencentBizLebasearchLebaSearchPluginManagerActivity.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBounceScrollView.a()))
      {
        int i = this.a.jdField_a_of_type_Int;
        i = (int)(this.a.jdField_a_of_type_ComTencentBizLebasearchLebaSearchPluginManagerActivity.d * (1.0D - LebaSearchPluginManagerActivity.jdField_a_of_type_Double) + this.a.jdField_a_of_type_Int);
        int j = (int)(this.a.jdField_a_of_type_Int - (this.a.jdField_a_of_type_ComTencentBizLebasearchLebaSearchPluginManagerActivity.b.getHeight() + this.a.jdField_a_of_type_ComTencentBizLebasearchLebaSearchPluginManagerActivity.jdField_a_of_type_Float * 56.0F - this.a.jdField_a_of_type_ComTencentBizLebasearchLebaSearchPluginManagerActivity.d * (1.0D - LebaSearchPluginManagerActivity.jdField_a_of_type_Double)));
        if ((i > this.a.jdField_a_of_type_ComTencentBizLebasearchLebaSearchPluginManagerActivity.b.getHeight() + this.a.jdField_a_of_type_ComTencentBizLebasearchLebaSearchPluginManagerActivity.jdField_a_of_type_Float * 56.0F) || (i > this.a.jdField_a_of_type_ComTencentBizLebasearchLebaSearchPluginManagerActivity.b.getHeight())) {
          this.a.jdField_a_of_type_ComTencentBizLebasearchLebaSearchPluginManagerActivity.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBounceScrollView.scrollBy(0, -j);
        }
      }
      return;
    }
    this.a.jdField_a_of_type_Int = this.a.jdField_a_of_type_ComTencentBizLebasearchLebaSearchPluginManagerActivity.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBounceScrollView.getScrollY();
    this.a.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(), 5L);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hix.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */