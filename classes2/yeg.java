import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import cooperation.pluginbridge.BridgeHelper;
import cooperation.pluginbridge.BridgePluginInstallActivity;
import cooperation.qqwifi.QQWiFiHelper.PluginLoadDialog;

public class yeg
  extends BroadcastReceiver
{
  static final String a = "bridge.onresume.broadcast";
  static final String b = "bridge.plugin.onresume.broadcast";
  
  private yeg()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramIntent = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.i("BridgeHelper", 2, "action:" + paramIntent);
    }
    if (("bridge.plugin.onresume.broadcast".equals(paramIntent)) || ("bridge.onresume.broadcast".equals(paramIntent))) {}
    try
    {
      paramContext.unregisterReceiver(BridgeHelper.a());
      BridgeHelper.a(null);
      if (BridgeHelper.a() != null)
      {
        BridgeHelper.a().dismiss();
        BridgeHelper.a(null);
      }
      if ((paramContext instanceof BridgePluginInstallActivity))
      {
        if (QLog.isColorLevel()) {
          QLog.w("BridgeHelper", 2, "Activity finish!");
        }
        ((BridgePluginInstallActivity)paramContext).finish();
      }
      return;
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        paramIntent.printStackTrace();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yeg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */