import com.tencent.biz.common.offline.OfflineExpire.OfflineExpireCheckUpdate;
import com.tencent.biz.webviewplugin.OfflineWebResManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hhf
  implements Runnable
{
  public hhf(OfflineExpire.OfflineExpireCheckUpdate paramOfflineExpireCheckUpdate)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    new OfflineWebResManager(OfflineExpire.OfflineExpireCheckUpdate.a(this.a)).a();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hhf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */