import android.os.Handler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener.Stub;
import com.tencent.qphone.base.util.QLog;
import cooperation.groupvideo.GVideoPluginInstallerActivity;

public class ybu
  extends OnPluginInstallListener.Stub
{
  public ybu(GVideoPluginInstallerActivity paramGVideoPluginInstallerActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onInstallBegin(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.a, 2, "Group video plugin onInstallBegin...");
    }
  }
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.a, 2, "Group video plugin onInstallDownloadProgress...");
    }
  }
  
  public void onInstallError(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.a, 2, "Group video plugin onInstallError...");
    }
    this.a.b.sendEmptyMessageDelayed(3, 200L);
  }
  
  public void onInstallFinish(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.a, 2, "Group video plugin onInstallFinish...");
    }
    this.a.b.sendEmptyMessageDelayed(1, 1000L);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ybu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */