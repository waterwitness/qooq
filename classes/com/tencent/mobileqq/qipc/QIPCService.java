package com.tencent.mobileqq.qipc;

import eipc.EIPCServer;
import eipc.EIPCService;

public class QIPCService
  extends EIPCService
{
  static final int a = 1;
  
  public void onAccountChanged()
  {
    super.onAccountChanged();
    if (this.mServer != null) {
      this.mServer.sendMsgToRemoteModule(1, null);
    }
  }
  
  public EIPCServer onCreateSingleServer()
  {
    return QIPCServerHelper.getInstance().getServer();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\qipc\QIPCService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */