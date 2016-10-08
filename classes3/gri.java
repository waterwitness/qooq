import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.config.ConfigInfo;
import com.tencent.av.report.TraeConfigUpdate;
import com.tencent.av.ui.ConfigInfoTips;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gri
  extends BroadcastReceiver
{
  public gri(ConfigInfoTips paramConfigInfoTips)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext.equals("com.tencent.av.ui.ConfigInfoTips.ACTION_IS_WRITE_CONFIG_INFO_TO_FILE"))
    {
      if (!ConfigInfoTips.a(this.a))
      {
        ConfigInfoTips.a(this.a, true);
        if (ConfigInfoTips.b(this.a)) {
          ConfigInfoTips.a(this.a);
        }
      }
      paramContext = ConfigInfo.instance();
      if (paramContext != null)
      {
        int i = paramContext.getSharpConfigVersionFromFile();
        TraeConfigUpdate.a().a("update", i);
      }
    }
    do
    {
      do
      {
        return;
      } while ((!paramContext.equals("com.tencent.av.ui.ConfigInfoTips.ACTION_IS_GETTED_SHARP_CONFIG_PAYLOAD")) || (ConfigInfoTips.b(this.a)));
      ConfigInfoTips.b(this.a, true);
      ConfigInfoTips.a(this.a, paramIntent.getIntExtra("version", 0));
    } while (!ConfigInfoTips.a(this.a));
    ConfigInfoTips.a(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gri.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */