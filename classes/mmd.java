import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

class mmd
  extends BroadcastReceiver
{
  mmd(mmc parammmc)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SplashActivity", 2, "onReceive:before_account_change");
    }
    this.a.a.a();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\mmd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */