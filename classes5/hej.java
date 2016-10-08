import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.PoiMapActivity;
import com.tencent.biz.PoiMapActivity.POI;
import com.tencent.biz.coupon.CouponActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hej
  implements View.OnClickListener
{
  public hej(PoiMapActivity paramPoiMapActivity, String paramString1, String paramString2, PoiMapActivity.POI paramPOI, String paramString3)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.jdField_a_of_type_ComTencentBizPoiMapActivity, CouponActivity.class);
    paramView.putExtra("url", this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentBizPoiMapActivity.startActivity(paramView);
    if ((this.jdField_a_of_type_ComTencentBizPoiMapActivity.a != null) && (this.jdField_a_of_type_ComTencentBizPoiMapActivity.l < this.jdField_a_of_type_ComTencentBizPoiMapActivity.a.length) && (!TextUtils.isEmpty(this.b))) {
      this.jdField_a_of_type_ComTencentBizPoiMapActivity.a("share_locate", this.b, this.jdField_a_of_type_ComTencentBizPoiMapActivity$POI.c, this.c, "0", "");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hej.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */