import android.os.IBinder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.buscard.BuscardPluginInstallActivity;
import cooperation.plugin.IPluginManager;

public class xyp
  implements OnPluginInstallListener
{
  public xyp(BuscardPluginInstallActivity paramBuscardPluginInstallActivity)
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
    if (QLog.isDevelopLevel()) {
      QLog.i(BuscardPluginInstallActivity.a(), 4, "onInstallError, pluginId:" + paramString + ",errorCode:" + paramInt);
    }
    if (QLog.isDevelopLevel())
    {
      QLog.i(BuscardPluginInstallActivity.a(), 4, "step9:cost=" + (System.currentTimeMillis() - this.a.a));
      this.a.a = System.currentTimeMillis();
    }
    QQToast.a(this.a.getApplicationContext(), 2131372395, 0);
    BuscardPluginInstallActivity.a(this.a, false);
    this.a.finish();
  }
  
  public void onInstallFinish(String paramString)
  {
    if (QLog.isDevelopLevel())
    {
      QLog.i(BuscardPluginInstallActivity.a(), 4, "step8:cost=" + (System.currentTimeMillis() - this.a.a));
      this.a.a = System.currentTimeMillis();
    }
    if (QLog.isDevelopLevel()) {
      QLog.i(BuscardPluginInstallActivity.a(), 4, "onInstallFinish, pluginId:" + paramString);
    }
    boolean bool = BuscardPluginInstallActivity.a(this.a).isPlugininstalled("BuscardPlugin.apk");
    if (QLog.isDevelopLevel()) {
      QLog.i(BuscardPluginInstallActivity.a(), 4, "installed=" + bool);
    }
    if (bool)
    {
      BuscardPluginInstallActivity.a(this.a);
      return;
    }
    QQToast.a(this.a.getApplicationContext(), 2131372395, 0);
    BuscardPluginInstallActivity.a(this.a, false);
    this.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xyp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */