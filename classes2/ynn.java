import android.app.Activity;
import android.content.Context;
import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.plugin.IQZonePluginManager;
import cooperation.qzone.plugin.IQZonePluginManager.OnPluginReadyListener;
import cooperation.qzone.plugin.IQZonePluginManager.PluginParams;

public final class ynn
  implements IQZonePluginManager.OnPluginReadyListener
{
  public ynn()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean, Context paramContext, IQZonePluginManager.PluginParams paramPluginParams)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "openActivityForResult onPluginReady." + paramBoolean);
    }
    if (paramBoolean)
    {
      IQZonePluginManager.b((Activity)paramContext, paramPluginParams);
      return;
    }
    Toast.makeText(BaseApplicationImpl.getContext(), "加载失败", 0).show();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ynn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */