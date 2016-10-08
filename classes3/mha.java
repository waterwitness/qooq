import android.content.SharedPreferences;
import com.tencent.mobileqq.activity.QQSettingSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;

public class mha
  implements Runnable
{
  public mha(QQSettingSettingActivity paramQQSettingSettingActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    SharedPreferences localSharedPreferences = this.a.getSharedPreferences("SecurityDetectActivity", 0);
    long l1 = localSharedPreferences.getLong("PimscureStatus" + this.a.app.getAccount(), 2L);
    long l2 = localSharedPreferences.getLong("AccountStatus" + this.a.app.getAccount(), 1L);
    long l3 = localSharedPreferences.getLong("LastDetectTime" + this.a.app.getAccount(), 0L);
    boolean bool = SettingCloneUtil.readValue(this.a, null, "security_scan_key", "qqsetting_security_scan_key", false);
    if (System.currentTimeMillis() - l3 < 604800000L) {
      this.a.runOnUiThread(new mhb(this, l2, l1, bool));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mha.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */