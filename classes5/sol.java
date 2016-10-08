import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.freshnews.FreshNewsDetailActivity;
import com.tencent.mobileqq.freshnews.FreshNewsHandler;
import com.tencent.mobileqq.freshnews.FreshNewsInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;

public class sol
  implements View.OnClickListener
{
  public sol(FreshNewsDetailActivity paramFreshNewsDetailActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if ((this.a.jdField_a_of_type_AndroidAppDialog != null) && (this.a.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      this.a.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a("CliOper", "", "", "0X8005785", "0X8005785", 0, 0, "", "", "", "");
    this.a.c("正在删除");
    if (this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.publishState == 1) {
      this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsHandler.c(this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.feedId);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sol.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */