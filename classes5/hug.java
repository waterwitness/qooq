import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.ecshopassit.EcShopOptPopBar;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import com.tencent.widget.PopupMenuDialog.OnClickActionListener;

public class hug
  implements PopupMenuDialog.OnClickActionListener
{
  public hug(EcShopOptPopBar paramEcShopOptPopBar)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(PopupMenuDialog.MenuItem paramMenuItem)
  {
    switch (paramMenuItem.a)
    {
    }
    do
    {
      do
      {
        return;
      } while ((paramMenuItem.c == null) || (TextUtils.isEmpty(paramMenuItem.c)));
      localIntent = new Intent(this.a.a, QQBrowserActivity.class);
      localIntent.putExtra("url", paramMenuItem.c);
      localIntent.putExtra("hide_more_button", true);
      localIntent.putExtra("webStyle", "noBottomBar");
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      this.a.a.startActivity(localIntent);
      VipUtils.a(null, "Shop_lifeservice", "Shop_discoveryclk", "clk_shopdiscoveryclk", 0, 0, new String[0]);
      return;
    } while ((paramMenuItem.c == null) || (TextUtils.isEmpty(paramMenuItem.c)));
    Intent localIntent = new Intent(this.a.a, QQBrowserActivity.class);
    localIntent.putExtra("url", paramMenuItem.c);
    localIntent.putExtra("hide_more_button", true);
    localIntent.putExtra("webStyle", "noBottomBar");
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    this.a.a.startActivity(localIntent);
    VipUtils.a(null, "Shop_lifeservice", "Shop_createclk", "clk_shopcreateclk", 0, 0, new String[0]);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hug.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */