import android.content.Context;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.OnPluginReadyListener;
import cooperation.plugin.IPluginManager.PluginParams;

public final class ydq
  implements IPluginManager.OnPluginReadyListener
{
  public ydq()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean, Context paramContext, IPluginManager.PluginParams paramPluginParams)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "launchPluginService onPluginReady." + paramBoolean);
    }
    if (paramBoolean) {
      IPluginManager.d(paramContext, paramPluginParams);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ydq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */