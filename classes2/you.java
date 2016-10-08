import android.os.RemoteException;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.remote.IServiceHandler;
import cooperation.qzone.remote.RecvMsg;
import cooperation.qzone.remote.RemoteServiceProxy;
import cooperation.qzone.remote.SendMsg;

public class you
  implements Runnable
{
  public you(RemoteServiceProxy paramRemoteServiceProxy, SendMsg paramSendMsg)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      if (this.jdField_a_of_type_CooperationQzoneRemoteRemoteServiceProxy.serviceHandler != null)
      {
        this.jdField_a_of_type_CooperationQzoneRemoteRemoteServiceProxy.serviceHandler.sendMsg(this.jdField_a_of_type_CooperationQzoneRemoteSendMsg);
        return;
      }
      try
      {
        RecvMsg localRecvMsg = this.jdField_a_of_type_CooperationQzoneRemoteRemoteServiceProxy.createWaiteRespTimeout(this.jdField_a_of_type_CooperationQzoneRemoteSendMsg, "main thread sendMsgToServiceFailed. serviceHandler is null.");
        this.jdField_a_of_type_CooperationQzoneRemoteRemoteServiceProxy.sendFailedRespToApp(this.jdField_a_of_type_CooperationQzoneRemoteSendMsg, localRecvMsg);
        return;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        return;
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      localRemoteException.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\you.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */