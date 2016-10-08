import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener.Stub;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import cooperation.qqindividuality.QQIndividualityBridgeActivity;

public class yim
  extends OnPluginInstallListener.Stub
{
  public yim(QQIndividualityBridgeActivity paramQQIndividualityBridgeActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onInstallBegin(String paramString) {}
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2) {}
  
  public void onInstallError(String paramString, int paramInt)
  {
    paramString = String.valueOf(paramInt);
    IPluginManager.a(paramString, "斗图");
    QLog.e("QQIndividuality", 2, "install plugin fail: " + paramInt);
    QQIndividualityBridgeActivity.c(this.a);
    ReportController.b(null, "CliOper", "", "", "ep_mall", "0X8006A98", 0, 0, paramString, "", "", "");
  }
  
  public void onInstallFinish(String paramString)
  {
    this.a.a();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yim.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */