import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener.Stub;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqreader.QRBridgeActivity;

public class yiy
  extends OnPluginInstallListener.Stub
{
  public yiy(QRBridgeActivity paramQRBridgeActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onInstallBegin(String paramString) {}
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2) {}
  
  public void onInstallError(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRBridgeActivity", 2, "installPlugin onInstallError, pluginId = " + paramString + ", errorCode = " + paramInt);
    }
    ReportController.b(this.a.app, "P_CliOper", "VIP_QQREADER", "", "0X800604D", "0X800604D", 1, paramInt, "", "", "", "");
  }
  
  public void onInstallFinish(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRBridgeActivity", 2, "installPlugin onInstallFinish, pluginId = " + paramString);
    }
    ReportController.b(this.a.app, "P_CliOper", "VIP_QQREADER", "", "0X800604D", "0X800604D", 1, 0, "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yiy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */