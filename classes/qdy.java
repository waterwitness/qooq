import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.config.ConfigManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;

public class qdy
  implements Runnable
{
  public qdy(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = BaseApplication.getContext();
    String str = this.a.a();
    localObject = ConfigManager.getInstance((Context)localObject, this.a, this.a.a(), str);
    if (localObject != null) {
      ((ConfigManager)localObject).onProxyIpChanged(this.a);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qdy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */