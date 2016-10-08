import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.utils.PhoneStatusMonitor;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class hbg
  extends BroadcastReceiver
{
  public hbg(PhoneStatusMonitor paramPhoneStatusMonitor)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("android.intent.action.NEW_OUTGOING_CALL"))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PhoneStatusMonitor", 2, "onReceive NEW_OUTGOING_CALL");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhoneStatusMonitor", 2, "onReceive PHONE_STATE");
    }
    ThreadManager.a(new hbh(this), 5, null, false);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\hbg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */