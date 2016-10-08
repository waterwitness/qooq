import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hly
  implements Runnable
{
  public hly(AccountDetailActivity paramAccountDetailActivity, RelativeLayout.LayoutParams paramLayoutParams1, RelativeLayout.LayoutParams paramLayoutParams2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.a.setLayoutParams(this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.e.setLayoutParams(this.b);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hly.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */