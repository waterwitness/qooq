import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lnx
  extends BroadcastReceiver
{
  public lnx(GesturePWDUnlockActivity paramGesturePWDUnlockActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.getLongExtra("timeid", 0L) > this.a.a) && (!this.a.isFinishing())) {
      this.a.finish();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lnx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */