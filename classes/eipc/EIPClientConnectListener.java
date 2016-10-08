package eipc;

public abstract interface EIPClientConnectListener
{
  public abstract void connectFailed();
  
  public abstract void connectSuccess(EIPCConnection paramEIPCConnection);
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\eipc\EIPClientConnectListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */