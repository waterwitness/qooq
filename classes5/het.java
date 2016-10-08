import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.PoiMapActivity;
import com.tencent.biz.PoiMapActivity.ShopListAdapter;
import com.tencent.biz.PoiMapActivity.Shops;
import com.tencent.biz.coupon.CouponActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

public class het
  implements AdapterView.OnItemClickListener
{
  public het(PoiMapActivity paramPoiMapActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.a.a.a(paramInt);
    if (paramAdapterView == null) {
      return;
    }
    paramView = new Intent(this.a, CouponActivity.class);
    paramView.putExtra("url", paramAdapterView.g);
    this.a.startActivity(paramView);
    if (!TextUtils.isEmpty(PoiMapActivity.a(this.a))) {
      this.a.a("rec_locate", "click_shangjia", paramAdapterView.h, "", "", "");
    }
    for (;;)
    {
      if (paramAdapterView.b != 0) {
        this.a.a("rec_locate", "view_share_tuan", paramAdapterView.h, "", "", "");
      }
      if (paramAdapterView.c == 0) {
        break;
      }
      this.a.a("rec_locate", "click_quan", paramAdapterView.h, "", "", "");
      return;
      this.a.a("rec_locate", "click_near_food", paramAdapterView.h, "", "", "");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\het.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */