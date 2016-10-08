import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.VipProxyPreLoadComicProcess;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.plugin.PluginPreInstaller;
import cooperation.qqreader.QRProcessManager;

public class yed
  implements OnPluginInstallListener
{
  public yed(PluginPreInstaller paramPluginPreInstaller)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public IBinder asBinder()
  {
    return null;
  }
  
  public void onInstallBegin(String paramString) {}
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2) {}
  
  public void onInstallError(String paramString, int paramInt)
  {
    if ("qqreaderplugin.apk".equals(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PluginPreInstaller", 2, "PluginPreInstaller onInstallError, pluginId = " + paramString + ", errorCode = " + paramInt);
      }
      ReportController.b(PluginPreInstaller.a(this.a), "P_CliOper", "VIP_QQREADER", "", "0X800604D", "0X800604D", 0, paramInt, "", "", "", "");
    }
  }
  
  public void onInstallFinish(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PluginPreInstaller", 2, "PluginReinstallInWiFi finish,plugin:" + paramString);
    }
    Object localObject;
    if ("qqreaderplugin.apk".equals(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PluginPreInstaller", 2, "PluginPreInstaller onInstallFinish, pluginId = " + paramString);
      }
      ReportController.b(PluginPreInstaller.a(this.a), "P_CliOper", "VIP_QQREADER", "", "0X800604D", "0X800604D", 0, 0, "", "", "", "");
      localObject = (QRProcessManager)PluginPreInstaller.a(this.a).getManager(128);
      if (localObject != null) {
        ((QRProcessManager)localObject).a();
      }
    }
    for (;;)
    {
      localObject = new Intent("com.tencent.mobileqq.cooperation.plugin." + paramString);
      ((Intent)localObject).putExtra("plugin", paramString);
      PluginPreInstaller.a(this.a).sendBroadcast((Intent)localObject);
      return;
      if ("comic_plugin.apk".equals(paramString))
      {
        localObject = new Intent(PluginPreInstaller.a(this.a), VipProxyPreLoadComicProcess.class);
        ((Intent)localObject).putExtra("userQqResources", 2);
        ((Intent)localObject).putExtra("useSkinEngine", false);
        ((Intent)localObject).putExtra("params_remote_connect_at_launch", true);
        IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
        localPluginParams.b = "comic_plugin.apk";
        localPluginParams.d = "comic_plugin";
        localPluginParams.jdField_a_of_type_JavaLangString = PluginPreInstaller.a(this.a).a();
        localPluginParams.e = "com.qqcomic.app.VipPreloadComicProcess";
        localPluginParams.jdField_a_of_type_AndroidContentIntent = ((Intent)localObject);
        IPluginManager.a(PluginPreInstaller.a(this.a), localPluginParams);
        if (QLog.isColorLevel()) {
          QLog.i("PluginPreInstaller", 2, "PluginReinstallInWiFi finish,plugin:" + paramString);
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */