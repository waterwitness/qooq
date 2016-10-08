package cooperation.qqreader;

import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.PluginProxyBroadcastReceiver;
import com.tencent.mobileqq.webprocess.PreloadService;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class VipProxyRreLoadReaderProcess
  extends PluginProxyBroadcastReceiver
{
  public VipProxyRreLoadReaderProcess()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    super.onReceive(paramContext, paramIntent);
    if (paramIntent.getBooleanExtra("isPreloadProcess", false))
    {
      QReaderHelper.e = 2;
      BaseApplicationImpl.a().waitAppRuntime(null).getAppRuntime("qqreaderplugin.apk");
      if (QLog.isColorLevel()) {
        QLog.i("VipProxyRreLoadReaderProcess", 2, "VipProxyRreLoadReaderProcess isPreloadProcess=true");
      }
    }
    PreloadService.a(paramContext);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qqreader\VipProxyRreLoadReaderProcess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */