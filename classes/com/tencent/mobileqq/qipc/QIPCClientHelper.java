package com.tencent.mobileqq.qipc;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResultCallback;
import mqq.app.MobileQQ;

public class QIPCClientHelper
{
  public static final int QIPC_CLIENT_ID = 1;
  public static final String TAG = "QIPCClientHelper";
  static QIPCClientHelper a;
  EIPCClient b = null;
  
  public static QIPCClientHelper getInstance()
  {
    try
    {
      if (a == null) {
        a = new QIPCClientHelper();
      }
      QIPCClientHelper localQIPCClientHelper = a;
      return localQIPCClientHelper;
    }
    finally {}
  }
  
  public void callServer(String paramString1, String paramString2, Bundle paramBundle, EIPCResultCallback paramEIPCResultCallback)
  {
    getClient().callServer(paramString1, paramString2, paramBundle, paramEIPCResultCallback);
  }
  
  public void disconnect()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIPCClientHelper", 2, "disconnect, " + this.b);
    }
    if (this.b != null)
    {
      this.b.disConnect();
      this.b = null;
    }
  }
  
  public EIPCClient getClient()
  {
    try
    {
      if (this.b == null)
      {
        this.b = new EIPCClient(MobileQQ.sMobileQQ, QIPCService.class, 1);
        this.b.registerModule(new QIPCClientModuleCore());
      }
      EIPCClient localEIPCClient = this.b;
      return localEIPCClient;
    }
    finally {}
  }
  
  public void register(QIPCModule paramQIPCModule)
  {
    getClient().registerModule(paramQIPCModule);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\qipc\QIPCClientHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */