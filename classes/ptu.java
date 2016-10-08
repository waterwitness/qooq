import android.content.Context;
import android.content.IntentFilter;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qphone.base.util.QLog;

public class ptu
  implements Runnable
{
  public ptu(BaseActivity paramBaseActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i = 0;
    if (!SettingCloneUtil.readValue(this.a, null, this.a.getString(2131367835), "qqsetting_screenshot_key", false)) {}
    for (;;)
    {
      if (i != 0) {
        this.a.turnOnShake();
      }
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      BaseActivity.access$102(new pub(null));
      try
      {
        this.a.getApplicationContext().registerReceiver(BaseActivity.access$100(), localIntentFilter);
        return;
      }
      catch (Exception localException)
      {
        QLog.e("qqBaseActivity", 1, "", localException);
      }
      i = 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ptu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */