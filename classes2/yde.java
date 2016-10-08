import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.huangye.HYConfigLoader.GetConfigListener;
import cooperation.huangye.ipc.HYRemoteManager;

public class yde
  implements HYConfigLoader.GetConfigListener
{
  public yde(HYRemoteManager paramHYRemoteManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramString == null) {}
    while ((HYRemoteManager.a(this.a) != null) && (HYRemoteManager.a(this.a).equals(paramString))) {
      return;
    }
    HYRemoteManager.a(this.a, paramString);
    this.a.b(paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yde.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */