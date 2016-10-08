import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.ui.PSTNC2CActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gxw
  extends BroadcastReceiver
{
  gxw(PSTNC2CActivity paramPSTNC2CActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS"))
    {
      paramContext = paramIntent.getStringExtra("reason");
      if ((paramContext != null) && (paramContext.equals("homekey")))
      {
        PSTNC2CActivity.b(this.a);
        this.a.finish();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gxw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */