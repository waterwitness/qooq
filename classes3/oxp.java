import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.random.RandomWebProtocol;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.recent.RecentCallHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class oxp
  implements View.OnClickListener
{
  public oxp(RecentCallHelper paramRecentCallHelper, BaseActivity paramBaseActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131298843: 
      do
      {
        return;
        RecentCallHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper, true);
      } while (RecentCallHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper) == null);
      RecentCallHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper).setVisibility(0);
      return;
    }
    ReportController.b(null, "CliOper", "", "", "0X80052D0", "0X80052D0", 0, 0, "", "", "", "");
    boolean bool = RandomWebProtocol.b();
    if (bool) {
      QLog.d("RecentCallHelper", 2, "Chat hall is using test url");
    }
    if (bool) {}
    for (paramView = "http://play.mobile.qq.com/randchat_test/chatplay/hall_test.html?_wv=1025?adtag=client.tab";; paramView = "http://play.mobile.qq.com/randchat/chatplay/hall.html?_wv=1025?adtag=client.tab")
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
      localIntent.putExtra("isShowAd", false);
      localIntent.putExtra("url", paramView);
      localIntent.putExtra("hide_operation_bar", true);
      localIntent.putExtra("hide_more_button", true);
      localIntent.putExtra("selfSet_leftViewText", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131367567));
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(localIntent);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\oxp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */