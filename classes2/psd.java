import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.apollo.task.ApolloActionManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class psd
  extends BroadcastReceiver
{
  public psd(ApolloActionManager paramApolloActionManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (("android.intent.action.SCREEN_OFF".equals(paramIntent.getAction())) && (this.a.b())) {
      this.a.a();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\psd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */