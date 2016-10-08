import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantActivity;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager.BannerConfig;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class htq
  implements View.OnClickListener
{
  public htq(EcShopAssistantActivity paramEcShopAssistantActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = (EcShopAssistantManager.BannerConfig)paramView.getTag();
    Intent localIntent = new Intent(this.a, QQBrowserActivity.class);
    localIntent.putExtra("url", paramView.b);
    this.a.startActivity(localIntent);
    ReportController.b(null, "P_CliOper", "Shop_lifeservice", "", "Shop_bannerclk", "Clk_shopbanner", 0, 0, "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\htq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */