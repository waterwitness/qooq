import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qqfav.ipc.QfavRemoteProxyForQQ;
import cooperation.qqfav.ipc.QfavRemoteProxyForQQ.QfavRemoteProxyCallWrapper;
import java.util.concurrent.ConcurrentLinkedQueue;

class ygs
  extends Thread
{
  ygs(ygr paramygr)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    while (!this.a.a.a.isEmpty())
    {
      QfavRemoteProxyForQQ.QfavRemoteProxyCallWrapper localQfavRemoteProxyCallWrapper = (QfavRemoteProxyForQQ.QfavRemoteProxyCallWrapper)this.a.a.a.poll();
      if (localQfavRemoteProxyCallWrapper != null) {
        QfavRemoteProxyForQQ.a(this.a.a, localQfavRemoteProxyCallWrapper);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ygs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */