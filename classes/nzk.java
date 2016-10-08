import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearpeople.NearbyRecommender.NearbyRecommenderUtils;
import com.tencent.mobileqq.statistics.ReportController;

public class nzk
  implements Runnable
{
  public nzk(NearbyChatPie paramNearbyChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    String[] arrayOfString = NearbyRecommenderUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    String str = this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("uin");
    ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80055FE", "0X80055FE", 0, 0, arrayOfString[0], str, "", "");
    this.a.J = false;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nzk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */