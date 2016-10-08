import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.coupon.CouponActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hhr
  implements View.OnClickListener
{
  public hhr(CouponActivity paramCouponActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if ((this.a.a & 0x4) != 0)
    {
      paramView = new Intent();
      paramView.putExtra("isNeedFinish", true);
      paramView.putExtra("toPage", 1);
      this.a.setResult(-1, paramView);
      this.a.finish();
      return;
    }
    paramView = new Intent(this.a, CouponActivity.class);
    paramView.putExtra("url", "http://web.p.qq.com/qqmpmobile/coupon/mycoupons.html?_bid=108");
    paramView.putExtra("source", "2");
    paramView.putExtra("from", this.a.a & 0xC | 0x5);
    this.a.startActivityForResult(paramView, 100);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hhr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */