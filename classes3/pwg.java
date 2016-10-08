import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class pwg
  extends BroadcastReceiver
{
  public pwg(DataLineHandler paramDataLineHandler)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ((paramContext.equalsIgnoreCase("android.intent.action.MEDIA_UNMOUNTED")) || (paramContext.equalsIgnoreCase("android.intent.action.MEDIA_UNMOUNTABLE")) || (paramContext.equalsIgnoreCase("android.intent.action.MEDIA_EJECT")) || (paramContext.equalsIgnoreCase("android.intent.action.MEDIA_REMOVED"))) {
      this.a.d(8);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pwg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */