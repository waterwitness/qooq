import android.widget.LinearLayout;
import com.tencent.biz.lebasearch.LebaSearchPluginManagerActivity;
import com.tencent.biz.pubaccount.AccountDetailBounceScrollView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.BounceScrollView.OnScrollChangedListener;

public class hiy
  implements BounceScrollView.OnScrollChangedListener
{
  public hiy(LebaSearchPluginManagerActivity paramLebaSearchPluginManagerActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(float paramFloat1, float paramFloat2) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt1 = (int)(this.a.jdField_a_of_type_AndroidWidgetLinearLayout.getHeight() - this.a.d * (1.0D - LebaSearchPluginManagerActivity.jdField_a_of_type_Double) + 56.0F * this.a.jdField_a_of_type_Float);
    this.a.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBounceScrollView.setMaxOverScrollY(paramInt1);
    if (LebaSearchPluginManagerActivity.a(this.a))
    {
      this.a.a(paramInt2);
      LebaSearchPluginManagerActivity.a(this.a, paramInt2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hiy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */