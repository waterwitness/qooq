package cooperation.plugin;

import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.IPluginAdapter;
import mqq.app.AppRuntime;

public class PluginAdapterImpl
  implements IPluginAdapter
{
  public PluginAdapterImpl()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public Object invoke(int paramInt, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      return null;
    }
    paramBundle = BaseApplicationImpl.a();
    if (paramBundle.a() != null)
    {
      String str = paramBundle.a().getAccount();
      if (Build.VERSION.SDK_INT > 10) {}
      for (paramInt = 4; "1103".equals(paramBundle.getSharedPreferences(str, paramInt).getString("currentThemeId_6.3.5", "1000")); paramInt = 0) {
        return Boolean.valueOf(true);
      }
    }
    return Boolean.valueOf(false);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\cooperation\plugin\PluginAdapterImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */