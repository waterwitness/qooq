import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyFeedsActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hwq
  implements Runnable
{
  public hwq(ReadInJoyFeedsActivity paramReadInJoyFeedsActivity, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Int <= 0)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyFeedsActivity.a.setText(2131367566);
      return;
    }
    if (this.jdField_a_of_type_Int > 99)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyFeedsActivity.a.setText(String.format("%s(%d+)", new Object[] { this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyFeedsActivity.getString(2131367566), Integer.valueOf(99) }));
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyFeedsActivity.a.setText(String.format("%s(%d)", new Object[] { this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyFeedsActivity.getString(2131367566), Integer.valueOf(this.jdField_a_of_type_Int) }));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hwq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */