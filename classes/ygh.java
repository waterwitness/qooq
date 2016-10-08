import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener.Stub;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavHelper;
import java.util.concurrent.atomic.AtomicBoolean;

class ygh
  extends OnPluginInstallListener.Stub
{
  ygh(ygg paramygg)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onInstallBegin(String paramString) {}
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2) {}
  
  public void onInstallError(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("qqfav", 2, "install plugin " + paramString + " error! " + paramInt);
    }
    try
    {
      this.a.a.start();
      return;
    }
    catch (Exception paramString) {}
  }
  
  public void onInstallFinish(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("qqfav", 2, "install plugin " + paramString + " OK.");
    }
    QfavHelper.a().set(true);
    try
    {
      this.a.a.start();
      return;
    }
    catch (Exception paramString) {}
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ygh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */