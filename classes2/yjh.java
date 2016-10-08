import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qqwifi.QQWiFiHelper;
import cooperation.qqwifi.QQWiFiHelper.QQWIFIInstallListener;

public class yjh
  implements Runnable
{
  public yjh(QQWiFiHelper.QQWIFIInstallListener paramQQWIFIInstallListener)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    QQWiFiHelper.b(QQWiFiHelper.QQWIFIInstallListener.a(this.a), QQWiFiHelper.QQWIFIInstallListener.a(this.a).app);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yjh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */