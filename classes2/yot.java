import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.remote.RecvMsg;
import cooperation.qzone.remote.RemoteServiceProxy;
import cooperation.qzone.remote.SendMsg;
import java.util.concurrent.ConcurrentLinkedQueue;

public class yot
  extends Thread
{
  public yot(RemoteServiceProxy paramRemoteServiceProxy)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    while (!this.a.sendMsgQueue.isEmpty())
    {
      SendMsg localSendMsg = (SendMsg)this.a.sendMsgQueue.poll();
      if (localSendMsg != null) {
        try
        {
          this.a.sendMsgToService(localSendMsg);
        }
        catch (Exception localException)
        {
          RecvMsg localRecvMsg = this.a.createWaiteRespTimeout(localSendMsg, "sendMsgToServiceFailed，" + localException.toString());
          this.a.sendFailedRespToApp(localSendMsg, localRecvMsg);
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */