import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.os.MqqHandler;

public class ovt
  implements View.OnClickListener
{
  public ovt(BannerManager paramBannerManager, long paramLong)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (BannerManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager) != null)
    {
      paramView = BannerManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager).obtainMessage(1134028);
      BannerManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager).sendMessage(paramView);
    }
    paramView = new Intent();
    paramView.setAction("cooperation.qqreader.aioback2reader");
    paramView.putExtra("bookid", this.jdField_a_of_type_Long);
    paramView.putExtra("is_from_conversation", true);
    BannerManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager).sendBroadcast(paramView);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ovt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */