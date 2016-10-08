import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import eipc.EIPCConnection;
import eipc.EIPCOnGetConnectionListener;

public class vcq
  implements EIPCOnGetConnectionListener
{
  public vcq(InnerDns paramInnerDns)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onConnectBind(EIPCConnection paramEIPCConnection)
  {
    if (paramEIPCConnection != null) {
      InnerDns.a(this.a, paramEIPCConnection.procName);
    }
    InnerDns.a(this.a, true);
  }
  
  public void onConnectUnbind(EIPCConnection paramEIPCConnection)
  {
    if (paramEIPCConnection != null) {
      InnerDns.a(this.a, paramEIPCConnection.procName);
    }
    InnerDns.a(this.a, false);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\vcq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */