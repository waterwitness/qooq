package cooperation.plugin;

import android.app.ProgressDialog;
import android.content.Context;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class PluginManagerV2$LaunchState
{
  public ProgressDialog a;
  public Context a;
  public IPluginManager.OnPluginReadyListener a;
  public IPluginManager.PluginParams a;
  public boolean a;
  
  public PluginManagerV2$LaunchState()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\plugin\PluginManagerV2$LaunchState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */