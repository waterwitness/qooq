import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.BaseActivity2;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class puf
  extends BroadcastReceiver
{
  private puf(BaseActivity2 paramBaseActivity2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("android.intent.action.SCREEN_OFF"))
    {
      BaseActivity2.K = false;
      GesturePWDUtils.setAppForground(paramContext, BaseActivity2.K);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\puf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */