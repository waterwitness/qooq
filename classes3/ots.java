import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ots
  extends BroadcastReceiver
{
  public ots(SendHbActivity paramSendHbActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (("tencent.av.v2q.StartVideoChat".equals(paramIntent.getAction())) && (SendHbActivity.a(this.a)) && ((SendHbActivity.a(this.a) & 0x40) > 0)) {
      this.a.finish();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ots.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */