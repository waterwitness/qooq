import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qwallet.plugin.QWalletPluginProxyActivity;

public class yjr
  extends BroadcastReceiver
{
  private yjr(QWalletPluginProxyActivity paramQWalletPluginProxyActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      return;
      paramContext = paramIntent.getAction();
    } while ((paramContext == null) || (!paramContext.equals("pluginsdk_QWallet_PatternLock_closeAll")));
    this.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yjr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */