import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.buscard.BuscardPluginInstallActivity;
import cooperation.plugin.IPluginManager;
import mqq.os.MqqHandler;

public class xyn
  implements Runnable
{
  public xyn(BuscardPluginInstallActivity paramBuscardPluginInstallActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((BuscardPluginInstallActivity.a(this.a).a("BuscardPlugin.apk") == null) || (!BuscardPluginInstallActivity.a(this.a).isReady()))
    {
      if (QLog.isDevelopLevel())
      {
        QLog.i(BuscardPluginInstallActivity.a(), 4, "step2:cost=" + (System.currentTimeMillis() - this.a.a));
        this.a.a = System.currentTimeMillis();
      }
      if (QLog.isDevelopLevel()) {
        QLog.e(BuscardPluginInstallActivity.a(), 4, "mPluginManager.queryPlugin->pluginInfo is null");
      }
      if (!BuscardPluginInstallActivity.a(this.a))
      {
        ThreadManager.b().postDelayed(this, 3000L);
        BuscardPluginInstallActivity.a(this.a, true);
        return;
      }
      QQToast.a(this.a.getApplicationContext(), 2131372395, 0);
      BuscardPluginInstallActivity.a(this.a, false);
      this.a.finish();
      return;
    }
    if (QLog.isDevelopLevel())
    {
      QLog.i(BuscardPluginInstallActivity.a(), 4, "step3:cost=" + (System.currentTimeMillis() - this.a.a));
      this.a.a = System.currentTimeMillis();
    }
    ThreadManager.c().post(new xyo(this));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xyn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */