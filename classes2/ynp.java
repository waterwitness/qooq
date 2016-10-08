import android.content.Context;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.plugin.IQZonePluginManager;
import cooperation.qzone.plugin.IQZonePluginManager.OnPluginReadyListener;
import cooperation.qzone.plugin.IQZonePluginManager.PluginParams;

public final class ynp
  implements IQZonePluginManager.OnPluginReadyListener
{
  public ynp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean, Context paramContext, IQZonePluginManager.PluginParams paramPluginParams)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "launchPluginBroadcast onPluginReady." + paramBoolean);
    }
    if (paramBoolean) {
      IQZonePluginManager.c(paramContext, paramPluginParams);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ynp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */