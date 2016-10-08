import android.app.Activity;
import android.content.Context;
import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.OnPluginReadyListener;
import cooperation.plugin.IPluginManager.PluginParams;

public final class ydm
  implements IPluginManager.OnPluginReadyListener
{
  public ydm()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean, Context paramContext, IPluginManager.PluginParams paramPluginParams)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "openActivityForResult onPluginReady." + paramBoolean);
    }
    if (paramBoolean)
    {
      IPluginManager.b((Activity)paramContext, paramPluginParams);
      return;
    }
    Toast.makeText(BaseApplicationImpl.getContext(), "加载失败", 0).show();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ydm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */