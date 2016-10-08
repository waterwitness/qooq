import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.Call;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class krw
  extends BroadcastReceiver
{
  public krw(Call paramCall)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (("android.intent.action.TIME_SET".equals(paramContext)) || ("android.intent.action.TIMEZONE_CHANGED".equals(paramContext)) || ("android.intent.action.DATE_CHANGED".equals(paramContext))) {
      this.a.i();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\krw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */