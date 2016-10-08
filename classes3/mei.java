import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class mei
  extends BroadcastReceiver
{
  public mei(QQMapActivity paramQQMapActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent.getAction().equals("android.intent.action.SCREEN_OFF")) && (!this.a.q) && (!this.a.r) && (GesturePWDUtils.getGesturePWDState(this.a, this.a.o) == 2) && (GesturePWDUtils.getGesturePWDMode(this.a, this.a.o) == 21))
    {
      if (QLog.isColorLevel()) {
        QLog.d("qqbaseactivity", 2, "qqmapactivity.start lock. receive lock.");
      }
      paramContext = new Intent(this.a, GesturePWDUnlockActivity.class);
      QQMapActivity.b(this.a, paramContext);
      this.a.r = true;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mei.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */