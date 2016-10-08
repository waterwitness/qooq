import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qqdataline.QQProxyForDataline;

public class ovm
  implements View.OnClickListener
{
  public ovm(BannerManager paramBannerManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    paramView = new Bundle();
    paramView.putBoolean("string_from", false);
    paramView.putBoolean("string_uin", true);
    paramView.putLong("device_din", 0L);
    paramView.putInt("sTitleID", 0);
    QQProxyForDataline.a(BannerManager.a(this.a), paramView, "com.qqdataline.activity.LiteWifiphotoActivity");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ovm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */