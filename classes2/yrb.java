import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.RemoteRequestSender;

public final class yrb
  implements Runnable
{
  public yrb()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    RemoteHandleManager.a().a().h();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yrb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */