package eipc;

import com.tencent.qphone.base.util.QLog;

class EIPCClient$ClientDeathRecipient$1
  implements EIPClientConnectListener
{
  EIPCClient$ClientDeathRecipient$1(EIPCClient.ClientDeathRecipient paramClientDeathRecipient) {}
  
  public void connectFailed()
  {
    QLog.d("EIPCConst", 2, "client binderDied connectFailed");
  }
  
  public void connectSuccess(EIPCConnection paramEIPCConnection)
  {
    QLog.d("EIPCConst", 2, "client binderDied connectSuccess");
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\eipc\EIPCClient$ClientDeathRecipient$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */