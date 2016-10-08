import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troopreward.TroopRewardDetailActivity;
import com.tencent.qphone.base.util.QLog;

public class vwb
  implements Runnable
{
  public vwb(TroopRewardDetailActivity paramTroopRewardDetailActivity, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardDetailActivity.a, QQBrowserActivity.class);
      localIntent.putExtra("BSafeReportPost", true);
      if (this.jdField_a_of_type_JavaLangString == null) {}
      for (byte[] arrayOfByte = null;; arrayOfByte = this.jdField_a_of_type_JavaLangString.getBytes("utf-8"))
      {
        localIntent.putExtra("SafeReportData", arrayOfByte);
        localIntent.putExtra("hide_more_button", true);
        localIntent.putExtra("ishiderefresh", true);
        localIntent.putExtra("ishidebackforward", true);
        this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardDetailActivity.a.startActivity(localIntent.putExtra("url", "http://jubao.qq.com/uniform_impeach/impeach_entry?_wv=1"));
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(".troop.troop_reward", 2, "openJuBao:" + "http://jubao.qq.com/uniform_impeach/impeach_entry?_wv=1");
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vwb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */