import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import mqq.os.MqqHandler;

public class ldm
  extends BroadcastReceiver
{
  public ldm(Conversation paramConversation)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getStringExtra("wording");
    int i = paramIntent.getIntExtra("timetowait", 360000);
    this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.N = i;
    this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.d = paramContext;
    this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(15, 2);
    this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(-1, null);
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(Conversation.class).postDelayed(new ldn(this), i);
    ReportController.b(null, "P_CliOper", "Safe_SecurityDetect", "", "SecurityDetect_PushBanner", "showBanner", 0, 0, "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ldm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */