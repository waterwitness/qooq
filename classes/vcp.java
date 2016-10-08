import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import eipc.EIPCConnection;
import eipc.EIPClientConnectListener;

public class vcp
  implements EIPClientConnectListener
{
  public vcp(InnerDns paramInnerDns)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void connectFailed()
  {
    InnerDns.a(this.a, false);
  }
  
  public void connectSuccess(EIPCConnection paramEIPCConnection)
  {
    if (paramEIPCConnection != null) {
      InnerDns.a(this.a, paramEIPCConnection.procName);
    }
    InnerDns.a(this.a, true);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\vcp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */