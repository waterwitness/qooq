import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.ecshopassit.EcShopRecommendAdapter;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.VipUtils;
import tencent.im.oidb.qqshop.qqshop.SQQSHPRecmdAccount;

public class huh
  implements View.OnClickListener
{
  public huh(EcShopRecommendAdapter paramEcShopRecommendAdapter, qqshop.SQQSHPRecmdAccount paramSQQSHPRecmdAccount)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    VipUtils.a(null, "Shop_lifeservice", "Shop_ulikeclk", "clk_shopulikeclk", 0, 0, new String[0]);
    paramView = String.valueOf(this.jdField_a_of_type_TencentImOidbQqshopQqshop$SQQSHPRecmdAccount.puin.get());
    if (TextUtils.isEmpty(paramView)) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("report_src_param_type", "gouwu_follow");
    localIntent.putExtra("report_src_param_name", "0X8005D58");
    PublicAccountUtil.a(localIntent, this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopRecommendAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopRecommendAdapter.jdField_a_of_type_AndroidAppActivity, paramView, -5);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\huh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */